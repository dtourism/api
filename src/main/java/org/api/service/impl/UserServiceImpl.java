package org.api.service.impl;

import org.api.mapper.UserMapper;
import org.api.domain.dto.UserDTO;
import org.api.domain.po.UserPO;
import org.api.domain.vo.UserVO;
import org.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 用户管理业务逻辑层
 * @author fox
 * @since 2020-04-26
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserVO> userList(UserDTO userDTO) {
        return userMapper.userList(userDTO);
    }

    @Override
    public Boolean addUser(UserPO userPO) {
        userPO.setCreateTime(new Date());
        return userMapper.addUser(userPO) > 0;
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Boolean updateUser(UserPO userPO) {
        userPO.setUpdateTime(new Date());
        return userMapper.updateUser(userPO) > 0;
    }

    @Override
    public Boolean logicDeleteUser(UserDTO userDTO) {
        UserPO userPO = new UserPO();
        userDTO.setId(userPO.getId());
        userDTO.setDel(1);
        return userMapper.updateUser(userPO) > 0;
    }

    @Override
    public Boolean deleteUser(Long id) {
        return userMapper.deleteUser(id) > 0;
    }
}
