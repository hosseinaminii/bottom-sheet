package com.zarinpal.libs.bottomsheet;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Android BottomSheet Project at ZarinPal
 * Created by hosseinAmini on 11/29/17.
 * Copyright Hossein Amini All Rights Reserved.
 */

class ListBottomSheetAdapter<DataSetType> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ListBottomSheetModal               listBottomSheetModal;
    private OnListBottomSheetItemClickListener listener;
    private ArrayList<DataSetType>             items;

    public ListBottomSheetAdapter(ListBottomSheetModal listBottomSheetModal) {
        this.listBottomSheetModal = listBottomSheetModal;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(listBottomSheetModal.getItemLayout(viewType), parent, false);
        return listBottomSheetModal.getViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        final DataSetType element  = this.items.get(position);
        final int         viewType = holder.getItemViewType();
        this.listBottomSheetModal.onBindViewHolder(holder, position, holder.getItemViewType(),
                element);
        if (this.listener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onListBottomSheetItemClick(element, position, viewType);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void swapData(ArrayList<DataSetType> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnListBottomSheetItemClickListener listener) {
        this.listener = listener;
    }

}
