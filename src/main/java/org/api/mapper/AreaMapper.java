package org.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.api.domain.dto.AreaDTO;
import org.api.domain.entity.Area;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author fox
 * @since 2020-04-26
 */
@Repository
@Mapper
public interface AreaMapper extends BaseMapper<Area> {

    /**
     * 条件查询区域编码
     * @param areaDTO 查询实体类
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
