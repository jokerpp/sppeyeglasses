package com.jskj.audiotransform5.event;

public class OpenSubtitleEvent {
    private String message;

    public OpenSubtitleEvent(String string){
        message = string;
    }
    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

}
