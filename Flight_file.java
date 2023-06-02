import java.io.IOException;
import java.io.RandomAccessFile;

public class Flight_file extends  Data_base
{
    final static int BITESIZE  = 209;
    final static int BITEGIN  = 40;
    final static int BITEDES  = 80;
    final static int BITEDATA  = 120;
    final static int BITETIME  = 160;
    final static int BITEPRICE  = 200;
    final static int BITESEAT  = 204;
    final static int BOOKED  = 208;




    Ticket_file t = new Ticket_file();



    //-----------------------------------  Set default flight --------------------------------------

    /**
     * this method set tree flight id
     */
    protected void default_flight(RandomAccessFile flight_file) throws IOException
    {


        Write_file( flight_file , "WX-10" ,0);
        Write_file(flight_file , "YAZD" ,40 );
        Write_file(flight_file ,"TEHRAN",80);
        Write_file(flight_file , "1401-12-10"  ,120);
        Write_file( flight_file , "12:30" ,160);

        flight_file.seek(200);
        flight_file.writeInt(700000);

        flight_file.seek(204);
        flight_file.writeInt(51);

        flight_file.seek(208);
        flight_file.writeBoolean(false);



        Write_file( flight_file , "WX-11" ,209);
        Write_file(flight_file , "YAZD"  ,249 );
        Write_file(flight_file ,"SHIRAZ",289);
        Write_file(flight_file , "1401-12-8"  ,329);
        Write_file( flight_file , "18:40" ,369);

        flight_file.seek(409);
        flight_file.writeInt(400000);

        flight_file.seek(413);
        flight_file.writeInt(72);

        flight_file.seek(317);
        flight_file.writeBoolean(false);


        Write_file( flight_file , "WX-12" ,418);
        Write_file(flight_file , "YAZD" ,458 );
        Write_file(flight_file ,"MASHHAD",498);
        Write_file(flight_file , "1401-12-20"  ,538);
        Write_file( flight_file , "17:45" ,578);

        flight_file.seek(618);
        flight_file.writeInt(800000);

        flight_file.seek(622);
        flight_file.writeInt(60);

        flight_file.seek(626);
        flight_file.writeBoolean(false);


//

    }





//------------------------------------------------- Search Flight ticket -------------------------------------------------

    /**
     *  This method give for filter flight information,
     *  (price): you can filter in price range
     *  (seat) : it shows all the flights that
     *  have that amount of seat;
     * @param flight_file  array of flight from Flight class
     * @param user_file  array of user from Passenger class
     */
    protected void search_flight(RandomAccessFile flight_file, RandomAccessFile user_file) throws IOException
    {
        search_front();

        Passenger p = new Passenger();

        System.out.print("\t\t\t\t\t\t==> ");
        int num = reader.nextInt();

        switch (num)
        {
            // --------------------- Flight ID ----------------
            case 1 ->
            {
                System.out.print("\t\t\t\t\t\tflight_id ==> ");
                String flightid_filter = reader.next();
                clear();
                header_print();

                int flight_counter = (int) (flight_file.length()/BITESIZE);

                for (int i = 0; i < flight_counter; i++)
                {

                    if ( read_file(flight_file,i*BITESIZE).equals(flightid_filter.toUpperCase()))
                    {
                        mid_print(flight_file, i*BITESIZE);
                    }
                }
                end_print(flight_file,user_file);
            }


            // ------------------- Origins --------------------
            case 2 ->
            {
                System.out.print("\t\t\t\t\t\torigin ==> ");
                String origin = reader.next();
                clear();
                header_print();

                int flight_counter = (int) (flight_file.length()/BITESIZE);

                for (int i = 0; i < flight_counter; i++)
                {

                    if ( read_file(flight_file,i*BITESIZE + BITEGIN).equals(origin.toUpperCase()))
                    {
                        mid_print(flight_file, i*BITESIZE);
                    }
                }
                end_print(flight_file,user_file);
            }


            // ------------------- Destention ----------------
            case 3 ->
            {
                System.out.print("\t\t\t\t\t\tdestantion ==> ");
                String destantion = reader.next();
                clear();
                header_print();

                int flight_counter = (int) (flight_file.length()/BITESIZE);

                for (int i = 0; i < flight_counter; i++)
                {

                    if ( read_file(flight_file,i*BITESIZE + BITEDES).equals(destantion.toUpperCase()))
                    {
                        mid_print(flight_file, i*BITESIZE);
                    }
                }
                end_print(flight_file,user_file);
            }

            // --------------- Data ---------------
            case 4 ->
            {
                System.out.print("\t\t\t\t\t\tdata ==> ");
                String data = reader.next();
                clear();
                header_print();

                int flight_counter = (int) (flight_file.length()/BITESIZE);

                for (int i = 0; i < flight_counter; i++)
                {

                    if ( read_file(flight_file,i*BITESIZE + BITEDATA).equals(data.toUpperCase()))
                    {
                        mid_print(flight_file, i*BITESIZE);
                    }
                }
                end_print(flight_file,user_file);
            }


            // ------------------- time -----------------
            case 5 ->
            {
                System.out.print("\t\t\t\t\t\ttime ==> ");
                String time = reader.next();
                clear();
                header_print();

                int flight_counter = (int) (flight_file.length()/BITESIZE);

                for (int i = 0; i < flight_counter; i++)
                {
                    if ( read_file(flight_file,i*BITESIZE + BITETIME).equals(time.toUpperCase()))
                    {
                        mid_print(flight_file, i*BITESIZE);
                    }
                }
                end_print(flight_file,user_file);
            }

            // ------------------- price -----------------
            case 6 ->
            {
                System.out.print("\t\t\t\t\t\tLowest price ==> ");
                int low_price = reader.nextInt();
                System.out.print("\t\t\t\t\t\tMost price ==> ");
                int most_price = reader.nextInt();
                clear();
                header_print();

                int flight_counter = (int) (flight_file.length()/BITESIZE);

                for (int i = 0; i < flight_counter; i++)
                {
                    flight_file.seek(i*BITESIZE + BITEPRICE);

                    if (flight_file.readInt() >= low_price && flight_file.readInt() <= most_price)
                    {
                        mid_print(flight_file, i*BITESIZE);
                    }


                }
                end_print(flight_file,user_file);
            }


            // ------------------- seat -----------------
            case 7 ->
            {
                System.out.print("\t\t\t\t\t\tseat ==> ");
                int seat = reader.nextInt();
                clear();
                header_print();

                int flight_counter = (int) (flight_file.length()/BITESIZE);

                for (int i = 0; i < flight_counter; i++)
                {
                    flight_file.seek(i*BITESIZE + BITESEAT);

                    if (flight_file.readInt() != 0 && flight_file.readInt() >= seat)
                    {
                        mid_print(flight_file, i*BITESIZE);
                    }
                }
                end_print(flight_file,user_file);
            }

            // ------------------- exit -----------------
            case 8 -> {
                clear();
                p.passenger_menu_back(flight_file,user_file);
            }
            default -> {
                System.out.println("\t\t\t\t\t\t\t\t\t\t\033[91m ==> wrong choice <==\033[97m");
                System.out.print("\t\t\t\t\t\t\t\t\t\t\t\033[33mPlese try again\033[97m");
                search_flight(flight_file,user_file);
            }
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

    private void mid_print( RandomAccessFile flight_file , int seek) throws IOException
    {
        System.out.print("\033[35m\t\t\t\t\t");
        System.out.print("+---------------------------------------------------------------------------------------------+");
        try {Thread.sleep(80);} catch (InterruptedException e) {};

        flight_file.seek(seek + BITEPRICE);
        int price = flight_file.readInt();

        flight_file.seek(seek + BITESEAT);
        int seat = flight_file.readInt();

        System.out.print("\n\t\t\t\t\t");
        System.out.printf("|\033[97m    %-10s\033[35m|\033[97m    %-10s\033[35m|\033[97m    %-11s\033[35m|\033[97m %-12s\033[35m|\033[97m  %-9s\033[35m|\033[97m  %-10s\033[35m|\033[97m  %-4s\033[35m  ", read_file(flight_file,seek), read_file(flight_file,seek + BITEGIN), read_file(flight_file,seek + BITEDES), read_file(flight_file,seek + BITEDATA), read_file(flight_file,seek + BITETIME), price,seat);
        System.out.println("|");
        try {Thread.sleep(80);} catch (InterruptedException e) {};
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


    private void end_print(RandomAccessFile flight_file, RandomAccessFile user_file) throws IOException
    {
        System.out.print("\t\t\t\t\t");
        System.out.print("+---------------------------------------------------------------------------------------------+");

        System.out.println("\n\t\t\t\t\t Press something to go back");
        while (true)
        {
            String go_back = reader.next();
            clear();
            search_flight(flight_file, user_file);

            break;
        }
    }





//------------------------------------------------- Flight Schedules -------------------------------------------------
    /**
     *  This method check flight array and print
     *  flight array is not nall !!
     * @param flight_file  array of flight from Flight class
     * @param user_file  array of user from Passenger class
     */

    protected void flight_schedules(RandomAccessFile flight_file, RandomAccessFile user_file , String name) throws IOException
    {

        int flight_counter = (int) (flight_file.length()/BITESIZE);

        System.out.println("\n\n\n\n flight counter ==> "+ flight_counter +"\nflight lenght ==> "+flight_file.length()+"\n\n\n\n\n\n\n");

        System.out.print("\n\t\t\t\t\t\t\t\t\t\033[90m      << Flights List >>\033[97m\n");

        System.out.println("\033[35m");
        System.out.print("\t\t\t\t\t");
        System.out.print("+---------------------------------------------------------------------------------------------+");
        try{Thread.sleep(80);}catch(InterruptedException e) {};


        System.out.print("\n\t\t\t\t\t");
        System.out.printf("| %-1s| %-1s| %-1s| %-1s| %-1s| %-1s| %-1s|","\033[33m  Flight ID  \033[35m","\033[33m   Origins   \033[35m","\033[33m  Destention  \033[35m","\033[33m    Data    \033[35m","\033[33m   Time   \033[35m","\033[33m   Price   \033[35m","\033[33m Seats \033[35m");
        System.out.println();
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        for (int i = 0; i < flight_counter; i++)
        {
            String str = read_file(flight_file,i*BITESIZE);

            if(str.contains(TEMP))
            {}
            else {
                System.out.print("\033[35m\t\t\t\t\t");
                System.out.print("+---------------------------------------------------------------------------------------------+");
                try {Thread.sleep(80);} catch (InterruptedException e) {};

                int seek = i*BITESIZE;

                flight_file.seek(seek + BITEPRICE);
                int price = flight_file.readInt();

                flight_file.seek(seek + BITESEAT);
                int seat = flight_file.readInt();


                System.out.print("\n\t\t\t\t\t");

                System.out.printf("|\033[97m    %-10s\033[35m|\033[97m    %-10s\033[35m|\033[97m    %-11s\033[35m|\033[97m %-12s\033[35m|\033[97m   %-8s\033[35m|\033[97m  %,-10d\033[35m|\033[97m  % -4d\033[35m  "
                        , read_file(flight_file,seek), read_file(flight_file,seek + BITEGIN), read_file(flight_file,seek + BITEDES), read_file(flight_file,seek + BITEDATA), read_file(flight_file,seek + BITETIME), price,seat);
                System.out.println("|");
                try {Thread.sleep(80);} catch (InterruptedException e) {};
            }
        }

        System.out.print("\t\t\t\t\t");
        System.out.print("+---------------------------------------------------------------------------------------------+");

        System.out.println("\n\t\t\t\t\t Press something to go back");
        while(true)
        {
            String go_back = reader.next();
            clear();
            if(name.equals("passenger"))
            {
                Passenger p = new Passenger();
                p.passenger_menu_back(flight_file, user_file);
            }
            else {

                Admin a = new Admin();
                a.admin_back(flight_file, user_file);
            }

            break;
        }



    }





//-----------------------------------  Add flight --------------------------------------

    /**
     *  This method is for adding a flight
     */

    protected void add(RandomAccessFile flight_file,RandomAccessFile user_file) throws IOException
    {
        add_front();
        Admin a = new Admin();

        int seek = check_flights(flight_file) * BITESIZE;

        System.out.println("\n\n\t\t\t\t\t\t <<< " + seek + " >>>\n\n");


        // -------------- flight id -----------------
        System.out.print("\t\t\t\t\t\tflight_id ==> ");
        String flight_id = reader.next();
        if(flight_id.equals("1"))
        {
            clear();
            a.admin_back(flight_file,user_file);
        }

        Write_file(flight_file,flight_id.toUpperCase(),seek);


        // -------------- origin -----------------
        System.out.print("\t\t\t\t\t\torigin ==> ");
        String origin = reader.next();
        if(origin.equals("1"))
        {
            clear();
            a.admin_back(flight_file,user_file);
        }
        Write_file(flight_file,origin.toUpperCase(),seek + BITEGIN);


        // -------------- destination -----------------
        System.out.print("\t\t\t\t\t\tdestination ==> ");
        String destination = reader.next();
        if(destination.equals("1"))
        {
            clear();
            a.admin_back(flight_file, user_file);
        }
        Write_file(flight_file,destination.toUpperCase(),seek + BITEDES);

        // -------------- data -----------------
        System.out.print("\t\t\t\t\t\tdata ==> ");
        String data = reader.next();
        if(data.equals("1"))
        {
            clear();
            a.admin_back(flight_file, user_file);
        }
        Write_file(flight_file,data,seek + BITEDATA);

        // -------------- time -----------------
        System.out.print("\t\t\t\t\t\ttime ==> ");
        String time = reader.next();
        if(time.equals("1"))
        {
            clear();
            a.admin_back(flight_file,user_file);
        }

        Write_file(flight_file,time,seek + BITETIME);


        // -------------- price -----------------
        System.out.print("\t\t\t\t\t\tprice ==> ");
        int price = reader.nextInt();
        if(price == 1)
        {
            clear();
            a.admin_back(flight_file,user_file);
        }

        flight_file.seek(seek + BITEPRICE);
        flight_file.writeInt(price);


        // -------------- seat -----------------
        System.out.print("\t\t\t\t\t\tseat ==> ");
        int seat = reader.nextInt();
        if(seat == 1)
        {
            clear();
            a.admin_back( flight_file, user_file);
        }
        flight_file.seek(seek + BITESEAT);
        flight_file.writeInt(seat);

        flight_file.seek(seek + BOOKED);
        flight_file.writeBoolean(false);

        clear();

        try {Thread.sleep(500);} catch (InterruptedException e) {};
        System.out.print("\n\t\t\t\t\033[32m  <<< change Saved >>> ");
        try {Thread.sleep(1500);} catch (InterruptedException e) {};
        clear();
        a.admin_back( flight_file, user_file);
    }

    private void add_front()
    {
        System.out.println("\n\n");
        try{Thread.sleep(500);}catch(InterruptedException e) {};
        System.out.println("\033[35m\t\t\t\t\t\t+----------------------------------------+");

        try{Thread.sleep(80);}catch(InterruptedException e) {};
        System.out.println("\t\t\t\t\t\t|      \033[36m˙˚ Add flight information ˚˙" +"\033[35m      |");
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
     * @param flight_file  array of flight from Flight class
     * @param user_file  array of user from Passenger class
     */
    protected void update(RandomAccessFile flight_file,RandomAccessFile user_file) throws IOException
    {
        System.out.print("\n\n\t\t\t\t\t\t Flight id ==> ");
        String flight_id = reader.next();

        int[] check = check_flight_id(flight_file,flight_id.toUpperCase());

        int flag = check[0];
        int seek = check[1];


        if(flag == 0)
        {
            System.out.print("\n\n\n\t\t\t\t\t\033[91m  <<< Wrong Flight Id >>> ");
            try {Thread.sleep(2000);} catch (InterruptedException e) {};
            clear();
            update(flight_file,user_file);
        }
        else
        {
            clear();

            update_front1();

            ubdate1(flight_file,user_file,seek);

            clear();
        }

    }

    private void ubdate1(RandomAccessFile flight_file,RandomAccessFile user_file,int seek) throws IOException
    {
        System.out.print("\t\t\t\t\t\t==> ");
        int num1 = reader.nextInt();

        switch (num1)
        {
            // --------------------- Flight ID ----------------
            case 1:
                System.out.print("\t\t\t\t\t\tflight_id ==> ");
                String flight_id1 = reader.next();



                Write_file(flight_file,flight_id1,seek);

                ubdate1(flight_file,user_file,seek);
                break;



            // ------------------- Origins --------------------
            case 2:

                System.out.print("\t\t\t\t\t\torigin ==> ");
                String origin = reader.next();


                Write_file(flight_file,origin,seek + BITEGIN);
                ubdate1(flight_file,user_file,seek);
                break;

            // ------------------- Destention ----------------
            case 3:
                System.out.print("\t\t\t\t\t\tdestantion ==> ");
                String destantion = reader.next();


                Write_file(flight_file,destantion,seek + BITEDES);

                ubdate1(flight_file,user_file,seek);
                break;

            // --------------- Data ---------------
            case 4:
                System.out.print("\t\t\t\t\t\tdata ==> ");
                String data = reader.next();

                Write_file(flight_file,data,seek + BITEDATA);

                ubdate1(flight_file,user_file,seek);
                break;


            // ------------------- time -----------------
            case 5:
                System.out.print("\t\t\t\t\t\ttime ==> ");
                String time = reader.next();

                Write_file(flight_file,time,seek + BITETIME);

                ubdate1(flight_file,user_file,seek);
                break;


            // ------------------- price -----------------
            case 6:
                System.out.print("\t\t\t\t\t\tprice ==> ");
                int price = reader.nextInt();

                flight_file.seek(seek + BITEPRICE);
                flight_file.writeInt(price);

                ubdate1(flight_file,user_file,seek);
                break;


            // ------------------- seat -----------------
            case 7:
                System.out.print("\t\t\t\t\t\tseat ==> ");
                int seat = reader.nextInt();

                flight_file.seek(seek + BITESEAT);
                flight_file.writeInt(seat);

                ubdate1(flight_file,user_file,seek);
                break;

            // ------------------- exit -----------------
            case 8:
                clear();
                Admin a = new Admin();
                a.admin_back(flight_file,user_file);
                break;

            default:

                System.out.println("\t\t\t\t\t\t\t\t\t\t\033[91m ==> wrong choice <==\033[97m");
                System.out.print("\t\t\t\t\t\t\t\t\t\t\t\033[33mPlese try again\033[97m");
                ubdate1(flight_file,user_file,seek);
                break;


        }
    }


    private void update_front1()
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
     * @param flight_file  array of flight from Flight class
     * @param user  array of user from Passenger class
     */
    protected void remove(RandomAccessFile flight_file,RandomAccessFile user) throws IOException
    {
        remove_front();

        System.out.print("\t\t\t\t\t\tflight_id ==> ");
        String flight_remove = reader.next();
        if(flight_remove.equals("1"))
        {
            clear();
            Admin a = new Admin();
            a.admin_back(flight_file,user);
        }

        int flight_counter = (int) (flight_file.length()/BITESIZE);


        for (int i = 0; i < flight_counter; i++)
        {
            int seek = i * BITESIZE;
            flight_file.seek(seek + BOOKED);

            if( flight_file.readBoolean() == true)
            {
                System.out.print("\n\n\n\t\t\t\t\t\033[91m  <<< This Flight Was Bought >>> ");
                try {Thread.sleep(2000);} catch (InterruptedException e) {};
                clear();
                remove(flight_file,user);

            }
        }


        int[] check = check_flight_id(flight_file,flight_remove.toUpperCase());

        int flag = check[0];
        int seek = check[1];


        if(flag == 0)
        {
            System.out.print("\n\n\n\t\t\t\t\t\033[91m  <<< Wrong Flight Id >>> ");
            try {Thread.sleep(2000);} catch (InterruptedException e) {};
            clear();
            remove(flight_file,user);
        }
        else
        {
            clear();

            Write_file(flight_file, TEMP,seek);


            System.out.print("\n\t\t\t\t\033[32m  <<< change Saved >>> ");
            try {Thread.sleep(1500);} catch (InterruptedException e) {};
            clear();

            Admin a = new Admin();
            a.admin_back(flight_file,user);
        }
    }


    private void remove_front()
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




    //-----------------------------------  check flight ary --------------------------------------
    /**
     *  This method give a flight array
     *  and return index of first house of array is nall
     * @param flight_file  array of flight from Flight class
     */

    private int check_flights(RandomAccessFile flight_file) throws IOException
    {
        int flight_counter = (int) (flight_file.length()/BITESIZE);

        int seek = flight_counter ;
        for (int i = 0; i < flight_counter; i++)
        {
            if(read_file(flight_file,i*BITESIZE).contains(TEMP))
            {
                seek = i;
                break;
            }
        }

        return seek;
    }

    //-----------------------------------  check flight Id --------------------------------------
    /**
     *  This method give a flight array and id ;
     *  ( First ) it checks that the flight id is correct
     *  ( Second ) if its true return index of that flight id
     * @param flight_file  array of flight from Flight class
     *  @param id  flight id
     */

    private int[] check_flight_id(RandomAccessFile flight_file,String id) throws IOException
    {
        int[] flag = {0,0};


        int flight_counter = (int) (flight_file.length()/BITESIZE);

        for (int i = 0; i < flight_counter; i++)
        {
            if(read_file(flight_file,i*BITESIZE) .equals(id))
            {
                flag[0] = 1;
                flag[1] = i * BITESIZE ;
                break;
            }
        }

        return flag;
    }
}
