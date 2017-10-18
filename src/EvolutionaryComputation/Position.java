package EvolutionaryComputation;

/**
 *@author flzhang 
 *@exception 存储每只鸟的位置，及其适应值f
 *@param n位置的维度，f适应值
 */
	 public class Position{ 
		private double f;
		private double[] pos;
		//初始化参数
		public Position(double[] pos_s,int n) {
			this.pos= new double[n];
			for(int i=0;i<pos_s.length;i++){
				this.pos[i]=pos_s[i];
			}
		}
		public double getPosD(int i){
			return pos[i];
		}
		public double getF(){
			return this.f;
		}
		public  void setPos(double x_s,int i){
			this.pos[i]=x_s;
		}
		public void setF(double f_s){
			this.f=f_s;
		}
		public String toString(){
			return " f:"+this.f;
		}
	}