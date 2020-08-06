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
 * 大小件扫码单据表对象 t_scan_bill
 * @author 杨海传
 * @date 2020-07-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_scan_bill")
public class ScanBill implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    @TableId(value = "f_pid", type = IdType.AUTO)
    private String pid;

    /** S-日期+流水号 */
    @TableField(value = "f_bill")
    private String bill;

    /** 单据日期 */
    @TableField(value = "f_billdate")
    private String billdate;

    /** 物料编码 */
    @TableField(value = "f_matCode")
    private String matCode;

    /** 供应商编码 */
    @TableField(value = "f_supplier_code")
    private String supplierCode;

    /** 状态：0：未创建；1：待扫描；2：扫描中；3：扫描完 */
    @TableField(value = "f_status")
    private String status;

    /** 小件数量 */
    @TableField(value = "f_num")
    private String num;

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
