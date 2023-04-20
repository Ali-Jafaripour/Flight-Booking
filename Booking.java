import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author    Ali jafaripour
 * @Data     1402/01/09
 */

public class Booking {

    static Scanner reader = new Scanner(System.in);

    Passenger[] user = new Passenger[20];
    Flight[] flight_ary = new Flight[20];

    static int index_user;




//-------- welcome massage --------

    public void welcome()
    {
        new_user();
        new_flights();
        diffalt_flight();
        welcome_massage();

        menu_back(flight_ary,user);
    }

    //----------- new users --------
    void new_user()
    {
        for (int j = 0; j < user.length; j++)
        {
            user[j] = new Passenger();
        }
    }

    //----------- new  flights --------
    void new_flights()
    {
        for (int j = 0; j < flight_ary.length; j++)
        {
            flight_ary[j] = new Flight();
        }

    }


// ------------------------------------------ first menu -----------------------------------------

    public void menu_back(Flight[] flight_ary,Passenger[] user)
    {
       // print_usernames(user);



        menu_front();

        int num = reader.nextInt();

        clear();

        switch (num)
        {
            // ------------------- Sign in -------------------
            case 1:
                sign_in(flight_ary,user);
                break;

            // ------------------- Sign up --------------------
            case 2:
                add_back(flight_ary,user);
                break;

            default:

                System.out.println("\t\t\t\t\t\t\t\t\t\t\033[91m ==> Wrong choice <==\033[97m");
                System.out.print("\t\t\t\t\t\t\t\t\t\t\t\033[33mPlese try again\033[97m");
                menu_back(flight_ary,user);
                break;
        }

    }

    private void menu_front()
    {
        System.out.println("\n\n\n\n\n\n\n");
        try{Thread.sleep(500);}catch(InterruptedException e) {};
        System.out.println("\033[35m\t\t\t\t\t\t+-----------------------------+");
        try{Thread.sleep(80);}catch(InterruptedException e) {};
        System.out.println("\t\t\t\t\t\t|          " + "\033[36m˙˚ Menu ˚˙" +"\033[35m         |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t+-----------------------------+");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|                             |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|         " + "\033[33m(1)\033[36m Sign in"+"\033[35m         |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|                             |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|         "+"\033[33m(2)\033[36m Sign up"+"\033[35m         |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|                             |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t+-----------------------------+");
        try{Thread.sleep(80);}catch(InterruptedException e) {};
        System.out.print("\t\t\t\t\t\t==> ");

    }



//------------------------------------------  sign up -----------------------------------------
    /**
     * These methods for create account
     */
    private void add_back(Flight[] flight_ary,Passenger[] user)
    {
        //print_usernames(user);      // For Test

        add_front();

        // ----------------- username -------------------
        System.out.print("\t\t\t\t\t\tName ==> ");
        String username = reader.next();

        int flag  = check_username(user,username);

        if(flag ==1)
        {
            System.out.print("\n\t\t\t\t\t\t\t\033[91m  <<< This username used >>> ");
            try {Thread.sleep(2000);} catch (InterruptedException e) {};
            clear();
            add_back(flight_ary,user);
        }
        // ----------------- password --------------------
        System.out.print("\t\t\t\t\t\tPassword ==> ");
        String password = reader.next();

        clear();

        int count = complate_user(user);



        if(flag == 0)
        {
            user[count].setusername(username);
            user[count].setpassword(password);
            count++;
            System.out.print("\n\t\t\t\t\033[32m  <<< change Saved >>> ");
            try {Thread.sleep(1500);} catch (InterruptedException e) {};
            clear();
            menu_back(flight_ary,user);

        }

    }

    private  void add_front()
    {
        System.out.println("\n\n\n\n\n\n\n");
        try{Thread.sleep(500);}catch(InterruptedException e) {};
        System.out.println("\033[35m\t\t\t\t\t\t+----------------------------------------+");

        try{Thread.sleep(80);}catch(InterruptedException e) {};
        System.out.println("\t\t\t\t\t\t|   \033[36m ˙˚ Write your name & password ˚˙ " +"\033[35m   |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|                                        |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|      ˙˚ remember your Decision ˚˙      |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\033[35m\t\t\t\t\t\t+----------------------------------------+");
        try{Thread.sleep(80);}catch(InterruptedException e) {};


    }


//------------------------------------------  sign in -----------------------------------------
    /**
     * These methods for sing in
     */

    private void sign_in(Flight[] flight_ary,Passenger[] user)
    {
       // print_usernames(user);      // For Test



        sign_frant();

        // -------------- username -----------------
        System.out.print("\t\t\t\t\t\tName ==> ");
        String username = reader.next();
        if(username.equals("1"))
        {
            clear();
            menu_back(flight_ary,user);
        }

        int flag_name = check_username(user,username);


        if(flag_name == 0 && !username.toLowerCase().equals("admin"))
        {
            System.out.print("\n\n\n\t\t\t\t\033[91m  <<< Wrong Username >>> ");
            try {Thread.sleep(2000);} catch (InterruptedException e) {};
            clear();
            sign_in(flight_ary,user);
        }


        // -------------- password -----------------
        System.out.print("\t\t\t\t\t\tPassword ==> ");

        String password = reader.next();
        if(password.equals("1"))
        {
            clear();
            menu_back(flight_ary,user);
        }

        int[] check_pass = new int[2];
        check_pass = check_password(user,password);
        int flag_pass = check_pass[0];
        index_user = check_pass[1];

        if(flag_pass == 0 && !password.toLowerCase().equals("admin"))
        {
            System.out.print("\n\n\n\t\t\t\t\033[91m  <<< Wrong Password >>> ");
            try {Thread.sleep(2000);} catch (InterruptedException e) {};
            clear();
            sign_in(flight_ary,user);
        }

        clear();




        if(username.toLowerCase().equals("admin") && password.toLowerCase().equals("admin") )
        {
            Admin admin = new Admin();

            admin.admin_back(flight_ary,user);

        }

        if(flag_name == 1  && flag_pass == 1)
        {
            user[index_user].passenger_menu_back(flight_ary, user);
        }

    }

    private void sign_frant()
    {

        System.out.println("\n\n");
        try{Thread.sleep(500);}catch(InterruptedException e) {};
        System.out.println("\033[35m\t\t\t\t\t\t+----------------------------------------+");

        try{Thread.sleep(80);}catch(InterruptedException e) {};
        System.out.println("\t\t\t\t\t\t|   \033[36m˙˚ Write your name and password ˚˙" +"\033[35m   |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|                                        |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|             ˙˚ 1.exit ˚˙               |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\033[35m\t\t\t\t\t\t+----------------------------------------+");
        try{Thread.sleep(80);}catch(InterruptedException e) {};
    }








//-------------------------------------- Check username -------------------------------------
    /**
     * This method check username in aray of user
     */

    private  int  check_username(Passenger[] user,String username)
    {
        int flag =0;

        for (int i = 0; i < user.length; i++)
        {

            if(user[i].getusername() != null && user[i].getusername().equals(username) ||  username.toLowerCase().equals("admin"))
            {
                flag = 1;
            }

        }

        return flag;
    }

//-------------------------------------- Check username -------------------------------------
    /**
     * This method check password in aray of user
     */

    public  int[]  check_password(Passenger[] user,String password)
    {
        int[] flag_index = new int[2];


        for (int i = 0; i < user.length; i++)
        {
            if(user[i].getpassword() != null && user[i].getpassword().equals(password))
            {
                flag_index[0]= 1;
                flag_index[1] = i;

            }

        }

        return flag_index;
    }





//-------------------------------------- complete users -------------------------------------
    /**
     * This method find user of array Its null & return index of
     */

    private int complate_user(Passenger[] user)
    {
        int index = 0;

        for (int i = 0; i < user.length; i++)
        {
            if(user[i].getusername() == null)
            {
                index = i;
                break;
            }

        }

        return index;
    }


//------------------------------------------ welcome massage -------------------------------------

    private void welcome_massage()
    {
        clear();
        System.out.println("\n\n\n\n\n\n\n\n\n\n");

        System.out.println("\033[36m\t\t\t     ___                ____________ __                             ");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t     \\  \\     ____     /  /  _______|  |     ______  ___   ___   _____ _______");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t      \\  \\   /    \\   /  /|  ____   |  |    /  ____/  _  \\|    \\/    |   _____|");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t       \\  \\ /  /\\  \\ /  / |   __|   |  |   |  |   |  | |  |  |\\  /|  |    __|");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t        \\  V  /  \\  V  /  |  |______|  |___|  |___|  |_|  |  | \\/ |  |   |____");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t         \\___/    \\___/   |_________|_______\\______\\_____/|__|    |__|________|");


        System.out.println("\n\n\n\n\n\033[93m");

        System.out.println("\t\t\t ______             _    _              ______           _     _____ _      _        _       ");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t | ___ \\           | |  (_)             | ___ \\         | |   |_   _(_)    | |      | |      ");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t | |_/ / ___   ___ | | ___ _ __   __ _  | |_/ / ___  ___| |_    | |  _  ___| | _____| |_ ___ ");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t | ___ \\/ _ \\ / _ \\| |/ / | '_ \\ / _` | | ___ \\/ _ \\/ __| __|   | | | |/ __| |/ / _ \\ __/ __|");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t | |_/ / (_) | (_) |   <| | | | | (_| | | |_/ /  __/\\__ \\ |_    | | | | (__|   <  __/ |_\\__ \\");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t \\____/ \\___/ \\___/|_|\\_\\_|_| |_|\\__, | \\____/ \\___||___/\\__|   \\_/ |_|\\___|_|\\_\\___|\\__|___/");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t                                  __/ |                                                      ");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t                                 |___/                                                       ");
        try{Thread.sleep(80);}catch(InterruptedException e) {};





        try{Thread.sleep(1500);}catch(InterruptedException e) {};

        clear();
    }

//------------------------------------------ system clear -----------------------------------------

    public void clear()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


    //-----------------------------------  Set diffalt flight --------------------------------------
    /*
     * this method set tree flight id
     */
    private void diffalt_flight()
    {
        flight_ary[0].set_flight_id("WX-12");
        flight_ary[0].set_origin("Yazd");
        flight_ary[0].set_destantion("Tehran");
        flight_ary[0].set_data("1401-12-10");
        flight_ary[0].set_time("9:30");
        flight_ary[0].set_price(700000);
        flight_ary[0].set_seat(51);

        flight_ary[1].set_flight_id("WX-13");
        flight_ary[1].set_origin("Yazd");
        flight_ary[1].set_destantion("Shiraz");
        flight_ary[1].set_data("1401-12-8");
        flight_ary[1].set_time("8:30");
        flight_ary[1].set_price(400000);
        flight_ary[1].set_seat(72);

        flight_ary[2].set_flight_id("WX-14");
        flight_ary[2].set_origin("Yazd");
        flight_ary[2].set_destantion("Mashhad");
        flight_ary[2].set_data("1401-12-20");
        flight_ary[2].set_time("17:45");
        flight_ary[2].set_price(800000);
        flight_ary[2].set_seat(60);
    }





    public void print_usernames(Passenger[] user)
    {
        for (int i = 0; i < user.length; i++)
        {
            System.out.println( "username ("+i+") "+user[i].getusername()+"\tpass => "+user[i].getpassword());
        }
        System.out.println("\n\n\n\n");
    }



}
