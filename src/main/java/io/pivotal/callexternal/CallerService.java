package io.pivotal.callexternal;

import java.net.URI;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CallerService {

	private final RestTemplate restTemplate;

	public CallerService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public String makeCall(String s) {

		HttpHeaders requestHeaders = new HttpHeaders();
		HttpEntity requestEntity = new HttpEntity(null, requestHeaders);
		ResponseEntity<String> responseEntity = restTemplate.exchange(
				URI.create("http://jsonplaceholder.typicode.com/todos/1"),
				HttpMethod.GET,
				requestEntity,
				String.class
		);

		return responseEntity.getBody();
	}
}
