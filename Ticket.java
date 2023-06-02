import java.util.Random;

/**
 * @Author    Ali jafaripour
 * @Data     1402/01/25
 */

public class Ticket
{
    public int ticketId;
    private  String user_id;
    private  String flight_id;



    //--------------- constructor ------------------
    public Ticket()
    {
        Random rand = new Random();

        boolean isUnique = false;
        while (!isUnique)
        {


            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 9; i++)
            {
                int digit = rand.nextInt(10);
                sb.append(digit);
            }

            int newTicketId = Integer.parseInt(sb.toString());

            if (newTicketId != this.ticketId )
            {
                this.ticketId = newTicketId;
                isUnique = true;
            }

        }
    }

}


