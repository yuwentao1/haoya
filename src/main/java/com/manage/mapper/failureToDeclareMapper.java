package com.manage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.manage.pojo.FailureToDeclare;
/***
 * ����mapper��
 * @author 
 *
 */
public interface failureToDeclareMapper {
	/***
	 * 
	 * @param fai ����ʵ����
	 * @return �Ƿ���ӳɹ�
	 */
	public int faiadd(@Param("fai")FailureToDeclare fai);
	

	/**
	 * �������޸�
	 * @param ���������
	 * @return ���
	 */
	public int fialureUpdate(FailureToDeclare fial);
	
	/**
	 * ��������ѯ�걨id
	 * @param �豸id
	 * @return �����걨����
	 */
	public List<FailureToDeclare> fialureJquery(@Param("equipment_id")String equipment_id);
}
