package za.ac.cput.MichaelJansen.conf;

import za.ac.cput.MichaelJansen.Domain.SalesItem;

/**
 * Created by Michael on 12/09/2015.
 */
public class SalesItemFactory {
    public static SalesItem createSalesItem(int menuItemId,int tableId,String extra){
        SalesItem salesItem = new SalesItem.Builder(menuItemId, tableId).extra(extra).build();

        return salesItem;
    }
}
