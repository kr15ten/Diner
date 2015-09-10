package za.ac.cput.MichaelJansen.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.MichaelJansen.Domain.MenuItem;

/**
 * Created by Michael on 09/09/2015.
 */
@Repository
public interface MenuItemRepository extends CrudRepository<MenuItem,Integer> {
}
