package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Cart;

public class CartDao {
	public static ArrayList<Cart> selectByEmail(String email) {
		ArrayList<Cart> list = new ArrayList<Cart>();

		ResultSet resultSet = null;

		Connection connection = BaseDao.getConnection();

		PreparedStatement preparedStatement = null;

		String sql = "SELECT * FROM cart WHERE email=?;";

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Cart Cart = new Cart(resultSet.getString("id"), resultSet.getString("comid"),
						resultSet.getString("combrand"), resultSet.getString("comname"),
						resultSet.getString("comprice"), resultSet.getString("email"));
				list.add(Cart);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(resultSet, preparedStatement, connection);
		}

		return list;
	}

	public static int insert(Cart cart) {
		String sql = "INSERT INTO cart VALUE(?,?,?,?,?,?);";

		Object[] params = { cart.getId(), cart.getComid(), cart.getCombrand(), cart.getComname(), cart.getComprice(),
				cart.getEmail() };
		return BaseDao.exectuIUD(sql, params);
	}

	public static int deleteAll(String email) {

		String sql = "DELETE FROM cart WHERE email=?;";

		Object[] params = { email };
		return BaseDao.exectuIUD(sql, params);
	}

	public static int delete(String id) {
		String sql = "DELETE FROM cart WHERE id=?;";

		Object[] params = { id };
		return BaseDao.exectuIUD(sql, params);
	}
}
