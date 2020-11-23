package esercizi.gestione;

import java.sql.*;

import esercizi.bean.Autenticazione;
import esercizi.bean.InformazioniUtente;
/*Model gestione dati*/
public class GestioneInformazioniUtente {
	
	private Connection connection;
	
	public GestioneInformazioniUtente() throws SQLException {
		connection=DriverManagerConnectionPool.getConnection();
	}
	
	public InformazioniUtente getUtente(String argomento) throws SQLException {
		PreparedStatement ps=connection.prepareStatement("select * from informazioniutente where argomento=?");
		ps.setString(1, argomento);
		ResultSet resultSet=ps.executeQuery();
		while(resultSet.next()) {
			InformazioniUtente ut=new InformazioniUtente(resultSet.getString("NOME UTENTE"),resultSet.getString("PASSWORD"),resultSet.getString("ARGOMENTO"));
			return ut;
		}
		return null;
	}
	
	public void inserisciDati(String nome,String password,String argomento) throws SQLException {
		PreparedStatement ps=connection.prepareStatement("INSERT INTO `informazioniutente`(`Nome Utente`, `Password`, `Argomento`) VALUES (?,?,?)");
		ps.setString(1, nome);
		ps.setString(2, password);
		ps.setString(3, argomento);
		ps.executeUpdate();
		Statement statement=connection.createStatement();
		statement.execute("UPDATE `informazioniutente` SET `Password`='1544' WHERE `Password`= '154'");
	}
	
	public Autenticazione getAutenticazione(String user,String password) throws SQLException {
		PreparedStatement ps=connection.prepareStatement("select * from autenticazione where user=? and password=?");
		ps.setString(1, user);
		ps.setString(2, password);
		ResultSet rs=ps.executeQuery();
		Autenticazione aut=null;
		while(rs.next()) {
			aut=new Autenticazione();
			aut.setUser(rs.getString("USER"));
			aut.setPassword(rs.getString("PASSWORD"));
		}
		return aut;
		
	}
	public void chiudiConnessione() throws SQLException {
		DriverManagerConnectionPool.releaseConnection(connection);
	}
}
