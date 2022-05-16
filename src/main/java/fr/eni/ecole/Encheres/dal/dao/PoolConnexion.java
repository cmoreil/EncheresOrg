package fr.eni.ecole.Encheres.dal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PoolConnexion {

	public static Connection getConnexion(String database) throws ClassNotFoundException, SQLException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String connectionUrl = "jdbc:sqlserver://localhost;database=" + database + ";";
		Connection con = DriverManager.getConnection(connectionUrl, "sa", "Pa$$w0rd");
		return con;
	}

}
