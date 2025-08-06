package com.jumio.commons.camera;

import com.jumio.commons.PersistWith;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import kotlin.jvm.internal.r;

@PersistWith("PreviewProperties")
public final class PreviewProperties implements Serializable {
    public static final Companion Companion = new Companion((r) null);

    /* renamed from: a  reason: collision with root package name */
    public Size f38972a = new Size(0, 0);

    /* renamed from: b  reason: collision with root package name */
    public Size f38973b = new Size(0, 0);

    /* renamed from: c  reason: collision with root package name */
    public Size f38974c = new Size(0, 0);

    /* renamed from: d  reason: collision with root package name */
    public boolean f38975d;

    /* renamed from: e  reason: collision with root package name */
    public int f38976e;

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }
    }

    public final PreviewProperties copy() {
        PreviewProperties previewProperties = new PreviewProperties();
        previewProperties.f38972a = Size.copy$default(this.f38972a, 0, 0, 3, (Object) null);
        previewProperties.f38973b = Size.copy$default(this.f38973b, 0, 0, 3, (Object) null);
        previewProperties.f38974c = Size.copy$default(this.f38974c, 0, 0, 3, (Object) null);
        previewProperties.f38975d = this.f38975d;
        previewProperties.f38976e = this.f38976e;
        return previewProperties;
    }

    public final boolean getFrontFacing() {
        return this.f38975d;
    }

    public final Size getPreview() {
        return this.f38974c;
    }

    public final Size getScaledPreview() {
        return this.f38972a;
    }

    public final int getSensorRotation() {
        return this.f38976e;
    }

    public final Size getSurface() {
        return this.f38973b;
    }

    public final boolean isEmpty() {
        return this.f38974c.isEmpty() && this.f38973b.isEmpty() && this.f38972a.isEmpty();
    }

    public final void setFrontFacing(boolean z11) {
        this.f38975d = z11;
    }

    public final void setPreview(Size size) {
        this.f38974c = size;
    }

    public final void setScaledPreview(Size size) {
        this.f38972a = size;
    }

    public final void setSensorRotation(int i11) {
        this.f38976e = i11;
    }

    public final void setSurface(Size size) {
        this.f38973b = size;
    }

    public String toString() {
        int width = this.f38972a.getWidth();
        int height = this.f38972a.getHeight();
        int width2 = this.f38973b.getWidth();
        int height2 = this.f38973b.getHeight();
        int width3 = this.f38974c.getWidth();
        int height3 = this.f38974c.getHeight();
        boolean z11 = this.f38975d;
        int i11 = this.f38976e;
        return StringsKt__IndentKt.h("\n\t\t\t| scaledPreview: (" + width + Constants.ACCEPT_TIME_SEPARATOR_SP + height + ")\n\t\t\t| surface: (" + width2 + Constants.ACCEPT_TIME_SEPARATOR_SP + height2 + ")\n\t\t\t| preview: (" + width3 + Constants.ACCEPT_TIME_SEPARATOR_SP + height3 + ")\n\t\t\t| frontFacing: " + z11 + "\n\t\t\t| sensorRotation: " + i11 + "\n\t\t", (String) null, 1, (Object) null);
    }
}
