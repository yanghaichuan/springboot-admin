package com.yhc.example.domain.entity;

import java.io.Serializable;
import lombok.Data;
import java.util.Date;

/**
 *  sys_menu
 * @author 杨海传 2020-08-15
 */
@Data
public class SysMenu implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    private Long menuId;

    /**
     * 名称
     */
    private String menuName;

    /**
     * 菜单类型
     */
    private String menuType;

    /**
     * 父菜单id
     */
    private Long parentId;

    /**
     * 路径
     */
    private String url;

    /**
     * 状态
     */
    private Integer state;

    /**
     * 样式徽章
     */
    private String badge;

    /**
     * 上传图片路径
     */
    private String img;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date createtime;

}

