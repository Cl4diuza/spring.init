package th.co.aware.etda.ws.dopa.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import th.co.aware.etda.ws.dopa.entity.UserAccount;
import th.co.aware.etda.ws.dopa.repository.UserAccountRepository;

@RestController
@RequestMapping
public class UserAccountRestController {
	
	@Autowired
	private UserAccountRepository userAccountRepo;
		
	@GetMapping("/UserAccounts")
	public Iterable<UserAccount> retrieveAllUserAccount(){
		
		return userAccountRepo.findAll();
	}
	
	@GetMapping("/UserAccounts/{id}")
	public UserAccount retrieveUserAccount(@PathVariable String id) {
		
		Optional<UserAccount> userAccount = userAccountRepo.findById(id);		
		return userAccount.get();
	}
	
	@DeleteMapping("/UserAccounts/{id}")
	public void deleteUserAccount(@PathVariable String id) {
		userAccountRepo.deleteById(id);
	}
	
	@PostMapping("/UserAccounts")
	public ResponseEntity<Object> createUserAccount(@RequestBody UserAccount userAccount) 
	{
		UserAccount savedUserAccount = userAccountRepo.save(userAccount);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedUserAccount.getId()).toUri();

		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/UserAccounts/{id}")
	public ResponseEntity<Object> updateUserAccount(@RequestBody UserAccount userAccount, @PathVariable String id) {

		Optional<UserAccount> user = userAccountRepo.findById(id);

		if (!user.isPresent())
			return ResponseEntity.notFound().build();

		userAccount.setId(id);
		
		userAccountRepo.save(userAccount);
		return ResponseEntity.noContent().build();
	}
}
