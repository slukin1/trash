package androidx.media;

import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import androidx.media.b;

public class c {

    public static class a extends b.C0047b {
        public a(Context context, b bVar) {
            super(context, bVar);
        }

        public void onLoadItem(String str, MediaBrowserService.Result<MediaBrowser.MediaItem> result) {
            ((b) this.f10185b).e(str, new b.c(result));
        }
    }

    public interface b extends b.d {
        void e(String str, b.c<Parcel> cVar);
    }

    public static Object a(Context context, b bVar) {
        return new a(context, bVar);
    }
}
