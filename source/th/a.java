package th;

import com.huobi.asset.feature.summary.AssetSummaryAccountType;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public AssetSummaryAccountType f47895a;

    /* renamed from: b  reason: collision with root package name */
    public AssetSummaryAccountType f47896b;

    public a(AssetSummaryAccountType assetSummaryAccountType, AssetSummaryAccountType assetSummaryAccountType2) {
        this.f47895a = assetSummaryAccountType;
        this.f47896b = assetSummaryAccountType2;
    }

    public boolean a(Object obj) {
        return obj instanceof a;
    }

    public AssetSummaryAccountType b() {
        return this.f47895a;
    }

    public AssetSummaryAccountType c() {
        return this.f47896b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (!aVar.a(this)) {
            return false;
        }
        AssetSummaryAccountType b11 = b();
        AssetSummaryAccountType b12 = aVar.b();
        if (b11 != null ? !b11.equals(b12) : b12 != null) {
            return false;
        }
        AssetSummaryAccountType c11 = c();
        AssetSummaryAccountType c12 = aVar.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public int hashCode() {
        AssetSummaryAccountType b11 = b();
        int i11 = 43;
        int hashCode = b11 == null ? 43 : b11.hashCode();
        AssetSummaryAccountType c11 = c();
        int i12 = (hashCode + 59) * 59;
        if (c11 != null) {
            i11 = c11.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "AssetNavigationEvent(accountType=" + b() + ", subAccountType=" + c() + ")";
    }
}
