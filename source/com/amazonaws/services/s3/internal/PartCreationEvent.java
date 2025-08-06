package com.amazonaws.services.s3.internal;

import com.amazonaws.services.s3.OnFileDelete;
import java.io.File;

public class PartCreationEvent {

    /* renamed from: a  reason: collision with root package name */
    public final File f15169a;

    /* renamed from: b  reason: collision with root package name */
    public final int f15170b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f15171c;

    /* renamed from: d  reason: collision with root package name */
    public final OnFileDelete f15172d;

    public PartCreationEvent(File file, int i11, boolean z11, OnFileDelete onFileDelete) {
        if (file != null) {
            this.f15169a = file;
            this.f15170b = i11;
            this.f15171c = z11;
            this.f15172d = onFileDelete;
            return;
        }
        throw new IllegalArgumentException("part must not be specified");
    }

    public OnFileDelete a() {
        return this.f15172d;
    }

    public File b() {
        return this.f15169a;
    }

    public int c() {
        return this.f15170b;
    }

    public boolean d() {
        return this.f15171c;
    }
}
