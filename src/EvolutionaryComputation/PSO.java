package EvolutionaryComputation;


/**
 *函数的极值用PSO来解，主要分成5步
 *1.初始化位置
 *2.计算每只鸟的适应度
 *3.找到每只鸟自己的极值，以及整个鸟群的极值
 *4.计算位置变化量，改变位置
 *5.重复2~4，一个较大的次数使他趋于稳定
 **/
public class PSO {
	
	int n=100; //粒子个数，太多或者太少都会有问题
	Position[] p; //鸟的位置和适应值存储类
	Position[] v; //鸟的位置变化量
	Position[] pBest;  //记录每只鸟的历史最佳位置
	Position   gBest;  //记录种群的最佳位置
	int dim=5; //维度参数，设置变量的个数
	// 设置两个加速函数
	double c1=1.5;
	double c2=1.5;
	double w=0.3;
	double vmax=0.05;  //最快增长的速度
	/**
	 * @exception 适应函数，通过鸟的位置计算鸟的适应值
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
			//如果符合约束条件就更新适应值，否则不做任何改变
			if(condition_sum<=7.5*dim&&condition_mul>=0.75){
				p[i].setF(-Math.abs((z-y)/e));
			}
		}
	}
	/**
	 * 种群初始化
	 * @param args
	 */
	public void init(){
		p=new Position[n];
		v=new Position[n];
		pBest=new Position[n];
		//位置参数
		double[] pos_p=new double[dim];
		double[] pos_v=new double[dim];
		for(int k=0;k<dim;k++){
			pos_p[k]=0.0;
		}
		//初始化粒子群最优位置
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
			//求最小值，所以最小的值是最优的
			if(p[i].getF()<gBest.getF()){  
				gBest=p[i];
				gBest.setF(p[i].getF());
			}
		}
		System.out.println("start gBest:"+gBest);
	}
	//粒子群算法 max 为计算次数
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
                //更新位置和速度
                v[j]=new Position(v_s,dim);
                for(int m=0;m<dim;m++){
                	//判断越界
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
            //更新个体极值和群体极值
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
