package org.api.server;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@Repository
@FeignClient(name = "ApiFeign" ,url = "https://restapi.amap.com/v3/")
public interface ApiFeign {

    @ApiOperation("高德地图天气查询")
    @GetMapping("weather/weatherInfo")
    JSONObject Weather(@RequestParam("key") String key,@RequestParam("city") String city,
                       @RequestParam("extensions") String extensions,@RequestParam("output") String output);


}
