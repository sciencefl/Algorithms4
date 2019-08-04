package algo;

public class MyCircularDeque {
    /** Initialize your data structure here. Set the size of the deque to be k. */
	int size;
	int head;
	int tail;
	int[] circularDeque;
    public MyCircularDeque(int k) {
        this.size=0;
        this.head=0;
        this.tail=0;
        circularDeque=new int[k];
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull()) {
        	return false;
        }else {
        	if(size==0) {
        		circularDeque[head]=value;
        		this.size++;
        		return true;
        	}
        	head--;
        	if(head<0) {
        		head=head+circularDeque.length;
        	}
        	circularDeque[head]=value;
        	this.size++;
        	return true;
        }
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
    	if(!isFull()) {
    		if(size==0) {
    			circularDeque[tail]=value;
    			this.size++;
    			return true;
    		}
    		tail++;
    		if(tail>circularDeque.length-1) {
    			tail=tail-circularDeque.length;
    		}
    		circularDeque[tail]=value;
    		this.size++;
    		return true;
        }else {
			return false;
		}
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty()) {
        	return false;
        }else {
        	if(head==tail) {
        		size=0;
        		return true;
        	}
        	head++;
        	if(head>circularDeque.length-1) {
        		head=head-circularDeque.length;
        	}
        	this.size--;
        	return true;
        }
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty()) {
        	return false;
        }else {
        	if(head==tail) {
        		size=0;
        		return true;
        	}
        	tail--;
        	if(tail<0) {
        		tail=tail+circularDeque.length;
        	}
        	this.size--;
        	return true;
        }
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        return circularDeque[head];
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        return circularDeque[tail];
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size==0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size==circularDeque.length;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyCircularDeque circularDeque=new MyCircularDeque(3);// 设置容量大小为3
//		System.out.println(circularDeque.insertLast(1));			    // 返回 true
//		System.out.println(circularDeque.insertLast(2));				// 返回 true
		System.out.println(circularDeque.insertFront(3));
		System.out.println(circularDeque.deleteLast());	
		System.out.println(circularDeque.getFront());// 返回 true	
		System.out.println(circularDeque.insertLast(3));
		System.out.println(circularDeque.insertFront(3));//
		System.out.println(circularDeque.getFront());//已经满了，返回 false      
		System.out.println(circularDeque.getRear());  				// 返回 2
		System.out.println(circularDeque.isFull());				        // 返回 true
		System.out.println(circularDeque.deleteLast());			        // 返回 true
		System.out.println(circularDeque.insertFront(4));		        // 返回 true
		System.out.println(circularDeque.getFront());			// 返回 4

	}

}
