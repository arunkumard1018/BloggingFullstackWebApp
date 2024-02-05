package com.app.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class FileConverter {
	public static File convertMultipartFileToFile(MultipartFile file) {
		File convertedFile = new File(file.getOriginalFilename());
		try {
		    FileOutputStream fos = new FileOutputStream(convertedFile);
		    fos.write(file.getBytes());
		    fos.close();

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return convertedFile;
	}
}
