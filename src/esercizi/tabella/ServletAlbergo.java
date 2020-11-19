package esercizi.tabella;

import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

import esercizi.bean.GestioneStruttura;
import esercizi.bean.Struttura;

/**
 * Servlet implementation class ServletAlbergo
 */
@WebServlet("/ServletAlbergo")
public class ServletAlbergo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAlbergo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			GestioneStruttura gs=new GestioneStruttura();
			String albergo=request.getParameter("nomealbergo");
			Struttura st=gs.getStrutturaAlbergo(albergo);
			gs.chiudiConnessione();
			response.setContentType("text/xml");
			StringBuffer xml=new StringBuffer();
			xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
			xml.append("<response>");
			if(st!=null) {
				
				xml.append("<Albergo>");
				xml.append(st.getAlbergo());
				xml.append("</Albergo>");
			    
				xml.append("<Camere>");
				xml.append(st.getCamere());
				xml.append("</Camere>");
			
				xml.append("<Posizione>");
				xml.append(st.getPosizione());
				xml.append("</Posizione>");
			
				xml.append("<Servizi>");
				xml.append(st.getServizi());
				xml.append("</Servizi>");
			
				xml.append("<Pulizia>");
				xml.append(st.getPulizia());
				xml.append("</Pulizia>");
				
			}
			else {
				xml.append("Codice Albergo Invalido");
			}
			
			xml.append("</response>");
			System.out.println(xml);
			response.getWriter().write(xml.toString());
			
		} catch(Exception e) {
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
