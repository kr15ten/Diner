package za.ac.cput.MichaelJansen.Service;

import za.ac.cput.MichaelJansen.Domain.SalesItem;

import java.util.List;

/**
 * Created by Michael on 15/09/2015.
 */
public interface SalesItemService {

    List<SalesItem> getSalesItems();

    SalesItem getSalesItem(int id);
}
