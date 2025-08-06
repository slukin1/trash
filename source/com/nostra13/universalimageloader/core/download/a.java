package com.nostra13.universalimageloader.core.download;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.webkit.MimeTypeMap;
import com.google.common.net.HttpHeaders;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import vx.b;

public class a implements ImageDownloader {

    /* renamed from: a  reason: collision with root package name */
    public final Context f28450a;

    /* renamed from: b  reason: collision with root package name */
    public final int f28451b;

    /* renamed from: c  reason: collision with root package name */
    public final int f28452c;

    /* renamed from: com.nostra13.universalimageloader.core.download.a$a  reason: collision with other inner class name */
    public static /* synthetic */ class C0247a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f28453a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.nostra13.universalimageloader.core.download.ImageDownloader$Scheme[] r0 = com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f28453a = r0
                com.nostra13.universalimageloader.core.download.ImageDownloader$Scheme r1 = com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.HTTP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f28453a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.nostra13.universalimageloader.core.download.ImageDownloader$Scheme r1 = com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.HTTPS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f28453a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.nostra13.universalimageloader.core.download.ImageDownloader$Scheme r1 = com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.FILE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f28453a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.nostra13.universalimageloader.core.download.ImageDownloader$Scheme r1 = com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.CONTENT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f28453a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.nostra13.universalimageloader.core.download.ImageDownloader$Scheme r1 = com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.ASSETS     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f28453a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.nostra13.universalimageloader.core.download.ImageDownloader$Scheme r1 = com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.DRAWABLE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f28453a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.nostra13.universalimageloader.core.download.ImageDownloader$Scheme r1 = com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nostra13.universalimageloader.core.download.a.C0247a.<clinit>():void");
        }
    }

    public a(Context context) {
        this(context, 5000, 20000);
    }

    public InputStream a(String str, Object obj) throws IOException {
        switch (C0247a.f28453a[ImageDownloader.Scheme.ofUri(str).ordinal()]) {
            case 1:
            case 2:
                return h(str, obj);
            case 3:
                return g(str, obj);
            case 4:
                return e(str, obj);
            case 5:
                return d(str, obj);
            case 6:
                return f(str, obj);
            default:
                return i(str, obj);
        }
    }

    public HttpURLConnection b(String str, Object obj) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(Uri.encode(str, "@#&=*+-_.,:!?()/~'%")).openConnection();
        httpURLConnection.setConnectTimeout(this.f28451b);
        httpURLConnection.setReadTimeout(this.f28452c);
        return httpURLConnection;
    }

    @TargetApi(14)
    public InputStream c(Uri uri) {
        ContentResolver contentResolver = this.f28450a.getContentResolver();
        if (Build.VERSION.SDK_INT >= 14) {
            return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
        }
        return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri);
    }

    public InputStream d(String str, Object obj) throws IOException {
        return this.f28450a.getAssets().open(ImageDownloader.Scheme.ASSETS.crop(str));
    }

    public InputStream e(String str, Object obj) throws FileNotFoundException {
        ContentResolver contentResolver = this.f28450a.getContentResolver();
        Uri parse = Uri.parse(str);
        if (k(parse)) {
            Bitmap thumbnail = MediaStore.Video.Thumbnails.getThumbnail(contentResolver, Long.valueOf(parse.getLastPathSegment()).longValue(), 1, (BitmapFactory.Options) null);
            if (thumbnail != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                thumbnail.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
                return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            }
        } else if (str.startsWith("content://com.android.contacts/")) {
            return c(parse);
        }
        return contentResolver.openInputStream(parse);
    }

    public InputStream f(String str, Object obj) {
        return this.f28450a.getResources().openRawResource(Integer.parseInt(ImageDownloader.Scheme.DRAWABLE.crop(str)));
    }

    public InputStream g(String str, Object obj) throws IOException {
        String crop = ImageDownloader.Scheme.FILE.crop(str);
        if (l(str)) {
            return j(crop);
        }
        return new ox.a(new BufferedInputStream(new FileInputStream(crop), 32768), (int) new File(crop).length());
    }

    public InputStream h(String str, Object obj) throws IOException {
        HttpURLConnection b11 = b(str, obj);
        int i11 = 0;
        while (b11.getResponseCode() / 100 == 3 && i11 < 5) {
            b11 = b(b11.getHeaderField(HttpHeaders.LOCATION), obj);
            i11++;
        }
        try {
            InputStream inputStream = b11.getInputStream();
            if (m(b11)) {
                return new ox.a(new BufferedInputStream(inputStream, 32768), b11.getContentLength());
            }
            b.a(inputStream);
            throw new IOException("Image request failed with response code " + b11.getResponseCode());
        } catch (IOException e11) {
            b.c(b11.getErrorStream());
            throw e11;
        }
    }

    public InputStream i(String str, Object obj) throws IOException {
        throw new UnsupportedOperationException(String.format("UIL doesn't support scheme(protocol) by default [%s]. You should implement this support yourself (BaseImageDownloader.getStreamFromOtherSource(...))", new Object[]{str}));
    }

    @TargetApi(8)
    public final InputStream j(String str) {
        Bitmap createVideoThumbnail;
        if (Build.VERSION.SDK_INT < 8 || (createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str, 2)) == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createVideoThumbnail.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }

    public final boolean k(Uri uri) {
        String type = this.f28450a.getContentResolver().getType(uri);
        return type != null && type.startsWith("video/");
    }

    public final boolean l(String str) {
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(str));
        return mimeTypeFromExtension != null && mimeTypeFromExtension.startsWith("video/");
    }

    public boolean m(HttpURLConnection httpURLConnection) throws IOException {
        return httpURLConnection.getResponseCode() == 200;
    }

    public a(Context context, int i11, int i12) {
        this.f28450a = context.getApplicationContext();
        this.f28451b = i11;
        this.f28452c = i12;
    }
}
