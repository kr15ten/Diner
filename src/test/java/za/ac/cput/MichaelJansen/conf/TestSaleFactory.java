package za.ac.cput.MichaelJansen.conf;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.MichaelJansen.Domain.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael on 07/09/2015.
 */
public class TestSaleFactory {

    Sale sale;
    private int tableId;
    private int waiterId;
    private float tip;

    @Before
    public void setUp() throws Exception
    {

        waiterId = 1;
        tableId = 1;
        tip = 150.00f;

    }

    @Test
    public void testSaleCreation() throws Exception
    {
        sale = SaleFactory.createSale(tableId,waiterId,tip);
        Assert.assertNotNull(sale);
        Assert.assertEquals(1,sale.getTableId());
    }


    @After
    public void tearDown() throws Exception
    {
        //super.tearDown();
    }
}
