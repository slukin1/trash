package com.hbg.module.libkt;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.b;
import androidx.databinding.f;
import java.util.ArrayList;
import java.util.List;
import te.d;
import te.h;

public class DataBinderMapperImpl extends DataBinderMapper {

    /* renamed from: a  reason: collision with root package name */
    public static final SparseIntArray f24497a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(4);
        f24497a = sparseIntArray;
        sparseIntArray.put(R$layout.dialog_button, 1);
        sparseIntArray.put(R$layout.feed_vod_load_error, 2);
        sparseIntArray.put(R$layout.feed_vod_loading, 3);
        sparseIntArray.put(R$layout.view_video, 4);
    }

    public List<DataBinderMapper> a() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.hbg.lib.widgets.DataBinderMapperImpl());
        return arrayList;
    }

    public f b(b bVar, View view, int i11) {
        int i12 = f24497a.get(i11);
        if (i12 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        } else if (i12 != 1) {
            if (i12 != 2) {
                if (i12 != 3) {
                    if (i12 != 4) {
                        return null;
                    }
                    if ("layout/view_video_0".equals(tag)) {
                        return new h(bVar, view);
                    }
                    throw new IllegalArgumentException("The tag for view_video is invalid. Received: " + tag);
                } else if ("layout/feed_vod_loading_0".equals(tag)) {
                    return new te.f(bVar, view);
                } else {
                    throw new IllegalArgumentException("The tag for feed_vod_loading is invalid. Received: " + tag);
                }
            } else if ("layout/feed_vod_load_error_0".equals(tag)) {
                return new d(bVar, view);
            } else {
                throw new IllegalArgumentException("The tag for feed_vod_load_error is invalid. Received: " + tag);
            }
        } else if ("layout/dialog_button_0".equals(tag)) {
            return new te.b(bVar, view);
        } else {
            throw new IllegalArgumentException("The tag for dialog_button is invalid. Received: " + tag);
        }
    }

    public f c(b bVar, View[] viewArr, int i11) {
        if (viewArr == null || viewArr.length == 0 || f24497a.get(i11) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
