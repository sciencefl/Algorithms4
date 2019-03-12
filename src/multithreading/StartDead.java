package multithreading;

public class StartDead extends Thread {
	// isAlive()函数 在创建和死亡状态下为false，就绪、运行、阻塞状态下都为true
	 private int i;
	@Override
	public void run() {
		//当线程类继承Thread类时，可以直接调用getName()方法来返回当前进程名
		//要获取当前进程，可以用this关键字
		// Thread类的getName()方法直接返回当前线程的名字
		for(;i<100;i++) {
			System.out.println(getName()+" "+i);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StartDead startDead=new StartDead();
		for(int i=0;i<300;i++) {
			System.out.println(Thread.currentThread().getName()+"　"+i);
			if(i==20) {
				startDead.start(); //启动线程，进入就绪状态
				System.out.println(startDead.isAlive());
			}
			if(i>20&&!startDead.isAlive()) {
				//对于一个死亡的进程调用start()方法会产生 IllegalThreadStateException 异常
				startDead.start();
			}
		}
	}

}
