package com.july.admin.controller;

import com.july.admin.common.Result;
import com.july.admin.service.FileStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Base64;
import java.util.Map;
import java.util.Random;

/**
 * @author: july
 * @date: 2020/1/11 15:12
 * @description:
 */
@Controller
public class CommonController {


    @Autowired
    private FileStoreService localFileService;

    @GetMapping("weather")
    @ResponseBody
    @Cacheable(value = "weather",key = "#cityId")
    public Result getWeather(String cityId){
        RestTemplate restTemplate = new RestTemplate();

        Map<String,Object> map = restTemplate
                .getForObject("http://t.weather.sojson.com/api/weather/city/" + cityId,
                        Map.class);
        return Result.success(map);
    }

    @PostMapping(value = "img/upload")
    @ResponseBody
    public Result<String> uploadImg(@RequestParam("file") MultipartFile file) throws Exception {

        String name = file.getOriginalFilename();
        String path = localFileService.upload(name,file);
        return Result.success(path);
    }

    @PostMapping(value = "img/delete")
    @ResponseBody
    public Result<Boolean> deleteImg(String name) throws Exception {

        boolean remove = localFileService.remove(name);
        return Result.success(remove);
    }
}
