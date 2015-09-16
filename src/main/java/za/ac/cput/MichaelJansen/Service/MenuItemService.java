package za.ac.cput.MichaelJansen.Service;

import za.ac.cput.MichaelJansen.Domain.MenuItem;

import java.util.List;

/**
 * Created by Michael on 15/09/2015.
 */
public interface MenuItemService {
    List<MenuItem> getMenuItems();

    MenuItem getMenuItem(int id);

    List<MenuItem> getType(String type);
}
