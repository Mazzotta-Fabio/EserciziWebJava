package esercizi.moduli;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import esercizi.bean.Meteo;
import esercizi.gestione.GestioneTemperature;

/**
 * Servlet implementation class ServletMeteo
 */
@WebServlet("/ServletMeteo")
public class ServletMeteo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMeteo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml");
		response.setHeader("Content-type", "application/html+xml");
		String value=request.getParameter("day");
		List<Meteo> list = null;
		try {
			GestioneTemperature gt=new GestioneTemperature();
			list=gt.getAllMeteo(value);
			gt.chiudiConnessione();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		//response.setCharacterEncoding("UTF-8");
		StringBuffer sb=new StringBuffer();
		//sb.append("<? xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\" ?>");
		if(list!=null) {
			for(Meteo t:list) {
				sb.append("<Giorno>");
				sb.append(t.getGiorno());
				sb.append("</Giorno>");
				
				sb.append("<Temperatura>");
				sb.append(t.getTemperatura());
				sb.append("</Temperatura>");
				
				sb.append("<Ora>");
				sb.append(t.getOra());
				sb.append("</Ora>");
				
				sb.append("<Umidita>");
				sb.append(t.getUmidita());
				sb.append("</Umidita>");
			}
			System.out.println(sb.toString());
			response.getWriter().write(sb.toString());
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
