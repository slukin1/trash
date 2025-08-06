package com.tencent.qcloud.tuikit.tuicallengine.i;

import android.content.Context;
import android.text.TextUtils;
import com.huobi.finance.bean.FinanceRecordItem;
import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.qcloud.tuikit.TUICommonDefine;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine;
import com.tencent.qcloud.tuikit.tuicallengine.e.m;
import com.tencent.qcloud.tuikit.tuicallengine.e.o;
import com.tencent.qcloud.tuikit.tuicallengine.f.j;
import com.tencent.qcloud.tuikit.tuicallengine.f.k;
import com.tencent.qcloud.tuikit.tuicallengine.i.a;
import com.tencent.qcloud.tuikit.tuicallengine.impl.base.TUILog;
import com.tencent.qcloud.tuikit.tuicallengine.k.a;
import com.tencent.qcloud.tuikit.tuicallengine.k.b;
import com.tencent.qcloud.tuikit.tuicallengine.signaling.SignalingData;
import com.tencent.trtc.TRTCCloud;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class b extends a {

    /* renamed from: h  reason: collision with root package name */
    public final List<String> f48476h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public final HashSet<String> f48477i = new HashSet<>();

    /* renamed from: j  reason: collision with root package name */
    public final HashMap<String, List<String>> f48478j = new HashMap<>();

    /* renamed from: k  reason: collision with root package name */
    public final HashSet<String> f48479k = new HashSet<>();

    public class a implements V2TIMCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f48480a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TUICommonDefine.Callback f48481b;

        public a(List list, TUICommonDefine.Callback callback) {
            this.f48480a = list;
            this.f48481b = callback;
        }

        public void onError(int i11, String str) {
            TUILog.e("V4GroupCalling", "groupCall failed,errorCode: " + i11 + " errorMsg: " + str);
            TUICommonDefine.Callback callback = this.f48481b;
            if (callback != null) {
                callback.onError(i11, str);
            }
            b.this.c();
        }

        public void onSuccess() {
            TUILog.i("V4GroupCalling", "groupCall success");
            b bVar = b.this;
            com.tencent.qcloud.tuikit.tuicallengine.g.a aVar = bVar.f48472d;
            if (aVar != null) {
                aVar.a(this.f48480a, bVar.f48471c.f48380j);
            }
            TUICommonDefine.Callback callback = this.f48481b;
            if (callback != null) {
                callback.onSuccess();
            }
        }
    }

    /* renamed from: com.tencent.qcloud.tuikit.tuicallengine.i.b$b  reason: collision with other inner class name */
    public class C0605b implements V2TIMCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.tencent.qcloud.tuikit.tuicallengine.k.b f48483a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f48484b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TUICallDefine.CallParams f48485c;

        public C0605b(com.tencent.qcloud.tuikit.tuicallengine.k.b bVar, List list, TUICallDefine.CallParams callParams) {
            this.f48483a = bVar;
            this.f48484b = list;
            this.f48485c = callParams;
        }

        public void onError(int i11, String str) {
            j jVar;
            TUILog.e("V4GroupCalling", "inviteUser failed, errorCode: " + i11 + " errorMsg: " + str);
            com.tencent.qcloud.tuikit.tuicallengine.k.b bVar = this.f48483a;
            bVar.f48536d.post(new b.c(i11, str));
            for (String str2 : this.f48484b) {
                if (!TextUtils.isEmpty(str2) && (jVar = b.this.f48470b) != null) {
                    jVar.c(str2);
                }
            }
        }

        public void onSuccess() {
            TUILog.i("V4GroupCalling", "inviteUser success");
            this.f48483a.a(this.f48484b);
            b.this.f48476h.addAll(this.f48484b);
            b.this.f48477i.addAll(this.f48484b);
            com.tencent.qcloud.tuikit.tuicallengine.g.a aVar = b.this.f48472d;
            if (aVar != null) {
                aVar.a(this.f48484b, this.f48485c);
            }
        }
    }

    public class c implements V2TIMCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.tencent.qcloud.tuikit.tuicallengine.k.b f48487a;

        public c(com.tencent.qcloud.tuikit.tuicallengine.k.b bVar) {
            this.f48487a = bVar;
        }

        public void onError(int i11, String str) {
            TUILog.e("V4GroupCalling", "sendAcceptSignaling failed, errorCode: " + i11 + " , errorMsg: " + str);
            com.tencent.qcloud.tuikit.tuicallengine.k.b bVar = this.f48487a;
            bVar.f48536d.post(new b.c(i11, str));
            b.this.e((String) null);
        }

        public void onSuccess() {
            b bVar = b.this;
            if (bVar.f48471c.f48377g) {
                k.f48439a = bVar.f48469a;
                k.b.f48445a.c();
            }
            this.f48487a.a();
        }
    }

    public class d implements V2TIMCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f48489a;

        public d(b bVar, String str) {
            this.f48489a = str;
        }

        public void onError(int i11, String str) {
            TUILog.e("V4GroupCalling", "sendRejectSignaling failed, inviteID: " + this.f48489a + " errorCode: " + i11 + " , errorMsg: " + str);
        }

        public void onSuccess() {
        }
    }

    public class e implements V2TIMCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f48490a;

        public e(b bVar, String str) {
            this.f48490a = str;
        }

        public void onError(int i11, String str) {
            TUILog.e("V4GroupCalling", "sendCancelSignaling failed, inviteID: " + this.f48490a + " errorCode: " + i11 + " ,errorMsg: " + str);
        }

        public void onSuccess() {
        }
    }

    public class f implements V2TIMCallback {
        public f(b bVar) {
        }

        public void onError(int i11, String str) {
            TUILog.e("V4GroupCalling", "sendGroupHangupSignaling failed, errorCode: " + i11 + " ,errorMsg: " + str);
        }

        public void onSuccess() {
        }
    }

    public b(Context context) {
        super(context);
    }

    public void a(List<String> list, TUICallDefine.CallParams callParams, TUICommonDefine.ValueCallback valueCallback) {
        list.remove(V2TIMManager.getInstance().getLoginUser());
        list.removeAll(Collections.singleton((Object) null));
        ArrayList arrayList = new ArrayList(list);
        arrayList.retainAll(this.f48477i);
        list.removeAll(arrayList);
        com.tencent.qcloud.tuikit.tuicallengine.k.b bVar = new com.tencent.qcloud.tuikit.tuicallengine.k.b(valueCallback);
        int size = this.f48477i.size() + list.size();
        int i11 = com.tencent.qcloud.tuikit.tuicallengine.k.a.f48519a;
        if (size > 8) {
            TUILog.e("V4GroupCalling", "inviteUser exceeding max user number");
            bVar.a(TUICallDefine.ERROR_PARAM_INVALID, "inviteUser exceeding max user number");
            return;
        }
        TUILog.i("V4GroupCalling", "inviteUser, callState: " + this.f48471c + " ,userIdList: " + list);
        String a11 = o.a(this.f48471c, list, new ArrayList(this.f48477i), callParams, 0);
        int i12 = 30;
        TUICallDefine.CallParams callParams2 = this.f48471c.f48380j;
        if (callParams2 != null) {
            i12 = callParams2.timeout;
        }
        this.f48478j.put(V2TIMManager.getSignalingManager().inviteInGroup(this.f48471c.f48372b, list, a11, false, i12, new C0605b(bVar, list, callParams)), new ArrayList(list));
        HashSet hashSet = new HashSet(this.f48479k);
        hashSet.retainAll(list);
        this.f48479k.removeAll(hashSet);
    }

    public void b(TUICommonDefine.Callback callback) {
        String a11 = o.a(o.a(this.f48471c, 0));
        String str = this.f48471c.f48372b;
        TUILog.i("V4GroupCalling", "groupCall sendGroupInvite ,groupId:" + str + " , inviteData:" + a11);
        int i11 = com.tencent.qcloud.tuikit.tuicallengine.k.a.f48519a;
        com.tencent.qcloud.tuikit.tuicallengine.f.a aVar = this.f48471c;
        TUICallDefine.CallParams callParams = aVar.f48380j;
        int i12 = callParams != null ? callParams.timeout : 30;
        List<String> list = aVar.f48374d;
        this.f48471c.f48382l.set(V2TIMManager.getSignalingManager().inviteInGroup(str, list, a11, false, i12, new a(list, callback)));
        this.f48476h.addAll(list);
        this.f48477i.addAll(list);
    }

    public void c(TUICommonDefine.Callback callback) {
        TUILog.i("V4GroupCalling", "hangup callRole: " + this.f48471c.f48375e + " ,status: " + this.f48471c.f48376f);
        if (TUICallDefine.Role.Caller.equals(this.f48471c.f48375e)) {
            if (TUICallDefine.Status.Waiting.equals(this.f48471c.f48376f)) {
                this.f48471c.f48386p.set(m.CancelCall);
                f(this.f48471c.f48382l.get());
                for (Map.Entry next : this.f48478j.entrySet()) {
                    if (next != null && !TextUtils.isEmpty((CharSequence) next.getKey())) {
                        f((String) next.getKey());
                    }
                }
                this.f48471c.f48385o.set(a.C0607a.Cancel);
                b(V2TIMManager.getInstance().getLoginUser());
            } else {
                b();
                a();
            }
        } else if (TUICallDefine.Role.Called.equals(this.f48471c.f48375e)) {
            if (TUICallDefine.Status.Waiting.equals(this.f48471c.f48376f)) {
                e(callback);
            } else if (TUICallDefine.Status.Accept.equals(this.f48471c.f48376f)) {
                b();
                a();
            }
        }
        c();
        new com.tencent.qcloud.tuikit.tuicallengine.k.b(callback).a();
    }

    public final boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        List list = this.f48478j.get(str);
        if (str.equals(this.f48471c.f48382l.get()) || (list != null && !list.isEmpty())) {
            return true;
        }
        return false;
    }

    public void e(TUICommonDefine.Callback callback) {
        TUILog.i("V4GroupCalling", FinanceRecordItem.STATE_REJECT);
        this.f48471c.f48386p.set(m.RejectCall);
        SignalingData c11 = o.c(this.f48471c);
        c11.getData().setExcludeFromHistoryMessage(true);
        a(this.f48471c.f48382l.get(), o.a(c11));
        this.f48471c.f48385o.set(a.C0607a.Reject);
        new com.tencent.qcloud.tuikit.tuicallengine.k.b(callback).a();
        b(V2TIMManager.getInstance().getLoginUser());
        c();
    }

    public final void f(String str) {
        if (!TextUtils.isEmpty(str)) {
            String b11 = o.b(this.f48471c);
            TUILog.i("V4GroupCalling", "sendCancelSignaling, callId: " + str + " ,cancelData: " + b11);
            V2TIMManager.getSignalingManager().cancel(str, b11, new e(this, str));
        }
    }

    public void d(TUICommonDefine.Callback callback) {
        TUILog.i("V4GroupCalling", "ignoreCalling");
        this.f48471c.f48385o.set(a.C0607a.Ignore);
        this.f48471c.f48386p.set(m.IgnoreCall);
        com.tencent.qcloud.tuikit.tuicallengine.f.a aVar = this.f48471c;
        a(aVar.f48382l.get(), o.a(aVar.f48373c, this.f48471c.f48384n.get(), true));
        new com.tencent.qcloud.tuikit.tuicallengine.k.b(callback).a();
        b(V2TIMManager.getInstance().getLoginUser());
        c();
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x001f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() {
        /*
            r7 = this;
            java.util.HashMap<java.lang.String, java.util.List<java.lang.String>> r0 = r7.f48478j
            boolean r0 = r0.isEmpty()
            r1 = 1
            if (r0 == 0) goto L_0x0014
            java.util.ArrayList r0 = new java.util.ArrayList
            java.util.HashSet<java.lang.String> r2 = r7.f48477i
            r0.<init>(r2)
            r7.a((java.util.List<java.lang.String>) r0, (boolean) r1)
            return
        L_0x0014:
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            java.util.HashSet<java.lang.String> r2 = r7.f48479k
            java.util.Iterator r2 = r2.iterator()
        L_0x001f:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x00aa
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 == 0) goto L_0x0032
            goto L_0x009d
        L_0x0032:
            java.util.HashMap<java.lang.String, java.util.List<java.lang.String>> r4 = r7.f48478j
            java.util.Set r4 = r4.entrySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x003c:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0070
            java.lang.Object r5 = r4.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            if (r5 == 0) goto L_0x003c
            java.lang.Object r6 = r5.getKey()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x003c
            java.lang.Object r6 = r5.getValue()
            if (r6 != 0) goto L_0x005d
            goto L_0x003c
        L_0x005d:
            java.lang.Object r6 = r5.getValue()
            java.util.List r6 = (java.util.List) r6
            boolean r6 = r6.contains(r3)
            if (r6 == 0) goto L_0x003c
            java.lang.Object r3 = r5.getKey()
            java.lang.String r3 = (java.lang.String) r3
            goto L_0x009f
        L_0x0070:
            java.util.ArrayList r4 = new java.util.ArrayList
            com.tencent.qcloud.tuikit.tuicallengine.f.a r5 = r7.f48471c
            java.util.List<java.lang.String> r5 = r5.f48374d
            r4.<init>(r5)
            com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine$Role r5 = com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine.Role.Called
            com.tencent.qcloud.tuikit.tuicallengine.f.a r6 = r7.f48471c
            com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine$Role r6 = r6.f48375e
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x008c
            com.tencent.qcloud.tuikit.tuicallengine.f.a r5 = r7.f48471c
            java.lang.String r5 = r5.f48373c
            r4.add(r5)
        L_0x008c:
            boolean r3 = r4.contains(r3)
            if (r3 == 0) goto L_0x009d
            com.tencent.qcloud.tuikit.tuicallengine.f.a r3 = r7.f48471c
            com.tencent.qcloud.tuikit.tuicallengine.impl.base.LiveData<java.lang.String> r3 = r3.f48382l
            java.lang.Object r3 = r3.get()
            java.lang.String r3 = (java.lang.String) r3
            goto L_0x009f
        L_0x009d:
            java.lang.String r3 = ""
        L_0x009f:
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L_0x001f
            r0.add(r3)
            goto L_0x001f
        L_0x00aa:
            com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine$Role r2 = com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine.Role.Caller
            com.tencent.qcloud.tuikit.tuicallengine.f.a r3 = r7.f48471c
            com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine$Role r3 = r3.f48375e
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00e2
            com.tencent.qcloud.tuikit.tuicallengine.f.a r2 = r7.f48471c
            com.tencent.qcloud.tuikit.tuicallengine.impl.base.LiveData<java.lang.String> r2 = r2.f48382l
            java.lang.Object r2 = r2.get()
            boolean r2 = r0.contains(r2)
            if (r2 == 0) goto L_0x00d5
            java.util.ArrayList r2 = new java.util.ArrayList
            com.tencent.qcloud.tuikit.tuicallengine.f.a r3 = r7.f48471c
            java.util.List<java.lang.String> r3 = r3.f48374d
            r2.<init>(r3)
            java.util.List r2 = r7.a((java.util.List<java.lang.String>) r2)
            r7.a((java.util.List<java.lang.String>) r2, (boolean) r1)
            goto L_0x00e2
        L_0x00d5:
            com.tencent.qcloud.tuikit.tuicallengine.f.a r2 = r7.f48471c
            com.tencent.qcloud.tuikit.tuicallengine.impl.base.LiveData<java.lang.String> r2 = r2.f48382l
            java.lang.Object r2 = r2.get()
            java.lang.String r2 = (java.lang.String) r2
            r7.f(r2)
        L_0x00e2:
            java.util.HashMap r2 = new java.util.HashMap
            java.util.HashMap<java.lang.String, java.util.List<java.lang.String>> r3 = r7.f48478j
            r2.<init>(r3)
            com.tencent.qcloud.tuikit.tuicallengine.f.a r3 = r7.f48471c
            com.tencent.qcloud.tuikit.tuicallengine.impl.base.LiveData<java.lang.String> r3 = r3.f48382l
            java.lang.Object r3 = r3.get()
            java.util.ArrayList r4 = new java.util.ArrayList
            com.tencent.qcloud.tuikit.tuicallengine.f.a r5 = r7.f48471c
            java.util.List<java.lang.String> r5 = r5.f48374d
            r4.<init>(r5)
            r2.put(r3, r4)
            java.util.Set r2 = r2.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x0105:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0142
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            if (r3 == 0) goto L_0x0105
            java.lang.Object r4 = r3.getKey()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L_0x0120
            goto L_0x0105
        L_0x0120:
            java.lang.Object r4 = r3.getKey()
            boolean r4 = r0.contains(r4)
            if (r4 == 0) goto L_0x0138
            java.lang.Object r3 = r3.getValue()
            java.util.List r3 = (java.util.List) r3
            java.util.List r3 = r7.a((java.util.List<java.lang.String>) r3)
            r7.a((java.util.List<java.lang.String>) r3, (boolean) r1)
            goto L_0x0105
        L_0x0138:
            java.lang.Object r3 = r3.getKey()
            java.lang.String r3 = (java.lang.String) r3
            r7.f(r3)
            goto L_0x0105
        L_0x0142:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuikit.tuicallengine.i.b.b():void");
    }

    public final void e(String str) {
        TUILog.i("V4GroupCalling", "preExitRoom, mIsInRoom: " + this.f48471c.f48377g + " , leaveUser: " + str + " , mInvitingList: " + this.f48476h + " , mCallingUserList: " + this.f48477i);
        if (this.f48476h.size() <= 0 && this.f48477i.size() <= 0) {
            com.tencent.qcloud.tuikit.tuicallengine.f.a aVar = this.f48471c;
            if (aVar.f48377g && !TextUtils.isEmpty(aVar.f48372b)) {
                if (TextUtils.isEmpty(str)) {
                    str = V2TIMManager.getInstance().getLoginUser();
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                a((List<String>) arrayList, false);
            }
            if (TUICallDefine.Status.Accept.equals(this.f48471c.f48376f)) {
                a();
            } else {
                b(V2TIMManager.getInstance().getLoginUser());
            }
            c();
        }
    }

    public void a(TUICommonDefine.Callback callback) {
        TUILog.i("V4GroupCalling", "accept");
        com.tencent.qcloud.tuikit.tuicallengine.f.a aVar = this.f48471c;
        aVar.f48376f = TUICallDefine.Status.Accept;
        aVar.f48386p.set(m.AcceptCall);
        k.f48439a = this.f48469a;
        k kVar = k.b.f48445a;
        com.tencent.qcloud.tuikit.tuicallengine.f.a aVar2 = this.f48471c;
        kVar.a(aVar2.f48371a, aVar2.f48384n.get());
        this.f48474f = callback;
    }

    public void c(String str, String str2, SignalingData signalingData) {
        TUILog.i("V4GroupCalling", "inviteeRejected inviteID: " + str + ", invitee: " + str2 + " , data: " + signalingData + " ,mAddUserMap: " + this.f48478j + " ,mCallingUserList: " + this.f48477i);
        if (o.c(signalingData)) {
            if (d(str)) {
                j jVar = this.f48470b;
                if (jVar != null) {
                    jVar.d(str2);
                }
            } else {
                return;
            }
        } else if (!d(str) && !this.f48477i.contains(str2)) {
            return;
        } else {
            if (a(str2)) {
                TUILog.i("V4GroupCalling", "isMultiPlatformLogin, mEnableMultiDevice: " + this.f48475g);
                if (this.f48475g) {
                    b(V2TIMManager.getInstance().getLoginUser());
                    c();
                    return;
                }
                return;
            }
            j jVar2 = this.f48470b;
            if (jVar2 != null) {
                jVar2.f(str2);
            }
        }
        this.f48476h.remove(str2);
        this.f48477i.remove(str2);
        e((String) null);
    }

    public final List<String> a(List<String> list) {
        if (list == null || list.isEmpty()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (String next : list) {
            if (!TextUtils.isEmpty(next) && this.f48477i.contains(next)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public void a(String str, String str2, String str3, List<String> list, SignalingData signalingData) {
        SignalingData.DataInfo data = signalingData.getData();
        if (data.getUserIDs() != null && !data.getUserIDs().isEmpty()) {
            list = data.getUserIDs();
        }
        TUILog.i("V4GroupCalling", "lineBusy inviteID: " + str + ", inviter: " + str2 + ", userIds: " + list);
        TUICallDefine.MediaType mediaType = TUICallDefine.MediaType.values()[signalingData.getCallType()];
        com.tencent.qcloud.tuikit.tuicallengine.j.c.a(str, str2, mediaType);
        if (list != null && list.size() > 1 && TextUtils.isEmpty(str3)) {
            for (String next : list) {
                if (!this.f48477i.contains(next) && !this.f48471c.f48373c.equals(next)) {
                    com.tencent.qcloud.tuikit.tuicallengine.j.c.a(next, str2, mediaType, (V2TIMCallback) null);
                }
            }
        }
    }

    public void b(String str, String str2, String str3, List<String> list, SignalingData signalingData) {
        if (o.d(signalingData)) {
            SignalingData.DataInfo data = signalingData.getData();
            if ("hangup".equals(data.getCmd())) {
                if (!this.f48471c.f48377g) {
                    j jVar = this.f48470b;
                    if (jVar != null) {
                        jVar.c(str2);
                    }
                    this.f48476h.remove(str2);
                    this.f48477i.remove(str2);
                    e(str2);
                }
            } else if ("lineBusy".equals(data.getCmd())) {
                j jVar2 = this.f48470b;
                if (jVar2 != null) {
                    jVar2.d(str2);
                }
                this.f48476h.remove(str2);
                this.f48477i.remove(str2);
                e(str2);
            } else {
                a(str2, signalingData);
            }
        } else {
            this.f48471c.f48384n.set(TUICallDefine.MediaType.values()[signalingData.getCallType()]);
            this.f48471c.f48371a.intRoomId = signalingData.getRoomId();
            if (signalingData.getCallEnd() != 0) {
                e((String) null);
            } else {
                a(str2, signalingData);
            }
        }
    }

    public void c(String str) {
        j jVar = this.f48470b;
        if (jVar != null) {
            jVar.b(str);
        }
        this.f48476h.remove(str);
        this.f48477i.add(str);
        this.f48479k.add(str);
    }

    public final void a(String str, SignalingData signalingData) {
        List<String> inCallUserIDs = signalingData.getData().getInCallUserIDs();
        this.f48477i.clear();
        this.f48476h.clear();
        if (inCallUserIDs != null) {
            this.f48477i.addAll(inCallUserIDs);
        }
        this.f48477i.addAll(this.f48471c.f48374d);
        this.f48471c.f48386p.set(m.ReceiveCall);
        j jVar = this.f48470b;
        if (jVar != null) {
            ArrayList arrayList = new ArrayList(this.f48477i);
            com.tencent.qcloud.tuikit.tuicallengine.f.a aVar = this.f48471c;
            jVar.a(str, arrayList, aVar.f48372b, aVar.f48384n.get(), signalingData.getUserData());
        }
        this.f48476h.addAll(this.f48471c.f48374d);
        this.f48477i.add(this.f48471c.f48373c);
        this.f48476h.remove(V2TIMManager.getInstance().getLoginUser());
        this.f48477i.remove(V2TIMManager.getInstance().getLoginUser());
    }

    public final void c() {
        if (this.f48471c.f48377g) {
            k.f48439a = this.f48469a;
            k.b.f48445a.b();
        }
        this.f48471c.a();
        this.f48476h.clear();
        this.f48477i.clear();
        this.f48479k.clear();
        this.f48478j.clear();
        this.f48474f = null;
        a.C0604a aVar = this.f48473e;
        if (aVar != null) {
            com.tencent.qcloud.tuikit.tuicallengine.a.a(com.tencent.qcloud.tuikit.tuicallengine.a.this);
            this.f48473e = null;
        }
    }

    public void b(String str, String str2, SignalingData signalingData) {
        TUILog.i("V4GroupCalling", "inviteeAccepted inviteID: " + str + ", invitee: " + str2 + " data: " + signalingData + " ,callState: " + this.f48471c + " ,mAddUserMap: " + this.f48478j);
        if (o.e(signalingData) || !d(str)) {
            return;
        }
        if (TUICallDefine.Role.Called.equals(this.f48471c.f48375e) && !V2TIMManager.getInstance().getLoginUser().equals(str2)) {
            return;
        }
        if (a(str2)) {
            TUILog.i("V4GroupCalling", "isMultiPlatformLogin, mEnableMultiDevice: " + this.f48475g);
            if (this.f48475g) {
                b(V2TIMManager.getInstance().getLoginUser());
                c();
                return;
            }
            return;
        }
        this.f48476h.remove(str2);
        TUICallDefine.Status status = TUICallDefine.Status.Accept;
        if (!status.equals(this.f48471c.f48376f)) {
            com.tencent.qcloud.tuikit.tuicallengine.f.a aVar = this.f48471c;
            aVar.f48376f = status;
            aVar.f48386p.set(m.CallAccepted);
            k.f48439a = this.f48469a;
            k.b.f48445a.c();
            TRTCCloud.sharedInstance(this.f48469a).muteLocalVideo(0, false);
            if (TUICallDefine.Role.Caller.equals(this.f48471c.f48375e)) {
                j jVar = this.f48470b;
                if (jVar != null) {
                    com.tencent.qcloud.tuikit.tuicallengine.f.a aVar2 = this.f48471c;
                    jVar.a(aVar2.f48371a, aVar2.f48384n.get(), this.f48471c.f48375e);
                }
                this.f48471c.f48381k.f48390d.set(Long.valueOf(o.b()));
                if (this.f48475g) {
                    o.a(status, (TUICommonDefine.Callback) null);
                }
            }
        }
    }

    public void a(String str, String str2, SignalingData signalingData) {
        TUILog.i("V4GroupCalling", "invitationCancelled, inviteID: " + str + " , inviter: " + str2 + " , data: " + signalingData + " , mAddUserMap: " + this.f48478j);
        if (d(str)) {
            this.f48471c.f48385o.set(a.C0607a.Cancel);
            this.f48471c.f48386p.set(m.CallCanceled);
            j jVar = this.f48470b;
            if (jVar != null) {
                jVar.a(str2);
            }
            c();
        }
    }

    public void a(String str, List<String> list) {
        TUILog.i("V4GroupCalling", "invitationTimeout, inviteID: " + str + " , mAddUserMap: " + this.f48478j + " , inviteeList: " + list + " ,mCallingUserList: " + this.f48477i + " ,mInvitingUserList: " + this.f48476h);
        if (!d(str) || !list.contains(V2TIMManager.getInstance().getLoginUser())) {
            for (String next : list) {
                if (this.f48477i.contains(next) || this.f48476h.contains(next)) {
                    j jVar = this.f48470b;
                    if (jVar != null) {
                        jVar.e(next);
                    }
                    this.f48476h.remove(next);
                    this.f48477i.remove(next);
                }
            }
            e((String) null);
            return;
        }
        this.f48471c.f48385o.set(a.C0607a.Timeout);
        this.f48471c.f48386p.set(m.NotAnswerCall);
        b(V2TIMManager.getInstance().getLoginUser());
        c();
    }

    public void a(long j11) {
        if (TUICallDefine.Role.Called.equals(this.f48471c.f48375e)) {
            a(TUICallDefine.Status.Accept);
            j jVar = this.f48470b;
            if (jVar != null) {
                com.tencent.qcloud.tuikit.tuicallengine.f.a aVar = this.f48471c;
                jVar.a(aVar.f48371a, aVar.f48384n.get(), this.f48471c.f48375e);
            }
            this.f48471c.f48381k.f48390d.set(Long.valueOf(o.b()));
            if (!TextUtils.isEmpty(this.f48471c.f48382l.get())) {
                com.tencent.qcloud.tuikit.tuicallengine.k.b bVar = new com.tencent.qcloud.tuikit.tuicallengine.k.b(this.f48474f);
                String a11 = o.a(this.f48471c);
                TUILog.i("V4GroupCalling", "sendAcceptSignaling, acceptData: " + a11);
                V2TIMManager.getSignalingManager().accept(this.f48471c.f48382l.get(), a11, new c(bVar));
            }
        }
    }

    public void a(String str, int i11) {
        j jVar = this.f48470b;
        if (jVar != null) {
            jVar.c(str);
        }
        this.f48477i.remove(str);
        e(str);
    }

    public final void a(String str, String str2) {
        TUILog.i("V4GroupCalling", "sendRejectSignaling inviteID: " + str + " ,rejectData: " + str2);
        V2TIMManager.getSignalingManager().reject(str, str2, new d(this, str));
    }

    public final void a(List<String> list, boolean z11) {
        if (!list.isEmpty()) {
            SignalingData a11 = o.a(this.f48471c, 0);
            if (z11) {
                a11.getData().setExcludeFromHistoryMessage(true);
            }
            String a12 = o.a(a11);
            TUILog.i("V4GroupCalling", "sendGroupHangupSignaling, hangupData: " + a12 + " ,groupId: " + this.f48471c.f48372b + " ,userList: " + list);
            V2TIMManager.getSignalingManager().inviteInGroup(this.f48471c.f48372b, list, a12, false, 0, new f(this));
        }
    }
}
