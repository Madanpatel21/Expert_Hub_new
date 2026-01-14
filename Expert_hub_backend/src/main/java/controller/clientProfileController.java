package controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import Repository.clientProfileRepository;
import dto.apiResponse;
import dto.clientProfileRequest;
import entity.clientProfile;
import exception.badRequestException;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import service.clientProfileService;
import service.profileImageService;

@RestController
@RequestMapping("/api/client/profile")
public class clientProfileController {
	private final clientProfileService ClientProfileService;
	private final profileImageService ProfileImageService;
	
	public clientProfileController(clientProfileService ClientProfileService,
		    profileImageService ProfileImageService) {
		this.ClientProfileService = ClientProfileService;
		this.ProfileImageService = ProfileImageService;
	}

	@PostMapping("/{userId}")
	public apiResponse<String> createProfile(@PathVariable Long userId, @RequestBody clientProfileRequest request)
	{
		ClientProfileService.createProfile(userId, request);
        return new apiResponse<>("Client profile created",true, null);
	}

	@PostMapping("/{profileId}/upload-image")
	public apiResponse<String> uploadProfileImage(
		@PathVariable Long profileId, @RequestParam("image") MultipartFile image){
		
		String file=ProfileImageService.saveProfileImage(image);
		ClientProfileService.updateProfileImage(profileId, file);
		
		return 	new apiResponse<>("Profile Image Uploaded",true,file);
	}
}
