package com.baomidou.config.rules;

/**
 * ID类型
 *
 * @author YangHu
 * @since 2016/8/30
 */
public enum IdClassType {
    /**
     * LONG型
     */
    longtype("long", "com.baomidou.framework.service.ISuperService"),

    /**
     * STRING型
     */
    stringtype("string", "com.baomidou.framework.service.ICommonService");

    private String type;
    private String pakageName;

    IdClassType(String type, String pkgName) {
        this.type = type;
        this.pakageName = pkgName;
    }

    public String getType() {
        return type;
    }

    public String getPakageName() {
        return pakageName;
    }

}
