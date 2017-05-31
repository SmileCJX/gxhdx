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
                                   placeholder="学生姓名/ studentName" required="required" readonly="readonly">
                        </div>
                    </div>


                    <div class="am-form-group">
                        <label for="user-name" class="am-u-sm-3 am-form-label"> 学号
                            /  sno</label>
                        <div class="am-u-sm-9">
                            <input type="text" id="sno" name="sno" value="${entity.sno}"
                                   placeholder="学号/ sno" required="required" readonly="readonly">
                        </div>
                    </div>


                    <div class="am-form-group">
                        <label for="user-name" class="am-u-sm-3 am-form-label"> 年级
                            /  grade</label>
                        <div class="am-u-sm-9">
                            <input type="text" id="grade" name="grade" value="${entity.grade}"
                                   placeholder="年级/ sno" required="required" readonly="readonly">
                        </div>
                    </div>

                    <div class="am-form-group">
                        <label for="academy" class="am-u-sm-3 am-form-label"> 学院名称
                            /  AcademyName</label>
                        <div class="am-u-sm-9">
                            <input type="text" id="academy" name="academy" value="${entity.academy}"
                                   placeholder="学院名称/ academy" required="required" readonly="readonly">
                        </div>
                    </div>

                    <div class="am-form-group">
                        <label for="profession" class="am-u-sm-3 am-form-label"> 专业
                            /  profession</label>
                        <div class="am-u-sm-9">
                            <input type="text" id="profession" name="profession" value="${entity.profession}"
                                   placeholder="专业/ profession" required="required" readonly="readonly">
                        </div>
                    </div>

                    <div class="am-form-group">
                        <label for="user-name" class="am-u-sm-3 am-form-label"> 班级
                            /  classes</label>
                        <div class="am-u-sm-9">
                            <input type="text" id="classes" name="classes" value="${entity.classes}"
                                   placeholder="班级/ classes" required="required" readonly="readonly">
                        </div>
                    </div>


                    <div class="am-form-group">
                        <label for="user-name" class="am-u-sm-3 am-form-label"> 电话
                            /  phone</label>
                        <div class="am-u-sm-9">
                            <input type="text" id="phone" name="phone" value="${entity.phone}"
                                   placeholder="电话/ phone" required="required" readonly="readonly">
                        </div>
                    </div>


                    <div class="am-form-group">
                        <label for="user-name" class="am-u-sm-3 am-form-label"> 邮箱
                            /  email</label>
                        <div class="am-u-sm-9">
                            <input type="text" id="email" name="email" value="${entity.email}"
                                   placeholder="邮箱/ email" required="" readonly="readonly">
                        </div>
                    </div>


                    <div class="am-form-group">
                        <label for="user-name" class="am-u-sm-3 am-form-label"> 角色
                            /  role</label>
                        <div class="am-u-sm-9">
                            <input type="text" id="role" name="role" value="${entity.role}"
                                   placeholder="角色/ role" required="" readonly="readonly">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- content end -->
</body>
</html>
