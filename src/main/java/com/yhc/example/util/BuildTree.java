package com.yhc.example.util;

import com.yhc.example.domain.vo.TreeBean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IDEA2018.3
 * author:杨海传
 * Date:2020-08-15 10:02
 */
public class BuildTree {
    public static List<TreeBean> build(List<TreeBean> list, Long parentId) {
        List<TreeBean> treeBeanList = getChildPerms(list, parentId);
        return treeBeanList;
    }

    /**
     * 根据父节点的ID获取所有子节点
     *
     * @param list     分类表
     * @param parentId 传入的父节点ID
     * @return String
     */
    public static List<TreeBean> getChildPerms(List<TreeBean> list, Long parentId) {
        List<TreeBean> returnList = new ArrayList<TreeBean>();
        for (Iterator<TreeBean> iterator = list.iterator(); iterator.hasNext(); ) {
            TreeBean t = (TreeBean) iterator.next();
            // 一、根据传入的某个父节点ID,遍历该父节点的所有子节点

            if (t.getParentId().longValue() == parentId.longValue()) {
                recursionFn(list, t);
                returnList.add(t);
            }
        }
        return returnList;
    }

    /**
     * 递归列表
     *
     * @param list
     * @param t
     */
    private static void recursionFn(List<TreeBean> list, TreeBean t) {
        // 得到子节点列表
        List<TreeBean> childList = getChildList(list, t);
        t.setChildren(childList);
        for (TreeBean tChild : childList) {
            if (hasChild(list, tChild)) {
                // 判断是否有子节点
                Iterator<TreeBean> it = childList.iterator();
                while (it.hasNext()) {
                    TreeBean n = (TreeBean) it.next();
                    recursionFn(list, n);
                }
            }
        }
    }

    /**
     * 得到子节点列表
     */
    private static List<TreeBean> getChildList(List<TreeBean> list, TreeBean t) {
        List<TreeBean> tlist = new ArrayList<TreeBean>();
        Iterator<TreeBean> it = list.iterator();
        while (it.hasNext()) {
            TreeBean n = (TreeBean) it.next();
            if (n.getParentId().longValue() == t.getId()) {
                tlist.add(n);
            }
        }
        return tlist;
    }

    /**
     * 判断是否有子节点
     */
    private static boolean hasChild(List<TreeBean> list, TreeBean t) {
        return getChildList(list, t).size() > 0 ? true : false;
    }

}
