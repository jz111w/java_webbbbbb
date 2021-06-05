package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");// ���ݿ���������
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		// ��������
		Connection connection = null;

		try {

			connection = DriverManager.getConnection(
					// ����47.107.247.91��������3306�˿ڣ�����mysql����
					"jdbc:mysql://47.107.247.91:3306/web?useSSL=false&serverTimezone=UTC", "root", "123456");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public static int exectuIUD(String sql, Object[] params) {
		// �޷��ر���ʱ���������Ϸ��ͺͻ�ȡ
		int count = 0;
		Connection connection = BaseDao.getConnection();

		PreparedStatement ps = null;

		try {
			ps = connection.prepareStatement(sql);

			for (int i = 0; i < params.length; i++) {
				// ����SQL���
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
		// �ر��������Ӻ���ز���
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
