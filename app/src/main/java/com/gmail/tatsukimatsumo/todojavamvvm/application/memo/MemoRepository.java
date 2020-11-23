package com.gmail.tatsukimatsumo.todojavamvvm.application.memo;

import com.gmail.tatsukimatsumo.todojavamvvm.domain.memo.Memo;

import java.util.List;

public interface MemoRepository {
    void save(Memo memo);
    List<Memo> getAll();
}
