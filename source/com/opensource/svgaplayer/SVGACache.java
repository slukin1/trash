package com.opensource.svgaplayer;

import android.content.Context;
import ay.b;
import com.huochat.community.util.FileTool;
import com.luck.picture.lib.config.PictureMimeType;
import java.io.File;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.x;

@Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001#B\t\b\u0002¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0018\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\rJ\u000e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\tJ\u000e\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tJ\u000e\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\tJ\u000e\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\tJ\u000e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\tR\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001c\u0010 \u001a\u00020\t8B@\u0002X\u000e¢\u0006\f\n\u0004\b\u0018\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006$"}, d2 = {"Lcom/opensource/svgaplayer/SVGACache;", "", "Landroid/content/Context;", "context", "", "k", "Lcom/opensource/svgaplayer/SVGACache$Type;", "type", "l", "", "path", "f", "(Ljava/lang/String;)V", "", "j", "i", "cacheKey", "h", "str", "c", "Ljava/net/URL;", "url", "d", "Ljava/io/File;", "b", "e", "audio", "a", "Lcom/opensource/svgaplayer/SVGACache$Type;", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "cacheDir", "<init>", "()V", "Type", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
public final class SVGACache {

    /* renamed from: a  reason: collision with root package name */
    public static Type f28466a = Type.DEFAULT;

    /* renamed from: b  reason: collision with root package name */
    public static String f28467b = "/";

    /* renamed from: c  reason: collision with root package name */
    public static final SVGACache f28468c = new SVGACache();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/opensource/svgaplayer/SVGACache$Type;", "", "(Ljava/lang/String;I)V", "DEFAULT", "FILE", "com.opensource.svgaplayer"}, k = 1, mv = {1, 1, 15})
    public enum Type {
        DEFAULT,
        FILE
    }

    public final File a(String str) {
        return new File(g() + str + PictureMimeType.MP3);
    }

    public final File b(String str) {
        return new File(g() + str + '/');
    }

    public final String c(String str) {
        MessageDigest instance = MessageDigest.getInstance(FileTool.HASH_TYPE_MD5);
        instance.update(str.getBytes(Charset.forName("UTF-8")));
        String str2 = "";
        for (byte valueOf : instance.digest()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            d0 d0Var = d0.f56774a;
            sb2.append(String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(valueOf)}, 1)));
            str2 = sb2.toString();
        }
        return str2;
    }

    public final String d(URL url) {
        return c(url.toString());
    }

    public final File e(String str) {
        return new File(g() + str + ".svga");
    }

    public final void f(String str) {
        File[] listFiles;
        try {
            File file = new File(str);
            if (!file.exists()) {
                file = null;
            }
            if (file != null && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.exists()) {
                        if (file2.isDirectory()) {
                            f28468c.f(file2.getAbsolutePath());
                        }
                        file2.delete();
                    }
                }
            }
        } catch (Exception e11) {
            b.f26389a.c("SVGACache", "Clear svga cache path: " + str + " fail", e11);
        }
    }

    public final String g() {
        if (!x.b(f28467b, "/")) {
            File file = new File(f28467b);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return f28467b;
    }

    public final boolean h(String str) {
        File file;
        if (i()) {
            file = b(str);
        } else {
            file = e(str);
        }
        return file.exists();
    }

    public final boolean i() {
        return f28466a == Type.DEFAULT;
    }

    public final boolean j() {
        return (x.b("/", g()) ^ true) && new File(g()).exists();
    }

    public final void k(Context context) {
        l(context, Type.DEFAULT);
    }

    public final void l(Context context, Type type) {
        if (!j() && context != null) {
            f28467b = context.getCacheDir().getAbsolutePath() + "/svga/";
            File file = new File(g());
            if (!(!file.exists())) {
                file = null;
            }
            if (file != null) {
                file.mkdirs();
            }
            f28466a = type;
        }
    }
}
