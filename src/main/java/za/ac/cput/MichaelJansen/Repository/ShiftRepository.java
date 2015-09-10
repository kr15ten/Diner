package za.ac.cput.MichaelJansen.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.MichaelJansen.Domain.Shift;

/**
 * Created by Michael on 09/09/2015.
 */
@Repository
public interface ShiftRepository extends CrudRepository<Shift,Integer> {
}
