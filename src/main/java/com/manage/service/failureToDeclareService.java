package com.manage.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.manage.pojo.FailureToDeclare;
/***
 * ����Service��
 * @author 
 *
 */
public interface failureToDeclareService {

	/***
	 * 
	 * @param fai ����ʵ����
	 * @return �Ƿ���ӳɹ�
	 */
	public int faiadd(FailureToDeclare fai);
	
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
