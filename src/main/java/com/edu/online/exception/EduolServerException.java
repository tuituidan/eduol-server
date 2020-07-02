package com.edu.online.exception;

import com.edu.online.exception.com.AbstractException;

/**
 * EduolException.
 *
 * @author zhujunhan
 */
public class EduolServerException extends AbstractException {
    private static final long serialVersionUID = -2401857095905017858L;

    /**
     * message.
     *
     * @param message tips
     */
    public EduolServerException(String message) {
        super(message);
    }

    /**
     * message、args.
     *
     * @param message String
     * @param args    Object...
     */
    public EduolServerException(String message, Object... args) {
        super(message, args);
    }

    /**
     * cause、message.
     *
     * @param cause   异常原因实例
     * @param message tips
     */
    public EduolServerException(Throwable cause, String message) {
        super(cause, message);
    }

    /**
     * cause、message、args.
     *
     * @param cause   Throwable
     * @param message String
     * @param args    Object...
     */
    public EduolServerException(Throwable cause, String message, Object... args) {
        super(cause, message, args);
    }
}
