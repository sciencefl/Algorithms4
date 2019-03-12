package multithreading;

public class SecondThread implements Runnable {
	/**
	 * 实现Runnable接口创建线程类
	 * 1.定义Runable接口的实现类，并重写该接口的run()方法，改run()方法同样是该线程的线程执行体
	 * 2.实例化Runnable实现类的实例，并以此实例作为Thread类的构造函数参数（target）来创建Thread对象
	 * 该Thread对象才是真正的线程对象
	 */
	private int i;
	public void run() {
		for(;i<100;i++) {
			//当用Runnable接口实现线程的时候
			//如果想获取当前线程对象，只能用Thread.currentThread()方法
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建Thread子类的实例，即创建了线程
		for(int i=0;i<100;i++) {
			//调用Thread类的currentThread()方法，获取当前进程
			System.out.println(Thread.currentThread().getName()+" " +i);
			if(i==20) {
				
				SecondThread secondThread =new SecondThread();
				new Thread(secondThread,"线程1").start();
				new Thread(secondThread,"线程2").start();
			}
		}
	}

}
