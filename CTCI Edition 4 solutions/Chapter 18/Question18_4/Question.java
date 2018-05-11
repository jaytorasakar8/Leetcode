package Question18_4;

public class Question {
	/* Resources */
	static Resource r[] = new Resource[4];
	/* Threads */
	static MyThread th1 = new MyThread("Thread 1");
	static MyThread th2 = new MyThread("Thread 2");

	public static boolean canAcquireResource(MyThread t, Resource r){
		MyThread ot = null;
		if (t.getName().equals("Thread 1")) {
			ot = th2;
		}
		else{
			ot = th1;
		}
		if(ot == null) return true;
		if(!ot.getRes().contains(r)) return true;
		if(t.getTime() < ot.getTime()){
			while(t.isAlive()){
				System.out.println("Thread: ["+ot.getName()+ "] is waiting..");
			}
			return true;
		}
		else{
			System.out.println("Thread exiting: [" + t.getName()+"]");
			t.stop();
		}
		return false;
	}

	public static void main(String args[]){
		/* Create the resources */
		r[0] = new Resource(0);
		r[1] = new Resource(1);
		r[2] = new Resource(2);
		r[3] = new Resource(3);
		/* Start the threads */
		th1.start();
		th2.start();
	}
}
