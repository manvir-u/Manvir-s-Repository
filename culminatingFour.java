import java.util.Scanner;
public class culminatingFour{
  public static void main(String[] args){
   Scanner in = new Scanner(System.in);
   System.out.println("{-Welcome to Supreme Pass Hotel-}"); 
   boolean time = true;
   double priceSet = 0;
   int f = 0;
   int r = 0;
   //make loop
     System.out.println("Since this is your first time using this program your going to have to set it up \n First of all how many floors are there and how many rooms per floor"); 
     System.out.println("Number of floors");
     f = in.nextInt();
     System.out.println("Enter number of rooms");
     r = in.nextInt();
   
   String [][] rooms  = setup(f,r);
   int c = 1;
   priceSet=price(c, priceSet);
   
  while(time){
   System.out.println("Would you like to go into the managment side(1) or consumer side(2)");
   c = in.nextInt();
   if (c == 1){
     System.out.println("1. Check how many rooms are booked\n2. Check how many rooms vacant\n3. Clear all rooms booked\n4. Display rooms \n5. Set price per night\n6. Setup\n7. exit");
     int a = in.nextInt();
     if (a == 1){
       booked(rooms,f,r);
     }else if (a == 2){
       vaccant(rooms,f,r);
     }else if (a == 3){
      rooms=clear(rooms,f,r);
     }else if (a == 7){
       time = false;
     }else if (a == 5){
       priceSet=price(c, priceSet);
     }else if (a == 4){
       display(f,r,rooms);
     }else if(a==6){
     System.out.println("Number of floors");
     f = in.nextInt();
     System.out.println("Enter number of rooms");
     r = in.nextInt();
     rooms  = setup(f,r);
     }else{
       System.out.println("Not a valid option");
     }
   }
   else if (c == 2){
     boolean loop = true; 
       while(loop){
     System.out.println("Would you like to book a room? Yes(1), No(2)");
     int t = in.nextInt();
     if(t==1){
       book(rooms,f,r,c);
       price(c,priceSet);
     }
     else if (t==2){
       time = false;
       break;
     }
     else{
       System.out.println(t+" is not an option");
     }
     }
   }
   }
  }
  public static String [][] setup(int f, int r){
    
     String [][] rooms = new String [f][r];
     for (int i = 0; i<f;i++){
       for(int k = 0; k<r;k++){
         rooms[i][k] = "O";
         System.out.print(rooms[i][k]+"\t");
       }
       System.out.println("\n");
     }
   return rooms;
   }
  public static void booked(String rooms[][], int f, int r){
    int counter = 0;
    for (int i = 0; i<f;i++){
       for(int k = 0; k<r;k++){
         if (rooms[i][k].equals("X")){
           counter++;
         }        
       }  
     
    }System.out.println("There are "+counter+" rooms booked");
  }
  public static void vaccant(String rooms[][], int f, int r){
    int counter = 0;
    for (int i = 0; i<f;i++){//GET VALUES
       for(int k = 0; k<r;k++){
         if (rooms[i][k].equals("O")){
           counter++;
         }        
       }       
    }
    System.out.println("There are "+counter+" rooms vaccant");
  }
  public static void display(int f, int r, String rooms[][]){
    for (int i = 0; i<f;i++){
       for(int k = 0; k<r;k++){
         System.out.print(rooms[i][k]+"\t");
       }
       System.out.println("\n");
     }
  }
  public static String[][] clear(String rooms[][], int f, int r){
    for (int i = 0; i<f;i++){
       for(int k = 0; k<r;k++){
         rooms[i][k] = "O";
       }
     }
    System.out.println("All booked rooms have been cleared");
    return rooms;
  }
  public static void book(String rooms[][], int f, int r, int c){
    int l = f;
    int d = r;
    Scanner in = new Scanner(System.in);
    for (int i = 0; i<f;i++){
       for(int k = 0; k<r;k++){        
         System.out.print(rooms[i][k]+"\t");
       }
       System.out.println("\n");
     }
    boolean broke = true;
    while(broke){
    System.out.println("Which room would you like?");
    System.out.println("Which floor");
    int floorChoice = in.nextInt();
    floorChoice--;
    if (floorChoice>f || floorChoice<0){
      System.out.println("Floor "+floorChoice+" doesn't exist");
    }
    System.out.println("Which Room");
    int roomChoice = in.nextInt();
    roomChoice--;
       if (roomChoice>r || roomChoice<0){
     System.out.println("Room "+roomChoice+" does not exist"); 
    }else if (rooms[floorChoice][roomChoice].equals("X")){
      System.out.println("That room is booked");
    }else{
     broke = false;
     rooms[floorChoice][roomChoice]="X";
    }
    }
  }
  public static double price(int c,double priceSet){
    Scanner in = new Scanner(System.in);

    if (c ==1){
      System.out.println("What would you like to set the price of a room too");
       priceSet = in.nextDouble();
      
    }
    
    if(c==2){
      System.out.println("The price of a room is $"+priceSet);
      System.out.println("How many days would you like to stay");
      int days = in.nextInt();
      double total = days*priceSet;
      System.out.println("That will cost you $"+total);    
      System.out.println("The price of a room is $"+priceSet);
    }
    return priceSet;
  }

}