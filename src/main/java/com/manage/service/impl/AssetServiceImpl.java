package com.manage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manage.mapper.AssetMapper;
import com.manage.pojo.Asset;
import com.manage.service.AssetService;

@Service
public class AssetServiceImpl implements AssetService {
	@Autowired
	private AssetMapper mapper;

	public List<Asset> selectlist(int page, int limit, String equipment_name) {
		// TODO Auto-generated method stub
		
		return mapper.selectlist(page, limit, equipment_name);
	}

	public Asset select(String id) {
		// TODO Auto-generated method stub
		return mapper.select(id);
	}

	public int count(String equipment_name) {
		// TODO Auto-generated method stub
		return mapper.count(equipment_name);
	}
	
	
	
}
