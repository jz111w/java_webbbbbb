package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Saler;

public class SalerDao {
	public static Saler selectById(String id) {
		Saler saler = null;

		ResultSet resultSet = null;

		Connection connection = BaseDao.getConnection();

		PreparedStatement preparedStatement = null;

		String sql = "SELECT * FROM saler WHERE id=?;";

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				saler = new Saler(resultSet.getString("id"), resultSet.getString("pw"), resultSet.getString("charge"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(resultSet, preparedStatement, connection);
		}

		return saler;
	}

	public static int updatePw(String id, String pw) {
		String sql = "UPDATE saler SET pw=?WHERE id=? ;";

		Object[] params = { pw, id };
		return BaseDao.exectuIUD(sql, params);
	}

	public static int delete(String id) {
		String sql = "DELETE FROM saler WHERE id=? ;";

		Object[] params = { id };
		return BaseDao.exectuIUD(sql, params);
	}

	public static ArrayList<Saler> showAll() {
		ArrayList<Saler> list = new ArrayList<Saler>();

		ResultSet resultSet = null;

		Connection connection = BaseDao.getConnection();

		PreparedStatement preparedStatement = null;

		String sql = "SELECT * FROM saler;";

		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Saler saler = new Saler(resultSet.getString("id"), resultSet.getString("pw"),
						resultSet.getString("charge"));
				list.add(saler);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(resultSet, preparedStatement, connection);
		}

		return list;
	}

	public static int insert(Saler saler) {
		String sql = "INSERT INTO saler VALUE(?,?,?);";

		Object[] params = { saler.getId(), saler.getPw(), saler.getCharge() };

		return BaseDao.exectuIUD(sql, params);
	}
}
