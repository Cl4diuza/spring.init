package th.co.aware.etda.ws.dopa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import th.co.aware.etda.ws.dopa.service.DOPAService;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class DopaServiceTest {
    
	@Autowired
	private DOPAService service;
		
	@Test
	public void TestService(){
		
		System.out.println(service.test("Opal"));
	}
	
	
}