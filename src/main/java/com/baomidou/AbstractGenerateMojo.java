package com.baomidou;

import com.baomidou.config.DataSourceConfig;
import com.baomidou.config.PackageConfig;
import com.baomidou.config.StrategyConfig;
import com.baomidou.config.builder.ConfigBuilder;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * 插件基类，用于属性配置
 * 设计成抽象类主要是用于后期可扩展，共享参数配置。
 *
 * @author YangHu
 * @since 2016/8/30
 */
public abstract class AbstractGenerateMojo extends AbstractMojo {

    /**
     * 数据源配置
     */
    @Parameter(required = true)
    private DataSourceConfig dataSource;

    /**
     * 数据库表配置
     */
    @Parameter
    private StrategyConfig strategy;

    /**
     * 包 相关配置
     */
    @Parameter
    private PackageConfig packageInfo;


    /**
     * 生成文件的输出目录
     */
    @Parameter
    private String outputDir;

    /**
     * 是否覆盖已有文件
     */
    @Parameter(defaultValue = "false")
    private boolean fileOverride;

    /**
     * 是否在xml中添加二级缓存配置
     */
    @Parameter(defaultValue = "true")
    private boolean enableCache;

    /**
     * 开发人员
     */
    @Parameter(defaultValue = "author")
    private String author;

    protected ConfigBuilder config;

    /**
     * 日志工具
     */
    protected Log log = getLog();

    /**
     * 初始化配置
     */
    protected void initConfig() {
        if (null == config) {
            config = new ConfigBuilder(packageInfo, dataSource, strategy, outputDir);
        }
    }

    public String getOutputDir() {
        return outputDir;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isFileOverride() {
        return fileOverride;
    }

    public boolean isEnableCache() {
        return enableCache;
    }

}
