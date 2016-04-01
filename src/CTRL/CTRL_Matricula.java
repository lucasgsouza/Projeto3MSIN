package CTRL;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MODEL.MODEL_Matricula;
import TO.TO_Matricula;

/**
 * Servlet implementation class CTRL_Curso
 */
@WebServlet("/ManterMatrciula.do")
public class CTRL_Matricula extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pMatricula = request.getParameter("Matricula");
		String pDataMatricula = request.getParameter("DataMatricula");
		String pCodigoCurso = request.getParameter("CodigoCurso");
		String pValor = request.getParameter("Valor");
		String pRaAluno = request.getParameter("RaAluno");
		String pStatusMatricula = request.getParameter("StatusMatricula");
		String pStatusFinanceiro = request.getParameter("StatusFinanceiro");
		String paçao = request.getParameter("Açao");
		
		int Matricula, CodigoCurso, RaAluno;

		float Valor;

		try {
			Matricula = Integer.parseInt(pMatricula);
			CodigoCurso = Integer.parseInt(pCodigoCurso);
			RaAluno = Integer.parseInt(pRaAluno);
			Valor = Float.parseFloat(pValor);
		} catch (NumberFormatException e) {
			Matricula = 0;
			CodigoCurso = 0;
			RaAluno= 0;
			Valor = 0;
			e.printStackTrace();
		}

		MODEL_Matricula MODELMatricula = new MODEL_Matricula(Matricula, pDataMatricula, CodigoCurso, Valor,RaAluno,pStatusMatricula, pStatusFinanceiro);

		if (paçao.equals("Cadastrar")) {
		MODELMatricula.Cadastrar_Matricula();
		} else if (paçao.equals("Alterar")) {
			MODELMatricula.Alterar_Matricula();
		} else if (paçao.equals("Excluir")) {
		MODELMatricula.Excluir_Matricula(Matricula);
		} else if (paçao.equals("Consultar")) {
			MODELMatricula.Consultar_Matricula(Matricula);
		}

		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Aluno Cadastrado</title></head><body>");
		out.println("Matricula " + MODELMatricula.getMatricula()+ "<br>");
		out.println("DataMatricula " + MODELMatricula.getDataMatricula()+ "<br>");
		out.println("CodigoCurso: " + MODELMatricula.getCodigoCurso() + "<br>");
		out.println("Valor: " +MODELMatricula.getValor() + "<br>");
		out.println("RaAluno: " + MODELMatricula.getRaAluno() + "<br>");
		out.println("StatusMatricula " + MODELMatricula.getStatusMatricula() + "<br>");
		out.println("StatusFinanceiro: " + MODELMatricula.getStatusFinanceiro() + "<br>");
		
		out.println("</body></html>");
	}

}