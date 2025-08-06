package com.mob.mcl.a;

import android.os.Bundle;
import android.text.TextUtils;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.network.StringPart;
import com.mob.tools.utils.HashonHelper;
import java.io.Serializable;
import java.util.HashMap;

public class b implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public String f27405a;

    /* renamed from: b  reason: collision with root package name */
    public String f27406b;

    /* renamed from: c  reason: collision with root package name */
    public String f27407c;

    /* renamed from: d  reason: collision with root package name */
    public String f27408d;

    /* renamed from: e  reason: collision with root package name */
    public int f27409e;

    /* renamed from: f  reason: collision with root package name */
    public int f27410f;

    /* renamed from: g  reason: collision with root package name */
    public int f27411g;

    public static HashMap<String, String> a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return HashonHelper.fromJson(str);
        }
        return null;
    }

    public static b a(Bundle bundle) {
        b bVar = new b();
        if (bundle != null) {
            bVar.f27405a = bundle.getString("type");
            bVar.f27406b = bundle.getString("url");
            bVar.f27407c = bundle.getString("headers");
            bVar.f27409e = bundle.getInt("chunkLength");
            bVar.f27408d = bundle.getString(TtmlNode.TAG_BODY);
            bVar.f27410f = bundle.getInt("readTimout");
            bVar.f27411g = bundle.getInt("connectionTimeout");
        }
        return bVar;
    }

    public static Bundle a(String str, String str2, HashMap<String, String> hashMap, StringPart stringPart, int i11, NetworkHelper.NetworkTimeOut networkTimeOut) {
        Bundle bundle = new Bundle();
        bundle.putString("type", str);
        bundle.putString("url", str2);
        HashMap hashMap2 = new HashMap();
        if (hashMap != null) {
            hashMap2.putAll(hashMap);
        }
        new HashonHelper();
        bundle.putString("headers", HashonHelper.fromHashMap(hashMap2));
        bundle.putInt("chunkLength", i11);
        if (stringPart != null) {
            bundle.putString(TtmlNode.TAG_BODY, stringPart.toString());
        }
        bundle.putInt("readTimout", networkTimeOut.readTimout);
        bundle.putInt("connectionTimeout", networkTimeOut.connectionTimeout);
        return bundle;
    }
}
