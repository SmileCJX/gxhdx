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
						
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label"> 部门编号
								/  dno</label>
							<div class="am-u-sm-9">
								<input type="text"  id="dno" name="dno" 
									placeholder="部门编号/ dno"  required="required" >
							</div>
						</div>
					
	
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label"> 部门名称
								/  name</label>
							<div class="am-u-sm-9">
								<input type="text"  id="name" name="name" 
									placeholder="部门名称/ name"  required="required" >
							</div>
						</div>
					
	
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label"> 部长姓名
								/  ministerName</label>
							<div class="am-u-sm-9">
								<input type="text"  id="ministerName" name="ministerName" 
									placeholder="部长姓名/ ministerName"  required="required" >
							</div>
						</div>
					
	
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label"> 部长电话
								/  ministerPhone</label>
							<div class="am-u-sm-9">
								<input type="text"  id="ministerPhone" name="ministerPhone" 
									placeholder="部长电话/ ministerPhone"  required="required" >
							</div>
						</div>
					
	
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label"> 总人数
								/  totalPersons</label>
							<div class="am-u-sm-9">
								<input type="text"  id="totalPersons" name="totalPersons" 
									placeholder="总人数/ totalPersons"  required="" >
							</div>
						</div>
					
	
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label"> 描述
								/  description</label>
							<div class="am-u-sm-9">
								<input type="text"  id="description" name="description" 
									placeholder="描述/ description"  required="" >
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
