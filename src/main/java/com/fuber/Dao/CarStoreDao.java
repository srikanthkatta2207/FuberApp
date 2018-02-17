package fuber.Dao;

import fuber.model.Car;
import fuber.model.Location;
import fuber.model.NormalCar;
import fuber.model.PinkCar;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class CarStoreDao
{
    public  static final ArrayList<Car> cars = new ArrayList<>();

    static{
        cars.add(0, new NormalCar( new Location( 1.0, 5.0 ), 1 ));
        cars.add(1,new PinkCar( new Location( 3.0, 6.0 ), 2 ));
        cars.add(2,new NormalCar( new Location( 6.0, 10.0 ), 3 ));

        for(Car car: cars) {
            car.setAvailability( true );
        }
    }


    public ArrayList<Car> getAllAvailableCars()

    {
        ArrayList<Car> availableCars = new ArrayList<>();

        for ( Car car : cars )
        {
            if ( car.isAvailability() )
            {
                availableCars.add( car );
            }
        }

        return availableCars;
    };
}
