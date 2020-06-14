public class Flight{

	   private String flightNumber;
	   private String Cities[]={"Dammam","Jeddah","Yanbu" , "Hail" , "Abha" , "Tabuk" ,"Taif"};
	   private int Destination;
	   private int Gate ;
	   private String Date;
	   private String DepartureTime;
	   private String arriveTime; 
	   public static int totalFlights ; 
	   
	   public  Flight(){
	      Destination=0;
	      Gate=0;
	      totalFlights=0;
	      Date="";
	      DepartureTime="";
	      arriveTime="";
	      totalFlights++;
	      flightNumber="";
	   }
	   
	   //Destination=Dest,Gate=gte,Date=dte,DepartureTime=dep
	   public Flight(int Dest ,  String dte ,int gte  , String dep ){
	      Destination=Dest;
	      Gate=gte;
	      Date=dte;
	      DepartureTime=dep;
	      totalFlights++;
         generateFlightNumber();
	      flightNumber=getFlightNumber();
	      calculateAriivalTime();
	   }
//---------------------------------------------	   
	   public void setDestination(int Dest){
	      Destination=Dest;
	   }
	   public int getDestination(){
		   return Destination;
	   }
//---------------------------------------------	   
	   public void setDate(String dte){
	      Date=dte;
	   }
	   public String getDate(){
		   return Date;
	   }
//---------------------------------------------	   
	   public void setGate(int gte){
	      Gate=gte;
	   }
	   public int getGate(){
		   return Gate;
	   }
//--------------------------------------------	   
	   public void setDepartureTime(String dep){
	      DepartureTime=dep;
	   }
	   public String getDepartureTime(){
		   return DepartureTime;
	   }  
//--------------------------------------------	   
	   public void setArrivalTime(String arrive){
	      arriveTime=arrive;
	   }
	   public String getArrivalTime(){
	      return arriveTime;
	   }
//---------------------------------------------
	   public String getFlightNumber(){
	      
	      return flightNumber;
	   }
//---------------------------------------------	   
	   public void generateFlightNumber(){//DAM003
	   //totalFlights is ready to use here
	      String city= Cities[Destination].substring(0,3);
	      flightNumber=city.toUpperCase()+"00"+totalFlights;
	   }
//---------------------------------------------	   
	   public void calculateAriivalTime(){
	      int duration=0;
	      switch (Destination){
	         case 0:
	            duration=65;
	            break;
	         case 1 :
	         case 2 :
	         case 3 :
	            duration=105;
	            break;
	         case 4: 
	            duration=75;
	            break;
	         case 5:
	            duration=80;
	            break;
	         case 6:
	            duration=95;
	            break;
	         default:System.out.println("invalid input");
	      }
	   //calculate the arriveTime
	      arriveTime="00:00";
	      int h=Integer.parseInt(DepartureTime.substring(0,DepartureTime.indexOf(':')));
	      int min=Integer.parseInt(DepartureTime.substring(DepartureTime.indexOf(':')+1,DepartureTime.length()));
	      int num=(int)(duration/60);
	      int min1=duration%60;
	      h+=num;
	      min+=min1;
	      if (min>59){
	         int num1=min/60;
	         h+=num1;
	         min=min%60;}
	      if(h>23){
	         h=h-24;//arriveTime+1
	         if(min<10 && h>10)
	            arriveTime=h+":"+"0"+min+"+1";
	         if(h<10 && min>10)
	            arriveTime="0"+h+":"+min+"+1";
	         if(h>10&&min>10)
	            arriveTime=h+":"+min+"+1";
	         if(h<10 && min<10)
	            arriveTime="0"+h+":"+"0"+min+"+1";}
	      else{
	         if(min<10 && h>10)
	            arriveTime=h+":"+"0"+min;
	         if(h<10 && min>10)
	            arriveTime="0"+h+":"+min;
	         if(h>10&&min>10)
	            arriveTime=h+":"+min;
	         if(h<10 && min<10)
	            arriveTime="0"+h+":"+"0"+min;}
	   }
//---------------------------------------------	   
	   public void printFlightInfo(){
	      System.out.printf("Flight Number: %-15sGate: %-15d%nDestination: %-15sDate: %-15s%nDeparture Time: %-15sArrival Time: %-15s%n%n",flightNumber,Gate,Cities[Destination],Date,DepartureTime,arriveTime);
	   }
	 
	}