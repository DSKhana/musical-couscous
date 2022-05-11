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
		String sql = "insert into \"POLL\" values (\"SEQ_INFO\".nextval, ?, ?)";
		
		try {
			conn = pollTemplate.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getVotes());
			
			System.out.println(sql);
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
		String sql = "select \"NUMBER\", \"NAME\", \"VOTES\" from \"POLL\"";
		
		try {
			conn = pollTemplate.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				PollVO tmp = new PollVO(
						rs.getLong(1),
						rs.getString("Name"),
						rs.getInt("VOTES")
						);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
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
		String sql = "update \"POLL\" set (\"SEQ_SCORE\".nextval, ?, ?)";
		try {
			conn = pollTemplate.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getVotes());
			
			System.out.println(sql);
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
}
