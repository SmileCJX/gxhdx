<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8"%>
<div class="am-u-sm-12">
	<form class="am-form">
		<table class="am-table am-table-striped am-table-hover table-main">
			<thead>
				<tr>
					<th class="table-check"><input type="checkbox" id="checkAll" onclick="selectAll();" /></th>
											<th class="table-date am-hide-sm-only">活动标题</th>
						<th class="table-date am-hide-sm-only">活动内容</th>
						<th class="table-date am-hide-sm-only">活动开始日期</th>
						<th class="table-date am-hide-sm-only">活动结束日期</th>
						<th class="table-date am-hide-sm-only">活动报名开始日期</th>
						<th class="table-date am-hide-sm-only">活动报名结束日期</th>
						<th class="table-date am-hide-sm-only">活动关键字</th>
						<th class="table-date am-hide-sm-only">活动相关连接</th>
						<th class="table-date am-hide-sm-only">活动主办部门</th>
						<th class="table-date am-hide-sm-only">活动承办人员</th>
						<th class="table-date am-hide-sm-only">活动承办人联系电话</th>
						<th class="table-date am-hide-sm-only">浏览数</th>
						<th class="table-date am-hide-sm-only">活动类型</th>
						<th class="table-date am-hide-sm-only">活动备注</th>
					<th class="table-set">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list.items }" var="item">
					<tr>
						<td><input type="checkbox" name="checkitem" onclick="selectItem(this);" id="check${item.id }" value="${item.id }"/></td>
							<td>${item.title}</td>
							<td>${item.content}</td>
							<td>${item.activityStartDate}</td>
							<td>${item.activityEndDate}</td>
							<td>${item.applyStartDate}</td>
							<td>${item.applyEndDate}</td>
							<td>${item.keyword}</td>
							<td>${item.url}</td>
							<td>${item.depatement}</td>
							<td>${item.sponsor}</td>
							<td>${item.sponsorPhone}</td>
							<td>${item.hits}</td>
							<td>${item.type}</td>
							<td>${item.remark}</td>
						<td>
							<div class="am-btn-toolbar">
								<div class="am-btn-group am-btn-group-xs">
									<button type="button" class="am-btn am-btn-default am-text-secondary"
										onclick="openWindow('activity/edit?id=${item.id}','编辑');">
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
