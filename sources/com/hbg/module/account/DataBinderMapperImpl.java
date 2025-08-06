package com.hbg.module.account;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.b;
import androidx.databinding.f;
import java.util.ArrayList;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {

    /* renamed from: a  reason: collision with root package name */
    public static final SparseIntArray f77645a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(1);
        f77645a = sparseIntArray;
        sparseIntArray.put(R$layout.activity_account, 1);
    }

    public List<DataBinderMapper> a() {
        ArrayList arrayList = new ArrayList(6);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.hbg.lib.widgets.DataBinderMapperImpl());
        arrayList.add(new com.hbg.module.asset.DataBinderMapperImpl());
        arrayList.add(new com.hbg.module.huobi.im.DataBinderMapperImpl());
        arrayList.add(new com.hbg.module.libkt.DataBinderMapperImpl());
        arrayList.add(new com.hbg.module.share.DataBinderMapperImpl());
        return arrayList;
    }

    public f b(b bVar, View view, int i11) {
        int i12 = f77645a.get(i11);
        if (i12 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        } else if (i12 != 1) {
            return null;
        } else {
            if ("layout/activity_account_0".equals(tag)) {
                return new wb.b(bVar, view);
            }
            throw new IllegalArgumentException("The tag for activity_account is invalid. Received: " + tag);
        }
    }

    public f c(b bVar, View[] viewArr, int i11) {
        if (viewArr == null || viewArr.length == 0 || f77645a.get(i11) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
