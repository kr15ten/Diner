package za.ac.cput.MichaelJansen.Service;

import za.ac.cput.MichaelJansen.Domain.Manager;

import java.util.List;

/**
 * Created by Michael on 15/09/2015.
 */
public interface ManagerService {
    List<Manager> getManagers();

    Manager getManager(int id);
}
