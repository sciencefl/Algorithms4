package Foundamentals;

import java.util.Scanner;

public class Sort {
	public static boolean lessEqual(Comparable v,Comparable w){
		return v.compareTo(w)<=0;
	}
	public static void exch(Comparable[] a,int i, int j){
		Comparable temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	public static void show(Comparable[] a){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	public static boolean isSorted(Comparable[] a){
		for(int i=1;i<a.length;i++){
			if(!lessEqual(a[i-1],a[i])){
				return false;
			}
		}
		return true;
	}
	public static void selectionSort(Comparable[] a){
		for(int i=0;i<a.length;i++){
			int min=i;
			int k=0;
			for(int j=i;j<a.length;j++){
				if(lessEqual(a[j],a[min])){
					min=j; 
				}

			}
			exch(a,i,min);
		}
	}
	public static void insertionSort(Comparable[] a){
		for(int i=1;i<a.length;i++){
			for(int j=i;j>0&&lessEqual(a[j],a[j-1]);j--){
				exch(a,j,j-1);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int N=in.nextInt();
		Comparable[] a = new Comparable[N];
		for(int i=0;i<N;i++){
			a[i]=in.nextInt();
		}
		show(a);
//		selectionSort(a);
		insertionSort(a);
		show(a);
		System.out.print("result="+isSorted(a));
	}

}
