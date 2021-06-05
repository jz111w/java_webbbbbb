package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Userdata;

public class UserdataDao {
	public static int insert(Userdata ud) {
		String sql = "INSERT INTO userdata VALUE(?,?,?,?);";

		Object[] params = { ud.getId(), ud.getEmail(), ud.getBrand(), ud.getGrade() };

		return BaseDao.exectuIUD(sql, params);
	}

	public static int update(String id, int grade) {
		String sql = "UPDATE userdata SET grade=? WHERE id=?;";

		Object[] params = { grade, id };
		return BaseDao.exectuIUD(sql, params);
	}

	public static Userdata selectByEB(String email, String brand) {

		Userdata userdata = null;

		ResultSet resultSet = null;

		Connection connection = BaseDao.getConnection();

		PreparedStatement preparedStatement = null;

		String sql = "SELECT * FROM Userdata WHERE email=? and brand=?;";

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, brand);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				userdata = new Userdata(resultSet.getString("id"), resultSet.getString("email"),
						resultSet.getString("brand"), resultSet.getInt("grade"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(resultSet, preparedStatement, connection);
		}

		return userdata;
	}

	public static ArrayList<Userdata> selectByEmail(String email) {
		ArrayList<Userdata> list = new ArrayList<Userdata>();

		ResultSet resultSet = null;

		Connection connection = BaseDao.getConnection();

		PreparedStatement preparedStatement = null;

		String sql = "SELECT * FROM userdata WHERE email =?;";

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Userdata ud = new Userdata(resultSet.getString("id"), resultSet.getString("email"),
						resultSet.getString("brand"), resultSet.getInt("grade"));
				list.add(ud);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(resultSet, preparedStatement, connection);
		}

		return list;
	}

	public static Userdata selectByMaxGrade(String email) {

		Userdata userdata = null;

		ResultSet resultSet = null;

		Connection connection = BaseDao.getConnection();

		PreparedStatement preparedStatement = null;

		String sql = "SELECT * FROM userdata WHERE email=? AND grade=(SELECT MAX(grade) FROM userdata WHERE email=?);";

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, email);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				userdata = new Userdata(resultSet.getString("id"), resultSet.getString("email"),
						resultSet.getString("brand"), resultSet.getInt("grade"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(resultSet, preparedStatement, connection);
		}

		return userdata;
	}

	public static ArrayList<String> selectEmail() {
		ArrayList<String> list = new ArrayList<String>();

		ResultSet resultSet = null;

		Connection connection = BaseDao.getConnection();

		PreparedStatement preparedStatement = null;

		String sql = "SELECT  distinct email FROM userdata;";

		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String ud = resultSet.getString("email");
				list.add(ud);
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
