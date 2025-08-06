package androidx.media;

import android.content.Context;
import android.content.Intent;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat;
import java.util.ArrayList;
import java.util.List;

public class b {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f10183a;

        /* renamed from: b  reason: collision with root package name */
        public final Bundle f10184b;
    }

    /* renamed from: androidx.media.b$b  reason: collision with other inner class name */
    public static class C0047b extends MediaBrowserService {

        /* renamed from: b  reason: collision with root package name */
        public final d f10185b;

        public C0047b(Context context, d dVar) {
            attachBaseContext(context);
            this.f10185b = dVar;
        }

        public MediaBrowserService.BrowserRoot onGetRoot(String str, int i11, Bundle bundle) {
            MediaSessionCompat.ensureClassLoader(bundle);
            a b11 = this.f10185b.b(str, i11, bundle == null ? null : new Bundle(bundle));
            if (b11 == null) {
                return null;
            }
            return new MediaBrowserService.BrowserRoot(b11.f10183a, b11.f10184b);
        }

        public void onLoadChildren(String str, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> result) {
            this.f10185b.c(str, new c(result));
        }
    }

    public static class c<T> {

        /* renamed from: a  reason: collision with root package name */
        public MediaBrowserService.Result f10186a;

        public c(MediaBrowserService.Result result) {
            this.f10186a = result;
        }

        public List<MediaBrowser.MediaItem> a(List<Parcel> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Parcel next : list) {
                next.setDataPosition(0);
                arrayList.add(MediaBrowser.MediaItem.CREATOR.createFromParcel(next));
                next.recycle();
            }
            return arrayList;
        }

        public void b(T t11) {
            if (t11 instanceof List) {
                this.f10186a.sendResult(a((List) t11));
            } else if (t11 instanceof Parcel) {
                Parcel parcel = (Parcel) t11;
                parcel.setDataPosition(0);
                this.f10186a.sendResult(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
                parcel.recycle();
            } else {
                this.f10186a.sendResult((Object) null);
            }
        }
    }

    public interface d {
        a b(String str, int i11, Bundle bundle);

        void c(String str, c<List<Parcel>> cVar);
    }

    public static Object a(Context context, d dVar) {
        return new C0047b(context, dVar);
    }

    public static IBinder b(Object obj, Intent intent) {
        return ((MediaBrowserService) obj).onBind(intent);
    }

    public static void c(Object obj) {
        ((MediaBrowserService) obj).onCreate();
    }
}
