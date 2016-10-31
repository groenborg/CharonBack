package testsuites;

import contracttest.UserContractHolder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import services.ContractService;

/**
 * Created by simon on 31/10/2016.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({contracttest.UserContractTest.class})
public class TestSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
        UserContractHolder.contract = new ContractService();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
}
