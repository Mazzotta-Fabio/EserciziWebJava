package esercizi.moduli;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import esercizi.bean.InformazioniUtente;
import esercizi.gestione.GestioneInformazioniUtente;

/**
 * Servlet implementation class ServletPersistenzadati
 */
@WebServlet("/ServletPersistenzadati")
public class ServletPersistenzadati extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPersistenzadati() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=getServletContext().getRequestDispatcher("/gestionePersistenza.jsp");
		GestioneInformazioniUtente giu = null;
		InformazioniUtente iu = null;
		try {
			giu = new GestioneInformazioniUtente();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("bean",iu);
		String argomento="";
	    if(request.getParameter("XHTML")!=null){
	    	argomento=argomento+request.getParameter("XHTML");
	    }
	    if(request.getParameter("IMMAGINI")!=null){
	    	 argomento=argomento+request.getParameter("IMMAGINI");
	    }
	    if(request.getParameter("HTML")!=null){
	    	argomento=argomento+request.getParameter("HTML");
	    }
	    if(request.getParameter("COLL")!=null){
	    	argomento=argomento+request.getParameter("COLL");
	    }
	    if(request.getParameter("OGGETTI")!=null){
	    	argomento=argomento+request.getParameter("OGGETTI");
	    }
	    try {
			giu.inserisciDati(request.getParameter("nome"), request.getParameter("pass"), argomento);
			iu=giu.getUtente("xml");
			request.setAttribute("bean",iu);
			giu.chiudiConnessione();
	    } catch (SQLException e) {
			e.printStackTrace();
		}
	    
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
