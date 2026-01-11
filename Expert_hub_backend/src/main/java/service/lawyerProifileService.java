package service;

import org.springframework.stereotype.Service;

import Repository.lawyerProfileRepository;
import Repository.userRepository;
import dto.lawyerProfileRequest;
import entity.lawyerProfile;
import entity.user;
import exception.badRequestException;

@Service
public class lawyerProifileService {
	private final lawyerProfileRepository LawyerProfileRepository;
    private final userRepository UserRepository;

    public lawyerProifileService(lawyerProfileRepository LawyerProfileRepository, userRepository UserRepository) {
    		this.LawyerProfileRepository=LawyerProfileRepository;
    		this.UserRepository=UserRepository;
    }

    public void createProfile(Long userId, lawyerProfileRequest request) {

        user User = UserRepository.findById(userId)
                .orElseThrow(() -> new badRequestException("User not found"));

        lawyerProfile profile = new lawyerProfile();
        profile.setFullName(request.getFullName());
        profile.setBarCouncilNumber(request.getBarCouncilNumber());
        profile.setYearsOfExperience(request.getYearsOfExperience());
        profile.setPracticeArea(request.getPracticeArea());
        profile.setCity(request.getCity());
        profile.setConsultationFees(request.getConsultationFees());
        profile.setVerified(false);
        profile.setUser(User);

        LawyerProfileRepository.save(profile);
    }
}
