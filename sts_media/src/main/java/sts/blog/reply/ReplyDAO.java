package sts.blog.reply;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import www.utility.DBClose;
import www.utility.DBOpen;

@Component
public class ReplyDAO {
  @Autowired
  private DBOpen dbopen = null;
  
  @Autowired
  private DBClose dbclose = null;
  
  public ReplyDAO(){
    System.out.println(">>>>>>ReplyDAO auto created...");
  }
  
  public ArrayList list(int mediano){
    Connection con = dbopen.getConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    StringBuffer sql = new StringBuffer();
    int cnt = 0;
    ArrayList list = new ArrayList();
    ReplyDTO dto = new ReplyDTO();
    
    try{
      sql.append(" SELECT replyno, content, passwd, rdate, meidano");
      sql.append(" FROM reply");
      sql.append(" WHERE mediano = ?");
      sql.append(" ORDER BY replyno DESC");
      
      pstmt= con.prepareStatement(sql.toString());
      pstmt.setInt(1, mediano);
      rs = pstmt.executeQuery();
      
      while(rs.next()==true){
        dto.setReplyno(rs.getInt("replyno"));
        dto.setContent(rs.getString("content"));
        dto.setPasswd(rs.getString("passwd"));
        dto.setRdate(rs.getString("rdate"));
        dto.setMediano(rs.getInt("mediano"));
        
        list.add(dto);
      }
    }catch (Exception e){
      e.printStackTrace();
    } finally{
      dbclose.close(con, pstmt, rs);
    }
    
    return list;
  }
  
  
  public ReplyDTO read(int replyno){
    Connection con = dbopen.getConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    StringBuffer sql = new StringBuffer();
    ArrayList list = null;
    ReplyDTO dto = new ReplyDTO();
    
    try{
      sql.append(" SELECT replyno, content, passwd, rdate,mediano");
      sql.append(" FROM reply");
      sql.append(" WHERE replyno=?");
      
      pstmt = con.prepareStatement(sql.toString());
      pstmt.setInt(1, replyno);
      rs = pstmt.executeQuery();
      
      if(rs.next() == true){
        dto.setReplyno(rs.getInt("replyno"));
        dto.setContent(rs.getString("content"));
        dto.setPasswd(rs.getString("passwd"));
        dto.setRdate(rs.getString("rdate"));
        dto.setMediano(rs.getInt("mediano"));      
      }
    } catch(Exception e){
        e.printStackTrace();
    } finally{
        dbclose.close(con, pstmt, rs);
    }
      return dto;
  }

  
  public int checkPasswd(ReplyDTO dto){
    Connection con = dbopen.getConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    int cnt = 0;
    StringBuffer sql = new StringBuffer();
    
    try{
      sql.append(" SELECT COUNT(replyno) as cnt");
      sql.append(" FROM reply");
      sql.append(" WHERE replyno = ? AND passwd = ?");
      
      pstmt = con.prepareStatement(sql.toString());
      pstmt.setInt(1, dto.getReplyno());
      pstmt.setString(2, dto.getPasswd());
      
      rs = pstmt.executeQuery();
      rs.next();
      cnt = rs.getInt("cnt");
      
    } catch(Exception e){
      e.printStackTrace();
    } finally{
      dbclose.close(con, pstmt, rs);
    }
    return cnt;
  }
  
  public int create(ReplyDTO dto){
    Connection con = null;
    PreparedStatement pstmt = null;
    StringBuffer sql = new StringBuffer();
    int cnt = 0;
    
    try{
      sql.append(" INSERT INTO reply(replyno,");
      sql.append("             content, passwd, rdate, mediano)");
      sql.append(" VALUES((SELECT NVL(MAX(replyno), 0)+1 as replyno FROM reply),");
      sql.append("             ?, ?, sysdate, ?)"); // ASC: 오름 차순 
      
      pstmt = con.prepareStatement(sql.toString());
      pstmt.setString(1, dto.getContent());
      pstmt.setString(2, dto.getPasswd());
      pstmt.setInt(3, dto.getMediano());
      
      cnt = pstmt.executeUpdate();
    } catch(Exception e){
      e.printStackTrace();
    } finally{
      dbclose.close(con, pstmt);
    }
    return cnt;
  }

  public int update(ReplyDTO dto){
    Connection con = dbopen.getConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    StringBuffer sql = new StringBuffer();
    int cnt = 0;
    ArrayList list = null;
    
    try{
      sql.append(" UPDATE reply");
      sql.append(" SET content = ?");
      sql.append(" WHERE replyno = ?");
      
      pstmt = con.prepareStatement(sql.toString());
      pstmt.setString(1, dto.getContent());
      pstmt.setInt(2, dto.getReplyno());
      
      cnt = pstmt.executeUpdate();
    } catch(Exception e){
      e.printStackTrace();
    } finally{
      dbclose.close(con, pstmt, rs);
    }
    
    return cnt;
  }
}
