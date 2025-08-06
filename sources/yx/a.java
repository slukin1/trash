package yx;

import com.opensource.svgaplayer.proto.AudioEntity;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u0016"}, d2 = {"Lyx/a;", "", "", "startFrame", "I", "d", "()I", "endFrame", "a", "soundID", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "f", "(Ljava/lang/Integer;)V", "playID", "b", "e", "Lcom/opensource/svgaplayer/proto/AudioEntity;", "audioItem", "<init>", "(Lcom/opensource/svgaplayer/proto/AudioEntity;)V", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f29412a;

    /* renamed from: b  reason: collision with root package name */
    public final int f29413b;

    /* renamed from: c  reason: collision with root package name */
    public final int f29414c;

    /* renamed from: d  reason: collision with root package name */
    public final int f29415d;

    /* renamed from: e  reason: collision with root package name */
    public final int f29416e;

    /* renamed from: f  reason: collision with root package name */
    public Integer f29417f;

    /* renamed from: g  reason: collision with root package name */
    public Integer f29418g;

    public a(AudioEntity audioEntity) {
        this.f29412a = audioEntity.audioKey;
        Integer num = audioEntity.startFrame;
        int i11 = 0;
        this.f29413b = num != null ? num.intValue() : 0;
        Integer num2 = audioEntity.endFrame;
        this.f29414c = num2 != null ? num2.intValue() : 0;
        Integer num3 = audioEntity.startTime;
        this.f29415d = num3 != null ? num3.intValue() : 0;
        Integer num4 = audioEntity.totalTime;
        this.f29416e = num4 != null ? num4.intValue() : i11;
    }

    public final int a() {
        return this.f29414c;
    }

    public final Integer b() {
        return this.f29418g;
    }

    public final Integer c() {
        return this.f29417f;
    }

    public final int d() {
        return this.f29413b;
    }

    public final void e(Integer num) {
        this.f29418g = num;
    }

    public final void f(Integer num) {
        this.f29417f = num;
    }
}
