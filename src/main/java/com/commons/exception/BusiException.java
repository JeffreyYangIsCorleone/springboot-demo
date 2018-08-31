package com.commons.exception;

public class BusiException extends RuntimeException{

    private static final long serialVersionUID = -274762633056259205L;

    private int code;

    private String msg;

    public BusiException(int code, String msg, Exception e) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public BusiException(int code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

//    public BusiException(int code) {
//        super();
//        this.code = code;
//        this.msg = String.valueOf(Code.errorMap.get(code));
//    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
