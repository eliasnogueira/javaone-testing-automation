package com.eliasnogueira.workshop.suites;

import com.eliasnogueira.workshop.web.AdicionarPessoaTeste;
import com.eliasnogueira.workshop.web.AlterarPessoaTeste;
import com.eliasnogueira.workshop.web.RemoverPessoaTeste;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Suite de teste para o pacote web
 * @author Elias Nogueira <elias.nogueira@gmail.com>
 */
@RunWith(Suite.class)
@SuiteClasses(
        {
            AdicionarPessoaTeste.class,
            AlterarPessoaTeste.class,
            RemoverPessoaTeste.class
        }
)
public class WebTestSuite {

}
