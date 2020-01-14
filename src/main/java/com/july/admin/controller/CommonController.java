package com.july.admin.controller;

import com.july.admin.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @author: july
 * @date: 2020/1/11 15:12
 * @description:
 */
@Controller
public class CommonController {


    @GetMapping("weather")
    @ResponseBody
    @Cacheable("weather")
    public Result getWeather(String cityId){
        RestTemplate restTemplate = new RestTemplate();

        Map<String,Object> map = restTemplate
                .getForObject("http://t.weather.sojson.com/api/weather/city/" + cityId,
                        Map.class);
        return Result.success(map);
    }
}
