package com.luck.picture.lib.entity;

import java.util.ArrayList;

public class MediaData {
    public ArrayList<LocalMedia> data;
    public boolean isHasNextMore;

    public MediaData() {
    }

    public MediaData(boolean z11, ArrayList<LocalMedia> arrayList) {
        this.isHasNextMore = z11;
        this.data = arrayList;
    }
}
