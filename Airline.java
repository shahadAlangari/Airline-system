
//is flight number unique for each flight added?  JED001 JED002 or JED002 JED002
//checking for existing flight?
//checking arrivalTime??? and do we have to ckeck if the filght has been added???

 import java.util.*;
 public class Airline
 {
    public static Scanner read = new Scanner (System.in);
    private static Flight [] FlightList=new Flight [100];
    public static void main(String args[]){
       int select;
       do{
          System.out.println(" what would you like to do ?");
          System.out.println("(1) Add a flight\n (2) Find a flight\n (3)List all flight\n (4)List flight for a given date\n (5)Update departure and arrival time\n (6)Total number of flights\n (7)Exit");
          System.out.print("Your choice: ");
          select=read.nextInt();
          switch ( select ) {
             case 1 :
                System.out.println("choose destination :\n (0)Dammam\n (1)Jeddah\n (2)Yanbu\n (3)hail\n (4)Abha\n (5)Tabuk\n (6)Taif\n ");
                System.out.print("Your choice: ");
                int des=read.nextInt();
                System.out.println("Enter date in the format DD/MM :");
                String dte=read.next();
                System.out.println(" Enter gate : ");
                int gte=read.nextInt();
                System.out.println(" Enter departure time in the format HH:MM : ");
                String dep=read.next();
                if(addFlight(des,dte,gte,dep)){
                   System.out.println("the flight was added successfully!!!");
                   System.out.println("the flight number is : "+FlightList[Flight.totalFlights-1].getFlightNumber());}
                else 
                   System.out.println("the flight was not added because of an invalid input");
                System.out.println("___________________________________\n");
                
                break;
          
             case 2:
                System.out.println("enter the flight number that you are searching for. for example :DAM004 ");
                String FlightNumber=read.next();
                int loc=findFlight(FlightNumber); 
                if(loc==-1)
                   System.out.println("flight not found!!");
                else 
                   System.out.println("flight is found in the flightList in index: "+loc);
                break;
             case 3:
                printAll();
                break;
             case 4:
                System.out.println("enter date : ");
                String dte1=read.next();
                printAll(dte1);
                break;
             case 5:
                System.out.println("enter the flight number that you are searching for. for example : DAM004 ");
                String flightNumber2=read.next();
                System.out.println("enter new DepartureTime on the format HH:MM");
                String dep2=read.next();
                updateTime(flightNumber2,dep2);
                break;
             case 6:
                System.out.println("the number of flights is: "+getNumberOfFlights());
          
          }}while(select!=7);
    }//end main
//---------------------------------------------    
    public static boolean addFlight(int Dest ,  String dte ,int gte  , String dep)
 {
       if (Flight.totalFlights == 100) {
       
          return false;}
          
             if (Dest < 0 || Dest > 6) {
            return false;
        }
           if (dte.length()!=5||dte.charAt(2)!='/')
          return false;
          
           int day = Integer.parseInt(dte.substring(0, 2));
        int month = Integer.parseInt(dte.substring(3));
        
         if(dep.length()!=5||dep.charAt(2)!=':')
          return false;
      {
           int hour = Integer.parseInt(dep.substring(0, 2));
        int minutes = Integer.parseInt(dep.substring(3));

        if (hour < 0 || hour > 23) {
            return false;
        }

        
        if (minutes < 0 || minutes > 59) {
            return false;
        }
        
    
            if (month < 1 || month > 12) {
            return false;
        }

        if (day < 1 || day > 31) {
            return false;
        }
    
          FlightList[Flight.totalFlights]=new Flight( Dest ,   dte , gte  ,  dep);
          return true;}
    }
//---------------------------------------------
    public static int findFlight (String FlightNumber1){
       int location = -1;    //location=index of flight number
       int i;
       for(i=0; i<Flight.totalFlights; i++)
          if ((FlightList[i].getFlightNumber()).equals(FlightNumber1))//exsaption
             location = i;
       return location;
    } //end findFlight
//---------------------------------------------
    public static void printAll(){int i=0;
       for(;i<Flight.totalFlights;i++)
          FlightList[i].printFlightInfo(); 
    } // end printAll
//---------------------------------------------
    public static void printAll(String dte1){int i;
       for (i=0;i<Flight.totalFlights;i++)
          if((FlightList[i].getDate()).equals(dte1))
             FlightList[i].printFlightInfo();
    } //end printAll

//---------------------------------------------
    public static void updateTime (String FlightNumber1, String dep){
       if( findFlight(FlightNumber1)==-1){
          System.out.println("this flight has not been added!!!!");
          return;}
       FlightList[findFlight(FlightNumber1)].setDepartureTime(dep);
       FlightList[findFlight(FlightNumber1)].calculateAriivalTime();
    
    } //end updateTime

//---------------------------------------------
    public static int getNumberOfFlights(){
       return Flight.totalFlights;
    } //end getNumberOfFlights


 } //end class
