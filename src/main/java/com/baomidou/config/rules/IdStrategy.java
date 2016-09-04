package com.baomidou.config.rules;

/**
 * ID生成策略
 *
 * @author YangHu
 * @since 2016/8/30
 */
public enum IdStrategy {
    auto("AUTO"), id_worker("ID_WORKER"), uuid("UUID"), input("INPUT");

    private String value;

    IdStrategy(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
