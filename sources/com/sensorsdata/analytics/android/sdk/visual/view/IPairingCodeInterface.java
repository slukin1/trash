package com.sensorsdata.analytics.android.sdk.visual.view;

interface IPairingCodeInterface {

    public interface OnPairingCodeChangedListener {
        void onInputCompleted(CharSequence charSequence);

        void onPairingCodeChanged(CharSequence charSequence, int i11, int i12, int i13);
    }

    void setBottomLineHeight(int i11);

    void setBottomNormalColor(int i11);

    void setBottomSelectedColor(int i11);

    void setFigures(int i11);

    void setOnPairingCodeChangedListener(OnPairingCodeChangedListener onPairingCodeChangedListener);

    void setPairingCodeMargin(int i11);

    void setSelectedBackgroundColor(int i11);
}
