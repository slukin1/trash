package al;

import com.hbg.lib.core.util.CollectionsUtils;
import com.huobi.asset.AssetAccountType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public HashMap<AssetAccountType, ArrayList<Integer>> f40733a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<AssetAccountType, Integer> f40734b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<AssetAccountType, Integer> f40735c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<AssetAccountType, b> f40736d;

    /* renamed from: e  reason: collision with root package name */
    public long f40737e;

    public interface b {
        void a(int i11, boolean z11);
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static l f40738a = new l();
    }

    public static l f() {
        return c.f40738a;
    }

    public void a() {
        this.f40734b.clear();
    }

    public void b(AssetAccountType assetAccountType) {
        g();
        ArrayList arrayList = this.f40733a.get(assetAccountType);
        if (!CollectionsUtils.b(arrayList)) {
            arrayList.clear();
            this.f40733a.put(assetAccountType, arrayList);
        }
    }

    public void c(int i11, AssetAccountType assetAccountType) {
        d(i11, assetAccountType, false);
        b bVar = this.f40736d.get(assetAccountType);
        if (bVar != null) {
            bVar.a(i11, false);
        }
    }

    public void d(int i11, AssetAccountType assetAccountType, boolean z11) {
        b bVar;
        g();
        ArrayList arrayList = this.f40733a.get(assetAccountType);
        if (!CollectionsUtils.b(arrayList) && arrayList.contains(Integer.valueOf(i11))) {
            if (z11 && (bVar = this.f40736d.get(assetAccountType)) != null) {
                bVar.a(i11, false);
            }
            arrayList.remove(Integer.valueOf(i11));
            this.f40733a.put(assetAccountType, arrayList);
        }
    }

    public int e(AssetAccountType assetAccountType) {
        if (this.f40734b.get(assetAccountType) != null) {
            return this.f40734b.get(assetAccountType).intValue();
        }
        return -1;
    }

    public final void g() {
        this.f40737e = System.currentTimeMillis();
    }

    public boolean h(int i11, AssetAccountType assetAccountType) {
        ArrayList arrayList = this.f40733a.get(assetAccountType);
        if (CollectionsUtils.b(arrayList)) {
            return false;
        }
        return arrayList.contains(Integer.valueOf(i11));
    }

    public boolean i() {
        return System.currentTimeMillis() - this.f40737e > 1000;
    }

    public void j(AssetAccountType assetAccountType, b bVar) {
        this.f40736d.put(assetAccountType, bVar);
    }

    public void k(int i11, AssetAccountType assetAccountType) {
        b bVar;
        g();
        for (Map.Entry next : this.f40733a.entrySet()) {
            AssetAccountType assetAccountType2 = (AssetAccountType) next.getKey();
            ArrayList arrayList = (ArrayList) next.getValue();
            if (!CollectionsUtils.b(arrayList)) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    Integer num = (Integer) it2.next();
                    if (!((num.intValue() == i11 && assetAccountType == assetAccountType2) || (bVar = this.f40736d.get(assetAccountType2)) == null)) {
                        bVar.a(num.intValue(), false);
                    }
                }
                arrayList.clear();
                this.f40733a.put(assetAccountType2, arrayList);
            }
        }
        ArrayList arrayList2 = this.f40733a.get(assetAccountType);
        if (arrayList2 == null) {
            arrayList2 = new ArrayList();
        }
        arrayList2.add(Integer.valueOf(i11));
        this.f40733a.put(assetAccountType, arrayList2);
        b bVar2 = this.f40736d.get(assetAccountType);
        if (bVar2 != null) {
            bVar2.a(i11, true);
        }
    }

    public void l(AssetAccountType assetAccountType, int i11) {
        this.f40734b.put(assetAccountType, Integer.valueOf(i11));
    }

    public l() {
        this.f40733a = new HashMap<>();
        this.f40734b = new HashMap<>();
        this.f40735c = new HashMap<>();
        this.f40736d = new HashMap<>();
        this.f40737e = 0;
    }
}
