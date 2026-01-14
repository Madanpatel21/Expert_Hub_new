package controller;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.apiResponse;
import dto.loginRequest;
import dto.otpVerifyRequest;
import dto.registerRequest;
import service.authService;

@RestController
@RequestMapping("/api/auth")
public class authController {
   private final authService Authservice;
   
   public authController(authService AuthService) {
	   this.Authservice=AuthService;
   }
   @PostMapping("/register")
   public apiResponse<String> register(@RequestBody registerRequest request) {
	   Authservice.register(request);
	   return new apiResponse<String>("User registered successfully",true,null);
   }
   @PostMapping("/login")
   public apiResponse<String> login(@RequestBody loginRequest request) {
	   Authservice.login(request);
	   return new apiResponse<String>("Login Successfully",true,null);
   }
   @PostMapping("/verify-otp")
   public apiResponse<String> verifyOtp(@RequestBody otpVerifyRequest request){
	   Authservice.verifyOtp(request);
	   return new apiResponse<>("Login Successful",true,null);
   }
}
