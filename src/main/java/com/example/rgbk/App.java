package com.example.rgbk;

import com.example.rgbk.persistence.model.Project;
import com.example.rgbk.old_service.IProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@SpringBootApplication
public class App implements CommandLineRunner {

	@Autowired
	@Qualifier("projectServiceImpl")
	private IProjectService projectService;

	private static final Logger LOG = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {

		LOG.info("Inside main() - STARTING THE APPLICATION");

		SpringApplication.run(App.class, args);

		LOG.info("Inside main() - APPLICATION STARTUP FINISHED");

		// Uncomment the below to test the destroy hook in bean lifecycle
		// But you also have to comment the above code
//		ConfigurableApplicationContext context = SpringApplication.run(new Class[] { App.class, AppConfig.class }, args);
//		context.close();

	}

	@PostConstruct
	public void postConstruct() {
		LOG.info("Inside main() - postConstruct Called");
	}

	@Override
	public void run(String... args) throws Exception {
		Project project = new Project("My First Project", LocalDate.now());
		projectService.save(project);
		LOG.info("Saved Project in CommandLineRunner - Project {}", project.toString());
	}
}
