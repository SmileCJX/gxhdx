<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%@ include file="/WEB-INF/view/common/head.jsp"%>
</head>
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
    以获得更好的体验！</p>
<![endif]-->
<body>
<!-- content start -->
<div class="admin-content">
    <div class="admin-content-body">
        <div class="am-cf am-padding am-padding-bottom-0">
            <hr>
        </div>
        <div class="am-g">
            <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                <div data-am-widget="list_news" class="am-list-news am-list-news-default" >
                    <c:forEach items="${entity }" var="item">
                        <div class="am-list-news-bd">
                            <ul class="am-list">

                                <li class="am-g am-list-item-dated">
                                    <a href="##" class="am-list-item-hd ">${item.title}</a>
                                    <span class="am-list-date">
                                        <fmt:formatDate value="${item.modifyDate}" pattern="yyyy年MM月dd日 E"/>&nbsp;
                                        <c:choose>
                                            <c:when test="${item.available}">审核通过</c:when>
                                            <c:otherwise>审核失败</c:otherwise>
                                        </c:choose>&nbsp;
                                        <c:choose>
                                            <c:when test="${item.remind}">已提醒</c:when>
                                            <c:otherwise>未反馈</c:otherwise>
                                        </c:choose>
                                </li>

                            </ul>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- content end -->
</body>
</html>
