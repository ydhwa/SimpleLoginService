package org.ydh.Exception;

public class PasswordNotSuitableException extends RuntimeException {

    private final int ERR_CODE;

    public PasswordNotSuitableException(String msg, int errCode) {
        super(msg);
        ERR_CODE = errCode;
    }

    public PasswordNotSuitableException(String msg) {
        this(msg, 202);
    }

    public int getErrCode() {
        return ERR_CODE;
    }
}
