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
	
	<div class="am-container-1">
		<ul data-am-widget="gallery"
			class="am-gallery am-avg-sm-1 am-avg-md-3 am-avg-lg-4 am-gallery-bordered customer-case-ul"
			data-am-gallery="{  }">
			<c:forEach items="${activitytypeList.items }" var="item">
					<li>
						<div class="am-gallery-item">
							<a href="#" onclick="openActivity(${item.id})">
								<div class="customer-case-img">
									<img src='${item.imgUrl }' />
								</div>
								<h3 class="am-gallery-title">${item.typeName }</h3>
								<div class="am-gallery-desc gallery-words">${item.introduction }</div>
							</a>
						</div>
					</li>
			</c:forEach>
		</ul>
	</div>

	<div data-am-widget="gotop" class="am-gotop am-gotop-fixed" >
		<a href="#top" title="">
			<i class="am-gotop-icon am-icon-hand-o-up"></i>
		</a>
	</div>
	<%--<%@ include file="/WEB-INF/view/portal/default/customer.jsp"%>--%>
	<%@ include file="/WEB-INF/view/portal/default/footer.jsp"%>
	<script type="text/javascript">
		<%--function openArticle(id,categoryId) {--%>
			<%--window.location.href = '<c:url value="/article?id='+id+'&categoryId='+categoryId+'"/>';--%>
		<%--}--%>
		<%--$(function() {--%>
			<%--query();--%>
		<%--});--%>
		<%--function query() {--%>
			<%--$.ajax({--%>
				<%--url : 'portal/activitytype/list',--%>
				<%--type : 'post',--%>
				<%--data : {--%>

				<%--},--%>
				<%--cache : false,--%>
				<%--contentType : "application/x-www-form-urlencoded; charset=utf-8",--%>
				<%--success : function(data) {--%>
					<%--&lt;%&ndash;${"#test"}.append(data.obj.modifyDate);&ndash;%&gt;--%>
					<%--alert(data);--%>
					<%--alert("页面正常加载");--%>
				<%--},--%>
				<%--error : function() {--%>
					<%--alert("页面异常加载");--%>
				<%--}--%>
			<%--});--%>
		<%--}--%>

		function openActivity(id){
			window.location.href = '<c:url value="/portal_activity/list?id='+id+'"/>';
		}
	</script>
</body>
</html>
