package com.jumio.core.extraction;

import android.graphics.Rect;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.io.Serializable;
import jumio.core.p1;
import kotlin.jvm.internal.r;
import org.json.JSONObject;

public final class JumioRect implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final int f39179a;

    /* renamed from: b  reason: collision with root package name */
    public final int f39180b;

    /* renamed from: c  reason: collision with root package name */
    public final int f39181c;

    /* renamed from: d  reason: collision with root package name */
    public final int f39182d;

    public JumioRect() {
        this(0, 0, 0, 0, 15, (r) null);
    }

    public JumioRect(int i11, int i12, int i13, int i14) {
        this.f39179a = i11;
        this.f39180b = i12;
        this.f39181c = i13;
        this.f39182d = i14;
    }

    public static /* synthetic */ JumioRect copy$default(JumioRect jumioRect, int i11, int i12, int i13, int i14, int i15, Object obj) {
        if ((i15 & 1) != 0) {
            i11 = jumioRect.f39179a;
        }
        if ((i15 & 2) != 0) {
            i12 = jumioRect.f39180b;
        }
        if ((i15 & 4) != 0) {
            i13 = jumioRect.f39181c;
        }
        if ((i15 & 8) != 0) {
            i14 = jumioRect.f39182d;
        }
        return jumioRect.copy(i11, i12, i13, i14);
    }

    public final int component1() {
        return this.f39179a;
    }

    public final int component2() {
        return this.f39180b;
    }

    public final int component3() {
        return this.f39181c;
    }

    public final int component4() {
        return this.f39182d;
    }

    public final JumioRect copy(int i11, int i12, int i13, int i14) {
        return new JumioRect(i11, i12, i13, i14);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JumioRect)) {
            return false;
        }
        JumioRect jumioRect = (JumioRect) obj;
        return this.f39179a == jumioRect.f39179a && this.f39180b == jumioRect.f39180b && this.f39181c == jumioRect.f39181c && this.f39182d == jumioRect.f39182d;
    }

    public final int getBottom() {
        return this.f39182d;
    }

    public final int getLeft() {
        return this.f39179a;
    }

    public final int getRight() {
        return this.f39181c;
    }

    public final int getTop() {
        return this.f39180b;
    }

    public int hashCode() {
        return this.f39182d + p1.a(this.f39181c, p1.a(this.f39180b, this.f39179a * 31, 31), 31);
    }

    public final int height() {
        return this.f39182d - this.f39180b;
    }

    public final boolean isEmpty() {
        return this.f39179a == 0 && this.f39180b == 0 && this.f39181c == 0 && this.f39182d == 0;
    }

    public final JSONObject toJson() {
        return new JSONObject().put("left", this.f39179a).put(TtmlNode.RIGHT, this.f39181c).put(ViewHierarchyConstants.DIMENSION_TOP_KEY, this.f39180b).put("bottom", this.f39182d);
    }

    public final Rect toRect() {
        return new Rect(this.f39179a, this.f39180b, this.f39181c, this.f39182d);
    }

    public String toString() {
        int i11 = this.f39179a;
        int i12 = this.f39180b;
        int i13 = this.f39181c;
        int i14 = this.f39182d;
        return "JumioRect(left=" + i11 + ", top=" + i12 + ", right=" + i13 + ", bottom=" + i14 + ")";
    }

    public final int width() {
        return this.f39181c - this.f39179a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JumioRect(int i11, int i12, int i13, int i14, int i15, r rVar) {
        this((i15 & 1) != 0 ? 0 : i11, (i15 & 2) != 0 ? 0 : i12, (i15 & 4) != 0 ? 0 : i13, (i15 & 8) != 0 ? 0 : i14);
    }
}
