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
							<label for="user-name" class="am-u-sm-3 am-form-label"> 活动标题
								/  title</label>
							<div class="am-u-sm-9">
								<input type="text"  id="title" name="title" 
									placeholder="活动标题/ title"  required="required" >
							</div>
						</div>
					
	
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label"> 活动内容
								/  content</label>
							<div class="am-u-sm-9">
								<input type="text"  id="content" name="content" 
									placeholder="活动内容/ content"  required="required" >
							</div>
						</div>
					
	
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label"> 活动开始日期
								/  activityStartDate</label>
							<div class="am-u-sm-9">
								<input type="text"  id="activityStartDate" name="activityStartDate" 
									placeholder="活动开始日期/ activityStartDate"  required="required" >
							</div>
						</div>
					
	
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label"> 活动结束日期
								/  activityEndDate</label>
							<div class="am-u-sm-9">
								<input type="text"  id="activityEndDate" name="activityEndDate" 
									placeholder="活动结束日期/ activityEndDate"  required="required" >
							</div>
						</div>
					
	
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label"> 活动报名开始日期
								/  applyStartDate</label>
							<div class="am-u-sm-9">
								<input type="text"  id="applyStartDate" name="applyStartDate" 
									placeholder="活动报名开始日期/ applyStartDate"  required="required" >
							</div>
						</div>
					
	
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label"> 活动报名结束日期
								/  applyEndDate</label>
							<div class="am-u-sm-9">
								<input type="text"  id="applyEndDate" name="applyEndDate" 
									placeholder="活动报名结束日期/ applyEndDate"  required="required" >
							</div>
						</div>
					
	
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label"> 活动关键字
								/  keyword</label>
							<div class="am-u-sm-9">
								<input type="text"  id="keyword" name="keyword" 
									placeholder="活动关键字/ keyword"  required="required" >
							</div>
						</div>
					
	
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label"> 活动相关连接
								/  url</label>
							<div class="am-u-sm-9">
								<input type="text"  id="url" name="url" 
									placeholder="活动相关连接/ url"  required="" >
							</div>
						</div>
					
	
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label"> 活动主办部门
								/  depatement</label>
							<div class="am-u-sm-9">
								<input type="text"  id="depatement" name="depatement" 
									placeholder="活动主办部门/ depatement"  required="" >
							</div>
						</div>
					
	
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label"> 活动承办人员
								/  sponsor</label>
							<div class="am-u-sm-9">
								<input type="text"  id="sponsor" name="sponsor" 
									placeholder="活动承办人员/ sponsor"  required="required" >
							</div>
						</div>
					
	
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label"> 活动承办人联系电话
								/  sponsorPhone</label>
							<div class="am-u-sm-9">
								<input type="text"  id="sponsorPhone" name="sponsorPhone" 
									placeholder="活动承办人联系电话/ sponsorPhone"  required="required" >
							</div>
						</div>
					
	
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label"> 浏览数
								/  hits</label>
							<div class="am-u-sm-9">
								<input type="text"  id="hits" name="hits" 
									placeholder="浏览数/ hits"  required="" >
							</div>
						</div>
					
	
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label"> 活动类型
								/  type</label>
							<div class="am-u-sm-9">
								<input type="text"  id="type" name="type" 
									placeholder="活动类型/ type"  required="required" >
							</div>
						</div>
					
	
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label"> 活动备注
								/  remark</label>
							<div class="am-u-sm-9">
								<input type="text"  id="remark" name="remark" 
									placeholder="活动备注/ remark"  required="required" >
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
