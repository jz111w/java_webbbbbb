package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Com;

public class ComDao {
	public static ArrayList<Com> showAll() {
		ArrayList<Com> list = new ArrayList<Com>();

		ResultSet resultSet = null;

		Connection connection = BaseDao.getConnection();

		PreparedStatement preparedStatement = null;

		String sql = "SELECT * FROM com;";

		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Com Com = new Com(resultSet.getString("id"), resultSet.getString("brand"), resultSet.getString("name"),
						resultSet.getString("price"), resultSet.getString("stock"));
				list.add(Com);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(resultSet, preparedStatement, connection);
		}

		return list;

	}

	public static Com selectByid(String id) {

		Com Com = null;

		ResultSet resultSet = null;

		Connection connection = BaseDao.getConnection();

		PreparedStatement preparedStatement = null;

		String sql = "SELECT * FROM com WHERE id=?;";

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Com = new Com(resultSet.getString("id"), resultSet.getString("brand"), resultSet.getString("name"),
						resultSet.getString("price"), resultSet.getString("stock"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(resultSet, preparedStatement, connection);
		}

		return Com;
	}

	public static int update(Com com) {
		String sql = "UPDATE com SET brand=?,name=?,price=?,stock=? WHERE id=?;";

		Object[] params = { com.getBrand(), com.getName(), com.getPrice(), com.getStock(), com.getId() };
		return BaseDao.exectuIUD(sql, params);
	}

	public static ArrayList<Com> selectQuery(String name) {
		ArrayList<Com> list = new ArrayList<Com>();

		ResultSet resultSet = null;

		Connection connection = BaseDao.getConnection();

		PreparedStatement preparedStatement = null;

		String key;
		if (name.equals(""))
			key = "";
		else {
			key = "'%" + name + "%'";
		}

		String sql = "SELECT * FROM com WHERE name LIKE " + key + ";";

		try {
			preparedStatement = connection.prepareStatement(sql);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Com com = new Com(resultSet.getString("id"), resultSet.getString("brand"), resultSet.getString("name"),
						resultSet.getString("price"), resultSet.getString("stock"));
				list.add(com);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(resultSet, preparedStatement, connection);
		}

		return list;
	}

	public static ArrayList<Com> selectByBrand(String brand) {
		ArrayList<Com> list = new ArrayList<Com>();

		ResultSet resultSet = null;

		Connection connection = BaseDao.getConnection();

		PreparedStatement preparedStatement = null;

		String sql = "SELECT * FROM com WHERE brand =?;";

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, brand);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Com com = new Com(resultSet.getString("id"), resultSet.getString("brand"), resultSet.getString("name"),
						resultSet.getString("price"), resultSet.getString("stock"));
				list.add(com);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(resultSet, preparedStatement, connection);
		}

		return list;
	}

	public static int delete(String id) {
		String sql = "DELETE FROM com WHERE id=?;";

		Object[] params = { id };

		return BaseDao.exectuIUD(sql, params);
	}

	public static int insert(Com com) {
		String sql = "INSERT INTO com VALUE(?,?,?,?,? );";

		Object[] params = { com.getId(), com.getBrand(), com.getName(), com.getPrice(), com.getStock() };

		return BaseDao.exectuIUD(sql, params);
	}

	public static ArrayList<Com> selectByBrandRecommend(String brand) {
		ArrayList<Com> list = new ArrayList<Com>();

		ResultSet resultSet = null;

		Connection connection = BaseDao.getConnection();

		PreparedStatement preparedStatement = null;

		String sql = "SELECT * FROM com WHERE brand =? LIMIT 3;";

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, brand);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Com com = new Com(resultSet.getString("id"), resultSet.getString("brand"), resultSet.getString("name"),
						resultSet.getString("price"), resultSet.getString("stock"));
				list.add(com);
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
