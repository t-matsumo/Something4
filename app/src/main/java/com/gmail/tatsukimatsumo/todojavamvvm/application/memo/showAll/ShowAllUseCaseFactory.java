package com.gmail.tatsukimatsumo.todojavamvvm.application.memo.showAll;

import com.gmail.tatsukimatsumo.todojavamvvm.infrastructure.memo.InMemoryMemoRepository;

public class ShowAllUseCaseFactory {
    public static ShowAllUseCase create() {
        return new ShowAllUseCase(new InMemoryMemoRepository());
    }
}
