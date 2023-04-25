package com.twic.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import com.twic.dto.VilleDTO;
import com.twic.service.VilleService;

/**
 * Servlet implementation class ModifierVille
 */
public class ModifierVille extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierVille() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codeVille = request.getParameter("code");
		
		VilleService villeService = new VilleService();
		VilleDTO ville = villeService.getVilleByCode(codeVille);
		
		request.setAttribute("ville", ville);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/modifierVille.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String codeCommune = request.getParameter("codeCommune");
		String nomCommune = request.getParameter("nomCommune");
		String codePostal = request.getParameter("codePostal");
		String libelleAcheminement = request.getParameter("libelleAcheminement");
		String ligne = request.getParameter("ligne");
		String latitude = request.getParameter("latitude");
		String longitude = request.getParameter("longitude");
		
		System.out.println(nomCommune);
		
		VilleService villeService = new VilleService();
		villeService.test(codeCommune, nomCommune, codePostal, libelleAcheminement, ligne, latitude, longitude);
		
		doGet(request, response);
	}

}
