package za.ac.cput.MichaelJansen.conf;

import za.ac.cput.MichaelJansen.Domain.Order;
import za.ac.cput.MichaelJansen.Domain.Table;

import java.util.List;

/**
 * Created by Michael on 07/09/2015.
 */
public class TableFactory {
    public static Table createTable(int seats,List<Order>orders,Boolean available)
    {
        Table table = new Table.Builder(seats, orders, available)
                .build();
        return table;
    }
}
