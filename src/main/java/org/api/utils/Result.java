package org.api.utils;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.api.enums.StatusCode;

import java.time.ZonedDateTime;

/**
 * @author: fox
 * @Date: 2020/4/17
 * Description: 封装返回值
 **/
@Data
@ApiModel("接口返回封装类")
public class Result<T>{

    /**
     * 状态码
     */
    private String status;

    /**
     * 时间戳
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private ZonedDateTime timestamp;

    /**
     * 自定义信息
     */
    private String message;

    /**
     * 数据data
     */
    private T data;

    public Result(String status, String message, T data) {
        this.status = status;
        this.timestamp = ZonedDateTime.now();
        this.message = message;
        this.data = data;
    }

    public Result(String status, String message) {
        this.timestamp = ZonedDateTime.now();
        this.status = status;
        this.message = message;
    }

    /**
     * 操作成功，含数据
     */
    public static Result<?> success(Object data) {
        return new Result("200", "操作成功", data);
    }

    /**
     * 操作成功，无数据
     */
    public static Result<?> success() {
        return new Result("200", "操作成功");
    }

    /**
     * 操作失败，无数据
     */
    public static Result<?> fail(StatusCode statusCode) {
        return fail(statusCode.getCode(),statusCode.getMessage());
    }

    public static Result<?> fail(String status,String message) {
        return new Result(status, message);
    }
}
