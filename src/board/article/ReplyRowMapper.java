package board.article;
import java.sql.ResultSet;
import java.sql.SQLException;

import board.RowMapper;

public class ReplyRowMapper implements RowMapper<Reply> {

	@Override
	public Reply getRow(ResultSet rs) throws SQLException {
		
		int parentId = rs.getInt("parentId");
		int replyId = rs.getInt("replyId");
		int mId = rs.getInt("mId");
		String replybody = rs.getString("replybody");
		String replynickname = rs.getString("replynickname");
		String replyregdate = rs.getString("replyregdate");
		
		Reply reply = new Reply();
		reply.setParentId(parentId);
		reply.setReplyId(replyId);
		reply.setmId(mId);
		reply.setReplybody(replybody);
		reply.setReplynickname(replynickname);
		reply.setReplyregdate(replyregdate);

		return reply;
	}

}
