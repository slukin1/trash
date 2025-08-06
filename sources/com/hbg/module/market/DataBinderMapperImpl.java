package com.hbg.module.market;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.b;
import androidx.databinding.f;
import java.util.ArrayList;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {

    /* renamed from: a  reason: collision with root package name */
    public static final SparseIntArray f26687a = new SparseIntArray(0);

    public List<DataBinderMapper> a() {
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.hbg.lib.widgets.DataBinderMapperImpl());
        arrayList.add(new com.hbg.module.content.DataBinderMapperImpl());
        arrayList.add(new com.hbg.module.libkt.DataBinderMapperImpl());
        return arrayList;
    }

    public f b(b bVar, View view, int i11) {
        if (f26687a.get(i11) <= 0 || view.getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    public f c(b bVar, View[] viewArr, int i11) {
        if (viewArr == null || viewArr.length == 0 || f26687a.get(i11) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
