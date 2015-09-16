package za.ac.cput.MichaelJansen.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.MichaelJansen.Domain.SalesItem;
import za.ac.cput.MichaelJansen.Repository.SalesItemRepository;
import za.ac.cput.MichaelJansen.Service.SalesItemService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael on 15/09/2015.
 */
@Service
public class SalesItemServiceImpl implements SalesItemService {

    @Autowired
    SalesItemRepository repository;

    public List<SalesItem> getSalesItems(){

        List<SalesItem> allSalesItems = new ArrayList<SalesItem>();

        Iterable<SalesItem> salesItems = repository.findAll();
        for(SalesItem salesItem: salesItems)
        {
            allSalesItems.add(salesItem);
        }

        return allSalesItems;
    }

    public SalesItem getSalesItem(int id){
        SalesItem salesItem;

        salesItem = repository.findOne(id);

        return salesItem;
    }
    
}
