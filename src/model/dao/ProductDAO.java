package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import library.JDBCConnectionUtil;
import model.bean.Product;

public class ProductDAO {
	private static Connection conn;
	private static Statement st;
	private static PreparedStatement pst;
	private static ResultSet rs;

	public ArrayList<Product> getItems() {
		ArrayList<Product> listItems = new ArrayList<>();
		conn = JDBCConnectionUtil.getConnection();
		String sql = "SELECT*FROM hoa ORDER BY id_hoa ASC";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Product objPro = new Product(rs.getInt("id_hoa"), rs.getString("ten_hoa"), rs.getString("mo_ta"),
						rs.getString("hinh_anh"), rs.getInt("gia_ban"));
				listItems.add(objPro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return listItems;
	}

	public static int additems(Product objAdd) {
		conn = JDBCConnectionUtil.getConnection();
		int result = 0;
		String sql = "INSERT INTO hoa (ten_hoa, mo_ta, hinh_anh, gia_ban) VALUES (?, ?, ?, ?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objAdd.getTenHoa());
			pst.setString(2, objAdd.getMoTa());
			pst.setString(3, objAdd.getHinhAnh());
			pst.setInt(4, objAdd.getGiaBan());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCConnectionUtil.close(rs, pst, conn);
		}

		return result;
	}

	public static Product getItem(int id) {
		conn = JDBCConnectionUtil.getConnection();
		String sql = "SELECT * FROM hoa WHERE id_hoa= ? ";
		Product objPro = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				objPro = new Product(rs.getInt("id_hoa"), rs.getString("ten_hoa"), rs.getString("mo_ta"),
						rs.getString("hinh_anh"), rs.getInt("gia_ban"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCConnectionUtil.close(rs, pst, conn);
		}

		return objPro;
	}

	public static int Edititems(Product objPro) {
		conn = JDBCConnectionUtil.getConnection();
		int result = 0;
		String sql = "UPDATE hoa SET  ten_hoa= ? , mo_ta= ? , hinh_anh = ? , gia_ban = ? WHERE id_hoa=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objPro.getTenHoa());
			pst.setString(2, objPro.getMoTa());
			pst.setString(3, objPro.getHinhAnh());
			pst.setInt(4, objPro.getGiaBan());
			pst.setInt(5, objPro.getId());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCConnectionUtil.close(rs, pst, conn);
		}

		return result;
	}

	public static int delitems(int id) {

		conn = JDBCConnectionUtil.getConnection();
		String sql = "DELETE FROM hoa WHERE id_hoa = ?";
		int result = 0;
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			result = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCConnectionUtil.close(rs, pst, conn);
		}

		return result;
	}

}
