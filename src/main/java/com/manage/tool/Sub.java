package com.manage.tool;

import java.util.List;

import com.manage.pojo.Accessory;

public class Sub {
	public static String substring(List<Accessory> list) {
		int id[] = new int[list.size()];
		int tid=0;
		for (int i = 0; i < list.size(); i++) {
			String filesuffix = list.get(i).getId().substring(list.get(i).getId().lastIndexOf("J")+1);
			id[i]=Integer.parseInt(filesuffix);
		}
		for (int i = 0; i < id.length; i++) {
			if(i+1==id.length) {
				break;
			}
			if(id[i]<id[i+1]) {
				id[i]=id[i+1];
				tid=id[i];
			}
		}
		return "FJ"+tid;
	} 
}
