package fuber.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FuberClientController
{
    @RequestMapping( "/" )
    public String index()
    {
        return "index";
    }

}
