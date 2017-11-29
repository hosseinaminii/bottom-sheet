package com.zarinpal.libs.bottomsheet;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.View;

/**
 * Android BottomSheet Project at ZarinPal
 * Created by hosseinAmini on 11/29/17.
 * Copyright Hossein Amini All Rights Reserved.
 */

public abstract class BottomSheetModal extends BottomSheetDialogFragment {

    public abstract int getLayout();
    public abstract void getView(View view);

    @SuppressLint("RestrictedApi")
    @Override
    public void setupDialog(Dialog dialog, int style) {
        super.setupDialog(dialog, style);

        View view = View.inflate(getContext(), getLayout(), null);
        dialog.setContentView(view);

        if(getHeight() != -1) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from((View) view.getParent());
            bottomSheetBehavior.setPeekHeight(getHeight());
        }

        getView(view);
    }

    protected int getHeight() {
        return -1;
    }

}
