package com.manage.tool;

public class Flie {
	
	public static String fileName(String fileip) {
        String filesuffix = fileip.substring(fileip.lastIndexOf(".")+1);
        System.out.println(filesuffix);
        if (filesuffix.toUpperCase().equals("PNG") || 
        		filesuffix.toUpperCase().equals("JPG") || 
        		filesuffix.toUpperCase().equals("GIF") || 
        		filesuffix.toUpperCase().equals("TIF") ||
        		filesuffix.toUpperCase().equals("BMP")) {
			return "ͼƬ��ʽ";
		}else {
			return "��Ƶ��ʽ";
		}
	}
}
