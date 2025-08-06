package com.luck.picture.lib.interfaces;

import java.util.List;

public interface OnQueryAllAlbumListener<T> {
    void onComplete(List<T> list);
}
