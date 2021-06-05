package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Ord;
import entity.Statistics;

public class OrdDao {
	public static int insert(Ord ord) {
		String sql = "INSERT INTO ord VALUE(?,?,?,?,?,?,?);";

		Object[] params = { ord.getId(), ord.getTime(), ord.getEmail(), ord.getComid(), ord.getCombrand(),
				ord.getComname(), ord.getPrice() };
		return BaseDao.exectuIUD(sql, params);
	}

	public static ArrayList<Ord> showAll() {
		ArrayList<Ord> list = new ArrayList<Ord>();

		ResultSet resultSet = null;

		Connection connection = BaseDao.getConnection();

		PreparedStatement preparedStatement = null;

		String sql = "SELECT * FROM ord;";

		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Ord ord = new Ord(resultSet.getString("id"), resultSet.getString("time"), resultSet.getString("email"),
						resultSet.getString("comid"), resultSet.getString("combrand"), resultSet.getString("comname"),
						resultSet.getString("price"));
				list.add(ord);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(resultSet, preparedStatement, connection);
		}

		return list;
	}

	public static ArrayList<Ord> selectByEmail(String email) {
		ArrayList<Ord> list = new ArrayList<Ord>();

		ResultSet resultSet = null;

		Connection connection = BaseDao.getConnection();

		PreparedStatement preparedStatement = null;

		String sql = "SELECT * FROM ord WHERE email =?;";

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Ord ord = new Ord(resultSet.getString("id"), resultSet.getString("time"), resultSet.getString("email"),
						resultSet.getString("comid"), resultSet.getString("combrand"), resultSet.getString("comname"),
						resultSet.getString("price"));
				list.add(ord);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(resultSet, preparedStatement, connection);
		}

		return list;
	}

	public static ArrayList<String> showName() {
		ArrayList<String> list = new ArrayList<String>();

		ResultSet resultSet = null;

		Connection connection = BaseDao.getConnection();

		PreparedStatement preparedStatement = null;

		String sql = "SELECT comname FROM ord;";

		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String ord = resultSet.getString("comname");
				list.add(ord);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(resultSet, preparedStatement, connection);
		}

		return list;
	}

	public static ArrayList<String> showBrand() {
		ArrayList<String> list = new ArrayList<String>();

		ResultSet resultSet = null;

		Connection connection = BaseDao.getConnection();

		PreparedStatement preparedStatement = null;

		String sql = "SELECT combrand FROM ord;";

		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String ord = resultSet.getString("combrand");
				list.add(ord);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(resultSet, preparedStatement, connection);
		}

		return list;
	}

	public static ArrayList<Statistics> selectCount() {
		ArrayList<Statistics> list = new ArrayList<Statistics>();

		ResultSet resultSet = null;

		Connection connection = BaseDao.getConnection();

		PreparedStatement preparedStatement = null;

		String sql = "SELECT DISTINCT combrand ,COUNT(combrand) c FROM ord GROUP BY combrand;";

		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Statistics s = new Statistics(resultSet.getString("combrand"), resultSet.getInt("c"));
				list.add(s);
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
