package entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
public class user {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id; // User ID
 
 @Column(nullable = false, unique = true, name="email")
 private String email; //User email
 
 @Column(nullable = false, name="password")
 private String password; // User Password
 @ManyToOne(fetch = FetchType.EAGER)
 @JoinColumn(name = "role_id", nullable = false)
 private role role; // user role

}
