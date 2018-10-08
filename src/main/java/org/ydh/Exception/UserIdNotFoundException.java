package org.ydh.Exception;

public class UserIdNotFoundException extends RuntimeException {

    private final int ERR_CODE;

    public UserIdNotFoundException(String msg, int errCode) {
        super(msg);
        ERR_CODE = errCode;
    }

    public UserIdNotFoundException(String msg) {
        this(msg, 101);
    }

    public int getErrCode() {
        return ERR_CODE;
    }
}
