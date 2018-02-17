package fuber.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FuberClientController
{
    @RequestMapping( "/" )
    public String index()
    {
        return "index";
    }

    @RequestMapping( value = "/book_car", method = RequestMethod.POST )
    public String bookCar(@RequestParam("name") String name, Model model) {

        model.addAttribute( "customerName",name );

        return "book_car";
    };
}
