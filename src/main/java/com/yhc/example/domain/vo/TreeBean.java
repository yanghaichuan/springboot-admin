package com.yhc.example.domain.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IDEA2018.3
 * author:杨海传
 * Date:2020-08-15 9:56
 */

@Data
public class TreeBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private Long parentId;

    private String parentName;

    private String type;

    private String badge;

    private String url;

    private String remark;

    private List<TreeBean> children;


}
