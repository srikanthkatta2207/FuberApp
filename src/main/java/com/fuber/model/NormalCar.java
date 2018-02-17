package fuber.model;

public class NormalCar extends Car
{
    private static final int EXTRA_PRICE = 0;

    public NormalCar()
    {

    }

    public NormalCar( Location location, int number )
    {
        super( location, number );

        this.extraPrice = EXTRA_PRICE;
    }
}
