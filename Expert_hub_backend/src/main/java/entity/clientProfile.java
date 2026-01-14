package entity;


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
public class clientProfile {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String fullName;
 private String phone;
 private  String city;
 @OneToOne
 @JoinColumn(name="user_id", nullable = false, unique = true)
 private user User;
 
 private String profileImagePath;
}
