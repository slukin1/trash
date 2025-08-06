package com.business.common;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.b;
import androidx.databinding.f;
import i4.d;
import i4.h;
import i4.j;
import i4.l;
import i4.n;
import java.util.ArrayList;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {

    /* renamed from: a  reason: collision with root package name */
    public static final SparseIntArray f64267a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(7);
        f64267a = sparseIntArray;
        sparseIntArray.put(R$layout.dialog_fragment_airdrop_claim, 1);
        sparseIntArray.put(R$layout.dialog_fragment_airdrop_result, 2);
        sparseIntArray.put(R$layout.dialog_fragment_red_packet_tips, 3);
        sparseIntArray.put(R$layout.item_airdrop_gift, 4);
        sparseIntArray.put(R$layout.item_airdrop_symbol, 5);
        sparseIntArray.put(R$layout.view_airdrop, 6);
        sparseIntArray.put(R$layout.view_swap_zero_side, 7);
    }

    public List<DataBinderMapper> a() {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.hbg.lib.widgets.DataBinderMapperImpl());
        arrayList.add(new com.hbg.module.libkt.DataBinderMapperImpl());
        return arrayList;
    }

    public f b(b bVar, View view, int i11) {
        int i12 = f64267a.get(i11);
        if (i12 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag != null) {
            switch (i12) {
                case 1:
                    if ("layout/dialog_fragment_airdrop_claim_0".equals(tag)) {
                        return new i4.b(bVar, view);
                    }
                    throw new IllegalArgumentException("The tag for dialog_fragment_airdrop_claim is invalid. Received: " + tag);
                case 2:
                    if ("layout/dialog_fragment_airdrop_result_0".equals(tag)) {
                        return new d(bVar, view);
                    }
                    throw new IllegalArgumentException("The tag for dialog_fragment_airdrop_result is invalid. Received: " + tag);
                case 3:
                    if ("layout/dialog_fragment_red_packet_tips_0".equals(tag)) {
                        return new i4.f(bVar, view);
                    }
                    throw new IllegalArgumentException("The tag for dialog_fragment_red_packet_tips is invalid. Received: " + tag);
                case 4:
                    if ("layout/item_airdrop_gift_0".equals(tag)) {
                        return new h(bVar, view);
                    }
                    throw new IllegalArgumentException("The tag for item_airdrop_gift is invalid. Received: " + tag);
                case 5:
                    if ("layout/item_airdrop_symbol_0".equals(tag)) {
                        return new j(bVar, view);
                    }
                    throw new IllegalArgumentException("The tag for item_airdrop_symbol is invalid. Received: " + tag);
                case 6:
                    if ("layout/view_airdrop_0".equals(tag)) {
                        return new l(bVar, view);
                    }
                    throw new IllegalArgumentException("The tag for view_airdrop is invalid. Received: " + tag);
                case 7:
                    if ("layout/view_swap_zero_side_0".equals(tag)) {
                        return new n(bVar, view);
                    }
                    throw new IllegalArgumentException("The tag for view_swap_zero_side is invalid. Received: " + tag);
                default:
                    return null;
            }
        } else {
            throw new RuntimeException("view must have a tag");
        }
    }

    public f c(b bVar, View[] viewArr, int i11) {
        if (viewArr == null || viewArr.length == 0 || f64267a.get(i11) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
