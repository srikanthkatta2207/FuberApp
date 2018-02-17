package fuber.controller;

import fuber.model.Customer;
import fuber.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes( "customer" )
public class FuberClientController
{
    @Autowired
    Customer customer;

    @Autowired
    Location location;

    @Autowired
    HttpSession httpSession;

    @RequestMapping( "/" )
    public String index()
    {
        return "index";
    }

    @RequestMapping( value = "/book_car", method = RequestMethod.POST )
    public String bookCar( @RequestParam( "name" ) String name, @RequestParam( "longitude" ) String longitude, @RequestParam( "latitude" ) String latitude, Model model)
    {
        double long_val = Double.parseDouble( longitude );
        double lat_val = Double.parseDouble( latitude );
        location.setLatitude( lat_val );
        location.setLongitude( long_val );
        customer.setLocation( location );
        customer.setName( name );
        httpSession.setAttribute( "customer",customer );
        model.addAttribute( "customerName", name );
        return "book_car";
    };




}
