package fuber.services;

import fuber.Utils.Utils;
import fuber.model.Car;
import fuber.model.Currency;
import fuber.model.Customer;
import fuber.model.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class PaymentService
{
    @Autowired
    HttpSession httpSession;

    public Money getPayment()
    {
        Customer customer = (Customer) httpSession.getAttribute( "customer" );

        Car car = (Car) httpSession.getAttribute( "car" );

        car.setAvailability( true );

        double travelledDistance = Utils.calculateDistanceBetween( customer.getLocation(), car.getLocation() );

        double amount = travelledDistance * (car.PRICE + car.getExtraPrice());

        Money totalMoney = new Money( amount, Currency.dogeCoin() );

        return totalMoney;
    }

    ;

}
