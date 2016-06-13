package com.eliasnogueira.workshop.suites;

import com.eliasnogueira.workshop.rest.APITest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Test suit for rest package
 * @author Elias Nogueira <elias.nogueira@gmail.com>
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
            APITest.class
        }
)
public class APITestSuite {
 
}
