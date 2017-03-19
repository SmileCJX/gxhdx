<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8"%>
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
	<div class="rollpic">
		<div data-am-widget="slider" class="am-slider am-slider-default"
			data-am-slider='{}'>
			<ul class="am-slides">
				<c:forEach items="${slideImgs.items }" var="item">
					<li><img src='<c:url value="${item.imgUrl }"/>' height="540px"/></li>
				</c:forEach>
			</ul>
		</div>
	</div>
	<div class="gray-li">
		<div class="customer-case part-all ">
			<div class="part-title">
				<a href="customer-case.html"> <i
					class=" am-icon-briefcase part-title-i"></i> <span
					class="part-title-span">活动精选</span>
					<p>Activity Best</p>
				</a>
			</div>


			<ul data-am-widget="gallery"
				class=" am-avg-sm-1
  am-avg-md-4 am-avg-lg-4 am-gallery-bordered customer-case-content">
				<c:forEach items="${activitytypelists}" var="item">
					<li class="case-li am-u-sm-6 am-u-md-6 am-u-lg-3">
						<div class="am-gallery-item case-img1">
							<a href="#" onclick="openActivity(${item.id})"> <img src='${item.imgUrl }' />
							</a>
						</div>
						<div class="case-li-mengban">
							<div class=" case-word">
								<h3 class="am-gallery-title">${item.typeName}</h3>
								<a href="#" onclick="openActivity(${item.id})"><span><i class="am-icon-eye"></i>查看更多</span></a>
							</div>
						</div>
					</li>
				</c:forEach>
			</ul>
			<div class="part-title"></div>
		</div>
	</div>

	<div class=" news-all">
		<div class="am-container-1">
			<div class="news part-all">
				<div class="part-title">
					<a href="news.html"> <i
						class="am-icon-newspaper-o part-title-i"></i> <span
						class="part-title-span">院系新闻</span>
						<p>News</p>
					</a>
				</div>
				<div class="news-content ">
					<ul class="news-content-ul">
						<c:forEach items="${news.items}" var="item">
							<c:if test="${item.available}">
								<li class="am-u-sm-12 am-u-md-6 am-u-lg-6" style="height: 200px"><a href="#">
									<div class=" am-u-sm-12 am-u-md-12 am-u-lg-5">
										<div class="news-img">
											<img src='<c:url value="${item.picurl}"/>'/>
										</div>
									</div>
									<div class=" am-u-sm-12 am-u-md-12 am-u-lg-7">
										<span class="news-right-title">${item.title}</span>
										<p class="news-right-time">${item.modifyDate}</p>
										<p class="news-right-words">${item.keyword}</p>
										<a href="#" onclick="openArticle( ${item.id},'7' )"><span class="see-more2">查看更多<i
												class="am-icon-angle-double-right"></i></span></a>
									</div>
									<div class="clear"></div>
								</a></li>
							</c:if>
						</c:forEach>
						<%--<li class="am-u-sm-12 am-u-md-6 am-u-lg-6"><a href="#">--%>
								<%--<div class=" am-u-sm-12 am-u-md-12 am-u-lg-5">--%>
									<%--<div class="news-img">--%>
										<%--<img src='<c:url value="/static/image/portal/default/news1.png"/>'/>--%>
									<%--</div>--%>
								<%--</div>--%>
								<%--<div class=" am-u-sm-12 am-u-md-12 am-u-lg-7">--%>
									<%--<span class="news-right-title">关于召开年会的通知</span>--%>
									<%--<p class="news-right-time">2015-06-11</p>--%>
									<%--<p class="news-right-words">互联网，又称网际网路或音译因特网、英特网，是网络与网络之间所串连成的庞大网络网络与网络之...</p>--%>
									<%--<a><span class="see-more2">查看更多<i--%>
											<%--class="am-icon-angle-double-right"></i></span></a>--%>
								<%--</div>--%>
								<%--<div class="clear"></div>--%>
						<%--</a></li>--%>
						<%--<div class="clear"></div>--%>
					</ul>
					<div class="clear"></div>
				</div>
			</div>
		</div>
	</div>
	
<%--<%@ include file="/WEB-INF/view/portal/default/customer.jsp"%>--%>
<%@ include file="/WEB-INF/view/portal/default/footer.jsp"%>
<script type="text/javascript">
	function openArticle(id,categoryId) {
		window.location.href = '<c:url value="/news?id='+id+'&categoryId='+categoryId+'"/>';
	}

	function openActivity(id){
		window.location.href = '<c:url value="/portal_activity/list?id='+id+'"/>';
	}
</script>
</body>
</html>
