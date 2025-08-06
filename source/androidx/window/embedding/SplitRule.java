package androidx.window.embedding;

import kotlin.Metadata;
import kotlin.jvm.internal.r;

@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u000b\b\u0017\u0018\u00002\u00020\u0001B1\b\u0000\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0017\u0010\f\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000bR\u0017\u0010\u0015\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0018\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0016\u0010\t\u001a\u0004\b\u0017\u0010\u000b¨\u0006\u001b"}, d2 = {"Landroidx/window/embedding/SplitRule;", "Landroidx/window/embedding/EmbeddingRule;", "", "other", "", "equals", "", "hashCode", "a", "I", "getMinWidth", "()I", "minWidth", "b", "getMinSmallestWidth", "minSmallestWidth", "", "c", "F", "getSplitRatio", "()F", "splitRatio", "d", "getLayoutDirection", "layoutDirection", "<init>", "(IIFI)V", "window_release"}, k = 1, mv = {1, 6, 0})
public class SplitRule extends EmbeddingRule {

    /* renamed from: a  reason: collision with root package name */
    public final int f12074a;

    /* renamed from: b  reason: collision with root package name */
    public final int f12075b;

    /* renamed from: c  reason: collision with root package name */
    public final float f12076c;

    /* renamed from: d  reason: collision with root package name */
    public final int f12077d;

    public SplitRule() {
        this(0, 0, 0.0f, 0, 15, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SplitRule(int i11, int i12, float f11, int i13, int i14, r rVar) {
        this((i14 & 1) != 0 ? 0 : i11, (i14 & 2) != 0 ? 0 : i12, (i14 & 4) != 0 ? 0.5f : f11, (i14 & 8) != 0 ? 3 : i13);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplitRule)) {
            return false;
        }
        SplitRule splitRule = (SplitRule) obj;
        if (this.f12074a != splitRule.f12074a || this.f12075b != splitRule.f12075b) {
            return false;
        }
        return ((this.f12076c > splitRule.f12076c ? 1 : (this.f12076c == splitRule.f12076c ? 0 : -1)) == 0) && this.f12077d == splitRule.f12077d;
    }

    public int hashCode() {
        return (((((this.f12074a * 31) + this.f12075b) * 31) + Float.floatToIntBits(this.f12076c)) * 31) + this.f12077d;
    }

    public SplitRule(int i11, int i12, float f11, int i13) {
        this.f12074a = i11;
        this.f12075b = i12;
        this.f12076c = f11;
        this.f12077d = i13;
    }
}
