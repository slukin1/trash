package com.huobi.index.helper;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huobi.invite.bean.InviterInfo;
import com.huobi.invite.helper.InviteReturnHelper;
import com.huobi.share.bean.PreviewItem;
import com.huobi.sharev2.manager.ShareManager;
import com.huobi.utils.a0;
import com.tencent.imsdk.v2.V2TIMConversation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import tg.r;
import u6.g;

public final class KLineShareHelper {

    public class a extends BaseSubscriber<InviterInfo> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PreviewItem f73267b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ArrayList f73268c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f73269d;

        public a(PreviewItem previewItem, ArrayList arrayList, String str) {
            this.f73267b = previewItem;
            this.f73268c = arrayList;
            this.f73269d = str;
        }

        /* renamed from: a */
        public void onNext(InviterInfo inviterInfo) {
            super.onNext(inviterInfo);
            if (inviterInfo != null) {
                KLineShareHelper.d(this.f73267b, this.f73268c, inviterInfo.getInviteCode(), this.f73269d);
            } else {
                KLineShareHelper.d(this.f73267b, this.f73268c, (String) null, this.f73269d);
            }
        }
    }

    public static String b(long j11, String str) {
        String str2 = a0.j() + (AppLanguageHelper.getInstance().isChineseLanguage() ? "/zh-cn" : "/en-us") + "/views/feed/details/news-flash-details/" + j11;
        if (!r.x().F0() || TextUtils.isEmpty(str)) {
            return str2;
        }
        return str2 + "?inviteCode=" + str;
    }

    public static void c(PreviewItem previewItem, String str) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(previewItem.getBmp());
        if (r.x().F0()) {
            InviteReturnHelper.e().compose(RxJavaHelper.t((g) null)).timeout(2, TimeUnit.SECONDS).onErrorResumeNext(Observable.just(null)).subscribe(new a(previewItem, arrayList, str));
        } else {
            d(previewItem, arrayList, (String) null, str);
        }
    }

    public static void d(PreviewItem previewItem, ArrayList<Bitmap> arrayList, String str, String str2) {
        String str3 = str;
        HashMap hashMap = new HashMap();
        hashMap.put(V2TIMConversation.CONVERSATION_GROUP_TYPE, ag.a.b("", "", previewItem.getId() + "", "", "", previewItem.getContent(), 1, b(previewItem.getId(), str3), previewItem.getShareImg(), 0, 0, "News 7*24"));
        hashMap.put("community", ag.a.b("", "", previewItem.getId() + "", "", "", previewItem.getContent(), 1, b(previewItem.getId(), str3), previewItem.getShareImg(), 0, 0, "News 7*24"));
        ShareManager.getInstance().newShareWithShareUrl((String) null, previewItem.getTitle(), arrayList, true, false, str2, hashMap, true);
    }
}
