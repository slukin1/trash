package com.luck.picture.lib.interfaces;

import java.util.List;

public interface OnQueryDataSourceListener<T> {
    void onComplete(List<T> list);
}
