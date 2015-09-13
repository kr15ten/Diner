package za.ac.cput.MichaelJansen.conf;

import za.ac.cput.MichaelJansen.Domain.Order;
import za.ac.cput.MichaelJansen.Domain.SalesItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael on 07/09/2015.
 */
public class OrderFactory {
    public static Order createOrder(List<SalesItem> items,
            String extras)
    {
        Order order = new Order
                .Builder(items,extras)
                .build();
        return order;
    }
}
