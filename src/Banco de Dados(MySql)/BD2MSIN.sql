CREATE SCHEMA `BD2MSIN`;
use BD2MSIN;

CREATE  TABLE `BD2MSIN`.`TabelaCurso` (

  `Codigo` INT NOT NUll  AUTO_INCREMENT,
  `NomeCurso` VARCHAR(100) NULL ,
  `DataInicio` CHAR(15),
  `DataFim`CHAR(15),
  `Horario` CHAR(12),
  `NumeroVagas` INT,
  `Valor` FLOAT(10),
  `LabSala` INT(10),
  `Descricao` VARCHAR(100),
  `MatSoftwares` VARCHAR(100),
  `Area` CHAR(12) ,
  PRIMARY KEY (`Codigo`));
  
  CREATE  TABLE `BD2MSIN`.`TabelaAluno`  (

  `Ra` INT  AUTO_INCREMENT,
  `Nome` VARCHAR(50) ,
  `Endereco` VARCHAR(100),
  `Telefone` VARCHAR(15),
  `Email` VARCHAR(50),
  `RG`VARCHAR (20),
  `CPF` VARCHAR (20),
  PRIMARY KEY (`Ra`));
  
  
  
  CREATE  TABLE `BD2MSIN`.`TabelaMatricula` (

  `Matricula` INT NOT NUll  AUTO_INCREMENT,
  `DataMatricula` CHAR(15) ,
  `CodigoCurso` INT,
  `Valor` FLOAT(10),
  `RaAluno` INT,
  `StatusMatricula`CHAR (15),
  `StatusFinanceiro` CHAR(15),
  
  PRIMARY KEY (`Matricula`),
  FOREIGN KEY (CodigoCurso) REFERENCES TabelaCurso (Codigo),
  FOREIGN KEY (RaAluno) REFERENCES TabelaAluno (Ra));
  
  CREATE  TABLE `BD2MSIN`.`TabelaAtendente` (

  `Codigo` INT NOT NUll  AUTO_INCREMENT,
  `Nome` CHAR(15) ,
  PRIMARY KEY (`Codigo`));
   
   
  
  select*from TabelaAluno;
