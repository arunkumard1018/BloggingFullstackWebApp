package com.app.aws;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.app.util.FileConverter;

@Service
public class AmzonClientService {

	private final AmazonS3 s3client;
	
	@Value("${aws.bucketName}")
	private String bucketName;
	@Value("${aws.endpointUrl}")
	private String endpointUrl;
	
	
	public AmzonClientService(AmazonS3 s3client) {
		this.s3client = s3client;
	}

	public String upload(MultipartFile file) {
		String fileUrl = null;
		try {
			File localFile = FileConverter.convertMultipartFileToFile(file);
			String fileName = generateFileName(file);
			fileUrl = endpointUrl + "/" + bucketName + "/" + fileName;
			s3client.putObject(new PutObjectRequest(bucketName, fileName, localFile)
					.withCannedAcl(CannedAccessControlList.PublicRead));
			localFile.delete();
		}catch (Exception e) {
			return null;
		}
		return fileUrl;
	}

	private String generateFileName(MultipartFile multiPart) {
		return new Date().getTime() + "-" + multiPart.getOriginalFilename().replace(" ", "_");
	}

	public String deleteFileFromS3Bucket(String fileUrl) {
		String fileName = fileUrl.substring(fileUrl.lastIndexOf("/") + 1);
		s3client.deleteObject(new DeleteObjectRequest(bucketName, fileName));
		return "deleted : " + fileName;
	}

	public String uploadBlogPostImage(MultipartFile file, Long id) {
		bucketName = bucketName+"/"+id+"/post-images";
		return upload(file);
	}

}
