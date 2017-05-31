<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
            <div class="am-u-sm-12 am-u-md-10">
                <form class="am-form am-form-horizontal" id="form" data-am-validator onsubmit="return false;">
                    <input type="hidden" name="id" value="${entity.id }" />

                    <div class="am-form-group">
                        <label for="user-name" class="am-u-sm-3 am-form-label"> 学生姓名
                            /  studentName</label>
                        <div class="am-u-sm-9">
                            <input type="text" id="studentName" name="studentName" value="${entity.studentName}"
                                   placeholder="学生姓名/ studentName" required="required">
                        </div>
                    </div>


                    <div class="am-form-group">
                        <label for="user-name" class="am-u-sm-3 am-form-label"> 学号
                            /  sno</label>
                        <div class="am-u-sm-9">
                            <input type="text" id="sno" name="sno" value="${entity.sno}"
                                   placeholder="学号/ sno" required="required">
                        </div>
                    </div>


                    <div class="am-form-group">
                        <label for="user-name" class="am-u-sm-3 am-form-label"> 年级
                            /  grade</label>
                        <div class="am-u-sm-9">
                            <select class="form-control" id="grade" name="grade">
                                <option value="${entity.grade}" selected>${entity.grade}</option>
                                <option value="12级">12级</option>
                                <option value="13级">13级</option>
                                <option value="14级">14级</option>
                                <option value="15级">15级</option>
                                <option value="16级">16级</option>
                            </select>
                        </div>
                    </div>

                    <div class="am-form-group">
                        <label for="academy" class="am-u-sm-3 am-form-label"> 学院名称
                            /  AcademyName</label>
                        <div class="am-u-sm-9">
                            <select class="form-control" id="academy" name="academy">
                                <option value="${entity.academy}" selected>
                                    ${entity.academy}
                                </option>
                                <c:forEach var="value" items="${academys}">
                                    <option value="${value.academyName}">
                                            ${value.academyName}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>

                    <div class="am-form-group">
                        <label for="profession" class="am-u-sm-3 am-form-label"> 专业
                            /  profession</label>
                        <div class="am-u-sm-9">
                            <select class="form-control" id="profession" name="profession">
                                <option value="${entity.profession}" selected>
                                    ${entity.profession}
                                </option>
                                <c:forEach var="value" items="${professions}">
                                    <option value="${value.professionName}">
                                            ${value.professionName}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>

                    <div class="am-form-group">
                        <label for="user-name" class="am-u-sm-3 am-form-label"> 班级
                            /  classes</label>
                        <div class="am-u-sm-9">
                            <input type="text" id="classes" name="classes" value="${entity.classes}"
                                   placeholder="班级/ classes" required="required">
                        </div>
                    </div>


                    <div class="am-form-group">
                        <label for="user-name" class="am-u-sm-3 am-form-label"> 电话
                            /  phone</label>
                        <div class="am-u-sm-9">
                            <input type="text" id="phone" name="phone" value="${entity.phone}"
                                   placeholder="电话/ phone" required="required">
                        </div>
                    </div>


                    <div class="am-form-group">
                        <label for="user-name" class="am-u-sm-3 am-form-label"> 邮箱
                            /  email</label>
                        <div class="am-u-sm-9">
                            <input type="text" id="email" name="email" value="${entity.email}"
                                   placeholder="邮箱/ email" required="">
                        </div>
                    </div>


                    <div class="am-form-group">
                        <label for="user-name" class="am-u-sm-3 am-form-label"> 角色
                            /  role</label>
                        <div class="am-u-sm-9">
                            <select class="form-control" id="role" name="role">
                                <option value="${entity.role}" selected>${entity.role}</option>
                                <option value="学生" selected>学生</option>
                                <option value="班长">班长</option>
                                <option value="学习委员">学习委员</option>
                                <option value="团支书">团支书</option>
                                <option value="生活委员">生活委员</option>
                                <option value="纪律委员">纪律委员</option>
                            </select>
                        </div>
                    </div>

                    <div class="am-form-group">
                        <label for="user-name" class="am-u-sm-3 am-form-label"> 密码重置
                            /  email</label>
                        <div class="am-u-sm-9">
                            <input type="password" id="password" name="password" value="${entity.password}"
                                   placeholder="密码/ password" required="" class="login-field login-field-password">
                        </div>
                    </div>

                    <div class="am-form-group">
                        <div class="am-u-sm-9 am-u-sm-push-3">
                            <button type="submit" onclick="submitDo();"
                                    class="am-btn am-btn-primary">保存</button>
                        </div>
                    </div>

                </form>
            </div>
        </div>
    </div>
</div>
<!-- content end -->
<script type="text/javascript">
    function submitDo() {
        setTimeout("ajaxDo()",10);
    }
    function ajaxDo(){
        if($("#form .am-field-error").size()!=0){
            return false;
        }
        var data = $("#form").serialize();
        data = decodeURIComponent(data, true);
        $.ajax({
            url : "edit",
            data : data,
            method : 'post',
            contentType : 'application/x-www-form-urlencoded',
            encoding : 'UTF-8',
            cache : false,
            success : function(result) {
                if (result.success) {
                    layer.msg('保存成功');
                    setTimeout("closeWindow()", 1000);
                } else {
                    layer.msg('保存失败');
                }
            },
            error : function() {
                layer.msg('系统异常');
            }
        });
    }
    $('#password').hideShowPassword({
        // Creates a wrapper and toggle element with minimal styles.
        innerToggle: true,
        // Makes the toggle functional in touch browsers without
        // the element losing focus.
        touchSupport: Modernizr.touch
    });
</script>
</body>
</html>
