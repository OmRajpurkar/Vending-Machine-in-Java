import java.io.*;
import java.lang.Math;

public class VendingMachine 
{
	static int option1_price=10;
	static int option2_price=20;
	static int option3_price=25;
	static int option4_price=52;
	static int note1=10;
	static int note2=20;
	static int ch;
	
	public static void main(String[] args) throws Exception
	{
		do
		{
		System.out.println("\n1. Lays - Rs. 10");
		System.out.println("2. Jim Jam Biscuits - Rs. 20");
		System.out.println("3. Coke - Rs. 25");
		System.out.println("4. Dairy Milk Silk - Rs. 52");
		System.out.println("5. Exit");
		System.out.println("Select your choice");
		BufferedReader bin=new BufferedReader(new InputStreamReader(System.in));
		ch=Integer.parseInt(bin.readLine());
		
		switch(ch)
		{
		case 1:
			System.out.println("Enter Money: ");
			int moneyEntered=Integer.parseInt(bin.readLine());
			optimalSol(option1_price,moneyEntered);
			break;
		case 2:
			System.out.println("Enter Money: ");
			moneyEntered=Integer.parseInt(bin.readLine());
			optimalSol(option2_price,moneyEntered);
			break;
		case 3:
			System.out.println("Enter Money: ");
			moneyEntered=Integer.parseInt(bin.readLine());
			optimalSol(option3_price,moneyEntered);
			break;
		case 4:
			System.out.println("Enter Money: ");
			moneyEntered=Integer.parseInt(bin.readLine());
			optimalSol(option4_price,moneyEntered);
			break;
		case 5:
			return;
		default:
			System.out.println("Wrong Choice");
		}
		}while(ch!=5);
	}

	private static void optimalSol(int price, int moneyEntered) 
	{
		int moneyToGive = moneyEntered;
			if(moneyEntered > price)
			{
				moneyToGive=moneyEntered-price;
			}
			else if(moneyEntered<10)
			{
				System.out.println("You have entered less money.");
				return;
			}
			else if(moneyToGive == moneyEntered)
			{
				System.out.println("Thankyou visit again!!");
				return;
			}
			
			if(moneyToGive>=note2)
			{
				System.out.print(((int)Math.floor(moneyToGive/note2))+" Notes of Rs. "+note2+" & ");
				System.out.print(((int)Math.floor((moneyToGive%note2)/note1))+" Notes of Rs. "+note1);
				System.out.print(" & "+((moneyToGive%note2)%10)+" in coin\n");
			}
			else if(moneyToGive<note2 && moneyToGive>note1)
			{
				System.out.print(((int)Math.floor(moneyToGive/note1))+" Notes of Rs. "+note1);
				System.out.print(" & "+(moneyToGive % 10)+" in coin\n");
			}
			else if(moneyToGive<note1 && moneyToGive>0)
			{
				System.out.print((moneyToGive % 10)+" in coin\n");
			}
	}
}