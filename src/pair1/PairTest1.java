package pair1;

import javax.print.DocFlavor.STRING;

public class PairTest1{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//String[] words= {"adc","def","ghi","xyz"};
		//Pair<String> mmPair=Arrayalg.minmax(words);
		//System.out.println(" The first is :"+mmPair.getFirst());
		//System.out.println(" The second is :"+mmPair.getSecond());
		father F1=new father();
		father F2=new son();
		test(F1);
		test(F2);
	}
	public  static <T> void test(T t) {
		Class classT=t.getClass();  //��ȡһ��ʵ��������ʱ����
		Class classTarget =son.class;  //��ȡһ���������
		System.out.println("T.className =====>>"+classT.getSimpleName());
	}

}
//�ڲ���Ļ���
class Arrayalg{
	/**
	 * ��ȡһ���ַ�������С������
	 * ��T����Ϊʵ����Comparable�ӿڵ���  <T extends Comparable<T>>
	 */
	public  static<T extends Comparable<T>> Pair<T> minmax(T[] a){ 
		if(a==null||a.length==0) return null;
		T min=a[0];
		T max=a[0];
		for(int i=1;i<a.length;i++) {
			if(min.compareTo(a[i])>0) min=a[i];
			if(max.compareTo(a[i])<0) max=a[i];
		}
		return new Pair<T>(min,max);
	}
}
class father{}
class son extends father{}
