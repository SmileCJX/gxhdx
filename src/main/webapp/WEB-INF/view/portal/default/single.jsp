<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->
<head>
<%@ include file="/WEB-INF/view/portal/default/portalHead.jsp"%>
</head>
<body>
	<%@ include file="/WEB-INF/view/portal/default/header.jsp"%>
	<%@ include file="/WEB-INF/view/portal/default/top.jsp"%>
	<br>
	<div class=" am-container">${article.content }</div>
	<hr>
	<div data-am-widget="gotop" class="am-gotop am-gotop-fixed" >
		<a href="#top" title="">
			<i class="am-gotop-icon am-icon-hand-o-up"></i>
		</a>
	</div>
	<%@ include file="/WEB-INF/view/portal/default/footer.jsp"%>
</body>
</html>
