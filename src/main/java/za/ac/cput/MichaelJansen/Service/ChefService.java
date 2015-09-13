package za.ac.cput.MichaelJansen.Service;

import za.ac.cput.MichaelJansen.Domain.Chef;

import java.util.List;

/**
 * Created by Michael on 13/09/2015.
 */
public interface ChefService {

    List<Chef> getChefs();

    Chef getChef(int id);
}
