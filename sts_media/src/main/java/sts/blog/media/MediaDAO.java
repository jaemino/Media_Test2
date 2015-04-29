package sts.blog.media;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
 
import www.utility.DBClose;
import www.utility.DBOpen;
 
@Component
public class MediaDAO {
  @Autowired
  private DBOpen dbopen = null;
  
  @Autowired
  private DBClose dbclose = null;
  
  public MediaDAO(){
    System.out.println(">>>>> MediaDAO auto created...");  
  }
  
  public ArrayList list(int mediagroupno){
    Connection con = dbopen.getConnection();
    PreparedStatement pstmt = null;
    ResultSet rs= null;
    StringBuffer sql = new StringBuffer();
    ArrayList list = new ArrayList();

    
    try{
      sql.append(" SELECT mediano, title, rdate, poster, filename, filesize, mview, mediagroupno");
      sql.append(" FROM media");
      sql.append(" WHERE mediagroupno = ?");
      sql.append(" ORDER BY mediano DESC");
    
      pstmt = con.prepareStatement(sql.toString());
      pstmt.setInt(1, mediagroupno);
      
      rs = pstmt.executeQuery();   // DBMS -> 변환 -> JAVA
      
      list = new ArrayList();
      while(rs.next() == true){
        MediaDTO dto = new MediaDTO(); // 레코드 1건 저장
        dto.setMediano(rs.getInt("mediano"));
        dto.setTitle(rs.getString("title"));
        dto.setRdate(rs.getString("rdate"));
        dto.setPoster(rs.getString("poster"));
        dto.setFilename(rs.getString("filename"));
        dto.setFilesize(rs.getInt("filesize"));
        dto.setMview(rs.getString("mview"));
        dto.setMediagroupno(rs.getInt("mediagroupno"));
        
        list.add(dto);
      }
      
    }catch(Exception e){
      System.out.println(e.toString());
    }finally{
      dbclose.close(con, pstmt, rs);
    }
    
    return list;
  }
  
  /**
   * 미디어 등록
   * 
   * @return
   */
  public int create(MediaDTO dto) {
    Connection con = dbopen.getConnection();
    PreparedStatement pstmt = null; // SQL 실행
    ResultSet rs = null; // SELECT 결과 저장
    StringBuffer sql = null;
    int cnt = 0;
 
    try {
      sql = new StringBuffer();
      sql.append(" INSERT INTO media(mediano,");
      sql.append("             title, rdate, poster, filename, filesize, mview, mediagroupno)");
      sql.append(" VALUES((SELECT NVL(MAX(mediano), 0)+1 as mediano FROM media),");
      sql.append("             ?, sysdate, ?, ?, ?, 'Y', ?)"); // ASC: 오름 차순 
 
      pstmt = con.prepareStatement(sql.toString());
      pstmt.setString(1, dto.getTitle());
      pstmt.setString(2, dto.getPoster());
      pstmt.setString(3, dto.getFilename());
      pstmt.setLong(4, dto.getFilesize());
      pstmt.setInt(5, dto.getMediagroupno());
      
      cnt = pstmt.executeUpdate();
 
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      dbclose.close(con, pstmt, rs);
    }
 
    return cnt;
  }
  
  /**
   * 조회
   * 
   * @return
   */
  public MediaDTO read(int mediano) {
    Connection con = dbopen.getConnection();
    PreparedStatement pstmt = null; // SQL 실행
    ResultSet rs = null; // SELECT 결과 저장
    StringBuffer sql = null;
    int cnt = 0;
    MediaDTO dto = null;
 
    try {
      sql = new StringBuffer();
      sql.append(" SELECT mediano, title, rdate, poster, filename, filesize, mview, mediagroupno");
      sql.append(" FROM media");
      sql.append(" WHERE mediano = ?"); 
 
      pstmt = con.prepareStatement(sql.toString());
      pstmt.setInt(1, mediano);
      
      rs = pstmt.executeQuery();
 
      while (rs.next() == true) { // 첫 번째 레코드, 두번째 레코드
        dto = new MediaDTO();
        dto.setMediano(rs.getInt("mediano"));
        dto.setTitle(rs.getString("title"));
        dto.setRdate(rs.getString("rdate"));
        dto.setPoster(rs.getString("poster"));
        dto.setFilename(rs.getString("filename"));
        dto.setFilesize(rs.getLong("filesize"));
        dto.setMview(rs.getString("mview"));
        dto.setMediagroupno(rs.getInt("mediagroupno"));
 
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      dbclose.close(con, pstmt, rs);
    }
 
    return dto;
  }
  
  public int update(MediaDTO dto){
    Connection con = dbopen.getConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    StringBuffer sql = new StringBuffer();
    int cnt = 0;
    
    try{
      sql.append(" UPDATE media");
      sql.append(" SET title=?, poster=?, filename=?, filesize=?");
      sql.append(" WHERE mediano=?");  
      
      pstmt = con.prepareStatement(sql.toString());
      pstmt.setString(1, dto.getTitle());
      pstmt.setString(2, dto.getPoster());
      pstmt.setString(3, dto.getFilename());
      pstmt.setLong(4, dto.getFilesize());
      pstmt.setInt(5, dto.getMediano());
      
      cnt = pstmt.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      dbclose.close(con, pstmt, rs);
    }
   
    return cnt;
  }
  
  
  public int delete(int mediano){
    Connection con = dbopen.getConnection();
    PreparedStatement pstmt = null;
    StringBuffer sql = new StringBuffer();
    int cnt = 0;
    
    try{
      sql.append(" DELETE FROM media");
      sql.append(" WHERE mediano=?");  
      
      pstmt = con.prepareStatement(sql.toString());
      pstmt.setInt(1, mediano);
      
      cnt = pstmt.executeUpdate();
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      dbclose.close(con, pstmt);
    }
   
    return cnt;
  }

}