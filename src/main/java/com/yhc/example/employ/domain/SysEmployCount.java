package com.yhc.example.employ.domain;

import lombok.Data;

@Data
public class SysEmployCount {
    /**
     * 就业时间
     */
    public String employTime;
    /**
     * 就业数量
     */
    public Integer employNum;

    /**
     * 序号
     */
    public Integer orderNum;
    /**
     * 数量
     */
    public Integer lim;
}
