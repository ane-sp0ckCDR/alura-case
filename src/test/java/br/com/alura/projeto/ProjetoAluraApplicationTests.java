package br.com.alura.projeto;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Disabled("Teste desabilitado pois tenta subir o contexto completo, incluindo JSP")
class ProjetoAluraApplicationTests {

	@Test
	void contextLoads() {

	}

}
