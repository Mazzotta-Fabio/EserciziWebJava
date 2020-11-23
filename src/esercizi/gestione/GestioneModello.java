package esercizi.gestione;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import esercizi.bean.Modello;

public class GestioneModello {
	
	private Connection conn;
	
	public GestioneModello() throws SQLException {
		conn=DriverManagerConnectionPool.getConnection();
	}
	
	public List<Modello> getModelli() throws SQLException{
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("select * from modelli");
		List<Modello> listaModelli=new ArrayList<Modello>();
		while(rs.next()) {
			Modello mod=new Modello();
			mod.setMarca(rs.getString("Modello"));
			mod.setS275(rs.getString("27.5"));
			mod.setS29(rs.getString("29"));
			listaModelli.add(mod);
		}
		return listaModelli;
	}
	
	public void chiudiConnessione() throws SQLException {
		DriverManagerConnectionPool.releaseConnection(conn);
	}
}
