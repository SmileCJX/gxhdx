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
							<label for="user-name" class="am-u-sm-3 am-form-label"> 活动类型
								/  typeName</label>
							<div class="am-u-sm-9">
								<input type="text" id="typeName" name="typeName" value="${entity.typeName}"
									placeholder="活动类型/ typeName" required="required">
							</div>
						</div>
					
	
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label"> 简介
								/  introduction</label>
							<div class="am-u-sm-9">
								<input type="text" id="introduction" name="introduction" value="${entity.introduction}"
									placeholder="简介/ introduction" required="required">
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-phone" class="am-u-sm-3 am-form-label">缩略图
								/ ImgUrl</label>
							<div class="am-u-sm-9">
								<div class="am-form-group am-form-file" >
									<button type="button" class="am-btn am-btn-danger am-btn-sm" onclick="openChooseLayer();">
										<i class="am-icon-cloud-upload"></i> 选择要上传的文件
									</button>
								</div>
								<img alt="" src="${entity.imgUrl }" id="showImg" width="300px" height="200px">
								<button type="button" class="am-btn am-btn-danger am-btn-sm" id="deleteImg" onclick="delImg('${entity.imgUrl}')">
									删除
								</button>
								<input type="hidden" id="imgUrl" name="imgUrl" value="${entity.imgUrl }">
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

		var data = {
			url : '',
			alt : ''
		};
		function openChooseLayer() {
			layer.open({
				type : 2,
				title : '选择图片',
				shadeClose : true,
				shade : 0.8,
				area : [ '92%', '90%' ],
				content : '<c:url value="/common/chooseLayer"/>',
				end : function() {
					console.log(data.url)
					$("#imgUrl").val(data.url);
					$("#showImg").attr("src",data.url);
					$("#deleteImg").attr("onclick","delImg('"+data.url+"')");
				}
			});
		}
		function delImg(path){
			$("#imgUrl").val("");
			$("#showImg").attr("src","");
			/* if(path==null){
			 return;
			 }
			 $.ajax({
			 url : "../common/fileDelete",
			 data : {
			 path:path
			 },
			 method : 'post',
			 contentType : 'application/x-www-form-urlencoded',
			 encoding : 'UTF-8',
			 cache : false,
			 success : function(result) {
			 if (result.success) {
			 $("#siteLogo").val("");
			 $("#showImg").attr("src","");
			 layer.msg('删除成功');
			 } else {
			 layer.msg('删除失败');
			 }
			 },
			 error : function() {
			 layer.msg('系统异常');
			 }
			 }); */
		}
	</script>
</body>
</html>
