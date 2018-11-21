package com.manage.tool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jbpm.api.ProcessEngine;
import org.jbpm.api.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/***
 * ������������
 * @author ������
 *
 */
@Component
public class FlowTools {
	@Autowired
	private ProcessEngine pro;
	
	/**
	 * ��������
	 */
	public void processDeployment() {
		pro.getRepositoryService().createDeployment().addResourceFromClasspath("img/management.jpdl.xml").deploy();
	}
	
	/***
	 * ����ʵ��
	 * @param equipment_id �����豸id
	 * @param id ��
	 */
	public void startDeployment(String equipment_id,String id) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("equipment_id", equipment_id);
		map.put("id", id);
		pro.getExecutionService().startProcessInstanceByKey("management",map);
	}
	
	/**
	 * 
	 * @param aply ��
	 * @param equipment �����豸id
	 */
	public void submissionProcess(String aply,String equipment) {
		List<Task> taskList = pro.getTaskService().findPersonalTasks(aply); 
		System.out.println("============= ��" + aply + "���ĸ��������б� ============");	
		for (Task task : taskList) {				
			System.out.println("id=" + task.getId()+ ", name=" + task.getName()	+ ", assignee=" + task.getAssignee()); // ������
			 String executionId=pro.getTaskService().getTask(task.getId()).getExecutionId();
			 String equipment_id= (String) pro.getExecutionService().getVariable(executionId, "equipment_id");
			 //�豸ID �� ���ݿ�洢���豸IDƥ��
			 if(equipment_id.equals(equipment)) {
				 pro.getTaskService().completeTask(task.getId());
			 }
		}
	}
}
