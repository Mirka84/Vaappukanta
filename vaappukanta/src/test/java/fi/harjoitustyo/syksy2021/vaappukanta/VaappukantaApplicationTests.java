package fi.harjoitustyo.syksy2021.vaappukanta;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fi.harjoitustyo.syksy2021.vaappukanta.web.VaappuController;

@SpringBootTest
class VaappukantaApplicationTests {
	
	@Autowired
	VaappuController vaappuController; 

	@Test
	void contextLoads() {
		
		assertThat(vaappuController).isNotNull(); 
	}

}
