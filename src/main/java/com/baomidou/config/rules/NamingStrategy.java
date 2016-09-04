package com.baomidou.config.rules;

import com.baomidou.config.ConstVal;
import org.apache.commons.lang.StringUtils;

/**
 * 从数据库表到文件的命名策略
 *
 * @author YangHu
 * @since 2016/8/30
 */
public enum NamingStrategy {
    /**
     * 不做任何改变，原样输出
     */
    nochange,
    /**
     * 下划线转驼峰命名
     */
    underline_to_camel,
    /**
     * 仅去掉前缀
     */
    remove_prefix,
    /**
     * 去掉前缀并且转驼峰
     */
    remove_prefix_and_camel;

    public static String underlineToCamel(String name) {
        // 快速检查
        if (StringUtils.isBlank(name)) {
            // 没必要转换
            return "";
        } else if (!name.contains(ConstVal.UNDERLINE)) {
            // 不含下划线，仅将首字母小写
            return name.substring(0, 1).toLowerCase() + name.substring(1);
        }
        StringBuilder result = new StringBuilder();
        // 用下划线将原始字符串分割
        String camels[] = name.split(ConstVal.UNDERLINE);
        for (String camel : camels) {
            // 跳过原始字符串中开头、结尾的下换线或双重下划线
            if (StringUtils.isBlank(camel)) {
                continue;
            }
            // 处理真正的驼峰片段
            if (result.length() == 0) {
                // 第一个驼峰片段，全部字母都小写
                result.append(camel.toLowerCase());
            } else {
                // 其他的驼峰片段，首字母大写
                result.append(camel.substring(0, 1).toUpperCase());
                result.append(camel.substring(1).toLowerCase());
            }
        }
        return result.toString();
    }

    /**
     * 去掉下划线前缀
     *
     * @param name
     * @return
     */
    public static String removePrefix(String name) {
        if (StringUtils.isBlank(name)) {
            return "";
        }
        int idx = name.indexOf(ConstVal.UNDERLINE);
        if (idx == -1) {
            return name;
        }
        return name.substring(idx + 1);
    }

    /**
     * 去掉下划线前缀且将后半部分转成驼峰格式
     *
     * @param name
     * @return
     */
    public static String removePrefixAndCamel(String name) {
        return underlineToCamel(removePrefix(name));
    }

}
