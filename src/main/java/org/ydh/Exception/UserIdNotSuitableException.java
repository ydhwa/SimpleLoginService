package org.ydh.Exception;

public class UserIdNotSuitableException extends RuntimeException {

    private final int ERR_CODE;

    public UserIdNotSuitableException(String msg, int errCode) {
        super(msg);
        ERR_CODE = errCode;
    }

    public UserIdNotSuitableException(String msg) {
        this(msg, 201);
    }

    public int getErrCode() {
        return ERR_CODE;
    }
}
