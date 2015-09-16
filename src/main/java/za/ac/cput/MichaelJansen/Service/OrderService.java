package za.ac.cput.MichaelJansen.Service;

import za.ac.cput.MichaelJansen.Domain.MenuItem;
import za.ac.cput.MichaelJansen.Domain.Order;

import java.util.List;

/**
 * Created by Michael on 15/09/2015.
 */
public interface OrderService {
    List<Order> getOrders();

    Order getOrder(int id);

    public List<MenuItem> getOrderedMenuItems(int id);
}
