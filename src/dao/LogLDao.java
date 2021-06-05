package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.LogL;

public class LogLDao {
	public static int insert(LogL logl) {
		String sql = "INSERT INTO logl VALUE(?,?,?,?,?);";

		Object[] params = { logl.getId(), logl.getEmail(), logl.getTime(), logl.getIp(), logl.getAction(), };
		return BaseDao.exectuIUD(sql, params);
	}

	public static ArrayList<LogL> showAll() {
		ArrayList<LogL> list = new ArrayList<LogL>();

		ResultSet resultSet = null;

		Connection connection = BaseDao.getConnection();

		PreparedStatement preparedStatement = null;

		String sql = "SELECT * FROM logl;";

		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				LogL logL = new LogL(resultSet.getString("id"), resultSet.getString("email"),
						resultSet.getString("time"), resultSet.getString("ip"), resultSet.getString("action"));
				list.add(logL);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(resultSet, preparedStatement, connection);
		}

		return list;
	}
}
