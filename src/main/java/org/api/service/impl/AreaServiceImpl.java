package org.api.service.impl;

import cn.hutool.core.bean.BeanUtil;
import org.api.mapper.AreaMapper;
import org.api.mapper.UserMapper;
import org.api.domain.dto.AreaDTO;
import org.api.domain.dto.UserDTO;
import org.api.domain.entity.Area;
import org.api.domain.po.UserPO;
import org.api.domain.vo.UserVO;
import org.api.service.AreaService;
import org.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 行政区域管理业务逻辑层
 *
 * @author fox
 * @since 2020-04-26
 */
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private AreaMapper areaMapper;

    /**
     * 条件查询区域列表
     *
     * @param areaDTO 查询dto
     * @return 返回列表
     */
    @Override
    public List<Area> areaList(AreaDTO areaDTO) {
        return null;
    }

    /**
     * 新增区域编码
     *
     * @param area 区域编码
     */
    @Override
    public int insertArea(Area area) {
        return 0;
    }

    /**
     * 删除指定的区域编码
     *
     * @param id 区域id
     */
    @Override
    @Transactional(
            transactionManager = "apiTransactionManager",
            /* 传播级别 */
            propagation = Propagation.REQUIRED,
            /* 回滚机制 */
            rollbackFor = {RuntimeException.class, Exception.class},
            /* 事务隔离级别（默认为Mysql级别） */
            isolation = Isolation.DEFAULT,
            /* 超时默认30秒 */
            timeout = 1800)
    public void deleteArea(Integer id) {
        AreaDTO areaDTO = new AreaDTO();
        areaDTO.setId(id);
        List<Area> areas = areaMapper.areaList(areaDTO);
        Area area = areas.stream().findFirst().orElse(null);
        if (area != null) {
            UserDTO userDTO = new UserDTO();
            userDTO.setMobile(area.getCityCode());
            List<UserVO> userVOS = userMapper.userList(new UserDTO());
            BeanUtil.copyProperties(userVOS, List.class);
            userVOS.forEach(x -> {
                x.setMobile(null);
                UserPO userPO = BeanUtil.copyProperties(x, UserPO.class);
                userService.updateUser(userPO);
            });
//            if (areas != null) {
//                throw new RuntimeException("抛出！");
//            }
//            areaMapper.deleteArea(id);
        }

    }
}
