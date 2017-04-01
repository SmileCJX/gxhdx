<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8"%>
<% HttpSession s = request.getSession();%>
	<header class="am-topbar header">
	<div class="am-container-1">
		<div class="left hw-logo">
			<img class=" logo"
				src='${siteInfo.siteLogo }'></img>
				<span class="am-serif">${siteInfo.siteName }</span>
		</div>
		<button
			class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only"
			data-am-collapse="{target: '#doc-topbar-collapse'}">
			<span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span>
		</button>

		<div class="am-collapse am-topbar-collapse right"
			id="doc-topbar-collapse">

			<div class=" am-topbar-left am-form-inline am-topbar-right"
				role="search">
				<ul class="am-nav am-nav-pills am-topbar-nav hw-menu">
					<li <c:if test="${category.name=='首页' }">class="hw-menu-active"</c:if>>
								<a href='<c:url value="/"/>'>首页</a>
					</li>
					<c:forEach items="${categories.items }" var="item">
						<c:if test="${item.available }">
							<li <c:if test="${category.name==item.name }">class="hw-menu-active"</c:if>>
								<a href='<c:url value="list?categoryId=${item.id }"/>'
								<c:if test="${item.blank }">_blank</c:if>>${item.name }</a>
							</li>
						</c:if>
					</c:forEach>
					<li>
						<div class="-mob-share-ui-button -mob-share-open"
							 style="padding: 0em !important;background: #ffffff !important;color: #333 !important;font-weight:normal !important;">
						分享
						</div>
					</li>
					<li  class="am-dropdown" data-am-dropdown>
						<%--<c:if test="${s.username}"><%=s.getAttribute("username") %></c:if>--%>
						<%--<a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;">--%>
							<%--<%=s.getAttribute("username") %> <span class="am-icon-caret-down"></span>--%>
						<%--</a>--%>
						<a
								class="am-dropdown-toggle" data-am-dropdown-toggle
								href="javascript:;"> <span class="am-icon-users"></span> <%=s.getAttribute("USER_Name") %> <span
								class="am-icon-caret-down"></span>
						</a>
						<ul class="am-dropdown-content">
							<li><a href="#"><span class="am-icon-user"></span> 资料</a></li>
							<li><a href="#"><span class="am-icon-cog"></span> 设置</a></li>
							<li><a href="logout"><span class="am-icon-power-off"></span> 退出</a></li>
						</ul>

					</li>
				</ul>
			</div>
			<!--MOB SHARE begin-->
			<div class="-mob-share-ui" style="display: none">
				<ul class="-mob-share-list">
					<li class="-mob-share-weibo"><p>新浪微博</p></li>
					<li class="-mob-share-tencentweibo"><p>腾讯微博</p></li>
					<li class="-mob-share-qzone"><p>QQ空间</p></li>
					<li class="-mob-share-qq"><p>QQ好友</p></li>
					<li class="-mob-share-renren"><p>人人网</p></li>
					<li class="-mob-share-kaixin"><p>开心网</p></li>
					<li class="-mob-share-douban"><p>豆瓣</p></li>
					<li class="-mob-share-facebook"><p>Facebook</p></li>
					<li class="-mob-share-twitter"><p>Twitter</p></li>
				</ul>
				<div class="-mob-share-close">取消</div>
			</div>
			<div class="-mob-share-ui-bg"></div>
			<!--MOB SHARE END-->

		</div>
	</div><script id="-mob-share" src="http://f1.webshare.mob.com/code/mob-share.js?appkey=1c3756a24433c"></script>
</header>

