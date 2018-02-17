package fuber.controller;

import fuber.model.Car;
import fuber.model.Customer;
import fuber.model.Location;
import fuber.services.CarPoolService;
import fuber.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
@SessionAttributes( "customer" )
public class FuberClientController
{
    @Autowired
    Customer customer;

    @Autowired
    Location location;

    @Autowired
    CarPoolService carPoolService;

    @Autowired
    PaymentService paymentService;

    @Autowired
    HttpSession httpSession;

    @RequestMapping( "/" )
    public String index()
    {
        return "index";
    }

    public void createCustomer( String name, String longitude, String latitude )
    {
        double long_val = Double.parseDouble( longitude );
        double lat_val = Double.parseDouble( latitude );
        location.setLatitude( lat_val );
        location.setLongitude( long_val );
        customer.setLocation( location );
        customer.setName( name );
        httpSession.setAttribute( "customer", customer );
    }

    @RequestMapping( value = "/book_car", method = RequestMethod.POST )
    public String bookCar( @RequestParam( "name" ) String name,
        @RequestParam( "cur_longitude" ) String curLongitude, @RequestParam( "cur_latitude" ) String curLatitude,
        @RequestParam( "des_longitude" ) String desLongitude, @RequestParam( "des_latitude" ) String desLatitude,
        Model model )
    {
        createCustomer( name, curLongitude, curLatitude );
        Car car = carPoolService.getCarNearBy();
        if ( car == null )
        {
            model.addAttribute( "reject", true );
            return "reject_page";
        }

        double des_long_val = Double.parseDouble( desLongitude );
        double des_lat_val = Double.parseDouble( desLatitude );
        car.setAvailability( false );
        car.setLocation( new Location( des_long_val, des_lat_val ) );
        httpSession.setAttribute( "car", car );
        model.addAttribute( "customerName", name );
        model.addAttribute( "car", car );
        return "book_car";
    }

    ;

    @RequestMapping( value = "/cars", method = RequestMethod.GET )
    public @ResponseBody ArrayList<Car> getAvailableCars()
    {
        return carPoolService.getAllAvailableCars();
    }

    @RequestMapping( value = "/end", method = RequestMethod.GET )
    public @ResponseBody String getFinalPrice()
    {

        double finalPrice = paymentService.getPayment();

        httpSession.invalidate();

        return "You should pay : " + finalPrice;
    }


}
