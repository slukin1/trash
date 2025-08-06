package com.tencent.qcloud.tuikit.tuicallengine.f;

import android.os.Handler;
import android.os.Looper;
import com.tencent.qcloud.tuikit.TUICommonDefine;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallObserver;
import com.tencent.qcloud.tuikit.tuicallengine.impl.base.TUILog;
import com.tencent.trtc.TRTCCloudDef;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class j {

    /* renamed from: a  reason: collision with root package name */
    public List<WeakReference<TUICallObserver>> f48412a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public Handler f48413b = new Handler(Looper.getMainLooper());

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TUICallObserver f48414a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f48415b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f48416c;

        public a(j jVar, TUICallObserver tUICallObserver, int i11, String str) {
            this.f48414a = tUICallObserver;
            this.f48415b = i11;
            this.f48416c = str;
        }

        public void run() {
            TUICallObserver tUICallObserver = this.f48414a;
            if (tUICallObserver != null) {
                tUICallObserver.onError(this.f48415b, this.f48416c);
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TUICallObserver f48417a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f48418b;

        public b(j jVar, TUICallObserver tUICallObserver, String str) {
            this.f48417a = tUICallObserver;
            this.f48418b = str;
        }

        public void run() {
            TUICallObserver tUICallObserver = this.f48417a;
            if (tUICallObserver != null) {
                tUICallObserver.onUserJoin(this.f48418b);
            }
        }
    }

    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TUICallObserver f48419a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f48420b;

        public c(j jVar, TUICallObserver tUICallObserver, String str) {
            this.f48419a = tUICallObserver;
            this.f48420b = str;
        }

        public void run() {
            TUICallObserver tUICallObserver = this.f48419a;
            if (tUICallObserver != null) {
                tUICallObserver.onUserLeave(this.f48420b);
            }
        }
    }

    public class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TUICallObserver f48421a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f48422b;

        public d(j jVar, TUICallObserver tUICallObserver, String str) {
            this.f48421a = tUICallObserver;
            this.f48422b = str;
        }

        public void run() {
            TUICallObserver tUICallObserver = this.f48421a;
            if (tUICallObserver != null) {
                tUICallObserver.onUserReject(this.f48422b);
            }
        }
    }

    public class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TUICallObserver f48423a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f48424b;

        public e(j jVar, TUICallObserver tUICallObserver, String str) {
            this.f48423a = tUICallObserver;
            this.f48424b = str;
        }

        public void run() {
            TUICallObserver tUICallObserver = this.f48423a;
            if (tUICallObserver != null) {
                tUICallObserver.onUserNoResponse(this.f48424b);
            }
        }
    }

    public class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TUICallObserver f48425a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f48426b;

        public f(j jVar, TUICallObserver tUICallObserver, String str) {
            this.f48425a = tUICallObserver;
            this.f48426b = str;
        }

        public void run() {
            TUICallObserver tUICallObserver = this.f48425a;
            if (tUICallObserver != null) {
                tUICallObserver.onUserLineBusy(this.f48426b);
            }
        }
    }

    public class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TUICallObserver f48427a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f48428b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f48429c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f48430d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TUICallDefine.MediaType f48431e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48432f;

        public g(j jVar, TUICallObserver tUICallObserver, String str, List list, String str2, TUICallDefine.MediaType mediaType, String str3) {
            this.f48427a = tUICallObserver;
            this.f48428b = str;
            this.f48429c = list;
            this.f48430d = str2;
            this.f48431e = mediaType;
            this.f48432f = str3;
        }

        public void run() {
            TUICallObserver tUICallObserver = this.f48427a;
            if (tUICallObserver != null) {
                tUICallObserver.onCallReceived(this.f48428b, this.f48429c, this.f48430d, this.f48431e, this.f48432f);
                this.f48427a.onCallReceived(this.f48428b, this.f48429c, this.f48430d, this.f48431e);
            }
        }
    }

    public class h implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TUICallObserver f48433a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TUICommonDefine.RoomId f48434b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TUICallDefine.MediaType f48435c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ TUICallDefine.Role f48436d;

        public h(j jVar, TUICallObserver tUICallObserver, TUICommonDefine.RoomId roomId, TUICallDefine.MediaType mediaType, TUICallDefine.Role role) {
            this.f48433a = tUICallObserver;
            this.f48434b = roomId;
            this.f48435c = mediaType;
            this.f48436d = role;
        }

        public void run() {
            TUICallObserver tUICallObserver = this.f48433a;
            if (tUICallObserver != null) {
                tUICallObserver.onCallBegin(this.f48434b, this.f48435c, this.f48436d);
            }
        }
    }

    public class i implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TUICallObserver f48437a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f48438b;

        public i(j jVar, TUICallObserver tUICallObserver, String str) {
            this.f48437a = tUICallObserver;
            this.f48438b = str;
        }

        public void run() {
            TUICallObserver tUICallObserver = this.f48437a;
            if (tUICallObserver != null) {
                tUICallObserver.onCallCancelled(this.f48438b);
            }
        }
    }

    public void a(int i11, String str) {
        TUILog.e("CallingObserverManager", "onError, code: " + i11 + ", msg:" + str);
        for (WeakReference next : this.f48412a) {
            if (next != null) {
                this.f48413b.post(new a(this, (TUICallObserver) next.get(), i11, str));
            }
        }
    }

    public void b(String str) {
        TUILog.i("CallingObserverManager", "onUserJoin, userId: " + str);
        for (WeakReference next : this.f48412a) {
            if (next != null) {
                this.f48413b.post(new b(this, (TUICallObserver) next.get(), str));
            }
        }
    }

    public void c(String str) {
        TUILog.i("CallingObserverManager", "onUserLeave, userId: " + str);
        for (WeakReference next : this.f48412a) {
            if (next != null) {
                this.f48413b.post(new c(this, (TUICallObserver) next.get(), str));
            }
        }
    }

    public void d(String str) {
        TUILog.i("CallingObserverManager", "onUserLineBusy, userId: " + str);
        for (WeakReference next : this.f48412a) {
            if (next != null) {
                this.f48413b.post(new f(this, (TUICallObserver) next.get(), str));
            }
        }
    }

    public void e(String str) {
        TUILog.i("CallingObserverManager", "onUserNoResponse, userId: " + str);
        for (WeakReference next : this.f48412a) {
            if (next != null) {
                this.f48413b.post(new e(this, (TUICallObserver) next.get(), str));
            }
        }
    }

    public void f(String str) {
        TUILog.i("CallingObserverManager", "onUserReject, userId: " + str);
        for (WeakReference next : this.f48412a) {
            if (next != null) {
                this.f48413b.post(new d(this, (TUICallObserver) next.get(), str));
            }
        }
    }

    public void a(String str, List<String> list, String str2, TUICallDefine.MediaType mediaType, String str3) {
        TUILog.i("CallingObserverManager", "onCallReceived, callerId: " + str + " ,calleeIdList: " + list + " ,callMediaType: " + mediaType + " ,groupId: " + str2 + " ,userData: " + str3);
        for (WeakReference next : this.f48412a) {
            if (next != null) {
                this.f48413b.post(new g(this, (TUICallObserver) next.get(), str, list, str2, mediaType, str3));
            }
        }
    }

    public void a(TUICommonDefine.RoomId roomId, TUICallDefine.MediaType mediaType, TUICallDefine.Role role) {
        TUILog.i("CallingObserverManager", "onCallBegin, roomId: " + roomId + " , callMediaType: " + mediaType + " , callRole: " + role);
        for (WeakReference next : this.f48412a) {
            if (next != null) {
                this.f48413b.post(new h(this, (TUICallObserver) next.get(), roomId, mediaType, role));
            }
        }
    }

    public void a(String str) {
        TUILog.i("CallingObserverManager", "onCallCancelled, callerId: " + str);
        for (WeakReference next : this.f48412a) {
            if (next != null) {
                this.f48413b.post(new i(this, (TUICallObserver) next.get(), str));
            }
        }
    }

    public final void a(TRTCCloudDef.TRTCQuality tRTCQuality, List<TUICommonDefine.NetworkQualityInfo> list) {
        if (tRTCQuality != null) {
            TUICommonDefine.NetworkQualityInfo networkQualityInfo = new TUICommonDefine.NetworkQualityInfo();
            networkQualityInfo.userId = tRTCQuality.userId;
            networkQualityInfo.quality = TUICommonDefine.NetworkQuality.values()[tRTCQuality.quality];
            list.add(networkQualityInfo);
        }
    }
}
