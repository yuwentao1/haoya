package com.manage.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.manage.pojo.Asset;

public interface AssetService {
		public List<Asset> selectlist(int page,int limit,String equipment_name);
		public Asset select(String id);
		public int count(String equipment_name);
}
