package za.ac.cput.MichaelJansen.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.MichaelJansen.Domain.Table;
import za.ac.cput.MichaelJansen.Repository.TableRepository;
import za.ac.cput.MichaelJansen.Service.TableService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael on 15/09/2015.
 */
@Service
public class TableServiceImpl implements TableService {

    @Autowired
    TableRepository repository;

    public List<Table> getTables(){

        List<Table> allTables = new ArrayList<Table>();

        Iterable<Table> tables = repository.findAll();
        for(Table table: tables)
        {
            allTables.add(table);
        }

        return allTables;
    }

    public Table getTable(int id){
        Table table;

        table = repository.findOne(id);

        return table;
    }
    
}
