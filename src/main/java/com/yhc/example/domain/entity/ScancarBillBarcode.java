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
 * 大小件扫码对象 t_scancar_bill_barcode
 * 
 * @author 杨海传
 * @date 2020-07-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_scancar_bill_barcode")
public class ScancarBillBarcode  implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    @TableId(value = "f_pid", type = IdType.AUTO)
    private String pid;

    /** S-日期+流水号 */
    @TableField(value = "f_bill")
    private String bill;

    /** 条码 */
    @TableField(value = "f_barcode")
    private String barcode;

    /** 物料编码 */
    @TableField(value = "f_mat_code")
    private String matCode;

    @TableField(value = "f_sys_flag")
    private String sysFlag;


    @TableField(value = "f_remark")
    private String remark;

    @TableField(value = "f_remark1")
    private String remark1;

    @TableField(value = "f_remark2")
    private String remark2;

    @TableField(value = "f_remark3")
    private String remark3;

    @TableField(value = "f_creator")
    private String creator;

    @TableField(value = "f_create_time")
    private String createTime;

    @TableField(value = "f_modifier")
    private String modifier;

    @TableField(value = "f_modifyTime")
    private String modifyTime;

}
