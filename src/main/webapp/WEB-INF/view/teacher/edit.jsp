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
							<label for="user-name" class="am-u-sm-3 am-form-label"> 教师姓名
								/  teacherName</label>
							<div class="am-u-sm-9">
								<input type="text" id="teacherName" name="teacherName" value="${entity.teacherName}"
									placeholder="教师姓名/ teacherName" required="required">
							</div>
						</div>
					
	
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label"> 教师编号
								/  tno</label>
							<div class="am-u-sm-9">
								<input type="text" id="tno" name="tno" value="${entity.tno}"
									placeholder="教师编号/ tno" required="required">
							</div>
						</div>
					
	
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label"> 学院
								/  academy</label>
							<div class="am-u-sm-9">
								<input type="text" id="academy" name="academy" value="${entity.academy}"
									placeholder="学院/ academy" required="required">
							</div>
						</div>
					
	
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label"> 职称
								/  rank</label>
							<div class="am-u-sm-9">
								<input type="text" id="rank" name="rank" value="${entity.rank}"
									placeholder="职称/ rank" required="required">
							</div>
						</div>
					
	
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label"> 研究方向
								/  research</label>
							<div class="am-u-sm-9">
								<input type="text" id="research" name="research" value="${entity.research}"
									placeholder="研究方向/ research" required="required">
							</div>
						</div>
					
	
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label"> 荣誉
								/  honer</label>
							<div class="am-u-sm-9">
								<input type="text" id="honer" name="honer" value="${entity.honer}"
									placeholder="荣誉/ honer" required="required">
							</div>
						</div>
					
	
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label"> 学历
								/  education</label>
							<div class="am-u-sm-9">
								<input type="text" id="education" name="education" value="${entity.education}"
									placeholder="学历/ education" required="required">
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
								<input type="text" id="role" name="role" value="${entity.role}"
									placeholder="角色/ role" required="">
							</div>
						</div>
					
	
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label"> 介绍
								/  introduction</label>
							<div class="am-u-sm-9">
								<input type="text" id="introduction" name="introduction" value="${entity.introduction}"
									placeholder="介绍/ introduction" required="required">
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
		<%@ include file="/WEB-INF/view/common/footer.jsp"%>
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
	</script>
</body>
</html>
