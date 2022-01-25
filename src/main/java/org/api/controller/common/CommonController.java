package org.api.controller.common;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.io.FileUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.api.server.ApiFeign;
import org.api.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * 全局请求
 *
 */
@Slf4j
@CrossOrigin
@RestController
@Api(tags = {"全局请求"})
@RequestMapping("/commons")
public class CommonController {

    @Autowired
    private ApiFeign apiFeign;

    @GetMapping("/log")
    @ApiOperation("查看日志")
    public Object log(){
        log.error("异常日志测试");
        log.info("业务日志测试");
        int a  = 0/0;
        log.debug("debug日志测试");
        return Result.success("log");
    }

    @GetMapping("/read-stream")
    @ApiOperation("读取流操作")
    public Object readStream(String url){
        File file = FileUtil.file(url);
        System.out.println(file.getName());
        String encode = Base64.encode(file);
        return Result.success(encode);
    }

    @PostMapping("/read-excel")
    @ApiOperation("读取excel")
    public Object readExcel(MultipartFile file){
        ExcelReader reader = ExcelUtil.getReader(MultipartFileToFile.multipartFileToFile(file));
        List<Map<String,Object>> readAll = reader.readAll();
        return Result.success(readAll);
    }
}
