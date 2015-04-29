package sts.blog.media;
 
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
 



import www.utility.UploadSaveManager;
import www.utility.Utility;
 
@Controller
public class MediaCont {
  @Autowired
  private MediaDAO dao;
  
  public MediaCont(){
    System.out.println(">>>>>>>> MediaCont auto created...");
  }
  
  // http://localhost:9090/media/media/list.do
  @RequestMapping(value="/media/list.do", method=RequestMethod.GET)
  public ModelAndView list(int mediagroupno){
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/media/list"); // /media/list.jsp
    
    mav.addObject("root", Utility.getRoot());
    mav.addObject("list", dao.list(mediagroupno));
    mav.addObject("mediagroupno", mediagroupno);

    return mav;
  }
 
  @RequestMapping(value="/media/create.do", method=RequestMethod.GET)
  public ModelAndView createForm(MediaDTO dto){
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/media/createForm");   // /media/createForm.jsp 
    mav.addObject("root", Utility.getRoot()); // /media
    
    mav.addObject("mediagroupno", dto.getMediagroupno());
    // request.setAttribute("mediagroupno", dto.getMediagroupno());
    return mav;
  }
  
  @RequestMapping(value="/media/create.do", method=RequestMethod.POST)
  public ModelAndView createProc(MediaDTO dto, HttpServletRequest request){
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/media/msgView");   // /media/msgView.jsp 
    mav.addObject("root", Utility.getRoot()); // /media
 
    // --------------------------------------------------------
    // poster 파일 전송 관련
    // --------------------------------------------------------
    // 전송된 파일이 자동 저장되어 있음.
    MultipartFile posterMF = dto.getPosterMF();
 
    // 서버에 전송된 파일 저장
    String basePath = Utility.getRealPath(request, "/media/storage");
    String poster = UploadSaveManager.saveFileSpring30(posterMF, basePath);
 
    dto.setPoster(poster); // 파일명
    // --------------------------------------------------------
    
    // --------------------------------------------------------
    // filename 파일 전송 관련
    // --------------------------------------------------------
    // 전송된 파일이 자동 저장되어 있음.
    MultipartFile filenameMF = dto.getFilenameMF();
 
    // 서버에 전송된 파일 저장
    String filename = UploadSaveManager.saveFileSpring30(filenameMF, basePath);
 
    dto.setFilename(filename); // 파일명
    dto.setFilesize(filenameMF.getSize()); // 파일 사이즈
    // --------------------------------------------------------
    
    int cnt = dao.create(dto);
    if (cnt == 1){
      mav.addObject("msg1", "Media File Uploaded.");
      mav.addObject("link1", "<input type='button' value='List' onclick=\"location.href='./list.do?mediagroupno="+dto.getMediagroupno()+"';\"");    
    }else{
      mav.addObject("msg1", "Failed to Upload Media File.");
      mav.addObject("link1", "<input type='button' value='Retry' onclick=\"history.back();\"");    
      mav.addObject("link2", "<input type='button' value='List' onclick=\"location.href='./list.do?mediagroupno="+dto.getMediagroupno()+"';\"");     
    }
    
    return mav;
  }
  
  @RequestMapping(value="/media/read.do", method=RequestMethod.GET)
  public ModelAndView read(int mediano){
    ModelAndView mav = new ModelAndView();
    
    MediaDTO dto = dao.read(mediano);
    
    String filename = dto.getFilename();
    filename = filename.toUpperCase();
    
    if (filename.endsWith(".MP3")){
      mav.setViewName("/media/readMP3");   // /media/readMP3.jsp 
    }else if (filename.endsWith(".MP4")){
      mav.setViewName("/media/readMP4");   // /media/readMP4.jsp 
    }
//    else if (filename.endsWith(".GIF") || filename.endsWith(".PNG") || filename.endsWith(".JPG")){
//      mav.setViewName("/media/readJPG");   // /media/readJPG.jsp 
//    }
    
    
    mav.addObject("root", Utility.getRoot()); // /media
    
    mav.addObject("dto", dto);
    // request.setAttribute("list", dao.list(dto.getMediagroupno()));
 
    return mav;
  }
  
  @RequestMapping(value="/media/update.do", method=RequestMethod.GET)
  public ModelAndView updateForm(MediaDTO dto){
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/media/updateForm");
    mav.addObject("root", Utility.getRoot());
    
    dto = dao.read(dto.getMediano());
    mav.addObject("dto", dto);
    
    return mav;
  }
  
  
  @RequestMapping(value="/media/update.do", method=RequestMethod.POST)
  public ModelAndView updateProc(MediaDTO dto, HttpServletRequest request){
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/media/msgView");   // /media/msgView.jsp 
    mav.addObject("root", Utility.getRoot()); // /media
 
    // 기존에 등록된 파일 정보 추출
    MediaDTO oldDTO = dao.read(dto.getMediano());
 
    // --------------------------------------------------------
    // poster 파일 전송 관련
    // --------------------------------------------------------
    // 전송된 파일이 자동 저장되어 있음.
    MultipartFile posterMF = dto.getPosterMF();
 
    // System.out.println(">>>>> 파일을 선택하지 않은 경우 posterMF: " + posterMF);
    
    // 새로 전송하는 파일이 있다면 기존 파일 삭제 후 새파일 전송
    if (posterMF.getSize() > 0){ 
      String basePath = Utility.getRealPath(request, "/media/storage");
      Utility.deleteFile(basePath + "/" + oldDTO.getPoster());
 
      // 서버에 전송된 파일 저장
      String poster = UploadSaveManager.saveFileSpring30(posterMF, basePath);
 
      dto.setPoster(poster); // 새로운 파일명 지정
    }else{
      dto.setPoster(oldDTO.getPoster()); // 기존 파일 재사용
    }
    // --------------------------------------------------------
    
    // --------------------------------------------------------
    // filename 파일 전송 관련
    // --------------------------------------------------------
    // 전송된 파일이 자동 저장되어 있음.
    MultipartFile filenameMF = dto.getFilenameMF();
 
    if (filenameMF.getSize() > 0){
      String basePath = Utility.getRealPath(request, "/media/storage");
      Utility.deleteFile(basePath + "/" + oldDTO.getFilename());
 
      // 서버에 전송된 파일 저장
      String filename = UploadSaveManager.saveFileSpring30(filenameMF, basePath);
 
      dto.setFilename(filename); // 파일명
      dto.setFilesize(filenameMF.getSize()); // 파일 사이즈
    }else{
      dto.setFilename(oldDTO.getFilename());
      dto.setFilesize(oldDTO.getFilesize());
    }
    // --------------------------------------------------------
    
    int cnt = dao.update(dto);
    if (cnt == 1){
      mav.addObject("msg1", "Media File Updated.");
      mav.addObject("link1", "<input type='button' value='List' onclick=\"location.href='./list.do?mediagroupno="+dto.getMediagroupno()+"';\"");    
    }else{
      mav.addObject("msg1", "Failed to update Media File.");
      mav.addObject("link1", "<input type='button' value='Retry' onclick=\"history.back();\"");    
      mav.addObject("link2", "<input type='button' value='List' onclick=\"location.href='./list.do?mediagroupno="+dto.getMediagroupno()+"';\"");      
    }
    
    return mav;
  }

  @RequestMapping(value="/media/delete.do", method=RequestMethod.GET)
  public ModelAndView deleteForm(MediaDTO dto){
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/media/deleteForm");
    mav.addObject("root", Utility.getRoot());
    
    mav.addObject("dto", dto);
    
    return mav;
  }
  
  @RequestMapping(value="/media/delete.do", method=RequestMethod.POST)
  public ModelAndView deleteProc(MediaDTO dto, HttpServletRequest request){
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/media/msgView");   // /media/msgView.jsp 
    mav.addObject("root", Utility.getRoot()); // /media
 
    // 기존에 등록된 파일 정보 추출
    MediaDTO oldDTO = dao.read(dto.getMediano());
 
    String basePath = Utility.getRealPath(request, "/media/storage");
    Utility.deleteFile(basePath + "/" + oldDTO.getPoster());
    Utility.deleteFile(basePath + "/" + oldDTO.getFilename());
    
    int cnt = dao.delete(dto.getMediano());
    if (cnt == 1){
      mav.addObject("msg1", "Media File Deleted.");
      mav.addObject("link1", "<input type='button' value='List' onclick=\"location.href='./list.do?mediagroupno="+dto.getMediagroupno()+"';\"");    
    }else{
      mav.addObject("msg1", "Failed to delete Media File.");
      mav.addObject("link1", "<input type='button' value='Retry' onclick=\"history.back();\"");    
      mav.addObject("link2", "<input type='button' value='List' onclick=\"location.href='./list.do?mediagroupno="+dto.getMediagroupno()+"';\"");      
    }
    
    return mav;
  }
}
