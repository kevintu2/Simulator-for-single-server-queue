package hw2;
public class Event implements Comparable<Event> {
	
	public int type;
	public double time;
	
	public Event(double t, int s) {
		time = t;
		type = s;
	}
	
	public static double getTimeBirth() {
		return Exp.getExp(Simulator.lambda);
	}
	
	public static double getTimeMon() {
		return Exp.getExp(Simulator.lambda);
	}
	
	public static double getTimeDeath() {
		return Exp.getExp(1.0/Simulator.ts);
	}

	
    public int compareTo(Event e) {
    	double variation = time - e.time;
    	if (variation > 0) {
	    	return 1;
		} 
    	
    	else if (variation < 0) {
		    return -1;
		}
    	
    	else {
		    return 0;
		}
    }
	
	public void function(double t) {
		//Death event
		if(type == 0) {	
			Request r = Simulator.listR.remove();
			r.deathtime = t;
			Simulator.totalReqtime += r.getTQ();
			Simulator.busytime += r.getTS();
			Simulator.nofcompReq ++;
			
			System.out.println("R" + r.getID() + " DONE: " + r.deathtime);
			
			if(Simulator.listR.size() > 0) {
				Request nextr = Simulator.listR.peek();
				nextr.starttime = t;
				
				System.out.println("R" + nextr.getID() + " START: " + nextr.starttime);
				
				Event nextd = new Event(t + getTimeDeath(), 0);
				Simulator.EQueue.add(nextd);
			}

		}
		//Birth Event
		else if(type == 1) {
			Request r1 = new Request(Simulator.pos + 1);
			Simulator.pos++;
			r1.arrivaltime = t;
			Simulator.listR.add(r1);
			
			System.out.println("R" + r1.getID() + " ARR: " + r1.arrivaltime);
			
			if(Simulator.listR.size() == 1){
				r1.starttime = t;
				Event e = new Event(t + getTimeDeath(), 0);
				Simulator.EQueue.add(e);
				System.out.println("R" + r1.getID() + " START: " + t);
			}
			
			Event nextb = new Event(t + getTimeBirth(), 1);
			Simulator.EQueue.add(nextb);
		}
		//Monitor Event
		else if(type == 2) {
			Simulator.Queuelen += Simulator.listR.size();
			Simulator.nofMonEvents ++;
		    Event nextm = new Event(t + getTimeMon(), 2);
		    Simulator.EQueue.add(nextm);
		}
		
	}
	
	
	
}
