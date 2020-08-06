package com.yhc.example.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 条码对象 t_mat_dic
 *
 * @author 杨海传
 * @date 2020-07-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_mat_dic")
public class MatDic implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "f_pid", type = IdType.AUTO)
    private String pid;

    /**
     * 物料编码
     */
    @TableField(value = "f_mat_code")
    private String matCode;

    /**
     * 物料全称
     */
    @TableField(value = "f_mat_name")
    private String matName;

    /**
     * 物料名简称
     */
    @TableField(value = "f_mat_name_sort")
    private String matNameSort;

    /**
     * 物料规格
     */
    @TableField(value = "f_mat_size")
    private String matSize;

    /**
     * 物料类型（9112  ：框架纸(白卡纸)   ；9109 烟用内衬纸(铝箔纸)）
     */
    @TableField(value = "f_mat_type")
    private String matType;

    /**
     * 框架纸(白卡纸), 烟用内衬纸(铝箔纸)
     */
    @TableField(value = "f_mat_type_name")
    private String matTypeName;

    /**
     * 大件中的小件标准数量
     */
    @TableField(value = "f_box_count")
    private String boxCount;

    /**
     * 物料标重
     */
    @TableField(value = "f_standard_weight")
    private String standardWeight;

    @TableField(value = "f_sys_flag")
    private String sysFlag;

    @TableField(value = "f_remark")
    private String remark;

    @TableField(value = "f_remark1")
    private String remark1;

    @TableField(value = "f_creator")
    private String creator;

    @TableField(value = "f_create_time")
    private String createTime;

    @TableField(value = "f_modifier")
    private String modifier;

    @TableField(value = "f_modify_time")
    private String modifyTime;
    /**
     * 单位
     */
    @TableField(value = "f_unit")
    private String unit;
}
