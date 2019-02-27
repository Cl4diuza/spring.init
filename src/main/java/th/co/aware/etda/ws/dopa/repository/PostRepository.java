package th.co.aware.etda.ws.dopa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import th.co.aware.etda.ws.dopa.entity.Post;
import th.co.aware.etda.ws.dopa.entity.UserAccount;

public interface PostRepository extends CrudRepository<Post, String> {
	List<Post> findByCreatedUserOrderByCreatedDateDesc(UserAccount user);
}
