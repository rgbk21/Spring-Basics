package com.example.rgbk;

import com.example.rgbk.config.AppConfig;
import com.example.rgbk.persistence.model.Project;
import com.example.rgbk.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@SpringBootApplication
public class App {

	@Autowired
	@Qualifier("projectServiceImpl")
	private IProjectService projectService;

	public static void main(String[] args) {

		SpringApplication.run(App.class, args);

		// Uncomment the below to test the destroy hook in bean lifecycle
		// But you also have to comment the above code
//		ConfigurableApplicationContext context = SpringApplication.run(new Class[] { App.class, AppConfig.class }, args);
//		context.close();

	}

	@PostConstruct
	public void postConstruct() {
		Project project = new Project("My First Project", LocalDate.now());
		projectService.save(project);
	}

}
