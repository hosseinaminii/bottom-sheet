package com.zarinpal.bottomsheet;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.zarinpal.libs.bottomsheet.ListBottomSheetModal;

import java.util.ArrayList;

/**
 * Android BottomSheet Project at ZarinPal
 * Created by hosseinAmini on 12/10/17.
 * Copyright Hossein Amini All Rights Reserved.
 */

public class PurseBottomSheetModal extends ListBottomSheetModal<PurseModel> {

    @Override
    public RecyclerView.ViewHolder getViewHolder(View view, int viewType) {
        return new PurseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, int viewType, PurseModel element) {
        PurseViewHolder purseViewHolder = (PurseViewHolder)holder;

        purseViewHolder.txtName.setText(element.getName());
        purseViewHolder.txtBalance.setText(element.getBalance());

    }

    @Override
    public int getItemLayout(int viewType) {
        return R.layout.bottome_sheet_item;
    }

    @Override
    public ArrayList<PurseModel> getItems() {
        ArrayList<PurseModel> purses = new ArrayList<>();
        for(int i = 0; i < 100; i++) {
            PurseModel purse = new PurseModel();
            purse.setName("Name: " + i);
            purse.setBalance("Balance: " + i);

            purses.add(purse);
        }


        return purses;
    }

    class PurseViewHolder extends RecyclerView.ViewHolder {

        TextView txtName, txtBalance;

        public PurseViewHolder(View itemView) {
            super(itemView);
            this.txtName = itemView.findViewById(R.id.txtName);
            this.txtBalance = itemView.findViewById(R.id.txtBalance);
        }
    }
}
