package com.ys.caobao.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ys.caobao.R;
import com.ys.caobao.adapter.RecyclerAdapter;
import com.ys.caobao.model.RecyclerHolder;
import com.ys.caobao.util.ViewUtil;

import java.util.ArrayList;
import java.util.List;

public class ShopFragment extends Fragment{
    private View view;
    //
    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private List<String> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_shop, null);
        init();
        initData();
        return view;
    }

    private void initData() {
        list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        adapter = new RecyclerAdapter<String>(getActivity(), list, R.layout.item_shop) {
            @Override
            public void convert(RecyclerHolder holder, String item) {

            }
        };
        recyclerView = ViewUtil.getVRows(getActivity(), recyclerView, 1);
        recyclerView.setAdapter(adapter);
    }

    private void init() {
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
    }

}
