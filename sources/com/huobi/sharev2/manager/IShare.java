package com.huobi.sharev2.manager;

import android.graphics.Bitmap;
import androidx.fragment.app.FragmentActivity;
import com.huobi.sharev2.bean.ShareInfo;
import d10.l;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Unit;

public interface IShare {
    void doShare(String str);

    void newShareWithImages(Bitmap bitmap, String str, String str2);

    void newShareWithImages(Bitmap bitmap, String str, String str2, String str3);

    void newShareWithImages(ArrayList<Bitmap> arrayList, boolean z11, boolean z12, String str);

    void newShareWithImages(ArrayList<Bitmap> arrayList, boolean z11, boolean z12, String str, String str2);

    void newShareWithImages(ArrayList<Bitmap> arrayList, boolean z11, boolean z12, String str, Map<String, Object> map, ArrayList<String> arrayList2);

    void newShareWithPageId(String str, String str2, String str3);

    void newShareWithPageId(String str, String str2, ArrayList<Bitmap> arrayList, String str3, String str4, String str5, boolean z11, boolean z12, String str6, String str7, String str8, ArrayList<String> arrayList2, String str9, String str10);

    void newShareWithPageId(String str, String str2, ArrayList<Bitmap> arrayList, String str3, String str4, boolean z11, boolean z12, String str5, String str6, String str7, ArrayList<String> arrayList2, String str8);

    void newShareWithPageId(String str, String str2, ArrayList<Bitmap> arrayList, String str3, String str4, boolean z11, boolean z12, String str5, String str6, String str7, ArrayList<String> arrayList2, String str8, Map<String, Object> map, ArrayList<String> arrayList3, String str9);

    void newShareWithShareUrl(String str, String str2, String str3, String str4);

    void newShareWithShareUrl(String str, String str2, String str3, boolean z11, l<? super Integer, Unit> lVar);

    void newShareWithShareUrl(String str, String str2, ArrayList<Bitmap> arrayList, boolean z11, boolean z12, String str3);

    void newShareWithShareUrl(String str, String str2, ArrayList<Bitmap> arrayList, boolean z11, boolean z12, String str3, String str4);

    void newShareWithShareUrl(String str, String str2, ArrayList<Bitmap> arrayList, boolean z11, boolean z12, String str3, String str4, String str5, String str6, String str7);

    void newShareWithShareUrl(String str, String str2, ArrayList<Bitmap> arrayList, boolean z11, boolean z12, String str3, String str4, String str5, ArrayList<String> arrayList2, String str6);

    void newShareWithShareUrl(String str, String str2, ArrayList<Bitmap> arrayList, boolean z11, boolean z12, String str3, Map<String, Object> map, boolean z13);

    void newShareWithShareUrlV2(String str, String str2, ArrayList<Bitmap> arrayList, boolean z11, boolean z12, String str3, Map<String, Object> map, boolean z13, l<? super Integer, Unit> lVar);

    @Deprecated
    void share(FragmentActivity fragmentActivity, ShareInfo shareInfo);

    void shareGroup(String str, ArrayList<Bitmap> arrayList, Map<String, Object> map);
}
