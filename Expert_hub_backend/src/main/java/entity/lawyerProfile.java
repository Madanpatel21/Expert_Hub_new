package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class lawyerProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String fullName;
	private String barCouncilNumber;
	private int yearsOfExperience;
	private String practiceArea;
	private String city;
	private double consultationFees;
	private boolean verified;
	@OneToOne
	@JoinColumn(name="user_id",nullable = false,unique = true)
	private user User;
}
