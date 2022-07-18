package exp.avishek.bankapplication.dao;

import exp.avishek.bankapplication.model.entity.AccountMainEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDao extends JpaRepository<AccountMainEntity, Long> {

    AccountMainEntity getAccountMainEntitiesByAccountNumber(Long accountNumber);

}
