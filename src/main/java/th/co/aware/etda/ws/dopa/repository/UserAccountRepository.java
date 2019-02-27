package th.co.aware.etda.ws.dopa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import th.co.aware.etda.ws.dopa.entity.UserAccount;

public interface UserAccountRepository extends CrudRepository<UserAccount, String> {
	UserAccount findByUsernameAndEmail(String username, String email);
	UserAccount findByEmail(String email);
	
	
	@Query(name = "UserAccount.findByCity", nativeQuery = true, value = "SELECT user_account.* FROM user_account LEFT JOIN address ON address.account_id = user_account.id WHERE address.city =:city")
	List<UserAccount> findByCity(@Param("city") String city);

}
