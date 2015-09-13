package za.ac.cput.MichaelJansen.Domain;

/**
 * Created by Michael on 13/09/2015.
 */
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestChef.class,
        TestManager.class,
        TestMenuItem.class,
        TestOrder.class,
        TestSalary.class,
        TestSale.class,
        TestSalesItem.class,
        TestShift.class,
        TestTable.class,
        TestWaiter.class
})
public class DomainTestSuite {
}
