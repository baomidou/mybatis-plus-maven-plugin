package com.baomidou.config;

import com.baomidou.config.rules.IdClassType;
import com.baomidou.config.rules.IdStrategy;
import com.baomidou.config.rules.NamingStrategy;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * 策略配置项
 *
 * @author YangHu
 * @since 2016/8/30
 */
public class StrategyConfig {

    /**
     * 数据库表映射到实体的命名策略
     */
    @Parameter(defaultValue = "nochange")
    private NamingStrategy naming;

    /**
     * Entity 中的ID生成类型
     */
    @Parameter(defaultValue = "ID_WORKER")
    private IdStrategy idGenType;

    /**
     * 数据库表设计的ID的类型 STIRNG, LONG
     */
    @Parameter(defaultValue = "stringtype")
    private IdClassType serviceIdType;

    /**
     * 自定义继承的Service类全称，带包名
     */
    @Parameter
    private String superServiceClass;

    /*
     *  需要包含的表名（与exclude二选一配置）
     */
    @Parameter
    private String[] include = null;

    /**
     * 需要排除的表名
     */
    @Parameter
    private String[] exclude = null;

    public NamingStrategy getNaming() {
        return naming;
    }

    public IdClassType getServiceIdType() {
        return serviceIdType;
    }

    public IdStrategy getIdGenType() {
        return idGenType;
    }

    public String[] getInclude() {
        return include;
    }

    public String[] getExclude() {
        return exclude;
    }

    public String getSuperServiceClass() {
        return superServiceClass;
    }

}
