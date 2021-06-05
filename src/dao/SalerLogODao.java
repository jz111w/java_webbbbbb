package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.SalerLogO;

public class SalerLogODao {
	public static int insert(SalerLogO salerLogO) {
		String sql = "INSERT INTO salerlogo VALUE(?,?,?,?,?);";

		Object[] params = { salerLogO.getId(), salerLogO.getSalerid(), salerLogO.getTime(), salerLogO.getIp(),
				salerLogO.getAction() };
		return BaseDao.exectuIUD(sql, params);
	}

	public static ArrayList<SalerLogO> showAll() {
		ArrayList<SalerLogO> list = new ArrayList<SalerLogO>();

		ResultSet resultSet = null;

		Connection connection = BaseDao.getConnection();

		PreparedStatement preparedStatement = null;

		String sql = "SELECT * FROM salerlogo;";

		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				SalerLogO salerLogO = new SalerLogO(resultSet.getString("id"), resultSet.getString("salerid"),
						resultSet.getString("time"), resultSet.getString("ip"), resultSet.getString("action"));
				list.add(salerLogO);
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
