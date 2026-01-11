package Repository;

import java.util.Optional;



import org.springframework.data.jpa.repository.JpaRepository;

import entity.user;

public interface userRepository extends JpaRepository<user,Long>{

	Optional<user> findByEmail(String email);
	boolean existsByEmail( String email);
}
