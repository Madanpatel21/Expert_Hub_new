package service;

import org.springframework.stereotype.Service;

import Repository.clientProfileRepository;
import Repository.userRepository;
import dto.clientProfileRequest;
import entity.clientProfile;
import entity.user;
import exception.badRequestException;

@Service
public class clientProfileService {
	 private final clientProfileRepository ClientProfileRepository;
	 private final userRepository UserRepository;
	 public clientProfileService(clientProfileRepository ClientProfileRepository,
             userRepository UserRepository) {
		this.ClientProfileRepository = ClientProfileRepository;
		this.UserRepository = UserRepository;
	 }
	 public void createProfile(Long userId, clientProfileRequest request) {
		 user User= UserRepository.findById(userId).orElseThrow(()-> new badRequestException("User not found"));
		 clientProfile profile = new clientProfile();
	        profile.setFullName(request.getFullName());
	        profile.setPhone(request.getPhone());
	        profile.setCity(request.getCity());
	        profile.setUser(User);

	        ClientProfileRepository.save(profile);
	 }
}
