package org.ydh.Exception;

public class AlreadyUserIdExistException extends RuntimeException {

    private final int ERR_CODE;

    public AlreadyUserIdExistException(String msg, int errCode) {
        super(msg);
        ERR_CODE = errCode;
    }

    public AlreadyUserIdExistException(String msg) {
        this(msg, 102);
    }

    public int getErrCode() {
        return ERR_CODE;
    }
}
