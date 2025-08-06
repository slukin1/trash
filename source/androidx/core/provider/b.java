package androidx.core.provider;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import androidx.core.provider.FontsContractCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import y0.c;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final Comparator<byte[]> f8434a = y0.b.f61714b;

    public static class a {
        public static Cursor a(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, Object obj) {
            return contentResolver.query(uri, strArr, str, strArr2, str2, (CancellationSignal) obj);
        }
    }

    public static List<byte[]> b(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature byteArray : signatureArr) {
            arrayList.add(byteArray.toByteArray());
        }
        return arrayList;
    }

    public static boolean c(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i11 = 0; i11 < list.size(); i11++) {
            if (!Arrays.equals(list.get(i11), list2.get(i11))) {
                return false;
            }
        }
        return true;
    }

    public static List<List<byte[]>> d(c cVar, Resources resources) {
        if (cVar.b() != null) {
            return cVar.b();
        }
        return androidx.core.content.res.a.c(resources, cVar.c());
    }

    public static FontsContractCompat.a e(Context context, c cVar, CancellationSignal cancellationSignal) throws PackageManager.NameNotFoundException {
        ProviderInfo f11 = f(context.getPackageManager(), cVar, context.getResources());
        if (f11 == null) {
            return FontsContractCompat.a.a(1, (FontsContractCompat.b[]) null);
        }
        return FontsContractCompat.a.a(0, h(context, cVar, f11.authority, cancellationSignal));
    }

    public static ProviderInfo f(PackageManager packageManager, c cVar, Resources resources) throws PackageManager.NameNotFoundException {
        String e11 = cVar.e();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(e11, 0);
        if (resolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + e11);
        } else if (resolveContentProvider.packageName.equals(cVar.f())) {
            List<byte[]> b11 = b(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
            Collections.sort(b11, f8434a);
            List<List<byte[]>> d11 = d(cVar, resources);
            for (int i11 = 0; i11 < d11.size(); i11++) {
                ArrayList arrayList = new ArrayList(d11.get(i11));
                Collections.sort(arrayList, f8434a);
                if (c(b11, arrayList)) {
                    return resolveContentProvider;
                }
            }
            return null;
        } else {
            throw new PackageManager.NameNotFoundException("Found content provider " + e11 + ", but package was not " + cVar.f());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ int g(byte[] r4, byte[] r5) {
        /*
            int r0 = r4.length
            int r1 = r5.length
            if (r0 == r1) goto L_0x0008
            int r4 = r4.length
            int r5 = r5.length
        L_0x0006:
            int r4 = r4 - r5
            return r4
        L_0x0008:
            r0 = 0
            r1 = r0
        L_0x000a:
            int r2 = r4.length
            if (r1 >= r2) goto L_0x001b
            byte r2 = r4[r1]
            byte r3 = r5[r1]
            if (r2 == r3) goto L_0x0018
            byte r4 = r4[r1]
            byte r5 = r5[r1]
            goto L_0x0006
        L_0x0018:
            int r1 = r1 + 1
            goto L_0x000a
        L_0x001b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.provider.b.g(byte[], byte[]):int");
    }

    public static FontsContractCompat.b[] h(Context context, c cVar, String str, CancellationSignal cancellationSignal) {
        int i11;
        Uri uri;
        boolean z11;
        int i12;
        Cursor query;
        String str2 = str;
        ArrayList arrayList = new ArrayList();
        Uri build = new Uri.Builder().scheme("content").authority(str2).build();
        Uri build2 = new Uri.Builder().scheme("content").authority(str2).appendPath("file").build();
        Cursor cursor = null;
        try {
            String[] strArr = {"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"};
            ContentResolver contentResolver = context.getContentResolver();
            int i13 = 0;
            if (Build.VERSION.SDK_INT > 16) {
                query = a.a(contentResolver, build, strArr, "query = ?", new String[]{cVar.g()}, (String) null, cancellationSignal);
            } else {
                query = contentResolver.query(build, strArr, "query = ?", new String[]{cVar.g()}, (String) null);
            }
            if (cursor != null && cursor.getCount() > 0) {
                int columnIndex = cursor.getColumnIndex("result_code");
                ArrayList arrayList2 = new ArrayList();
                int columnIndex2 = cursor.getColumnIndex("_id");
                int columnIndex3 = cursor.getColumnIndex("file_id");
                int columnIndex4 = cursor.getColumnIndex("font_ttc_index");
                int columnIndex5 = cursor.getColumnIndex("font_weight");
                int columnIndex6 = cursor.getColumnIndex("font_italic");
                while (cursor.moveToNext()) {
                    int i14 = columnIndex != -1 ? cursor.getInt(columnIndex) : i13;
                    int i15 = columnIndex4 != -1 ? cursor.getInt(columnIndex4) : i13;
                    if (columnIndex3 == -1) {
                        i11 = i14;
                        uri = ContentUris.withAppendedId(build, cursor.getLong(columnIndex2));
                    } else {
                        i11 = i14;
                        uri = ContentUris.withAppendedId(build2, cursor.getLong(columnIndex3));
                    }
                    int i16 = columnIndex5 != -1 ? cursor.getInt(columnIndex5) : 400;
                    if (columnIndex6 == -1 || cursor.getInt(columnIndex6) != 1) {
                        i12 = i11;
                        z11 = false;
                    } else {
                        i12 = i11;
                        z11 = true;
                    }
                    arrayList2.add(FontsContractCompat.b.a(uri, i15, i16, z11, i12));
                    i13 = 0;
                }
                arrayList = arrayList2;
            }
            return (FontsContractCompat.b[]) arrayList.toArray(new FontsContractCompat.b[0]);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
}
