package hw2;
public class Exp {

	public static double getExp(double lambda) {
		
		return -(Math.log(1 - Math.random())) / lambda;
	}
	
	public static void main(String [] args) {
		for(int i = 0; i<Integer.parseInt(args[1]);i++) {
			System.out.println(getExp((Double.parseDouble(args[0]))));
		}
	}
}

