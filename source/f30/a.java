package f30;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.provider.MediaStore;
import java.util.Locale;

public class a {

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f60251c = {"_id", "_display_name", "_size", "width", "height"};

    /* renamed from: a  reason: collision with root package name */
    public final Context f60252a;

    /* renamed from: b  reason: collision with root package name */
    public final int f60253b;

    public a(Context context, int i11) {
        this.f60252a = context;
        this.f60253b = i11;
    }

    @SuppressLint({"NewApi"})
    public Cursor a(int i11) {
        if (this.f60252a == null) {
            return null;
        }
        String b11 = b();
        if (this.f60253b >= 26) {
            Bundle bundle = new Bundle();
            bundle.putInt("android:query-arg-limit", i11);
            bundle.putStringArray("android:query-arg-sort-columns", new String[]{b11});
            bundle.putInt("android:query-arg-sort-direction", 1);
            return this.f60252a.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, f60251c, bundle, (CancellationSignal) null);
        }
        return this.f60252a.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, f60251c, (String) null, (String[]) null, String.format(Locale.US, "%s DESC LIMIT %s", new Object[]{b11, Integer.valueOf(i11)}));
    }

    @SuppressLint({"InlinedApi"})
    public String b() {
        return this.f60253b >= 29 ? "datetaken" : "date_modified";
    }
}
