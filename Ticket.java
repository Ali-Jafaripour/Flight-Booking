import java.util.Random;

public class Ticket
{

        private int ticketId;

        //--------------- constructor ------------------
        public Ticket()
        {
            Random rand = new Random();

            boolean isUnique = false;
            while (!isUnique)
            {

                // char c = (char)(rand.nextInt(26)+'A');

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
        //--------------- Get ------------------
        public int getTicketId()
        {
            return this.ticketId;
        }
    }


