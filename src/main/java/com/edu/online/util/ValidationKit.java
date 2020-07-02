package com.edu.online.util;

import com.edu.online.consts.Const;
import com.edu.online.exception.ValidationException;

import java.util.*;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import lombok.experimental.UtilityClass;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * ValidationKit.
 *
 * @author zhujunhan
 * @version 1.0
 * @date 2020/1/30
 */
@UtilityClass
public class ValidationKit {

    /**
     * 获取Validator.
     */
    private static final Validator VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();

    /**
     * 手动调用Spring验证.
     *
     * @param bean 要验证的bean
     * @param <T>  要验证的bean类型
     */
    public static <T> void validate(T bean) {
        Set<ConstraintViolation<T>> constraintViolations = VALIDATOR.validate(bean);
        AssertKit.notEmpty(constraintViolations, getMessage(constraintViolations));
    }

    private static <T> String getMessage(Set<ConstraintViolation<T>> resultList) {
        List<String> msgList = resultList.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
        return StringUtils.join(msgList, Const.SEP_COMMA);
    }


    /**
     * isBlank.
     *
     * @param str     str
     * @param message message
     * @param args    args
     */
    public static void isBlank(String str, String message, Object... args) {
        if (StringUtils.isBlank(str)) {
            throw new ValidationException(message, args);
        }
    }


    /**
     * equals.
     *
     * @param obj1    obj1
     * @param obj2    obj2
     * @param message message
     * @param args    args
     */
    public static void equals(Object obj1, Object obj2, String message, Object... args) {
        if (Objects.equals(obj1, obj2)) {
            throw new ValidationException(message, args);
        }
    }

    /**
     * equals.
     *
     * @param str1    str1
     * @param str2    str2
     * @param message message
     * @param args    args
     */
    public static void equals(String str1, String str2, String message, Object... args) {
        if (StringUtils.equals(str1, str2)) {
            throw new ValidationException(message, args);
        }
    }

    /**
     * notEquals.
     *
     * @param obj1    obj1
     * @param obj2    obj2
     * @param message message
     * @param args    args
     */
    public static void notEquals(Object obj1, Object obj2, String message, Object... args) {
        if (ObjectUtils.notEqual(obj1, obj2)) {
            throw new ValidationException(message, args);
        }
    }


    /**
     * notEquals.
     *
     * @param str1    str1
     * @param str2    str2
     * @param message message
     * @param args    args
     */
    public static void notEquals(String str1, String str2, String message, Object... args) {
        if (!StringUtils.equals(str1, str2)) {
            throw new ValidationException(message, args);
        }
    }

    /**
     * isTrue.
     *
     * @param istrue  istrue
     * @param message message
     * @param args    args
     */
    public static void isTrue(boolean istrue, String message, Object... args) {
        if (istrue) {
            throw new ValidationException(message, args);
        }
    }

    /**
     * isFalse.
     *
     * @param isfalse isfalse
     * @param message message
     * @param args    args
     */
    public static void isFalse(boolean isfalse, String message, Object... args) {
        if (!isfalse) {
            throw new ValidationException(message, args);
        }
    }

    /**
     * isNull.
     *
     * @param obj     obj
     * @param message message
     * @param args    args
     */
    public static void isNull(Object obj, String message, Object... args) {
        if (obj == null) {
            throw new ValidationException(message, args);
        }
    }

    /**
     * notNull.
     *
     * @param obj     obj
     * @param message message
     * @param args    args
     */
    public static void notNull(Object obj, String message, Object... args) {
        if (obj != null) {
            throw new ValidationException(message, args);
        }
    }

    /**
     * notEmpty.
     *
     * @param array   array
     * @param message message
     * @param args    args
     */
    public static void notEmpty(Object[] array, String message, Object... args) {
        if (ArrayUtils.isNotEmpty(array)) {
            throw new ValidationException(message, args);
        }
    }

    /**
     * notEmpty.
     *
     * @param coll    coll
     * @param message message
     * @param args    args
     */
    public static void notEmpty(Collection<?> coll, String message, Object... args) {
        if (CollectionUtils.isNotEmpty(coll)) {
            throw new ValidationException(message, args);
        }
    }

    /**
     * notEmpty.
     *
     * @param map     map
     * @param message message
     * @param args    args
     */
    public static void notEmpty(Map<?, ?> map, String message, Object... args) {
        if (MapUtils.isNotEmpty(map)) {
            throw new ValidationException(message, args);
        }
    }

    /**
     * isEmpty.
     *
     * @param array   array
     * @param message message
     * @param args    args
     */
    public static void isEmpty(Object[] array, String message, Object... args) {
        if (ArrayUtils.isEmpty(array)) {
            throw new ValidationException(message, args);
        }
    }

    /**
     * isEmpty.
     *
     * @param coll    coll
     * @param message message
     * @param args    args
     */
    public static void isEmpty(Collection<?> coll, String message, Object... args) {
        if (CollectionUtils.isEmpty(coll)) {
            throw new ValidationException(message, args);
        }
    }

    /**
     * isEmpty.
     *
     * @param map     map
     * @param message message
     * @param args    args
     */
    public static void isEmpty(Map<?, ?> map, String message, Object... args) {
        if (MapUtils.isEmpty(map)) {
            throw new ValidationException(message, args);
        }
    }
}

