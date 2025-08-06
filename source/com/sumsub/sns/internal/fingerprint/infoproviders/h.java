package com.sumsub.sns.internal.fingerprint.infoproviders;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import com.sumsub.sns.internal.fingerprint.tools.threading.safe.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.Result;
import kotlin.jvm.internal.Lambda;

public final class h implements g {

    /* renamed from: a  reason: collision with root package name */
    public final MediaCodecList f34608a;

    public static final class a extends Lambda implements d10.a<List<? extends y>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f34609a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(h hVar) {
            super(0);
            this.f34609a = hVar;
        }

        /* renamed from: a */
        public final List<y> invoke() {
            return this.f34609a.b();
        }
    }

    public h(MediaCodecList mediaCodecList) {
        this.f34608a = mediaCodecList;
    }

    public final List<y> b() {
        String str;
        List list;
        MediaCodecInfo[] codecInfos = this.f34608a.getCodecInfos();
        ArrayList arrayList = new ArrayList(codecInfos.length);
        for (MediaCodecInfo mediaCodecInfo : codecInfos) {
            if (mediaCodecInfo == null || (str = mediaCodecInfo.getName()) == null) {
                str = "";
            }
            String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
            if (supportedTypes != null) {
                list = new ArrayList();
                for (String valueOf : supportedTypes) {
                    list.add(String.valueOf(valueOf));
                }
            } else {
                list = CollectionsKt__CollectionsKt.k();
            }
            arrayList.add(new y(str, list));
        }
        return arrayList;
    }

    public List<y> a() {
        Object a11 = c.a(0, new a(this), 1, (Object) null);
        List k11 = CollectionsKt__CollectionsKt.k();
        if (Result.m3078isFailureimpl(a11)) {
            a11 = k11;
        }
        return (List) a11;
    }
}
