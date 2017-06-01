<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page pageEncoding="UTF-8"%>
<%--<% HttpSession s = request.getSession();%>--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->
<head>
<%@ include file="/WEB-INF/view/portal/default/portalHead.jsp"%>
</head>
<body>
	<%@ include file="/WEB-INF/view/portal/default/header.jsp"%>
	<%@ include file="/WEB-INF/view/portal/default/top.jsp"%>
	<div class="am-container">
		<article class="am-article">
		<div class="am-article-hd">
			<br>
			<h1 class="am-article-title">${entity.title }</h1>
			<br>
			<p class="am-article-meta">作者：${entity.sponsor }</p>
			<br>
			<p class="am-article-meta">发布日期：<fmt:formatDate value="${entity.modifyDate}" pattern="yyyy年MM月dd日 E"/></p>
			<br/>
			<p class="am-article-meta"><button type="button" class="am-btn am-btn-success am-round" onclick="apply();">我要报名</button></p>
			<br>
		</div>

		<div class="am-article-bd">
			<p class="am-article-lead">摘要：${entity.remark }</p>
			<hr>
			${entity.content }
			<hr>
		</div>
		</article>
		<c:forEach items="${commentList }" var="item">
			<article class="am-comment">
				<a href="#link-to-user-home">
					<img src="/gxhdx/static/image/login/user.png" alt="" class="am-comment-avatar" width="48" height="48"/>
				</a>

				<div class="am-comment-main">
					<header class="am-comment-hd">
						<!--<h3 class="am-comment-title">评论标题</h3>-->
						<div class="am-comment-meta">
							<a href="#link-to-user" class="am-comment-author">${item.username }</a>
							评论于 <time datetime="2013-07-27T04:54:29-07:00" title="2013年7月27日 下午7:54 格林尼治标准时间+0800"><fmt:formatDate value="${item.modifyDate }" pattern="yyyy年MM月dd日 E"/></time>
						</div>
					</header>

					<div class="am-comment-bd">
							${item.content }
					</div>
				</div>
			</article>
		</c:forEach>

		<form action="" class="am-form" id="ue-form">
			<fieldset>
				<div class="am-form-group">
					<label for="content">评论：</label>
					<textarea class="am-validate" id="content" name="content"  required></textarea>
				</div>
				<input type="text" id="activityId" name="activityId"  style="display: none" value="${entity.id}" required/>
				<input type="text" id="username" name="username"  style="display: none"  required/>
				<button class="am-btn am-btn-secondary" type="submit" onclick="submitDo();">提交</button>
			</fieldset>
		</form>
	</div>

	<div data-am-widget="gotop" class="am-gotop am-gotop-fixed" >
		<a href="#top" title="">
			<i class="am-gotop-icon am-icon-hand-o-up"></i>
		</a>
	</div>
	<%@ include file="/WEB-INF/view/portal/default/footer.jsp"%>
	<script src="<c:url value="/static/plugin/ueditor/ueditor.config.js"/>"></script>
	<script src="<c:url value="/static/plugin/ueditor/ueditor.all.js"/>"></script>
</body>
</html>

<script type="text/javascript">
	$(function() {
		$("#username").attr("value",$(".am-dropdown-toggle").text().trim());

		var $textArea = $('[name=content]');
		var editor = UE.getEditor('content');
		var $form = $('#ue-form');

		$form.validator({
			submit: function() {
				// 同步编辑器数据
				editor.sync();

				var formValidity = this.isFormValid();

				// 表单验证未成功，而且未成功的第一个元素为 UEEditor 时，focus 编辑器
				if (!formValidity && $form.find('.' + this.options.inValidClass).eq(0).is($textArea)) {
					editor.focus();
				}

				console.warn('验证状态：', formValidity ? '通过' : '未通过');

				return false;
			}
		});

		// 编辑器内容变化时同步到 textarea
		editor.addListener('contentChange', function() {
			editor.sync();

			// 触发验证
			$('[name=content]').trigger('change');
		});
	});

	function submitDo() {
		setTimeout("ajaxDoResend()",10);
	}
	function ajaxDoResend(){
		if($("#form .am-field-error").size()!=0){
			return false;
		}
		var data = $("#ue-form").serialize();
		data = decodeURIComponent(data, true);
		$.ajax({
			url : "comment/resend",
			data : data,
			method : 'post',
			contentType : 'application/x-www-form-urlencoded',
			encoding : 'UTF-8',
			cache : false,
			success : function(result) {
				if (result.success) {
					layer.msg('评论成功');
					setTimeout("closeWindow()", 1000);
				} else {
					layer.msg('评论失败');
				}
			},
			error : function() {
				layer.msg('评论异常');
			}
		});
	}
	function apply() {
		setTimeout("ajaxDo()",10);
	}
	function ajaxDo(){
		$.ajax({
			url : "signs/apply",
			data : {
				title: '${entity.title }'
			},
			method : 'post',
			contentType : 'application/x-www-form-urlencoded',
			encoding : 'UTF-8',
			cache : false,
			success : function(result) {
				if (result.success) {
					layer.msg('报名成功');
					window.location.href = '<c:url value="/"/>';
				} else {
					layer.msg('还未登录');
					setTimeout(window.location.href = "list?categoryId=9",2000);
					<%--window.location.href = '<c:url value="/"/>';--%>
				}
			},
			error : function() {
				layer.msg('报名异常');
			}
		});
	}

</script>

