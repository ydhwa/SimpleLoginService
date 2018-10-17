package org.ydh.Exception;

public class UserIdNotSuitableException extends RuntimeException {

    private final ErrorCode ERR_CODE;

    public UserIdNotSuitableException(String msg, ErrorCode errCode) {
        super(msg);
        ERR_CODE = errCode;
    }

    public UserIdNotSuitableException(String msg) {
        this(msg, ErrorCode.USER_ID_NOT_SUITABLE);
    }

    public ErrorCode getErrCode() {
        return ERR_CODE;
    }
}
