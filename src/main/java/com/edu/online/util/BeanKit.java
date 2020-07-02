package com.edu.online.util;

import com.edu.online.exception.EduolServerException;

import java.util.HashSet;
import java.util.Set;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

/**
 * BeanExtUtils.
 *
 * @author zhujunhan
 * @version 1.0
 * @date 2020/1/30
 */
@UtilityClass
@Slf4j
public class BeanKit {

    /**
     * 转换对象.
     *
     * @param source 源属性Dto
     * @param cls    目标属性Do
     * @param <T>    转换类型
     * @return T
     */
    public static <T> T convert(Object source, Class<T> cls) {
        if (source == null) {
            return null;
        }
        try {
            T target = cls.getDeclaredConstructor().newInstance();
            BeanUtils.copyProperties(source, target);
            return target;
        } catch (Exception e) {
            throw new EduolServerException("转换错误：【{}】", cls.getName());
        }
    }

    /**
     * 复制非空数据.
     *
     * @param source 源属性Dto
     * @param target 目标属性Do
     */
    public static void copyNotNullProperties(Object source, Object target) {
        BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
    }

    private static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();
        Set<String> emptyNames = new HashSet<>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}

