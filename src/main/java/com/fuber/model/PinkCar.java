package fuber.model;


public class PinkCar extends Car
{
    private static final int EXTRA_PRICE = 5;

    public PinkCar()
    {

    }

    public PinkCar( Location location, int number )
    {
        super( location, number );

        this.extraPrice = EXTRA_PRICE;
    }
}
