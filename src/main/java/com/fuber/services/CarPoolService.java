package fuber.services;

import fuber.Dao.CarStoreDao;
import fuber.Utils.Utils;
import fuber.filters.Filter;
import fuber.filters.NormalColorFilter;
import fuber.filters.PinkColorFilter;
import fuber.model.Car;
import fuber.model.Customer;
import fuber.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class CarPoolService
{
    @Autowired
    CarStoreDao carStoreDao;

    @Autowired
    HttpSession httpSession;

    private static final String PINK_COLOR = "pink";

    public ArrayList<Car> getAllAvailableCars()
    {
        return carStoreDao.getAllAvailableCars();
    }


    public ArrayList<Car> getAllAvailableCars( Filter filter )
    {

        ArrayList<Car> availableCars = carStoreDao.getAllAvailableCars();

        return filter.applyOn( availableCars );
    }


    public Car getCarNearBy( String color )
    {
        try
        {

            ArrayList<Car> availableCars = getAllAvailableCars( getFilter( color ) );

            Customer customer = (Customer) httpSession.getAttribute( "customer" );

            Location customerLocation = customer.getLocation();

            HashMap<Car, Double> carRanges = new HashMap<>();

            for ( Car car : availableCars )
            {

                Location carLocation = car.getLocation();

                double distance = Utils.calculateDistanceBetween( customerLocation, carLocation );

                carRanges.put( car, distance );
            }

            return getCarInMinimumDistanceFromCustomer( carRanges );
        }
        catch ( Exception e )
        {
            System.out.println( e );

            return null;
        }

    }

    ;

    public Car getCarInMinimumDistanceFromCustomer( HashMap<Car, Double> carRanges )
    {

        Map.Entry<Car, Double> min = null;

        for ( Map.Entry<Car, Double> entry : carRanges.entrySet() )
        {
            if ( min == null || min.getValue() > entry.getValue() )
            {
                min = entry;
            }
        }

        return min.getKey();
    }

    public Filter getFilter( String color )
    {
        Filter filter;

        if ( color.equals( PINK_COLOR ) )
        {
            filter = new PinkColorFilter();
        }
        else
        {
            filter = new NormalColorFilter();
        }
        return filter;
    }
}
