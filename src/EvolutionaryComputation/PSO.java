package EvolutionaryComputation;


/**
 *�����ļ�ֵ��PSO���⣬��Ҫ�ֳ�5��
 *1.��ʼ��λ��
 *2.����ÿֻ�����Ӧ��
 *3.�ҵ�ÿֻ���Լ��ļ�ֵ���Լ�������Ⱥ�ļ�ֵ
 *4.����λ�ñ仯�����ı�λ��
 *5.�ظ�2~4��һ���ϴ�Ĵ���ʹ�������ȶ�
 **/
public class PSO {
	
	int n=100; //���Ӹ�����̫�����̫�ٶ���������
	Position[] p; //���λ�ú���Ӧֵ�洢��
	Position[] v; //���λ�ñ仯��
	Position[] pBest;  //��¼ÿֻ�����ʷ���λ��
	Position   gBest;  //��¼��Ⱥ�����λ��
	// �����������ٺ���
	double c1=3;
	double c2=1;
	double w=0.3;
	double vmax=0.05;
	/**
	 * @exception ��Ӧ������ͨ�����λ�ü��������Ӧֵ
	 */
	public void fitnessFunciton(){
		for(int i=0;i<n;i++){
			double x=p[i].getX();
			double y=p[i].getY();
			if(x<30&&y<30){
				p[i].setF(30*x-y);
			}else if(x<30&&y>=30){
				p[i].setF(30*y-x);
			}else if(x>=30&&y<30){
				p[i].setF(x*x-y/2);
			}else if(x>=30&&y>=30){
				p[i].setF(20*y*y-500*x);
			}
		}
	}
	/**
	 * ��Ⱥ��ʼ��
	 * @param args
	 */
	public void init(){
		p=new Position[n];
		v=new Position[n];
		pBest=new Position[n];
		gBest=new Position(0.0,0.0);
		for(int i=0;i<n;i++){
			p[i]=new Position(Math.random()*60, Math.random()*60);
			v[i]=new Position(Math.random()*vmax, Math.random()*vmax);
		}
		fitnessFunciton();
		gBest.setF(Integer.MIN_VALUE);
		for(int i=0;i<100;i++){
			pBest[i]=p[i];
			if(p[i].getF()>gBest.getF()){
				gBest=p[i];
				gBest.setF(p[i].getF());
			}
		}
		System.out.println("start gBest:"+gBest);
	}
	//����Ⱥ�㷨 max Ϊ�������
	public void PSO_Method(int max){
        for(int i=0;i<max;i++){
            for(int j=0;j<n;j++){
                //����λ�ú��ٶ�
                double vx=w*v[j].getX()+c1*Math.random()*(pBest[j].getX()-p[j].getX())+c2*Math.random()*(gBest.getX()-p[j].getX());
                double vy=w*v[j].getY()+c1*Math.random()*(pBest[j].getY()-p[j].getY())+c2*Math.random()*(gBest.getY()-p[j].getY());
                if (vx>vmax) vx=vmax;
                if (vy>vmax) vy=vmax;
//                System.out.println("======"+(i+1)+"======vx:"+vx);
                v[j]=new Position(vx,vy);
//                System.out.println("======"+(i+1)+"======v[j]:"+v[j]);
                p[j].setX(p[j].getX()+v[j].getX());
                p[j].setY(p[j].getY()+v[j].getY());
                //Խ���ж�
                if(p[j].getX()>=60) p[j].setX(59.99);
                if(p[j].getX()<=0) p[j].setX(0.01);
                if(p[j].getY()>=60) p[j].setY(59.99);
                if(p[j].getY()<=0) p[j].setY(0.01);
            }
            fitnessFunciton();
            //���¸��弫ֵ��Ⱥ�弫ֵ
            for (int j=0;j<n;j++){
                if (pBest[j].getF()<p[j].getF()){
                    pBest[j]=p[j];
                }
                if(p[j].getF()>gBest.getF()){
                    gBest=p[j];
                    gBest.setF(p[j].getF());
                }
            }
            System.out.println("======"+(i+1)+"======gbest:"+gBest.toString());}
        }
}
