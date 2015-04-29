package sts.blog.mediagroup;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
 
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
 


import www.utility.DBClose;
import www.utility.DBOpen;
 
@Component
public class MediagroupDAO {
  @Autowired 
  private DBOpen dbopen = null;
  
  @Autowired
  private DBClose dbclose = null;
  
  public MediagroupDAO(){
    System.out.println(">>>>> MediagroupDAO auto created...");  
  }
 
  //-------------------------------------------------
  public int create(MediagroupDTO dto){
    Connection con = dbopen.getConnection();
    PreparedStatement pstmt = null;
    StringBuffer sql = new StringBuffer();
    int cnt = 0;
    
    try{
      sql.append(" INSERT INTO mediagroup(mediagroupno, title)");
      sql.append(" VALUES((SELECT NVL(MAX(mediagroupno), 0)+1 as mediagroupno FROM mediagroup), ?)");
    
      pstmt = con.prepareStatement(sql.toString());
      pstmt.setString(1, dto.getTitle());
      
      cnt = pstmt.executeUpdate(); // 1: 하나의 레코드 추가, 0: 인서트 실패
    }catch(Exception e){
      System.out.println(e.toString());
    }finally{
      dbclose.close(con, pstmt);
    }
    
    return cnt;
  }
  
  //-------------------------------------------------
  /**
   * 미디어 그룹 목록
   * 
   * @return
   */
  public ArrayList list(){
    Connection con = dbopen.getConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    StringBuffer sql = new StringBuffer();
    ArrayList list = new ArrayList();
    
    try{
      sql.append(" SELECT mediagroupno, title");
      sql.append(" FROM mediagroup");
      sql.append(" ORDER BY mediagroupno ASC");
    
      pstmt = con.prepareStatement(sql.toString());
           
      rs = pstmt.executeQuery(); 
      
      list = new ArrayList();
      while (rs.next() == true) { // 첫 번째 레코드, 두번째 레코드
        MediagroupDTO dto = new MediagroupDTO();
        dto.setMediagroupno(rs.getInt("mediagroupno"));
        dto.setTitle(rs.getString("title"));         
 
        list.add(dto);
      }
     }catch(Exception e){
      System.out.println(e.toString());
    }finally{
      dbclose.close(con, pstmt, rs);
    }
    
    return list;
  }

  //-------------------------------------------------
  public MediagroupDTO read(MediagroupDTO dto){
    Connection con = dbopen.getConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    StringBuffer sql = new StringBuffer();
    
    try{
      sql.append(" SELECT mediagroupno, title");
      sql.append(" FROM mediagroup");
      sql.append(" WHERE mediagroupno = ?");
    
      pstmt = con.prepareStatement(sql.toString());
      pstmt.setInt(1, dto.getMediagroupno());
           
      rs = pstmt.executeQuery(); 

      if (rs.next() == true) { // 첫 번째 레코드, 두번째 레코드
        dto.setMediagroupno(rs.getInt("mediagroupno"));
        dto.setTitle(rs.getString("title"));         
 
      }
     }catch(Exception e){
      System.out.println(e.toString());
    }finally{
      dbclose.close(con, pstmt, rs);
    }
    
    return dto;
  }
  
  //-------------------------------------------------
  public int update(MediagroupDTO dto){
    Connection con = dbopen.getConnection();
    PreparedStatement pstmt = null;
    StringBuffer sql = new StringBuffer();
    int cnt = 0;
    
    try{
      sql.append(" UPDATE mediagroup");
      sql.append(" SET title=?");
      sql.append(" WHERE mediagroupno=?");
    
      pstmt = con.prepareStatement(sql.toString());
      pstmt.setString(1, dto.getTitle());
      pstmt.setInt(2, dto.getMediagroupno());
           
      cnt = pstmt.executeUpdate();
      
     }catch(Exception e){
      System.out.println(e.toString());
    }finally{
      dbclose.close(con, pstmt);
    }
    
    return cnt;
  }
  
  //-------------------------------------------------
  public int delete(MediagroupDTO dto){
    Connection con = dbopen.getConnection();
    PreparedStatement pstmt = null;
    StringBuffer sql = new StringBuffer();
    int cnt = 0;
    
    try{
      sql.append(" DELETE FROM mediagroup");
      sql.append(" WHERE mediagroupno=?");
    
      pstmt = con.prepareStatement(sql.toString());
      pstmt.setInt(1, dto.getMediagroupno());
           
      cnt = pstmt.executeUpdate();      
     }catch(Exception e){
      System.out.println(e.toString());
    }finally{
      dbclose.close(con, pstmt);
    }
    
    return cnt;
  }
}