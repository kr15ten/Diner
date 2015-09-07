package za.ac.cput.MichaelJansen.conf;

import za.ac.cput.MichaelJansen.Domain.Order;
import za.ac.cput.MichaelJansen.Domain.Sale;
import za.ac.cput.MichaelJansen.Domain.Waiter;

import java.util.List;

/**
 * Created by Michael on 07/09/2015.
 */
public class SaleFactory {
    public static Sale createSale(List<Order> items,Waiter waiter,float tip)
    {
        Sale sale = new Sale.Builder(waiter,items,tip)
                .build();
        return sale;
    }
}
