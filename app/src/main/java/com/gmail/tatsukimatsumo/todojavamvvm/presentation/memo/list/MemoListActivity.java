package com.gmail.tatsukimatsumo.todojavamvvm.presentation.memo.list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import com.gmail.tatsukimatsumo.todojavamvvm.R;
import com.gmail.tatsukimatsumo.todojavamvvm.application.memo.MemoData;
import com.gmail.tatsukimatsumo.todojavamvvm.presentation.memo.detail.MemoDetailActivity;

public class MemoListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo_list);

        setupFragment();

        MemoListViewModel viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(MemoListViewModel.class);
        viewModel.getTransitToDetailEvent().observe(this, this::transitToDetail);
    }

    private void setupFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, MemoListFragment.newInstance())
                .commit();
    }


    void transitToDetail(MemoData memo) {
        Intent intent = MemoDetailActivity.getIntent(getApplicationContext(), memo);
        startActivity(intent);
    }
}