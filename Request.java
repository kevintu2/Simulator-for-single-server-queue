package hw2;
public class Request {

	public double arrivaltime;
	public double starttime;
	public double deathtime;
	private int ID;
	
	public Request(int x) {
		ID = x;
	}
	
	public int getID() {
		return ID;
	}
	
	public double getTQ() {
		return deathtime - arrivaltime;
	}
	
	public double getTS() {
		return deathtime - starttime;
	}
}
