package com.manage.tool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jbpm.api.ProcessEngine;
import org.jbpm.api.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/***
 * 工作流工具类
 * @author 禹文涛
 *
 */
@Component
public class FlowTools {
	@Autowired
	private ProcessEngine pro;
	
	/**
	 * 部署流程
	 */
	public void processDeployment() {
		pro.getRepositoryService().createDeployment().addResourceFromClasspath("img/management.jpdl.xml").deploy();
	}
	
	/***
	 * 流程实例
	 * @param equipment_id 故障设备id
	 * @param id 人
	 */
	public void startDeployment(String equipment_id,String id) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("equipment_id", equipment_id);
		map.put("id", id);
		pro.getExecutionService().startProcessInstanceByKey("management",map);
	}
	
	/**
	 * 
	 * @param aply 人
	 * @param equipment 故障设备id
	 */
	public void submissionProcess(String aply,String equipment) {
		List<Task> taskList = pro.getTaskService().findPersonalTasks(aply); 
		System.out.println("============= 【" + aply + "】的个人任务列表 ============");	
		for (Task task : taskList) {				
			System.out.println("id=" + task.getId()+ ", name=" + task.getName()	+ ", assignee=" + task.getAssignee()); // 办理人
			 String executionId=pro.getTaskService().getTask(task.getId()).getExecutionId();
			 String equipment_id= (String) pro.getExecutionService().getVariable(executionId, "equipment_id");
			 //设备ID 和 数据库存储的设备ID匹配
			 if(equipment_id.equals(equipment)) {
				 pro.getTaskService().completeTask(task.getId());
			 }
		}
	}
}
