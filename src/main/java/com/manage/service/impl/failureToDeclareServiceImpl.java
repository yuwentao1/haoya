package com.manage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manage.mapper.failureToDeclareMapper;
import com.manage.pojo.FailureToDeclare;
import com.manage.service.failureToDeclareService;
@Service
public class failureToDeclareServiceImpl implements failureToDeclareService{

	@Autowired
	private failureToDeclareMapper mapper;

	public int faiadd(FailureToDeclare fai) {
		
		return mapper.faiadd(fai);
	}

	public int fialureUpdate(FailureToDeclare fial) {
		
		return mapper.fialureUpdate(fial);
	} 

	public List<FailureToDeclare> fialureJquery(String equipment_id) {
		
		return mapper.fialureJquery(equipment_id);
	}
}
