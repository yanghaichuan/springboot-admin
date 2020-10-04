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
 *  sys_company_message
 * @author yhc 2020-10-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_company_message")
public class SysCompanyMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 单位id
     */
    private Integer company;

    /**
     * 单位名称
     */
    private String companyName;


    /**
     * 招聘信息
     */
    private String recruitId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户名称
     */
    private String name;

    /**
     * 状态
     */
    private String status;

    /**
     * 父id
     */
    private Integer parentId;

    /**
     * 内容
     */
    private String message;

    /**
     * 序号
     */
    private Long orderNum;

    /**
     * 评分
     */
    private String score;

    /**
     * 打开次数
     */
    private Integer openNum;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 创建人
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    public SysCompanyMessage() {
    }

}