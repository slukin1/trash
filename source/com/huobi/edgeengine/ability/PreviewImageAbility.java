package com.huobi.edgeengine.ability;

import android.app.Activity;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.m;
import com.hbg.lib.widgets.photoviewer.PhotoViewerUtils;
import com.huobi.edgeengine.ability.AbilityFunction;
import i6.d;
import java.util.List;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import rj.b;

public final class PreviewImageAbility implements s {

    /* renamed from: a  reason: collision with root package name */
    public static final a f43895a = new a((r) null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public void a(b bVar, Object obj, AbilityFunction.a aVar) {
        if (bVar != null) {
            try {
                d.c("previewImage", "PreviewImageAbility call result= " + obj);
                PreviewImageBean previewImageBean = (PreviewImageBean) m.d().fromJson((String) obj, PreviewImageBean.class);
                PhotoViewerUtils.a((Activity) bVar.d(), PhotoViewerUtils.b(previewImageBean.b()), previewImageBean.a());
                if (aVar != null) {
                    aVar.a(true, obj);
                }
            } catch (Throwable th2) {
                LogUtils.j(th2);
                if (aVar != null) {
                    aVar.a(false, obj);
                }
            }
        }
    }

    public static final class PreviewImageBean {

        /* renamed from: a  reason: collision with root package name */
        public int f43896a;

        /* renamed from: b  reason: collision with root package name */
        public List<String> f43897b;

        public PreviewImageBean() {
            this(0, (List) null, 3, (r) null);
        }

        public PreviewImageBean(int i11, List<String> list) {
            this.f43896a = i11;
            this.f43897b = list;
        }

        public final int a() {
            return this.f43896a;
        }

        public final List<String> b() {
            return this.f43897b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PreviewImageBean)) {
                return false;
            }
            PreviewImageBean previewImageBean = (PreviewImageBean) obj;
            return this.f43896a == previewImageBean.f43896a && x.b(this.f43897b, previewImageBean.f43897b);
        }

        public int hashCode() {
            int i11 = this.f43896a * 31;
            List<String> list = this.f43897b;
            return i11 + (list == null ? 0 : list.hashCode());
        }

        public String toString() {
            return "PreviewImageBean(currentIndex=" + this.f43896a + ", imageList=" + this.f43897b + ')';
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ PreviewImageBean(int i11, List list, int i12, r rVar) {
            this((i12 & 1) != 0 ? 0 : i11, (i12 & 2) != 0 ? null : list);
        }
    }
}
