package railwayreservation;

import java.io.DataInputStream;
import java.io.IOException;

public class prog {

	public static void main(String[] args)throws IOException {
		float p;
		float r;
		int t;
		try{
		DataInputStream d=new DataInputStream(System.in);
		p=Float.parseFloat(d.readLine());
		r=Float.parseFloat(d.readLine());
		t=Integer.parseInt(d.readLine());
		
		
		
		
		double t2=(double)(t);
		double amount=0.00;
		double rate=(1+(r/100));
		
		double t1=t2/12;
		
		double value=0.0;
		 value= Math.pow(rate,t1);
		
		double number=p*value;
		amount=number*t2;
		System.out.println(amount);
		double amt=Math.floor(amount);
	
		
		System.out.println("Final_Amount"+amt);
		

	}
		catch(NumberFormatException e){
			System.out.println("Invalid");
		}

}
}
