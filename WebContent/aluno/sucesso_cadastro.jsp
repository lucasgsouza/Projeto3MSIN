<%@ page language= "java" contentType= "text/html; charset=UTF - 8"     pageEncoding= "ISO-8859-1" %>
<%@page import= "MODEL.Aluno" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="shortcut icon" href="../assets/ico/favicon.png">
	<link href="../css/bootstrap.min.css" rel="stylesheet">
	<link href="../css/styles.css" rel="stylesheet">
	<link href="../css/queries.css" rel="stylesheet">
	<link rel="stylesheet" href="../css/flexslider.css" type="text/css">
	<link rel="stylesheet" href="../css/animate.css" type="text/css">
	<link href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">

    <title>Escola de Cursos</title>

    <!-- Bootstrap core CSS -->
    <link href="../assets/css/bootstrap.css" rel="stylesheet">
    <link href="../assets/css/font-awesome.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../assets/css/main.css" rel="stylesheet">


    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <!-- Fixed navbar -->
    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">PR<i class="fa fa-circle"></i>JETO</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="../index.html">HOME</a></li>
            <li class="menu-drop active">
            	<a href="#">ALUNO ▾</a>
            	<ul class="dropdown">
	                <li><a href="cadastrar_aluno.html">Cadastrar</a></li>
	                <li><a href="alterar_aluno.html">Alterar</a></li>
	                <li><a href="consultar_aluno.html">Consultar</a></li>
	                <li><a href="excluir_aluno.html">Excluir</a></li>
            	</ul>
            </li>
            <li class="menu-drop">
            	<a href="#">CURSO ▾</a>
            	<ul class="dropdown">
	                <li><a href="../curso/cadastrar_curso.html">Cadastrar</a></li>
	                <li><a href="../curso/alterar_curso.html">Alterar</a></li>
	                <li><a href="../curso/consultar_curso.html">Consultar</a></li>
	                <li><a href="../curso/excluir_curso.html">Excluir</a></li>
            	</ul>
            </li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>

	<div id="blue">
		<div class="container">
			<div class="row centered">
				<div class="col-lg-8 col-lg-offset-2">
				<h4>ALUNO CADATRADO COM SUCESSO</h4>
				<p><img src="../assets/img/success.png" style="width: 60px;"></p>
				</div>
			</div><!-- row -->
		</div><!-- container -->
	</div><!--  bluewrap -->


	<div class="container w">
		
		<form name="signup-form">
			<div>
				<%Aluno aluno = (Aluno)request.getAttribute("aluno"); %> 
				<p>RA:  <%=aluno.getCodAluno() %></p>
				<br><br>
				<p>Nome: <%=aluno.getNomeAluno() %></p>
				<br><br>
				<p>Endereço: <%=aluno.getEnderecoAluno() %></p>
				<br><br>
				<p>E-mail: <%=aluno.getEmailAluno() %></p>	
				<br><br>		
				<p>Telefone: <%=aluno.getTelefoneAluno() %></p>
				<br><br>
				<p>RG: <%=aluno.getRgAluno() %></p>
				<br><br>
				<p>CPF: <%=aluno.getCpfAluno() %></p>
			</div>


		</form>

	</div><!-- container -->

	<br>

	<div id="f">
		<div class="container">
			<div class="row centered">
				<a href="#"><i class="fa fa-twitter"></i></a><a href="#"><i class="fa fa-facebook"></i></a><a href="#"><i class="fa fa-dribbble"></i></a>
		
			</div><!-- row -->
		</div><!-- container -->
	</div><!-- Footer -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="../assets/js/bootstrap.min.js"></script>
  </body>
</html>
