package com.twic.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.twic.dto.VilleDTO;
import com.twic.service.VilleService;

/**
 * Servlet implementation class AffichageVilles
 */
public class AffichageVilles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AffichageVilles() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void getVilles(HttpServletRequest request) throws IOException {
    	
		VilleService villeService = new VilleService();
		
		List<VilleDTO> villes = villeService.getAllVilles();
		
		List<List<VilleDTO>> sousListes = new ArrayList<>();
		int tailleSousListe = 50;
		for (int i = 0; i < villes.size(); i += tailleSousListe) {
		    sousListes.add(villes.subList(i, Math.min(i + tailleSousListe, villes.size())));
		}
		
		request.setAttribute("villes", sousListes);
		request.setAttribute("lastPage", sousListes.size());
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		String supprimer = request.getParameter("supprimer");
		
		if(page == null) {
			page = "1";
		}
		
		if(supprimer != null) {
			request.setAttribute("supprimer", supprimer);
			VilleService villeService = new VilleService();
			villeService.deleteVille(supprimer);
			System.out.println(supprimer);
		}
		
		request.setAttribute("currentPage", page);
		
		getVilles(request);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/villes.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
