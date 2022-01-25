package org.api.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.api.domain.po.Role;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * @Author: fox
 * Email:fayfoxcat@gmail.com
 * Date: 2020/6/22 13:24
 * Description(api): 用户对应实体类VO
 **/
@Data
@ApiModel("用户实体VO")
@NoArgsConstructor
public class UserVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "账号")
    private String account;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "昵称")
    private String userName;

    @ApiModelProperty(value = "头像")
    private String header;

    @ApiModelProperty(value = "性别（0：女 ，1：男，2：保密）")
    private Integer sex;

    @ApiModelProperty(value = "手机号")
    private String mobile;

    @ApiModelProperty(value = "出生日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birthday;

    @ApiModelProperty(value = "用户状态（0：禁用，1：正常，2：审核）")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty(value = "创建人Id")
    private Long createUserId;

    @ApiModelProperty(value = "创建人")
    private String createUserName;

    @ApiModelProperty(value = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    @ApiModelProperty(value = "更新人Id")
    private Long updateUserId;

    @ApiModelProperty(value = "更新人")
    private String updateUserName;

    @ApiModelProperty(value = "逻辑状态（0：正常，1删除）")
    private Integer del;

    /*用户对应的角色集合*/
    private Set<Role> roles;

}
