package za.ac.cput.MichaelJansen.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.MichaelJansen.Domain.Waiter;
import za.ac.cput.MichaelJansen.Model.WaiterResource;
import za.ac.cput.MichaelJansen.Service.WaiterService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael on 16/09/2015.
 */
@RestController
@RequestMapping("/api/**")
public class HomePage
{
    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String Index()
    {
        return "Home Page of the Diner App";
    }
}