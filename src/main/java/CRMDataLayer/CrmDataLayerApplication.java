package CRMDataLayer;

import CRMDataLayer.model.Lead;
import CRMDataLayer.repository.LeadRepository;
import CRMDataLayer.ui.MainMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrmDataLayerApplication {
	@Autowired
	LeadRepository leadRepository;
	public static void main(String[] args) {
		SpringApplication.run(CrmDataLayerApplication.class, args);
	}

	@Bean
	public void run() {
		Lead lead1 = leadRepository.save(new Lead("Rogers", "5555555555", "cap@ojsedn.com", "USA Inc."));
		Lead lead2 = leadRepository.save(new Lead("Stark", "5555555555", "cubatas@ojsedn.com", "Extremis Foods"));
		Lead lead3 = leadRepository.save(new Lead("Banner", "5555555555", "rads@ojsedn.com", "Gamma Ray"));
		Lead lead4 = leadRepository.save(new Lead("Romanoff", "5555555555", "widow_not_an_os@ojsedn.com", "Red Room Assasins Ltd."));
		Lead lead5 = leadRepository.save(new Lead("Barton", "5555555555", "arrows@ojsedn.com", "Pizza Dog"));
		Lead lead6 = leadRepository.save(new Lead("Odinson", "5555555555", "strongest_avenger@ojsedn.com", "Asgard Tours"));
		System.out.println(lead1.toString());
	}

}
