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


						<%--<div class="am-form-group">--%>
							<%--<label for="user-name" class="am-u-sm-3 am-form-label"> 活动内容--%>
								<%--/  content</label>--%>
							<%--<div class="am-u-sm-9">--%>
								<%--<input type="text"  id="content" name="content" --%>
									<%--placeholder="活动内容/ content"  required="required" >--%>
							<%--</div>--%>
						<%--</div>--%>
						<div class="am-form-group">
							<label for="user-QQ" class="am-u-sm-3 am-form-label">内容 /
								Content</label>
							<div class="am-u-sm-9">
								<textarea name="content" id="content" rows="20"></textarea>
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
								/  Name</label>
							<div class="am-u-sm-9">
								<select class="form-control" id="department_id" name="department_id">
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
								/  AcademyName</label>
							<div class="am-u-sm-9">
								<select class="form-control" id="activitytype_id" name="activitytype_id">
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
					
	
						<%--<div class="am-form-group">--%>
							<%--<label for="user-name" class="am-u-sm-3 am-form-label"> 浏览数--%>
								<%--/  hits</label>--%>
							<%--<div class="am-u-sm-9">--%>
								<%--<input type="text"  id="hits" name="hits" --%>
									<%--placeholder="浏览数/ hits"  required="" >--%>
							<%--</div>--%>
						<%--</div>--%>
					
	
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label"> 活动备注
								/  remark</label>
							<div class="am-u-sm-9">
								<input type="text"  id="remark" name="remark" 
									placeholder="活动备注/ remark"  required="required" >
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-weibo" class="am-u-sm-3 am-form-label">是否可用
								/ Available</label>
							<div class="am-u-sm-9 am-form-select">
								<select  id="available"
										 name="available">
									<option value="1">可用</option>
									<option value="0">禁用</option>
								</select>
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-phone" class="am-u-sm-3 am-form-label">活动图片
								/ ImgUrl</label>
							<div class="am-u-sm-9">
								<div class="am-form-group am-form-file" >
									<button type="button" class="am-btn am-btn-danger am-btn-sm" onclick="openChooseLayer();">
										<i class="am-icon-cloud-upload"></i> 选择要上传的文件
									</button>
								</div>
								<img alt="" src="" id="showImg" width="300px" height="200px">
								<button type="button" class="am-btn am-btn-danger am-btn-sm" id="deleteImg">
									删除
								</button>
								<input type="hidden" id="imgUrl" name="imgUrl">
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
	<script type="text/javascript"
			src="<c:url value="/static/plugin/tinymce/tinymce.min.js"/>"></script>
	<script type="text/javascript">
		$(function() {
			setTexteara();
		});

		function submitDo() {

			setTimeout("ajaxDo()",10);
		}
		function ajaxDo(){
			$("#content").val(tinyMCE.get('content').getContent());
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
		function setTexteara() {
			tinymce.init({
				selector : '#content',
				height : 500,
				language : 'zh_CN',
				menubar : false,
				automatic_uploads : true,
				paste_data_images : true,
				convert_urls : false,
				imagetools_toolbar : "rotateleft rotateright | flipv fliph | editimage imageoptions",
				/*  imagetools_proxy: '${CPATH}/admin/tinymce/image/proxy',
				 images_upload_url: '${CPATH}/admin/tinymce/image/upload', */
				wordcount_countregex : /[\u4e00-\u9fa5_a-zA-Z0-9]/g,
				file_picker_callback : function(callback, value, meta) {
					layer.open({
						type : 2,
						title : '选择图片',
						shadeClose : true,
						shade : 0.8,
						area : [ '92%', '90%' ],
						content : '<c:url value="/common/chooseLayer"/>',
						end : function() {
							callback(data.url, {alt : data.alt});
						}
					});
				},
				plugins : [
					"advlist autolink autosave link image imagetools lists charmap print preview hr anchor pagebreak spellchecker",
					"searchreplace wordcount visualblocks visualchars code codesample fullscreen insertdatetime media nonbreaking",
					"table contextmenu directionality emoticons template textcolor paste fullpage textcolor colorpicker textpattern" ],
				toolbar1 : '  bold italic underline strikethrough removeformat | blockquote hr table image | link  anchor unlink | alignleft aligncenter alignright alignjustify | bullist numlist  | fullscreen code   ',
				toolbar2 : '  formatselect | outdent indent | forecolor backcolor  | codesample undo redo  ',
			});
		}
		function openChooseLayer() {
			layer.open({
				type : 2,
				title : '选择图片',
				shadeClose : true,
				shade : 0.8,
				area : [ '92%', '90%' ],
				content : '<c:url value="/common/chooseLayer"/>',
				end : function() {
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
