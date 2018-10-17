package org.ydh.Exception;

public class PasswordNotSuitableException extends RuntimeException {

    private final ErrorCode ERR_CODE;

    public PasswordNotSuitableException(String msg, ErrorCode errCode) {
        super(msg);
        ERR_CODE = errCode;
    }

    public PasswordNotSuitableException(String msg) {
        this(msg, ErrorCode.PASSWORD_NOT_SUITAblE);
    }

    public ErrorCode getErrCode() {
        return ERR_CODE;
    }
}
