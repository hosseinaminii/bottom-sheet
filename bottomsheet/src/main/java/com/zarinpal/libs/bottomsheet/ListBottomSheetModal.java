package com.zarinpal.libs.bottomsheet;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Android BottomSheet Project at ZarinPal
 * Created by hosseinAmini on 11/29/17.
 * Copyright Hossein Amini All Rights Reserved.
 */

public abstract class ListBottomSheetModal<DataSetType> extends BottomSheetModal {

    private OnListBottomSheetItemClickListener<DataSetType> listener;
    private ListBottomSheetAdapter<DataSetType>             adapter;

    public ListBottomSheetModal(FragmentManager fm) {
        super(fm);
        this.adapter = new ListBottomSheetAdapter<>(this);

    }

    public void addItems(ArrayList<DataSetType> list) {
        this.adapter.swapData(list);
    }

    public void addItem(DataSetType... item) {
        this.adapter.addData(item);
    }


    public int getItemViewType(int position) {
        return -1;
    }


    public abstract RecyclerView.ViewHolder getViewHolder(View view, int viewType);

    public abstract void onBindViewHolder(RecyclerView.ViewHolder holder, int position, int viewType,
                                          DataSetType element);

    public abstract int getItemLayout(int viewType);

//    public abstract ArrayList<DataSetType> getItems();

    @Override
    public int getLayout() {
        return R.layout.list_bottom_sheet;
    }

    @Override
    public void getView(View view) {
        RecyclerView        recyclerView  = view.findViewById(R.id.bottom_sheet_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


    }

    public void setOnItemClickListener(OnListBottomSheetItemClickListener listener) {
        adapter.setOnItemClickListener(listener);
    }

}

