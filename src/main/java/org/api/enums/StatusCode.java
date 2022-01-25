package org.api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: fox
 * @Date: 2020/4/17
 * Description: 自定义状态码
 **/
@Getter
@AllArgsConstructor
public enum StatusCode {

    SYSTEM_ERROR("-1", "系统异常"),
    SYSTEM_BUSY("1", "系统繁忙,请稍候再试"),
    INVALID_OPERATION("2", "非法操作"),
    GATEWAY_ERROR("3", "网关异常"),
    GATEWAY_CONNECT_TIME_OUT("4", "网关超时"),
    ARGUMENT_NOT_VALID("5", "请求参数校验不通过"),
    UPLOAD_FILE_SIZE_LIMIT("6", "上传文件大小超过限制"),
    DUPLICATE_PRIMARY_KEY("7", "唯一键冲突"),
    HTTP_ERROR_100("100", "100错误"),
    HTTP_ERROR_300("300", "300错误"),
    HTTP_ERROR_400("400", "400错误"),
    HTTP_ERROR_500("500", "500错误"),
    SIGN_ERROR("120", "签名错误"),
    TIME_OUT("130", "访问超时"),
    KICK_OUT("300", "您已经在其他地方登录，请重新登录！"),
    BAD_REQUEST("407", "参数解析失败"),
    INVALID_TOKEN("401", "无效的授权码"),
    INVALID_CLIENTID("402", "无效的密钥"),
    REQUEST_NOT_FOUND("404", "访问的服务不存在！"),
    METHOD_NOT_ALLOWED("405", "不支持当前请求方法"),
    REPEAT_REQUEST_NOT_ALLOWED("406", "请求重复提交"),
    SYSTEM_ERR("500", "服务器运行异常"),
    NOT_EXIST_USER_OR_ERROR_PWD("10000", "该用户不存在或密码错误"),
    NOT_PARAM_USER_OR_ERROR_PWD("10006", "用户名或密码为空"),
    NO_EXCEPTION("404000", "未知异常"),
    INVALID_BOOK("404001", "无效的ID"),
    ERROR_PARAMETER("404002", "参数验证失败"),
    REQUEST_NULL("404003",   "未查询到相关数据"),
    INSERT_ERROR("404004", "添加失败"),
    UPDATE_ERROR("404005", "更新失败"),
    DELETE_ERROR("404006", "删除失败"),
    CLIENT_NOT_ONLINE("404006", "消息发送失败，客户端不在线！");

    /**
     * 错误类型码
     */
    private final String code;

    /**
     * 错误类型描述信息
     */
    private final String message;

}
