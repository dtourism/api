package org.api.service;

import org.api.domain.dto.AreaDTO;
import org.api.domain.dto.UserDTO;
import org.api.domain.entity.Area;
import org.api.domain.po.UserPO;
import org.api.domain.vo.UserVO;

import java.util.List;

/**
 * @author fox
 * @since 2020-04-26
 */
public interface AreaService {

    /**
     * 条件查询区域列表
     * @param areaDTO 查询dto
     * @return 返回列表
     */
    List<Area> areaList(AreaDTO areaDTO);

    /**
     * 新增区域编码
     * @param area 区域编码
     */
    int insertArea(Area area);

    /**
     * 删除指定的区域编码
     * @param id 区域id
     */
    void deleteArea(Integer id);

}
