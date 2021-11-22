package Co.empresa.eclipseExamen.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionPostgreSQL {
	private Connection con = null;
	private static ConexionPostgreSQL db;
	private PreparedStatement preparedStatement;

	private static final String url = " queenie.db.elephantsql.com";
	private static final String dbName = "mnjgxshj";
	private static final String driver = "org.postgresql.Driver";
	private static final String userName = "mnjgxshj";
	private static final String password = "Uzjqo00sxV0W9OzPEB1q3wpoVvGMbbUV";
	
	
	// Conéctate a la base de datos
			public ConexionPostgreSQL() {
				try {
					Class.forName(driver);
					con = (Connection)DriverManager.getConnection(url + dbName, userName, password);
					System.out.println("Conexion exitosa!");

				} catch (ClassNotFoundException e) {
					e.printStackTrace();

				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("¡Error al conectarse a la base de datos!");

				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("¡Error al cargar el controlador!");
				}

			}

			// metodo Singlenton
			public static ConexionPostgreSQL singlenton() {
				if (db == null) {
					db = new ConexionPostgreSQL();
				}
				return db;
			}

			// cerrar conexion a la base de datos
			public void cerrarConexion() {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			// metodo para consultar
			public ResultSet query() throws SQLException {
				ResultSet res = preparedStatement.executeQuery();
				return res;
			}

			// metodo para actualizar
			public int execute() throws SQLException {
				int result = preparedStatement.executeUpdate();
				return result;
			}

			// metodo para hacer la conexion
			public Connection getCon() {
				return this.con;
			}

			// metodo para iniciar la conexion
			public PreparedStatement setPreparedStatement(String sql) throws SQLException {
				this.preparedStatement = con.prepareStatement(sql);
				return this.preparedStatement;
			}
	
	
}
