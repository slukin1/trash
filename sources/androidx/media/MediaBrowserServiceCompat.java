package androidx.media;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.media.b;
import androidx.media.c;
import androidx.media.d;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class MediaBrowserServiceCompat extends Service {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f10090g = Log.isLoggable("MBServiceCompat", 3);

    /* renamed from: b  reason: collision with root package name */
    public g f10091b;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayMap<IBinder, f> f10092c = new ArrayMap<>();

    /* renamed from: d  reason: collision with root package name */
    public f f10093d;

    /* renamed from: e  reason: collision with root package name */
    public final q f10094e = new q();

    /* renamed from: f  reason: collision with root package name */
    public MediaSessionCompat.Token f10095f;

    public class a extends m<List<MediaBrowserCompat.MediaItem>> {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f10096f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f10097g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Bundle f10098h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Bundle f10099i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Object obj, f fVar, String str, Bundle bundle, Bundle bundle2) {
            super(obj);
            this.f10096f = fVar;
            this.f10097g = str;
            this.f10098h = bundle;
            this.f10099i = bundle2;
        }

        /* renamed from: h */
        public void d(List<MediaBrowserCompat.MediaItem> list) {
            if (MediaBrowserServiceCompat.this.f10092c.get(this.f10096f.f10112f.asBinder()) == this.f10096f) {
                if ((a() & 1) != 0) {
                    list = MediaBrowserServiceCompat.this.b(list, this.f10098h);
                }
                try {
                    this.f10096f.f10112f.a(this.f10097g, list, this.f10098h, this.f10099i);
                } catch (RemoteException unused) {
                    Log.w("MBServiceCompat", "Calling onLoadChildren() failed for id=" + this.f10097g + " package=" + this.f10096f.f10107a);
                }
            } else if (MediaBrowserServiceCompat.f10090g) {
                Log.d("MBServiceCompat", "Not sending onLoadChildren result for connection that has been disconnected. pkg=" + this.f10096f.f10107a + " id=" + this.f10097g);
            }
        }
    }

    public class b extends m<MediaBrowserCompat.MediaItem> {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ResultReceiver f10101f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Object obj, ResultReceiver resultReceiver) {
            super(obj);
            this.f10101f = resultReceiver;
        }

        /* renamed from: h */
        public void d(MediaBrowserCompat.MediaItem mediaItem) {
            if ((a() & 2) != 0) {
                this.f10101f.send(-1, (Bundle) null);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable("media_item", mediaItem);
            this.f10101f.send(0, bundle);
        }
    }

    public class c extends m<List<MediaBrowserCompat.MediaItem>> {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ResultReceiver f10103f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Object obj, ResultReceiver resultReceiver) {
            super(obj);
            this.f10103f = resultReceiver;
        }

        /* renamed from: h */
        public void d(List<MediaBrowserCompat.MediaItem> list) {
            if ((a() & 4) != 0 || list == null) {
                this.f10103f.send(-1, (Bundle) null);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelableArray("search_results", (Parcelable[]) list.toArray(new MediaBrowserCompat.MediaItem[0]));
            this.f10103f.send(0, bundle);
        }
    }

    public class d extends m<Bundle> {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ResultReceiver f10105f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(Object obj, ResultReceiver resultReceiver) {
            super(obj);
            this.f10105f = resultReceiver;
        }

        public void c(Bundle bundle) {
            this.f10105f.send(-1, bundle);
        }

        /* renamed from: h */
        public void d(Bundle bundle) {
            this.f10105f.send(0, bundle);
        }
    }

    public static final class e {
    }

    public class f implements IBinder.DeathRecipient {

        /* renamed from: a  reason: collision with root package name */
        public final String f10107a;

        /* renamed from: b  reason: collision with root package name */
        public final int f10108b;

        /* renamed from: c  reason: collision with root package name */
        public final int f10109c;

        /* renamed from: d  reason: collision with root package name */
        public final e f10110d;

        /* renamed from: e  reason: collision with root package name */
        public final Bundle f10111e;

        /* renamed from: f  reason: collision with root package name */
        public final o f10112f;

        /* renamed from: g  reason: collision with root package name */
        public final HashMap<String, List<androidx.core.util.c<IBinder, Bundle>>> f10113g = new HashMap<>();

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                f fVar = f.this;
                MediaBrowserServiceCompat.this.f10092c.remove(fVar.f10112f.asBinder());
            }
        }

        public f(String str, int i11, int i12, Bundle bundle, o oVar) {
            this.f10107a = str;
            this.f10108b = i11;
            this.f10109c = i12;
            this.f10110d = new e(str, i11, i12);
            this.f10111e = bundle;
            this.f10112f = oVar;
        }

        public void binderDied() {
            MediaBrowserServiceCompat.this.f10094e.post(new a());
        }
    }

    public interface g {
        IBinder d(Intent intent);

        void onCreate();
    }

    public class h implements g, b.d {

        /* renamed from: a  reason: collision with root package name */
        public final List<Bundle> f10116a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public Object f10117b;

        /* renamed from: c  reason: collision with root package name */
        public Messenger f10118c;

        public class a extends m<List<MediaBrowserCompat.MediaItem>> {

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b.c f10120f;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(Object obj, b.c cVar) {
                super(obj);
                this.f10120f = cVar;
            }

            /* renamed from: h */
            public void d(List<MediaBrowserCompat.MediaItem> list) {
                ArrayList arrayList;
                if (list != null) {
                    arrayList = new ArrayList();
                    for (MediaBrowserCompat.MediaItem writeToParcel : list) {
                        Parcel obtain = Parcel.obtain();
                        writeToParcel.writeToParcel(obtain, 0);
                        arrayList.add(obtain);
                    }
                } else {
                    arrayList = null;
                }
                this.f10120f.b(arrayList);
            }
        }

        public h() {
        }

        public b.a b(String str, int i11, Bundle bundle) {
            IBinder iBinder;
            if (!(bundle == null || bundle.getInt("extra_client_version", 0) == 0)) {
                bundle.remove("extra_client_version");
                this.f10118c = new Messenger(MediaBrowserServiceCompat.this.f10094e);
                Bundle bundle2 = new Bundle();
                bundle2.putInt("extra_service_version", 2);
                p0.g.b(bundle2, "extra_messenger", this.f10118c.getBinder());
                MediaSessionCompat.Token token = MediaBrowserServiceCompat.this.f10095f;
                if (token != null) {
                    IMediaSession extraBinder = token.getExtraBinder();
                    if (extraBinder == null) {
                        iBinder = null;
                    } else {
                        iBinder = extraBinder.asBinder();
                    }
                    p0.g.b(bundle2, "extra_session_binder", iBinder);
                } else {
                    this.f10116a.add(bundle2);
                }
            }
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat.f10093d = new f(str, -1, i11, bundle, (o) null);
            MediaBrowserServiceCompat.this.e(str, i11, bundle);
            MediaBrowserServiceCompat.this.f10093d = null;
            return null;
        }

        public void c(String str, b.c<List<Parcel>> cVar) {
            MediaBrowserServiceCompat.this.f(str, new a(str, cVar));
        }

        public IBinder d(Intent intent) {
            return b.b(this.f10117b, intent);
        }

        public void onCreate() {
            Object a11 = b.a(MediaBrowserServiceCompat.this, this);
            this.f10117b = a11;
            b.c(a11);
        }
    }

    public class i extends h implements c.b {

        public class a extends m<MediaBrowserCompat.MediaItem> {

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b.c f10123f;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(Object obj, b.c cVar) {
                super(obj);
                this.f10123f = cVar;
            }

            /* renamed from: h */
            public void d(MediaBrowserCompat.MediaItem mediaItem) {
                if (mediaItem == null) {
                    this.f10123f.b(null);
                    return;
                }
                Parcel obtain = Parcel.obtain();
                mediaItem.writeToParcel(obtain, 0);
                this.f10123f.b(obtain);
            }
        }

        public i() {
            super();
        }

        public void e(String str, b.c<Parcel> cVar) {
            MediaBrowserServiceCompat.this.h(str, new a(str, cVar));
        }

        public void onCreate() {
            Object a11 = c.a(MediaBrowserServiceCompat.this, this);
            this.f10117b = a11;
            b.c(a11);
        }
    }

    public class j extends i implements d.c {

        public class a extends m<List<MediaBrowserCompat.MediaItem>> {

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d.b f10126f;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(Object obj, d.b bVar) {
                super(obj);
                this.f10126f = bVar;
            }

            /* renamed from: h */
            public void d(List<MediaBrowserCompat.MediaItem> list) {
                ArrayList arrayList;
                if (list != null) {
                    arrayList = new ArrayList();
                    for (MediaBrowserCompat.MediaItem writeToParcel : list) {
                        Parcel obtain = Parcel.obtain();
                        writeToParcel.writeToParcel(obtain, 0);
                        arrayList.add(obtain);
                    }
                } else {
                    arrayList = null;
                }
                this.f10126f.b(arrayList, a());
            }
        }

        public j() {
            super();
        }

        public void a(String str, d.b bVar, Bundle bundle) {
            MediaBrowserServiceCompat.this.g(str, new a(str, bVar), bundle);
        }

        public void onCreate() {
            Object a11 = d.a(MediaBrowserServiceCompat.this, this);
            this.f10117b = a11;
            b.c(a11);
        }
    }

    public class k extends j {
        public k() {
            super();
        }
    }

    public class l implements g {

        /* renamed from: a  reason: collision with root package name */
        public Messenger f10129a;

        public l() {
        }

        public IBinder d(Intent intent) {
            if ("android.media.browse.MediaBrowserService".equals(intent.getAction())) {
                return this.f10129a.getBinder();
            }
            return null;
        }

        public void onCreate() {
            this.f10129a = new Messenger(MediaBrowserServiceCompat.this.f10094e);
        }
    }

    public static class m<T> {

        /* renamed from: a  reason: collision with root package name */
        public final Object f10131a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f10132b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f10133c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f10134d;

        /* renamed from: e  reason: collision with root package name */
        public int f10135e;

        public m(Object obj) {
            this.f10131a = obj;
        }

        public int a() {
            return this.f10135e;
        }

        public boolean b() {
            return this.f10132b || this.f10133c || this.f10134d;
        }

        public void c(Bundle bundle) {
            throw new UnsupportedOperationException("It is not supported to send an error for " + this.f10131a);
        }

        public void d(T t11) {
            throw null;
        }

        public void e(Bundle bundle) {
            if (this.f10133c || this.f10134d) {
                throw new IllegalStateException("sendError() called when either sendResult() or sendError() had already been called for: " + this.f10131a);
            }
            this.f10134d = true;
            c(bundle);
        }

        public void f(T t11) {
            if (this.f10133c || this.f10134d) {
                throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.f10131a);
            }
            this.f10133c = true;
            d(t11);
        }

        public void g(int i11) {
            this.f10135e = i11;
        }
    }

    public class n {

        public class a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ o f10137b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f10138c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ int f10139d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f10140e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Bundle f10141f;

            public a(o oVar, String str, int i11, int i12, Bundle bundle) {
                this.f10137b = oVar;
                this.f10138c = str;
                this.f10139d = i11;
                this.f10140e = i12;
                this.f10141f = bundle;
            }

            public void run() {
                MediaBrowserServiceCompat.this.f10092c.remove(this.f10137b.asBinder());
                f fVar = new f(this.f10138c, this.f10139d, this.f10140e, this.f10141f, this.f10137b);
                MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                mediaBrowserServiceCompat.f10093d = fVar;
                mediaBrowserServiceCompat.e(this.f10138c, this.f10140e, this.f10141f);
                MediaBrowserServiceCompat.this.f10093d = null;
                Log.i("MBServiceCompat", "No root for client " + this.f10138c + " from service " + getClass().getName());
                try {
                    this.f10137b.b();
                } catch (RemoteException unused) {
                    Log.w("MBServiceCompat", "Calling onConnectFailed() failed. Ignoring. pkg=" + this.f10138c);
                }
            }
        }

        public class b implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ o f10143b;

            public b(o oVar) {
                this.f10143b = oVar;
            }

            public void run() {
                f remove = MediaBrowserServiceCompat.this.f10092c.remove(this.f10143b.asBinder());
                if (remove != null) {
                    remove.f10112f.asBinder().unlinkToDeath(remove, 0);
                }
            }
        }

        public class c implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ o f10145b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f10146c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ IBinder f10147d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Bundle f10148e;

            public c(o oVar, String str, IBinder iBinder, Bundle bundle) {
                this.f10145b = oVar;
                this.f10146c = str;
                this.f10147d = iBinder;
                this.f10148e = bundle;
            }

            public void run() {
                f fVar = MediaBrowserServiceCompat.this.f10092c.get(this.f10145b.asBinder());
                if (fVar == null) {
                    Log.w("MBServiceCompat", "addSubscription for callback that isn't registered id=" + this.f10146c);
                    return;
                }
                MediaBrowserServiceCompat.this.a(this.f10146c, fVar, this.f10147d, this.f10148e);
            }
        }

        public class d implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ o f10150b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f10151c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ IBinder f10152d;

            public d(o oVar, String str, IBinder iBinder) {
                this.f10150b = oVar;
                this.f10151c = str;
                this.f10152d = iBinder;
            }

            public void run() {
                f fVar = MediaBrowserServiceCompat.this.f10092c.get(this.f10150b.asBinder());
                if (fVar == null) {
                    Log.w("MBServiceCompat", "removeSubscription for callback that isn't registered id=" + this.f10151c);
                } else if (!MediaBrowserServiceCompat.this.p(this.f10151c, fVar, this.f10152d)) {
                    Log.w("MBServiceCompat", "removeSubscription called for " + this.f10151c + " which is not subscribed");
                }
            }
        }

        public class e implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ o f10154b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f10155c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ ResultReceiver f10156d;

            public e(o oVar, String str, ResultReceiver resultReceiver) {
                this.f10154b = oVar;
                this.f10155c = str;
                this.f10156d = resultReceiver;
            }

            public void run() {
                f fVar = MediaBrowserServiceCompat.this.f10092c.get(this.f10154b.asBinder());
                if (fVar == null) {
                    Log.w("MBServiceCompat", "getMediaItem for callback that isn't registered id=" + this.f10155c);
                    return;
                }
                MediaBrowserServiceCompat.this.n(this.f10155c, fVar, this.f10156d);
            }
        }

        public class f implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ o f10158b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f10159c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ int f10160d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f10161e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Bundle f10162f;

            public f(o oVar, String str, int i11, int i12, Bundle bundle) {
                this.f10158b = oVar;
                this.f10159c = str;
                this.f10160d = i11;
                this.f10161e = i12;
                this.f10162f = bundle;
            }

            public void run() {
                IBinder asBinder = this.f10158b.asBinder();
                MediaBrowserServiceCompat.this.f10092c.remove(asBinder);
                f fVar = new f(this.f10159c, this.f10160d, this.f10161e, this.f10162f, this.f10158b);
                MediaBrowserServiceCompat.this.f10092c.put(asBinder, fVar);
                try {
                    asBinder.linkToDeath(fVar, 0);
                } catch (RemoteException unused) {
                    Log.w("MBServiceCompat", "IBinder is already dead.");
                }
            }
        }

        public class g implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ o f10164b;

            public g(o oVar) {
                this.f10164b = oVar;
            }

            public void run() {
                IBinder asBinder = this.f10164b.asBinder();
                f remove = MediaBrowserServiceCompat.this.f10092c.remove(asBinder);
                if (remove != null) {
                    asBinder.unlinkToDeath(remove, 0);
                }
            }
        }

        public class h implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ o f10166b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f10167c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ Bundle f10168d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ResultReceiver f10169e;

            public h(o oVar, String str, Bundle bundle, ResultReceiver resultReceiver) {
                this.f10166b = oVar;
                this.f10167c = str;
                this.f10168d = bundle;
                this.f10169e = resultReceiver;
            }

            public void run() {
                f fVar = MediaBrowserServiceCompat.this.f10092c.get(this.f10166b.asBinder());
                if (fVar == null) {
                    Log.w("MBServiceCompat", "search for callback that isn't registered query=" + this.f10167c);
                    return;
                }
                MediaBrowserServiceCompat.this.o(this.f10167c, this.f10168d, fVar, this.f10169e);
            }
        }

        public class i implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ o f10171b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f10172c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ Bundle f10173d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ResultReceiver f10174e;

            public i(o oVar, String str, Bundle bundle, ResultReceiver resultReceiver) {
                this.f10171b = oVar;
                this.f10172c = str;
                this.f10173d = bundle;
                this.f10174e = resultReceiver;
            }

            public void run() {
                f fVar = MediaBrowserServiceCompat.this.f10092c.get(this.f10171b.asBinder());
                if (fVar == null) {
                    Log.w("MBServiceCompat", "sendCustomAction for callback that isn't registered action=" + this.f10172c + ", extras=" + this.f10173d);
                    return;
                }
                MediaBrowserServiceCompat.this.l(this.f10172c, this.f10173d, fVar, this.f10174e);
            }
        }

        public n() {
        }

        public void a(String str, IBinder iBinder, Bundle bundle, o oVar) {
            MediaBrowserServiceCompat.this.f10094e.a(new c(oVar, str, iBinder, bundle));
        }

        public void b(String str, int i11, int i12, Bundle bundle, o oVar) {
            if (MediaBrowserServiceCompat.this.c(str, i12)) {
                MediaBrowserServiceCompat.this.f10094e.a(new a(oVar, str, i11, i12, bundle));
                return;
            }
            throw new IllegalArgumentException("Package/uid mismatch: uid=" + i12 + " package=" + str);
        }

        public void c(o oVar) {
            MediaBrowserServiceCompat.this.f10094e.a(new b(oVar));
        }

        public void d(String str, ResultReceiver resultReceiver, o oVar) {
            if (!TextUtils.isEmpty(str) && resultReceiver != null) {
                MediaBrowserServiceCompat.this.f10094e.a(new e(oVar, str, resultReceiver));
            }
        }

        public void e(o oVar, String str, int i11, int i12, Bundle bundle) {
            MediaBrowserServiceCompat.this.f10094e.a(new f(oVar, str, i11, i12, bundle));
        }

        public void f(String str, IBinder iBinder, o oVar) {
            MediaBrowserServiceCompat.this.f10094e.a(new d(oVar, str, iBinder));
        }

        public void g(String str, Bundle bundle, ResultReceiver resultReceiver, o oVar) {
            if (!TextUtils.isEmpty(str) && resultReceiver != null) {
                MediaBrowserServiceCompat.this.f10094e.a(new h(oVar, str, bundle, resultReceiver));
            }
        }

        public void h(String str, Bundle bundle, ResultReceiver resultReceiver, o oVar) {
            if (!TextUtils.isEmpty(str) && resultReceiver != null) {
                MediaBrowserServiceCompat.this.f10094e.a(new i(oVar, str, bundle, resultReceiver));
            }
        }

        public void i(o oVar) {
            MediaBrowserServiceCompat.this.f10094e.a(new g(oVar));
        }
    }

    public interface o {
        void a(String str, List<MediaBrowserCompat.MediaItem> list, Bundle bundle, Bundle bundle2) throws RemoteException;

        IBinder asBinder();

        void b() throws RemoteException;
    }

    public static class p implements o {

        /* renamed from: a  reason: collision with root package name */
        public final Messenger f10176a;

        public p(Messenger messenger) {
            this.f10176a = messenger;
        }

        public void a(String str, List<MediaBrowserCompat.MediaItem> list, Bundle bundle, Bundle bundle2) throws RemoteException {
            Bundle bundle3 = new Bundle();
            bundle3.putString("data_media_item_id", str);
            bundle3.putBundle("data_options", bundle);
            bundle3.putBundle("data_notify_children_changed_options", bundle2);
            if (list != null) {
                bundle3.putParcelableArrayList("data_media_item_list", list instanceof ArrayList ? (ArrayList) list : new ArrayList(list));
            }
            c(3, bundle3);
        }

        public IBinder asBinder() {
            return this.f10176a.getBinder();
        }

        public void b() throws RemoteException {
            c(2, (Bundle) null);
        }

        public final void c(int i11, Bundle bundle) throws RemoteException {
            Message obtain = Message.obtain();
            obtain.what = i11;
            obtain.arg1 = 2;
            obtain.setData(bundle);
            this.f10176a.send(obtain);
        }
    }

    public final class q extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final n f10177a;

        public q() {
            this.f10177a = new n();
        }

        public void a(Runnable runnable) {
            if (Thread.currentThread() == getLooper().getThread()) {
                runnable.run();
            } else {
                post(runnable);
            }
        }

        public void handleMessage(Message message) {
            Bundle data = message.getData();
            switch (message.what) {
                case 1:
                    Bundle bundle = data.getBundle("data_root_hints");
                    MediaSessionCompat.ensureClassLoader(bundle);
                    this.f10177a.b(data.getString("data_package_name"), data.getInt("data_calling_pid"), data.getInt("data_calling_uid"), bundle, new p(message.replyTo));
                    return;
                case 2:
                    this.f10177a.c(new p(message.replyTo));
                    return;
                case 3:
                    Bundle bundle2 = data.getBundle("data_options");
                    MediaSessionCompat.ensureClassLoader(bundle2);
                    this.f10177a.a(data.getString("data_media_item_id"), p0.g.a(data, "data_callback_token"), bundle2, new p(message.replyTo));
                    return;
                case 4:
                    this.f10177a.f(data.getString("data_media_item_id"), p0.g.a(data, "data_callback_token"), new p(message.replyTo));
                    return;
                case 5:
                    this.f10177a.d(data.getString("data_media_item_id"), (ResultReceiver) data.getParcelable("data_result_receiver"), new p(message.replyTo));
                    return;
                case 6:
                    Bundle bundle3 = data.getBundle("data_root_hints");
                    MediaSessionCompat.ensureClassLoader(bundle3);
                    n nVar = this.f10177a;
                    p pVar = new p(message.replyTo);
                    nVar.e(pVar, data.getString("data_package_name"), data.getInt("data_calling_pid"), data.getInt("data_calling_uid"), bundle3);
                    return;
                case 7:
                    this.f10177a.i(new p(message.replyTo));
                    return;
                case 8:
                    Bundle bundle4 = data.getBundle("data_search_extras");
                    MediaSessionCompat.ensureClassLoader(bundle4);
                    this.f10177a.g(data.getString("data_search_query"), bundle4, (ResultReceiver) data.getParcelable("data_result_receiver"), new p(message.replyTo));
                    return;
                case 9:
                    Bundle bundle5 = data.getBundle("data_custom_action_extras");
                    MediaSessionCompat.ensureClassLoader(bundle5);
                    this.f10177a.h(data.getString("data_custom_action"), bundle5, (ResultReceiver) data.getParcelable("data_result_receiver"), new p(message.replyTo));
                    return;
                default:
                    Log.w("MBServiceCompat", "Unhandled message: " + message + "\n  Service version: " + 2 + "\n  Client version: " + message.arg1);
                    return;
            }
        }

        public boolean sendMessageAtTime(Message message, long j11) {
            Bundle data = message.getData();
            data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            data.putInt("data_calling_uid", Binder.getCallingUid());
            data.putInt("data_calling_pid", Binder.getCallingPid());
            return super.sendMessageAtTime(message, j11);
        }
    }

    public void a(String str, f fVar, IBinder iBinder, Bundle bundle) {
        List<androidx.core.util.c> list = fVar.f10113g.get(str);
        if (list == null) {
            list = new ArrayList<>();
        }
        for (androidx.core.util.c cVar : list) {
            if (iBinder == cVar.f8468a && a.a(bundle, (Bundle) cVar.f8469b)) {
                return;
            }
        }
        list.add(new androidx.core.util.c(iBinder, bundle));
        fVar.f10113g.put(str, list);
        m(str, fVar, bundle, (Bundle) null);
        this.f10093d = fVar;
        j(str, bundle);
        this.f10093d = null;
    }

    public List<MediaBrowserCompat.MediaItem> b(List<MediaBrowserCompat.MediaItem> list, Bundle bundle) {
        if (list == null) {
            return null;
        }
        int i11 = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
        int i12 = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
        if (i11 == -1 && i12 == -1) {
            return list;
        }
        int i13 = i12 * i11;
        int i14 = i13 + i12;
        if (i11 < 0 || i12 < 1 || i13 >= list.size()) {
            return Collections.emptyList();
        }
        if (i14 > list.size()) {
            i14 = list.size();
        }
        return list.subList(i13, i14);
    }

    public boolean c(String str, int i11) {
        if (str == null) {
            return false;
        }
        for (String equals : getPackageManager().getPackagesForUid(i11)) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void d(String str, Bundle bundle, m<Bundle> mVar) {
        mVar.e((Bundle) null);
    }

    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public abstract e e(String str, int i11, Bundle bundle);

    public abstract void f(String str, m<List<MediaBrowserCompat.MediaItem>> mVar);

    public void g(String str, m<List<MediaBrowserCompat.MediaItem>> mVar, Bundle bundle) {
        mVar.g(1);
        f(str, mVar);
    }

    public void h(String str, m<MediaBrowserCompat.MediaItem> mVar) {
        mVar.g(2);
        mVar.f(null);
    }

    public void i(String str, Bundle bundle, m<List<MediaBrowserCompat.MediaItem>> mVar) {
        mVar.g(4);
        mVar.f(null);
    }

    public void j(String str, Bundle bundle) {
    }

    public void k(String str) {
    }

    public void l(String str, Bundle bundle, f fVar, ResultReceiver resultReceiver) {
        d dVar = new d(str, resultReceiver);
        this.f10093d = fVar;
        d(str, bundle, dVar);
        this.f10093d = null;
        if (!dVar.b()) {
            throw new IllegalStateException("onCustomAction must call detach() or sendResult() or sendError() before returning for action=" + str + " extras=" + bundle);
        }
    }

    public void m(String str, f fVar, Bundle bundle, Bundle bundle2) {
        a aVar = new a(str, fVar, str, bundle, bundle2);
        this.f10093d = fVar;
        if (bundle == null) {
            f(str, aVar);
        } else {
            g(str, aVar, bundle);
        }
        this.f10093d = null;
        if (!aVar.b()) {
            throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + fVar.f10107a + " id=" + str);
        }
    }

    public void n(String str, f fVar, ResultReceiver resultReceiver) {
        b bVar = new b(str, resultReceiver);
        this.f10093d = fVar;
        h(str, bVar);
        this.f10093d = null;
        if (!bVar.b()) {
            throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + str);
        }
    }

    public void o(String str, Bundle bundle, f fVar, ResultReceiver resultReceiver) {
        c cVar = new c(str, resultReceiver);
        this.f10093d = fVar;
        i(str, bundle, cVar);
        this.f10093d = null;
        if (!cVar.b()) {
            throw new IllegalStateException("onSearch must call detach() or sendResult() before returning for query=" + str);
        }
    }

    public IBinder onBind(Intent intent) {
        return this.f10091b.d(intent);
    }

    public void onCreate() {
        super.onCreate();
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 28) {
            this.f10091b = new k();
        } else if (i11 >= 26) {
            this.f10091b = new j();
        } else if (i11 >= 23) {
            this.f10091b = new i();
        } else if (i11 >= 21) {
            this.f10091b = new h();
        } else {
            this.f10091b = new l();
        }
        this.f10091b.onCreate();
    }

    public boolean p(String str, f fVar, IBinder iBinder) {
        boolean z11 = true;
        boolean z12 = false;
        if (iBinder == null) {
            try {
                if (fVar.f10113g.remove(str) == null) {
                    z11 = false;
                }
                return z11;
            } finally {
                this.f10093d = fVar;
                k(str);
                this.f10093d = null;
            }
        } else {
            List list = fVar.f10113g.get(str);
            if (list != null) {
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    if (iBinder == ((androidx.core.util.c) it2.next()).f8468a) {
                        it2.remove();
                        z12 = true;
                    }
                }
                if (list.size() == 0) {
                    fVar.f10113g.remove(str);
                }
            }
            this.f10093d = fVar;
            k(str);
            this.f10093d = null;
            return z12;
        }
    }
}
