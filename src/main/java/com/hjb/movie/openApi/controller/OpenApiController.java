package com.hjb.movie.openApi.controller;

import com.hjb.movie.openApi.service.OpenApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
@RestController
public class OpenApiController {

    private final OpenApiService openApiService;

    @Autowired
    OpenApiController(OpenApiService openApiService) {
        this.openApiService = openApiService;
    }

    @RequestMapping( value = "/getMovieInfo" , method = RequestMethod.GET )
    public void getMovieInfoList() throws IOException {
        this.openApiService.callOpenApi();
    }

}
