package th.co.aware.etda.ws.dopa.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import th.co.aware.etda.ws.dopa.entity.Role;


public interface RoleRepository extends CrudRepository<Role, String> {
	List<Role> findByName(String name);
	
	//List<String> findByUserAccount(List<String> name);
}
