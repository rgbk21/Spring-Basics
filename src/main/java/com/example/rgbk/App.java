package com.example.rgbk;

import com.example.rgbk.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App {

	public static void main(String[] args) {

		SpringApplication.run(App.class, args);

		// Uncomment the below to test the destroy hook in bean lifecycle
		// But you also have to comment the above code
//		ConfigurableApplicationContext context = SpringApplication.run(new Class[] { App.class, AppConfig.class }, args);
//		context.close();

	}

}
