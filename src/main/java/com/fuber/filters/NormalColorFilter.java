package fuber.filters;

import fuber.model.Car;
import fuber.model.NormalCar;

import java.util.ArrayList;

public class NormalColorFilter implements Filter
{
    @Override public ArrayList<Car> applyOn(ArrayList<Car> cars)
    {
        ArrayList<Car> filteredCars = new ArrayList<>();

        for ( Car car : cars )
        {

            if ( car instanceof NormalCar )
            {

                filteredCars.add( car );
            }
        }
        return filteredCars;
    }
}
