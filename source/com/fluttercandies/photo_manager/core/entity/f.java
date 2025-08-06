package com.fluttercandies.photo_manager.core.entity;

import android.graphics.Bitmap;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.util.Map;
import kotlin.jvm.internal.r;

public final class f {

    /* renamed from: f  reason: collision with root package name */
    public static final a f65096f = new a((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final int f65097a;

    /* renamed from: b  reason: collision with root package name */
    public final int f65098b;

    /* renamed from: c  reason: collision with root package name */
    public final Bitmap.CompressFormat f65099c;

    /* renamed from: d  reason: collision with root package name */
    public final int f65100d;

    /* renamed from: e  reason: collision with root package name */
    public final long f65101e;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final f a(Map<?, ?> map) {
            Bitmap.CompressFormat compressFormat;
            int intValue = ((Integer) map.get("width")).intValue();
            int intValue2 = ((Integer) map.get("height")).intValue();
            int intValue3 = ((Integer) map.get(TUIConstants.TUIGroupNote.PLUGIN_GROUP_NOTE_FORMAT)).intValue();
            int intValue4 = ((Integer) map.get("quality")).intValue();
            long intValue5 = (long) ((Integer) map.get("frame")).intValue();
            if (intValue3 == 0) {
                compressFormat = Bitmap.CompressFormat.JPEG;
            } else {
                compressFormat = Bitmap.CompressFormat.PNG;
            }
            return new f(intValue, intValue2, compressFormat, intValue4, intValue5);
        }
    }

    public f(int i11, int i12, Bitmap.CompressFormat compressFormat, int i13, long j11) {
        this.f65097a = i11;
        this.f65098b = i12;
        this.f65099c = compressFormat;
        this.f65100d = i13;
        this.f65101e = j11;
    }

    public final Bitmap.CompressFormat a() {
        return this.f65099c;
    }

    public final long b() {
        return this.f65101e;
    }

    public final int c() {
        return this.f65098b;
    }

    public final int d() {
        return this.f65100d;
    }

    public final int e() {
        return this.f65097a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f65097a == fVar.f65097a && this.f65098b == fVar.f65098b && this.f65099c == fVar.f65099c && this.f65100d == fVar.f65100d && this.f65101e == fVar.f65101e;
    }

    public int hashCode() {
        return (((((((this.f65097a * 31) + this.f65098b) * 31) + this.f65099c.hashCode()) * 31) + this.f65100d) * 31) + a.a(this.f65101e);
    }

    public String toString() {
        return "ThumbLoadOption(width=" + this.f65097a + ", height=" + this.f65098b + ", format=" + this.f65099c + ", quality=" + this.f65100d + ", frame=" + this.f65101e + ')';
    }
}
