package EvolutionaryComputation;

/**
 *@author flzhang 
 *@exception �洢ÿֻ���λ�ã�������Ӧֵf
 *@param nλ�õ�ά�ȣ�f��Ӧֵ
 */
	 public class Position{ 
		private double f;
		private double[] pos;
		//��ʼ������
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