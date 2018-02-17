package fuber.services;

import fuber.Dao.CarStoreDao;
import fuber.Utils.Utils;
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

    public ArrayList<Car> getAllAvailableCars()
    {
        return carStoreDao.getAllAvailableCars();
    };

   public Car getCarNearBy()
    {

        ArrayList<Car> availableCars = getAllAvailableCars();

        Customer customer = (Customer) httpSession.getAttribute( "customer" );

        Location customerLocation = customer.getLocation();

        HashMap<Car, Double> carRanges = new HashMap<>();

        System.out.println("Hello world"+ availableCars.get( 0 ));

        for ( Car car : availableCars )
        {

            Location carLocation = car.getLocation();

            double distance = Utils.calculateDistanceBetween( customerLocation, carLocation );

            carRanges.put( car, distance );
        }

        return getCarInMinimumDistanceFromCustomer( carRanges );
    }


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
}
