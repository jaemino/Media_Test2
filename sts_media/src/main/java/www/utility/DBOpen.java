package www.utility;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.stereotype.Component;

@Component
public class DBOpen {
  public DBOpen(){
    System.out.println(">>>>>>>>>>DBOpen.java auto created...");
  }
  
  public Connection getConnection(){
    Connection con = null;
  
    //------------------------------------------------------------
    // DBMS ���� ����
    //------------------------------------------------------------
    // String url = "jdbc:oracle:thin:@121.160.41.249:20131:oracle11g2"; // ���� IP
    try{
      String url = "jdbc:oracle:thin:@JP:1521:XE";  // ��ü ��ġ
      String id = "soldesk";
      String pass = "1234";
      Class.forName("oracle.jdbc.driver.OracleDriver"); 
      con = DriverManager.getConnection(url, id, pass); // DBMS ���� ����
    }catch(Exception e){
      System.out.println(e.toString());
    }
    //------------------------------------------------------------
    return con;
  }

}
