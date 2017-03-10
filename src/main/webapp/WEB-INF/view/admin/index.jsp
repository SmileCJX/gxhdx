<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8"%>
<!-- content start -->
	<div class="admin-content-body">
		<div class="am-cf am-padding">
			<div class="am-fl am-cf">
				<strong class="am-text-primary am-text-lg">首页</strong> / <small>一些常用模块</small>
			</div>
		</div>
		<ul
			class="am-avg-sm-1 am-avg-md-4 am-margin am-padding am-text-center admin-content-list ">
			<li>
			<a href="/gxhdx/list?categoryId=4" class="am-text-success"><span
					class="am-icon-btn am-icon-file-text"></span><br />新闻动态</a></li>
			<li><a href="/gxhdx/list?categoryId=5" class="am-text-warning"><span
					class="am-icon-btn am-icon-briefcase"></span><br />高校百事通</a></li>
			<li><a href="/gxhdx/list?categoryId=1" class="am-text-danger"><span
					class="am-icon-btn am-icon-recycle"></span><br />关于我们</a></li>
			<li><a href="/gxhdx/" class="am-text-secondary"><span
					class="am-icon-btn am-icon-user-md"></span><br />首页</a></li>
		</ul>


		<div data-am-widget="list_news" class="am-list-news am-list-news-default" >
			<!--列表标题-->
			<div class="am-list-news-hd am-cf">
				<!--带更多链接-->
				<a href="/gxhdx/messageboard/index.jsp" class="">
					<h2>留言板</h2>
					<span class="am-list-news-more am-fr">更多 &raquo;</span>
				</a>
			</div>

			<div class="am-list-news-bd">
				<ul class="am-list">
					<c:forEach items="${messageboards}" var="item">
						<li class="am-g am-list-item-dated">
							<a href="##" class="am-list-item-hd ">${item.content}</a>
							<span class="am-list-date">${item.modifyDate}</span>
						</li>
						<br/>
					</c:forEach>
				</ul>
			</div>

		</div>

	</div>

	<footer class="admin-content-footer">
		<hr>
	</footer>
<!-- content end -->

