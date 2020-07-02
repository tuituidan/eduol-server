package com.edu.online.exception;

import com.edu.online.exception.com.AbstractException;

/**
 * ValidException.
 *
 * @author zhujunhan
 * @version 1.0
 * @date 2020/1/30
 */
public class ValidationException extends AbstractException {
    private static final long serialVersionUID = 8307330717880840211L;

    /**
     * message.
     *
     * @param message tips
     */
    public ValidationException(String message) {
        super(message);
    }

    /**
     * message、args.
     *
     * @param message String
     * @param args    Object...
     */
    public ValidationException(String message, Object... args) {
        super(message, args);
    }

    /**
     * cause、message.
     *
     * @param cause   异常原因实例
     * @param message tips
     */
    public ValidationException(Throwable cause, String message) {
        super(cause, message);
    }

    /**
     * cause、message、args.
     *
     * @param cause   Throwable
     * @param message String
     * @param args    Object...
     */
    public ValidationException(Throwable cause, String message, Object... args) {
        super(cause, message, args);
    }
}
