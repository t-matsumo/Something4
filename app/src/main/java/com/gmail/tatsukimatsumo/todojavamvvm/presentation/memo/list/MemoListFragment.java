package com.gmail.tatsukimatsumo.todojavamvvm.presentation.memo.list;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gmail.tatsukimatsumo.todojavamvvm.R;
import com.gmail.tatsukimatsumo.todojavamvvm.databinding.FragmentMemoListBinding;

public class MemoListFragment extends Fragment {
    private FragmentMemoListBinding dataBinding;
    private MemoListViewModel viewModel;

    public MemoListFragment() {
        // Required empty public constructor
    }

    public static MemoListFragment newInstance() {
        MemoListFragment fragment = new MemoListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_memo_list, container, false);
        viewModel = new ViewModelProvider(requireActivity(), new ViewModelProvider.NewInstanceFactory()).get(MemoListViewModel.class);
        dataBinding.setLifecycleOwner(this);
        dataBinding.setViewmodel(viewModel);
        viewModel.start();
        return dataBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        dataBinding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        dataBinding.recyclerView.setAdapter(new MemoListAdapter(viewModel));
    }
}