package com.edu.online.util;

import java.util.UUID;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.helpers.MessageFormatter;

/**
 * 字符串工具类.
 *
 * @author zhujunhan
 * @version 1.0
 * @date 2020/1/30
 */
@UtilityClass
public class StringKit {

    /**
     * 获取最新的UUID.
     *
     * @return 字符串
     */
    public static String getUuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }


    /**
     * 使用 Slf4j 中的字符串格式化方式来格式化字符串.
     *
     * @param pattern 待格式化的字符串
     * @param args    参数
     * @return 格式化后的字符串
     */
    public static String format(String pattern, Object... args) {
        return pattern == null ? StringUtils.EMPTY : MessageFormatter.arrayFormat(pattern, args).getMessage();
    }
}
