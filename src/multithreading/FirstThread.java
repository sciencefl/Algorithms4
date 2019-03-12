package multithreading;

public class FirstThread extends Thread {
	/*
	 * 1.定义Thread类的子类，并重写thread类的run()方法，该run()方法的方法体就是代表了线程要执行的任务，因此经常
	 * 把run方法叫做线程执行体
	 * 2.创建Thread子类的实例，即创建了线程。
	 * 3.用线程对象的start()方法来执行线程。
	 * 注意：使用继承Thread方法创建线程类，多条线程之间无法共享线程类的实例变量。
	 */
	private int i;
	//重写run方法，run方法就是线程执行体
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
		//创建Thread子类的实例，即创建了线程
		for(int i=0;i<100;i++) {
			//调用Thread类的currentThread()方法，获取当前进程
			System.out.println(Thread.currentThread().getName()+" " +i);
			if(i==20) {
				new FirstThread().start();
				new FirstThread().start();
			}
		}
	}

}
