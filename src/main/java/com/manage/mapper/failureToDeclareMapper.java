package com.manage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.manage.pojo.FailureToDeclare;
/***
 * 故障mapper层
 * @author 
 *
 */
public interface failureToDeclareMapper {
	/***
	 * 
	 * @param fai 故障实体类
	 * @return 是否添加成功
	 */
	public int faiadd(@Param("fai")FailureToDeclare fai);
	

	/**
	 * 工作流修改
	 * @param 故障申请表
	 * @return 结果
	 */
	public int fialureUpdate(FailureToDeclare fial);
	
	/**
	 * 工作流查询申报id
	 * @param 设备id
	 * @return 故障申报集合
	 */
	public List<FailureToDeclare> fialureJquery(@Param("equipment_id")String equipment_id);
}
