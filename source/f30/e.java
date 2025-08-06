package f30;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import androidx.core.util.c;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import zendesk.belvedere.Callback;
import zendesk.belvedere.MediaIntent;
import zendesk.belvedere.MediaResult;
import zendesk.belvedere.h;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public final h f60257a;

    /* renamed from: b  reason: collision with root package name */
    public final d f60258b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f60259c;

    public e(Context context, h hVar, d dVar) {
        this.f60259c = context;
        this.f60257a = hVar;
        this.f60258b = dVar;
    }

    public final boolean a(Context context) {
        return g(context);
    }

    @SuppressLint({"NewApi"})
    public final List<Uri> b(Intent intent) {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 16 && intent.getClipData() != null) {
            ClipData clipData = intent.getClipData();
            int itemCount = clipData.getItemCount();
            for (int i11 = 0; i11 < itemCount; i11++) {
                ClipData.Item itemAt = clipData.getItemAt(i11);
                if (itemAt.getUri() != null) {
                    arrayList.add(itemAt.getUri());
                }
            }
        } else if (intent.getData() != null) {
            arrayList.add(intent.getData());
        }
        return arrayList;
    }

    public c<MediaIntent, MediaResult> c(int i11) {
        if (a(this.f60259c)) {
            return j(this.f60259c, i11);
        }
        return new c<>(MediaIntent.notAvailable(), null);
    }

    @TargetApi(19)
    public final Intent d(String str, boolean z11, List<String> list) {
        Intent intent;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 19) {
            h.a("Belvedere", "Gallery Intent, using 'ACTION_OPEN_DOCUMENT'");
            intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        } else {
            h.a("Belvedere", "Gallery Intent, using 'ACTION_GET_CONTENT'");
            intent = new Intent("android.intent.action.GET_CONTENT");
        }
        intent.setType(str);
        intent.addCategory("android.intent.category.OPENABLE");
        if (i11 >= 18) {
            intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", z11);
        }
        if (list != null && !list.isEmpty()) {
            intent.putExtra("android.intent.extra.MIME_TYPES", (String[]) list.toArray(new String[0]));
        }
        return intent;
    }

    public void e(Context context, int i11, int i12, Intent intent, Callback<List<MediaResult>> callback, boolean z11) {
        Context context2 = context;
        int i13 = i11;
        int i14 = i12;
        Callback<List<MediaResult>> callback2 = callback;
        ArrayList arrayList = new ArrayList();
        MediaResult b11 = this.f60258b.b(i13);
        if (b11 != null) {
            if (b11.getFile() == null || b11.getUri() == null) {
                Locale locale = Locale.US;
                Object[] objArr = new Object[1];
                objArr[0] = Boolean.valueOf(i14 == -1);
                h.a("Belvedere", String.format(locale, "Parsing activity result - Gallery - Ok: %s", objArr));
                if (i14 == -1) {
                    List<Uri> b12 = b(intent);
                    h.a("Belvedere", String.format(locale, "Number of items received from gallery: %s", new Object[]{Integer.valueOf(b12.size())}));
                    if (z11) {
                        h.a("Belvedere", "Resolving items");
                        g.c(context2, this.f60257a, callback2, b12);
                        return;
                    }
                    h.a("Belvedere", "Resolving items turned off");
                    for (Uri j11 : b12) {
                        arrayList.add(h.j(context2, j11));
                    }
                }
            } else {
                Locale locale2 = Locale.US;
                Object[] objArr2 = new Object[1];
                objArr2[0] = Boolean.valueOf(i14 == -1);
                h.a("Belvedere", String.format(locale2, "Parsing activity result - Camera - Ok: %s", objArr2));
                this.f60257a.m(context2, b11.getUri(), 3);
                if (i14 == -1) {
                    MediaResult j12 = h.j(context2, b11.getUri());
                    arrayList.add(new MediaResult(b11.getFile(), b11.getUri(), b11.getOriginalUri(), b11.getName(), j12.getMimeType(), j12.getSize(), j12.getWidth(), j12.getHeight()));
                    h.a("Belvedere", String.format(locale2, "Image from camera: %s", new Object[]{b11.getFile()}));
                }
                this.f60258b.a(i13);
            }
        }
        if (callback2 != null) {
            callback2.internalSuccess(arrayList);
        }
    }

    public MediaIntent f(int i11, String str, boolean z11, List<String> list) {
        if (!h(this.f60259c)) {
            return MediaIntent.notAvailable();
        }
        return new MediaIntent(i11, d(str, z11, list), (String) null, true, 1);
    }

    public final boolean g(Context context) {
        Intent intent = new Intent();
        intent.setAction("android.media.action.IMAGE_CAPTURE");
        PackageManager packageManager = context.getPackageManager();
        boolean z11 = packageManager.hasSystemFeature("android.hardware.camera") || packageManager.hasSystemFeature("android.hardware.camera.front");
        boolean i11 = i(intent, context);
        h.a("Belvedere", String.format(Locale.US, "Camera present: %b, Camera App present: %b", new Object[]{Boolean.valueOf(z11), Boolean.valueOf(i11)}));
        if (!z11 || !i11) {
            return false;
        }
        return true;
    }

    public final boolean h(Context context) {
        return i(d("*/*", false, new ArrayList()), context);
    }

    public final boolean i(Intent intent, Context context) {
        if (context.getPackageManager().queryIntentActivities(intent, 0).size() > 0) {
            return true;
        }
        return false;
    }

    public final c<MediaIntent, MediaResult> j(Context context, int i11) {
        Context context2 = context;
        File e11 = this.f60257a.e(context2);
        if (e11 == null) {
            h.e("Belvedere", "Camera Intent: Image path is null. There's something wrong with the storage.");
            return null;
        }
        Uri i12 = this.f60257a.i(context2, e11);
        if (i12 == null) {
            h.e("Belvedere", "Camera Intent: Uri to file is null. There's something wrong with the storage or FileProvider configuration.");
            return null;
        }
        h.a("Belvedere", String.format(Locale.US, "Camera Intent: Request Id: %s - File: %s - Uri: %s", new Object[]{Integer.valueOf(i11), e11, i12}));
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("output", i12);
        this.f60257a.l(context2, intent, i12, 3);
        boolean z11 = f.a(context2, "android.permission.CAMERA") && !f.b(context2, "android.permission.CAMERA");
        MediaResult j11 = h.j(context2, i12);
        String name = e11.getName();
        String mimeType = j11.getMimeType();
        long size = j11.getSize();
        long width = j11.getWidth();
        long height = j11.getHeight();
        String str = "android.permission.CAMERA";
        MediaResult mediaResult = r3;
        MediaResult mediaResult2 = new MediaResult(e11, i12, i12, name, mimeType, size, width, height);
        return new c<>(new MediaIntent(i11, intent, z11 ? str : null, true, 2), mediaResult);
    }
}
