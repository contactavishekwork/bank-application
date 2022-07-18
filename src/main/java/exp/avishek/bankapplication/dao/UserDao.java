package exp.avishek.bankapplication.dao;

import exp.avishek.bankapplication.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<UserEntity, Long> {

    UserEntity getUserById(int accountId);

    List<UserEntity> getAllByUsernameMatches(String username);
}
