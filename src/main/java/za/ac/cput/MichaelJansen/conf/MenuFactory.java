package za.ac.cput.MichaelJansen.conf;

import za.ac.cput.MichaelJansen.Domain.Menu;
import za.ac.cput.MichaelJansen.Domain.MenuItem;
import za.ac.cput.MichaelJansen.Domain.Salary;
import za.ac.cput.MichaelJansen.Domain.Shift;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael on 07/09/2015.
 */
public class MenuFactory {
    public static Menu createMenu(List<MenuItem> menuItems)
    {
        Menu menu = new Menu.Builder(menuItems).
                build();
        return menu;
    }
}
