package service;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Repository.roleRepository;
import Repository.userRepository;
import dto.loginRequest;
import dto.otpVerifyRequest;
import dto.registerRequest;
import entity.role;
import entity.user;
import exception.badRequestException;

@Service
public class authService {
	@Autowired
	private final userRepository userRepo;
	@Autowired
	private final roleRepository roleRepo;
	
	private String generateOtp() {
	    return String.valueOf(100000 + new Random().nextInt(900000));
	}
	
	public authService(userRepository userRepo, roleRepository roleRepo) {
		this.userRepo=userRepo;
		this.roleRepo=roleRepo;
	}
	//Register
	public void register(registerRequest request) {
		if(userRepo.existsByEmail(request.getEmail())){
			throw new badRequestException("Email Already Registered");
		}
		
		role Role=roleRepo.findByName(request.getRole()).orElseThrow(()-> new badRequestException("Invalid Role"));
	user User= new user();
	User.setEmail(request.getEmail());
	User.setPassword(request.getPassword());
	User.setRole(Role);
	
	userRepo.save(User);
	
	}
	// Login
	public void login(loginRequest request){
		user User=userRepo.findByEmail(request.getEmail()).orElseThrow(()-> new badRequestException("User Doesn't Exists"));
		if(!User.getPassword().equals(request.getPassword())) {
			throw new badRequestException("Invalid Password");
		}
		String otp=generateOtp();
		User.setOtp(otp);
		User.setOtpExpiry(LocalDateTime.now().plusMinutes(5));
		
		userRepo.save(User);
		System.out.println("Login OTP : "+ otp);
		
	}
	public void verifyOtp(otpVerifyRequest request) {
		user User= userRepo.findByEmail(request.getEmail()).
				orElseThrow(()-> new badRequestException("User not found"));
	if(User.getOtp()==null|| User.getOtpExpiry()==null ||!User.getOtp().equals(request.getOtp()) 
			|| User.getOtpExpiry().isBefore(LocalDateTime.now())) {
		throw new badRequestException("Invalid or Expired OTP ");
		}
	 User.setOtp(null);
	 User.setOtpExpiry(null);
	 userRepo.save(User);
	
	}
}
