package hw2;
import java.util.*;
import java.util.PriorityQueue;

public class Simulator {
	
	public static PriorityQueue<Event> EQueue = new PriorityQueue<Event>();
	public static Queue<Request> listR = new LinkedList<Request>();
	public static double busytime = 0.0;
	public static double nofcompReq = 0.0;
	public static double nofMonEvents = 0.0;
	public static double totalReqtime = 0.0;
	public static double Queuelen = 0.0;
	public static int pos = -1;
	static double lambda;
	static double ts;
	
	public static void main(String[] args) {
		
        double t = Double.parseDouble(args[0]);
        lambda = Double.parseDouble(args[1]);
        ts = Double.parseDouble(args[2]);
    	simulate(t);

	}
	
	public static void simulate(double time) {
		double t = 0;
		double cap = time;
		EQueue.add(new Event(0.0, 1));
		EQueue.add(new Event(0.0, 2));
		
		while(t < cap) {
	
			Event e = EQueue.remove();
			t = e.time;
			e.function(t);
		}
		
		System.out.println("UTIL: " + ( busytime / time));
		System.out.println("QLEN: " + ( Queuelen / nofMonEvents));
		System.out.println("TRESP: " + (totalReqtime / nofcompReq));
		
	}

}
