package com.hjb.movie;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class MovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieApplication.class, args);
		
		RestTemplate restTemplate = new RestTemplate();
		String apiUrl = "https://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.json?key=e08881edc3158fd8194585483c48e21e";
		String response = restTemplate.getForObject(apiUrl, String.class);
		System.out.println(response);
		
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(response);

            // JsonNode에서 필요한 값을 추출
            String movieNm = rootNode.path("movieListResult").path("movieNm").asText(); // key1에 해당하는 값을 추출하여 문자열로 변환
            String nationAlt = rootNode.path("nationAlt").asText(); // key2에 해당하는 값을 추출하여 정수로 변환

            // 추출한 값들을 출력
            System.out.println(movieNm);
            System.out.println(nationAlt);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		
	}

}
