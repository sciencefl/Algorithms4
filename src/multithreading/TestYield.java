package multithreading;

public class TestYield extends Thread {
	/**
	 * sleep ��yield��������Thread���ṩ�ľ�̬�������������õ�ǰ����ִ�е��߳���ͣ�����������߳��������������߳̽������״̬
	 * ��ĳ���̵߳���yield����֮��ֻ�����ȼ����ڻ��߸��ڵ�ǰ�̵߳��̣߳��Żᱻִ��
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
				//��i=20ʱ��ʹ��yield�����õ�ǰ�����ò�
				Thread.yield();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestYield testYield=new TestYield("�߼�");
		testYield.start();
		testYield.setPriority(MAX_PRIORITY);
		TestYield testYield2=new TestYield("�ͼ�");
		testYield2.start();
		testYield2.setPriority(MIN_PRIORITY);
	}

}
