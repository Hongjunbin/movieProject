package com.hjb.movie.openApi.service;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class OpenApiMovieService implements OpenApiService {

    public void callOpenApi() throws IOException {

        HttpClient hc = new HttpClient();

        GetMethod getMethod = new GetMethod("https://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.json");
        getMethod.setQueryString("key=e08881edc3158fd8194585483c48e21e");

        hc.executeMethod( getMethod );

        String responseBodyAsString = getMethod.getResponseBodyAsString();

        // 데이터 파싱 ( jsonObject 관련 라이브러리 사용 )
        // DB 저장
        System.out.println(responseBodyAsString);

    }

}
