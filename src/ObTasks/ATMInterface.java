package ObTasks;

import java.util.Scanner;

class BankAccount {
	
	String name;
	String userName;
	String password;
	String accountNo;
	float balance = 100000f;
	int transactions = 0;
	String mytransactionHistory = "";
	
	public void registration() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter Your Name - ");
		this.name = sc.nextLine();
		System.out.print("\nEnter Your Username - ");
		this.userName = sc.nextLine();
		System.out.print("\nEnter Your Password - ");
		this.password = sc.nextLine();
		System.out.print("\nEnter Your Account Number - ");
		this.accountNo = sc.nextLine();
		System.out.println("\nRegistration completed..kindly login");
	}
	
	public boolean loginDetails() {
		boolean isLogin = false;
		Scanner sc = new Scanner(System.in);
		while ( !isLogin ) {
			System.out.print("\nEnter Your Username - ");
			String Username = sc.nextLine();
			if ( Username.equals(userName) ) {
				while ( !isLogin ) {
					System.out.print("\nEnter Your Password - ");
					String Password = sc.nextLine();
					if ( Password.equals(password) ) {
						System.out.print("\nYour Login is successful!!!");
						isLogin = true;
					}
					else {
						System.out.println("\nIncorrect Password...Please try again");
					}
				}
			}
			else {
				System.out.println("\nSorry...Username not found.Please recheck");
			}
		}
		return isLogin;
	}
	
	public void withDraw() {
		
		System.out.print("\nPlease enter amount to withdraw - ");
		Scanner sc = new Scanner(System.in);
		float amnt = sc.nextFloat();
		try {
			
			if ( balance >= amnt ) {
				transactions++;
				balance -= amnt;
				System.out.println("\nWithdraw Successful");
				String string = amnt + " Rs Withdrawed\n";
				mytransactionHistory = mytransactionHistory.concat(string);
				
			}
			else {
				System.out.println("\nInsufficient Balance!!!");
			}
			
		}
		catch ( Exception e) {
		}
	}
	
	public void deposit() {
		
		System.out.print("\nEnter amount to deposit - ");
		Scanner sc = new Scanner(System.in);
		float amnt = sc.nextFloat();
		
		try {
			if ( amnt <= 100000f ) {
				transactions++;
				balance += amnt;
				System.out.println("\nDeposit Succesful");
				String string = amnt + " Rs deposited\n";
				mytransactionHistory = mytransactionHistory.concat(string);
			}
			else {
				System.out.println("\nSorry...Limit is 100000.00");
			}
			
		}
		catch ( Exception e) {
		}
	}
	
	public void transfered() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter Receipent Name - ");
		String receipentname = sc.nextLine();
		System.out.print("\nEnter amount to transfer - ");
		float amnt = sc.nextFloat();
		
		try {
			if ( balance >= amnt ) {
				if ( amnt <= 50000f ) {
					transactions++;
					balance -= amnt;
					System.out.println("\nSuccessfully Transfered to " + receipentname);
					String str = amnt + " Rs transfered to " + receipentname + "\n";
					mytransactionHistory = mytransactionHistory.concat(str);
				}
				else {
					System.out.println("\nSorry...Limit is 50000.00");
				}
			}
			else {
				System.out.println("\nInsufficient Balance");
			}
		}
		catch ( Exception e) {
		}
	}
	
	public void yourBalance() {
		System.out.println("\n" + balance + " Rs");
	}
	
	public void transactHistory() {
		if ( transactions == 0 ) {
			System.out.println("\nEmpty");
		}
		else {
			System.out.println("\n" + mytransactionHistory);
		}
	}
}

public class ATMInterface {
	
	public static int takeIntegerInput(int capacity) {
		int myinput = 0;
		boolean syst = false;
		
		while ( !syst ) {
			try {
				Scanner sc = new Scanner(System.in);
				myinput = sc.nextInt();
				syst = true;
				
				if ( syst && myinput > capacity || myinput < 1 ) {
					System.out.println("Choose the number between 1 to " + capacity);
					syst = false;
				}
			}
			catch ( Exception e ) {
				System.out.println("Enter only valid value");
				syst = false;
			}
		};
		return myinput;
	}
	

	public static void main(String[] args) {
				
		System.out.println("\n**********WELCOME TO SBI ATM SYSTEM**********\n");
		System.out.println("1.Register \n2.Exit");
		System.out.print("Enter Your Choice - ");
		int choice = takeIntegerInput(2);
		
		if ( choice == 1 ) {
			BankAccount bank = new BankAccount();
			bank.registration();
			while(true) {
				System.out.println("\n1.Login \n2.Exit");
				System.out.print("Enter Your Choice - ");
				int cho = takeIntegerInput(2);
				if ( cho == 1 ) {
					if (bank.loginDetails()) {
						System.out.println("\n\n########WELCOME BACK " + bank.name + " #########\n");
						boolean isFinish = false;
						while (!isFinish) {
							System.out.println("\n1.Withdraw \n2.Deposit \n3.Transfer \n4.Check Balance \n5.Transaction History \n6.Exit");
							System.out.print("\nEnter Your Choice - ");
							int ch = takeIntegerInput(6);
							switch(ch) {
								case 1:
								bank.withDraw();
								break;
								case 2:
								bank.deposit();
								break;
								case 3:
								bank.transfered();
								break;
								case 4:
								bank.yourBalance();
								break;
								case 5:
								bank.transactHistory();
								break;
								case 6:
								isFinish = true;
								break;
							}
						}
					}
				}
				else {
					System.exit(0);
				}
			}
		}
		else {
			System.exit(0);
		}
		
		
		
	}


}
