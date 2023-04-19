import java.util.Scanner;

public class Passenger
{
    private String username;

    private String password;

    private int  wallet = 0;

    Scanner reader = new Scanner(System.in);

    Booking sign_in  = new Booking();

    int index_user = sign_in.index_pass;


//-------------   Getter  ----------------

    public String getusername()
    {
        return username;
    }

    public String getpassword()
    {
        return password;
    }

    public int getwallet()
    {
        return wallet;
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

    public void setwallet(int wallet)
    {
        this.wallet = wallet;
    }


//------------------------------------------------- passenger menu -------------------------------------------------

    public void passenger_menu_back(Flight[] flight_ary,Passenger[] user)
    {
        passenger_menu_frant(user);
        int num = reader.nextInt();

        clear();

        switch (num)
        {
            // ------------- Change Password ---------------
            case 1:
                change_pass(flight_ary,user);
                break;

            // ------------ Search Flight ticket -------------
            case 2:
                search_flight_id(flight_ary,user);
                break;

            // ------------ Ticket Cancellation --------------
            case 3:
                ticket(flight_ary,user);
                break;

            // -------------- Flight Schedules --------------
            case 4:
                flight_schedules(flight_ary,user);
                break;


            // -------------- Booked Ticket ------------------
            case 5:
                booked(flight_ary,user);
                break;

            // ---------------- Add Charge -------------------
            case 6:
                charge(flight_ary,user);
                break;

            // ---------------- Sign out ---------------------
            case 0:
                sign_in.menu_back(flight_ary,user);
                break;



            default:

                System.out.println("\t\t\t\t\t\t\t\t\t\t\033[91m ==> Wrong choice <==\033[97m");
                System.out.print("\t\t\t\t\t\t\t\t\t\t\t\033[33mPlese try again\033[97m");
                passenger_menu_back(flight_ary, user);
                break;


        }

    }

    private void passenger_menu_frant(Passenger[] user)
    {
        System.out.println("\n\n");
        try{Thread.sleep(500);}catch(InterruptedException e) {};
        System.out.println("\033[35m\t\t\t\t\t\t+--------------------------------+");
        try{Thread.sleep(80);}catch(InterruptedException e) {};
        System.out.println("\t\t\t\t\t\t|      " + "\033[36m˙˚ Passenger menu ˚˙" +"\033[35m      |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|                                |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.printf("\t\t\t\t\t\t|         wallet =>\033[97m %-,11d\033[35m  |\n",user[index_user].getwallet());
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







//------------------------------------------------- Change Password -------------------------------------------------
    /**
     *  This method give password if its true ,can change it.
     * @param flight_ary  array of flight from Flight class
     * @param user  array of user from Passenger class
     */

    private void change_pass(Flight[] flight_ary, Passenger[] user)
    {
        change_front();


        // -------------- password -----------------
        System.out.print("\t\t\t\t\t\tPassword ==> ");
        String password = reader.next();

        if(password.equals("1"))
        {
            clear();
            passenger_menu_back(flight_ary,user);
        }

        int[] check_pass = new int[2];
        check_pass = sign_in.check_password(user, password);
        int flag = check_pass[0];

        if(flag== 0)
        {
            System.out.print("\n\n\n\t\t\t\t\033[91m  <<< Wrong Password >>> ");
            try {Thread.sleep(2000);} catch (InterruptedException e) {};
            clear();
            change_pass(flight_ary, user);
        }
        clear();

        System.out.print("\t\t\t\t\t\tNew Password ==> ");
        String new_password = reader.next();

        user[index_user].setpassword(new_password);

        clear();
        System.out.print("\n\t\t\t\t\033[32m  <<< change Saved >>> ");
        try {Thread.sleep(1500);} catch (InterruptedException e) {};
        clear();
        passenger_menu_back(flight_ary,user);

    }


    private void change_front()
    {
        System.out.println("\n\n");
        try{Thread.sleep(500);}catch(InterruptedException e) {};
        System.out.println("\033[35m\t\t\t\t\t\t+----------------------------------------+");

        try{Thread.sleep(80);}catch(InterruptedException e) {};
        System.out.println("\t\t\t\t\t\t|      \033[36m˙˚ Write your password ˚˙" +"\033[35m    |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|                                        |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|             ˙˚ 1.exit ˚˙               |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\033[35m\t\t\t\t\t\t+----------------------------------------+");
        try{Thread.sleep(80);}catch(InterruptedException e) {};
    }


//------------------------------------------------- Search Flight ticket -------------------------------------------------

    private void search_flight_id(Flight[] flight_ary, Passenger[] user)
    {
        search_front();
        System.out.print("\t\t\t\t\t\t==> ");
        int num = reader.nextInt();

        switch (num)
        {
            // --------------------- Flight ID ----------------
            case 1:
                System.out.print("\t\t\t\t\t\tflight_id ==> ");
                String flightid_filter = reader.next();
                clear();

                header_print();

                for (int i = 0; i < flight_ary.length; i++)
                {
                    if(flight_ary[i].get_flight_id() != null  &&  flight_ary[i].get_flight_id().equals(flightid_filter.toUpperCase()))
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

                end_print(flight_ary, user);





                break;



            // ------------------- Origins --------------------
            case 2:

                System.out.print("\t\t\t\t\t\torigin ==> ");
                String origin = reader.next();
                clear();
                header_print();

                for (int i = 0; i < flight_ary.length; i++)
                {
                    if(flight_ary[i].get_origin() != null  &&  flight_ary[i].get_origin().equals(origin))
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

                end_print(flight_ary, user);

                break;

            // ------------------- Destention ----------------
            case 3:
                System.out.print("\t\t\t\t\t\tdestantion ==> ");
                String destantion = reader.next();
                clear();

                header_print();

                for (int i = 0; i < flight_ary.length; i++)
                {
                    if(flight_ary[i].get_destantion() != null  &&  flight_ary[i].get_flight_id().equals(destantion))
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

                end_print(flight_ary, user);




                break;

            // --------------- Data ---------------
            case 4:
                System.out.print("\t\t\t\t\t\tdata ==> ");
                String data = reader.next();
                clear();

                header_print();

                for (int i = 0; i < flight_ary.length; i++)
                {
                    if(flight_ary[i].get_data() != null  &&  flight_ary[i].get_data().equals(data))
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

                end_print(flight_ary, user);


                break;


            // ------------------- time -----------------
            case 5:
                System.out.print("\t\t\t\t\t\ttime ==> ");
                String time = reader.next();
                clear();

                header_print();
                for (int i = 0; i < flight_ary.length; i++)
                {
                    if(flight_ary[i].get_time() != null  &&  flight_ary[i].get_time().equals(time))
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
                end_print(flight_ary, user);



                break;


            // ------------------- price -----------------
            case 6:
                System.out.print("\t\t\t\t\t\tLowest price ==> ");
                int low_price = reader.nextInt();
                System.out.print("\t\t\t\t\t\tMost price ==> ");
                int most_price = reader.nextInt();

                clear();
                header_print();
                for (int i = 0; i < flight_ary.length; i++)
                {
                    if(flight_ary[i].get_price() >= low_price  &&  flight_ary[i].get_price() <= most_price)
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

                end_print(flight_ary, user);


                break;


            // ------------------- seat -----------------
            case 7:
                System.out.print("\t\t\t\t\t\tseat ==> ");
                int seat = reader.nextInt();
                clear();

                header_print();
                for (int i = 0; i < flight_ary.length; i++)
                {
                    if(flight_ary[i].get_seat() != 0  &&  flight_ary[i].get_seat() >= seat)
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
                end_print(flight_ary, user);



                break;

            // ------------------- exit -----------------
            case 8:
                clear();
                passenger_menu_back(flight_ary,user);
                break;

            default:

                System.out.println("\t\t\t\t\t\t\t\t\t\t\033[91m ==> wrong choice <==\033[97m");
                System.out.print("\t\t\t\t\t\t\t\t\t\t\t\033[33mPlese try again\033[97m");
                search_flight_id(flight_ary, user);
                break;


        }

    }


    private void search_front()
    {
        System.out.println("\n\n");
        try{Thread.sleep(500);}catch(InterruptedException e) {};
        System.out.println("\033[35m\t\t\t\t\t\t+-----------------------------+");
        try{Thread.sleep(80);}catch(InterruptedException e) {};
        System.out.println("\t\t\t\t\t\t|      " + "\033[36m˙˚ Passenger menu ˚˙" +"\033[35m   |");
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


    private void header_print()
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



    }


    private void end_print(Flight[] flight_ary, Passenger[] user)
    {
        System.out.print("\t\t\t\t\t");
        System.out.print("+---------------------------------------------------------------------------------------------+");

        System.out.println("\t\t\t\t\t Press something to go back");
        while(true)
        {
            String go_back = reader.next();
            clear();
            passenger_menu_back(flight_ary, user);

            break;
        }
    }


//------------------------------------------------- Ticket Cancellation -------------------------------------------------

    private void ticket(Flight[] flight_ary, Passenger[] user)
    {

    }


//------------------------------------------------- Flight Schedules -------------------------------------------------
    /**
     *  This method check flight array and print
     *  flight array is not nall !!
     * @param flight_ary  array of flight from Flight class
     * @param user  array of user from Passenger class
     */

    private void flight_schedules(Flight[] flight_ary, Passenger[] user)
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
            passenger_menu_back(flight_ary, user);

            break;
        }



    }

//------------------------------------------------- Booked Ticket -------------------------------------------------

    private void booked(Flight[] flight_ary, Passenger[] user)
    {

    }

//------------------------------------------------- Add Charge -------------------------------------------------

    private void charge(Flight[] flight_ary, Passenger[] user)
    {
        charge_front();
        System.out.print("\t\t\t\t\t\t==> ");
        int charge = reader.nextInt();

        if(charge == 1)
        {
            clear();
            passenger_menu_back(flight_ary, user);
        }

        user[index_user].setwallet(charge);

        clear();
        System.out.print("\n\t\t\t\t\033[32m  <<< change Saved >>> ");
        try {Thread.sleep(1500);} catch (InterruptedException e) {};
        clear();
        passenger_menu_back(flight_ary,user);

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









//------------------------------------------ system clear -----------------------------------------



    public  void clear()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
