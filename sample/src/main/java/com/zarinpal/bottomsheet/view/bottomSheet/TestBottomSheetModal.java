package com.zarinpal.bottomsheet.view.bottomSheet;

import android.annotation.SuppressLint;

import androidx.fragment.app.FragmentManager;

import android.view.View;
import android.widget.TextView;

import com.zarinpal.bottomsheet.R;
import com.zarinpal.bottomsheet.model.PurseModel;
import com.zarinpal.libs.bottomsheet.ListBottomSheetModal;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Android BottomSheet Project at ZarinPal
 * Created by hosseinAmini on 12/10/17.
 * Copyright Hossein Amini All Rights Reserved.
 */

@SuppressLint("ValidFragment")
public class TestBottomSheetModal extends ListBottomSheetModal<PurseModel> {

    public TestBottomSheetModal(FragmentManager fm) {
        super(fm);
    }

    @Override
    public RecyclerView.ViewHolder getViewHolder(View view, int viewType) {
        return new PurseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, int viewType, PurseModel element) {
        PurseViewHolder purseViewHolder = (PurseViewHolder) holder;
        purseViewHolder.txtTitle.setText(element.getName());

    }

    @Override
    public int getItemLayout(int viewType) {
        return R.layout.bottome_sheet_item;
    }


    class PurseViewHolder extends RecyclerView.ViewHolder {

        TextView txtTitle;

        public PurseViewHolder(View itemView) {
            super(itemView);
            this.txtTitle = itemView.findViewById(R.id.txt_title);
        }
    }
}
