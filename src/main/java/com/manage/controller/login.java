package com.manage.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.jbpm.api.ProcessEngine;
import org.jbpm.api.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.manage.pojo.Accessory;
import com.manage.pojo.FailureToDeclare;
import com.manage.service.AccessoryService;
import com.manage.service.failureToDeclareService;
import com.manage.tool.FileUpload;
import com.manage.tool.Flie;
import com.manage.tool.Sub;

@Controller
public class login {
	@Autowired
	private ProcessEngine pro;
	@Autowired
	private failureToDeclareService ser;
	@Autowired
	private AccessoryService ass;

	/***
	 * 申报
	 * 
	 * @param equipment_id
	 *            故障设备id
	 * @throws IOException
	 */
	@RequestMapping("/declare")
	@ResponseBody
	public String declare(FailureToDeclare faile, String accessory_memo, HttpServletResponse resp,
			HttpServletRequest req) throws IOException {
		int sum=0;
		req.setCharacterEncoding("UTF-8");
		resp.setHeader("Access-Control-Allow-Origin", "*");
		System.out.println("asd");
		// 获取文件格式
		MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) req;
		Iterator iter = multiRequest.getFileNames();
		String num = "";
		while (iter.hasNext()) {
			sum++;
			// 一次遍历所有文件
			MultipartFile file = multiRequest.getFile(iter.next().toString());
			String path = req.getSession().getServletContext().getRealPath("/") + "upload\\";
			FileUpload.Fileupload(path, file);
			if (file != null) {
				// 重新命名名字
				String name = file.getOriginalFilename();
				num += name + ",";
				// 添加图片
				String path2 = FileUpload.Fileupload(path, file);
			}
		}
		if(sum>0) {
			// 添加附件表
			int count1 = ass.addAccessory(faile.getEquipment_id(), "图片格式", "故障附件", num, "");
			List<Accessory> list = ass.selectaccessorytid(faile.getEquipment_id());
			String t_id = Sub.substring(list);
			System.out.println(t_id);
			// 查询附加id
			Accessory access = ass.selectid(t_id);
			System.out.println(access.getId());
			faile.setProblem_accessory(access.getId());
		}else {
			faile.setProblem_accessory("");
		}
		
		// 流程实例
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("equipment_id", faile.getEquipment_id());
		map.put("id", faile.getProcess_manid());
		pro.getExecutionService().startProcessInstanceByKey("management", map);
		//添加
		int count = ser.faiadd(faile);
		if (count > 0) {
			return "y";
		} else {
			return "n";
		}
	}

	/***
	 * 派工
	 * 
	 * @param faile
	 *            故障实体类
	 * @return 结果
	 */
	@RequestMapping("/malfunctionModification")
	@ResponseBody
	public String malfunctionModification(FailureToDeclare faile, HttpServletResponse resp) {
		resp.setHeader("Access-Control-Allow-Origin", "*");
		List<FailureToDeclare> list = ser.fialureJquery(faile.getEquipment_id());
		FailureToDeclare fa = null;
		for (FailureToDeclare failureToDeclare : list) {
			if (failureToDeclare.getProcess_status() != 5 && failureToDeclare.getProcess_status() == 1) {
				fa = failureToDeclare;
			}
		}
		faile.setProcess_id(fa.getProcess_id());
		List<Task> taskList = pro.getTaskService().findPersonalTasks("申报");
		System.out.println(taskList.size());
		for (Task task : taskList) {
			System.out.println("id=" + task.getId() + ", name=" + task.getName() + ", assignee=" + task.getAssignee()); // 办理人
			String executionId = pro.getTaskService().getTask(task.getId()).getExecutionId();
			String equipment_id = (String) pro.getExecutionService().getVariable(executionId, "equipment_id");
			System.out.println("asd");
			System.out.println(equipment_id);
			// 设备ID 和 数据库存储的设备ID匹配
			if (equipment_id.equals(faile.getEquipment_id())) {
				System.out.println("asd");
				pro.getTaskService().completeTask(task.getId());
			}
		}
		faile.setProcess_status(2);
		int count = ser.fialureUpdate(faile);
		if (count > 0) {
			return "y";
		} else {
			return "n";
		}
	}

	/***
	 * 维修
	 * 
	 * @param faile
	 * @param file
	 * @param accessory_memo
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/repair")
	@ResponseBody
	public String maintenanceInstructions(FailureToDeclare faile,
			HttpServletResponse resp,HttpServletRequest req) throws IOException {
		resp.setHeader("Access-Control-Allow-Origin", "*");
		System.out.println("asd");
		MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) req;
		Iterator iter = multiRequest.getFileNames();
		String num = "";
		int sum=0;
		while (iter.hasNext()) {
			sum++;
			// 一次遍历所有文件
			MultipartFile file = multiRequest.getFile(iter.next().toString());
			String path = req.getSession().getServletContext().getRealPath("/") + "upload\\";
			FileUpload.Fileupload(path, file);
			if (file != null) {
				// 重新命名名字
				String name = file.getOriginalFilename();
				num += name + ",";
				// 添加图片
				String path2 = FileUpload.Fileupload(path, file);
			}
		}
		if(sum>0) {
			// 添加附件表
			int count1 = ass.addAccessory(faile.getEquipment_id(), "图片格式", "维修附件", num, "");
			List<Accessory> list = ass.selectaccessorytid(faile.getEquipment_id());
			String t_id = Sub.substring(list);
			System.out.println(t_id);
			// 查询附加id
			Accessory access = ass.selectid(t_id);
			System.out.println(access.getId());
			faile.setProblem_accessory(access.getId());
		}else {
			faile.setProblem_accessory("");
		}
		List<FailureToDeclare> list = ser.fialureJquery(faile.getEquipment_id());
		FailureToDeclare fa = null;
		for (FailureToDeclare failureToDeclare : list) {
			if (failureToDeclare.getProcess_status() != 5 && failureToDeclare.getProcess_status() == 2) {
				fa = failureToDeclare;
			}
		}
		faile.setProcess_id(fa.getProcess_id());
		List<Task> taskList = pro.getTaskService().findPersonalTasks("派工");
		System.out.println(taskList.size());
		for (Task task : taskList) {
			System.out.println("id=" + task.getId() + ", name=" + task.getName() + ", assignee=" + task.getAssignee()); // 办理人
			String executionId = pro.getTaskService().getTask(task.getId()).getExecutionId();
			String equipment_id = (String) pro.getExecutionService().getVariable(executionId, "equipment_id");
			System.out.println("asd");
			System.out.println(equipment_id);
			// 设备ID 和 数据库存储的设备ID匹配
			if (equipment_id.equals(faile.getEquipment_id())) {
				System.out.println("asd");
				pro.getTaskService().completeTask(task.getId());
			}
		}
		faile.setProcess_status(3);
		int count = ser.fialureUpdate(faile);
		if (count > 0) {
			return "y";
		} else {
			return "n";
		}
	}

	@RequestMapping("/file")
	@ResponseBody
	public String flie(MultipartFile file, HttpServletRequest request) {
		System.out.println(this.getClass().getClassLoader().getResource(""));
		String filename = file.getOriginalFilename();
		String path = request.getContextPath() + "/img";
		File filepath = new File(path, filename);
		System.out.println(filename);
		if (!filepath.exists()) {
			filepath.mkdirs();
			System.out.println("asd");
		}
		// 将上传文件保存到一个目标文件当中
		try {
			return "y";
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "n";
	}

}
