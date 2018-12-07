package io.pivotal.callexternal;

import java.util.function.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CallexternalApplication {

	@Autowired
	CallerService callerService;

	@Bean
	public RestTemplate rest(RestTemplateBuilder builder) {
		return builder.build();
	}


	@Bean
	public Function<String, String> myfunc() {
		return s -> callerService.makeCall(s);
	}

	public static void main(String[] args) {
		SpringApplication.run(CallexternalApplication.class, args);
	}
}
