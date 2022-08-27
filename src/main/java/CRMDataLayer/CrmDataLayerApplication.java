package CRMDataLayer;

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

	@Autowired
	MainMenu menu;

	public static void main(String[] args) {
		SpringApplication.run(CrmDataLayerApplication.class, args);
	}

	@Bean
	public void run() {

		menu.executeCommand();
	}

}
