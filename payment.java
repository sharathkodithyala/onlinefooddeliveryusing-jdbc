package xyz;

public class payment extends user {
	payment(){
		System.out.println("You have entered the payment section.");	
	}
	public void paymentMethod(){
		System.out.print("\nSelect the type of payment (1. Gpay, 2. Phonepay, 3. Paytm 4.Cash): ");
		int seloption=scanner.nextInt();
		switch(seloption) {
		case 1:{
			gpay();
		}break;
		case 2:{
			phonepe();
			
		}
		break;
		case 3:{
			paytm();
		}break;
		case 4:{
			System.out.println("thanks for visiting");
		}
		}
		
	}

	public void gpay() {
		System.out.println();
	}

	public void phonepe() {
		System.out.println("enter your custamername:");
		String custname=scanner.next();
		System.out.println("enter your phone");
		int custnum=scanner.nextInt();
		System.out.println("enter your upiid");
		String upiid=scanner.next();
		int res=otp();
		System.out.println("enter the otp");
		int otpenter=scanner.nextInt();
		if(res==otpenter)
		{
			System.out.println("payment was succussfull");
		}
		System.out.println("");
	}
	public void paytm() {
		System.out.println();
		}
	public int  otp(){
		int oott=(int)(Math.random()*10000);
		System.out.println(oott);
		System.out.println("");
		return oott;
		
	}
	
}
