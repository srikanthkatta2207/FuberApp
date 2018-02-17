package fuber.filters;

import fuber.model.Car;

import java.util.ArrayList;

public interface Filter
{
    ArrayList<Car> applyOn(ArrayList<Car> cars);
}
