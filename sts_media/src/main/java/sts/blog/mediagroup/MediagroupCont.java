package sts.blog.mediagroup;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import www.utility.Utility;
 
@Controller
public class MediagroupCont {
  @Autowired
  private MediagroupDAO dao;
  
  public MediagroupCont(){
    System.out.println(">>>>> MediagroupCont auto created...");
  }
  
  //servlet-context.xml에 패키지등록  @line26
  // http://localhost:9090/media/mediagroup/create.do
  @RequestMapping(value="/mediagroup/create.do", method=RequestMethod.GET)
  public ModelAndView createForm(){
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/mediagroup/createForm"); // /mediagroup/createForm.jsp
    
    return mav;
  }
  //
  // http://localhost:9090/media/mediagroup/create.do
  @RequestMapping(value="/mediagroup/create.do", method=RequestMethod.POST)
  public ModelAndView createProc(MediagroupDTO dto){
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/mediagroup/msgView"); // /mediagroup/msgView.jsp
    
    int cnt = dao.create(dto);
    System.out.println(cnt);
    if (cnt == 1){
      mav.addObject("msg1", "Mediagroup created.");
      mav.addObject("link1", "<input type='button' value='Create More' onclick=\"location.href='./create.do'; \">");
      mav.addObject("link2", "<input type='button' value='Mediagroup List' onclick=\"location.href='./list.do'; \">");
    }else{
      mav.addObject("msg1", "Failed to create Mediagroup.");
      mav.addObject("link1", "<input type='button' value='Retry' onclick=\"history.back();\">");
      mav.addObject("link2", "<input type='button' value='Mediagroup List' onclick=\"location.href='./list.do'; \">");
       
    }
    
    return mav;
  }
  
  // http://localhost:9090/media/mediagroup/list.do
  @RequestMapping(value="/mediagroup/list.do", method=RequestMethod.GET)
  public ModelAndView list(){
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/mediagroup/list");   // /mediagroup/list.jsp 
    mav.addObject("root", Utility.getRoot()); // /media
    
    mav.addObject("list", dao.list());
    // request.setAttribute("list", dao.list());
   
    return mav;
  }
  
//http://localhost:9090/media/mediagroup/update.do
 @RequestMapping(value="/mediagroup/update.do", method=RequestMethod.GET)
 public ModelAndView updateForm(MediagroupDTO dto){
   ModelAndView mav = new ModelAndView();
   mav.setViewName("/mediagroup/updateForm");   // /mediagroup/updateForm.jsp 
   
   mav.addObject("root", Utility.getRoot()); // /media
   mav.addObject("dto", dao.read(dto));
   // request.setAttribute("dto", dao.read(dto));
  
   return mav;
 }
 
 // http://localhost:9090/media/mediagroup/update.do
 @RequestMapping(value="/mediagroup/update.do", method=RequestMethod.POST)
 public ModelAndView updateProc(MediagroupDTO dto){
   ModelAndView mav = new ModelAndView();
   mav.setViewName("/mediagroup/msgView"); // /mediagroup/msgView.jsp
   mav.addObject("img", "<img src='./images/bu01.png'>");
   
   int cnt = dao.update(dto);
   if (cnt == 1){
     // request.setAttribute("msg1", "Mediagroup updated.");
     mav.addObject("msg1", "Mediagroup updated.");
     mav.addObject("link1", "<input type='button' value='Mediagroup List' onclick=\"location.href='./list.do'; \">");
   }else{
     mav.addObject("msg1", "Failed to update mediagroup.");
     mav.addObject("link1", "<input type='button' value='Retry' onclick=\"history.back();\">");
     mav.addObject("link2", "<input type='button' value='Mediagroup List' onclick=\"location.href='./list.do'; \">");
      
   }
   
   return mav;
 }  
//http://localhost:9090/media/mediagroup/delete.do
@RequestMapping(value="/mediagroup/delete.do", method=RequestMethod.GET)
public ModelAndView deleteForm(MediagroupDTO dto){
  ModelAndView mav = new ModelAndView();
  mav.setViewName("/mediagroup/deleteForm");   // /mediagroup/deleteForm.jsp 
  
  mav.addObject("root", Utility.getRoot()); // /media
  mav.addObject("dto", dto);
 
  return mav;
}

// http://localhost:9090/media/mediagroup/delete.do
@RequestMapping(value="/mediagroup/delete.do", method=RequestMethod.POST)
public ModelAndView deleteProc(MediagroupDTO dto){
  ModelAndView mav = new ModelAndView();
  mav.setViewName("/mediagroup/msgView"); // /mediagroup/msgView.jsp
  mav.addObject("img", "<img src='./images/bu01.png'>");
  
  int cnt = dao.delete(dto);
  if (cnt == 1){
    // request.setAttribute("msg1", "Mediagroup updated.");
    mav.addObject("msg1", "Mediagroup deleted.");
    mav.addObject("link1", "<input type='button' value='Mediagroup List' onclick=\"location.href='./list.do'; \">");
  }else{
    mav.addObject("msg1", "Failed to delete mediagroup.");
    mav.addObject("link1", "<input type='button' value='Retry' onclick=\"history.back();\">");
    mav.addObject("link2", "<input type='button' value='Mediagroup List' onclick=\"location.href='./list.do'; \">");
     
  }
  
  return mav;
}  
 
}
