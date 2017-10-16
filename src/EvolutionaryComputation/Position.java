package EvolutionaryComputation;

/**
 * 
 *@author flzhang 
 *@exception 存储每只鸟的位置，及其适应值f
 *@param x,y 位置，f适应值
 */
	 public class Position{ 
		private double x;
		private double y;
		private double f;
		public Position(double x_,double y_) {
			this.x=x_;
			this.y=y_;
		}
		public double getX(){
			return this.x;
		}
		public double getY(){
			return this.y;
		}
		public double getF(){
			return this.f;
		}
		public  void setX(double x_s){
			this.x=x_s;
		}
		public void setY(double y_s){
			this.y=y_s;
		}
		public void setF(double f_s){
			this.f=f_s;
		}
		public String toString(){
			return "x:"+x+" y:"+y+" f:"+f;
		}
	}