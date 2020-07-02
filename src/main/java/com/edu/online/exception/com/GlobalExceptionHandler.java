package com.edu.online.exception.com;

import com.edu.online.consts.Const;
import com.edu.online.exception.EduolServerException;
import com.edu.online.exception.ValidationException;

import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * GlobalExceptionHandler.
 *
 * @author zhujunhan
 * @version 1.0
 * @date 2020/1/30
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 不需要写日志的.
     *
     * @param ex RuntimeException
     * @return String
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ValidationException.class, IllegalArgumentException.class,
            MethodArgumentTypeMismatchException.class,
            MissingServletRequestParameterException.class})
    public String customExceptionHandler(RuntimeException ex) {
        return ex.getMessage();
    }

    /**
     * bean参数验证 带requestbody的方式.
     *
     * @param ex RuntimeException
     * @return String
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String validExceptionHandler(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining(Const.SEP_COMMA));
    }

    /**
     * bean参数验证.
     *
     * @param ex RuntimeException
     * @return String
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public String validExceptionHandler(BindException ex) {
        return ex.getAllErrors().stream().map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining(Const.SEP_COMMA));
    }

    /**
     * 单个参数验证.
     *
     * @param ex RuntimeException
     * @return String
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public String validExceptionHandler(ConstraintViolationException ex) {
        return ex.getConstraintViolations().stream().map(ConstraintViolation::getMessage)
                .collect(Collectors.joining(Const.SEP_COMMA));
    }

    /**
     * 运行时异常.
     *
     * @param ex RunException
     * @return String
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(EduolServerException.class)
    public String runExceptionionHandler(EduolServerException ex) {
        log.error("运行发生了异常，请检查!", ex);
        return ex.getMessage();
    }


    /**
     * 其他未被捕获的异常.
     *
     * @param throwable 所有的未被捕获或定义的异常
     * @return String
     */
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    public String exception(Throwable throwable) {
        log.error(throwable.getMessage(), throwable);
        return "服务器内部出现问题, 请稍后重试或联系系统管理员!";
    }
}
