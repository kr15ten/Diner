package za.ac.cput.MichaelJansen.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.MichaelJansen.Domain.MenuItem;
import za.ac.cput.MichaelJansen.Domain.Order;
import za.ac.cput.MichaelJansen.Repository.MenuItemRepository;
import za.ac.cput.MichaelJansen.Repository.OrderRepository;
import za.ac.cput.MichaelJansen.Service.OrderService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael on 15/09/2015.
 */
@Service
public class OrderServiceImpl implements OrderService {
    
    @Autowired
    OrderRepository repository;

    @Autowired
    MenuItemRepository menuItemRepository;

    Order order;

    public List<Order> getOrders(){

        List<Order> allOrders = new ArrayList<Order>();

        Iterable<Order> orders = repository.findAll();
        for(Order order: orders)
        {
            allOrders.add(order);
        }

        return allOrders;
    }

    public Order getOrder(int id){
        order = repository.findOne(id);

        return order;
    }

    public List<MenuItem> getOrderedMenuItems(int id){
        List<MenuItem> menuItems = new ArrayList<MenuItem>();

        order = getOrder(id);
        MenuItem menuItem;

        for(int x = 0;x < order.getItems().size();x++)
        {
            menuItem = menuItemRepository.findOne(order.getItems().get(x).getMenuItemId());

            menuItems.add(menuItem);
        }

        return menuItems;
    }
}
