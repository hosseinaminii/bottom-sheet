package com.zarinpal.bottomsheet.view.bottomSheet;

import android.annotation.SuppressLint;
import android.view.View;

import com.zarinpal.bottomsheet.R;
import com.zarinpal.libs.bottomsheet.BottomSheetModal;

import androidx.fragment.app.FragmentManager;

/**
 * Created by Farshid Roohi.
 * bottom-sheet | Copyrights 12/25/18.
 */
@SuppressLint("ValidFragment")
public class BottomSheetTransparentModal extends BottomSheetModal {

    public BottomSheetTransparentModal(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getLayout() {
        return R.layout.bottom_sheet_test;
    }

    @Override
    public void getView(View view) {

    }

    @Override
    public boolean isMakeTransparent() {
        return true;
    }
}
