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
	// 设置两个加速函数
	double c1=3;
	double c2=1;
	double w=0.3;
	double vmax=0.05;
	/**
	 * @exception 适应函数，通过鸟的位置计算鸟的适应值
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
	 * 种群初始化
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
	//粒子群算法 max 为计算次数
	public void PSO_Method(int max){
        for(int i=0;i<max;i++){
            for(int j=0;j<n;j++){
                //更新位置和速度
                double vx=w*v[j].getX()+c1*Math.random()*(pBest[j].getX()-p[j].getX())+c2*Math.random()*(gBest.getX()-p[j].getX());
                double vy=w*v[j].getY()+c1*Math.random()*(pBest[j].getY()-p[j].getY())+c2*Math.random()*(gBest.getY()-p[j].getY());
                if (vx>vmax) vx=vmax;
                if (vy>vmax) vy=vmax;
//                System.out.println("======"+(i+1)+"======vx:"+vx);
                v[j]=new Position(vx,vy);
//                System.out.println("======"+(i+1)+"======v[j]:"+v[j]);
                p[j].setX(p[j].getX()+v[j].getX());
                p[j].setY(p[j].getY()+v[j].getY());
                //越界判断
                if(p[j].getX()>=60) p[j].setX(59.99);
                if(p[j].getX()<=0) p[j].setX(0.01);
                if(p[j].getY()>=60) p[j].setY(59.99);
                if(p[j].getY()<=0) p[j].setY(0.01);
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
            System.out.println("======"+(i+1)+"======gbest:"+gBest.toString());}
        }
}
