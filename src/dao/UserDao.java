package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.User;

public class UserDao {
	public static int insert(User user) {
		String sql = "INSERT INTO user VALUE(?,?,?);";

		Object[] params = { user.getEmail(), user.getPw(), user.getType() };
		return BaseDao.exectuIUD(sql, params);
	}

	public static User selectByEmail(String email) {
		User user = null;

		ResultSet resultSet = null;

		Connection connection = BaseDao.getConnection();

		PreparedStatement preparedStatement = null;

		String sql = "SELECT * FROM user WHERE email=?;";

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				user = new User(resultSet.getString("email"), resultSet.getString("pw"), resultSet.getString("type"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(resultSet, preparedStatement, connection);
		}

		return user;
	}

	public static int updatePw(String email, String pw) {
		String sql = "UPDATE user SET pw=?WHERE email=? ;";

		Object[] params = { pw, email };
		return BaseDao.exectuIUD(sql, params);
	}

	public static ArrayList<User> showAll() {
		ArrayList<User> list = new ArrayList<User>();

		ResultSet resultSet = null;

		Connection connection = BaseDao.getConnection();

		PreparedStatement preparedStatement = null;

		String sql = "SELECT * FROM user WHERE type=1 or type=2;";

		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				User user = new User(resultSet.getString("email"), resultSet.getString("pw"),
						resultSet.getString("type"));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(resultSet, preparedStatement, connection);
		}

		return list;
	}

	public static ArrayList<String> selectEmail() {
		ArrayList<String> list = new ArrayList<String>();

		ResultSet resultSet = null;

		Connection connection = BaseDao.getConnection();

		PreparedStatement preparedStatement = null;

		String sql = "SELECT  distinct email FROM user where type=1;";

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
