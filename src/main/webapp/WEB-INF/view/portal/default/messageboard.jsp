<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8"%>
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
<br>
<%--<div class=" am-container">${article.content }</div>--%>
<div class=" am-container">
    <form action="" class="am-form" id="ue-form">
        <fieldset>
            <div class="am-form-group">
                <label for="title">标题：</label>
                <%--<input type="text" id="title" name="title"  placeholder="输入电话（11位）" required/>--%>
                <select class="form-control" id="title" name="title">
                    <option value="意见反馈">意见反馈</option>
                    <option value="界面不够美观">界面不够美观</option>
                    <option value="功能问题">功能问题</option>
                    <option value="我有想法">我有想法</option>
                    <option value="我要吐槽">我要吐槽</option>
                </select>
            </div>
            <div class="am-form-group">
                <label for="userName">用户名：</label>
                <input type="text" id="userName" name="userName" minlength="3" placeholder="输入用户名（至少 3 个字符）" required/>
            </div>
            <div class="am-form-group">
                <label for="phoneNumber">电话号码：</label>
                <input type="text" id="phoneNumber" name="phoneNumber" length="11" placeholder="输入电话（11位）" required/>
            </div>
            <div class="am-form-group">
                <label for="content">评论：</label>
                <textarea class="am-validate" id="content" name="content"  required></textarea>
            </div>

            <button class="am-btn am-btn-secondary" type="submit" onclick="submitDo();">提交</button>
        </fieldset>
    </form>
</div>

<hr>
<div data-am-widget="gotop" class="am-gotop am-gotop-fixed" >
    <a href="#top" title="">
        <i class="am-gotop-icon am-icon-hand-o-up"></i>
    </a>
</div>
<%@ include file="/WEB-INF/view/portal/default/footer.jsp"%>
<script src="<c:url value="/static/plugin/ueditor/ueditor.config.js"/>"></script>
<script src="<c:url value="/static/plugin/ueditor/ueditor.all.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/js/app.js"/>"></script>
<script type="text/javascript"
        src="<c:url value="/static/js/layer/layer.js"/>"></script>
<script type="text/javascript">
    $(function() {
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
        setTimeout("ajaxDo()",10);
    }
    function ajaxDo(){
        if($("#form .am-field-error").size()!=0){
            return false;
        }
        var data = $("#ue-form").serialize();
        data = decodeURIComponent(data, true);
        $.ajax({
            url : "message/edit",
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