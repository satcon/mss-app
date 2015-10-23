<!DOCTYPE HTML>
<script type="text/javascript" charset="utf-8">
		var dg_sysuser;
		$(function() {
			dg_sysuser = $('#dg_sysuser').datagrid({
				url : sys.basePath() + '/sys/user/findUsers',
				fit : true,
				fitColumns : false,
				striped : true,
				border : false,
				idField : 'userId',
				pagination : true,
				singleSelect : false,
				pageSize : 10,
				pageList : [ 10, 20, 50, 100 ],
				nowrap : false,
				columns : [ [ {
					field : 'userId',
					title : '主键',
					checkbox : true
				}, {
					field : 'userName',
					title : '用户名',
					width : 150
				}, {
					field : 'password',
					title : '密码',
					width : 150
				} , {
					field : 'createTime',
					title : '创建时间',
					width : 150
				}, {
					field : 'updateTime',
					title : '最后修改时间',
					width : 150
				} ] ],
				toolbar : [ {
					text : '增加',
					iconCls : 'icon-add',
					handler : function() {
						$('#sysuser_addForm input').val('');
						$('#sysusers_add_dialog').dialog('open');
					}
				}, '-', {
					text : '删除',
					iconCls : 'icon-remove',
					handler : function() {
						remove();
					}
				}, '-', {
					text : '修改',
					iconCls : 'icon-edit',
					handler : function() {
						editFunc();
					}
				}, '-' ],
				onLoadSuccess : function(data) {
				},
				onLoadError : function() {
					console.info('---->【加载失败！】');
				}
			}); // END datagrid

			//$('.datagrid-header div').css('textAlign', 'center');

		}); // END jQuery
		
		/* 查询 */
		function searchFunc() {
			dg_sysuser.datagrid('load', serializeObject($('#sysusers_queryform')));
		}
		/* 清空查询 */
		function clearFun() {
			$('#sysusers_queryform input').val('');
			dg_sysuser.datagrid('load', {});
		}
		
		/* 编辑用户信息  */
		function editFunc() {
			var rows = dg_sysuser.datagrid('getChecked');
			if(rows.length == 1) {
				var id = rows[0].userId;
				parent.$.modalDialog({
					title : '编辑用户',
					width : 500,
					height : 300,
					href : sys.basePath() + '/sys/user/editPage?userId=' + id,
					buttons : [ {
						iconCls : 'icon-save',
						text : '保存',
						handler : function() {
							parent.$.modalDialog.openner_dataGrid = dg_sysuser;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
							var f = parent.$.modalDialog.handler.find('#sysuser_editForm');
							f.submit();
						}
					} ],
					onLoad : function() {
						$('#sysuser_editForm').form('load', rows[0]);
					}
				});// Modal Dialog END
				
			} else {
				$.messager.show({
					title : '提示',
					msg : '请勾选要删除的记录！'
				});
			}
			
			
		}
		/* 删除 */
		function remove() {
			var rows = dg_sysuser.datagrid('getChecked');
			if (rows.length > 0) {
				parent.$.messager.confirm('确认','是否删除当前选中的项目？',function(r){
					if (r) {
						var ids = [];
						for (var i = 0, length = rows.length; i < length; i++) {
							ids.push(rows[i].userId);
						}

						$.ajax({
							url : sys.basePath() + '/sys/user/deleteUsers',
							method : 'post',
							dataType : 'json',
							data : {
								ids : ids.join(',')
							},
							success : function(r) {
								dg_sysuser.datagrid('load');
								dg_sysuser.datagrid('unselectAll');
								$.messager.show({
									title : '提示',
									msg : r.msg
								});
							}
						});// AJAX END
						
						ids = '';
					}// IF END
					
				});// CONFIRM END
				
			} else {
				$.messager.show({
					title : '提示',
					msg : '请勾选要删除的记录！'
				});
			}
		}
	</script>

<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'north',border:false" style="height:100px;">
       <div class="easyui-panel" data-options="title:'查询',fit:true,border:false">
           <div class="easyui-panel" data-options="fit:true,border:false" style="padding: 10px;">
              <form id="sysusers_queryform" method="post">
		                  用户名： <input name="userName" /> 
			   <a href="javascript:searchFunc();" class="easyui-linkbutton" iconCls='icon-search' plain="true">查询</a>
			   <a href="javascript:clearFun();" class="easyui-linkbutton" iconCls='icon-cancel' plain="true">清空</a>
		      </form>
	       </div>
		</div>
	</div> <!-- END  North Region -->

	<div data-options="region:'center'">
		<table id="dg_sysuser"></table>
	</div><!-- END CENTER -->
</div><!-- END LAYOUT -->

<div id="sysusers_add_dialog" class="easyui-dialog"
	data-options="closed:true,modal:true,title:'添加用户',
	  buttons:[{
				text : '确定',
				iconCls : 'icon-save',
				plain : 'true',
				handler : function() {
					$('#sysuser_addForm').form('submit', {
						url : sys.basePath()+'/sys/user/addUser',
						success : function(r) {
							var obj = jQuery.parseJSON(r);
							if (obj.success) {
								  $('#dg_sysuser').datagrid('insertRow',{
									index:0,
									row : obj.obj
								});
								$('#sysusers_add_dialog').dialog('close');
							}
							$.messager.show({
								title : '提示',
								msg : obj.msg
							});
						}
					});
				}
			}]"
	style="width: 500px; height: 200px; text-align: left;padding: 10px;" >
	<form id="sysuser_addForm" method="post">
		<table>
			<tr>
				<th>编号</th>
				<td><input name="id" readonly="readonly" /></td>
				<th>登录名称</th>
				<td><input name="userName" class="easyui-validatebox"
					data-options="required:true" /></td>
			</tr>
			<tr>
				<th>密码</th>
				<td><input name="password" type="password"
					class="easyui-validatebox" data-options="required:true" /></td>
				<th>创建时间</th>
				<td><input name="createdatetime" readonly="readonly" /></td>
			</tr>
			<tr>
				<th>最后修改时间</th>
				<td><input name="modifydatetime" readonly="readonly" /></td>
				<th></th>
				<td></td>
			</tr>
		</table>
	</form>
</div>
