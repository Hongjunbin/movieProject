package com.hjb.movie.openApi.controller;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
@Controller
public class OpenApiController {

    @GetMapping( "/getMovieInfo" )
    public void getMovieInfoList() throws IOException {

        HttpClient hc = new HttpClient();

        GetMethod getMethod = new GetMethod("https://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.json");
        getMethod.setQueryString("key=e08881edc3158fd8194585483c48e21e");

        hc.executeMethod( getMethod );

        String responseBodyAsString = getMethod.getResponseBodyAsString();

        System.out.println(responseBodyAsString);

    }

}
