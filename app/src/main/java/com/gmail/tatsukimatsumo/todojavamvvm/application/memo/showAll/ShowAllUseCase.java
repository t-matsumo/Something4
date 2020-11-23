package com.gmail.tatsukimatsumo.todojavamvvm.application.memo.showAll;

import com.gmail.tatsukimatsumo.todojavamvvm.application.memo.MemoData;
import com.gmail.tatsukimatsumo.todojavamvvm.application.memo.MemoRepository;
import com.gmail.tatsukimatsumo.todojavamvvm.domain.memo.Memo;

import java.util.ArrayList;
import java.util.List;

public class ShowAllUseCase {
    private MemoRepository repository;

    ShowAllUseCase(MemoRepository repository) {
        this.repository = repository;
    }

    public List<MemoData> showAll() {
        List<Memo> memoList = repository.getAll();

        List<MemoData> dataList = new ArrayList<>(memoList.size());
        for (Memo m : memoList) {
            dataList.add(new MemoData(m));
        }
        return dataList;
    }
}
