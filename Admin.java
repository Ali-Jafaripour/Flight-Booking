import java.util.Scanner;
/**
 * @Author    Ali jafaripour
 * @Data     1402/01/13
 */
public class Admin
{


    Scanner reader = new Scanner(System.in);

    Booking sign_out  = new Booking();

    //-----------------------------------  admin menu --------------------------------------

    public void admin_back(Flight[] flight_ary,Passenger[] user)
    {
        print_usernames(user);

        admin_frant();

        int num = reader.nextInt();

        clear();

        switch (num) {
            // --------------------- add ----------------------
            case 1 -> add(flight_ary, user);


            // ------------------- Update --------------------
            case 2 -> update(flight_ary, user);


            // ------------------- remove --------------------
            case 3 -> remove(flight_ary, user);


            // --------------- Flight Schedules ---------------
            case 4 -> print_flight(flight_ary, user);


            // ------------------- sing out -----------------
            case 0 -> sign_out.menu_back(flight_ary,user);
            default -> {
                System.out.println("\t\t\t\t\t\t\t\t\t\t\033[91m ==> Rong choice <==\033[97m");
                System.out.print("\t\t\t\t\t\t\t\t\t\t\t\033[33mPlese try again\033[97m");
                admin_back(flight_ary, user);
            }
        }

    }

    private  void admin_frant()
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

        System.out.println("\t\t\t\t\t\t|       "+"\033[33m(2)\033[36m Update"+"\033[35m            |");
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

    /**
     *  This method is for adding a flight
     * @param flight_ary  array of flight from Flight class
     * @param user  array of user from Passenger class
     */

    private void add(Flight[] flight_ary,Passenger[] user)
    {
        add_frant();

        int index=check_flights(flight_ary);

        // -------------- flight id -----------------
        System.out.print("\t\t\t\t\t\tflight_id ==> ");
        String flight_id = reader.next();
        if(flight_id.equals("1"))
        {
            clear();
            admin_back(flight_ary,user);
        }
        flight_ary[index].set_flight_id(flight_id.toUpperCase());


        // -------------- origin -----------------
        System.out.print("\t\t\t\t\t\torigin ==> ");
        String origin = reader.next();
        if(origin.equals("1"))
        {
            clear();
            admin_back(flight_ary,user);
        }
        flight_ary[index].set_origin(origin);


        // -------------- destantion -----------------
        System.out.print("\t\t\t\t\t\tdestantion ==> ");
        String destantion = reader.next();
        if(destantion.equals("1"))
        {
            clear();
            admin_back(flight_ary,user);
        }
        flight_ary[index].set_destantion(destantion);

        // -------------- data -----------------
        System.out.print("\t\t\t\t\t\tdata ==> ");
        String data = reader.next();
        if(data.equals("1"))
        {
            clear();
            admin_back(flight_ary,user);
        }
        flight_ary[index].set_data(data);

        // -------------- time -----------------
        System.out.print("\t\t\t\t\t\ttime ==> ");
        String time = reader.next();
        if(time.equals("1"))
        {
            clear();
            admin_back(flight_ary,user);
        }
        flight_ary[index].set_time(time);


        // -------------- price -----------------
        System.out.print("\t\t\t\t\t\tprice ==> ");
        int price = reader.nextInt();
        if(price == 1)
        {
            clear();
            admin_back(flight_ary,user);
        }
        flight_ary[index].set_price(price);


        // -------------- seat -----------------
        System.out.print("\t\t\t\t\t\tseat ==> ");
        int seat = reader.nextInt();
        if(seat == 1)
        {
            clear();
            admin_back(flight_ary,user);
        }
        flight_ary[index].set_seat(seat);

        clear();

        try {Thread.sleep(500);} catch (InterruptedException e) {};
        System.out.print("\n\t\t\t\t\033[32m  <<< change Saved >>> ");
        try {Thread.sleep(1500);} catch (InterruptedException e) {};
        clear();
        admin_back(flight_ary,user);
    }

    private void add_frant()
    {
        System.out.println("\n\n");
        try{Thread.sleep(500);}catch(InterruptedException e) {};
        System.out.println("\033[35m\t\t\t\t\t\t+----------------------------------------+");

        try{Thread.sleep(80);}catch(InterruptedException e) {};
        System.out.println("\t\t\t\t\t\t|   \033[36m˙˚ Add flight information ˚˙" +"\033[35m   |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|                                        |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|             ˙˚ 1.exit ˚˙               |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\033[35m\t\t\t\t\t\t+----------------------------------------+");
        try{Thread.sleep(80);}catch(InterruptedException e) {};
    }

    //-----------------------------------  Update flight --------------------------------------
    /**
     *  This method give a flight id
     *  if it's true admin can Can edit any part of flight info
     * @param flight_ary  array of flight from Flight class
     * @param user  array of user from Passenger class
     */
    private void update(Flight[] flight_ary,Passenger[] user)
    {
        System.out.print("\n\n\t\t\t\t\t\t Flight id ==> ");
        String flight_id = reader.next();

        int[] check = check_flight_id(flight_ary,flight_id.toUpperCase());

        int flag = check[0];
        int index = check[1];


        if(flag == 0)
        {
            System.out.print("\n\n\n\t\t\t\t\t\033[91m  <<< Wrong Flight Id >>> ");
            try {Thread.sleep(2000);} catch (InterruptedException e) {};
            clear();
            update(flight_ary,user);
        }
        else
        {
            clear();

            update_frant1();

            ubdate1(flight_ary,user,index);

            clear();
        }

    }

    private void ubdate1(Flight[] flight_ary,Passenger[] user,int index)
    {
        System.out.print("\t\t\t\t\t\t==> ");
        int num1 = reader.nextInt();

        switch (num1)
        {
            // --------------------- Flight ID ----------------
            case 1:
                System.out.print("\t\t\t\t\t\tflight_id ==> ");
                String flight_id1 = reader.next();

                flight_ary[index].set_flight_id(flight_id1);
                ubdate1(flight_ary,user,index);
                break;



            // ------------------- Origins --------------------
            case 2:

                System.out.print("\t\t\t\t\t\torigin ==> ");
                String origin = reader.next();

                flight_ary[index].set_origin(origin);
                ubdate1(flight_ary,user,index);
                break;

            // ------------------- Destention ----------------
            case 3:
                System.out.print("\t\t\t\t\t\tdestantion ==> ");
                String destantion = reader.next();

                flight_ary[index].set_destantion(destantion);
                ubdate1(flight_ary,user,index);
                break;

            // --------------- Data ---------------
            case 4:
                System.out.print("\t\t\t\t\t\tdata ==> ");
                String data = reader.next();

                flight_ary[index].set_data(data);
                ubdate1(flight_ary,user,index);
                break;


            // ------------------- time -----------------
            case 5:
                System.out.print("\t\t\t\t\t\ttime ==> ");
                String time = reader.next();

                flight_ary[index].set_time(time);
                ubdate1(flight_ary,user,index);
                break;


            // ------------------- price -----------------
            case 6:
                System.out.print("\t\t\t\t\t\tprice ==> ");
                int price = reader.nextInt();

                flight_ary[index].set_price(price);
                ubdate1(flight_ary,user,index);
                break;


            // ------------------- seat -----------------
            case 7:
                System.out.print("\t\t\t\t\t\tseat ==> ");
                int seat = reader.nextInt();

                flight_ary[index].set_seat(seat);
                ubdate1(flight_ary,user,index);
                break;

            // ------------------- exit -----------------
            case 8:
                clear();
                admin_back(flight_ary,user);
                break;

            default:

                System.out.println("\t\t\t\t\t\t\t\t\t\t\033[91m ==> wrong choice <==\033[97m");
                System.out.print("\t\t\t\t\t\t\t\t\t\t\t\033[33mPlese try again\033[97m");
                ubdate1(flight_ary,user,index);
                break;


        }
    }


    private void update_frant1()
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

        System.out.println("\t\t\t\t\t\t|       " + "\033[33m(1)\033[36m Flight ID"+"\033[35m         |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|                             |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|       "+"\033[33m(2)\033[36m Origins"+"\033[35m           |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|                             |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|       "+"\033[33m(3)\033[36m Destention"+"\033[35m        |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|                             |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|       "+"\033[33m(4)\033[36m Data"+"\033[35m              |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|                             |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|       "+"\033[33m(5)\033[36m Time "+"\033[35m             |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|                             |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|       "+"\033[33m(6)\033[36m Price "+"\033[35m            |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|                             |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|       "+"\033[33m(7)\033[36m seat "+"\033[35m             |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|                             |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|       "+"\033[33m(8)\033[36m exit "+"\033[35m             |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};


        System.out.println("\t\t\t\t\t\t+-----------------------------+");
        try{Thread.sleep(80);}catch(InterruptedException e) {};
    }



    //-----------------------------------  Remove flight --------------------------------------
    /**
     *  This method give a flight id
     *  if it's true admin can Can delete that flight
     * @param flight_ary  array of flight from Flight class
     * @param user  array of user from Passenger class
     */
    private void remove(Flight[] flight_ary,Passenger[] user)
    {
        remove_frant();

        System.out.print("\t\t\t\t\t\tflight_id ==> ");
        String flight_remove = reader.next();
        if(flight_remove.equals("1"))
        {
            clear();
            admin_back(flight_ary,user);
        }

        int[] check = check_flight_id(flight_ary,flight_remove.toUpperCase());

        int flag = check[0];
        int index = check[1];


        if(flag == 0)
        {
            System.out.print("\n\n\n\t\t\t\t\t\033[91m  <<< Wrong Flight Id >>> ");
            try {Thread.sleep(2000);} catch (InterruptedException e) {};
            clear();
            remove(flight_ary,user);
        }
        else
        {
            clear();

            flight_ary[index].set_flight_id(null);

            System.out.print("\n\t\t\t\t\033[32m  <<< change Saved >>> ");
            try {Thread.sleep(1500);} catch (InterruptedException e) {};
            clear();
            admin_back(flight_ary,user);
        }
    }


    private void remove_frant()
    {
        System.out.println("\n\n");
        try{Thread.sleep(500);}catch(InterruptedException e) {};
        System.out.println("\033[35m\t\t\t\t\t\t+----------------------------------------+");

        try{Thread.sleep(80);}catch(InterruptedException e) {};
        System.out.println("\t\t\t\t\t\t| \033[36m˙˚ Add flight information  to remove˚˙" +"\033[35m |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|                                        |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|             ˙˚ 1.exit ˚˙               |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\033[35m\t\t\t\t\t\t+----------------------------------------+");
        try{Thread.sleep(80);}catch(InterruptedException e) {};
    }


    //-----------------------------------  Print flight --------------------------------------
    /**
     *  This method check flight array and print
     *  flight array is not nall !!
     * @param flight_ary  array of flight from Flight class
     * @param user  array of user from Passenger class
     */
    private void print_flight(Flight[] flight_ary,Passenger[] user)
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

            if(flight_ary[i].get_flight_id()!= null)
            {
                System.out.print("\033[35m\t\t\t\t\t");
                System.out.print("+---------------------------------------------------------------------------------------------+");
                try{Thread.sleep(80);}catch(InterruptedException e) {};


                System.out.print("\n\t\t\t\t\t");
                System.out.printf("|\033[97m    %-10s\033[35m|\033[97m    %-10s\033[35m|\033[97m    %-11s\033[35m|\033[97m %-12s\033[35m|\033[97m  %-9s\033[35m|\033[97m  %-10s\033[35m|\033[97m  %-4s\033[35m  ",flight_ary[i].get_flight_id(),flight_ary[i].get_origin(),flight_ary[i].get_destantion(),flight_ary[i].get_data(),flight_ary[i].get_time(),flight_ary[i].get_price(),flight_ary[i].get_seat());
                System.out.println("|");
                try{Thread.sleep(80);}catch(InterruptedException e) {};
            }
        }

        System.out.print("\t\t\t\t\t");
        System.out.print("+---------------------------------------------------------------------------------------------+");

        System.out.println("\t\t\t\t\t Press something to go back");
        while(true)
        {
            String go_back = reader.next();
            clear();
            admin_back(flight_ary,user);

            break;
        }



    }







    //-----------------------------------  check flight ary --------------------------------------
    /**
     *  This method give a flight array
     *  and return index of first house of array is nall
     * @param flight_ary  array of flight from Flight class
     */
    private int check_flights(Flight[] flight_ary)
    {
        int index = 0;

        for (int i = 0; i <flight_ary.length; i++)
        {
            if(flight_ary[i].get_flight_id()== null)
            {
                index = i;
                break;
            }
        }

        return index;
    }

    //-----------------------------------  check flight Id --------------------------------------
    /**
     *  This method give a flight array and id ;
     *  ( First ) it checks that the flight id is correct
     *  ( Second ) if its true return index of that flight id
     * @param flight_ary  array of flight from Flight class
     *  @param id  flight id
     */

    private int[] check_flight_id(Flight[] flight_ary,String id)
    {
        int[] flag = {0,0};

        for (int i = 0; i <flight_ary.length; i++)
        {
            if(flight_ary[i].get_flight_id() != null && flight_ary[i].get_flight_id().equals(id))
            {
                flag[0] = 1;
                flag[1] = i;
                break;
            }
        }

        return flag;
    }


    //------------------------------------------ system clear -----------------------------------------

    public  void clear()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
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
