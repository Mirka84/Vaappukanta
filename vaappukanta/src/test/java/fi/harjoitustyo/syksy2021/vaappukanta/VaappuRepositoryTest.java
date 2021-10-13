package fi.harjoitustyo.syksy2021.vaappukanta;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.assertj.core.api.Assertions;

import fi.harjoitustyo.syksy2021.vaappukanta.domain.Malli;
import fi.harjoitustyo.syksy2021.vaappukanta.domain.MalliRepository;
import fi.harjoitustyo.syksy2021.vaappukanta.domain.VaappuRepository;
import fi.harjoitustyo.syksy2021.vaappukanta.domain.Vaappu;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class VaappuRepositoryTest {
	
	@Autowired
	private VaappuRepository repository; 
	
	@Autowired
	private MalliRepository mrepository; 
	
	

}
