package com.gmail.tatsukimatsumo.todojavamvvm.presentation.memo.list;

import com.gmail.tatsukimatsumo.todojavamvvm.application.memo.MemoData;
import com.gmail.tatsukimatsumo.todojavamvvm.application.memo.showAll.ShowAllUseCase;
import com.gmail.tatsukimatsumo.todojavamvvm.application.memo.showAll.ShowAllUseCaseFactory;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MemoListViewModel extends ViewModel {
    private ShowAllUseCase showAllUseCase = ShowAllUseCaseFactory.create();

    private MutableLiveData<List<MemoData>> memoList = new MutableLiveData<>();
    LiveData<List<MemoData>> getMemoList() {
        return memoList;
    }

    private MutableLiveData<MemoData> transitToDetailEvent = new MutableLiveData<>();
    LiveData<MemoData> getTransitToDetailEvent() {
        return transitToDetailEvent;
    }

    public void start() {
        List<MemoData> memoDataList = showAllUseCase.showAll();
        memoList.setValue(memoDataList);
    }

    public void transitToDetail(MemoData memo) {
        transitToDetailEvent.setValue(memo);
    }
}
