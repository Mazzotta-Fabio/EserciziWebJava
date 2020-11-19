package esercizi.tabella;

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

import esercizi.bean.GestioneModello;
import esercizi.bean.Modello;

/**
 * Servlet implementation class ServletBici
 */
@WebServlet("/ServletBici")
public class ServletBici extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletBici() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie [] cookies=request.getCookies();
		if(cookies!=null) {
			for(int i=0;i<cookies.length;i++) {
				Cookie cookie=cookies[i];
				String name=cookie.getName();
				String value=cookie.getValue();
				if((name.equals("nome"))&&(value.equals("pippo"))) {
					try {
						GestioneModello gm=new GestioneModello();
						List<Modello> listaModelli=gm.getModelli();
						gm.chiudiConnessione();
						request.setAttribute("listaModelli", listaModelli);
						RequestDispatcher rd=getServletContext().getRequestDispatcher("/carica.jsp");
						rd.forward(request, response);
					}
					catch(SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
		else {
			Cookie newCookie=new Cookie("nome","pippo");
			newCookie.setMaxAge(365*36654);
			response.addCookie(newCookie);
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
