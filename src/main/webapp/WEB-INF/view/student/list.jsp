<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8"%>
<div class="am-u-sm-12">
	<form class="am-form">
		<table class="am-table am-table-striped am-table-hover table-main">
			<thead>
				<tr>
					<th class="table-check"><input type="checkbox" id="checkAll" onclick="selectAll();" /></th>
											<th class="table-date am-hide-sm-only">学生姓名</th>
						<th class="table-date am-hide-sm-only">学号</th>
						<th class="table-date am-hide-sm-only">年级</th>
						<th class="table-date am-hide-sm-only">学院</th>
						<th class="table-date am-hide-sm-only">专业</th>
						<th class="table-date am-hide-sm-only">班级</th>
						<th class="table-date am-hide-sm-only">电话</th>
						<th class="table-date am-hide-sm-only">邮箱</th>
						<th class="table-date am-hide-sm-only">角色</th>
					<th class="table-set">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list.items }" var="item">
					<tr>
						<td><input type="checkbox" name="checkitem" onclick="selectItem(this);" id="check${item.id }" value="${item.id }"/></td>
							<td>${item.studentName}</td>
							<td>${item.sno}</td>
							<td>${item.grade}</td>
							<td>${item.academy}</td>
							<td>${item.profession}</td>
							<td>${item.classes}</td>
							<td>${item.phone}</td>
							<td>${item.email}</td>
							<td>${item.role}</td>
						<td>
							<div class="am-btn-toolbar">
								<div class="am-btn-group am-btn-group-xs">
									<button type="button" class="am-btn am-btn-default am-text-secondary"
										onclick="openWindow('student/edit?id=${item.id}','编辑');">
										<span class="am-icon-pencil-square-o"></span> 编辑
									</button>
									<button type="button" class="am-btn am-btn-default am-text-danger"
									    onclick="del('${item.id}')">
										<span class="am-icon-trash-o"></span> 删除
									</button>
								</div>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		${list.pageStr }
		<hr />
		<p>注：.....</p>
	</form>
</div>
