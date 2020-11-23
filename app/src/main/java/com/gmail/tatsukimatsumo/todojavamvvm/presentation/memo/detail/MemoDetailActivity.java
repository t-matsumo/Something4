package com.gmail.tatsukimatsumo.todojavamvvm.presentation.memo.detail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.gmail.tatsukimatsumo.todojavamvvm.R;
import com.gmail.tatsukimatsumo.todojavamvvm.application.memo.MemoData;

public class MemoDetailActivity extends AppCompatActivity {

    private static final String EXTRA_MEMO = "EXTRA_MEMO";

    public static Intent getIntent(Context context, MemoData memo) {
        Intent intent = new Intent(context, MemoDetailActivity.class);
        intent.putExtra(EXTRA_MEMO, memo);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo_detail);
    }


}