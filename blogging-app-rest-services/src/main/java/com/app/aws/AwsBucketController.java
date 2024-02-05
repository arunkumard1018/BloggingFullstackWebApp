package com.app.aws;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.service.AuthenticationService;
import com.app.util.ImageUrl;

@RestController
public class AwsBucketController {

	private AmzonClientService amzonClientService;
	private AuthenticationService authService;
	public AwsBucketController(AmzonClientService amzonClientService) {
		this.amzonClientService = amzonClientService;
	}

	@PostMapping("/upload/{id}/post-img")
	public ResponseEntity<ImageUrl> uploadFile(@RequestPart(value = "file") MultipartFile file, @PathVariable Long id) {
		if (authService.isAuthenticatedUser(id)) {
			String UploadedFileUrl = amzonClientService.upload(file);
			ImageUrl imageUrl = new ImageUrl(UploadedFileUrl);
			if (UploadedFileUrl != null) {
				return ResponseEntity.status(HttpStatus.ACCEPTED).body(imageUrl);
			}
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	}

	@PostMapping("/deleteFile")
	public String deleteFile(@RequestPart(value = "url") String fileUrl) {
		return this.amzonClientService.deleteFileFromS3Bucket(fileUrl);
	}
}
