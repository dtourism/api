package org.api.domain.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @Author: fox
 * Email:fayfoxcat@gmail.com
 * Date: 2020/6/22 13:24
 * Description(api): 行政区域表
 **/

@Data
public class AreaDTO{

    /**
     * id
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Integer id;

    /**
     * 省份区域编码
     */
    private String provinceCode;

    /**
     * 省份名称
     */
    private String provinceName;

    /**
     * 城市区域编码
     */
    private String cityCode;

    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 区县区域编码
     */
    private String districtCode;

    /**
     * 区县名称
     */
    private String districtName;

}
