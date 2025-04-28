import java.util.Scanner;
class BankAccount
{
	private double balance;

	public 	BankAccount(double IB)
	{
		balance = IB;
	}
	public double getBalance()
	{
		return balance;
	}

	public void deposit(double amount)
	{
		balance = balance + amount;
	}
	public boolean withdraw(double amount)
	{
		if(amount<=balance)
		{
			balance -=amount;
			return true;
		}
		else
		{
			return false;
		}
	}
}

class ATM
{
	private BankAccount account;

	public  ATM(BankAccount account)
	{
		this.account = account;
	}

	public void displayMenu()
	{
		System.out.println("Welcome to the ATM");
		System.out.println("1.Check Balance");
		System.out.println("2.Deposite");
		System.out.println("3.Withdraw");
		System.out.println("4.Exit");
	}

	public void PT()
	{
		Scanner sc = new Scanner(System.in);
		int choice;
		double amount;


		while(true)
		{
			displayMenu();
			System.out.println("Enter Your Choice:");
			choice=sc.nextInt();


			switch(choice)
			{
			case 1:
				System.out.println("Your balance is: Rs. "+ account.getBalance());
				break;

			case 2:
				System.out.println("Enter the deposite amount:Rs.");
				amount = sc.nextDouble();
				if(amount>0)
				{
					account.deposit(amount);
					System.out.println("Deposite Sucessfully.");
				}
				else
				{
					System.out.println("Invalid deposite amount");
				}
				break;
			case 3:
				System.out.println("Enter the withdrawl amount:Rs.");
				amount = sc.nextDouble();
				if(amount>0 && account.withdraw(amount))
				{
					System.out.println("Withdraw Sucessfully.");
				}
				else
				{
					System.out.println("Invalid withdrawl amount or insufficient balance.");
				}
				break;
			case 4:
				System.out.println("Thank You for using the ATM ");
				return;
			default:
				System.out.println("Invalid Choice.Please Try Again");
			}

		}
	}
}


 class ATM_INTERFACE
{
	public static void main(String[] args) 
	{
		BankAccount userAccount = new BankAccount(100000);
		ATM atm = new ATM (userAccount);
		atm.PT();	
	}
}