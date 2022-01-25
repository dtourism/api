package org.api.domain.po;

import lombok.Data;

import java.util.List;

/**
 * @Author: WSY
 * Email:fayfoxcat@gmail.com
 * Date: 2020/6/22 15:07
 * Description(api): 用户角色表
 **/
@Data
public class Role {

    public Role(Integer roleId, String role, String describe, Boolean enabled, List<Permission> permissions) {
        this.roleId = roleId;
        this.role = role;
        this.describe = describe;
        this.enabled = enabled;
        this.permissions = permissions;
    }

    /**
     * 数据库主键
     */
    private Integer roleId;

    /**
     * 角色标识符，如: admin
     */
    private String role;

    /**
     * 描述，如: 管理员
     */
    private String describe;

    /**
     * 是否启用角色，当禁用时该角色以及对应的权限则无法被使用
     */
    private Boolean enabled;

    /**
     * 该角色拥有的权限
     */
    private List<Permission> permissions;


}
