package com.example.websocketdemo.config;


/**
 * Created by Vignesh on 25/03/20.
 */
public class Message {
    private String number;
    private String content;
    private String sender;

    public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}   

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
