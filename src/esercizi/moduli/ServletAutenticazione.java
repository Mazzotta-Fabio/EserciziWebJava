package esercizi.moduli;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import esercizi.bean.Autenticazione;
import esercizi.gestione.GestioneInformazioniUtente;

/**
 * Servlet implementation class ServletModuli
 */
@WebServlet("/Autenticazione")
public class ServletAutenticazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAutenticazione() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			GestioneInformazioniUtente giu=new GestioneInformazioniUtente();
			Autenticazione aut=giu.getAutenticazione(request.getParameter("user"), request.getParameter("password"));
			giu.chiudiConnessione();
			String paginaEsito;
			if(aut==null) {	
				paginaEsito="/errore.html";
			}
			else {
				paginaEsito="/autenticazione.jsp";
				request.setAttribute("Autenticazione", aut);
			}
			RequestDispatcher rd=getServletContext().getRequestDispatcher(paginaEsito);
			rd.forward(request, response);
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
