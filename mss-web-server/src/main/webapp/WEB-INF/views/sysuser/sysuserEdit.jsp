<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
$(function(){
	parent.$.messager.progress('close');
	$('#sysuser_editForm').form({
		url : sys.basePath() + '/sys/user/editUser',
		onSubmit : function() {
			parent.$.messager.progress({
				title : '提示',
				text : '数据处理中，请稍后....'
			});
			var isValid = $(this).form('validate');
			if (!isValid) {
				parent.$.messager.progress('close');
			}
			return isValid;
		},
		success : function(result) {
			parent.$.messager.progress('close');
			result = $.parseJSON(result);
			if (result.success) {
				parent.$.modalDialog.openner_dataGrid.datagrid('reload');//之所以能在这里调用到parent.$.modalDialog.openner_dataGrid这个对象，是因为user.jsp页面预定义好了
				parent.$.modalDialog.handler.dialog('close');
			} else {
				parent.$.messager.alert('错误', result.msg, 'error');
			}
		}
	});
});
</script>
<form id="sysuser_editForm" method="post">
	<table>
		<tr>
			<th>编号</th>
			<td><input name="userId" value="${sysuser.userId}" readonly="readonly" /></td>
			<th>登录名称</th>
			<td><input name="userName" value="${sysuser.userName}" class="easyui-validatebox" data-options="required:true" /></td>
		</tr>
		<tr>
			<th>密码</th>
			<td><input name="password" value="${sysuser.password}" type="password" class="easyui-validatebox" data-options="required:true" /></td>
			<th>创建时间</th>
			<td><input name="createTime" value="${sysuser.createTime}" readonly="readonly" /></td>
		</tr>
		<tr>
			<th>最后修改时间</th>
			<td><input name="updateTime" value="${sysuser.updateTime}" readonly="readonly" /></td>
			<th></th>
			<td></td>
		</tr>
	</table>
</form>