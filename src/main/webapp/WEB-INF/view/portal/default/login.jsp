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
<body class="login-container">
<%@ include file="/WEB-INF/view/portal/default/header.jsp"%>
<%@ include file="/WEB-INF/view/portal/default/top.jsp"%>
<link rel="stylesheet" type="text/css"
      href='<c:url value="/static/css/common.min.css"/>'>
<link rel="stylesheet" type="text/css"
      href='<c:url value="/static/css/other.min.css"/>'>
<br>
<%--<div class=" am-container">${article.content }</div>--%>
<div class=" am-container">
    <div class="login-box">
        <form action="" class="am-form" data-am-validator id="login-form" data-am-validator onsubmit="return false;">
            <div class="am-form-group">
                <label for="doc-vld-name-2"><i class="am-icon-user"></i></label>
                <input type="text" id="studentName" name="studentName" minlength="3" placeholder="输入用户名（至少 3 个字符）" required/>
            </div>

            <div class="am-form-group">
                <label for="doc-vld-email-2"><i class="am-icon-key"></i></label>
                <input type="password" id="password" name="password" placeholder="输入密码" required/>
            </div>
            <button class="am-btn am-btn-secondary" onclick="submitDo();"  type="submit">登录</button>
        </form>
    </div>
</div>

<hr>
<div data-am-widget="gotop" class="am-gotop am-gotop-fixed" >
    <a href="#top" title="">
        <i class="am-gotop-icon am-icon-hand-o-up"></i>
    </a>
</div>
<%@ include file="/WEB-INF/view/portal/default/footer.jsp"%>
<script type="text/javascript" src="<c:url value="/static/js/app.js"/>"></script>
<script type="text/javascript"
        src="<c:url value="/static/js/layer/layer.js"/>"></script>
<script type="text/javascript">
    function submitDo() {
        setTimeout("ajaxDo()",10);
    }
    function ajaxDo(){
        var data = $("#login-form").serialize();
        data = decodeURIComponent(data, true);
        $.ajax({
            url : "portal/login",
            data : data,
            method : 'post',
            contentType : 'application/x-www-form-urlencoded',
            encoding : 'UTF-8',
            cache : false,
            success : function(result) {
                if (result.success) {
                    layer.msg('登录成功');
                    window.location.href = '<c:url value="/"/>';
                } else {
                    layer.msg('登录失败');
                }
            },
            error : function() {
                layer.msg('系统异常');
            }
        });
    }
</script>
</body>
</html>
