package esercizi.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GestioneStruttura {
	private Connection connection;
	
	public GestioneStruttura() throws SQLException {
		connection=DriverManagerConnectionPool.getConnection();
	}
	
	public void chiudiConnessione() throws SQLException {
		DriverManagerConnectionPool.releaseConnection(connection);
	}
	
	public Struttura getStrutturaAlbergo(String albergo) throws SQLException {
		PreparedStatement ps=connection.prepareStatement("select * from struttura where albergo=?");
		ps.setString(1, albergo);
		ResultSet rs=ps.executeQuery();
		Struttura struttura=null;
		while(rs.next()) {
			struttura=new Struttura();
			struttura.setAlbergo(rs.getString("albergo"));
			struttura.setCamere(rs.getString("camere"));
			struttura.setPosizione(rs.getString("posizione"));
			struttura.setPulizia(rs.getString("pulizia"));
			struttura.setServizi(rs.getString("servizi"));
		}
		return struttura;
	}
}
