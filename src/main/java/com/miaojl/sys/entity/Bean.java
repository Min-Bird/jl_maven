package com.miaojl.sys.entity;

import java.io.Serializable;

/**
 * @author mjl
 * @date 2020/3/17
 * @description 父实体类
 */
public class Bean implements Serializable {

    private static final long serialVersionUID = 1L;
    //创建时间
    private String createDate;
    //创建人
    private Integer createBy;
    //是否删除 1是，0否
    private Integer delFlag;

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }
}
