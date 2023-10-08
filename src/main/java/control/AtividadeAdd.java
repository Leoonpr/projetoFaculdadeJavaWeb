package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import dao.AtividadeDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atividade;

/**
 * Servlet implementation class AtividadeAdd
 */
public class AtividadeAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AtividadeAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		
		Atividade atividade = new Atividade();
		atividade.setNome(nome);

		AtividadeDao atvDao = new AtividadeDao();
		
		try {
			atvDao.adicionar(atividade);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PrintWriter out = response.getWriter();
		out.println("<p>O nome da ativadade: " + atividade.getNome() + "</p>");
		out.println("<a href=\"/sisacademia/index.jsp\"> Voltar ao Menu Inicial </a>\r\n");



	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
