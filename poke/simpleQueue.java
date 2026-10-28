package poke;

public class simpleQueue {
	BattleAction[] data;
    int front;
    int rear;
    int count;

	simpleQueue(int size){
	    data = new BattleAction[size];
	    front = 0;
	    rear = 0;
	    count=0;
	}
	
	boolean isEmpty() {
	    return count == 0;
	}

	boolean isFull() {
		return count==this.data.length;
	}
	
	void enqueue(BattleAction value) {
	    if (isFull()) {
	        System.out.println("Queue is full!");
	        return;
	    }

	    data[rear] = value;
	    rear=(rear+1)%data.length;
	    count++;
	}
	
	BattleAction peek() {
	    if (isEmpty()) {
	        return null;
	    }
	    return data[front];
	}

	
	BattleAction dequeue() {
	    if (isEmpty()) {
	        return null;
	    }

	    BattleAction value = data[front];
	    front=(front+1)%data.length;
	    count--;
	    return value;
	}

	/*
	void showqueue() {
		for (int i=front;i<rear;i++) {
			System.out.print(""+data[i]+" ");
		}
		System.out.println();
	}
*/
}
