package com.jskj.audiotransform5.event;

public class AsrSelectEvent {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



    public AsrSelectEvent(String str){
        message = str;
    }


}
