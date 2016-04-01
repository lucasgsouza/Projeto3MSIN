package Projeto3MSIN;

import java.sql.Connection;

/*Não é uma classe é uma interface*/
public interface Connect{

    public Connection getConnection();    
    public void closeConnection();
}