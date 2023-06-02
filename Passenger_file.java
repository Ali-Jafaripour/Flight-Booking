import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Passenger_file extends Data_base
{

    final static int BITESIZE  = 84;

    final static int BITEWALLET  = 80;



//-------------------------------------- Check username -------------------------------------
    /**
     * This method check username in aray of user
     */

    protected   int check_username(RandomAccessFile user_file, String user_name) throws IOException
    {
        int flag =0;


        long user_counter =  user_file.length() / BITESIZE;

        for (int i = 0; i < user_counter; i++)
        {
            String temp = read_file(user_file,i * BITESIZE);
            // System.out.println("\n read user name in check method : " + temp );
            if(user_name.equals(temp))
            {
                flag = 1;
            }

        }

        return flag;
    }

//-------------------------------------- Check password -------------------------------------
    /**
     * This method check password in aray of user
     */

    protected   int  check_password(RandomAccessFile user_file,String password) throws IOException
    {
        int flag =0;



        long user_counter =  user_file.length() / 84;

        for (int i = 0; i < user_counter; i++)
        {

            String temp = read_file(user_file,i * BITESIZE + 40);

            if(password.equals(temp))
            {
                flag = 1;
                Login.seek_user = i;

                System.out.println( "\n seek user : " + Login.seek_user);
            }

        }

        return flag;
    }







//------------------------------------------------- Change Password -------------------------------------------------
    /**
     *  This method give password if it's true ,can change it.
     * @param flight_file  array of flight from Flight class
     * @param user_file  array of user from Passenger class
     */

    protected void change_pass(RandomAccessFile flight_file, RandomAccessFile user_file) throws IOException
    {
        Passenger p = new Passenger();

        change_front();


        // -------------- password -----------------
        System.out.print("\t\t\t\t\t\tPassword ==> ");
        String password = reader.next();

        if(password.equals("1"))
        {
            clear();
            p.passenger_menu_back(flight_file,user_file);
        }


        int flag  = check_password(user_file, password);

        if(flag == 0)
        {
            System.out.print("\n\n\n\t\t\t\t\033[91m  <<< Wrong Password >>> ");
            try {Thread.sleep(2000);} catch (InterruptedException e) {};
            clear();
            change_pass(flight_file,user_file);
        }
        clear();

        System.out.print("\t\t\t\t\t\tNew Password ==> ");
        String new_password = reader.next();



        Write_file(user_file,new_password,Login.seek_user + (SIZAOFSRING*2));

        clear();
        System.out.print("\n\t\t\t\t\033[32m  <<< change Saved >>> ");
        try {Thread.sleep(1000);} catch (InterruptedException e) {};
        clear();
        p.passenger_menu_back(flight_file,user_file);

    }


    private void change_front()
    {
        System.out.println("\n\n");
        try{Thread.sleep(500);}catch(InterruptedException e) {};
        System.out.println("\033[35m\t\t\t\t\t\t+----------------------------------------+");

        try{Thread.sleep(80);}catch(InterruptedException e) {};
        System.out.println("\t\t\t\t\t\t|        \033[36m˙˚ Write your password ˚˙" +"\033[35m       |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|                                        |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|             ˙˚ 1.exit ˚˙               |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\033[35m\t\t\t\t\t\t+----------------------------------------+");
        try{Thread.sleep(80);}catch(InterruptedException e) {};
    }








//------------------------------------------------- Add Charge -------------------------------------------------

    protected void charge(RandomAccessFile flight_file, RandomAccessFile user_file) throws IOException
    {
        Passenger p = new Passenger();

        charge_front();
        System.out.print("\t\t\t\t\t\t==> ");
        int charge = reader.nextInt();

        if(charge == 1)
        {
            clear();
            p.passenger_menu_back(flight_file, user_file);
        }


        user_file.seek(Login.seek_user + BITEWALLET);
        int wallet =  user_file.readInt();

//        System.out.println("\n\t\t\t\t wallet: "+ wallet);

        user_file.seek(Login.seek_user + BITEWALLET);
        user_file.writeInt(wallet + charge);


        user_file.seek(Login.seek_user + BITEWALLET);
        int new_wallet =  user_file.readInt();

//        System.out.println("\n\t\t\t\t new wallet: "+ wallet);


        clear();
        System.out.print("\n\t\t\t\t\033[32m  <<< change Saved >>> ");
        try {Thread.sleep(1000);} catch (InterruptedException e) {};
        clear();
        p.passenger_menu_back(flight_file, user_file);

    }


    private void charge_front()
    {
        System.out.println("\n\n");
        try{Thread.sleep(500);}catch(InterruptedException e) {};
        System.out.println("\033[35m\t\t\t\t\t\t+---------------------------------------------+");

        try{Thread.sleep(80);}catch(InterruptedException e) {};
        System.out.println("\t\t\t\t\t\t|\033[36m˙˚ Write a mount of money to charge wallet ˚˙" +"\033[35m|");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|                                             |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|                ˙˚ 1.exit ˚˙                 |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\033[35m\t\t\t\t\t\t+---------------------------------------------+");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

    }






}
