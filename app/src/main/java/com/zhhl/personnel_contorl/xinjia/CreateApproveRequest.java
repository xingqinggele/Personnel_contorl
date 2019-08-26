package com.zhhl.personnel_contorl.xinjia;

/**
 * Created by miao on 2018/10/8.
 */
public class CreateApproveRequest {

    /**
     * success : true
     * msg : 操作成功
     * obj : null
     * attributes : null
     */

    private boolean success;
    private String msg;
    private Object obj;
    private Object attributes;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public Object getAttributes() {
        return attributes;
    }

    public void setAttributes(Object attributes) {
        this.attributes = attributes;
    }
}
