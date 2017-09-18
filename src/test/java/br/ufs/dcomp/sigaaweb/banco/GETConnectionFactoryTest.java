package br.ufs.dcomp.sigaaweb.banco;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import org.junit.Test;

import br.ufs.dcomp.sigaaweb.util.ConnectionFactory;

public class GETConnectionFactoryTest {
	Connection conn;

	@Test
	public final void testGetConnection() {
		conn = ConnectionFactory.getConnection();
		
		assertNotNull(conn);
	}
}
