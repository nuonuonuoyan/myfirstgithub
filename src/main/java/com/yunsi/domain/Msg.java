package com.yunsi.domain;

//返回给客户端的对象
public class Msg {
    int code;//用于标识是否识别成功，0为失败，1为成功
    String msg;//用于记录车牌信息

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
