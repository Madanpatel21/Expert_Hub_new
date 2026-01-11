package dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class lawyerProfileRequest {
	private String fullName;
    private String barCouncilNumber;
    private int yearsOfExperience;
    private String practiceArea;
    private String city;
    private double consultationFees;
}
