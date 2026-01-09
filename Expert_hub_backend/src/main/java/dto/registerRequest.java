package dto;

import lombok.Getter;

import lombok.Setter;

@Getter
@Setter
public class registerRequest {
 private String Email;
 private String Password;
 private String Role;
}
