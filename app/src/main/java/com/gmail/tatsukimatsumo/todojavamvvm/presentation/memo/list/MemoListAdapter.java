package com.gmail.tatsukimatsumo.todojavamvvm.presentation.memo.list;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.gmail.tatsukimatsumo.todojavamvvm.R;
import com.gmail.tatsukimatsumo.todojavamvvm.application.memo.MemoData;
import com.gmail.tatsukimatsumo.todojavamvvm.databinding.MemoListItemBinding;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class MemoListAdapter extends RecyclerView.Adapter<MemoListAdapter.MemoViewHolder> {
    private MemoListViewModel viewModel;

    class MemoViewHolder extends RecyclerView.ViewHolder {
        private MemoListItemBinding dataBinding;

        public MemoViewHolder(MemoListItemBinding binding) {
            super(binding.getRoot());
            dataBinding = binding;
        }

        void setItem(MemoData memo) {
            dataBinding.setMemo(memo);
        }
    }

    MemoListAdapter(MemoListViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public MemoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        MemoListItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.memo_list_item, parent, false);
        binding.setViewmodel(viewModel);
        return new MemoViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MemoViewHolder holder, int position) {
        holder.setItem(Objects.requireNonNull(viewModel.getMemoList().getValue()).get(position));
    }

    @Override
    public int getItemCount() {
        return Objects.requireNonNull(viewModel.getMemoList().getValue()).size();
    }
}
