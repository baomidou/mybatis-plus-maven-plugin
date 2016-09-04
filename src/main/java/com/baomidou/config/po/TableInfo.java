package com.baomidou.config.po;


import org.apache.commons.lang.StringUtils;

import java.util.List;

/**
 * 表信息，关联到当前字段信息
 *
 * @author YangHu
 * @since 2016/8/30
 */
public class TableInfo {

    private String name;
    private String comment;

    private String entityName;
    private String mapperName;
    private String xmlName;
    private String serviceName;
    private String serviceImplName;

    private List<TableField> fields;
    private String fieldNames;
    private boolean hasDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getMapperName() {
        return mapperName;
    }

    public void setMapperName(String mapperName) {
        this.mapperName = mapperName;
    }

    public String getXmlName() {
        return xmlName;
    }

    public void setXmlName(String xmlName) {
        this.xmlName = xmlName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceImplName() {
        return serviceImplName;
    }

    public void setServiceImplName(String serviceImplName) {
        this.serviceImplName = serviceImplName;
    }

    public List<TableField> getFields() {
        return fields;
    }

    public void setFields(List<TableField> fields) {
        this.fields = fields;
    }

    public String getFieldNames() {
        if (StringUtils.isBlank(fieldNames)) {
            //此处设置值是因为后面的+=会自动添加一个null字符串
            fieldNames = "";
            for (TableField field : fields) {
                fieldNames += field.getName() + ", ";
            }
        }
        // -2 是多一个空格与一个逗号
        return fieldNames.substring(0, fieldNames.length() - 2);
    }

    /**
     * 判断字段中是否包含日期类型
     *
     * @return 是否
     */
    public boolean isHasDate() {
        for (TableField fieldInfo : fields) {
            if (fieldInfo.getPropertyType().equals("Date")) {
                hasDate = true;
                break;
            }
        }
        return hasDate;
    }
}
