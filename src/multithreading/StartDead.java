package multithreading;

public class StartDead extends Thread {
	// isAlive()���� �ڴ���������״̬��Ϊfalse�����������С�����״̬�¶�Ϊtrue
	 private int i;
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
		StartDead startDead=new StartDead();
		for(int i=0;i<300;i++) {
			System.out.println(Thread.currentThread().getName()+"��"+i);
			if(i==20) {
				startDead.start(); //�����̣߳��������״̬
				System.out.println(startDead.isAlive());
			}
			if(i>20&&!startDead.isAlive()) {
				//����һ�������Ľ��̵���start()��������� IllegalThreadStateException �쳣
				startDead.start();
			}
		}
	}

}
