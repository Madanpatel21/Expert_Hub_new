package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import Repository.roleRepository;
import Repository.userRepository;
import dto.loginRequest;
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
	
	}
}
