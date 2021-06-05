package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");// 数据库连接驱动
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		// 进行连接
		Connection connection = null;

		try {

			connection = DriverManager.getConnection(
					// 连接47.107.247.91服务器的3306端口，用于mysql服务
					"jdbc:mysql://47.107.247.91:3306/web?useSSL=false&serverTimezone=UTC", "root", "123456");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public static int exectuIUD(String sql, Object[] params) {
		// 无返回表项时的数据整合发送和获取
		int count = 0;
		Connection connection = BaseDao.getConnection();

		PreparedStatement ps = null;

		try {
			ps = connection.prepareStatement(sql);

			for (int i = 0; i < params.length; i++) {
				// 整合SQL语句
				ps.setObject(i + 1, params[i]);

			}
			count = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(null, ps, connection);
		}

		return count;
	}

	public static void closeAll(ResultSet rs, PreparedStatement ps, Connection connection) {
		// 关闭所有连接和相关参数
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if (ps != null)
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if (connection != null)
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
