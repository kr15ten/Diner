package za.ac.cput.MichaelJansen.Domain;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Michael on 12/09/2015.
 */
public class TestSalesItem {
    SalesItem salesItem;

    private int menuItemId;
    private int tableId;
    private String extra;

    //@Before
    public void setUp() throws Exception
    {
        menuItemId = 305;
        tableId = 3;
        extra = "Extra cheese";

        salesItem = new SalesItem.Builder(menuItemId,tableId).extra(extra).build();

    }

    //@Test
    public void createOrder() throws Exception
    {
        Assert.assertNotNull(salesItem);
        Assert.assertEquals(salesItem.getMenuItemId(),305);
    }

    //@After
    public void tearDown() throws Exception
    {
        //super.tearDown();
    }
}
