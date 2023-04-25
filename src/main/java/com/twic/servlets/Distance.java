package com.twic.servlets;

import com.twic.dto.VilleDTO;
import com.twic.service.VilleService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class Distance
 */
public class Distance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Distance() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void getVilles(HttpServletRequest request) throws IOException {
    	VilleService villeService = new VilleService();
		
		List<VilleDTO> villes = villeService.getAllVilles();
		request.setAttribute("villes", villes);	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getVilles(request);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/distance.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getVilles(request);
		
        String ville1 = request.getParameter("villeDepart");
        String ville2 = request.getParameter("villeArrivee");

        VilleService villeService = new VilleService();
        VilleDTO ville1Obj = villeService.getVilleByCode(ville1);
        VilleDTO ville2Obj = villeService.getVilleByCode(ville2);

        double distance = 0;
        if (ville1Obj != null && ville2Obj != null) {
            distance = villeService.getDistance(ville1, ville2);
        }

        request.setAttribute("ville1", ville1Obj);
        request.setAttribute("ville2", ville2Obj);
        request.setAttribute("distance", distance);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/distance.jsp");
        dispatcher.forward(request, response); 
    }

}
