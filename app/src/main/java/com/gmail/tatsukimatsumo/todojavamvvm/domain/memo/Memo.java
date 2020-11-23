package com.gmail.tatsukimatsumo.todojavamvvm.domain.memo;

public class Memo {
    private String content;

    public Memo(String content) {
        setContent(content);
    }

    public String getContent() {
        return this.content;
    }

    void setContent(String content) {
        if (content == null) {
            new IllegalStateException("conetnt should not be null");
        }

        this.content = content;
    }
}
