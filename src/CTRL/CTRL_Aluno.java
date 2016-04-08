package CTRL;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MODEL.Aluno;

@WebServlet("/ManterAluno.do")
public class CTRL_Aluno extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pNome = request.getParameter("nome");
		String pEndereco = request.getParameter("endereco");
		String pEmail = request.getParameter("email");
		String pTelefone = request.getParameter("telefone");
		String pRg = request.getParameter("rg");
		String pCpf = request.getParameter("cpf");
		String pSenha = request.getParameter("senha");
		String acao = request.getParameter("botao");
		if (acao.equals("CADASTRAR")){
			Aluno aluno = new Aluno(0, pNome, pEndereco, pEmail, pTelefone, pRg, pCpf, pSenha);
			if(aluno.criar()){
				request.setAttribute("aluno", aluno);
				RequestDispatcher view =  
						request.getRequestDispatcher("aluno/sucesso_cadastro.jsp");
				view.forward(request, response);
				
				/*PrintWriter out = response.getWriter();
				out.println("<html><head><title>Aluno Cadastrado</title></head><body>");
				out.println("id: " + aluno.getCodAluno() + "<br>");
				out.println("nome: " + aluno.getNomeAluno() + "<br>");
				out.println("</body></html>");*/
			}
			//cliente.carregar();
			
		}
		/*else if (acao.equals("Deletar")){
			Aluno aluno = new Cliente (Integer.parseInt(pId));
			cliente.excluir();
			PrintWriter out = response.getWriter();
			out.println("<html><head><title>Cliente Apagado</title></head><body>");
			out.println("id: " + cliente.getId() + "<br>");
			out.println("</body></html>");
		}*/
		
	}
}
