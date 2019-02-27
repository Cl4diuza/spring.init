package th.co.aware.etda.ws.dopa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class DOPAServiceImpl implements DOPAService {

	@Autowired
	private DOPAClient client;
	@Override
	public String test(String name) {
		return "hello " + name +" so this is "+ client.client() ;
	}
}
