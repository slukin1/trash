package com.hbg.lite.index.bean;

import com.hbg.lib.network.hbg.core.bean.TeachConfigItem;

public class LiteIndexChatTutorialModel {

    /* renamed from: a  reason: collision with root package name */
    public TeachConfigItem f77074a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f77075b;

    public boolean a(Object obj) {
        return obj instanceof LiteIndexChatTutorialModel;
    }

    public TeachConfigItem b() {
        return this.f77074a;
    }

    public boolean c() {
        return this.f77075b;
    }

    public void d(boolean z11) {
        this.f77075b = z11;
    }

    public void e(TeachConfigItem teachConfigItem) {
        this.f77074a = teachConfigItem;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LiteIndexChatTutorialModel)) {
            return false;
        }
        LiteIndexChatTutorialModel liteIndexChatTutorialModel = (LiteIndexChatTutorialModel) obj;
        if (!liteIndexChatTutorialModel.a(this)) {
            return false;
        }
        TeachConfigItem b11 = b();
        TeachConfigItem b12 = liteIndexChatTutorialModel.b();
        if (b11 != null ? b11.equals(b12) : b12 == null) {
            return c() == liteIndexChatTutorialModel.c();
        }
        return false;
    }

    public int hashCode() {
        TeachConfigItem b11 = b();
        return (((b11 == null ? 43 : b11.hashCode()) + 59) * 59) + (c() ? 79 : 97);
    }

    public String toString() {
        return "LiteIndexChatTutorialModel(teachConfigItem=" + b() + ", animate=" + c() + ")";
    }
}
