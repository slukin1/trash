package com.huobi.provider;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.zxing.client.android.utils.CodeUtils;
import com.hbg.lib.network.hbg.core.bean.ShareConfig;
import com.hbg.lib.network.pro.core.bean.ChainInfo;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.base.ext.b;
import com.hbg.module.libkt.base.ext.c;
import com.hbg.module.libkt.provider.HbgBaseShareProvider;
import com.huobi.R$drawable;
import com.huobi.sharev2.manager.ShareManager;
import com.tencent.imsdk.v2.V2TIMConversation;
import d10.l;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Unit;
import pro.huobi.R;
import yl.a;

@Route(path = "/provider/share/h5")
public class HbgShareProver implements HbgBaseShareProvider {
    public static /* synthetic */ void v(View view, FragmentActivity fragmentActivity, String str, boolean z11) {
        Bitmap f11 = a.f(view, fragmentActivity, view.getMeasuredWidth(), view.getMeasuredHeight());
        ArrayList arrayList = new ArrayList();
        arrayList.add(f11);
        HashMap hashMap = new HashMap();
        hashMap.put(V2TIMConversation.CONVERSATION_GROUP_TYPE, ag.a.b("", "", "", "", "", "", 6, str, "", 0, 0, ""));
        hashMap.put("community", ag.a.b("", "", "", "", "", "", 6, str, "", 0, 0, ""));
        ShareManager.getInstance().shareGroup(str, arrayList, hashMap);
    }

    public static /* synthetic */ Unit w(View view, String str, TextView textView, FragmentActivity fragmentActivity, String str2, String str3, ShareConfig shareConfig) {
        ((ImageView) view.findViewById(R.id.ivQr)).setImageBitmap(CodeUtils.createImage(shareConfig.getQrCodeUrl(), c.a(110.0f), c.a(110.0f), CodeUtils.drawableToBitmap(R$drawable.icon)));
        if (!b.x(str)) {
            textView.setVisibility(0);
            textView.setText(String.format(fragmentActivity.getResources().getString(R.string.n_content_im_group_invitation_code), new Object[]{str}));
        }
        cf.a.f26395a.b((ImageView) view.findViewById(R.id.ivGroupIcon), str2, new lq.a(view, fragmentActivity, str3), true);
        return null;
    }

    public static /* synthetic */ Unit x(Throwable th2, APIStatusErrorException aPIStatusErrorException) {
        if (aPIStatusErrorException == null) {
            return null;
        }
        HuobiToastUtil.i(aPIStatusErrorException.getErrMsg());
        return null;
    }

    public void b(FragmentActivity fragmentActivity, String str, String str2, String str3, String str4, String str5, String str6, int i11, l<? super Integer, Unit> lVar) {
        HashMap hashMap = new HashMap();
        String str7 = str6;
        String str8 = str;
        int i12 = i11;
        String str9 = str3;
        String str10 = str5;
        hashMap.put(V2TIMConversation.CONVERSATION_GROUP_TYPE, ag.a.b("", "", str7, "", "", str8, i12, str9, str10, 0, 0, fragmentActivity.getResources().getString(R.string.n_user_center_community_dynamic)));
        hashMap.put("community", ag.a.b("", "", str7, "", "", str8, i12, str9, str10, 0, 0, str4));
        ShareManager.getInstance().newShareWithShareUrlV2(str3, str, (ArrayList<Bitmap>) null, true, false, str4, hashMap, true, lVar);
    }

    public void f(FragmentActivity fragmentActivity, View view, String str, String str2, String str3) {
        Bitmap e11 = a.e(view, fragmentActivity);
        ArrayList arrayList = new ArrayList();
        arrayList.add(e11);
        ShareManager.getInstance().newShareWithImages((ArrayList<Bitmap>) arrayList, false, false, "");
    }

    public void h(FragmentActivity fragmentActivity, View view, String str, String str2, String str3, String str4, String str5, int i11, int i12) {
        Bitmap f11 = a.f(view, fragmentActivity, i11, i12);
        ArrayList arrayList = new ArrayList();
        arrayList.add(f11);
        HashMap hashMap = new HashMap();
        String str6 = str;
        String str7 = str4;
        String str8 = str2;
        String str9 = str3;
        String str10 = str5;
        hashMap.put(V2TIMConversation.CONVERSATION_GROUP_TYPE, ag.a.b("", "", str6, "", "", str7, 6, str8, str9, 0, 0, str10));
        hashMap.put("community", ag.a.b("", "", str6, "", "", str7, 6, str8, str9, 0, 0, str10));
        ShareManager.getInstance().newShareWithShareUrl(str2, str4, arrayList, true, false, ChainInfo.CHAIN_TYPE_LIVE, hashMap, false);
    }

    public void init(Context context) {
    }

    public void k(FragmentActivity fragmentActivity, View view, int i11, int i12, String str, String str2, String str3) {
        ShareManager.getInstance().newShareWithImages(a.f(view, fragmentActivity, i11, i12), str, str2, str3);
    }

    public void m(FragmentActivity fragmentActivity, View view, String str, String str2, String str3) {
        TextView textView = (TextView) view.findViewById(R.id.tvInviteCode);
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("showTail", Boolean.FALSE);
            hashMap.put("shareTitle", "");
            hashMap.put("showQRCode", Boolean.TRUE);
            hashMap.put("qrCodeUrl", str2);
            hashMap.put("shareUrl", str2);
            hashMap.put("source", "liveGroup");
            RequestExtKt.c(v7.b.a().postShareConfig(hashMap), new lq.b(view, str3, textView, fragmentActivity, str, str2), lq.c.f58049b, (MutableLiveData) null);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public View q(FragmentActivity fragmentActivity, View view) {
        return a.d(view, fragmentActivity);
    }

    public void r(FragmentActivity fragmentActivity, String str, String str2, String str3, String str4, String str5, String str6, int i11) {
        HashMap hashMap = new HashMap();
        String str7 = str6;
        String str8 = str;
        int i12 = i11;
        String str9 = str3;
        String str10 = str5;
        hashMap.put(V2TIMConversation.CONVERSATION_GROUP_TYPE, ag.a.b("", "", str7, "", "", str8, i12, str9, str10, 0, 0, fragmentActivity.getResources().getString(R.string.n_user_center_community_dynamic)));
        hashMap.put("community", ag.a.b("", "", str7, "", "", str8, i12, str9, str10, 0, 0, str4));
        ShareManager.getInstance().newShareWithShareUrl(str3, str, (ArrayList<Bitmap>) null, true, false, str4, hashMap, true);
    }
}
