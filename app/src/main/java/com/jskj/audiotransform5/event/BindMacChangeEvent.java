package com.jskj.audiotransform5.event;

public class BindMacChangeEvent {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



    public BindMacChangeEvent(String str){
        message = str;
    }


}
