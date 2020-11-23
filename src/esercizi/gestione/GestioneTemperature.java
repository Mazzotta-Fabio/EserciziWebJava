package esercizi.gestione;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import esercizi.bean.Meteo;
import esercizi.bean.Temperatura;

public class GestioneTemperature {
	private Connection conn;
	
	public GestioneTemperature() throws SQLException {
		conn=DriverManagerConnectionPool.getConnection();
	}
	
	public List<Temperatura> getAllTemperature(String codice) throws SQLException{
		PreparedStatement ps=conn.prepareStatement("select * from tempetature where cod=?");
		ps.setString(1, codice);
		ResultSet rs=ps.executeQuery();
		List<Temperatura> list=new ArrayList<Temperatura>();
		while(rs.next()) {
			Temperatura t=new Temperatura();
			t.setCodice(rs.getString("cod"));
			t.setGiorno(rs.getString("giorno"));
			t.setMin(rs.getString("min"));
			t.setMax(rs.getString("max"));
			list.add(t);
		}
		return list;
	}
	
	public List<Meteo> getAllMeteo(String giorno) throws SQLException{
		PreparedStatement ps=conn.prepareStatement("select * from meteo where giorno=?");
		ps.setString(1, giorno);
		ResultSet rs=ps.executeQuery();
		List<Meteo> list=new ArrayList<Meteo>();
		while(rs.next()) {
			Meteo t=new Meteo();
			t.setGiorno(rs.getString("giorno"));
			t.setUmidita(rs.getString("umidita"));
			t.setOra(rs.getString("ora"));
			t.setTemperatura(rs.getString("temperatura"));
			list.add(t);
		}
		return list;
	}
	public void chiudiConnessione() throws SQLException {
		DriverManagerConnectionPool.releaseConnection(conn);
	}
}
