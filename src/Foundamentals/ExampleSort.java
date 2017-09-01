package Foundamentals;

public class ExampleSort {
/**
 * 排序算法的模板
 * @param args
 */
	/**
	 * 判断v是否小于w
	 * @return 
	 */
	public static boolean less(Comparable v,Comparable w){
		return  v.compareTo(v)<0;
	}
	public static void exch(Comparable[] a,int i,int j){
		Comparable temp;
		temp=a[i]; a[i]=a[j]; a[j]=temp;
	}
	public static void show(Comparable[] a){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	public static boolean isSorted(Comparable[] a){
		for(int i=0;i<a.length;i++){
			if(ExampleSort.less(a[i+1], a[i]))
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
