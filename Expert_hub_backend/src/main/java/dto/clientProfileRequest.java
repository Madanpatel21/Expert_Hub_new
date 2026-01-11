package dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class clientProfileRequest {
	private String fullName;
	private String phone;
	private String city;
}