public class Flight
{


    private String flight_id;
    private String  origin;
    private String  destantion;
    private  String data;
    private  String time;
    private  int price;
    private  int seat;


    //-------------   Getter  ----------------

    public String get_flight_id()
    {
        return flight_id;
    }

    public String get_origin()
    {
        return origin;
    }

    public String get_destantion()
    {
        return destantion;
    }

    public String get_data()
    {
        return data;
    }

    public String get_time()
    {
        return time;
    }

    public int get_price()
    {
        return price;
    }
    public int get_seat()
    {
        return seat;
    }

    //-------------   setter  ----------------

    public void set_flight_id(String flight_id)
    {
        this.flight_id = flight_id;
    }

    public void set_origin(String origin)
    {
        this.origin = origin;
    }

    public void set_destantion(String destantion)
    {
        this.destantion = destantion;
    }

    public void set_data(String data)
    {
        this.data = data;
    }

    public void set_time(String time)
    {
        this.time = time;
    }

    public void set_price(int price)
    {
        this.price = price;
    }

    public void set_seat(int seat)
    {
        this.seat = seat;
    }
    


}
