package com.zarinpal.libs.bottomsheet;

import android.annotation.SuppressLint;
import android.app.Dialog;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.fragment.app.FragmentManager;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.view.View;

/**
 * Android BottomSheet Project at ZarinPal
 * Created by hosseinAmini on 11/29/17.
 * Copyright Hossein Amini All Rights Reserved.
 */

public abstract class BottomSheetModal extends BottomSheetDialogFragment {

    private FragmentManager fragmentManager;

    public BottomSheetModal(FragmentManager fm) {
        this.fragmentManager = fm;
    }

    @LayoutRes
    public abstract int getLayout();

    public abstract void getView(View view);

    @SuppressLint("RestrictedApi")
    @Override
    public void setupDialog(Dialog dialog, int style) {
        super.setupDialog(dialog, style);

        View view = View.inflate(getContext(), getLayout(), null);
        dialog.setContentView(view);

        if (getHeight() != -1) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from((View) view.getParent());
            bottomSheetBehavior.setPeekHeight(getHeight());
        }

        if (isMakeTransparent()) {
            ((View) view.getParent()).setBackgroundColor(ContextCompat.getColor(getContext(), android.R.color.transparent));
        }

        getView(view);
    }

    protected int getHeight() {
        return -1;
    }

    public boolean isMakeTransparent() {
        return false;
    }

    public void show() {
        super.show(this.fragmentManager, getClass().getName());
    }
}
