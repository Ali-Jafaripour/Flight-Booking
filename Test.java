import java.util.Scanner;

public class Test
{
    static Scanner reader = new Scanner(System.in);

    public static void main(String[] args)
    {
            System.out.print("\n\n\t\t\t\t\t\t Flight id ==> ");
            String flight_id = reader.next();



            int flag = 1;
            int index = 0;


            if(flag == 0)
            {
                System.out.print("\n\n\n\t\t\t\t\t\033[91m  <<< Rong Flight Id >>> ");
                try {Thread.sleep(2000);} catch (InterruptedException e) {};
                clear();
            }
            else
            {
                update_frant1();

                ubdate1(index);

                clear();


            }

        }

        private static void ubdate1(int index)
        {
            System.out.print("\t\t\t\t\t\t==> ");
            int num1 = reader.nextInt();

            switch (num1)
            {
                // --------------------- Flight ID ----------------
                case 1:
                    System.out.print("\t\t\t\t\t\tflight_id ==> ");
                    String flight_id1 = reader.next();
                    if(flight_id1.equals("1"))
                    {
                        clear();
                    }
                    ubdate1(index);
                    break;

                    // ------------------- Origins --------------------
                case 2:

                    System.out.print("\t\t\t\t\t\torigin ==> ");
                    String origin = reader.next();
                    if(origin.equals("1"))
                    {
                        clear();

                    }
                    ubdate1(index);
                    break;

                // ------------------- Destention ----------------
                case 3:
                    System.out.print("\t\t\t\t\t\tdestantion ==> ");
                    String destantion = reader.next();
                    if(destantion.equals("1"))
                    {
                        clear();

                    }
                    ubdate1(index);
                    break;

                // --------------- Data ---------------
                case 4:
                    System.out.print("\t\t\t\t\t\tdata ==> ");
                    String data = reader.next();
                    if(data.equals("1"))
                    {
                        clear();

                    }
                    ubdate1(index);
                    break;


                // ------------------- time -----------------
                case 5:
                    System.out.print("\t\t\t\t\t\ttime ==> ");
                    String time = reader.next();
                    if(time.equals("1"))
                    {
                        clear();

                    }
                    ubdate1(index);
                    break;


                // ------------------- price -----------------
                case 6:
                    System.out.print("\t\t\t\t\t\tprice ==> ");
                    int price = reader.nextInt();
                    if(price == 1)
                    {
                        clear();

                    }
                    ubdate1(index);
                    break;


                // ------------------- seat -----------------
                case 7:
                    System.out.print("\t\t\t\t\t\tseat ==> ");
                    int seat = reader.nextInt();
                    if(seat == 1)
                    {
                        clear();

                    }
                    ubdate1(index);
                    break;


                default:

                    System.out.println("\t\t\t\t\t\t\t\t\t\t\033[91m ==> Rong choice <==\033[97m");
                    System.out.print("\t\t\t\t\t\t\t\t\t\t\t\033[33mPlese try again\033[97m");

                    break;


            }
        }


        public static void update_frant1()
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

            System.out.println("\t\t\t\t\t\t|           1.exit            |");
            try{Thread.sleep(80);}catch(InterruptedException e) {};


            System.out.println("\t\t\t\t\t\t+-----------------------------+");
            try{Thread.sleep(80);}catch(InterruptedException e) {};
        }


    //------------------------------------------ system clear -----------------------------------------

    public static void clear()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
