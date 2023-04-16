import java.util.Scanner;

public class Passenger
{
    private String username;

    private String password;
    Scanner reader = new Scanner(System.in);


//-------------   Getter  ----------------

    public String getusername()
    {
        return username;
    }

    public String getpassword()
    {
        return password;
    }

//-------------   Setter  ----------------

    public void setusername(String username)
    {
        this.username = username;
    }

    public void setpassword(String password)
    {
        this.password = password;
    }

//------------------------------------------------- passenger menu -------------------------------------------------

// public void passenger_menu_back(Flight[] flight_ary,Passenger[] user)
// {
//     passenger_menu_frant();
//     int num = reader.nextInt();

//         clear();

//         switch (num)
//         {
//         // ------------- Change Password ---------------
//             case 1:
//                 change_pass(flight_ary,user);
//                 break;

//         // ------------------- Search Flight ticket --------------------
//             case 2:
//                search_flight_id(flight_ary,user);
//                 break;

//         // ------------------- Ticket Cancellation --------------------
//             case 3:
//             ticket(flight_ary,user);
//             break;

//         // --------------- Flight Schedules ---------------
//             case 4:
//                 flight_schedules(flight_ary,user);
//                 break;


//         // ------------------- Booked Ticket -----------------
//             case 5:
//                 booked(flight_ary,user);
//                 break;

//         // ------------------- Add Charge -----------------
//         case 6:
//             charge(flight_ary,user);
//             break;

//         // ------------------- Sign out -----------------
//         case 0:
//             sign_out.menu_back(user);
//             break;



//             default:

//                 System.out.println("\t\t\t\t\t\t\t\t\t\t\033[91m ==> Rong choice <==\033[97m");
//                 System.out.print("\t\t\t\t\t\t\t\t\t\t\t\033[33mPlese try again\033[97m");
//                 admin_back(flight_ary,user);
//                 break;


//         }

//     }


    private void passenger_menu_frant()
    {
        System.out.println("\n\n");
        try{Thread.sleep(500);}catch(InterruptedException e) {};
        System.out.println("\033[35m\t\t\t\t\t\t+--------------------------------+");
        try{Thread.sleep(80);}catch(InterruptedException e) {};
        System.out.println("\t\t\t\t\t\t|      " + "\033[36m˙˚ Passenger menu ˚˙" +"\033[35m      |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\033[35m\t\t\t\t\t\t+--------------------------------+");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|                                |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|     " + "\033[33m(1)\033[36m Change Password"+"\033[35m        |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|                                |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|     "+"\033[33m(2)\033[36m Search Flight ticket"+"\033[35m   |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|                                |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|     "+"\033[33m(3)\033[36m Ticket Cancellation"+"\033[35m    |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|                                |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|     "+"\033[33m(4)\033[36m Booked Ticket"+"\033[35m          |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|                                |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|     "+"\033[33m(4)\033[36m Add Charge"+"\033[35m             |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|                                |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|     "+"\033[33m(0)\033[36m Sing out"+"\033[35m               |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};



        System.out.println("\t\t\t\t\t\t|                                |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\033[35m\t\t\t\t\t\t+--------------------------------+");
        try{Thread.sleep(80);}catch(InterruptedException e) {};
        System.out.print("\t\t\t\t\t\t==> ");

    }














//------------------------------------------ system clear -----------------------------------------

    public  void clear()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
