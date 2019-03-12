package multithreading;

public class SecondThread implements Runnable {
	/**
	 * ʵ��Runnable�ӿڴ����߳���
	 * 1.����Runable�ӿڵ�ʵ���࣬����д�ýӿڵ�run()��������run()����ͬ���Ǹ��̵߳��߳�ִ����
	 * 2.ʵ����Runnableʵ�����ʵ�������Դ�ʵ����ΪThread��Ĺ��캯��������target��������Thread����
	 * ��Thread��������������̶߳���
	 */
	private int i;
	public void run() {
		for(;i<100;i++) {
			//����Runnable�ӿ�ʵ���̵߳�ʱ��
			//������ȡ��ǰ�̶߳���ֻ����Thread.currentThread()����
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����Thread�����ʵ�������������߳�
		for(int i=0;i<100;i++) {
			//����Thread���currentThread()��������ȡ��ǰ����
			System.out.println(Thread.currentThread().getName()+" " +i);
			if(i==20) {
				
				SecondThread secondThread =new SecondThread();
				new Thread(secondThread,"�߳�1").start();
				new Thread(secondThread,"�߳�2").start();
			}
		}
	}

}
