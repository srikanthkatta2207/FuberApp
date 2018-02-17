package fuber.filters;

import fuber.model.Car;
import fuber.model.PinkCar;

import java.util.ArrayList;

public class PinkColorFilter implements Filter
{
    @Override public ArrayList<Car> applyOn(ArrayList<Car> cars)
    {
        ArrayList<Car> filteredCars = new ArrayList<>();

        for ( Car car : cars )
        {

            if ( car instanceof PinkCar )
            {

                filteredCars.add( car );
            }
        }
        return filteredCars;
    }
}
