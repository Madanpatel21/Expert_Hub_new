package entity;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name="roles")
public class role {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id; // Id 
 
 @Column(nullable=false, unique=true)
 private String name; // Client or Lawyer
}
