package yx;

import com.opensource.svgaplayer.entities.SVGAVideoShapeEntity;
import com.opensource.svgaplayer.proto.FrameEntity;
import com.opensource.svgaplayer.proto.SpriteEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012B\u0011\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u0013¢\u0006\u0004\b\u0011\u0010\u0014R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lyx/f;", "", "", "imageKey", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "matteKey", "c", "", "Lyx/g;", "frames", "Ljava/util/List;", "a", "()Ljava/util/List;", "Lorg/json/JSONObject;", "obj", "<init>", "(Lorg/json/JSONObject;)V", "Lcom/opensource/svgaplayer/proto/SpriteEntity;", "(Lcom/opensource/svgaplayer/proto/SpriteEntity;)V", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final String f29426a;

    /* renamed from: b  reason: collision with root package name */
    public final String f29427b;

    /* renamed from: c  reason: collision with root package name */
    public final List<g> f29428c;

    public f(JSONObject jSONObject) {
        this.f29426a = jSONObject.optString("imageKey");
        this.f29427b = jSONObject.optString("matteKey");
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("frames");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i11 = 0; i11 < length; i11++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i11);
                if (optJSONObject != null) {
                    g gVar = new g(optJSONObject);
                    if ((!gVar.d().isEmpty()) && ((SVGAVideoShapeEntity) CollectionsKt___CollectionsKt.a0(gVar.d())).i() && arrayList.size() > 0) {
                        gVar.f(((g) CollectionsKt___CollectionsKt.m0(arrayList)).d());
                    }
                    arrayList.add(gVar);
                }
            }
        }
        this.f29428c = CollectionsKt___CollectionsKt.I0(arrayList);
    }

    public final List<g> a() {
        return this.f29428c;
    }

    public final String b() {
        return this.f29426a;
    }

    public final String c() {
        return this.f29427b;
    }

    public f(SpriteEntity spriteEntity) {
        List<g> list;
        this.f29426a = spriteEntity.imageKey;
        this.f29427b = spriteEntity.matteKey;
        List<FrameEntity> list2 = spriteEntity.frames;
        if (list2 != null) {
            list = new ArrayList<>(CollectionsKt__IterablesKt.u(list2, 10));
            g gVar = null;
            for (FrameEntity gVar2 : list2) {
                g gVar3 = new g(gVar2);
                if ((!gVar3.d().isEmpty()) && ((SVGAVideoShapeEntity) CollectionsKt___CollectionsKt.a0(gVar3.d())).i() && gVar != null) {
                    gVar3.f(gVar.d());
                }
                list.add(gVar3);
                gVar = gVar3;
            }
        } else {
            list = CollectionsKt__CollectionsKt.k();
        }
        this.f29428c = list;
    }
}
