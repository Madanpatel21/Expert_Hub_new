package dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class otpVerifyRequest {
	private String email;
	private String otp;
}
