package Projeto3MSIN;

import java.sql.Connection;

/*N�o � uma classe � uma interface*/
public interface Connect{

    public Connection getConnection();    
    public void closeConnection();
}