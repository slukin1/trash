package p4;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import m1.a;

public class b {

    /* renamed from: b  reason: collision with root package name */
    public static List<String> f66557b = Arrays.asList(new String[]{"FNumber", "ExposureTime", "ISOSpeedRatings", "GPSAltitude", "GPSAltitudeRef", "FocalLength", "GPSDateStamp", "WhiteBalance", "GPSProcessingMethod", "GPSTimeStamp", "DateTime", "Flash", "GPSLatitude", "GPSLatitudeRef", "GPSLongitude", "GPSLongitudeRef", "Make", "Model"});

    /* renamed from: a  reason: collision with root package name */
    public a f66558a;

    public b(String str) throws IOException {
        this.f66558a = new a(str);
    }

    public static void a(a aVar, a aVar2) {
        for (String b11 : f66557b) {
            b(aVar, aVar2, b11);
        }
        try {
            aVar2.X();
        } catch (IOException unused) {
        }
    }

    public static void b(a aVar, a aVar2, String str) {
        if (aVar.g(str) != null) {
            aVar2.c0(str, aVar.g(str));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0079 A[SYNTHETIC, Splitter:B:15:0x0079] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0083 A[SYNTHETIC, Splitter:B:20:0x0083] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.io.ByteArrayOutputStream c(android.content.Context r5, java.io.ByteArrayOutputStream r6) {
        /*
            r4 = this;
            r0 = 0
            java.util.UUID r1 = java.util.UUID.randomUUID()     // Catch:{ Exception -> 0x005d }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x005d }
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x005d }
            java.io.File r5 = r5.getCacheDir()     // Catch:{ Exception -> 0x005d }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x005d }
            r3.<init>()     // Catch:{ Exception -> 0x005d }
            r3.append(r1)     // Catch:{ Exception -> 0x005d }
            java.lang.String r1 = ".jpg"
            r3.append(r1)     // Catch:{ Exception -> 0x005d }
            java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x005d }
            r2.<init>(r5, r1)     // Catch:{ Exception -> 0x005d }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x005d }
            r5.<init>(r2)     // Catch:{ Exception -> 0x005d }
            byte[] r1 = r6.toByteArray()     // Catch:{ Exception -> 0x0059 }
            org.apache.commons.io.IOUtils.e(r1, r5)     // Catch:{ Exception -> 0x0059 }
            r5.close()     // Catch:{ Exception -> 0x0059 }
            m1.a r1 = new m1.a     // Catch:{ Exception -> 0x0059 }
            java.lang.String r3 = r2.getAbsolutePath()     // Catch:{ Exception -> 0x0059 }
            r1.<init>((java.lang.String) r3)     // Catch:{ Exception -> 0x0059 }
            m1.a r3 = r4.f66558a     // Catch:{ Exception -> 0x0059 }
            a(r3, r1)     // Catch:{ Exception -> 0x0059 }
            r1.X()     // Catch:{ Exception -> 0x0059 }
            r5.close()     // Catch:{ Exception -> 0x0059 }
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0059 }
            r1.<init>()     // Catch:{ Exception -> 0x0059 }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0059 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0059 }
            org.apache.commons.io.IOUtils.a(r3, r1)     // Catch:{ Exception -> 0x0057 }
            r3.close()     // Catch:{ Exception -> 0x0057 }
            return r1
        L_0x0057:
            r0 = move-exception
            goto L_0x0061
        L_0x0059:
            r1 = move-exception
            r3 = r0
            r0 = r1
            goto L_0x0061
        L_0x005d:
            r5 = move-exception
            r3 = r0
            r0 = r5
            r5 = r3
        L_0x0061:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Error preserving Exif data on selected image: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.String r1 = "ExifDataCopier"
            android.util.Log.e(r1, r0)
            if (r3 == 0) goto L_0x0081
            r3.close()     // Catch:{ IOException -> 0x007d }
            goto L_0x0081
        L_0x007d:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0081:
            if (r5 == 0) goto L_0x008b
            r5.close()     // Catch:{ IOException -> 0x0087 }
            goto L_0x008b
        L_0x0087:
            r5 = move-exception
            r5.printStackTrace()
        L_0x008b:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p4.b.c(android.content.Context, java.io.ByteArrayOutputStream):java.io.ByteArrayOutputStream");
    }

    public b(byte[] bArr) throws IOException {
        this.f66558a = new a((InputStream) new ByteArrayInputStream(bArr));
    }
}
