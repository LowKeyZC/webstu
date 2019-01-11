package com.zc.webstu.common;

public enum Result {

    /**
     * 成功
     */
    SUCCESS("200","成功"),

    /**
     * 无此用户
     */
    NOUSER("1001","无此用户"),

    /**
     * 密码错误
     */
    WRONGPWD("1002","密码错误"),

    /**
     * 余额不足
     */
    NOMONEY("1003", "余额不足");

    private String code;

    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    Result(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
