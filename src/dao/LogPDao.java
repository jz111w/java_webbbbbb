package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.LogP;

public class LogPDao {
	public static int insert(LogP logP) {
		String sql = "INSERT INTO logp VALUE(?,?,?,?,?,?);";

		Object[] params = { logP.getId(), logP.getTime(), logP.getEmail(), logP.getComid(), logP.getCombrand(),
				logP.getComname() };
		return BaseDao.exectuIUD(sql, params);
	}

	public static ArrayList<LogP> showAll() {
		ArrayList<LogP> list = new ArrayList<LogP>();

		ResultSet resultSet = null;

		Connection connection = BaseDao.getConnection();

		PreparedStatement preparedStatement = null;

		String sql = "SELECT * FROM logp;";

		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				LogP logP = new LogP(resultSet.getString("id"), resultSet.getString("time"),
						resultSet.getString("email"), resultSet.getString("comid"), resultSet.getString("combrand"),
						resultSet.getString("comname"));
				list.add(logP);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(resultSet, preparedStatement, connection);
		}

		return list;
	}

	public static ArrayList<LogP> selectByBrand(String brand) {
		ArrayList<LogP> list = new ArrayList<LogP>();

		ResultSet resultSet = null;

		Connection connection = BaseDao.getConnection();

		PreparedStatement preparedStatement = null;

		String sql = "SELECT * FROM logp WHERE combrand =?;";

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, brand);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				LogP logP = new LogP(resultSet.getString("id"), resultSet.getString("time"),
						resultSet.getString("email"), resultSet.getString("comid"), resultSet.getString("combrand"),
						resultSet.getString("comname"));
				list.add(logP);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(resultSet, preparedStatement, connection);
		}

		return list;
	}

	public static ArrayList<LogP> selectByEmail(String email) {
		ArrayList<LogP> list = new ArrayList<LogP>();

		ResultSet resultSet = null;

		Connection connection = BaseDao.getConnection();

		PreparedStatement preparedStatement = null;

		String sql = "SELECT * FROM logp WHERE email =?;";

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				LogP logP = new LogP(resultSet.getString("id"), resultSet.getString("time"),
						resultSet.getString("email"), resultSet.getString("comid"), resultSet.getString("combrand"),
						resultSet.getString("comname"));
				list.add(logP);
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

		String sql = "SELECT email FROM logp;";

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
