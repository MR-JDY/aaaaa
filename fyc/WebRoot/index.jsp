<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>单梅是SB</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
  </head>
  <script type="text/javascript">
  	function clic(){
  		alert("点你妈逼点，继续点？");
//   		clic();
		document.getElementById("h").style.display="block";
  	}
  	
  	function clic2(){
  		alert("还他妈点？");
  		clic2();
  	}
  </script>
  <body>
    <div align="center"><font color="red" size="24">你他么的老子不是叫你不要点吗？三天不见太阳？</font><br></div>
    <br><br><br><br><br>
    <div align="center"><input type="button" value="请点击获取" onclick="clic();" style="width:400px;heigh:100px;"/></div>
    <div id="h" style="display:none">
    <div align="center"><img alt="胸大吧？" src="a.jpg" style="width:200px;heigh:30px;"></div>
    <div align="center"><input type="button" value="请点击获取" onclick="clic2();" style="width:400px;heigh:100px;"/></div>
    </div>
  </body>
</html>
