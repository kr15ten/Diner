package za.ac.cput.MichaelJansen.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.MichaelJansen.Domain.SalesItem;

/**
 * Created by Michael on 12/09/2015.
 */
@Repository
public interface SalesItemRepository extends CrudRepository<SalesItem,Integer>{
}
