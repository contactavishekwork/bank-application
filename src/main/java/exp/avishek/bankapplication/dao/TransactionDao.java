package exp.avishek.bankapplication.dao;

import exp.avishek.bankapplication.model.entity.AccountMainEntity;
import org.springframework.data.repository.CrudRepository;

public interface TransactionDao extends CrudRepository<AccountMainEntity, Long> {

}
