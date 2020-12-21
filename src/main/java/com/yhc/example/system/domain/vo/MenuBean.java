package com.yhc.example.system.domain.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class MenuBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String title;

    private String href;

    private Long parentId;

    private String fontFamily;

    private String icon;

    private boolean spread;

    private boolean isCheck;


    private List<MenuBean> children;


}
