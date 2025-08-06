package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.airbnb.lottie.model.LottieCompositionCache;
import com.airbnb.lottie.parser.LottieCompositionMoshiParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.luck.picture.lib.config.PictureMimeType;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import okio.BufferedSource;
import okio.Okio;
import org.json.JSONObject;

public class LottieCompositionFactory {
    private static final byte[] MAGIC = {80, 75, 3, 4};
    private static final Map<String, LottieTask<LottieComposition>> taskCache = new HashMap();

    private LottieCompositionFactory() {
    }

    private static LottieTask<LottieComposition> cache(String str, Callable<LottieResult<LottieComposition>> callable) {
        LottieComposition lottieComposition = str == null ? null : LottieCompositionCache.getInstance().get(str);
        if (lottieComposition != null) {
            return new LottieTask<>(new j(lottieComposition));
        }
        if (str != null) {
            Map<String, LottieTask<LottieComposition>> map = taskCache;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        LottieTask<LottieComposition> lottieTask = new LottieTask<>(callable);
        if (str != null) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            lottieTask.addListener(new e(str, atomicBoolean));
            lottieTask.addFailureListener(new g(str, atomicBoolean));
            if (!atomicBoolean.get()) {
                taskCache.put(str, lottieTask);
            }
        }
        return lottieTask;
    }

    public static void clearCache(Context context) {
        taskCache.clear();
        LottieCompositionCache.getInstance().clear();
        L.networkCache(context).clear();
    }

    private static LottieImageAsset findImageAssetForFileName(LottieComposition lottieComposition, String str) {
        for (LottieImageAsset next : lottieComposition.getImages().values()) {
            if (next.getFileName().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public static LottieTask<LottieComposition> fromAsset(Context context, String str) {
        return fromAsset(context, str, "asset_" + str);
    }

    public static LottieResult<LottieComposition> fromAssetSync(Context context, String str) {
        return fromAssetSync(context, str, "asset_" + str);
    }

    @Deprecated
    public static LottieTask<LottieComposition> fromJson(JSONObject jSONObject, String str) {
        return cache(str, new f(jSONObject, str));
    }

    public static LottieTask<LottieComposition> fromJsonInputStream(InputStream inputStream, String str) {
        return cache(str, new m(inputStream, str));
    }

    public static LottieResult<LottieComposition> fromJsonInputStreamSync(InputStream inputStream, String str) {
        return fromJsonInputStreamSync(inputStream, str, true);
    }

    public static LottieTask<LottieComposition> fromJsonReader(JsonReader jsonReader, String str) {
        return cache(str, new k(jsonReader, str));
    }

    public static LottieResult<LottieComposition> fromJsonReaderSync(JsonReader jsonReader, String str) {
        return fromJsonReaderSyncInternal(jsonReader, str, true);
    }

    private static LottieResult<LottieComposition> fromJsonReaderSyncInternal(JsonReader jsonReader, String str, boolean z11) {
        try {
            LottieComposition parse = LottieCompositionMoshiParser.parse(jsonReader);
            if (str != null) {
                LottieCompositionCache.getInstance().put(str, parse);
            }
            LottieResult<LottieComposition> lottieResult = new LottieResult<>(parse);
            if (z11) {
                Utils.closeQuietly(jsonReader);
            }
            return lottieResult;
        } catch (Exception e11) {
            LottieResult<LottieComposition> lottieResult2 = new LottieResult<>((Throwable) e11);
            if (z11) {
                Utils.closeQuietly(jsonReader);
            }
            return lottieResult2;
        } catch (Throwable th2) {
            if (z11) {
                Utils.closeQuietly(jsonReader);
            }
            throw th2;
        }
    }

    public static LottieTask<LottieComposition> fromJsonString(String str, String str2) {
        return cache(str2, new n(str, str2));
    }

    public static LottieResult<LottieComposition> fromJsonStringSync(String str, String str2) {
        return fromJsonReaderSync(JsonReader.of(Okio.buffer(Okio.source((InputStream) new ByteArrayInputStream(str.getBytes())))), str2);
    }

    @Deprecated
    public static LottieResult<LottieComposition> fromJsonSync(JSONObject jSONObject, String str) {
        return fromJsonStringSync(jSONObject.toString(), str);
    }

    public static LottieTask<LottieComposition> fromRawRes(Context context, int i11) {
        return fromRawRes(context, i11, rawResCacheKey(context, i11));
    }

    public static LottieResult<LottieComposition> fromRawResSync(Context context, int i11) {
        return fromRawResSync(context, i11, rawResCacheKey(context, i11));
    }

    public static LottieTask<LottieComposition> fromUrl(Context context, String str) {
        return fromUrl(context, str, "url_" + str);
    }

    public static LottieResult<LottieComposition> fromUrlSync(Context context, String str) {
        return fromUrlSync(context, str, str);
    }

    public static LottieTask<LottieComposition> fromZipStream(ZipInputStream zipInputStream, String str) {
        return cache(str, new p(zipInputStream, str));
    }

    public static LottieResult<LottieComposition> fromZipStreamSync(ZipInputStream zipInputStream, String str) {
        try {
            return fromZipStreamSyncInternal(zipInputStream, str);
        } finally {
            Utils.closeQuietly(zipInputStream);
        }
    }

    private static LottieResult<LottieComposition> fromZipStreamSyncInternal(ZipInputStream zipInputStream, String str) {
        HashMap hashMap = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            LottieComposition lottieComposition = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(".json")) {
                    lottieComposition = fromJsonReaderSyncInternal(JsonReader.of(Okio.buffer(Okio.source((InputStream) zipInputStream))), (String) null, false).getValue();
                } else {
                    if (!name.contains(PictureMimeType.PNG) && !name.contains(".webp") && !name.contains(PictureMimeType.JPG)) {
                        if (!name.contains(".jpeg")) {
                            zipInputStream.closeEntry();
                        }
                    }
                    String[] split = name.split("/");
                    hashMap.put(split[split.length - 1], BitmapFactory.decodeStream(zipInputStream));
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (lottieComposition == null) {
                return new LottieResult<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                LottieImageAsset findImageAssetForFileName = findImageAssetForFileName(lottieComposition, (String) entry.getKey());
                if (findImageAssetForFileName != null) {
                    findImageAssetForFileName.setBitmap(Utils.resizeBitmapIfNeeded((Bitmap) entry.getValue(), findImageAssetForFileName.getWidth(), findImageAssetForFileName.getHeight()));
                }
            }
            for (Map.Entry next : lottieComposition.getImages().entrySet()) {
                if (((LottieImageAsset) next.getValue()).getBitmap() == null) {
                    return new LottieResult<>((Throwable) new IllegalStateException("There is no image for " + ((LottieImageAsset) next.getValue()).getFileName()));
                }
            }
            if (str != null) {
                LottieCompositionCache.getInstance().put(str, lottieComposition);
            }
            return new LottieResult<>(lottieComposition);
        } catch (IOException e11) {
            return new LottieResult<>((Throwable) e11);
        }
    }

    private static boolean isNightMode(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    private static Boolean isZipCompressed(BufferedSource bufferedSource) {
        try {
            BufferedSource peek = bufferedSource.peek();
            for (byte b11 : MAGIC) {
                if (peek.readByte() != b11) {
                    return Boolean.FALSE;
                }
            }
            peek.close();
            return Boolean.TRUE;
        } catch (NoSuchMethodError unused) {
            return Boolean.FALSE;
        } catch (Exception e11) {
            Logger.error("Failed to check zip file header", e11);
            return Boolean.FALSE;
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$cache$10(String str, AtomicBoolean atomicBoolean, Throwable th2) {
        taskCache.remove(str);
        atomicBoolean.set(true);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ LottieResult lambda$cache$8(LottieComposition lottieComposition) throws Exception {
        return new LottieResult(lottieComposition);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$cache$9(String str, AtomicBoolean atomicBoolean, LottieComposition lottieComposition) {
        taskCache.remove(str);
        atomicBoolean.set(true);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ LottieResult lambda$fromRawRes$2(WeakReference weakReference, Context context, int i11, String str) throws Exception {
        Context context2 = (Context) weakReference.get();
        if (context2 != null) {
            context = context2;
        }
        return fromRawResSync(context, i11, str);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ LottieResult lambda$fromUrl$0(Context context, String str, String str2) throws Exception {
        LottieResult<LottieComposition> fetchSync = L.networkFetcher(context).fetchSync(str, str2);
        if (!(str2 == null || fetchSync.getValue() == null)) {
            LottieCompositionCache.getInstance().put(str2, fetchSync.getValue());
        }
        return fetchSync;
    }

    private static String rawResCacheKey(Context context, int i11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("rawRes");
        sb2.append(isNightMode(context) ? "_night_" : "_day_");
        sb2.append(i11);
        return sb2.toString();
    }

    public static void setMaxCacheSize(int i11) {
        LottieCompositionCache.getInstance().resize(i11);
    }

    private static LottieResult<LottieComposition> fromJsonInputStreamSync(InputStream inputStream, String str, boolean z11) {
        try {
            return fromJsonReaderSync(JsonReader.of(Okio.buffer(Okio.source(inputStream))), str);
        } finally {
            if (z11) {
                Utils.closeQuietly(inputStream);
            }
        }
    }

    public static LottieTask<LottieComposition> fromRawRes(Context context, int i11, String str) {
        return cache(str, new o(new WeakReference(context), context.getApplicationContext(), i11, str));
    }

    public static LottieResult<LottieComposition> fromRawResSync(Context context, int i11, String str) {
        try {
            BufferedSource buffer = Okio.buffer(Okio.source(context.getResources().openRawResource(i11)));
            if (isZipCompressed(buffer).booleanValue()) {
                return fromZipStreamSync(new ZipInputStream(buffer.inputStream()), str);
            }
            return fromJsonInputStreamSync(buffer.inputStream(), str);
        } catch (Resources.NotFoundException e11) {
            return new LottieResult<>((Throwable) e11);
        }
    }

    public static LottieTask<LottieComposition> fromUrl(Context context, String str, String str2) {
        return cache(str2, new i(context, str, str2));
    }

    public static LottieResult<LottieComposition> fromUrlSync(Context context, String str, String str2) {
        LottieResult<LottieComposition> fetchSync = L.networkFetcher(context).fetchSync(str, str2);
        if (!(str2 == null || fetchSync.getValue() == null)) {
            LottieCompositionCache.getInstance().put(str2, fetchSync.getValue());
        }
        return fetchSync;
    }

    public static LottieTask<LottieComposition> fromAsset(Context context, String str, String str2) {
        return cache(str2, new h(context.getApplicationContext(), str, str2));
    }

    public static LottieResult<LottieComposition> fromAssetSync(Context context, String str, String str2) {
        try {
            if (!str.endsWith(".zip")) {
                if (!str.endsWith(".lottie")) {
                    return fromJsonInputStreamSync(context.getAssets().open(str), str2);
                }
            }
            return fromZipStreamSync(new ZipInputStream(context.getAssets().open(str)), str2);
        } catch (IOException e11) {
            return new LottieResult<>((Throwable) e11);
        }
    }
}
