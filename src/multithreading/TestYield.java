package multithreading;

public class TestYield extends Thread {
	/**
	 * sleep 和yield方法都是Thread类提供的静态方法，他可以让当前正在执行的线程暂停，但不是让线程阻塞，而是让线程进入就绪状态
	 * 当某个线程调用yield方法之后，只有优先级等于或者高于当前线程的线程，才会被执行
	 * @param args
	 */
	public TestYield() {
		
	}
	public TestYield(String s) {
		super(s);
	}
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println(getName()+" "+i);
			if(i==20) {
				//当i=20时，使用yield方法让当前进程让步
				Thread.yield();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestYield testYield=new TestYield("高级");
		testYield.start();
		testYield.setPriority(MAX_PRIORITY);
		TestYield testYield2=new TestYield("低级");
		testYield2.start();
		testYield2.setPriority(MIN_PRIORITY);
	}

}
