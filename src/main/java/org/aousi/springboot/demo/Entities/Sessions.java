package org.aousi.springboot.demo.Entities;

public class Sessions {
    private Integer id;

    private byte[] sessionId;

    private byte[] sessionBody;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getSessionId() {
        return sessionId;
    }

    public void setSessionId(byte[] sessionId) {
        this.sessionId = sessionId;
    }

    public byte[] getSessionBody() {
        return sessionBody;
    }

    public void setSessionBody(byte[] sessionBody) {
        this.sessionBody = sessionBody;
    }
}