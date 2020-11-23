package com.gmail.tatsukimatsumo.todojavamvvm.application.memo.save;

public class SaveCommand {
    private String content;

    SaveCommand(String content) {
        this.content = content;
    }

    String getContent() {
        return this.content;
    }
}
