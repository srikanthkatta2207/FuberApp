package fuber.model;

public abstract class Car
{
    public static final int PRICE = 1;

    private Location Location;

    private int number;

    private boolean availability;

    public int extraPrice;

    public Car() {

    }

    public Car( Location location, int number)
    {
        Location = location;
        this.number = number;
    }

    public static int getPRICE()
    {
        return PRICE;
    }

    public int getExtraPrice()
    {
        return extraPrice;
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

    public boolean isAvailability()
    {
        return availability;
    }

    public void setAvailability( boolean availability )
    {
        this.availability = availability;
    }
}

