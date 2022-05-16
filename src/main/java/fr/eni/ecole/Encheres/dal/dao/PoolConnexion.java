package fr.eni.ecole.Encheres.dal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PoolConnexion {

	//pour travailler sur la même DB (+manip à faire sur le PC de Mathias + se co à 10.50.101.1 dans SQLServer) : 
	public static Connection getConnexion(String database) throws ClassNotFoundException, SQLException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String connectionUrl = "jdbc:sqlserver://10.50.101.1:1433;database=" + database + ";";
		Connection con = DriverManager.getConnection(connectionUrl, "sa", "Pa$$w0rd");
		return con;
	}

}
