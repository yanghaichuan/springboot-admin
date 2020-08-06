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
 * barcode对象 t_barcode
 * 
 * @author 杨海传
 * @date 2020-07-06
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_barcode")
public class Barcode implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    @TableId(value = "f_pid", type = IdType.AUTO)
    private String pid;

    /** 工单编码 */
    @TableField(value = "f_workoder_code")
    private String workoderCode;

    /** 生产日期 */
    @TableField(value = "f_produce_date")
    private String produceDate;

    /** 物料编码 */
    @TableField(value = "f_mat_code")
    private String matCode;

    /** 条码（配盘码30位 字母E开始，物料码30位 字母I开始） */
    @TableField(value = "f_bar_code")
    private String barCode;

    /** 条码（01：配盘码；02物料码） */
    @TableField(value = "f_bar_type")
    private String barType;

    /** 质量追溯信息 配盘码12位 ，物料码暂未定义 */
    @TableField(value = "f_review")
    private String review;

    /** 配盘码为1，物料码为小件的数量，和单据的保持一致 */
    @TableField(value = "f_num")
    private String num;

    /** 托盘号4位 */
    @TableField(value = "f_pallet")
    private String pallet;

    /** 检验号 */
    @TableField(value = "f_check_num")
    private String checkNum;

    /** 物料重量 */
    @TableField(value = "f_weight")
    private String weight;

    /** 单位 */
    @TableField(value = "f_unit")
    private String unit;

    /** 是否有效 */
    @TableField(value = "f_sys_flag")
    private String sysFlag;

    /** 备注 */
    @TableField(value = "f_remark")
    private String remark;

    /** 备注1 */
    @TableField(value = "f_remark1")
    private String remark1;

    /** 创建人 */
    @TableField(value = "f_creator")
    private String creator;

    @TableField(value = "f_create_time")
    private String createTime;

    /** 修改人 */
    @TableField(value = "f_modifier")
    private String modifier;

    /** 修改时间 */
    @TableField(value = "f_modify_time")
    private String modifyTime;

}
