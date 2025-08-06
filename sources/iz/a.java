package iz;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import com.zendesk.belvedere.BelvedereCallback;
import com.zendesk.belvedere.BelvedereIntent;
import com.zendesk.belvedere.BelvedereResult;
import com.zendesk.belvedere.BelvedereSource;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final com.zendesk.belvedere.a f52887a;

    /* renamed from: b  reason: collision with root package name */
    public final e f52888b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<Integer, BelvedereResult> f52889c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public final b f52890d;

    /* renamed from: iz.a$a  reason: collision with other inner class name */
    public static /* synthetic */ class C0647a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f52891a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.zendesk.belvedere.BelvedereSource[] r0 = com.zendesk.belvedere.BelvedereSource.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f52891a = r0
                com.zendesk.belvedere.BelvedereSource r1 = com.zendesk.belvedere.BelvedereSource.Gallery     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f52891a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.zendesk.belvedere.BelvedereSource r1 = com.zendesk.belvedere.BelvedereSource.Camera     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: iz.a.C0647a.<clinit>():void");
        }
    }

    public a(com.zendesk.belvedere.a aVar, e eVar) {
        this.f52887a = aVar;
        this.f52888b = eVar;
        this.f52890d = aVar.b();
    }

    public final boolean a(Context context) {
        return h(context);
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

    public List<BelvedereIntent> c(Context context) {
        TreeSet<BelvedereSource> c11 = this.f52887a.c();
        ArrayList arrayList = new ArrayList();
        Iterator<BelvedereSource> it2 = c11.iterator();
        while (it2.hasNext()) {
            BelvedereIntent belvedereIntent = null;
            int i11 = C0647a.f52891a[it2.next().ordinal()];
            if (i11 == 1) {
                belvedereIntent = g(context);
            } else if (i11 == 2) {
                belvedereIntent = d(context);
            }
            if (belvedereIntent != null) {
                arrayList.add(belvedereIntent);
            }
        }
        return arrayList;
    }

    public final BelvedereIntent d(Context context) {
        if (a(context)) {
            return k(context);
        }
        return null;
    }

    public void e(Context context, int i11, int i12, Intent intent, BelvedereCallback<List<BelvedereResult>> belvedereCallback) {
        ArrayList arrayList = new ArrayList();
        if (i11 == this.f52887a.h()) {
            b bVar = this.f52890d;
            Locale locale = Locale.US;
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(i12 == -1);
            bVar.d("BelvedereImagePicker", String.format(locale, "Parsing activity result - Gallery - Ok: %s", objArr));
            if (i12 == -1) {
                List<Uri> b11 = b(intent);
                this.f52890d.d("BelvedereImagePicker", String.format(locale, "Number of items received from gallery: %s", new Object[]{Integer.valueOf(b11.size())}));
                new c(context, this.f52890d, this.f52888b, belvedereCallback).execute(b11.toArray(new Uri[b11.size()]));
                return;
            }
        } else if (this.f52889c.containsKey(Integer.valueOf(i11))) {
            b bVar2 = this.f52890d;
            Locale locale2 = Locale.US;
            Object[] objArr2 = new Object[1];
            objArr2[0] = Boolean.valueOf(i12 == -1);
            bVar2.d("BelvedereImagePicker", String.format(locale2, "Parsing activity result - Camera - Ok: %s", objArr2));
            BelvedereResult belvedereResult = this.f52889c.get(Integer.valueOf(i11));
            this.f52888b.n(context, belvedereResult.getUri(), 3);
            if (i12 == -1) {
                arrayList.add(belvedereResult);
                this.f52890d.d("BelvedereImagePicker", String.format(locale2, "Image from camera: %s", new Object[]{belvedereResult.getFile()}));
            }
            this.f52889c.remove(Integer.valueOf(i11));
        }
        if (belvedereCallback != null) {
            belvedereCallback.internalSuccess(arrayList);
        }
    }

    @TargetApi(19)
    public final Intent f() {
        Intent intent;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 19) {
            this.f52890d.d("BelvedereImagePicker", "Gallery Intent, using 'ACTION_OPEN_DOCUMENT'");
            intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        } else {
            this.f52890d.d("BelvedereImagePicker", "Gallery Intent, using 'ACTION_GET_CONTENT'");
            intent = new Intent("android.intent.action.GET_CONTENT");
        }
        intent.setType(this.f52887a.f());
        intent.addCategory("android.intent.category.OPENABLE");
        if (i11 >= 18) {
            intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", this.f52887a.a());
        }
        return intent;
    }

    public BelvedereIntent g(Context context) {
        if (i(context)) {
            return new BelvedereIntent(f(), this.f52887a.h(), BelvedereSource.Gallery, (String) null);
        }
        return null;
    }

    public final boolean h(Context context) {
        Intent intent = new Intent();
        intent.setAction("android.media.action.IMAGE_CAPTURE");
        PackageManager packageManager = context.getPackageManager();
        boolean z11 = packageManager.hasSystemFeature("android.hardware.camera") || packageManager.hasSystemFeature("android.hardware.camera.front");
        boolean j11 = j(intent, context);
        this.f52890d.d("BelvedereImagePicker", String.format(Locale.US, "Camera present: %b, Camera App present: %b", new Object[]{Boolean.valueOf(z11), Boolean.valueOf(j11)}));
        if (!z11 || !j11) {
            return false;
        }
        return true;
    }

    public final boolean i(Context context) {
        return j(f(), context);
    }

    public final boolean j(Intent intent, Context context) {
        return intent.resolveActivity(context.getPackageManager()) != null;
    }

    public final BelvedereIntent k(Context context) {
        Set<Integer> keySet = this.f52889c.keySet();
        int d11 = this.f52887a.d();
        int e11 = this.f52887a.e();
        while (true) {
            if (e11 >= this.f52887a.d()) {
                break;
            } else if (!keySet.contains(Integer.valueOf(e11))) {
                d11 = e11;
                break;
            } else {
                e11++;
            }
        }
        File f11 = this.f52888b.f(context);
        String str = null;
        if (f11 == null) {
            this.f52890d.w("BelvedereImagePicker", "Camera Intent: Image path is null. There's something wrong with the storage.");
            return null;
        }
        Uri i11 = this.f52888b.i(context, f11);
        if (i11 == null) {
            this.f52890d.w("BelvedereImagePicker", "Camera Intent: Uri to file is null. There's something wrong with the storage or FileProvider configuration.");
            return null;
        }
        this.f52889c.put(Integer.valueOf(d11), new BelvedereResult(f11, i11));
        boolean z11 = false;
        this.f52890d.d("BelvedereImagePicker", String.format(Locale.US, "Camera Intent: Request Id: %s - File: %s - Uri: %s", new Object[]{Integer.valueOf(d11), f11, i11}));
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("output", i11);
        this.f52888b.m(context, intent, i11, 3);
        if (g.a(context, "android.permission.CAMERA") && !g.b(context, "android.permission.CAMERA")) {
            z11 = true;
        }
        BelvedereSource belvedereSource = BelvedereSource.Camera;
        if (z11) {
            str = "android.permission.CAMERA";
        }
        return new BelvedereIntent(intent, d11, belvedereSource, str);
    }
}
