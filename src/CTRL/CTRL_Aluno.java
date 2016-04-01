package CTRL;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MODEL.MODEL_Aluno;;

/**
 * Servlet implementation class CTRL_Aluno
 */
@WebServlet("/ManterAluno.do")
public class CTRL_Aluno extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pRa = request.getParameter("Ra");
		String pNome = request.getParameter("Nome");
		String pEndereco = request.getParameter("Endereco");
		String pEmail = request.getParameter("Email");
		String pTelefone = request.getParameter("Telefone");
		String pRG = request.getParameter("RG");
		String pCPF = request.getParameter("CPF");
		String paçao = request.getParameter("Açao");

		int Ra;

		try {
			Ra = Integer.parseInt(pRa);
		} catch (NumberFormatException e) {
			Ra = 0;
			e.printStackTrace();
		}

		MODEL_Aluno Aluno = new MODEL_Aluno(Ra, pNome, pEndereco, pEmail, pTelefone, pRG, pCPF);

		if (paçao.equals("Cadastrar")) {
			Aluno.Cadastrar_Aluno();
		} else if (paçao.equals("Alterar")) {
			Aluno.Alterar_Aluno();
		} else if (paçao.equals("Excluir")) {
			Aluno.Excluir_Aluno(Ra);
		} else if (paçao.equals("ConsultarRA")) {
			Aluno.Consultar_Aluno(Ra);
		}
		

		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Aluno Cadastrado</title></head><body>");
		out.println("RA: " + Aluno.getRa()+ "<br>");
		out.println("Nome: " + Aluno.getNome() + "<br>");
		out.println("Endereço: " + Aluno.getEndereco()+ "<br>");
		out.println("E-mail: " + Aluno.getEmail()+ "<br>");
		out.println("Telefone: " + Aluno.getTelefone()+ "<br>");
		out.println("RG: " + Aluno.getRG()+ "<br>");
		out.println("CPF: " + Aluno.getCPF()+ "<br>");
		out.println("</body></html>");
	}

}
