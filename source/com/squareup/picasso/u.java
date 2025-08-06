package com.squareup.picasso;

import java.io.PrintWriter;

public class u {

    /* renamed from: a  reason: collision with root package name */
    public final int f30150a;

    /* renamed from: b  reason: collision with root package name */
    public final int f30151b;

    /* renamed from: c  reason: collision with root package name */
    public final long f30152c;

    /* renamed from: d  reason: collision with root package name */
    public final long f30153d;

    /* renamed from: e  reason: collision with root package name */
    public final long f30154e;

    /* renamed from: f  reason: collision with root package name */
    public final long f30155f;

    /* renamed from: g  reason: collision with root package name */
    public final long f30156g;

    /* renamed from: h  reason: collision with root package name */
    public final long f30157h;

    /* renamed from: i  reason: collision with root package name */
    public final long f30158i;

    /* renamed from: j  reason: collision with root package name */
    public final long f30159j;

    /* renamed from: k  reason: collision with root package name */
    public final int f30160k;

    /* renamed from: l  reason: collision with root package name */
    public final int f30161l;

    /* renamed from: m  reason: collision with root package name */
    public final int f30162m;

    /* renamed from: n  reason: collision with root package name */
    public final long f30163n;

    public u(int i11, int i12, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, int i13, int i14, int i15, long j19) {
        this.f30150a = i11;
        this.f30151b = i12;
        this.f30152c = j11;
        this.f30153d = j12;
        this.f30154e = j13;
        this.f30155f = j14;
        this.f30156g = j15;
        this.f30157h = j16;
        this.f30158i = j17;
        this.f30159j = j18;
        this.f30160k = i13;
        this.f30161l = i14;
        this.f30162m = i15;
        this.f30163n = j19;
    }

    public void a(PrintWriter printWriter) {
        printWriter.println("===============BEGIN PICASSO STATS ===============");
        printWriter.println("Memory Cache Stats");
        printWriter.print("  Max Cache Size: ");
        printWriter.println(this.f30150a);
        printWriter.print("  Cache Size: ");
        printWriter.println(this.f30151b);
        printWriter.print("  Cache % Full: ");
        printWriter.println((int) Math.ceil((double) ((((float) this.f30151b) / ((float) this.f30150a)) * 100.0f)));
        printWriter.print("  Cache Hits: ");
        printWriter.println(this.f30152c);
        printWriter.print("  Cache Misses: ");
        printWriter.println(this.f30153d);
        printWriter.println("Network Stats");
        printWriter.print("  Download Count: ");
        printWriter.println(this.f30160k);
        printWriter.print("  Total Download Size: ");
        printWriter.println(this.f30154e);
        printWriter.print("  Average Download Size: ");
        printWriter.println(this.f30157h);
        printWriter.println("Bitmap Stats");
        printWriter.print("  Total Bitmaps Decoded: ");
        printWriter.println(this.f30161l);
        printWriter.print("  Total Bitmap Size: ");
        printWriter.println(this.f30155f);
        printWriter.print("  Total Transformed Bitmaps: ");
        printWriter.println(this.f30162m);
        printWriter.print("  Total Transformed Bitmap Size: ");
        printWriter.println(this.f30156g);
        printWriter.print("  Average Bitmap Size: ");
        printWriter.println(this.f30158i);
        printWriter.print("  Average Transformed Bitmap Size: ");
        printWriter.println(this.f30159j);
        printWriter.println("===============END PICASSO STATS ===============");
        printWriter.flush();
    }

    public String toString() {
        return "StatsSnapshot{maxSize=" + this.f30150a + ", size=" + this.f30151b + ", cacheHits=" + this.f30152c + ", cacheMisses=" + this.f30153d + ", downloadCount=" + this.f30160k + ", totalDownloadSize=" + this.f30154e + ", averageDownloadSize=" + this.f30157h + ", totalOriginalBitmapSize=" + this.f30155f + ", totalTransformedBitmapSize=" + this.f30156g + ", averageOriginalBitmapSize=" + this.f30158i + ", averageTransformedBitmapSize=" + this.f30159j + ", originalBitmapCount=" + this.f30161l + ", transformedBitmapCount=" + this.f30162m + ", timeStamp=" + this.f30163n + '}';
    }
}
