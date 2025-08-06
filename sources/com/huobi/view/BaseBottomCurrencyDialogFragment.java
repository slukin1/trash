package com.huobi.view;

import com.huobi.otc.dialog.BaseFullBottomSheetFragment;

public abstract class BaseBottomCurrencyDialogFragment extends BaseFullBottomSheetFragment {
    public OnCurrencyMethodChangeCallback mCurrencyMethodChangedCallback;

    public interface OnCurrencyMethodChangeCallback {
        void onCurrencyMethodChanged(String str);
    }

    public void setOnCurrencyMethodChangeCallback(OnCurrencyMethodChangeCallback onCurrencyMethodChangeCallback) {
        this.mCurrencyMethodChangedCallback = onCurrencyMethodChangeCallback;
    }
}
