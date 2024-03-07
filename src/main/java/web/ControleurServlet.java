package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import dao.IEquipeDao;
import dao.EquipeDaoImpl;
import metier.entities.Equipe;

@WebServlet (name="cs",urlPatterns= {"/controleur","*.do"})
public class ControleurServlet extends HttpServlet {
	
	 IEquipeDao metier;
	 @Override
	public void init() throws ServletException {
		metier = new EquipeDaoImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest request,
			             HttpServletResponse response) 
			            throws ServletException, IOException {
		String path=request.getServletPath();
		if (path.equals("/index.do"))
		{
			request.getRequestDispatcher("Equipes.jsp").forward(request,response);
		}
		else if (path.equals("/chercher.do"))
		{
			String motCle=request.getParameter("motCle");
			EquipeModele model= new EquipeModele();
			model.setMotCle(motCle);
			List<Equipe> prods = metier.EquipesParMC(motCle);
			model.setEquipes(prods);
			request.setAttribute("model", model);
			request.getRequestDispatcher("Equipes.jsp").forward(request,response);
		}
		else if (path.equals("/saisie.do")  )
		{
			request.getRequestDispatcher("saisieEquipe.jsp").forward(request,response);
		}
		else if (path.equals("/save.do")  && request.getMethod().equals("POST"))
		{
		    String nom=request.getParameter("nom");
			double rank = Double.parseDouble(request.getParameter("rank"));
			Equipe p = metier.save(new Equipe(nom,rank));
			request.setAttribute("Equipe", p);
			request.getRequestDispatcher("confirmation.jsp").forward(request,response);
		}
		else if (path.equals("/supprimer.do"))
		{
		    Long id= Long.parseLong(request.getParameter("id"));
		    metier.deleteEquipe(id);
		    response.sendRedirect("chercher.do?motCle=");
					
			//request.getRequestDispatcher("confirmation.jsp").forward(request,response);
		}
		else if (path.equals("/editer.do")  )
		{
			Long id= Long.parseLong(request.getParameter("id"));
		    Equipe p = metier.getEquipe(id);
		    request.setAttribute("Equipe", p);
			request.getRequestDispatcher("editerEquipe.jsp").forward(request,response);
		}
		else if (path.equals("/update.do")  )
		{
			 Long id = Long.parseLong(request.getParameter("id"));
			 String nom=request.getParameter("nom");
			 double rank = Double.parseDouble(request.getParameter("rank"));
			 Equipe p = new Equipe();
			 p.setIdEquipe(id);
			 p.setNomEquipe(nom);
			 p.setrank(rank);
			 metier.updateEquipe(p);
			 request.setAttribute("Equipe", p);
			 request.getRequestDispatcher("confirmation.jsp").forward(request,response);
		}
		else
		{
			response.sendError(Response.SC_NOT_FOUND);		
		}	
	}
	
	@Override
	protected void doPost(HttpServletRequest request, 
						  HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}