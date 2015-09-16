package za.ac.cput.MichaelJansen.Service;

import za.ac.cput.MichaelJansen.Domain.Sale;

import java.util.List;

/**
 * Created by Michael on 15/09/2015.
 */
public interface SaleService {
    List<Sale> getSales();

    Sale getSale(int id);
}
