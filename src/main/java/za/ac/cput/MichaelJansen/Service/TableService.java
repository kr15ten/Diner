package za.ac.cput.MichaelJansen.Service;

import za.ac.cput.MichaelJansen.Domain.Table;

import java.util.List;

/**
 * Created by Michael on 15/09/2015.
 */
public interface TableService {

    List<Table> getTables();

    Table getTable(int id);

}
