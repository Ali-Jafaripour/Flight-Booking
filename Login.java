import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * @Author    Ali jafaripour
 * @Data     1402/01/09
 */

public class Login extends Passenger_file {

    static Scanner reader = new Scanner(System.in);



    static int seek_user;





//----------  welcome massage ------------

    public void welcome() throws IOException {

        RandomAccessFile user_file = new RandomAccessFile("user.dat" , "rw");

        RandomAccessFile flight_file = new RandomAccessFile("flight.dat" , "rw");

        RandomAccessFile ticket_file = new RandomAccessFile("tickets.dat" , "rw");
        ticket_file.close();

        Flight_file f = new Flight_file();
        f.default_flight(flight_file);

        welcome_massage();

        menu_back(flight_file,user_file);
    }




// ------------------------------------------ first menu -----------------------------------------

    public void menu_back(RandomAccessFile flight_file,RandomAccessFile user_file) throws IOException {

        System.out.println("\n");
        print_usernames(user_file);      // For Test
        System.out.println();

        menu_front();

        int num = reader.nextInt();

        clear();

        switch (num) {
            // ------------------- Sign in -------------------
            case 1 -> sign_in(flight_file, user_file);


            // ------------------- Sign up --------------------
            case 2 -> add_back(flight_file, user_file);
            default -> {
                System.out.println("\t\t\t\t\t\t\t\t\t\t\033[91m ==> Wrong choice <==\033[97m");
                System.out.print("\t\t\t\t\t\t\t\t\t\t\t\033[33mPlese try again\033[97m");
                menu_back(flight_file, user_file);
            }
        }

    }

    private void menu_front()
    {
        System.out.println("\n\n\n\n\n\n\n");
        try{Thread.sleep(500);}catch(InterruptedException ignored) {}

        System.out.println("\033[35m\t\t\t\t\t\t+-----------------------------+");
        try{Thread.sleep(500);}catch(InterruptedException ignored) {}

        System.out.println("\t\t\t\t\t\t|          " + "\033[36m˙˚ Menu ˚˙" +"\033[35m         |");
        try{Thread.sleep(500);}catch(InterruptedException ignored) {}

        System.out.println("\t\t\t\t\t\t+-----------------------------+");
        try{Thread.sleep(500);}catch(InterruptedException ignored) {}

        System.out.println("\t\t\t\t\t\t|                             |");
        try{Thread.sleep(500);}catch(InterruptedException ignored) {}

        System.out.println("\t\t\t\t\t\t|         " + "\033[33m(1)\033[36m Sign in"+"\033[35m         |");
        try{Thread.sleep(500);}catch(InterruptedException ignored) {}

        System.out.println("\t\t\t\t\t\t|                             |");
        try{Thread.sleep(500);}catch(InterruptedException ignored) {}

        System.out.println("\t\t\t\t\t\t|         "+"\033[33m(2)\033[36m Sign up"+"\033[35m         |");
        try{Thread.sleep(500);}catch(InterruptedException ignored) {}

        System.out.println("\t\t\t\t\t\t|                             |");
        try{Thread.sleep(500);}catch(InterruptedException ignored) {}

        System.out.println("\t\t\t\t\t\t+-----------------------------+");
        try{Thread.sleep(500);}catch(InterruptedException ignored) {}
        System.out.print("\t\t\t\t\t\t==> ");

    }



//------------------------------------------  sign up -----------------------------------------
    /**
     * These methods for create account
     */
    private void add_back(RandomAccessFile flight_file,RandomAccessFile user_file) throws IOException
    {
        System.out.println("\n");
        print_usernames(user_file);      // For Test
        System.out.println();
        add_front();

        // ----------------- username -------------------
        System.out.print("\t\t\t\t\t\tName ==> ");
        String username = reader.next();

        int flag  = check_username(user_file,username);

        if(flag ==1)
        {
            System.out.print("\n\t\t\t\t\t\t\t\033[91m  <<< This username used >>> ");
            try {Thread.sleep(2000);} catch (InterruptedException ignored) {}
            clear();
            add_back(flight_file,user_file);
        }
        // ----------------- password --------------------
        System.out.print("\t\t\t\t\t\tPassword ==> ");
        String password = reader.next();

        clear();

        long user_counter =  user_file.length() / 84;

        long seek = (user_counter * 84);

        if(flag == 0)
        {

            Write_file(user_file,username,seek);
            Write_file(user_file,password,seek + (SIZAOFSRING*2) );
            user_file.seek(seek + BITEWALLET);
            user_file.writeInt(0);



            System.out.print("\n\t\t\t\t\033[32m  <<< change Saved >>> ");
            try {Thread.sleep(1500);} catch (InterruptedException ignored) {}
            clear();
            menu_back(flight_file,user_file);

        }
        else {

            System.out.println(" Don't Write");
        }

    }

    private  void add_front()
    {
        System.out.println("\n\n\n\n\n\n\n");
        try{Thread.sleep(500);}catch(InterruptedException ignored) {}
        System.out.println("\033[35m\t\t\t\t\t\t+----------------------------------------+");

        try{Thread.sleep(80);}catch(InterruptedException ignored) {}
        System.out.println("\t\t\t\t\t\t|   \033[36m ˙˚ Write your name & password ˚˙ " +"\033[35m   |");
        try{Thread.sleep(80);}catch(InterruptedException ignored) {}

        System.out.println("\t\t\t\t\t\t|                                        |");
        try{Thread.sleep(80);}catch(InterruptedException ignored) {}

        System.out.println("\t\t\t\t\t\t|      ˙˚ remember your Decision ˚˙      |");
        try{Thread.sleep(80);}catch(InterruptedException ignored) {}

        System.out.println("\033[35m\t\t\t\t\t\t+----------------------------------------+");
        try{Thread.sleep(80);}catch(InterruptedException ignored) {}


    }


//------------------------------------------  sign in -----------------------------------------
    /**
     * These methods for sing in
     */
    private void sign_in(RandomAccessFile flight_file,RandomAccessFile user_file) throws IOException
    {
        System.out.println("\n");
        print_usernames(user_file);      // For Test
        System.out.println();

        sign_front();

        // -------------- username -----------------
        System.out.print("\t\t\t\t\t\tName ==> ");
        String username = reader.next();

        if(username.equals("1"))
        {
            clear();
            menu_back(flight_file,user_file);
        }

        int flag_name = check_username(user_file,username);

        if(flag_name == 0 && !username.equalsIgnoreCase("admin"))
        {
            System.out.print("\n\n\n\t\t\t\t\033[91m  <<< Wrong Username >>> ");
            try {Thread.sleep(2000);} catch (InterruptedException ignored) {}
            clear();
            sign_in(flight_file,user_file);
        }


        // -------------- password -----------------
        System.out.print("\t\t\t\t\t\tPassword ==> ");

        String password = reader.next();
        if(password.equals("1"))
        {
            clear();
            menu_back(flight_file,user_file);
        }

        int flag_pass;
        flag_pass = check_password(user_file,password);


        if(flag_pass == 0 && !password.equalsIgnoreCase("admin"))
        {
            System.out.print("\n\n\n\t\t\t\t\033[91m  <<< Wrong Password >>> ");
            try {Thread.sleep(2000);} catch (InterruptedException ignored) {}
            clear();
            sign_in(flight_file,user_file);
        }

        clear();




        if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin") )
        {
            Admin admin = new Admin();

            admin.admin_back(flight_file,user_file);

        }

        if(flag_name == 1  && flag_pass == 1)
        {
            Passenger p = new Passenger();
            p.passenger_menu_back(flight_file,user_file);
        }

    }

    private void sign_front()
    {

        System.out.println("\n\n");
        try{Thread.sleep(500);}catch(InterruptedException ignored) {}
        System.out.println("\033[35m\t\t\t\t\t\t+----------------------------------------+");

        try{Thread.sleep(80);}catch(InterruptedException ignored) {}
        System.out.println("\t\t\t\t\t\t|   \033[36m˙˚ Write your name and password ˚˙" +"\033[35m   |");
        try{Thread.sleep(80);}catch(InterruptedException ignored) {}

        System.out.println("\t\t\t\t\t\t|                                        |");
        try{Thread.sleep(80);}catch(InterruptedException ignored) {}

        System.out.println("\t\t\t\t\t\t|             ˙˚ 1.exit ˚˙               |");
        try{Thread.sleep(80);}catch(InterruptedException ignored) {}

        System.out.println("\033[35m\t\t\t\t\t\t+----------------------------------------+");
        try{Thread.sleep(80);}catch(InterruptedException ignored) {}
    }




//------------------------------------------ welcome massage -------------------------------------

    private void welcome_massage()
    {
        clear();

        System.out.println("\n\n\n\n");


        System.out.println("\t\t\033[36m                      _  _                                                                                                             _ .");
        try{Thread.sleep(80);}catch(InterruptedException ignored) {}
        System.out.println("\t\t                     ( `   )_                                                                                                         (  _ )_");
        try{Thread.sleep(80);}catch(InterruptedException ignored) {}
        System.out.println("\t\t                    (    )    `)                                                                                                     (_  _(_ ,)");
        try{Thread.sleep(80);}catch(InterruptedException ignored) {}
        System.out.println("\t\t                  (_   (_ .  _) _)                                       \033[97m        | \033[36m                            _");
        try{Thread.sleep(80);}catch(InterruptedException ignored) {}
        System.out.println("\t\t                                                                   \033[97m      --======|======--  \033[36m                  (  )");
        try{Thread.sleep(80);}catch(InterruptedException ignored) {}
        System.out.println("\t\t                                                                    \033[97m             |         \033[36m                ( `  ) . )");
        try{Thread.sleep(80);}catch(InterruptedException ignored) {}
        System.out.println("\t\t                                                                      \033[97m           |         \033[36m               (_, _(  ,_)_)");
        try{Thread.sleep(80);}catch(InterruptedException ignored) {}
        System.out.println("\t\t \033[97m                                                                            .-\"\"\"\"\"-.");
        try{Thread.sleep(80);}catch(InterruptedException ignored) {}
        System.out.println("\t\t                                                                           .'\033[34m_________\033[97m'.");
        try{Thread.sleep(80);}catch(InterruptedException ignored) {}
        System.out.println("\t\t                                                                          /\033[34m_/_|__|__|_\\_\033[97m\\");
        try{Thread.sleep(80);}catch(InterruptedException ignored) {}
        System.out.println("\t\t                                                                         ;'-._       _.-';");
        try{Thread.sleep(80);}catch(InterruptedException ignored) {}
        System.out.println("\t\t               ,---------------------------------------------------------|    `-. .-'    |--------------------------------------------------------,");
        try{Thread.sleep(80);}catch(InterruptedException ignored) {}
        System.out.println("\t\t               ```\"\"-..-------`\"-// \\\\-\"`---------------..__     ___     ;       '       ;     ___    __..---------------`\"-// \\\\-\"`-------..-\"\"```");
        try{Thread.sleep(80);}catch(InterruptedException ignored) {}
        System.out.println("\t\t                                 \\\\_//                       `\"-// \\\\..___\\             /___..// \\\\-\"`                      \\\\_//");
        try{Thread.sleep(80);}catch(InterruptedException ignored) {}
        System.out.println("\t\t                                  `\"`                           \\\\_//      '._       _.'      \\\\_//                          `\"`");
        try{Thread.sleep(80);}catch(InterruptedException ignored) {}
        System.out.println("\t\t                                                                 \\|/          ``---``          \\|/");
        try{Thread.sleep(80);}catch(InterruptedException ignored) {}
        System.out.println("\t\t                                                                OO|OO           O|O           OO|OO");
        try{Thread.sleep(80);}catch(InterruptedException ignored) {}


        System.out.println("\n\n\n");


        System.out.println("\033[36m\t\t\t\t\t\t\t     ___                ____________ __                             ");
        try{Thread.sleep(80);}catch(InterruptedException ignored) {}

        System.out.println("\t\t\t\t\t\t\t     \\  \\     ____     /  /  _______|  |     ______  ___   ___   _____ _______");
        try{Thread.sleep(80);}catch(InterruptedException ignored) {}

        System.out.println("\t\t\t\t\t\t\t      \\  \\   /    \\   /  /|  ____   |  |    /  ____/  _  \\|    \\/    |   _____|");
        try{Thread.sleep(80);}catch(InterruptedException ignored) {}

        System.out.println("\t\t\t\t\t\t\t       \\  \\ /  /\\  \\ /  / |   __|   |  |   |  |   |  | |  |  |\\  /|  |    __|");
        try{Thread.sleep(80);}catch(InterruptedException ignored) {}

        System.out.println("\t\t\t\t\t\t\t        \\  V  /  \\  V  /  |  |______|  |___|  |___|  |_|  |  | \\/ |  |   |____");
        try{Thread.sleep(80);}catch(InterruptedException ignored) {}

        System.out.println("\t\t\t\t\t\t\t         \\___/    \\___/   |_________|_______\\______\\_____/|__|    |__|________|");


        System.out.println("\n\n\033[93m");

        System.out.println("\t\t\t\t\t\t\t ______             _    _              ______           _     _____ _      _        _       ");
        try{Thread.sleep(80);}catch(InterruptedException ignored) {}

        System.out.println("\t\t\t\t\t\t\t | ___ \\           | |  (_)             | ___ \\         | |   |_   _(_)    | |      | |      ");
        try{Thread.sleep(80);}catch(InterruptedException ignored) {}

        System.out.println("\t\t\t\t\t\t\t | |_/ / ___   ___ | | ___ _ __   __ _  | |_/ / ___  ___| |_    | |  _  ___| | _____| |_ ___ ");
        try{Thread.sleep(80);}catch(InterruptedException ignored) {}

        System.out.println("\t\t\t\t\t\t\t | ___ \\/ _ \\ / _ \\| |/ / | '_ \\ / _` | | ___ \\/ _ \\/ __| __|   | | | |/ __| |/ / _ \\ __/ __|");
        try{Thread.sleep(80);}catch(InterruptedException ignored) {}

        System.out.println("\t\t\t\t\t\t\t | |_/ / (_) | (_) |   <| | | | | (_| | | |_/ /  __/\\__ \\ |_    | | | | (__|   <  __/ |_\\__ \\");
        try{Thread.sleep(80);}catch(InterruptedException ignored) {}

        System.out.println("\t\t\t\t\t\t\t \\____/ \\___/ \\___/|_|\\_\\_|_| |_|\\__, | \\____/ \\___||___/\\__|   \\_/ |_|\\___|_|\\_\\___|\\__|___/");
        try{Thread.sleep(80);}catch(InterruptedException ignored) {}

        System.out.println("\t\t\t\t\t\t\t                                  __/ |                                                      ");
        try{Thread.sleep(80);}catch(InterruptedException ignored) {}

        System.out.println("\t\t\t\t\t\t\t                                 |___/                                                       ");
        try{Thread.sleep(80);}catch(InterruptedException ignored) {}






        try{Thread.sleep(3000);}catch(InterruptedException ignored) {}

        clear();
    }




    private void print_usernames(RandomAccessFile user_file) throws IOException
    {

        long user_counter =  user_file.length() / 84;

        System.out.println("\nuser counter : " + user_counter);
        System.out.println("user length : " + user_file.length());

        for (int i = 0; i < user_counter; i++)
        {
            user_file.seek((long) i *BITESIZE + BITEWALLET);

            int wall = user_file.readInt();

            System.out.printf("\n(%d) name: %-8s\tpass: %-8s\t wallet: %-11s",i,read_file(user_file, (long) i *BITESIZE),
                    read_file(user_file, (long) i *BITESIZE + 40),wall);

        }
    }




}
