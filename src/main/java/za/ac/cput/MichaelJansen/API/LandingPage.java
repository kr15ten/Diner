package za.ac.cput.MichaelJansen.API;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.MichaelJansen.Domain.MenuItem;

/**
 * Created by Michael on 23/09/2015.
 */

@RestController
@RequestMapping("/")
public class LandingPage {

    @RequestMapping(method = RequestMethod.GET)
    public MenuItem getMenuItem() {

        MenuItem menuItem = new MenuItem.Builder(305, "Harold's hot sauce hamburger",
                "Burgers", "devilishly hot sauce for burgers that will set fire to many a mouth",
                30.00f).extras("Mayonaisse").build();

        return menuItem;
    }
}
