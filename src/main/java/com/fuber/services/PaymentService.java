package fuber.services;

import fuber.Utils.Utils;
import fuber.model.Car;
import fuber.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class PaymentService
{
    @Autowired
    HttpSession httpSession;

    public double getPayment()
    {
        Customer customer = (Customer) httpSession.getAttribute( "customer" );

        Car car = (Car) httpSession.getAttribute( "car" );

        car.setAvailability( true );

        double travelledDistance = Utils.calculateDistanceBetween( customer.getLocation(), car.getLocation() );

        return travelledDistance * (car.PRICE + car.getExtraPrice());
    }

    ;

}
