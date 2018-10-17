package org.ydh.Exception;

public class AlreadyUserIdExistException extends RuntimeException {

    private final ErrorCode ERR_CODE;

    public AlreadyUserIdExistException(String msg, ErrorCode errCode) {
        super(msg);
        ERR_CODE = errCode;
    }

    public AlreadyUserIdExistException(String msg) {
        this(msg, ErrorCode.ALREADY_USER_ID_EXIST);
    }

    public ErrorCode getErrCode() {
        return ERR_CODE;
    }
}
