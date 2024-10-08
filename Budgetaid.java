
package Budgetaid;
import java.util.*;

public class BudgetAid {

    public static void main(String[] args) {
        monthlyIncome me = new monthlyIncome();
        me.inherit();
        
        monthlyIncome.home_house home_house =me.new home_house();
       home_house.expens();
        home_house.calculate_expense();
        home_house.collect_expenses();
       home_house.choose();
      
        monthlyIncome.vehicle vehicle =me.new vehicle();
       vehicle. buy_or_not();
       vehicle.total_expenses_n_total_money_available();
       
    }
    
}

class monthlyIncome{
    Scanner me5 = new Scanner(System.in);
    
    private double  gross_monthlyIncome ;
     public double getgross_monthlyIncome(){
        return gross_monthlyIncome;
    }
     
    private  double income_left_after_tax_ded;
    public double getincome_left_after_tax_ded(){
        return income_left_after_tax_ded;
    }
    
    private void income(){
        
        System.out.println("Enter your gross monthly income:");
         gross_monthlyIncome=me5.nextDouble();
        System.out.println("Enter your tax deduction in percentage form(but in decimal  form):");
        float tax=me5.nextFloat();
        income_left_after_tax_ded=gross_monthlyIncome-gross_monthlyIncome*tax;
    }
    //this method give access to the private  method income at top
    public void inherit(){
        income();
    }
    
     abstract class expenses{
          
       double groceries;
       double water_n_light;
       double Travel_cost;
       double cellphone_n_telephone;
       double other;
       double total_expenses;
      
       abstract  void choose();
       
       public void expens(){
           //user inputs
           System.out.println("Enter amount you spend on groceries:");
            groceries=me5.nextDouble();
        
        System.out.println("Enter the amount you spend on water and electricity:");
           water_n_light =me5.nextDouble();
           
       System.out.println("Enter the amount you spend on travel cost:");
        Travel_cost =me5.nextDouble();
        
           System.out.println("Enter the amount you spend on cell phone and telephones:");
           cellphone_n_telephone =me5.nextDouble();
           
         System.out.println("Enter the amount you spend on other expenses:");
         other =me5.nextDouble();
           
       }
        
       
       public void calculate_expense()
       {
           total_expenses= groceries +water_n_light+Travel_cost+cellphone_n_telephone+ other;
           System.out.println("\nYour total amount for expenses  = R" +total_expenses);
       
       } 
        
        ArrayList <Double>total_expenses4= new ArrayList<>();
       public void collect_expenses() {
            double  me []={groceries ,water_n_light,Travel_cost,cellphone_n_telephone, other};
           //the array is for displaying words for displaying in discending order
           String expenses[] = {"groceries"," water  and electricity"," travel cost", " cellphone amd telephones", " other expenses"};
           
        total_expenses4.add(total_expenses); 
                      
        for (int i =0 ; i <me.length;i++){
            
            for(int j=0; j<me.length-1;j++){
                
                if(me[j]< me[j+1]){
                    
                   double temp =me[j];
                   me[j]= me[j+1];
                   me[j+1]=temp;
                   
                   String temp1 =expenses[j];
                   expenses[j]= expenses[j+1];
                  expenses[j+1]=temp1;
                 System.out.println("j");
                
                }
               
            }
         
         }
             for( double x: me){
                 
                    System.out.println( "=R"+ x  );
                    
                }
                 
       } 
         
    }
     
    class home_house extends expenses{
        
        double total_expense_for_rent_n_expenses;
        double total_home_loan_payments;
         double total_expenses_for_homeloan_n_expenses;
        double  money_left_after_expenses_n_property;
          double money_left_after_expense_n_rent;
            double home_loan_repayments;
       Scanner me3= new Scanner(System.in);
            
      int choice;  
     String choose[] ={"0.renting" ,"1.buy property" };
     
       @Override
       public  void choose() {
           
            System.out.println("Choose if your want to rent or buy property (choose 0 or 1):");
            
          do{
              for(String x : choose){
                  System.out.println(x);
              }
              
             choice=me5.nextInt();
          }while(choice==choose.length);
           
        switch(choice){
       
         case 0 :
           
           System.out.println("Enter the amount of your rent:");
           double rent =me5.nextDouble();
            total_expense_for_rent_n_expenses = rent+total_expenses;
            money_left_after_expense_n_rent= income_left_after_tax_ded- total_expense_for_rent_n_expenses;
              
               break;
         case 1:
       
           final int n=12;
       
          System.out.println("Enter total price of the property: ");
          double  price_of_property =me5.nextDouble();
         System.out.println("Enter the amount you deposited:");
           double  total_deposits =me5.nextDouble();
           System.out.println("Enter the  interest rate in decimal: ");
           double interest_rate = me5.nextDouble();
           System.out.println("The number of  years to pay for the house (NB:years should be 20-30 years):");
            double number_of_years =me5.nextDouble();
           
           double p=price_of_property-total_deposits;
           
             home_loan_repayments =(p*(interest_rate/n))/(1-(Math.pow(1+interest_rate/n, -n*number_of_years)));
             
             System.out.println("Your monthly repayments = R"+ home_loan_repayments );
           
              if( home_loan_repayments>(0.333333)*getgross_monthlyIncome()){
                   System.out.println("The home aproval is unlikely , the home loan  is greater than one-third of your income:");
       
              }
              else if( home_loan_repayments<(0.333333)*getgross_monthlyIncome()){
                   System.out.println("The home loan approval is successful:");
                total_expenses_for_homeloan_n_expenses= home_loan_repayments+ total_expenses;
               money_left_after_expenses_n_property= income_left_after_tax_ded-total_expenses_for_homeloan_n_expenses;
               
              }
              break;
       }
       
       }
    }
    
    class vehicle extends   home_house {
     
    double vehicle_monthly_repayment;
      double total_expenses_including_vehicle_loan;
       double money_available_after_all_expenses;
        double total_expenses_without_vehicle_loan;
      

     String choice2;
 
   public void buy_or_not(){
       
     System.out.println("Do your want to buy a vehicle(yes or no):");
      choice2= me3.nextLine();

       if(choice2.equals("yes")){
           
            final int n=12;
           final int number_ofyears=5;
           
          System.out.println("Enter the type of car and the brand your want to buy:");
           String  model_n_make =me5.nextLine();
           
           System.out.println("Enter the car price purchase:");
            double  Purchse_price= me5.nextDouble();
            
            System.out.println("Enter the total deposits:");
             double  total_deposits= me5.nextDouble();
             
             System.out.println("Enter the interest rate(percetage decimal form):");
              double  interest_rate= me5.nextDouble();
              
              System.out.println("Enter the estimated car insurance premium:");
               double  estimated_insurance_premium=me5.nextDouble();
       
            double P=Purchse_price-total_deposits;
           
            vehicle_monthly_repayment=(P*(interest_rate/n))/(1-(Math.pow(1+interest_rate/n, -n*number_ofyears)));
           
            System.out.println("Your monthly vehicle repaymenrts = R"  +vehicle_monthly_repayment );
            
            total_expenses_including_vehicle_loan = vehicle_monthly_repayment +  money_left_after_expenses_n_property +estimated_insurance_premium;
                   
        }
       
   }
    
    public void total_expenses_n_total_money_available(){
     
      if(choice==0 && choice2.equals("yes")){
          
         total_expenses_including_vehicle_loan =   total_expense_for_rent_n_expenses+vehicle_monthly_repayment;
         System.out.println("The total expenses  =  R" + total_expenses_including_vehicle_loan);
         
                if(total_expenses_including_vehicle_loan>getgross_monthlyIncome()*0.75){
                    System.out.println("The total expenses excludes 75% of your income");
                }
                
          money_available_after_all_expenses  =  income_left_after_tax_ded - total_expenses_including_vehicle_loan;   
            System.out.println("The total money after all the expenses = R " +  money_available_after_all_expenses);
            
      }else if(choice==0 && choice2.equals("no")){
           total_expenses_without_vehicle_loan=total_expense_for_rent_n_expenses;
         System.out.println("The total expenses  =  R" + total_expenses_without_vehicle_loan);
         
          if(total_expenses_without_vehicle_loan>getgross_monthlyIncome()*0.75){
                    System.out.println("The total expenses excludes 75% of your income");
                }
          
         money_available_after_all_expenses =  income_left_after_tax_ded - total_expenses_including_vehicle_loan;
           System.out.println("The total money after all the expenses = R " +  money_available_after_all_expenses);
           
      }else if(choice==1 && choice2.equals("yes")){
         total_expenses_including_vehicle_loan =   total_expenses_for_homeloan_n_expenses+vehicle_monthly_repayment;
          System.out.println("The total expenses  =  R" + total_expenses_including_vehicle_loan);
          
           if(total_expenses_including_vehicle_loan>getgross_monthlyIncome()*0.75){
                    System.out.println("The total expenses excludes  75%  of  your income");
                }
           
           money_available_after_all_expenses=  income_left_after_tax_ded - total_expenses_including_vehicle_loan;
            System.out.println("The total money after all the expenses = R " +  money_available_after_all_expenses);
            
      }else if(choice==1 && choice2.equals("no")){
          
         total_expenses_without_vehicle_loan=home_loan_repayments+ total_expenses;
         
          
           if(total_expenses_without_vehicle_loan>getgross_monthlyIncome()*0.75){
                    System.out.println("The total expenses excludes  75%  of  your income");
                }
           
           money_available_after_all_expenses= income_left_after_tax_ded  -  total_expenses_including_vehicle_loan;
           System.out.println("The total money after all the expenses = R " +  money_available_after_all_expenses);
      }   

    }
  
    }
}