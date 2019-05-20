package algo;
/**
 * n 皇后问题的求解
 * @author flzhang
 *
 */
public class Nqueen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Nqueen nqueen=new Nqueen(8);
		nqueen.calNqueen(0);
	}
	//存储皇后的解
	int[] result;
	int nqueen=0;
	public Nqueen(int count) {
		this.nqueen=count;
		result=new int[nqueen];
	}
	/**
	 * 检验第n行的皇后
	 * @param n
	 */
	public void calNqueen(int row) {
		//当row=nuqueen时，表示最后一行已经搜索完，则输出并退出
		if(row==nqueen) {
			print(result);
			System.out.println("----------------------------------");
			return;
		}
		//每一行都要进行搜索
		for(int column=0;column<nqueen;column++) {
			if(isOk(row,column)) {
				result[row]=column;
			//	System.out.println(result[row]);
				calNqueen(row+1);
				
			}
		}
	}
	public boolean isOk(int row,int column) {
		int leftColumn=column-1;
		int rightCloumn=column+1;
		for(int upRow=row-1;upRow>=0;upRow--) {
			if(result[upRow]==column) {
				return false;
			}
			if(leftColumn>=0&&result[upRow]==leftColumn) {
				return false;
			}
			if(rightCloumn<nqueen&&result[upRow]==rightCloumn) {
				return false;
			}
			leftColumn--;
			rightCloumn++;
		}
		return true;
	}
	private void print(int[] result) {
		for(int row=0;row<nqueen;row++) {
			for(int column=0;column<nqueen;column++) {
				if(result[row]==column) {
					System.out.print("Q ");
				}else {
					System.out.print(". ");
				}
			}
			System.out.println();
		}
	}
	

}
