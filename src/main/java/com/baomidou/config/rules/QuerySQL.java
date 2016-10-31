package com.baomidou.config.rules;

/**
 * <p>
 * 表数据查询
 * </p>
 *
 * @author hubin
 * @since 2016-04-25
 */
public enum QuerySQL {
    MYSQL("mysql", "show tables", "show table status",
            "show full fields from %s",
            "NAME", "COMMENT", "FIELD", "TYPE", "COMMENT", "KEY"),

    ORACLE("oracle", "SELECT * FROM USER_TABLES", "SELECT * FROM USER_TAB_COMMENTS",
            "SELECT AB.COLUMN_NAME,AB.DATA_TYPE, AB.COMMENTS, DECODE(AC.POSITION, '1', 'PRI') KEY " +
                    "FROM (SELECT A.COLUMN_NAME, A.DATA_TYPE, B.COMMENTS FROM USER_TAB_COLUMNS A, USER_COL_COMMENTS B " +
                    "WHERE A.TABLE_NAME = B.TABLE_NAME AND A.COLUMN_NAME = B.COLUMN_NAME AND A.TABLE_NAME = '%s') AB " +
                    "LEFT JOIN(SELECT CU.COLUMN_NAME, CU.POSITION FROM USER_CONS_COLUMNS CU, USER_CONSTRAINTS AU " +
                    "WHERE CU.CONSTRAINT_NAME = AU.CONSTRAINT_NAME AND AU.CONSTRAINT_TYPE = 'P' " +
                    "AND AU.TABLE_NAME = '%s') AC ON AB.COLUMN_NAME = AC.COLUMN_NAME",
            "TABLE_NAME", "COMMENTS", "COLUMN_NAME", "DATA_TYPE", "COMMENTS", "KEY");

    private final String dbType;
    private final String tablesSql;
    private final String tableCommentsSql;
    private final String tableFieldsSql;
    private final String tableName;
    private final String tableComment;
    private final String fieldName;
    private final String fieldType;
    private final String fieldComment;
    private final String fieldKey;


    QuerySQL(final String dbType, final String tablesSql, final String tableCommentsSql,
             final String tableFieldsSql, final String tableName, final String tableComment, final String fieldName,
             final String fieldType, final String fieldComment, final String fieldKey) {
        this.dbType = dbType;
        this.tablesSql = tablesSql;
        this.tableCommentsSql = tableCommentsSql;
        this.tableFieldsSql = tableFieldsSql;
        this.tableName = tableName;
        this.tableComment = tableComment;
        this.fieldName = fieldName;
        this.fieldType = fieldType;
        this.fieldComment = fieldComment;
        this.fieldKey = fieldKey;
    }

    public String getDbType() {
        return dbType;
    }

    public String getTablesSql() {
        return tablesSql;
    }

    public String getTableCommentsSql() {
        return tableCommentsSql;
    }

    public String getTableFieldsSql() {
        return tableFieldsSql;
    }

    public String getTableName() {
        return tableName;
    }

    public String getTableComment() {
        return tableComment;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getFieldType() {
        return fieldType;
    }

    public String getFieldComment() {
        return fieldComment;
    }

    public String getFieldKey() {
        return fieldKey;
    }

}
