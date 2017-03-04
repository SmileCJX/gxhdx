<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->
<head>
<style type="text/css">
.am-form-group{
padding:10px;
}
.am-form-group span{
font-weight:bold;
width:80px;
display:inline-block
}
</style>
</head>
<body>
	<!-- content start -->
	<div class="admin-content">
		<div class="admin-content-body">
			<div class="am-cf am-padding am-padding-bottom-0">
				<div class="am-fl am-cf">
					<strong class="am-text-primary am-text-lg">教师管理</strong> / <small>Teacher</small>
				</div>
			</div>

			<hr>

			<div class="am-g">
				<form id="form" class="am-form-inline">
					  <div class="am-form-group">
					      <span >教师姓名</span>
					      <input type="text"  class="am-form-field" id="teacherName" name="teacherName" placeholder="教师姓名">
					  </div>
					  <div class="am-form-group">
					      <span >教师编号</span>
					      <input type="text"  class="am-form-field" id="tno" name="tno" placeholder="教师编号">
					  </div>
					  <div class="am-form-group">
					      <span >学院</span>
					      <input type="text"  class="am-form-field" id="academy" name="academy" placeholder="学院">
					  </div>
					  <div class="am-form-group">
					      <span >职称</span>
					      <input type="text"  class="am-form-field" id="rank" name="rank" placeholder="职称">
					  </div>
					  <div class="am-form-group">
					      <span >研究方向</span>
					      <input type="text"  class="am-form-field" id="research" name="research" placeholder="研究方向">
					  </div>
					  <div class="am-form-group">
					      <span >荣誉</span>
					      <input type="text"  class="am-form-field" id="honer" name="honer" placeholder="荣誉">
					  </div>
					  <div class="am-form-group">
					      <span >学历</span>
					      <input type="text"  class="am-form-field" id="education" name="education" placeholder="学历">
					  </div>
					  <div class="am-form-group">
					      <span >邮箱</span>
					      <input type="text"  class="am-form-field" id="email" name="email" placeholder="邮箱">
					  </div>
					  <div class="am-form-group">
					      <span >角色</span>
					      <input type="text"  class="am-form-field" id="role" name="role" placeholder="角色">
					  </div>
					  <div class="am-form-group">
					      <span >介绍</span>
					      <input type="text"  class="am-form-field" id="introduction" name="introduction" placeholder="介绍">
					  </div>
  					 <div class="am-form-group" style="padding:10px;">
				      <span >更新时间</span>
				      <input type="text"  class="am-form-field" id="startDate" name="startDate" placeholder="起"
							 data-am-datepicker readonly required>
				      -
				      <input type="text"  class="am-form-field" id="endDate" name="endDate" placeholder="止"
							 data-am-datepicker readonly required>
					  </div>
					<br>
					<div class="am-u-sm-8 ">
					 	 	<button type="button" class="am-btn am-btn-secondary"
									onclick="openWindow('teacher/add','附件新增');">
									<span class="am-icon-plus"></span> 新增
							</button>
							<button type="button" class="am-btn am-btn-warning"
								onClick="del();">
								<span class="am-icon-trash-o"></span> 删除
							</button>
							<button class="am-btn am-btn-success" type="button"
								onclick="query()">
								<span class="am-icon-search"></span> 搜索
							</button>
							<button class="am-btn am-btn-primary" type="reset">
								<span class="am-icon-refresh"></span> 重置
							</button>
					</div>
			<input type="hidden" id="pageNo" name="pageNo" />
					<input type="hidden" id="pageSize" name="pageSize" />
			</form>
		</div>
		<br>
			<div id="list" class="am-g"></div>
		</div>
		<%@ include file="/WEB-INF/view/common/footer.jsp"%>
	</div>
	<!-- content end -->
	<script type="text/javascript">
		$(function() {
			query();

			//调用时间控件，并格式化输出
			$('#startDate').datetimepicker({
				format: 'yyyy-mm-dd',
			});
			$('#endDate').datetimepicker({
				format: 'yyyy-mm-dd',
			});
		});
		function query(pageNo,pageSize) {
			$("#pageNo").val(pageNo);
			$("#pageSize").val(pageSize);
			var data = $("#form").serialize();
			data = decodeURIComponent(data, true);
			$.ajax({
						url : 'teacher/list',
						type : 'post',
						data :data,
						cache : false,
						contentType : "application/x-www-form-urlencoded; charset=utf-8",
						success : function(html) {
							$('#list').html(html);
						},
						error : function() {
							layer.msg('系统异常');
						}
					});
		}
		function del(id) {
			if (!id) {
				id = "";
				$("[name='checkitem'][checked]").each(function(index) {
					id += $(this).val();
					if (index < $("[name='checkitem'][checked]").length - 1) {
						id += ",";
					}
				});
				if(id.length<1){
					layer.msg("请选择要删除的选项");
					return;
				}
			}
			layer.msg('你确定要删除么？', {
				  time: 0 //不自动关闭
				  ,btn: ['确定', '取消']
				  ,yes: function(index){
					 
					  $.ajax({
							url : 'teacher/del',
							type : 'post',
							data : {
								ids : id
							},
							cache : false,
							contentType : "application/x-www-form-urlencoded; charset=utf-8",
							success : function(html) {
								if (html.success) {
									layer.msg("删除成功");
									query();
								} else {
									layer.msg('删除失败');
								}
							},
							error : function() {
								layer.msg('系统异常');
							}
						});//end ajax
					  
				  }//end yes function
				});//end layer.msg
			
		}
		function selectAll() {
			$('input:checkbox').prop("checked",
					document.getElementById("checkAll").checked);
			$('input:checkbox').attr("checked",
					document.getElementById("checkAll").checked);
		}
		function selectItem(obj) {
			$(obj).prop("checked",
					document.getElementById($(obj).attr("id")).checked);
			$(obj).attr("checked",
					document.getElementById($(obj).attr("id")).checked);
		}
	</script>
</body>
</html>
