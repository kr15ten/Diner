package za.ac.cput.MichaelJansen.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.MichaelJansen.Domain.Sale;
import za.ac.cput.MichaelJansen.Repository.SaleRepository;
import za.ac.cput.MichaelJansen.Service.SaleService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael on 15/09/2015.
 */
@Service
public class SaleServiceImpl implements SaleService{
    @Autowired
    SaleRepository repository;

    public List<Sale> getSales(){

        List<Sale> allSales = new ArrayList<Sale>();

        Iterable<Sale> sales = repository.findAll();
        for(Sale sale: sales)
        {
            allSales.add(sale);
        }

        return allSales;
    }

    public Sale getSale(int id){
        Sale sale;

        sale = repository.findOne(id);

        return sale;
    }
}
