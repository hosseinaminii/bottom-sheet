package com.zarinpal.libs.bottomsheet;

/**
 * Android BottomSheet Project at ZarinPal
 * Created by hosseinAmini on 11/29/17.
 * Copyright Hossein Amini All Rights Reserved.
 */

public interface OnListBottomSheetItemClickListener<DataSetType> {
    void onListBottomSheetItemClick(DataSetType element, int position, int viewType);
}
