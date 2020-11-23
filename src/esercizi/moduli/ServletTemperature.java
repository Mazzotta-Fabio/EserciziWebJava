package esercizi.moduli;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import esercizi.bean.Temperatura;
import esercizi.gestione.GestioneTemperature;

/**
 * Servlet implementation class ServletTemperature
 */
@WebServlet("/ServletTemperature")
public class ServletTemperature extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTemperature() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value=request.getParameter("c");
		Cookie [] cookies=request.getCookies();
		if(cookies!=null) {
			for(int i=0;i<cookies.length;i++) {
				if(cookies[i].getValue().equals("abilitazione")) {
					try {
						GestioneTemperature gt=new GestioneTemperature();
						List<Temperatura> list=gt.getAllTemperature(value);
						gt.chiudiConnessione();
						request.setAttribute("temperature", list);
						RequestDispatcher rd=getServletContext().getRequestDispatcher("/settimana.jsp");
						rd.forward(request, response);
					}
					catch(SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
		else {
			Cookie c=new Cookie("temperatura","abilitazione");
			c.setMaxAge(234*789);
			response.addCookie(c);
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
