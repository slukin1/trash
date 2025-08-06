package com.jumio.core.cdn;

import android.content.res.AssetManager;
import com.jumio.commons.PersistWith;
import com.jumio.core.model.StaticModel;
import d10.l;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import jumio.core.o1;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONObject;

@PersistWith("CDNFeatureModel")
public final class CDNFeatureModel implements Serializable, StaticModel {

    /* renamed from: a  reason: collision with root package name */
    public final CDNCache f39079a = new CDNCache();

    /* renamed from: b  reason: collision with root package name */
    public final LinkedHashMap f39080b = new LinkedHashMap();

    public static final class a extends Lambda implements l<JSONObject, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CDNFeatureModel f39081a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(CDNFeatureModel cDNFeatureModel) {
            super(1);
            this.f39081a = cDNFeatureModel;
        }

        public final Object invoke(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            String string = jSONObject.getString("name");
            this.f39081a.f39080b.put(string, new CDNEncryptedEntry(jSONObject.getString("file"), jSONObject.getString("key"), jSONObject.getString("iv"), string, this.f39081a.f39079a));
            if (!this.f39081a.has(jSONObject.getString("name"))) {
                this.f39081a.f39079a.remove(jSONObject.getString("name"));
            }
            return Unit.f56620a;
        }
    }

    public static /* synthetic */ void load$default(CDNFeatureModel cDNFeatureModel, String str, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = CDNDownload.DEFAULT_TIMEOUT;
        }
        cDNFeatureModel.load(str, i11);
    }

    public final synchronized void clean(String str) {
        CDNEncryptedEntry cDNEncryptedEntry = (CDNEncryptedEntry) this.f39080b.get(str);
        if (cDNEncryptedEntry != null) {
            CDNCache cDNCache = this.f39079a;
            String name = cDNEncryptedEntry.getName();
            cDNCache.remove(str + "/" + name);
        }
    }

    public final CDNEncryptedEntry get(String str) {
        return (CDNEncryptedEntry) this.f39080b.get(str);
    }

    public final AssetManager getAssetManager() {
        return this.f39079a.getAssetManager();
    }

    public final File getDirectory() {
        return this.f39079a.getDirectory();
    }

    public final synchronized boolean has(String str) {
        boolean z11;
        CDNEncryptedEntry cDNEncryptedEntry = (CDNEncryptedEntry) this.f39080b.get(str);
        if (cDNEncryptedEntry != null) {
            CDNCache cDNCache = this.f39079a;
            String name = cDNEncryptedEntry.getName();
            z11 = cDNCache.has(str + "/" + name);
        } else {
            z11 = false;
        }
        return z11;
    }

    public final synchronized void load(String str, int i11) {
        CDNEncryptedEntry cDNEncryptedEntry = (CDNEncryptedEntry) this.f39080b.get(str);
        if (cDNEncryptedEntry != null) {
            CDNCache cDNCache = this.f39079a;
            String name = cDNEncryptedEntry.getName();
            String name2 = cDNEncryptedEntry.getName();
            CDNCache.load$default(cDNCache, name, str + "/" + name2, i11, (l) null, 8, (Object) null);
        }
    }

    public final void setAssetManager(AssetManager assetManager) {
        this.f39079a.setAssetManager(assetManager);
    }

    public final void setDirectory(File file) {
        this.f39079a.setDirectory(file);
    }

    public final synchronized void setup(JSONArray jSONArray) {
        o1.a(jSONArray, new a(this));
        String[] list = getDirectory().list();
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                if (!this.f39080b.keySet().contains(str)) {
                    arrayList.add(str);
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                this.f39079a.remove((String) it2.next());
            }
        }
    }
}
