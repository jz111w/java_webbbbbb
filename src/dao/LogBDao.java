package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.LogB;

public class LogBDao {
	public static int insert(LogB logB) {
		String sql = "INSERT logb VALUE(?,?,?,?,?,?);";

		Object[] params = { logB.getId(), logB.getTime(), logB.getEmail(), logB.getComid(), logB.getCombrand(),
				logB.getComname() };
		return BaseDao.exectuIUD(sql, params);
	}

	public static ArrayList<LogB> showAll() {
		ArrayList<LogB> list = new ArrayList<LogB>();

		ResultSet resultSet = null;

		Connection connection = BaseDao.getConnection();

		PreparedStatement preparedStatement = null;

		String sql = "SELECT * FROM logb;";

		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				LogB logB = new LogB(resultSet.getString("id"), resultSet.getString("time"),
						resultSet.getString("email"), resultSet.getString("comid"), resultSet.getString("combrand"),
						resultSet.getString("comname"));
				list.add(logB);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(resultSet, preparedStatement, connection);
		}

		return list;
	}

	public static ArrayList<LogB> selectByBrand(String brand) {
		ArrayList<LogB> list = new ArrayList<LogB>();

		ResultSet resultSet = null;

		Connection connection = BaseDao.getConnection();

		PreparedStatement preparedStatement = null;

		String sql = "SELECT * FROM logb WHERE combrand =?;";

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, brand);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				LogB logb = new LogB(resultSet.getString("id"), resultSet.getString("time"),
						resultSet.getString("email"), resultSet.getString("comid"), resultSet.getString("combrand"),
						resultSet.getString("comname"));
				list.add(logb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(resultSet, preparedStatement, connection);
		}

		return list;
	}

	public static ArrayList<LogB> selectByEmail(String email) {
		ArrayList<LogB> list = new ArrayList<LogB>();

		ResultSet resultSet = null;

		Connection connection = BaseDao.getConnection();

		PreparedStatement preparedStatement = null;

		String sql = "SELECT * FROM logb WHERE email =?;";

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				LogB logb = new LogB(resultSet.getString("id"), resultSet.getString("time"),
						resultSet.getString("email"), resultSet.getString("comid"), resultSet.getString("comemail"),
						resultSet.getString("comname"));
				list.add(logb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(resultSet, preparedStatement, connection);
		}

		return list;
	}

	public static ArrayList<String> showEmail() {
		ArrayList<String> list = new ArrayList<String>();

		ResultSet resultSet = null;

		Connection connection = BaseDao.getConnection();

		PreparedStatement preparedStatement = null;

		String sql = "SELECT email FROM logb;";

		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String email = resultSet.getString("email");
				list.add(email);
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
