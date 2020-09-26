package com.yhc.example.company.domain;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 *  sys_employ
 * @author yhc 2020-09-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_company")
public class SysCompany implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 名称
     */
    private String company;

    /**
     * 地址
     */
    private String companyAdress;

    /**
     * 编码
     */
    private String companyCode;

    /**
     * logo
     */
    private String companyLogo;

    /**
     * 规模
     */
    private String companyScale;

    /**
     * 联系电话
     */
    private String mobile;

    /**
     * 所在省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 状态0正常1禁用
     */
    private String status;

    /**
     * 介绍
     */
    private String remark;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    public SysCompany() {
    }

}