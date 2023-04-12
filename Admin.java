import java.util.Scanner;

public class Admin 
{

    // private String adminname = "admin";

    // private String  adminpass = "admin";

    static Scanner reader = new Scanner(System.in);

    Booking sign_out  = new Booking();
    Flight[] flight_ary = new Flight[20];
    
    //----------- new  flights -------- 
    void new_flights()
    {
        for (int j = 0; j < flight_ary.length; j++) 
        {
            flight_ary[j] = new Flight();
        }
    
    }    

    //-----------------------------------  admin menu --------------------------------------
    public void admin_menu()
    {
        new_flights();
        admin_back();
    }

    public void admin_back()
    {
        admin_frant();

        int num = reader.nextInt();

        clear();

        switch (num)
        {
        // --------------------- add ----------------------
            case 1:
                add();
                break;

        // ------------------- remove --------------------
            case 2:
               remove();
                break;

        // ------------------- remove --------------------
            case 3:
            print_flight();
            break;


             // ------------------- sing out --------------------
            case 4:
            sign_out.menu_back();
             break;



            default:

                System.out.println("\t\t\t\t\t\t\t\t\t\t\033[91m ==> Rong choice <==\033[97m");
                System.out.print("\t\t\t\t\t\t\t\t\t\t\t\033[33mPlese try again\033[97m");
                admin_back();
                break;
        }

    }

    

    public  void admin_frant()
    {
        System.out.println("\n\n");
        try{Thread.sleep(500);}catch(InterruptedException e) {};
        System.out.println("\033[35m\t\t\t\t\t\t+-----------------------------+");
        try{Thread.sleep(80);}catch(InterruptedException e) {};
        System.out.println("\t\t\t\t\t\t|         " + "\033[36m˙˚ Admin ˚˙" +"\033[35m         |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t+-----------------------------+");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|                             |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|       " + "\033[33m(1)\033[36m Add"+"\033[35m               |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|                             |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};
 
        System.out.println("\t\t\t\t\t\t|       "+"\033[33m(2)\033[36m Ubdate"+"\033[35m            |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|                             |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};
 
        System.out.println("\t\t\t\t\t\t|       "+"\033[33m(3)\033[36m Remove"+"\033[35m            |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|                             |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};
 
        System.out.println("\t\t\t\t\t\t|       "+"\033[33m(4)\033[36m Flight Schedules"+"\033[35m  |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|                             |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};
 
        System.out.println("\t\t\t\t\t\t|       "+"\033[33m(0)\033[36m Sing out"+"\033[35m          |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|                             |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t+-----------------------------+");
        try{Thread.sleep(80);}catch(InterruptedException e) {};
        System.out.print("\t\t\t\t\t\t==> ");

    }

    //-----------------------------------  Add flight --------------------------------------

    public void add()
    {

    }

    //-----------------------------------  Add flight --------------------------------------

    public void remove()
    {

    }


    //-----------------------------------  Add flight --------------------------------------
 
    public void print_flight()
    {

            System.out.print("\n\t\t\t\t\t\t\t\t\t\033[90m      << Flights List >>\033[97m\n");
    
            System.out.println("\033[35m");
            System.out.print("\t\t\t\t\t");
            System.out.print("+---------------------------------------------------------------------------------------------+");
            try{Thread.sleep(80);}catch(InterruptedException e) {};
    
    
            System.out.print("\n\t\t\t\t\t");
            System.out.printf("| %-1s| %-1s| %-1s| %-1s| %-1s| %-1s| %-1s|","\033[33m  Flight ID  \033[35m","\033[33m   Origins   \033[35m","\033[33m  Destention  \033[35m","\033[33m    Data    \033[35m","\033[33m   Time   \033[35m","\033[33m   Price   \033[35m","\033[33m Seats \033[35m");
            System.out.println();
            try{Thread.sleep(80);}catch(InterruptedException e) {};
    
    
            for (int i = 0; i < flight_ary.length; i++) 
            {
    
                    System.out.print("\033[35m\t\t\t\t\t");
                    System.out.print("+---------------------------------------------------------------------------------------------+");
                    try{Thread.sleep(80);}catch(InterruptedException e) {};
    
    
                    System.out.print("\n\t\t\t\t\t");
                    System.out.printf("|\033[97m    %-10s\033[35m|\033[97m    %-10s\033[35m|\033[97m    %-11s\033[35m|\033[97m %-12s\033[35m|\033[97m  %-9s\033[35m|\033[97m  %-10s\033[35m|\033[97m  %-4s\033[35m  ",flight_ary[i].get_flight_id(),flight_ary[i].get_origin(),flight_ary[i].get_destantion(),flight_ary[i].get_data(),flight_ary[i].get_time(),flight_ary[i].get_price(),flight_ary[i].get_seat());
                    System.out.println("|");
                    try{Thread.sleep(80);}catch(InterruptedException e) {};
    
            }
    
    
            System.out.print("\t\t\t\t\t");
            System.out.print("+---------------------------------------------------------------------------------------------+");
    

    }


//------------------------------------------ system clear -----------------------------------------

    public  void clear()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }



}
