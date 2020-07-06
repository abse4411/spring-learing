package com.boss.exception.eroor;

public enum ErrorResult implements IErrorResult{
    UNKNOWN_ERROR("E312","未知错误"),
    USER_NOT_FOUND("R323","用户不存在"),
    ACCESS_DENY("S423","用户名或密码错误"),
    Illegal_INPUT("R1242","非法输入");

    private String code;
    private String msg;

    ErrorResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public String code() {
        return code;
    }

    public String msg() {
        return msg;
    }
}
