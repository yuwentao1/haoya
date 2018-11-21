package com.manage.tool;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

public class FileUpload {
	public static String Fileupload(String path,MultipartFile file) throws IOException{
		InputStream stream = file.getInputStream();
		FileOutputStream fs = new FileOutputStream(path + file.getOriginalFilename());
		byte[] buffer = new byte[1024 * 1024];
		int bytesum = 0;
		int byteread = 0;

		while ((byteread = stream.read(buffer)) != -1) {
			bytesum += byteread;
			fs.write(buffer, 0, byteread);
		}
		fs.flush();
		fs.close();
		stream.close();
		return path+file.getOriginalFilename();
	}
}
