package service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class profileImageService {
	@Value("${file.upload-dir}")
    private String uploadDir;
	
	public String saveProfileImage(MultipartFile file) {
		if(file.isEmpty() || file ==null) {
			throw new RuntimeException("File is empty");
		}
		try {
			File dir=new File(uploadDir);
			if(!dir.exists()) {
				dir.mkdirs();
			}
			String filename=UUID.randomUUID() + "_"+file.getOriginalFilename();
			File destination=new File(dir,filename);
			file.transferTo(destination);
			 return filename;
		 }catch(IOException e) {
			 e.printStackTrace();
			 throw new RuntimeException("Failed to Upload");
		 }
	}
}
