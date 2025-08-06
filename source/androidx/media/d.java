package androidx.media;

import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;
import androidx.media.c;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public static Field f10187a;

    public static class a extends c.a {
        public a(Context context, c cVar) {
            super(context, cVar);
        }

        public void onLoadChildren(String str, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> result, Bundle bundle) {
            MediaSessionCompat.ensureClassLoader(bundle);
            ((c) this.f10185b).a(str, new b(result), bundle);
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public MediaBrowserService.Result f10188a;

        public b(MediaBrowserService.Result result) {
            this.f10188a = result;
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

        public void b(List<Parcel> list, int i11) {
            try {
                d.f10187a.setInt(this.f10188a, i11);
            } catch (IllegalAccessException e11) {
                Log.w("MBSCompatApi26", e11);
            }
            this.f10188a.sendResult(a(list));
        }
    }

    public interface c extends c.b {
        void a(String str, b bVar, Bundle bundle);
    }

    static {
        try {
            Field declaredField = MediaBrowserService.Result.class.getDeclaredField("mFlags");
            f10187a = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e11) {
            Log.w("MBSCompatApi26", e11);
        }
    }

    public static Object a(Context context, c cVar) {
        return new a(context, cVar);
    }
}
