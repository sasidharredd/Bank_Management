package com.banking;

import java.util.Scanner;

class Bank{
	private String name;
	private String acc_no;
	private long balance;
	
	Scanner sc = new Scanner(System.in);
	
	void openAccount(int i) {
		System.out.println("Enter "+i+" account holder name");
		name = sc.next();
		System.out.println("Enter "+i+" account number");
		acc_no = sc.next();
		System.out.println("Enter "+i+" account balance");
		balance = sc.nextLong();
		
	}
	
	public boolean searchAccount(String nme) {
		if(acc_no.equals(nme))
			return true;
		return false;
	}
	
	public  void displayDetails() {
		System.out.println("Account Details...");
		System.out.println(acc_no + "," + name + "," + balance);
		System.out.println("Account name : "+name+"\nAccount number : "+acc_no+"\nAccount balance : "+balance);
	}
	
	public void balance() {
        System.out.println("The account balance is : "+balance);
	}
	
	public void deposit() {
        System.out.println("Enter amount want to deposit...");
        long amt = sc.nextLong();
        balance = balance + amt;
        System.out.println("The account balance is : "+balance);
	}
	
	public void withdrawal() {
        System.out.println("Enter amount want to withdraw...");
        long amt = sc.nextLong();
        if(amt<balance) {
        	balance = balance - amt;
            System.out.println("The account balance is : "+balance);
        }
        else {
        	System.out.println("Enter amt within limit");
        	withdrawal();
        }
	}
	
}

public class Banking {	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of accounts to be added");
		int no = sc.nextInt();
		Bank[] b = new Bank[no];
		for(int i=0;i<no;i++) {
			b[i]=new Bank();
			b[i].openAccount(i+1);
		}
		int flag = 0,ch;
		do {
			System.out.println("Enter account number to login");
			String acc = sc.next();
			for(int i=0;i<no;i++) {
				if( b[i].searchAccount(acc)) {
					flag=1;
					do {
						System.out.println("Enter a choice form below...\n0. Display all account details\n1. Display my account details\n2. Balance check\n3. Deposit cash\n4. Withdraw cash\n5. Exit");
						 ch = sc.nextInt();
						switch(ch) {
						case 0:
							for (int i1 = 0; i1 < no; i1++) {
	                            b[i1].displayDetails();
	                        }
	                        break;
						case 1:
							b[i].displayDetails();
							break;
						case 2:
							b[i].balance();
							break;
						case 3:
							b[i].deposit();
							break;
						case 4:
							b[i].withdrawal();
							break;
						case 5:
							System.out.println("Thank you for using our banking services");
							System.exit(0);
							break;		
						default:
							System.out.println("Enter correct choice");
							break;
						}
					}while(ch!=5);
				}
			}
			if(flag==0)
				System.out.println("Account number is not found...");
		}while(flag==0);
		
		
		
		
	}
}
