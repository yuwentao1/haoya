package com.manage.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.manage.pojo.Accessory;
import com.manage.pojo.Asset;
import com.manage.service.AccessoryService;
import com.manage.service.AssetService;
import com.manage.tool.FileUpload;


@Controller
public class AssetController {
@Autowired
private AssetService service; 
	@ResponseBody
	@RequestMapping("/select")
	public Map<String, Object> list(HttpServletResponse resp,int page,int limit ,String equipment_name){
		page=(page-1)*limit;
		System.out.println("asd");
		resp.setHeader("Access-Control-Allow-Origin", "*");
		Map<String, Object> map=new HashMap<String, Object>();
		List<Asset> list=service.selectlist(page, limit, equipment_name);
		int count= service.count(equipment_name);
		map.put("list", list);
		map.put("page", page);
		map.put("count", count);
		return map;
	}
	@ResponseBody
	@RequestMapping("/selectinfoid")
	public Asset obg(HttpServletResponse resp,String id){
		resp.setHeader("Access-Control-Allow-Origin", "*");
		System.out.println(id);
		Asset obgl=service.select(id);
		return obgl;
	}
	
}
