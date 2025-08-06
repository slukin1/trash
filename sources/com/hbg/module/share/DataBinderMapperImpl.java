package com.hbg.module.share;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.b;
import androidx.databinding.f;
import java.util.ArrayList;
import java.util.List;
import yf.d;

public class DataBinderMapperImpl extends DataBinderMapper {

    /* renamed from: a  reason: collision with root package name */
    public static final SparseIntArray f37425a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(3);
        f37425a = sparseIntArray;
        sparseIntArray.put(R$layout.activity_feed_share, 1);
        sparseIntArray.put(R$layout.activity_group_share, 2);
        sparseIntArray.put(R$layout.item_share_group, 3);
    }

    public List<DataBinderMapper> a() {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.hbg.lib.widgets.DataBinderMapperImpl());
        arrayList.add(new com.hbg.module.libkt.DataBinderMapperImpl());
        return arrayList;
    }

    public f b(b bVar, View view, int i11) {
        int i12 = f37425a.get(i11);
        if (i12 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        } else if (i12 != 1) {
            if (i12 != 2) {
                if (i12 != 3) {
                    return null;
                }
                if ("layout/item_share_group_0".equals(tag)) {
                    return new yf.f(bVar, view);
                }
                throw new IllegalArgumentException("The tag for item_share_group is invalid. Received: " + tag);
            } else if ("layout/activity_group_share_0".equals(tag)) {
                return new d(bVar, view);
            } else {
                throw new IllegalArgumentException("The tag for activity_group_share is invalid. Received: " + tag);
            }
        } else if ("layout/activity_feed_share_0".equals(tag)) {
            return new yf.b(bVar, view);
        } else {
            throw new IllegalArgumentException("The tag for activity_feed_share is invalid. Received: " + tag);
        }
    }

    public f c(b bVar, View[] viewArr, int i11) {
        if (viewArr == null || viewArr.length == 0 || f37425a.get(i11) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
