//Banking Management System
import java.util.*;
//create a abstract class Account
abstract class Account
{
protected int acnumber;
protected double balance;

 Account()//Default constructor
 {
   acnumber=0;
   balance=0.0;
  }
  Account(int acnumber,double balance)//Parameterized constructor 
  {
    this.acnumber=acnumber;
    this.balance=balance;
   }
}
//inherit class SBaccount from Account
class SBaccount extends Account
{
 SBaccount()//Default constructor
 {
      super();
 }
 SBaccount(int acnumber,double balance)//Parameterized constructor
 {
   super(acnumber,balance); 
  }
  void deposit(double amount)//method for deposit
   {
    if(amount>0)
    {
    System.out.println("Current Balance:"+balance);
    balance=balance+amount;
    System.out.println("Your New balance:"+balance);
    }
    else
    System.out.println("Invalid amount");
   }
   void withdraw(double amount)//method for withdrawal
   {
     if(balance-amount>=1000)
     {
      System.out.println("Current balance:"+balance);
      balance=balance-amount;
      System.out.println("Your New balance:"+balance);  
      }
      else
      {
      System.out.println("Insufficient amount");
      }
    }
    void calc_interest()//method to calculate Interest
    { 
      System.out.println("Current balance:"+balance);
      balance+=balance*4/100*12;
      System.out.println("Your New balance:"+balance);
     }    
}
//inherit class FDaccount form account
class FDaccount extends Account
{
 int period;
 FDaccount()//Default constructor
 {
  super();
  }
   FDaccount(int acnumber,double balance,int period)//parameterized constructor
   {
     super(acnumber,balance);
     this.period=period;
    }   
    double calc_interest()//method for calculate interest
    { 
      return balance*8.25/100*period;
     }
     void close()// method to close account
     { 
       System.out.println("Your Current Balance:"+balance);
       balance+=calc_interest();
       System.out.println("Matured Amount:"+balance);
       this.balance=0;
      } 
}
//create a class Customer
class Customer 
{
    int  cust_id;
    String name,address;
    static int sbaccno=12345;
    static int fdaccno=98765;
   Scanner sc=new Scanner(System.in);
     SBaccount sb;
     FDaccount fd;
    Customer()//Default constructor
    {
     cust_id=0;
     name=null;
     address=null;
     }
   Customer( int cust_id,String name,String address)//parameterized constructor
   {
      this.cust_id= cust_id;
     this.name=name;
     this.address=address;
     System.out.println("Personal Details: ");
     System.out.println("Name: "+name);
    System.out.println("Customer Id: "+cust_id);
    System.out.println("Address: "+address);
     
   }
   void createAccount(int type)//method to create account
   {
      if(type==1)//create account for SB
     {  
      System.out.println("Enter initial Amount:  ");
      double amount=sc.nextDouble();
       sb=new SBaccount(sbaccno++,amount);
    }
   else if(type==2)//create account for FD
   {
       System.out.println("Enter Initial Amount, Period: ");
       double amount=sc.nextDouble();
       int period=sc.nextInt();
       fd=new FDaccount(fdaccno++,amount,period);
   }
   else
      System.out.println("Invalid Type");
}
 void transaction(int type)//method to make transaction
  {
    if(type ==1)//Deposit
    { 
      System.out.println("Enter Deposit Amount:");
        double amount=sc.nextDouble();       
          sb.deposit(amount);
    }
   else if(type == 2)//Withdraw
    {
        System.out.println("Enter Withdraw Amount:");
          double amount=sc.nextDouble();
           sb.withdraw(amount);
    } 
    else if(type == 3)//calculate interest
   {
      sb.calc_interest(); 
    }
    else if(type == 4)//close account
    {
      fd.close();
    }
    else 
      System.out.println("Invalid choice");
  }
}
//create a main class BankDemo
class BankDemo
{
  public static void main(String args[])
  {
    Customer c[]=new Customer[5];
    int ch1,ch2,ch3;
    int i=0,id,x;
    Scanner sc=new Scanner(System.in);
    do
    { 
       System.out.println("Simren Bank"); 
       System.out.println("Main menu");
       System.out.println("SBAccount------->1");
       System.out.println("FDAccount------->2");
       System.out.println("EXIT------------>3");
       System.out.println("Enter your Choice:");
       ch1=sc.nextInt();
        switch(ch1) 
        {
          case 1:
         do
        {
       System.out.println("Simren Bank");
       System.out.println("SBACCOUNT");
       System.out.println("New SBAccount---------------->1");
       System.out.println("Deposit---------------------->2");
      System.out.println("Withdraw---------------------->3");
      System.out.println("calculateinterest------------->4");
       System.out.println("Exit------------------------->5");    
       System.out.println("Enter your Choice");
          ch2=sc.nextInt();
         switch(ch2)
          { 
            case 1:
                        System.out.println("Enter name,address:");
                        String name=sc.nextLine();
			sc.nextLine();
                        String address=sc.nextLine();
                        c[i]=new Customer(i,name,address);
                        c[i].createAccount(1);
                         i++;
                          break;
           case 2:
                       System.out.println("Enter customer Id:");
                        x=sc.nextInt();
                       c[x].transaction(1);
                       break;
           case 3:      
                      System.out.println("Enter customer Id:");
                      x=sc.nextInt();
                     c[x].transaction(2);    
                      break;
           case 4:
                     System.out.println("Enter customer Id:");
                      x=sc.nextInt();
                      c[x].transaction(3);    
                      break;
           case 5:
                        break;
            default:
                       System.out.println("Invalid Choice---SBAccount");
        }
     }while(ch2!=5);
         break;
        case 2:
         do{
        System.out.println("Simren Bank");
       System.out.println("FDACCOUNT");
       System.out.println("New FDAccount------->1");
       System.out.println("FD Close------------>2");
       System.out.println("Exit---------------->3");    
       System.out.println("Enter your Choice:");
       ch3=sc.nextInt();
       switch(ch3)
       {
             case 1:
                       System.out.println("Enter name,address:");
                       String name=sc.nextLine();
			sc.nextLine();
                       String address=sc.nextLine();
                        c[i]=new Customer(i,name,address);
                        c[i].createAccount(2);
                         i++;
                        break;
              case 2:
                          System.out.println("Enter customer Id:");
                          x=sc.nextInt();
                          c[x].transaction(4);
                          break;
             case 3: 
                        break;
              default:
                        System.out.println("Invalid Choice");
            }
        }while(ch3!=3);
           break;
        case 3: 
                   break;
       default:
                 System.out.println("Invalid Choice");
        }
    }while(ch1 != 3);
    }
  }  