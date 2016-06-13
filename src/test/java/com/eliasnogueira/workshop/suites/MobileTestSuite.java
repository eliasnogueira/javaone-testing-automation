package com.eliasnogueira.workshop.suites;

import com.eliasnogueira.workshop.mobile.PesquisaPessoaScrollTeste;
import com.eliasnogueira.workshop.mobile.RemoverPessoaTeste;
import com.eliasnogueira.workshop.mobile.AdicionarPessoaTeste;
import com.eliasnogueira.workshop.mobile.AlterarPessoaTeste;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Test suite for mobile package
 * @author Elias Nogueira <elias.nogueira@gmail.com>
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
            AdicionarPessoaTeste.class,
            AlterarPessoaTeste.class, 
            PesquisaPessoaScrollTeste.class, 
            RemoverPessoaTeste.class
            
        }
)
public class MobileTestSuite {
    
}
