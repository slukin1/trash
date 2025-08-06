package com.squareup.picasso;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestHandler;
import com.sumsub.sns.internal.ml.autocapture.b;
import java.io.IOException;
import okio.Okio;
import okio.Source;

public class MediaStoreRequestHandler extends f {

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f29946b = {"orientation"};

    public enum PicassoKind {
        MICRO(3, 96, 96),
        MINI(1, 512, b.f34945b),
        FULL(2, -1, -1);
        
        public final int androidKind;
        public final int height;
        public final int width;

        private PicassoKind(int i11, int i12, int i13) {
            this.androidKind = i11;
            this.width = i12;
            this.height = i13;
        }
    }

    public MediaStoreRequestHandler(Context context) {
        super(context);
    }

    public static int k(ContentResolver contentResolver, Uri uri) {
        Cursor cursor = null;
        try {
            Cursor query = contentResolver.query(uri, f29946b, (String) null, (String[]) null, (String) null);
            if (query != null) {
                if (query.moveToFirst()) {
                    int i11 = query.getInt(0);
                    query.close();
                    return i11;
                }
            }
            if (query != null) {
                query.close();
            }
            return 0;
        } catch (RuntimeException unused) {
            if (cursor != null) {
                cursor.close();
            }
            return 0;
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    public static PicassoKind l(int i11, int i12) {
        PicassoKind picassoKind = PicassoKind.MICRO;
        if (i11 <= picassoKind.width && i12 <= picassoKind.height) {
            return picassoKind;
        }
        PicassoKind picassoKind2 = PicassoKind.MINI;
        if (i11 > picassoKind2.width || i12 > picassoKind2.height) {
            return PicassoKind.FULL;
        }
        return picassoKind2;
    }

    public boolean c(q qVar) {
        Uri uri = qVar.f30085d;
        return "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    public RequestHandler.a f(q qVar, int i11) throws IOException {
        Bitmap bitmap;
        q qVar2 = qVar;
        ContentResolver contentResolver = this.f30033a.getContentResolver();
        int k11 = k(contentResolver, qVar2.f30085d);
        String type = contentResolver.getType(qVar2.f30085d);
        boolean z11 = type != null && type.startsWith("video/");
        if (qVar.c()) {
            PicassoKind l11 = l(qVar2.f30089h, qVar2.f30090i);
            if (!z11 && l11 == PicassoKind.FULL) {
                return new RequestHandler.a((Bitmap) null, Okio.source(j(qVar)), Picasso.LoadedFrom.DISK, k11);
            }
            long parseId = ContentUris.parseId(qVar2.f30085d);
            BitmapFactory.Options d11 = RequestHandler.d(qVar);
            d11.inJustDecodeBounds = true;
            BitmapFactory.Options options = d11;
            RequestHandler.a(qVar2.f30089h, qVar2.f30090i, l11.width, l11.height, d11, qVar);
            if (z11) {
                bitmap = MediaStore.Video.Thumbnails.getThumbnail(contentResolver, parseId, l11 == PicassoKind.FULL ? 1 : l11.androidKind, options);
            } else {
                bitmap = MediaStore.Images.Thumbnails.getThumbnail(contentResolver, parseId, l11.androidKind, options);
            }
            if (bitmap != null) {
                return new RequestHandler.a(bitmap, (Source) null, Picasso.LoadedFrom.DISK, k11);
            }
        }
        return new RequestHandler.a((Bitmap) null, Okio.source(j(qVar)), Picasso.LoadedFrom.DISK, k11);
    }
}
