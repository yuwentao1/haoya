package com.manage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.manage.pojo.Asset;

public interface AssetMapper {
	public List<Asset> selectlist(@Param("page") int page, @Param("limit") int limit,
			@Param("equipment_name") String equipment_name);

	public Asset select(@Param("id") String id);
	
	public int count(@Param("equipment_name")String equipment_name);
}
