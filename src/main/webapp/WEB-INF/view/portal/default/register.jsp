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
    <link rel="stylesheet" type="text/css"
          href='<c:url value="/static/css/common.min.css"/>'>
    <link rel="stylesheet" type="text/css"
          href='<c:url value="/static/css/other.min.css"/>'>
</head>
<body>
<%@ include file="/WEB-INF/view/portal/default/header.jsp"%>
<%@ include file="/WEB-INF/view/portal/default/top.jsp"%>
<br>
<div class=" am-container register-container">
    <!--===========layout-container================-->
    <div class="register-box">
        <form action="" class="am-form" id="register-form" data-am-validator onsubmit="return false;">
            <fieldset>
                <legend>注册用户<p class="register-info">账号可以使用手机或者邮箱注册，但是仔细核对后，填入正确信息。</p></legend>

                <div class="am-form-group">
                    <div class="am-g">
                        <div class="am-u-md-2 am-padding-0 am-text-right">
                            <label for="doc-vld-name-2" class="register-name">账号</label>
                        </div>
                        <div class="am-u-md-10">
                            <input type="text" id="doc-vld-name-2" minlength="3"
                                   placeholder="输入用户名（至少 3 个字符）" required/>
                        </div>
                    </div>
                </div>

                <div class="am-form-group">
                    <div class="am-g">
                        <div class="am-u-md-2 am-padding-0 am-text-right">
                            <label for="doc-vld-name-2" class="register-name">姓名</label>
                        </div>
                        <div class="am-u-md-10">
                            <input type="text" id="studentName" name="studentName" minlength="3"
                                   placeholder="输入用户名（至少 3 个字符）" required/>
                        </div>
                    </div>
                </div>

                <div class="am-form-group">
                    <div class="am-g">
                        <div class="am-u-md-2 am-padding-0 am-text-right">
                            <label for="doc-vld-name-2" class="register-sno">学号</label>
                        </div>
                        <div class="am-u-md-10">
                            <input type="text" id="sno" name="sno" minlength="3"
                                   placeholder="请输入学号" required/>
                        </div>
                    </div>
                </div>

                <div class="am-form-group">
                    <div class="am-g">
                        <div class="am-u-md-2 am-padding-0 am-text-right">
                            <label for="doc-vld-name-2" class="register-grade">年级</label>
                        </div>
                        <div class="am-u-md-10">
                            <select class="form-control" id="grade" name="grade">
                                <option value="12级" selected>12级</option>
                                <option value="13级">13级</option>
                                <option value="14级">14级</option>
                                <option value="15级">15级</option>
                                <option value="16级">16级</option>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="am-form-group">
                    <div class="am-g">
                        <div class="am-u-md-2 am-padding-0 am-text-right">
                            <label for="doc-vld-name-2" class="register-academyName">学院</label>
                        </div>
                        <div class="am-u-md-10">
                            <input type="text" id="academy" name="academy" minlength="3"
                                   placeholder="请输入学院" required/>
                            <%--<select class="form-control" id="academy" name="academy">--%>
                                    <%--<option value="${value.academyName}">--%>
                                            <%--${value.academyName}--%>
                                    <%--</option>--%>
                            <%--</select>--%>
                        </div>
                    </div>
                </div>

                <div class="am-form-group">
                    <div class="am-g">
                        <div class="am-u-md-2 am-padding-0 am-text-right">
                            <label for="doc-vld-name-2" class="register-profession">专业</label>
                        </div>
                        <div class="am-u-md-10">
                            <input type="text" id="profession" name="profession" minlength="3"
                                   placeholder="请输入专业" required/>
                        </div>
                    </div>
                </div>

                <div class="am-form-group">
                    <div class="am-g">
                        <div class="am-u-md-2 am-padding-0 am-text-right">
                            <label for="doc-vld-name-2" class="register-classes">班级</label>
                        </div>
                        <div class="am-u-md-10">
                            <input type="text" id="classes" name="classes" minlength="3"
                                   placeholder="请输入班级" required/>
                        </div>
                    </div>
                </div>

                <div class="am-form-group">
                    <div class="am-g">
                        <div class="am-u-md-2 am-padding-0 am-text-right">
                            <label for="doc-vld-name-2" class="register-phone">电话</label>
                        </div>
                        <div class="am-u-md-10">
                            <input type="text" id="phone" name="phone" minlength="3"
                                   placeholder="请输入电话" required/>
                        </div>
                    </div>
                </div>

                <div class="am-form-group">
                    <div class="am-g">
                        <div class="am-u-md-2 am-padding-0 am-text-right">
                            <label for="doc-vld-name-2" class="register-email">邮箱</label>
                        </div>
                        <div class="am-u-md-10">
                            <input type="text" id="email" name="email" minlength="3"
                                   placeholder="请输入邮箱" required/>
                        </div>
                    </div>
                </div>

                <div class="am-form-group">
                    <div class="am-g">
                        <div class="am-u-md-2 am-padding-0 am-text-right">
                            <label for="password" class="register-pwd">密码</label>
                        </div>
                        <div class="am-u-md-10">
                            <input type="password" id="password" name="password" placeholder="请输入密码"  required/>
                        </div>
                    </div>
                </div>

                <div class="am-form-group">
                    <div class="am-g">
                        <div class="am-u-md-2 am-padding-0 am-text-right">
                            <label for="repassword">确认密码</label>
                        </div>
                        <div class="am-u-md-10">
                            <input type="password" id="repassword" name="repassword" placeholder="请与上面输入的值一致" data-equal-to="password" required/>
                        </div>
                    </div>
                </div>

                <div class="am-g">
                    <div class="am-u-md-10">
                        <button class="am-btn am-btn-secondary" onclick="submitDo();" type="submit">注册</button>
                    </div>
                </div>
            </fieldset>
        </form>
    </div>

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
    <%--$(function() {--%>
        <%--alert("hahah ");--%>
        <%--getAcademy();--%>
    <%--});--%>
    <%--function getAcademy(){--%>
        <%--$.ajax({--%>
            <%--url : "portal/getAcademy",--%>
            <%--data : {},--%>
            <%--contentType : 'application/x-www-form-urlencoded',--%>
            <%--encoding : 'UTF-8',--%>
            <%--cache : false,--%>
            <%--success : function(result) {--%>
<%--//                var content = "";--%>
<%--//                for(var i=0; i<result.length; i++){--%>
<%--//                    content += "<option value='"+result.academyName+"'>"+result.academyName+"</option>";--%>
<%--//                }--%>
                <%--${"#academy"}.empty().append(content);--%>
            <%--}--%>
        <%--})--%>
    <%--}--%>

    <%--function getProfession(){--%>
        <%--$.ajax({--%>
            <%--url : "portal/getProfession",--%>
            <%--data : {},--%>
            <%--contentType : 'application/x-www-form-urlencoded',--%>
            <%--encoding : 'UTF-8',--%>
            <%--cache : false,--%>
            <%--success : function(result) {--%>

            <%--}--%>
        <%--})--%>
    <%--}--%>

    function submitDo() {
        setTimeout("ajaxDo()",10);
    }
    function ajaxDo(){
        var data = $("#register-form").serialize();
        data = decodeURIComponent(data, true);
        $.ajax({
            url : "portal/register",
            data : data,
            method : 'post',
            contentType : 'application/x-www-form-urlencoded',
            encoding : 'UTF-8',
            cache : false,
            success : function(result) {
                if (result.success) {
                    layer.msg('注册成功');
                    window.location.href = '<c:url value="/"/>';
                } else {
                    layer.msg('注册失败');
                }
            },
            error : function() {
                layer.msg('注册异常');
            }
        });
    }

</script>
</body>
</html>
