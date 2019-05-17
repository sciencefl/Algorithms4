package javaNIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * NIO中 selector的使用
 * 
 * Selector 的基本使用流程
 * 1.通过 Selector.open() 打开一个 Selector.
 * 2.将 Channel 注册到 Selector 中, 并设置需要监听的事件(interest set)
 * 3.不断重复:
 * 		调用 select() 方法
 * 		调用 selector.selectedKeys() 获取 selected keys
 * 		迭代每个 selected key:
 *		从 selected key 中获取 对应的 Channel 和附加信息(如果有的话),判断是哪些 IO 事件已经就绪了, 然后处理它们. 如果是 OP_ACCEPT 事件, 
 *则调用 "SocketChannel clientChannel = ((ServerSocketChannel) key.channel()).accept()" 获取 SocketChannel, 并将它设置为 非阻塞的, 
 *然后将这个 Channel 注册到 Selector 中.
 *		根据需要更改 selected key 的监听事件.
 *		将已经处理过的 key 从 selected keys 集合中删除.
 *
 *
 */
public class NioEchoServer {
	private static final int BUF_SIZE=256;
	private static final int TIMEOUT=3000;
	public static void main(String[] args)  throws IOException{
		// TODO Auto-generated method stub
		//打开服务器端Socket 
		ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
		// 打开 selector
		Selector selector=Selector.open();
		// 服务器端 socket 监听 8080端口，并配置为非阻塞模式
		serverSocketChannel.socket().bind(new InetSocketAddress(80));
		serverSocketChannel.configureBlocking(false);
		// 将channel注册到 selector中,通常都是先注册一个op_accapt 事件，然后等这事件到来的时候，再注册 op_read事件。
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
		while(true) {
			//通过select方法，阻塞的等待  channel IO 可操作 .select方法获取的 结果放在 selectedKey中
			if(selector.select(TIMEOUT)==0){
				System.out.print(".");
				continue;
			}
			//已经获取 和 SelectionKey相关 的事件
			Iterator<SelectionKey> keyIterator=selector.selectedKeys().iterator();
			while(keyIterator.hasNext()) {
				SelectionKey selectionKey=keyIterator.next();
				//当获取到一个 selectionKey后，就删掉他，表示我们已经对他进行了处理
				keyIterator.remove();
				if(selectionKey.isAcceptable()) {
					// 当 OP_ACCEPT 事件到来时, 我们就有从 ServerSocketChannel 中获取一个 SocketChannel,
                    // 代表客户端的连接
                    // 注意, 在 OP_ACCEPT 事件中, 从 key.channel() 返回的 Channel 是 ServerSocketChannel.
                    // 而在 OP_WRITE 和 OP_READ 中, 从 key.channel() 返回的是 SocketChannel.
					SocketChannel clientChannel=((ServerSocketChannel)selectionKey.channel()).accept();
					clientChannel.configureBlocking(false);
					 //在 OP_ACCEPT 到来时, 再将这个 Channel 的 OP_READ 注册到 Selector 中.
                    // 注意, 这里我们如果没有设置 OP_READ 的话, 即 interest set 仍然是 OP_CONNECT 的话, 那么 select 方法会一直直接返回.
					clientChannel.register(selectionKey.selector(),SelectionKey.OP_READ,ByteBuffer.allocate(BUF_SIZE));
				}
	            if (selectionKey.isReadable()) {
                    SocketChannel clientChannel = (SocketChannel) selectionKey.channel();
                    ByteBuffer buf = (ByteBuffer) selectionKey.attachment();
                    long bytesRead = clientChannel.read(buf);
                    if (bytesRead == -1) {
                        clientChannel.close();
                    } else if (bytesRead > 0) {
                    	selectionKey.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                        System.out.println("Get data length: " + bytesRead);
                    }
                }

                if (selectionKey.isValid() && selectionKey.isWritable()) {
                    ByteBuffer buf = (ByteBuffer) selectionKey.attachment();
                    buf.flip();
                    SocketChannel clientChannel = (SocketChannel) selectionKey.channel();

                    clientChannel.write(buf);

                    if (!buf.hasRemaining()) {
                    	selectionKey.interestOps(SelectionKey.OP_READ);
                    }
                    buf.compact();
                }
			}
		}
		

	}

}
