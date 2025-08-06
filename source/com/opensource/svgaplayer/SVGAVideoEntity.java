package com.opensource.svgaplayer;

import android.graphics.Bitmap;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Build;
import com.luck.picture.lib.config.PictureMimeType;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.g;
import com.opensource.svgaplayer.proto.AudioEntity;
import com.opensource.svgaplayer.proto.MovieEntity;
import com.opensource.svgaplayer.proto.MovieParams;
import com.opensource.svgaplayer.proto.SpriteEntity;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.x;
import kotlin.ranges.h;
import okio.ByteString;
import org.json.JSONArray;
import org.json.JSONObject;
import wx.c;
import yx.f;
import zx.d;

@Metadata(bv = {}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B)\b\u0016\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010p\u001a\u00020!\u0012\u0006\u0010q\u001a\u00020C\u0012\u0006\u0010r\u001a\u00020C¢\u0006\u0004\bs\u0010tB)\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0012\u0012\u0006\u0010p\u001a\u00020!\u0012\u0006\u0010q\u001a\u00020C\u0012\u0006\u0010r\u001a\u00020C¢\u0006\u0004\bs\u0010uJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0012H\u0002J\u001e\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00122\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u001bH\u0002J$\u0010$\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020\u001e2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020!0 H\u0002J\u0018\u0010'\u001a\u00020!2\u0006\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020\u0015H\u0002J\u001c\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\u0019\u001a\u00020\u0012H\u0002J\u001c\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00150 2\u0006\u0010\u0019\u001a\u00020\u0012H\u0002J\u001e\u0010*\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00122\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u001bH\u0002J\u0012\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010\u0019\u001a\u00020\u0012H\u0002J'\u00100\u001a\u00020\u00042\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00040\u001b2\b\u0010/\u001a\u0004\u0018\u00010.H\u0000¢\u0006\u0004\b0\u00101J\u0006\u00102\u001a\u00020\u0004R\u0014\u00105\u001a\u00020\u000b8\u0002XD¢\u0006\u0006\n\u0004\b3\u00104R\"\u0010<\u001a\u0002068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b2\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R$\u0010B\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR$\u0010H\u001a\u00020C2\u0006\u0010D\u001a\u00020C8\u0006@BX\u000e¢\u0006\f\n\u0004\b$\u0010E\u001a\u0004\bF\u0010GR$\u0010J\u001a\u00020C2\u0006\u0010D\u001a\u00020C8\u0006@BX\u000e¢\u0006\f\n\u0004\b'\u0010E\u001a\u0004\bI\u0010GR(\u0010R\u001a\b\u0012\u0004\u0012\u00020L0K8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b(\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR(\u0010U\u001a\b\u0012\u0004\u0012\u00020#0K8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b)\u0010M\u001a\u0004\bS\u0010O\"\u0004\bT\u0010QR$\u0010[\u001a\u0004\u0018\u00010+8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u0018\u0010^\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010]R.\u0010d\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00100 8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b8\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\u0016\u0010f\u001a\u00020!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bS\u0010eR\u0016\u0010g\u001a\u00020C8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bF\u0010ER\u0016\u0010h\u001a\u00020C8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bI\u0010ER\u0018\u0010j\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b`\u0010iR$\u0010l\u001a\u00020k2\u0006\u0010D\u001a\u00020k8\u0006@BX\u000e¢\u0006\f\n\u0004\bl\u0010m\u001a\u0004\bn\u0010o¨\u0006v"}, d2 = {"Lcom/opensource/svgaplayer/SVGAVideoEntity;", "", "Lorg/json/JSONObject;", "movieObject", "", "z", "Lcom/opensource/svgaplayer/proto/MovieParams;", "movieParams", "A", "json", "t", "", "imgName", "imgKey", "i", "filePath", "Landroid/graphics/Bitmap;", "c", "Lcom/opensource/svgaplayer/proto/MovieEntity;", "obj", "s", "", "byteArray", "d", "w", "entity", "v", "Lkotlin/Function0;", "completionBlock", "y", "Lcom/opensource/svgaplayer/proto/AudioEntity;", "audio", "Ljava/util/HashMap;", "Ljava/io/File;", "audiosFileMap", "Lyx/a;", "e", "audioCache", "value", "f", "g", "h", "B", "Landroid/media/SoundPool;", "j", "callback", "Lcom/opensource/svgaplayer/SVGAParser$d;", "playCallback", "u", "(Ld10/a;Lcom/opensource/svgaplayer/SVGAParser$d;)V", "b", "a", "Ljava/lang/String;", "TAG", "", "Z", "k", "()Z", "x", "(Z)V", "antiAlias", "Lcom/opensource/svgaplayer/proto/MovieEntity;", "getMovieItem", "()Lcom/opensource/svgaplayer/proto/MovieEntity;", "setMovieItem", "(Lcom/opensource/svgaplayer/proto/MovieEntity;)V", "movieItem", "", "<set-?>", "I", "m", "()I", "FPS", "n", "frames", "", "Lyx/f;", "Ljava/util/List;", "q", "()Ljava/util/List;", "setSpriteList$com_opensource_svgaplayer", "(Ljava/util/List;)V", "spriteList", "l", "setAudioList$com_opensource_svgaplayer", "audioList", "Landroid/media/SoundPool;", "p", "()Landroid/media/SoundPool;", "setSoundPool$com_opensource_svgaplayer", "(Landroid/media/SoundPool;)V", "soundPool", "Lcom/opensource/svgaplayer/g$a;", "Lcom/opensource/svgaplayer/g$a;", "soundCallback", "Ljava/util/HashMap;", "o", "()Ljava/util/HashMap;", "setImageMap$com_opensource_svgaplayer", "(Ljava/util/HashMap;)V", "imageMap", "Ljava/io/File;", "mCacheDir", "mFrameHeight", "mFrameWidth", "Lcom/opensource/svgaplayer/SVGAParser$d;", "mPlayCallback", "Lzx/d;", "videoSize", "Lzx/d;", "r", "()Lzx/d;", "cacheDir", "frameWidth", "frameHeight", "<init>", "(Lorg/json/JSONObject;Ljava/io/File;II)V", "(Lcom/opensource/svgaplayer/proto/MovieEntity;Ljava/io/File;II)V", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
public final class SVGAVideoEntity {

    /* renamed from: a  reason: collision with root package name */
    public final String f28542a = "SVGAVideoEntity";

    /* renamed from: b  reason: collision with root package name */
    public boolean f28543b = true;

    /* renamed from: c  reason: collision with root package name */
    public MovieEntity f28544c;

    /* renamed from: d  reason: collision with root package name */
    public d f28545d = new d(0.0d, 0.0d, 0.0d, 0.0d);

    /* renamed from: e  reason: collision with root package name */
    public int f28546e = 15;

    /* renamed from: f  reason: collision with root package name */
    public int f28547f;

    /* renamed from: g  reason: collision with root package name */
    public List<f> f28548g = CollectionsKt__CollectionsKt.k();

    /* renamed from: h  reason: collision with root package name */
    public List<yx.a> f28549h = CollectionsKt__CollectionsKt.k();

    /* renamed from: i  reason: collision with root package name */
    public SoundPool f28550i;

    /* renamed from: j  reason: collision with root package name */
    public g.a f28551j;

    /* renamed from: k  reason: collision with root package name */
    public HashMap<String, Bitmap> f28552k = new HashMap<>();

    /* renamed from: l  reason: collision with root package name */
    public File f28553l;

    /* renamed from: m  reason: collision with root package name */
    public int f28554m;

    /* renamed from: n  reason: collision with root package name */
    public int f28555n;

    /* renamed from: o  reason: collision with root package name */
    public SVGAParser.d f28556o;

    /* renamed from: p  reason: collision with root package name */
    public d10.a<Unit> f28557p;

    @Metadata(bv = {}, d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/opensource/svgaplayer/SVGAVideoEntity$a", "Lcom/opensource/svgaplayer/g$a;", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
    public static final class a implements g.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SVGAVideoEntity f28558a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Ref$IntRef f28559b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ MovieEntity f28560c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d10.a f28561d;

        public a(SVGAVideoEntity sVGAVideoEntity, Ref$IntRef ref$IntRef, MovieEntity movieEntity, d10.a aVar) {
            this.f28558a = sVGAVideoEntity;
            this.f28559b = ref$IntRef;
            this.f28560c = movieEntity;
            this.f28561d = aVar;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/media/SoundPool;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "onLoadComplete"}, k = 3, mv = {1, 1, 15})
    public static final class b implements SoundPool.OnLoadCompleteListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Ref$IntRef f28562a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MovieEntity f28563b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d10.a f28564c;

        public b(Ref$IntRef ref$IntRef, MovieEntity movieEntity, d10.a aVar) {
            this.f28562a = ref$IntRef;
            this.f28563b = movieEntity;
            this.f28564c = aVar;
        }

        public final void onLoadComplete(SoundPool soundPool, int i11, int i12) {
            ay.b.f26389a.e("SVGAParser", "pool_complete");
            Ref$IntRef ref$IntRef = this.f28562a;
            int i13 = ref$IntRef.element + 1;
            ref$IntRef.element = i13;
            if (i13 >= this.f28563b.audios.size()) {
                this.f28564c.invoke();
            }
        }
    }

    public SVGAVideoEntity(JSONObject jSONObject, File file, int i11, int i12) {
        this.f28555n = i11;
        this.f28554m = i12;
        this.f28553l = file;
        JSONObject optJSONObject = jSONObject.optJSONObject("movie");
        if (optJSONObject != null) {
            z(optJSONObject);
            try {
                t(jSONObject);
            } catch (Exception e11) {
                e11.printStackTrace();
            } catch (OutOfMemoryError e12) {
                e12.printStackTrace();
            }
            w(jSONObject);
        }
    }

    public final void A(MovieParams movieParams) {
        Float f11 = movieParams.viewBoxWidth;
        float f12 = 0.0f;
        double floatValue = (double) (f11 != null ? f11.floatValue() : 0.0f);
        Float f13 = movieParams.viewBoxHeight;
        if (f13 != null) {
            f12 = f13.floatValue();
        }
        this.f28545d = new d(0.0d, 0.0d, floatValue, (double) f12);
        Integer num = movieParams.fps;
        this.f28546e = num != null ? num.intValue() : 20;
        Integer num2 = movieParams.frames;
        this.f28547f = num2 != null ? num2.intValue() : 0;
    }

    public final void B(MovieEntity movieEntity, d10.a<Unit> aVar) {
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = 0;
        if (g.f28608e.b()) {
            this.f28551j = new a(this, ref$IntRef, movieEntity, aVar);
            return;
        }
        this.f28550i = j(movieEntity);
        ay.b.f26389a.e("SVGAParser", "pool_start");
        SoundPool soundPool = this.f28550i;
        if (soundPool != null) {
            soundPool.setOnLoadCompleteListener(new b(ref$IntRef, movieEntity, aVar));
        }
    }

    public final void b() {
        if (g.f28608e.b()) {
            for (yx.a c11 : this.f28549h) {
                Integer c12 = c11.c();
                if (c12 != null) {
                    g.f28608e.f(c12.intValue());
                }
            }
            this.f28551j = null;
        }
        SoundPool soundPool = this.f28550i;
        if (soundPool != null) {
            soundPool.release();
        }
        this.f28550i = null;
        this.f28549h = CollectionsKt__CollectionsKt.k();
        this.f28548g = CollectionsKt__CollectionsKt.k();
        this.f28552k.clear();
    }

    public final Bitmap c(String str) {
        return c.f29378a.a(str, this.f28555n, this.f28554m);
    }

    public final Bitmap d(byte[] bArr, String str) {
        Bitmap a11 = wx.b.f29377a.a(bArr, this.f28555n, this.f28554m);
        return a11 != null ? a11 : c(str);
    }

    public final yx.a e(AudioEntity audioEntity, HashMap<String, File> hashMap) {
        Throwable th2;
        AudioEntity audioEntity2 = audioEntity;
        yx.a aVar = new yx.a(audioEntity2);
        Integer num = audioEntity2.startTime;
        int i11 = 0;
        double intValue = (double) (num != null ? num.intValue() : 0);
        Integer num2 = audioEntity2.totalTime;
        if (num2 != null) {
            i11 = num2.intValue();
        }
        double d11 = (double) i11;
        if (((int) d11) == 0) {
            return aVar;
        }
        SVGAParser.d dVar = this.f28556o;
        if (dVar != null) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, File> value : hashMap.entrySet()) {
                arrayList.add(value.getValue());
            }
            dVar.a(arrayList);
            this.f28557p.invoke();
            return aVar;
        }
        File file = hashMap.get(audioEntity2.audioKey);
        if (file != null) {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                double available = (double) fileInputStream.available();
                long j11 = (long) ((intValue / d11) * available);
                g gVar = g.f28608e;
                if (gVar.b()) {
                    aVar.f(Integer.valueOf(gVar.c(this.f28551j, fileInputStream.getFD(), j11, (long) available, 1)));
                } else {
                    SoundPool soundPool = this.f28550i;
                    aVar.f(soundPool != null ? Integer.valueOf(soundPool.load(fileInputStream.getFD(), j11, (long) available, 1)) : null);
                }
                Unit unit = Unit.f56620a;
                kotlin.io.b.a(fileInputStream, (Throwable) null);
            } catch (Throwable th3) {
                Throwable th4 = th3;
                kotlin.io.b.a(fileInputStream, th2);
                throw th4;
            }
        }
        return aVar;
    }

    public final File f(File file, byte[] bArr) {
        file.createNewFile();
        new FileOutputStream(file).write(bArr);
        return file;
    }

    public final HashMap<String, File> g(MovieEntity movieEntity) {
        HashMap<String, byte[]> h11 = h(movieEntity);
        HashMap<String, File> hashMap = new HashMap<>();
        if (h11.size() > 0) {
            for (Map.Entry next : h11.entrySet()) {
                File a11 = SVGACache.f28468c.a((String) next.getKey());
                Object key = next.getKey();
                File file = a11.exists() ? a11 : null;
                if (file == null) {
                    file = f(a11, (byte[]) next.getValue());
                }
                hashMap.put(key, file);
            }
        }
        return hashMap;
    }

    public final HashMap<String, byte[]> h(MovieEntity movieEntity) {
        Set<Map.Entry<String, ByteString>> entrySet;
        HashMap<String, byte[]> hashMap = new HashMap<>();
        Map<String, ByteString> map = movieEntity.images;
        if (!(map == null || (entrySet = map.entrySet()) == null)) {
            for (Map.Entry entry : entrySet) {
                String str = (String) entry.getKey();
                byte[] byteArray = ((ByteString) entry.getValue()).toByteArray();
                if (byteArray.length >= 4) {
                    List p02 = ArraysKt___ArraysKt.p0(byteArray, new h(0, 3));
                    if (((Number) p02.get(0)).byteValue() == 73 && ((Number) p02.get(1)).byteValue() == 68 && ((Number) p02.get(2)).byteValue() == 51) {
                        hashMap.put(str, byteArray);
                    } else if (((Number) p02.get(0)).byteValue() == -1 && ((Number) p02.get(1)).byteValue() == -5 && ((Number) p02.get(2)).byteValue() == -108) {
                        hashMap.put(str, byteArray);
                    }
                }
            }
        }
        return hashMap;
    }

    public final String i(String str, String str2) {
        String str3 = this.f28553l.getAbsolutePath() + "/" + str;
        String str4 = str3 + PictureMimeType.PNG;
        String str5 = this.f28553l.getAbsolutePath() + "/" + str2 + PictureMimeType.PNG;
        if (new File(str3).exists()) {
            return str3;
        }
        if (new File(str4).exists()) {
            return str4;
        }
        return new File(str5).exists() ? str5 : "";
    }

    public final SoundPool j(MovieEntity movieEntity) {
        try {
            if (Build.VERSION.SDK_INT < 21) {
                return new SoundPool(RangesKt___RangesKt.g(12, movieEntity.audios.size()), 3, 0);
            }
            return new SoundPool.Builder().setAudioAttributes(new AudioAttributes.Builder().setUsage(1).build()).setMaxStreams(RangesKt___RangesKt.g(12, movieEntity.audios.size())).build();
        } catch (Exception e11) {
            ay.b.f26389a.d(this.f28542a, e11);
            return null;
        }
    }

    public final boolean k() {
        return this.f28543b;
    }

    public final List<yx.a> l() {
        return this.f28549h;
    }

    public final int m() {
        return this.f28546e;
    }

    public final int n() {
        return this.f28547f;
    }

    public final HashMap<String, Bitmap> o() {
        return this.f28552k;
    }

    public final SoundPool p() {
        return this.f28550i;
    }

    public final List<f> q() {
        return this.f28548g;
    }

    public final d r() {
        return this.f28545d;
    }

    public final void s(MovieEntity movieEntity) {
        Set<Map.Entry<String, ByteString>> entrySet;
        Bitmap d11;
        Map<String, ByteString> map = movieEntity.images;
        if (map != null && (entrySet = map.entrySet()) != null) {
            for (Map.Entry entry : entrySet) {
                byte[] byteArray = ((ByteString) entry.getValue()).toByteArray();
                if (byteArray.length >= 4) {
                    List p02 = ArraysKt___ArraysKt.p0(byteArray, new h(0, 3));
                    if (!((((Number) p02.get(0)).byteValue() == 73 && ((Number) p02.get(1)).byteValue() == 68 && ((Number) p02.get(2)).byteValue() == 51) || (d11 = d(byteArray, i(((ByteString) entry.getValue()).utf8(), (String) entry.getKey()))) == null)) {
                        this.f28552k.put(entry.getKey(), d11);
                    }
                }
            }
        }
    }

    public final void t(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("images");
        if (optJSONObject != null) {
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String i11 = i(optJSONObject.get(next).toString(), next);
                if (!(i11.length() == 0)) {
                    String G = StringsKt__StringsJVMKt.G(next, ".matte", "", false, 4, (Object) null);
                    Bitmap c11 = c(i11);
                    if (c11 != null) {
                        this.f28552k.put(G, c11);
                    }
                } else {
                    return;
                }
            }
        }
    }

    public final void u(d10.a<Unit> aVar, SVGAParser.d dVar) {
        this.f28557p = aVar;
        this.f28556o = dVar;
        MovieEntity movieEntity = this.f28544c;
        if (movieEntity == null) {
            aVar.invoke();
            return;
        }
        if (movieEntity == null) {
            x.j();
        }
        y(movieEntity, new SVGAVideoEntity$prepare$1(this));
    }

    public final void v(MovieEntity movieEntity) {
        List<f> list;
        List<SpriteEntity> list2 = movieEntity.sprites;
        if (list2 != null) {
            list = new ArrayList<>(CollectionsKt__IterablesKt.u(list2, 10));
            for (SpriteEntity fVar : list2) {
                list.add(new f(fVar));
            }
        } else {
            list = CollectionsKt__CollectionsKt.k();
        }
        this.f28548g = list;
    }

    public final void w(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("sprites");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i11 = 0; i11 < length; i11++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i11);
                if (optJSONObject != null) {
                    arrayList.add(new f(optJSONObject));
                }
            }
        }
        this.f28548g = CollectionsKt___CollectionsKt.I0(arrayList);
    }

    public final void x(boolean z11) {
        this.f28543b = z11;
    }

    public final void y(MovieEntity movieEntity, d10.a<Unit> aVar) {
        List<AudioEntity> list = movieEntity.audios;
        if (list == null || list.isEmpty()) {
            aVar.invoke();
            return;
        }
        B(movieEntity, aVar);
        HashMap<String, File> g11 = g(movieEntity);
        if (g11.size() == 0) {
            aVar.invoke();
            return;
        }
        List<AudioEntity> list2 = movieEntity.audios;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(list2, 10));
        for (AudioEntity e11 : list2) {
            arrayList.add(e(e11, g11));
        }
        this.f28549h = arrayList;
    }

    public final void z(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("viewBox");
        if (optJSONObject != null) {
            this.f28545d = new d(0.0d, 0.0d, optJSONObject.optDouble("width", 0.0d), optJSONObject.optDouble("height", 0.0d));
        }
        this.f28546e = jSONObject.optInt("fps", 20);
        this.f28547f = jSONObject.optInt("frames", 0);
    }

    public SVGAVideoEntity(MovieEntity movieEntity, File file, int i11, int i12) {
        this.f28555n = i11;
        this.f28554m = i12;
        this.f28553l = file;
        this.f28544c = movieEntity;
        MovieParams movieParams = movieEntity.params;
        if (movieParams != null) {
            A(movieParams);
        }
        try {
            s(movieEntity);
        } catch (Exception e11) {
            e11.printStackTrace();
        } catch (OutOfMemoryError e12) {
            e12.printStackTrace();
        }
        v(movieEntity);
    }
}
