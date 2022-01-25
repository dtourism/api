package org.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.api.domain.dto.UserDTO;
import org.api.domain.po.UserPO;
import org.api.domain.vo.UserVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author fox
 * @since 2020-04-26
 */
@Repository
@Mapper
public interface UserMapper extends BaseMapper<UserPO> {

    /**
     * 校验用户登录
     * @param userName 用户名
     * @return UserPO 用户实体vo
     */
    UserVO getUserByName(@Param("userName") String userName);

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
    int addUser(UserPO userPO);

    /**
     * 更新用户信息
     * @param userPO 用户实体
     * @return 返回结果
     */
    int updateUser(UserPO userPO);

    /**
     * 根据用户id删除指定用户
     * @param id 用户id
     * @return 返回结果
     */
    int deleteUser(@Param("id") Long id);
}
