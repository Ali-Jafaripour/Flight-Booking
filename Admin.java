import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * @Author    Ali jafaripour
 * @Data     1402/01/13
 */
public class Admin extends Flight_file
{


    Scanner reader = new Scanner(System.in);
    Login sign_out  = new Login();


//-----------------------------------  admin menu --------------------------------------

    /**
     * this function for admin menu to
     * choose your action
     *
     * @param flight_file
     * @param user_file
     * @throws IOException
     */
    public void admin_back(RandomAccessFile flight_file, RandomAccessFile user_file) throws IOException
    {

        admin_front();

        int num = reader.nextInt();

        clear();

        switch (num) {
            // --------------------- add ----------------------
            case 1 -> add( flight_file, user_file);


            // ------------------- Update --------------------
            case 2 -> update( flight_file, user_file);


            // ------------------- remove --------------------
            case 3 -> remove( flight_file, user_file);


            // --------------- Flight Schedules ---------------
            case 4 -> flight_schedules( flight_file, user_file,"admin");


            // ------------------- sing out -----------------
            case 0 -> sign_out.menu_back( flight_file, user_file);
            default -> {
                System.out.println("\t\t\t\t\t\t\t\t\t\t\033[91m ==> Rong choice <==\033[97m");
                System.out.print("\t\t\t\t\t\t\t\t\t\t\t\033[33mPlese try again\033[97m");
                admin_back( flight_file, user_file);
            }
        }

    }

    private  void admin_front()
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



//---------------------------------------------------------------------------------------------------
















































//               __________________________________________________________________
//              |                                              _ .       |         |
//              |                                            (  _ )_     | ======= |
//              |                                           (_  _(_ ,)   | ======= |
//              |  __|__                                                 | ======= |
//              |  \___/                                                 | ======= |
//              |   | |                                                  | ======= |
//              |   | |          __|__                                   | ======= |
//              |   | |    *---o--(_)--o---*                             |         |
//              |___|_|__________________________________________________|_________|








//
//          __|__
//    *---o--(_)--o---*











//            ______
//            _\ _~-\___
//    =  = ==(____AA____D
//                \_____\___________________,-~~~~~~~`-.._
//                /     o O o o o o O O o o o o o o O o  |\_
//                `~-.__        ___..----..                  )
//                      `---~~\___________/------------`````
//                      =  ===(_________D







//                                    |
//                                    |
//                                    |
//                                  .-'-.
//                                 ' ___ '
//                       ---------'  .-.  '---------
//       _________________________'  '-'  '_________________________
//        ''''''-|---|--/    \==][^',_m_,'^][==/    \--|---|-''''''
//                      \    /  ||/   H   \||  \    /
//                       '--'   OO   O|O   OO   '--'





//                                           \ /                                          \   /
//                                          --o--           `\\             //'      .____-/.\-____.
//                                                            \\           //             ~`-'~
//                                                             \\. __-__ .//
//                                                   ___/-_.-.__`/~     ~\'__.-._-\___
//                            .|.       ___________.'__/__ ~-[ \.\'-----'/./ ]-~ __\__`.___________       .|.
//                            ~o~~~~~~~--------______-~~~~~-_/_/ |   .   | \_\_-~~~~~-______--------~~~~~~~o~
//                            ' `               + + +  (X)(X)  ~--\__ __/--~  (X)(X)  + + +               ' `
//                                                         (X) `/.\' ~ `/.\' (X)
//                                                             "\_/"   "\_/"



//                      _  _                                                                                                             _ .
//                     ( `   )_                                                                                                         (  _ )_
//                    (    )    `)                                                                                                     (_  _(_ ,)
//                  (_   (_ .  _) _)                                               |                             _
//                                                                         --======|======--                    (  )
//                                                                                 |                         ( `  ) . )
//                                                                                 |                        (_, _(  ,_)_)
//                                                                             .-"""""-.
//                                                                           .'_________'.
//                                                                          /_/_|__|__|_\_\
//                                                                         ;'-._       _.-';
//               ,---------------------------------------------------------|    `-. .-'    |--------------------------------------------------------,
//               ```""-..-------`"-// \\-"`---------------..__     ___     ;       '       ;     ___    __..---------------`"-// \\-"`-------..-""```
//                                 \\_//                       `"-// \\..___\             /___..// \\-"`                      \\_//
//                                  `"`                           \\_//      '._       _.'      \\_//                          `"`
//                                                                 \|/          ``---``          \|/
//                                                                OO|OO           O|O           OO|OO






//                            __|__
//                            \___/
//                             | |
//                             | |
//                            _|_|______________



//           _
//         -=\`\
//     |\ ____\_\__
//   -=\c`""""""" "`)
//      `~~~~~/ /~~`
//        -==/ /
//          '-'



//                      _  _
//                     ( `   )_
//                    (    )    `)
//                  (_   (_ .  _) _)
//                                                 _
//                                                (  )
//                 _ .                         ( `  ) . )
//               (  _ )_                      (_, _(  ,_)_)
//             (_  _(_ ,)




//                                                          ___
//                                                          \\ \
//                                                           \\ `\
//                                        ___                 \\  \
//                                       |    \                \\  `\
//                                       |_____\                \    \
//                                       |______\                \    `\
//                                       |       \                \     \
//                                       |      __\__---------------------------------._.
//                                     __|---~~~__o_o_o_o_o_o_o_o_o_o_o_o_o_o_o_o_o_o_[][\__
//                                    |___                         /~      )                \__
//                                        ~~~---..._______________/      ,/_________________/
//                                                               /      /
//                                                              /     ,/
//                                                             /     /
//                                                            /    ,/
//                                                           /    /
//                                                          //  ,/
//                                                         //  /
//                                                        // ,/
//                                                       //_/




//                                                              /\
//                                                             |  |
//                                                             |  |
//                                                            .'  '.
//                                                            |    |
//                                                            |    |
//                                                            | /\ |
//                                                          .' |__|'.
//                                                          |  |  |  |
//                                                         .'  |  |  '.
//                                                    /\   |   \__/   |   /\
//                                                   |  |  |   |  |   |  |  |
//                                               /|  |  |,-\   |  |   /-,|  |  |\
//                                               ||  |,-'   |  |  |  |   '-,|  ||
//                                               ||-'       |  |  |  |       '-||
//                                    |\     _,-'           |  |  |  |           '-,_     /|
//                                    ||  ,-'               |  |  |  |               '-,  ||
//                                    ||-'                  |  |  |  |                  '-||
//                                    ||                    |  \  /  |                    ||
//                                    |\________....--------\   ||   /--------....________/|
//                                                          /|  ||  |\
//                                                         / |  ||  | \
//                                                        /  |  \/  |  \
//                                                       /   |      |   \
//                                                     //   .|      |.   \\
//                                                   .' |_./ |      | \._| '.
//                                                  /     _.-|||  |||-._     \
//                                                  \__.-'   \||/\||/   '-.__/











}
