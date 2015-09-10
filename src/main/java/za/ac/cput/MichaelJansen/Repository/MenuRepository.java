package za.ac.cput.MichaelJansen.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.MichaelJansen.Domain.Menu;

/**
 * Created by Michael on 07/09/2015.
 */
@Repository
public interface MenuRepository extends CrudRepository<Menu, Integer> {
}
