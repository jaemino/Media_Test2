<%@ page contentType="text/html; charset=UTF-8" %>
<% request.setCharacterEncoding("utf-8"); %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style type="text/css">
*{
  font-family: 굴림체;
  font-size: 24px;
}
</style>
<script type="text/javascript">
function loadMusic(poster_img, src){
  var poster = document.getElementById('poster'); // id가 'poster'인 태그 검색
  poster.src = poster_img;                        // 새로운 이미지 할당 
 
  var audio1 = document.getElementById('audio1'); // id가 audio1 태그 검색
  audio1.src=src;                                 // mp3 음악 파일 할당
  audio1.play();                                  // 자동 실행
 
}
</script>
</head>
<body>
<div style='text-align: center;'>
  <img id='poster' src="./gguri.png" width="300" >
  <br><br>
  <audio controls autoplay id="audio1" src="./gguri.mp3" />
</div>
<div style='margin:0 auto; width: 30%; background-color: #FFFFFF'>
  <br>
  <OL>
    <LI><a href="javascript:loadMusic('maroon2.png', './Misery.mp3');">Misery</a>
    <LI><a href="javascript:loadMusic('maroon3.png', './Makes_Me_Wonder.mp3');">Makes me Wonder</a>
    <LI><a href="javascript:loadMusic('maroon1.png', './Never_Gonna_Leave_This_Bed.mp3');">Never Gonna Leave this Bed</a>
    <LI><a href="javascript:loadMusic('calvin.jpg', './Summer.mp3');">Summer</a>
  </OL>  
</div>
 
</body>
</html>
