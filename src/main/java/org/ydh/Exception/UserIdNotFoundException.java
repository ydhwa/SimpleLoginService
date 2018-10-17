package org.ydh.Exception;

public class UserIdNotFoundException extends RuntimeException {

    private final ErrorCode ERR_CODE;

    public UserIdNotFoundException(String msg, ErrorCode errCode) {
        super(msg);
        ERR_CODE = errCode;
    }

    public UserIdNotFoundException(String msg) {
        this(msg, ErrorCode.USER_ID_NOT_FOUND);
    }

    public ErrorCode getErrCode() {
        return ERR_CODE;
    }
}
