package pollResidencial;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PollDAO {
	private PollTemplate pollTemplate;
	
	public PollDAO() {
		pollTemplate = PollTemplate.getInstance();
	}
	
	public boolean insertPoll(PollVO vo) {
		boolean ret = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into \"POLL\" values (\"SEQ_NUMBER\".nextval, ?, 0)";
		
		try {
			conn = pollTemplate.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			
			int result = pstmt.executeUpdate();
			System.out.println(result + "행이 삽입되었습니다.");
			ret = true;
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return ret;
	}
	
	public List<PollVO> selectAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<PollVO> ls = new ArrayList<>();
		String sql = "select \"NUMBER\",\"NAME\", \"VOTES\" from \"POLL\"";
		
		try {
			conn = pollTemplate.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				PollVO tmp = new PollVO(
						rs.getLong(1),
						rs.getString("NAME"),
						rs.getInt("VOTES")
						);
				ls.add(tmp);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}	
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return (ls.size() == 0) ? null : ls;
	}
	
	public boolean UpdatePoll(PollVO vo) {
		boolean ret = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update \"POLL\" set \"VOTES\"= (SELECT NVL(MAX(VOTES), 0)+1 FROM POLL) where \"NUMBER\" = ?";
				
		try {
			conn = pollTemplate.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, vo.getNumber()); 
			
			int result = pstmt.executeUpdate();
			System.out.println(result + "행이 변경되었습니다.");
			ret = true;
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return ret;
	}
}
