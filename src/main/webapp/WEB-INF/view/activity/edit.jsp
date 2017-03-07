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
							<label for="user-name" class="am-u-sm-3 am-form-label"> 活动标题
								/  title</label>
							<div class="am-u-sm-9">
								<input type="text" id="title" name="title" value="${entity.title}"
									placeholder="活动标题/ title" required="required">
							</div>
						</div>
					
	
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label"> 活动内容
								/  content</label>
							<div class="am-u-sm-9">
								<input type="text" id="content" name="content" value="${entity.content}"
									placeholder="活动内容/ content" required="required">
							</div>
						</div>
					
	
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label"> 活动关键字
								/  keyword</label>
							<div class="am-u-sm-9">
								<input type="text" id="keyword" name="keyword" value="${entity.keyword}"
									placeholder="活动关键字/ keyword" required="required">
							</div>
						</div>
					
	
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label"> 活动相关连接
								/  url</label>
							<div class="am-u-sm-9">
								<input type="text" id="url" name="url" value="${entity.url}"
									placeholder="活动相关连接/ url" required="">
							</div>
						</div>


						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label"> 活动主办部门
								/  Name</label>
							<div class="am-u-sm-9">
								<select class="form-control" id="department_id" name="department_id">
									<option value="${entity.department.id}" selected>
										${entity.department.name}
									</option>
									<c:forEach var="value" items="${departments}">
										<option value="${value.id}">
												${value.name}
										</option>
									</c:forEach>
								</select>
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label"> 活动类型
								/  typeName</label>
							<div class="am-u-sm-9">
								<select class="form-control" id="activitytype_id" name="activitytype_id">
									<option value="${entity.activityType.id}" selected>
										${entity.activityType.typeName}
									</option>
									<c:forEach var="value" items="${activityTypes}">
										<option value="${value.id}">
												${value.typeName}
										</option>
									</c:forEach>
								</select>
							</div>
						</div>
					
	
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label"> 活动承办人员
								/  sponsor</label>
							<div class="am-u-sm-9">
								<input type="text" id="sponsor" name="sponsor" value="${entity.sponsor}"
									placeholder="活动承办人员/ sponsor" required="required">
							</div>
						</div>
					
	
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label"> 活动承办人联系电话
								/  sponsorPhone</label>
							<div class="am-u-sm-9">
								<input type="text" id="sponsorPhone" name="sponsorPhone" value="${entity.sponsorPhone}"
									placeholder="活动承办人联系电话/ sponsorPhone" required="required">
							</div>
						</div>
					
	
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label"> 浏览数
								/  hits</label>
							<div class="am-u-sm-9">
								<input type="text" id="hits" name="hits" value="${entity.hits}"
									placeholder="浏览数/ hits" required="">
							</div>
						</div>
					
	
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label"> 活动备注
								/  remark</label>
							<div class="am-u-sm-9">
								<input type="text" id="remark" name="remark" value="${entity.remark}"
									placeholder="活动备注/ remark" required="required">
							</div>
						</div>


						<div class="am-form-group">
							<label for="user-weibo" class="am-u-sm-3 am-form-label">是否可用
								/ Available</label>
							<div class="am-u-sm-9 am-form-select">
								<select  id="available"
										 name="available">
									<option value="1" <c:if test="${entity.available}">selected="selected"</c:if>>可用</option>
									<option value="0" <c:if test="${!entity.available}">selected="selected"</c:if>>禁用</option>
								</select>
							</div>
						</div>
					
	
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label"> 活动图片
								/  imgUrl</label>
							<div class="am-u-sm-9">
								<input type="text" id="imgUrl" name="imgUrl" value="${entity.imgUrl}"
									placeholder="活动图片/ imgUrl" required="required">
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
