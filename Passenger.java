import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * @Author    Ali jafaripour
 * @Data     1402/01/09
 */


public class Passenger extends Data_base
{

    Passenger_file user = new Passenger_file();
    Flight_file flight = new Flight_file();
    Ticket_file ticket = new Ticket_file();

    static Scanner reader = new Scanner(System.in);



//------------------------------------------------- passenger menu -------------------------------------------------

    /**
     *  This method for first passenger menu;
     * @param flight_file  array of flight from Flight class
     * @param user_file  array of user from Passenger class
     */
    public void passenger_menu_back(RandomAccessFile flight_file, RandomAccessFile user_file) throws IOException
    {
        passenger_menu_front(user_file);
        int num = reader.nextInt();

        user.clear();

        switch (num)
        {
            // ------------- Change Password ---------------
            case 1:
                user.change_pass(flight_file,user_file);
                break;

            // ------------ Search Flight ticket -------------
            case 2:
                flight.search_flight(flight_file,user_file);
                break;

            // ------------ Ticket Cancellation --------------
            case 3:

                ticket.ticket_cancel(flight_file,user_file);
                break;

            // -------------- Flight Schedules --------------
            case 4:
                flight.flight_schedules(flight_file,user_file,"passenger");
                break;


            // -------------- Booked Ticket ------------------
            case 5:
                ticket.booked(flight_file,user_file);
                break;

            // ---------------- Add Charge -------------------
            case 6:
                user.charge(flight_file,user_file);
                break;

            // ---------------- Sign out ---------------------
            case 0:
                Login login = new Login();
                login.menu_back(flight_file,user_file);
                break;



            default:

                System.out.println("\t\t\t\t\t\t\t\t\t\t\033[91m ==> Wrong choice <==\033[97m");
                System.out.print("\t\t\t\t\t\t\t\t\t\t\t\033[33mPlese try again\033[97m");
                passenger_menu_back(flight_file,user_file);
                break;


        }

    }

    private void passenger_menu_front(RandomAccessFile user_file) throws IOException {

        print_usernames(user_file);

        user_file.seek((Login.seek_user + Passenger_file.BITEWALLET));

        System.out.println("\n\n");
        try{Thread.sleep(500);}catch(InterruptedException e) {};
        System.out.println("\033[35m\t\t\t\t\t\t+--------------------------------+");
        try{Thread.sleep(80);}catch(InterruptedException e) {};
        System.out.println("\t\t\t\t\t\t|      " + "\033[36m˙˚ Passenger menu ˚˙" +"\033[35m      |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|                                |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.printf("\t\t\t\t\t\t|         wallet =>\033[97m %-,11d\033[35m  |\n", user_file.readInt());
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

        System.out.println("\t\t\t\t\t\t|     "+"\033[33m(4)\033[36m Flight Schedules"+"\033[35m       |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|                                |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|     "+"\033[33m(5)\033[36m Booked Ticket"+"\033[35m          |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|                                |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|     "+"\033[33m(6)\033[36m Add Charge"+"\033[35m             |");
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






    private void print_usernames(RandomAccessFile user_file) throws IOException
    {
        long user_counter =  user_file.length() / 84;

        System.out.println("\nuser counter : " + user_counter);
        System.out.println("user length : " + user_file.length());

        for (int i = 0; i < user_counter; i++)
        {
            user_file.seek(i*Passenger_file.BITESIZE+ Passenger_file.BITEWALLET);

            int wall = user_file.readInt();

            System.out.printf("\n(%d) name: %-8s\tpass: %-8s\t wallet: %-11s",i,read_file(user_file,i*Passenger_file.BITESIZE),
                    read_file(user_file,i*Passenger_file.BITESIZE + 40),wall);

        }
    }









}
