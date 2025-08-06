package com.fluttercandies.photo_manager.core.utils;

import android.media.MediaPlayer;
import kotlin.jvm.internal.x;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final f f65122a = new f();

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public Integer f65123a;

        /* renamed from: b  reason: collision with root package name */
        public Integer f65124b;

        /* renamed from: c  reason: collision with root package name */
        public Integer f65125c;

        public a(Integer num, Integer num2, Integer num3) {
            this.f65123a = num;
            this.f65124b = num2;
            this.f65125c = num3;
        }

        public final Integer a() {
            return this.f65125c;
        }

        public final Integer b() {
            return this.f65124b;
        }

        public final Integer c() {
            return this.f65123a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return x.b(this.f65123a, aVar.f65123a) && x.b(this.f65124b, aVar.f65124b) && x.b(this.f65125c, aVar.f65125c);
        }

        public int hashCode() {
            Integer num = this.f65123a;
            int i11 = 0;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            Integer num2 = this.f65124b;
            int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.f65125c;
            if (num3 != null) {
                i11 = num3.hashCode();
            }
            return hashCode2 + i11;
        }

        public String toString() {
            return "VideoInfo(width=" + this.f65123a + ", height=" + this.f65124b + ", duration=" + this.f65125c + ')';
        }
    }

    public static final boolean c(MediaPlayer mediaPlayer, int i11, int i12) {
        return true;
    }

    public final a b(String str) {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setDataSource(str);
        mediaPlayer.setOnErrorListener(e.f65121b);
        try {
            mediaPlayer.prepare();
            mediaPlayer.getVideoHeight();
            a aVar = new a(Integer.valueOf(mediaPlayer.getVideoWidth()), Integer.valueOf(mediaPlayer.getVideoHeight()), Integer.valueOf(mediaPlayer.getDuration()));
            mediaPlayer.stop();
            mediaPlayer.release();
            return aVar;
        } catch (Throwable unused) {
            mediaPlayer.release();
            return new a((Integer) null, (Integer) null, (Integer) null);
        }
    }
}
