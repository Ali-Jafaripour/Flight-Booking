import java.util.Scanner;


//  Author   Ali jafaripour
//  Data     1402/01/09

public class Booking {

    static Scanner reader = new Scanner(System.in);

    Passenger[] user = new Passenger[20];

    int newuser_flag = 0;

//-------- welcome massage --------

    public void welcome()
    {
        welcome_massage();
        menu_back();
    }

//----------- new users -------- 
    void new_user()
    {
        for (int j = 0; j < user.length; j++) 
        {
            user[j] = new Passenger();
        }
    }    



// ------------------------------------------ first menu -----------------------------------------

    public void menu_back()
    {

        if(newuser_flag == 0)
        {
            new_user();
            newuser_flag++;
        }

        menu_front();

        int num = reader.nextInt();

        clear();

        switch (num)
        {
            // ------------------- Sign in -------------------
            case 1:
                sign_in();
                break;

            // ------------------- Sign up --------------------
            case 2:
                add_back();
                break;

            default:

                System.out.println("\t\t\t\t\t\t\t\t\t\t\033[91m ==> Rong choice <==\033[97m");
                System.out.print("\t\t\t\t\t\t\t\t\t\t\t\033[33mPlese try again\033[97m");
                menu_back();
                break;
        }

    }

    public void menu_front()
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

    public void add_back()
    {
        print_usernames();      // For Test

        add_front();
        int flag = 0;

    // ----------------- username -------------------
        System.out.print("\t\t\t\t\t\tName ==> ");
        String username = reader.next();
        flag = check_username(username);
        if(flag ==1)
        {
            System.out.print("\n\t\t\t\t\t\t\t\033[91m  <<< This username used >>> ");
            try {Thread.sleep(2000);} catch (InterruptedException e) {};
            clear();
            add_back();
        }
    // ----------------- password --------------------
        System.out.print("\t\t\t\t\t\tPassword ==> ");
        String password = reader.next();

        clear();

        int count = complate_user();


       
        if(flag == 0)
        {
            user[count].setusername(username);
            user[count].setpassword(password);
            count++;
            System.out.print("\n\t\t\t\t\033[32m  <<< change Saved >>> ");
            try {Thread.sleep(1500);} catch (InterruptedException e) {};
            clear();
            menu_back();

        }

    }

    public  void add_front()
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
        // System.out.println("\t\t\t\t\t\tName ==> ");
        // System.out.print("\t\t\t\t\t\tPassword ==> ");

    }


//------------------------------------------  sign in -----------------------------------------

    public void sign_in()
    {
        print_usernames();      // For Test

        int flag_name = 0;
        int flag_pass = 0;

        sign_frant();

        // -------------- username -----------------
        System.out.print("\t\t\t\t\t\tName ==> ");
        String username = reader.next();
        if(username.equals("1"))
        {
            clear();
            menu_back();
        }

        flag_name = check_username(username);

        if(flag_name == 0 && !username.equals("admin"))
        {
            System.out.print("\n\n\n\t\t\t\t\033[91m  <<< Rong Username >>> ");
            try {Thread.sleep(2000);} catch (InterruptedException e) {};
            clear();
            sign_in();
        }


        // -------------- password -----------------
        System.out.print("\t\t\t\t\t\tPassword ==> ");
        String password = reader.next();
        if(password.equals("1"))
        {
            clear();
            menu_back();
        }

        flag_pass = check_password(password);

        if(flag_pass == 0 && !password.equals("admin"))
        {
            System.out.print("\n\n\n\t\t\t\t\033[91m  <<< Rong Password >>> ");
            try {Thread.sleep(2000);} catch (InterruptedException e) {};
            clear();
            sign_in();
        }

        clear();




        if(username.equals("admin") && password.equals("admin") )
        {
            Admin admin = new Admin();

            admin.admin_menu();

        }

        if(flag_name == 0  && flag_pass==0)
        {

                // passenger menu

        }
    }

    public void sign_frant()
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

    public  int  check_username(String username)
    {
        int flag =0;

        for (int i = 0; i < user.length; i++) 
        {
            if(user[i].getusername() != null && user[i].getusername().equals(username) ||  username.equals("admin"))
            {
                flag = 1;
            }
            
        }

        return flag;
    }

//-------------------------------------- Check username -------------------------------------

    public  int  check_password(String password)
    {
        int flag =0;

        for (int i = 0; i < user.length; i++) 
        {
            if(user[i].getpassword() != null && user[i].getpassword().equals(password))
            {
                flag = 1;
            }
            
        }

        return flag;
    }





//-------------------------------------- complate users -------------------------------------

    public int complate_user()
    {
        int count = 0;

            for (int i = 0; i < user.length; i++)
            {
                if(user[i].getusername() == null)
                {
                    count = i;
                    break;
                }

            }

        return count;
    }


//------------------------------------------ welcome massage -------------------------------------

     public void welcome_massage()
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

    public  void clear()
    {
    System.out.print("\033[H\033[2J");
    System.out.flush();
    }







    public void print_usernames()
    {
        for (int i = 0; i < user.length; i++)
        {
            System.out.println( "username ("+i+") "+user[i].getusername()+"\tpass => "+user[i].getpassword());
        }
        System.out.println("\n\n\n\n");
    }








}
