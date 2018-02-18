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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
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


    @RequestMapping( value = "/book_car", method = RequestMethod.POST )
    public String bookCar( @RequestParam( "name" ) String name,
        @RequestParam( "cur_longitude" ) String currentLongitude, @RequestParam( "cur_latitude" ) String currentLatitude,
        @RequestParam( "des_longitude" ) String destinationLongitude, @RequestParam( "des_latitude" ) String destinationLatitude,
        @RequestParam( "filter" ) String color,
        Model model )
    {
        createCustomer( name, currentLongitude, currentLatitude );
        Car car = carPoolService.getCarNearBy( color );
        if ( car == null )
        {
            httpSession.removeAttribute("customer");
            httpSession.removeAttribute("car");
            return "reject_page";
        }

        double des_long_val = Double.parseDouble( destinationLongitude );
        double des_lat_val = Double.parseDouble( destinationLatitude );
        car.setAvailability( false );
        model.addAttribute( "currentCarLocation", car.getLocation() );
        car.setLocation( new Location( des_long_val, des_lat_val ) );
        httpSession.setAttribute( "car", car );
        model.addAttribute( "customerName", name );
        model.addAttribute( "car", car );
        return "book_car";
    }

    @RequestMapping( value = "/cars", method = RequestMethod.GET )
    public @ResponseBody ArrayList<Car> getAvailableCars()
    {

        return carPoolService.getAllAvailableCars();
    }

    @RequestMapping( value = "/end", method = RequestMethod.GET )
    public void getFinalPrice( HttpServletResponse response ) throws ServletException, IOException
    {
        response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        double finalPrice = paymentService.getPayment();
        out.print( "You should pay: " + finalPrice + "\n" );
        httpSession.removeAttribute("customer");
        httpSession.removeAttribute("car");
        out.close();
    }


    public void createCustomer( String name, String longitude, String latitude )
    {
        try
        {
            double long_val = Double.parseDouble( longitude );
            double lat_val = Double.parseDouble( latitude );
            location.setLatitude( lat_val );
            location.setLongitude( long_val );
            customer.setLocation( location );
            customer.setName( name );
            httpSession.setAttribute( "customer", customer );
        } catch(Exception e) {
            System.out.println(e);
        }
    }

}
