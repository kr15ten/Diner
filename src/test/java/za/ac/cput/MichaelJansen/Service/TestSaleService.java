package za.ac.cput.MichaelJansen.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import za.ac.cput.MichaelJansen.App;
import za.ac.cput.MichaelJansen.Domain.Sale;
import za.ac.cput.MichaelJansen.Repository.SaleRepository;
import za.ac.cput.MichaelJansen.conf.SaleFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael on 15/09/2015.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestSaleService extends AbstractTestNGSpringContextTests {

    @Autowired
    SaleService service;


    @Autowired
    private SaleRepository repository;

    int id;

    Sale sale;
    int waiterId;
    int tableId;
    float tip;

    List<Sale> sales = new ArrayList<Sale>();
    
    @Test
    public void create() throws Exception
    {

        waiterId = 1;
        tableId = 1;
        tip = 150.00f;

        sale = SaleFactory.createSale(tableId, waiterId, tip);

        repository.save(sale);
        id = sale.getId();

        Assert.assertNotNull(sale.getId());
    }


    @Test(dependsOnMethods = "create")
    public void testGetOrders() throws Exception {
        sales = service.getSales();
        Assert.assertEquals(1, sales.size());
    }

    @Test(dependsOnMethods = "create")
    public void testGetOrder() throws Exception {
        sale = service.getSale(id);

        Assert.assertEquals(waiterId,sale.getWaiterId());
    }

    @AfterClass
    public void cleanUp() throws Exception
    {
        repository.deleteAll();
    }
    
}
