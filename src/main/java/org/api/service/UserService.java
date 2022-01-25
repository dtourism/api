package org.api.service;

import org.api.domain.dto.UserDTO;
import org.api.domain.po.UserPO;
import org.api.domain.vo.UserVO;

import java.util.List;

/**
 * @author fox
 * @since 2020-04-26
 */
public interface UserService{

    /**
     * 条件查询所有用户
     * @param userDTO 用户查询实体
     * @return 返回结果
     */
    List<UserVO> userList(UserDTO userDTO);

    /**
     * 新增用户
     * @param userPO 用户实体
     * @return 返回结果
     */
    Boolean addUser(UserPO userPO);

    /**
     * 更新用户信息
     * @param userPO 用户实体
     * @return 返回结果
     */
    Boolean updateUser(UserPO userPO);

    /**
     * 根据条件逻辑删除指定用户
     * @param userDTO 用户查询实体
     * @return 返回结果
     */
    Boolean logicDeleteUser(UserDTO userDTO);

    /**
     * 根据条件删除指定用户
     * @param id 用户id
     * @return 返回结果
     */
    Boolean deleteUser(Long id);

}
