import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Objects;

public class Ticket_file extends Data_base
{

    final static int BITESIZE  = 84;
    final static int BITEFLIGHTID  = 5;
    final static int BITEUSERID  = 45;




//------------------------------------------------- Ticket Cancellation -------------------------------------------------

    protected void ticket_cancel(RandomAccessFile flight_file, RandomAccessFile user_file) throws IOException
    {
        RandomAccessFile ticket_file = new RandomAccessFile("tickets.dat" , "rw");

        System.out.print("\t\t\t\t\t\tTicket id ==> ");
        int ticket_id= reader.nextInt();

        int ticket_counter = (int) (ticket_file.length()/BITESIZE);

        for (int i = 0; i < ticket_counter; i++)
        {
            int seek = i*BITESIZE;

            if ( ticket_file.readInt() == ticket_id)
            {
                ticket_file.seek(seek);
                ticket_file.write(0);
                // update seat
                String flight_id = read_file(ticket_file,seek + BITEFLIGHTID);
                int price = update_seat(flight_file,flight_id);

                // update money
                update_wallet( user_file, Login.seek_user,price);

                clear();
                System.out.print("\n\t\t\t\t\033[32m  <<< change Saved >>> ");
                try {Thread.sleep(1000);} catch (InterruptedException e) {};
                clear();

                Passenger p = new Passenger();
                p.passenger_menu_back(flight_file,user_file);
            }
        }

        clear();
        System.out.print("\n\n\n\t\t\t\t\033[91m  <<< Wrong Ticket id >>> ");
        try {Thread.sleep(1500);} catch (InterruptedException e) {};
        clear();
        Passenger p = new Passenger();
        p.passenger_menu_back(flight_file,user_file);

        ticket_file.close();
    }

    private void update_wallet(RandomAccessFile userFile, int seekUser, int price) throws IOException
    {
        userFile.seek(seekUser + Passenger_file.BITEWALLET);
        int wallet = userFile.readInt();

        userFile.seek(seekUser + Passenger_file.BITEWALLET);
        userFile.write(wallet + price);

    }

    private int update_seat(RandomAccessFile file, String flight_id) throws IOException
    {
        int prc = 0;

        int flight_counter = (int) (file.length() / Flight_file.BITESIZE);

        for (int i = 0; i < flight_counter; i++)
        {
            int seek = (i * Flight_file.BITESIZE);

            if (Objects.equals(read_file(file, seek), flight_id))
            {
                file.seek(seek + Flight_file.BITESEAT);
                int seat = file.readInt();

                file.seek(seek + Flight_file.BITESEAT);
                file.write(seat+1);

                file.seek(seek + Flight_file.BITEPRICE);
                prc = file.readInt();
                return prc;
            }


        }

        return prc;
    }



//------------------------------------------------- Booked Ticket -------------------------------------------------

    protected void booked(RandomAccessFile flight_file, RandomAccessFile user_file) throws IOException
    {

        RandomAccessFile ticket_file = new RandomAccessFile("tickets.dat" , "rw");
        booked_front();
        // -------------- flight id -----------------

        System.out.print("\t\t\t\t\t\tFlight id ==> ");
        String flight_id = reader.next();

        if(flight_id.equals("1"))
        {
            clear();
            Passenger p = new Passenger();
            p.passenger_menu_back(flight_file, user_file);
        }

        int[] check_flight = new int[2];

        check_flight = check_flight_id(flight_file,flight_id.toUpperCase());


        int flag = check_flight[0];
        int seek = check_flight[1];

        if(flag == 0)
        {
            System.out.print("\n\n\n\t\t\t\t\033[91m  <<< Wrong Flight id >>> ");
            try {Thread.sleep(2000);} catch (InterruptedException e) {};
            clear();
            booked(flight_file, user_file);
        }
        clear();

        flight_file.seek(seek + Flight_file.BITESEAT);

        if(flight_file.readInt() == 0)
        {
            System.out.print("\n\n\n\t\t\t\t\t\033[91m  <<< Flight seat is full >>> ");
            try {Thread.sleep(2500);} catch (InterruptedException e) {};
            clear();
            booked(flight_file, user_file);
        }

        flight_file.seek(seek + Flight_file.BITEPRICE);

        user_file.seek(Login.seek_user  + Passenger_file.BITEWALLET);

        if(flight_file.readInt() >= user_file.readInt())
        {
            System.out.print("\n\n\n\t\t\t\t\t\033[91m  <<< There is not enough stock >>> ");
            try {Thread.sleep(2500);} catch (InterruptedException e) {};
            clear();
            booked(flight_file, user_file);
        } else {


            flight_file.seek(seek + Flight_file.BITEPRICE);
            int price = flight_file.readInt();

            flight_file.seek(seek + Flight_file.BITESEAT);
            int seat = flight_file.readInt()-1;
            flight_file.seek(seek + Flight_file.BITESEAT);
            flight_file.writeInt(seat);

            user_file.seek(Login.seek_user  + Passenger_file.BITEWALLET);
            int stock = user_file.readInt();



            int new_stock = (stock - price);

            user_file.seek(Login.seek_user + Passenger_file.BITEWALLET);
            user_file.writeInt(new_stock);


        }

        String user_id = read_file(user_file,Login.seek_user );
        int id_tickeet = make_ticket(ticket_file,flight_id,user_id);

        while (true)
        {
            System.out.printf("\n\n\n\t\t\t\t\t\033[32m  <<< Your ticket id : ˙˚\033[33m%10d \033[32m˚˙ >>> \n"
                    , id_tickeet);

            String go_back = reader.next();
            clear();
            Passenger p = new Passenger();
            p.passenger_menu_back(flight_file, user_file);

            break;
        }

        ticket_file.close();
    }

    private int make_ticket(RandomAccessFile ticket_file, String flightId, String userId) throws IOException
    {
        int ticket_counter = (int) (ticket_file.length()/BITESIZE);

        int fill_seek = ticket_counter +1;

        for (int i = 0; i < ticket_counter; i++)
        {
            int seek = i*BITESIZE;

            if ( ticket_file.readInt() == 0)
            {
                fill_seek = seek;
                break;
            }
        }

        Ticket id = new Ticket();
        ticket_file.seek(fill_seek);
        ticket_file.write(id.ticketId);

        return id.ticketId;
    }


    /**
     * check flight array to find that flight id
     * if there was flag will be 1 and index of;
     * @return flag & index (1 = true),(0 = false)
     */
    protected   int[] check_flight_id(RandomAccessFile flight_file , String flight_id) throws IOException {
        int[] flag_seek = {0,0};

        int flight_counter = (int) (flight_file.length() / Flight_file.BITESIZE);
//        System.out.println("/n flight counter: "+ flight_counter);

        for (int i = 0; i < flight_counter; i++)
        {
            // System.out.printf("\nflight id read: %-8s\tflight id check: %10s\n",read_file(flight_file, i * Flight_file.BITESIZE),flight_id);

            if(read_file(flight_file, i * Flight_file.BITESIZE).equals(flight_id))
            {
                flag_seek[0] = 1;
                flag_seek[1] = i * Flight_file.BITESIZE;
                break;
            }
        }

        return flag_seek;
    }

    private void booked_front()
    {
        System.out.println("\n\n");
        try{Thread.sleep(500);}catch(InterruptedException e) {};
        System.out.println("\033[35m\t\t\t\t\t\t+----------------------------------------+");

        try{Thread.sleep(80);}catch(InterruptedException e) {};
        System.out.println("\t\t\t\t\t\t|  \033[36m˙˚ Write your cosidered flight id ˚˙" +"\033[35m  |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|                                        |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\t\t\t\t\t\t|             ˙˚ 1.exit ˚˙               |");
        try{Thread.sleep(80);}catch(InterruptedException e) {};

        System.out.println("\033[35m\t\t\t\t\t\t+----------------------------------------+");
        try{Thread.sleep(80);}catch(InterruptedException e) {};
    }




}
