<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8"%>
<div class="am-u-sm-12">
	<form class="am-form">
		<table class="am-table am-table-striped am-table-hover table-main">
			<thead>
				<tr>
					<th class="table-check"><input type="checkbox" id="checkAll" onclick="selectAll();" /></th>
											<th class="table-date am-hide-sm-only">教师姓名</th>
						<th class="table-date am-hide-sm-only">教师编号</th>
						<th class="table-date am-hide-sm-only">学院</th>
						<th class="table-date am-hide-sm-only">职称</th>
						<th class="table-date am-hide-sm-only">研究方向</th>
						<th class="table-date am-hide-sm-only">荣誉</th>
						<th class="table-date am-hide-sm-only">学历</th>
						<th class="table-date am-hide-sm-only">邮箱</th>
						<th class="table-date am-hide-sm-only">角色</th>
						<th class="table-date am-hide-sm-only">介绍</th>
					<th class="table-set">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list.items }" var="item">
					<tr>
						<td><input type="checkbox" name="checkitem" onclick="selectItem(this);" id="check${item.id }" value="${item.id }"/></td>
							<td>${item.teacherName}</td>
							<td>${item.tno}</td>
							<td>${item.academy}</td>
							<td>${item.rank}</td>
							<td>${item.research}</td>
							<td>${item.honer}</td>
							<td>${item.education}</td>
							<td>${item.email}</td>
							<td>${item.role}</td>
							<td>${item.introduction}</td>
						<td>
							<div class="am-btn-toolbar">
								<div class="am-btn-group am-btn-group-xs">
									<button type="button" class="am-btn am-btn-default am-text-secondary"
										onclick="openWindow('teacher/edit?id=${item.id}','编辑');">
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
