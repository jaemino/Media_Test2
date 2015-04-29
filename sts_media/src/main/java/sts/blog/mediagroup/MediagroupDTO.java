package sts.blog.mediagroup;
 
public class MediagroupDTO {
  private int mediagroupno;
  private String title;
  
  public void setMediagroupno(int mediagroupno){
    this.mediagroupno = mediagroupno;
  }
  
  public void setTitle(String title){
    this.title = title;
  }
  
  public int getMediagroupno(){
    return this.mediagroupno;
  }
  
  public String getTitle(){
    return this.title;
  }
}