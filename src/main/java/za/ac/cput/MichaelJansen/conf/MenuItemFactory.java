package za.ac.cput.MichaelJansen.conf;

import za.ac.cput.MichaelJansen.Domain.MenuItem;

/**
 * Created by Michael on 07/09/2015.
 */
public class MenuItemFactory {
    public static MenuItem createMenuItem(int id,String itemName,String type,String description,float price,String extras)
    {
        MenuItem menuItem = new MenuItem.Builder(id,itemName,type,description,price).
                extras(extras)
                .build();
        return menuItem;
    }
}
