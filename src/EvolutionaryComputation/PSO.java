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
	int dim=5; //ά�Ȳ��������ñ����ĸ���
	// �����������ٺ���
	double c1=1.5;
	double c2=1.5;
	double w=0.3;
	double vmax=0.05;  //����������ٶ�
	/**
	 * @exception ��Ӧ������ͨ�����λ�ü��������Ӧֵ
	 */
	public void fitnessFunciton(){
		double y=2.0;
		double z=0;
		double e=0;
		double fitness;
		double condition_sum=0;
		double condition_mul=1.0;
		
		for(int i=0;i<n;i++){
			for(int j=0;j<dim;j++){
				y*=Math.cos(p[i].getPosD(j))*Math.cos(p[i].getPosD(j));
				z+=Math.pow(Math.cos(p[i].getPosD(j)),4.0);
				e+=Math.pow(p[i].getPosD(j),2);
				condition_sum+=p[i].getPosD(j);
				condition_mul*=p[i].getPosD(j);
			}
			e=Math.pow(e, 0.5);
			//�������Լ�������͸�����Ӧֵ���������κθı�
			if(condition_sum<=7.5*dim&&condition_mul>=0.75){
				p[i].setF(-Math.abs((z-y)/e));
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
		//λ�ò���
		double[] pos_p=new double[dim];
		double[] pos_v=new double[dim];
		for(int k=0;k<dim;k++){
			pos_p[k]=0.0;
		}
		//��ʼ������Ⱥ����λ��
		gBest=new Position(pos_p,dim);
		
		for(int i=0;i<n;i++){
			for(int j=0;j<dim;j++){
				pos_p[j]=Math.random()*10;
				pos_v[j]=Math.random()*vmax;
			}
			p[i]=new Position(pos_p,dim);
			v[i]=new Position(pos_v,dim);
		}
		fitnessFunciton();
		gBest.setF(Double.MAX_VALUE);
		for(int i=0;i<100;i++){
			pBest[i]=p[i];
			//����Сֵ��������С��ֵ�����ŵ�
			if(p[i].getF()<gBest.getF()){  
				gBest=p[i];
				gBest.setF(p[i].getF());
			}
		}
		System.out.println("start gBest:"+gBest);
	}
	//����Ⱥ�㷨 max Ϊ�������
	public void PSO_Method(int max){
		double[] v_s=new double[dim];
        for(int i=0;i<max;i++){
            for(int j=0;j<n;j++){
            	for(int k=0;k<dim;k++){
            		v_s[k]=w*v[j].getPosD(k)+c1*Math.random()*(pBest[j].getPosD(k)-p[j].getPosD(k))+c2*Math.random()*(gBest.getPosD(k)-p[j].getPosD(k));
            		if(v_s[k]>vmax){
            			v_s[k]=vmax;
            		}
            	}
                //����λ�ú��ٶ�
                v[j]=new Position(v_s,dim);
                for(int m=0;m<dim;m++){
                	//�ж�Խ��
                	double sum_tmp=p[j].getPosD(m)+v[j].getPosD(m);
                	if(sum_tmp>10){
                		sum_tmp=10;
                	}else if(sum_tmp<0){
                		sum_tmp=0;
                	}
                		
                	p[j].setPos(sum_tmp, m);
                }
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
            System.out.println("======"+(i+1)+"======gbest:"+gBest.toString());
            }
        }
}
