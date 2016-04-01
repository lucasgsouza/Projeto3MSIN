package Teste;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.SQLException;

import org.junit.Test;

import Factory.ConnectionFactory;

public class Teste_Factory {

	@Test
	public void testObterConexao() {
		try {
			assertNotNull("Testar se a Conexão é Nula", ConnectionFactory.obtemConexao());
		} catch (SQLException e) {
			e.printStackTrace();
			fail("Gerou SQLException");
		}
	}

}
