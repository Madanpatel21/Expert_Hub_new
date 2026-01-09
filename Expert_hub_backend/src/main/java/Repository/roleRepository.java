package Repository;

import java.util.Optional;



import org.springframework.data.jpa.repository.JpaRepository;

import entity.role;

public interface roleRepository extends JpaRepository<role,Long> {
 Optional<role> findByName(String name);
}
