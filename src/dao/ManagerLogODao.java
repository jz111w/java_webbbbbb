package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.ManagerLogO;

public class ManagerLogODao {
	public static int insert(ManagerLogO mlo) {
		String sql = "INSERT INTO managerlogo VALUE(?,?,?,?);";

		Object[] params = { mlo.getId(), mlo.getTime(), mlo.getIp(), mlo.getAction() };
		return BaseDao.exectuIUD(sql, params);
	}

	public static ArrayList<ManagerLogO> showAll() {
		ArrayList<ManagerLogO> list = new ArrayList<ManagerLogO>();

		ResultSet resultSet = null;

		Connection connection = BaseDao.getConnection();

		PreparedStatement preparedStatement = null;

		String sql = "SELECT * FROM managerlogo;";

		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				ManagerLogO mlo = new ManagerLogO(resultSet.getString("id"), resultSet.getString("time"),
						resultSet.getString("ip"), resultSet.getString("action"));
				list.add(mlo);
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
