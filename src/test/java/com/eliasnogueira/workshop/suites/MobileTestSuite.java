package com.eliasnogueira.workshop.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.eliasnogueira.workshop.mobile.AdicionarPessoaTeste;
import com.eliasnogueira.workshop.mobile.AlterarPessoaTeste;
import com.eliasnogueira.workshop.mobile.RemoverPessoaTeste;

/**
 * Test suite for mobile package
 * @author Elias Nogueira <elias.nogueira@gmail.com>
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
            AdicionarPessoaTeste.class,
            AlterarPessoaTeste.class, 
            RemoverPessoaTeste.class
            
        }
)
public class MobileTestSuite {
    
}
