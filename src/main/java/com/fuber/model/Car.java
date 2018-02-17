package fuber.model;

public abstract class Car
{
    private static final int PRICE = 1;

    private Location Location;

    private int number;


    public int extraPrice;

    public Car() {

    }

    public Car( Location location, int number)
    {
        Location = location;
        this.number = number;
    }


    public Location getLocation()
    {
        return Location;
    }

    public void setLocation( Location location )
    {
        Location = location;
    }

    public int getNumber()
    {
        return number;
    }

    public void setNumber( int number )
    {
        this.number = number;
    }
}

