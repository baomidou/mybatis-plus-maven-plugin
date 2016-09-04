package com.baomidou.config.rules;

/**
 * 数据库类型定义
 *
 * @author YangHu
 * @since 2016/8/30
 */
public enum DbType {

    MYSQL("myslq"), ORACLE("oracle");

    private String value;

    DbType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
