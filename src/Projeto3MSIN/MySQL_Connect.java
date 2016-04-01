package Projeto3MSIN;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


abstract class MySQL_Connect implements Connect {

   // atributo
   public Connection conn;

   // construtor
   public MySQL_Connect() {
      conn            = null;
      String url      = "jdbc:mysql://localhost/"; // localizacao do servidor
      String dbName   = "BD2MSIN";             // nome do banco de dados
      String driver   = "com.mysql.jdbc.Driver";   // nome do driver de conexao (esta na pasta)
      String userName = "root";                    // nome do usuario do banco
      String password = "root";                   // respectiva senha
      
      try {
         Class.forName(driver);
         conn = DriverManager.getConnection(url + dbName, userName, password);
      }
      catch (Exception e) {
         JOptionPane.showMessageDialog(
                     null,
                    "Erro no Banco de Dados!\n\nContate seu Administrador do Sistema!",
                    "Erro...",
                    JOptionPane.WARNING_MESSAGE
            );
         e.printStackTrace();
      }
   }
   public Connection getConnection(){
      return conn;
   }
    
   public void closeConnection() {
      try                { 
         conn.close(); 
      }
      catch(Exception e) { 
         e.printStackTrace(); 
      }
   } 
}