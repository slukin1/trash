package com.luck.picture.lib.interfaces;

import java.util.ArrayList;

public interface OnResultCallbackListener<T> {
    void onCancel();

    void onResult(ArrayList<T> arrayList);
}
