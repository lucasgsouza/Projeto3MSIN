package CTRL;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TO.TO_Curso;
import MODEL.MODEL_Curso;

/**
 * Servlet implementation class CTRL_Curso
 */
@WebServlet("/ManterCurso.do")
public class CTRL_Curso extends HttpServlet {
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
		String pCodigo = request.getParameter("Codigo");
		String pNomedoCurso = request.getParameter("Nome");
		String pDataInicio = request.getParameter("DataInicio");
		String pDataFim = request.getParameter("DataFim");
		String pNumeroVagas = request.getParameter("NumeroVagas");
		String pValor = request.getParameter("Valor");
		String pLabSala = request.getParameter("LabSala");
		String pHorario = request.getParameter("Horario");
		String pDescricao = request.getParameter("Descricao");
		String pMatSoftwares = request.getParameter("MatSoftwares");
		String pArea = request.getParameter("Area");
		String paçao = request.getParameter("Açao");

		int Codigo, NumeroVagas, LabSala;
		float Valor;

		try {
			Codigo = Integer.parseInt(pCodigo);
			NumeroVagas = Integer.parseInt(pNumeroVagas);
			LabSala = Integer.parseInt(pLabSala);
			Valor = Float.parseFloat(pValor);
		} catch (NumberFormatException e) {
			Codigo = 0;
			NumeroVagas = 0;
			LabSala = 0;
			Valor = 0;
			e.printStackTrace();
		}

		MODEL_Curso Curso = new MODEL_Curso(Codigo, pNomedoCurso, pDataInicio, pDataFim, pHorario, NumeroVagas, Valor,
				LabSala, pDescricao, pMatSoftwares, pArea);

		if (paçao.equals("Cadastrar")) {
			Curso.Cadastrar_Curso();
		} else if (paçao.equals("Alterar")) {
			Curso.Alterar_Curso();
		} else if (paçao.equals("Excluir")) {
			Curso.Excluir_Curso(Codigo);
		} else if (paçao.equals("Consultar")) {
			Curso.Consultar_Curso(Codigo);
		}

		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Aluno Cadastrado</title></head><body>");
		out.println("Codigo: " + Curso.getCodigo() + "<br>");
		out.println("Nome: " + Curso.getNomeCurso()+"<br>");
		out.println("DataInicio: " + Curso.getDataInicio() + "<br>");
		out.println("DataFim: " + Curso.getDataFim() + "<br>");
		out.println("NumeroVagas: " + Curso.getNumeroVagas() + "<br>");
		out.println("Valor: " + Curso.getValor() + "<br>");
		out.println("LabSala: " + Curso.getLabSala() + "<br>");
		out.println("Horario: " + Curso.getHorario() + "<br>");
		out.println("Descricao: " +Curso.getDescricao() + "<br>");
		out.println("MatSoftwares: " + Curso.getMatSoftwares() + "<br>");
		out.println("Area: " + Curso.getArea()+ "<br>");
		out.println("</body></html>");
	}

}