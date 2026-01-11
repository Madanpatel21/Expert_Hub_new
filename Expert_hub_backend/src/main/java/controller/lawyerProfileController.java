package controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.apiResponse;
import dto.lawyerProfileRequest;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import service.lawyerProifileService;

@RestController
@RequestMapping("/api/lawyer/profile")
public class lawyerProfileController {
  private final lawyerProifileService LawyerProfileService;
  
  public lawyerProfileController(lawyerProifileService LawyerProfileService) {
	  this.LawyerProfileService=LawyerProfileService;
  }
  @PostMapping("/{userId}")
  public apiResponse<String> createProfile(@PathVariable Long userId, @RequestBody lawyerProfileRequest request){
	  LawyerProfileService.createProfile(userId, request);
	  
	  return new apiResponse<>("Lawyer profile created",true,null);
  }
}
