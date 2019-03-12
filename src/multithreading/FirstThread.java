package multithreading;

public class FirstThread extends Thread {
	/*
	 * 1.����Thread������࣬����дthread���run()��������run()�����ķ�������Ǵ������߳�Ҫִ�е�������˾���
	 * ��run���������߳�ִ����
	 * 2.����Thread�����ʵ�������������̡߳�
	 * 3.���̶߳����start()������ִ���̡߳�
	 * ע�⣺ʹ�ü̳�Thread���������߳��࣬�����߳�֮���޷������߳����ʵ��������
	 */
	private int i;
	//��дrun������run���������߳�ִ����
	@Override
	public void run() {
		//���߳���̳�Thread��ʱ������ֱ�ӵ���getName()���������ص�ǰ������
		//Ҫ��ȡ��ǰ���̣�������this�ؼ���
		// Thread���getName()����ֱ�ӷ��ص�ǰ�̵߳�����
		for(;i<100;i++) {
			System.out.println(getName()+" "+i);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����Thread�����ʵ�������������߳�
		for(int i=0;i<100;i++) {
			//����Thread���currentThread()��������ȡ��ǰ����
			System.out.println(Thread.currentThread().getName()+" " +i);
			if(i==20) {
				new FirstThread().start();
				new FirstThread().start();
			}
		}
	}

}
