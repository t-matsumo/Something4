package com.gmail.tatsukimatsumo.todojavamvvm.application.memo.save;

import com.gmail.tatsukimatsumo.todojavamvvm.application.memo.MemoRepository;
import com.gmail.tatsukimatsumo.todojavamvvm.domain.memo.Memo;

public class SaveUseCase {
    private MemoRepository repository;

    SaveUseCase(MemoRepository repository) {
        this.repository = repository;
    }

    void save(SaveCommand command) {
        Memo memo = new Memo(command.getContent());
        this.repository.save(memo);
    }
}
