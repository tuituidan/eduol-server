package com.edu.online.exception.com;

import com.edu.online.util.StringKit;

/**
 * AbstractException.
 *
 * @author zhujunhan
 * @version 1.0
 * @date 2020/1/30
 */
public class AbstractException extends RuntimeException {
    private static final long serialVersionUID = -6745724937886086306L;

    /**
     * message.
     *
     * @param message tips
     */
    public AbstractException(String message) {
        super(message);
    }

    /**
     * message、args.
     *
     * @param message String
     * @param args    Object...
     */
    public AbstractException(String message, Object... args) {
        super(StringKit.format(message, args));
    }

    /**
     * cause、message.
     *
     * @param message tips
     * @param cause   异常原因实例
     */
    public AbstractException(Throwable cause, String message) {
        super(message, cause);
    }


    /**
     * cause、message、args.
     *
     * @param message String
     * @param cause   Throwable
     * @param args    Object...
     */
    public AbstractException(Throwable cause, String message, Object... args) {
        super(StringKit.format(message, args), cause);
    }
}
