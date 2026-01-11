package controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.apiResponse;
import dto.clientProfileRequest;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import service.clientProfileService;

@RestController
@RequestMapping("/api/client/profile")
public class clientProfileController {
	private final clientProfileService ClientProfileService;
	
	public clientProfileController(clientProfileService ClientProfileService) {
		this.ClientProfileService=ClientProfileService;
	}
	@PostMapping("/{userId}")
	public apiResponse<String> createProfile(@PathVariable Long userId, @RequestBody clientProfileRequest request)
	{
		ClientProfileService.createProfile(userId, request);
        return new apiResponse<>("Client profile created",true, null);
	}
	
}
