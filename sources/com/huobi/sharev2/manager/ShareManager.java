package com.huobi.sharev2.manager;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import com.blankj.utilcode.util.PermissionUtils;
import com.google.gson.reflect.TypeToken;
import com.huobi.sharev2.bean.JsToNativeBean;
import com.huobi.sharev2.bean.ShareInfo;
import com.huobi.sharev2.helper.NewShareHelper;
import com.luck.picture.lib.permissions.PermissionConfig;
import com.tencent.imsdk.v2.V2TIMConversation;
import d10.l;
import i6.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import z9.g1;

public class ShareManager implements IShare {
    private static final String TAG = "ShareManager";
    public g1 mLoadingDialog;

    public static class Holder {
        public static final ShareManager instance = new ShareManager((a) null);
    }

    public class a implements PermissionUtils.e {
        public a() {
        }

        public void onDenied() {
        }

        public void onGranted() {
        }
    }

    public class b extends TypeToken<Map<String, Object>> {
        public b() {
        }
    }

    public /* synthetic */ ShareManager(a aVar) {
        this();
    }

    public static IShare getInstance() {
        return Holder.instance;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$doShare$1(JsToNativeBean jsToNativeBean, String str, Map map, ArrayList arrayList) {
        newShareWithPageId(jsToNativeBean.getData().getPageId(), jsToNativeBean.getData().getButtonId(), arrayList, jsToNativeBean.getData().getShareUrl(), jsToNativeBean.getData().getShareTitle(), jsToNativeBean.getData().getShowQRCode(), jsToNativeBean.getData().getShowTail(), jsToNativeBean.getData().getQrcodeTitle(), jsToNativeBean.getData().getQrcodeSubTitle(), jsToNativeBean.getData().getFloatContent(), jsToNativeBean.getData().getChannelList(), str, map, jsToNativeBean.getData().getExtendChannelList(), jsToNativeBean.getData().getShareThumbImage());
        dismissProgressDialog();
    }

    private void requestStorage() {
        String[] strArr;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 33) {
            strArr = new String[]{PermissionConfig.READ_MEDIA_IMAGES};
        } else {
            strArr = new String[]{PermissionConfig.READ_EXTERNAL_STORAGE, PermissionConfig.WRITE_EXTERNAL_STORAGE};
        }
        if (i11 >= 23 && !PermissionUtils.u(strArr)) {
            PermissionUtils.z(strArr).o(new a()).B();
        }
    }

    public void dismissProgressDialog() {
        g1 g1Var = this.mLoadingDialog;
        if (g1Var != null) {
            g1Var.dismiss();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0159  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void doShare(java.lang.String r19) {
        /*
            r18 = this;
            r15 = r18
            r18.showProgressDialog()
            r0 = 2132024290(0x7f141be2, float:1.9687052E38)
            r1 = 0
            com.google.gson.Gson r2 = new com.google.gson.Gson     // Catch:{ Exception -> 0x004a }
            r2.<init>()     // Catch:{ Exception -> 0x004a }
            java.lang.Class<com.huobi.sharev2.bean.JsToNativeBean> r3 = com.huobi.sharev2.bean.JsToNativeBean.class
            r4 = r19
            java.lang.Object r2 = r2.fromJson((java.lang.String) r4, r3)     // Catch:{ Exception -> 0x004a }
            com.huobi.sharev2.bean.JsToNativeBean r2 = (com.huobi.sharev2.bean.JsToNativeBean) r2     // Catch:{ Exception -> 0x004a }
            com.huobi.sharev2.manager.ShareManager$b r3 = new com.huobi.sharev2.manager.ShareManager$b     // Catch:{ Exception -> 0x004b }
            r3.<init>()     // Catch:{ Exception -> 0x004b }
            java.lang.reflect.Type r3 = r3.getType()     // Catch:{ Exception -> 0x004b }
            com.huobi.sharev2.bean.Data r4 = r2.getData()     // Catch:{ Exception -> 0x004b }
            if (r4 == 0) goto L_0x0059
            com.huobi.sharev2.bean.Data r4 = r2.getData()     // Catch:{ Exception -> 0x004b }
            com.google.gson.JsonObject r4 = r4.getExtendChannelParam()     // Catch:{ Exception -> 0x004b }
            if (r4 == 0) goto L_0x0059
            com.google.gson.Gson r4 = new com.google.gson.Gson     // Catch:{ Exception -> 0x004b }
            r4.<init>()     // Catch:{ Exception -> 0x004b }
            com.huobi.sharev2.bean.Data r5 = r2.getData()     // Catch:{ Exception -> 0x004b }
            com.google.gson.JsonObject r5 = r5.getExtendChannelParam()     // Catch:{ Exception -> 0x004b }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x004b }
            java.lang.Object r3 = r4.fromJson((java.lang.String) r5, (java.lang.reflect.Type) r3)     // Catch:{ Exception -> 0x004b }
            java.util.Map r3 = (java.util.Map) r3     // Catch:{ Exception -> 0x004b }
            r1 = r3
            goto L_0x0059
        L_0x004a:
            r2 = r1
        L_0x004b:
            android.app.Activity r3 = com.blankj.utilcode.util.a.c()
            java.lang.String r3 = r3.getString(r0)
            com.blankj.utilcode.util.ToastUtils.s(r3)
            r18.dismissProgressDialog()
        L_0x0059:
            r14 = r1
            if (r2 == 0) goto L_0x0159
            com.huobi.sharev2.bean.Data r1 = r2.getData()
            if (r1 == 0) goto L_0x0159
            com.huobi.sharev2.bean.Data r1 = r2.getData()
            java.lang.String r1 = r1.getShareUrl()
            boolean r1 = com.huobi.sharev2.helper.NewShareHelper.p(r1)
            if (r1 == 0) goto L_0x008a
            com.huobi.sharev2.bean.Data r1 = r2.getData()
            java.util.ArrayList r1 = r1.getImages()
            if (r1 == 0) goto L_0x0159
            com.huobi.sharev2.bean.Data r1 = r2.getData()
            java.util.ArrayList r1 = r1.getImages()
            int r1 = r1.size()
            if (r1 != 0) goto L_0x008a
            goto L_0x0159
        L_0x008a:
            com.huobi.sharev2.bean.Data r0 = r2.getData()
            if (r0 == 0) goto L_0x00e2
            com.huobi.sharev2.bean.Data r0 = r2.getData()
            java.util.ArrayList r0 = r0.getImages()
            if (r0 == 0) goto L_0x00e2
            com.huobi.sharev2.bean.Data r0 = r2.getData()
            java.lang.String r1 = r0.getSource()
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x00c9 }
            com.google.gson.Gson r3 = new com.google.gson.Gson     // Catch:{ all -> 0x00c9 }
            r3.<init>()     // Catch:{ all -> 0x00c9 }
            java.lang.String r4 = "community"
            java.lang.Object r4 = r14.get(r4)     // Catch:{ all -> 0x00c9 }
            java.lang.String r3 = r3.toJson((java.lang.Object) r4)     // Catch:{ all -> 0x00c9 }
            r0.<init>(r3)     // Catch:{ all -> 0x00c9 }
            java.lang.String r3 = "shareChannel"
            java.lang.String r1 = r0.getString(r3)     // Catch:{ all -> 0x00c9 }
            double r3 = java.lang.Double.parseDouble(r1)     // Catch:{ all -> 0x00c9 }
            r5 = 4611686018427387904(0x4000000000000000, double:2.0)
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 != 0) goto L_0x00cd
            java.lang.String r1 = "news"
            goto L_0x00cd
        L_0x00c9:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00cd:
            com.huobi.sharev2.bean.Data r0 = r2.getData()
            java.util.ArrayList r0 = r0.getImages()
            android.app.Activity r3 = com.blankj.utilcode.util.a.c()
            tr.a r4 = new tr.a
            r4.<init>(r15, r2, r1, r14)
            com.huobi.sharev2.helper.NewShareHelper.g(r0, r3, r4)
            goto L_0x0158
        L_0x00e2:
            com.huobi.sharev2.bean.Data r0 = r2.getData()
            java.lang.String r0 = r0.getPageId()
            com.huobi.sharev2.bean.Data r1 = r2.getData()
            java.lang.String r3 = r1.getButtonId()
            r4 = 0
            com.huobi.sharev2.bean.Data r1 = r2.getData()
            java.lang.String r5 = r1.getShareUrl()
            com.huobi.sharev2.bean.Data r1 = r2.getData()
            java.lang.String r6 = r1.getShareTitle()
            com.huobi.sharev2.bean.Data r1 = r2.getData()
            boolean r7 = r1.getShowQRCode()
            com.huobi.sharev2.bean.Data r1 = r2.getData()
            boolean r8 = r1.getShowTail()
            com.huobi.sharev2.bean.Data r1 = r2.getData()
            java.lang.String r9 = r1.getQrcodeTitle()
            com.huobi.sharev2.bean.Data r1 = r2.getData()
            java.lang.String r10 = r1.getQrcodeSubTitle()
            com.huobi.sharev2.bean.Data r1 = r2.getData()
            java.lang.String r11 = r1.getFloatContent()
            com.huobi.sharev2.bean.Data r1 = r2.getData()
            java.util.ArrayList r12 = r1.getChannelList()
            com.huobi.sharev2.bean.Data r1 = r2.getData()
            java.lang.String r13 = r1.getSource()
            com.huobi.sharev2.bean.Data r1 = r2.getData()
            java.util.ArrayList r16 = r1.getExtendChannelList()
            com.huobi.sharev2.bean.Data r1 = r2.getData()
            java.lang.String r17 = r1.getShareThumbImage()
            r1 = r18
            r2 = r0
            r15 = r16
            r16 = r17
            r1.newShareWithPageId(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r18.dismissProgressDialog()
        L_0x0158:
            return
        L_0x0159:
            android.app.Activity r1 = com.blankj.utilcode.util.a.c()
            java.lang.String r0 = r1.getString(r0)
            com.blankj.utilcode.util.ToastUtils.s(r0)
            r18.dismissProgressDialog()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.sharev2.manager.ShareManager.doShare(java.lang.String):void");
    }

    public void newShareWithImages(ArrayList<Bitmap> arrayList, boolean z11, boolean z12, String str) {
        ShareInfo shareInfo = new ShareInfo();
        shareInfo.setShareType(ShareInfo.ShareType.SHARE_IMAGE_WITH_BITMAPS);
        shareInfo.setImageBitmaps(arrayList);
        shareInfo.setShowNativeQr(z11);
        shareInfo.setShowTail(z12);
        shareInfo.setSource(str);
        share((FragmentActivity) com.blankj.utilcode.util.a.c(), shareInfo);
    }

    public void newShareWithPageId(String str, String str2, ArrayList<Bitmap> arrayList, String str3, String str4, boolean z11, boolean z12, String str5, String str6, String str7, ArrayList<String> arrayList2, String str8) {
        ShareInfo shareInfo = new ShareInfo();
        shareInfo.setShareType(ShareInfo.ShareType.SHARE_IMAGE_WITH_BITMAPS);
        shareInfo.setPageId(str);
        shareInfo.setButtonId(str2);
        shareInfo.setImageBitmaps(arrayList);
        shareInfo.setShareUrl(str3);
        shareInfo.setShareText(str4);
        shareInfo.setShowNativeQr(z11);
        shareInfo.setShowTail(z12);
        shareInfo.setPosterTitle(str5);
        shareInfo.setPosterSubtitle(str6);
        shareInfo.setFloatContent(str7);
        shareInfo.setChannelList(arrayList2);
        shareInfo.setSource(str8);
        share((FragmentActivity) com.blankj.utilcode.util.a.c(), shareInfo);
    }

    public void newShareWithShareUrl(String str, String str2, ArrayList<Bitmap> arrayList, boolean z11, boolean z12, String str3, String str4, String str5, ArrayList<String> arrayList2, String str6) {
        ShareInfo shareInfo = new ShareInfo();
        shareInfo.setShareUrl(str);
        shareInfo.setShareText(str2);
        shareInfo.setImageBitmaps(arrayList);
        shareInfo.setShowNativeQr(z11);
        shareInfo.setShowTail(z12);
        shareInfo.setPosterTitle(str3);
        shareInfo.setPosterSubtitle(str4);
        shareInfo.setFloatContent(str5);
        shareInfo.setChannelList(arrayList2);
        shareInfo.setSource(str6);
        shareInfo.setShareType(ShareInfo.ShareType.SHARE_IMAGE_WITH_BITMAPS);
        share((FragmentActivity) com.blankj.utilcode.util.a.c(), shareInfo);
    }

    public void newShareWithShareUrlV2(String str, String str2, ArrayList<Bitmap> arrayList, boolean z11, boolean z12, String str3, Map<String, Object> map, boolean z13, l<? super Integer, Unit> lVar) {
        ShareInfo shareInfo = new ShareInfo();
        shareInfo.setShareUrl(str);
        shareInfo.setShareText(str2);
        shareInfo.setImageBitmaps(arrayList);
        shareInfo.setShowNativeQr(z11);
        shareInfo.setShowTail(z12);
        shareInfo.setSource(str3);
        shareInfo.setShareType(ShareInfo.ShareType.SHARE_IMAGE_WITH_BITMAPS);
        shareInfo.setExtendMap(map);
        shareInfo.setDefaultTab(z13 ^ true ? 1 : 0);
        shareInfo.setShareCallback(lVar);
        share((FragmentActivity) com.blankj.utilcode.util.a.c(), shareInfo);
    }

    public void share(FragmentActivity fragmentActivity, ShareInfo shareInfo) {
        requestStorage();
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            NewShareHelper.j().t(fragmentActivity, shareInfo);
        } else {
            i.b().f(new tr.b(fragmentActivity, shareInfo));
        }
    }

    public void shareGroup(String str, ArrayList<Bitmap> arrayList, Map<String, Object> map) {
        ShareInfo shareInfo = new ShareInfo();
        shareInfo.setShareUrl(str);
        shareInfo.setQrUrl(str);
        shareInfo.setShareText("");
        shareInfo.setImageBitmaps(arrayList);
        shareInfo.setShowNativeQr(true);
        shareInfo.setShowTail(false);
        shareInfo.setSource("liveGroup");
        shareInfo.setShareType(ShareInfo.ShareType.SHARE_IMAGE_WITH_BITMAPS);
        shareInfo.setExtendMap(map);
        shareInfo.setDefaultTab(0);
        share((FragmentActivity) com.blankj.utilcode.util.a.c(), shareInfo);
    }

    public void showProgressDialog() {
        if (com.blankj.utilcode.util.a.c() != null && !com.blankj.utilcode.util.a.c().isDestroyed()) {
            if (this.mLoadingDialog == null) {
                this.mLoadingDialog = new g1(com.blankj.utilcode.util.a.c());
            }
            try {
                this.mLoadingDialog.show();
                this.mLoadingDialog.setCanceledOnTouchOutside(true);
                this.mLoadingDialog.setCancelable(true);
            } catch (Exception unused) {
            }
        }
    }

    private ShareManager() {
    }

    public void newShareWithImages(Bitmap bitmap, String str, String str2) {
        ShareInfo shareInfo = new ShareInfo();
        shareInfo.setShareType(ShareInfo.ShareType.SHARE_IMAGE_WITH_BITMAPS);
        shareInfo.setImageBitmaps(Collections.singletonList(bitmap));
        shareInfo.setShowNativeQr(true);
        shareInfo.setShowTail(false);
        shareInfo.setSource(str2);
        shareInfo.setQrUrl(str);
        share((FragmentActivity) com.blankj.utilcode.util.a.c(), shareInfo);
    }

    public void newShareWithShareUrl(String str, String str2, ArrayList<Bitmap> arrayList, boolean z11, boolean z12, String str3, String str4, String str5, String str6, String str7) {
        ShareInfo shareInfo = new ShareInfo();
        shareInfo.setShareUrl(str);
        shareInfo.setShareText(str2);
        shareInfo.setImageBitmaps(arrayList);
        shareInfo.setShowNativeQr(z11);
        shareInfo.setShowTail(z12);
        shareInfo.setPosterTitle(str3);
        shareInfo.setPosterSubtitle(str4);
        shareInfo.setFloatContent(str5);
        shareInfo.setSource(str6);
        shareInfo.setShareType(ShareInfo.ShareType.SHARE_IMAGE_WITH_BITMAPS);
        HashMap hashMap = new HashMap();
        hashMap.put(V2TIMConversation.CONVERSATION_GROUP_TYPE, str7);
        shareInfo.setExtendMap(hashMap);
        share((FragmentActivity) com.blankj.utilcode.util.a.c(), shareInfo);
    }

    public void newShareWithImages(Bitmap bitmap, String str, String str2, String str3) {
        ShareInfo shareInfo = new ShareInfo();
        shareInfo.setShareText(str2);
        shareInfo.setShareType(ShareInfo.ShareType.SHARE_IMAGE_WITH_BITMAPS);
        shareInfo.setImageBitmaps(Collections.singletonList(bitmap));
        shareInfo.setShowNativeQr(true);
        shareInfo.setShowTail(false);
        shareInfo.setSource(str3);
        shareInfo.setShareUrl(str);
        shareInfo.setQrUrl(str);
        share((FragmentActivity) com.blankj.utilcode.util.a.c(), shareInfo);
    }

    public void newShareWithPageId(String str, String str2, ArrayList<Bitmap> arrayList, String str3, String str4, boolean z11, boolean z12, String str5, String str6, String str7, ArrayList<String> arrayList2, String str8, Map<String, Object> map, ArrayList<String> arrayList3, String str9) {
        ShareInfo shareInfo = new ShareInfo();
        shareInfo.setShareType(ShareInfo.ShareType.SHARE_IMAGE_WITH_BITMAPS);
        String str10 = str;
        shareInfo.setPageId(str);
        String str11 = str2;
        shareInfo.setButtonId(str2);
        ArrayList<Bitmap> arrayList4 = arrayList;
        shareInfo.setImageBitmaps(arrayList);
        String str12 = str3;
        shareInfo.setShareUrl(str3);
        String str13 = str4;
        shareInfo.setShareText(str4);
        boolean z13 = z11;
        shareInfo.setShowNativeQr(z11);
        boolean z14 = z12;
        shareInfo.setShowTail(z12);
        String str14 = str5;
        shareInfo.setPosterTitle(str5);
        String str15 = str6;
        shareInfo.setPosterSubtitle(str6);
        String str16 = str7;
        shareInfo.setFloatContent(str7);
        ArrayList<String> arrayList5 = arrayList2;
        shareInfo.setChannelList(arrayList2);
        String str17 = str8;
        shareInfo.setSource(str8);
        shareInfo.setExtendMap(map);
        shareInfo.setExtendChannelList(arrayList3);
        shareInfo.setShareThumbImage(str9);
        share((FragmentActivity) com.blankj.utilcode.util.a.c(), shareInfo);
    }

    public void newShareWithImages(ArrayList<Bitmap> arrayList, boolean z11, boolean z12, String str, Map<String, Object> map, ArrayList<String> arrayList2) {
        ShareInfo shareInfo = new ShareInfo();
        shareInfo.setShareType(ShareInfo.ShareType.SHARE_IMAGE_WITH_BITMAPS);
        shareInfo.setImageBitmaps(arrayList);
        shareInfo.setShowNativeQr(z11);
        shareInfo.setShowTail(z12);
        shareInfo.setSource(str);
        shareInfo.setExtendMap(map);
        shareInfo.setExtendChannelList(arrayList2);
        share((FragmentActivity) com.blankj.utilcode.util.a.c(), shareInfo);
    }

    public void newShareWithShareUrl(String str, String str2, ArrayList<Bitmap> arrayList, boolean z11, boolean z12, String str3, Map<String, Object> map, boolean z13) {
        ShareInfo shareInfo = new ShareInfo();
        shareInfo.setShareUrl(str);
        shareInfo.setShareText(str2);
        shareInfo.setImageBitmaps(arrayList);
        shareInfo.setShowNativeQr(z11);
        shareInfo.setShowTail(z12);
        shareInfo.setSource(str3);
        shareInfo.setShareType(ShareInfo.ShareType.SHARE_IMAGE_WITH_BITMAPS);
        shareInfo.setExtendMap(map);
        shareInfo.setDefaultTab(z13 ^ true ? 1 : 0);
        share((FragmentActivity) com.blankj.utilcode.util.a.c(), shareInfo);
    }

    public void newShareWithPageId(String str, String str2, ArrayList<Bitmap> arrayList, String str3, String str4, String str5, boolean z11, boolean z12, String str6, String str7, String str8, ArrayList<String> arrayList2, String str9, String str10) {
        ShareInfo shareInfo = new ShareInfo();
        shareInfo.setShareType(ShareInfo.ShareType.SHARE_IMAGE_WITH_BITMAPS);
        String str11 = str;
        shareInfo.setPageId(str);
        String str12 = str2;
        shareInfo.setButtonId(str2);
        ArrayList<Bitmap> arrayList3 = arrayList;
        shareInfo.setImageBitmaps(arrayList);
        String str13 = str3;
        shareInfo.setShareUrl(str3);
        String str14 = str4;
        shareInfo.setShareThumbImage(str4);
        String str15 = str5;
        shareInfo.setShareText(str5);
        boolean z13 = z11;
        shareInfo.setShowNativeQr(z11);
        boolean z14 = z12;
        shareInfo.setShowTail(z12);
        String str16 = str6;
        shareInfo.setPosterTitle(str6);
        String str17 = str7;
        shareInfo.setPosterSubtitle(str7);
        String str18 = str8;
        shareInfo.setFloatContent(str8);
        shareInfo.setChannelList(arrayList2);
        shareInfo.setSource(str9);
        HashMap hashMap = new HashMap();
        hashMap.put(V2TIMConversation.CONVERSATION_GROUP_TYPE, str10);
        shareInfo.setExtendMap(hashMap);
        share((FragmentActivity) com.blankj.utilcode.util.a.c(), shareInfo);
    }

    public void newShareWithImages(ArrayList<Bitmap> arrayList, boolean z11, boolean z12, String str, String str2) {
        ShareInfo shareInfo = new ShareInfo();
        shareInfo.setShareType(ShareInfo.ShareType.SHARE_IMAGE_WITH_BITMAPS);
        shareInfo.setImageBitmaps(arrayList);
        shareInfo.setShowNativeQr(z11);
        shareInfo.setShowTail(z12);
        shareInfo.setSource(str);
        HashMap hashMap = new HashMap();
        hashMap.put(V2TIMConversation.CONVERSATION_GROUP_TYPE, str2);
        shareInfo.setExtendMap(hashMap);
        share((FragmentActivity) com.blankj.utilcode.util.a.c(), shareInfo);
    }

    public void newShareWithShareUrl(String str, String str2, String str3, boolean z11, l<? super Integer, Unit> lVar) {
        ShareInfo shareInfo = new ShareInfo();
        shareInfo.setShareType(ShareInfo.ShareType.SHARE_CONTENT);
        shareInfo.setShareText(str2);
        shareInfo.setShareUrl(str);
        shareInfo.setSource(str3);
        shareInfo.setShowNativeQr(z11);
        shareInfo.setShareCallback(lVar);
        share((FragmentActivity) com.blankj.utilcode.util.a.c(), shareInfo);
    }

    public void newShareWithShareUrl(String str, String str2, String str3, String str4) {
        ShareInfo shareInfo = new ShareInfo();
        shareInfo.setShareType(ShareInfo.ShareType.SHARE_CONTENT);
        shareInfo.setShareText(str2);
        shareInfo.setShareUrl(str);
        shareInfo.setSource(str3);
        HashMap hashMap = new HashMap();
        hashMap.put(V2TIMConversation.CONVERSATION_GROUP_TYPE, str4);
        shareInfo.setExtendMap(hashMap);
        share((FragmentActivity) com.blankj.utilcode.util.a.c(), shareInfo);
    }

    public void newShareWithPageId(String str, String str2, String str3) {
        ShareInfo shareInfo = new ShareInfo();
        shareInfo.setShareType(ShareInfo.ShareType.SHARE_IMAGE_WITH_BITMAPS);
        shareInfo.setPageId(str);
        shareInfo.setButtonId(str2);
        shareInfo.setSource(str3);
        share((FragmentActivity) com.blankj.utilcode.util.a.c(), shareInfo);
    }

    public void newShareWithShareUrl(String str, String str2, ArrayList<Bitmap> arrayList, boolean z11, boolean z12, String str3) {
        ShareInfo shareInfo = new ShareInfo();
        shareInfo.setShareUrl(str);
        shareInfo.setShareText(str2);
        shareInfo.setShareType(ShareInfo.ShareType.SHARE_IMAGE_WITH_BITMAPS);
        shareInfo.setImageBitmaps(arrayList);
        shareInfo.setShowNativeQr(z11);
        shareInfo.setShowTail(z12);
        shareInfo.setSource(str3);
        share((FragmentActivity) com.blankj.utilcode.util.a.c(), shareInfo);
    }

    public void newShareWithShareUrl(String str, String str2, ArrayList<Bitmap> arrayList, boolean z11, boolean z12, String str3, String str4) {
        ShareInfo shareInfo = new ShareInfo();
        shareInfo.setShareUrl(str);
        shareInfo.setShareText(str2);
        shareInfo.setShareType(ShareInfo.ShareType.SHARE_IMAGE_WITH_BITMAPS);
        shareInfo.setImageBitmaps(arrayList);
        shareInfo.setShowNativeQr(z11);
        shareInfo.setShowTail(z12);
        shareInfo.setSource(str3);
        HashMap hashMap = new HashMap();
        hashMap.put(V2TIMConversation.CONVERSATION_GROUP_TYPE, str4);
        shareInfo.setExtendMap(hashMap);
        share((FragmentActivity) com.blankj.utilcode.util.a.c(), shareInfo);
    }
}
