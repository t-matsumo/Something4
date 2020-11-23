package com.gmail.tatsukimatsumo.todojavamvvm.infrastructure.memo;

import com.gmail.tatsukimatsumo.todojavamvvm.application.memo.MemoRepository;
import com.gmail.tatsukimatsumo.todojavamvvm.domain.memo.Memo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class InMemoryMemoRepository implements MemoRepository {
    private List<Memo> data = new ArrayList<>();

    public InMemoryMemoRepository() {
        for (int i = 0; i < 100; i++) {
            data.add(new Memo("contentscontentscontentscontentscontents" + i));
        }
    }

    @Override
    public void save(Memo memo) {
        data.add(deepCopy(memo));
    }

    @Override
    public List<Memo> getAll() {
        List<Memo> memoList = new ArrayList<>(data.size());
        for (Memo m : data) {
            memoList.add(deepCopy(m));
        }
        return memoList;
    }

    private Memo deepCopy(Memo memo) {
        return new Memo(memo.getContent());
    }

}
