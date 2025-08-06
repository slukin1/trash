package com.huobi.edgeengine.ability;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.hbg.lib.network.hbg.socket.response.BaseHbgResponse;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.edgeengine.ability.AbilityFunction;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.internal.r;
import rj.b;

public final class AlertAbility implements s {

    /* renamed from: a  reason: collision with root package name */
    public static final a f43882a = new a((r) null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public static final void d(String str, HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        if (!TextUtils.isEmpty(str)) {
            zn.a.d().v(Uri.parse(str)).a().c();
        }
    }

    public static final void e(String str, HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        if (!TextUtils.isEmpty(str)) {
            zn.a.d().v(Uri.parse(str)).a().c();
        }
    }

    public void a(b bVar, Object obj, AbilityFunction.a aVar) {
        Unit unit;
        Map<?, ?> g11 = g(obj);
        if (g11 != null) {
            String f11 = f(g11, "okUrl");
            String f12 = f(g11, "cancelUrl");
            Context d11 = bVar != null ? bVar.d() : null;
            ek.a aVar2 = ek.a.f47514a;
            HBDialogFragment b02 = DialogUtils.b0((FragmentActivity) d11, aVar2.b(bVar, f(g11, "title")), (CharSequence) null, aVar2.b(bVar, f(g11, "content")), aVar2.b(bVar, f(g11, "cancel")), aVar2.b(bVar, f(g11, BaseHbgResponse.STATUS_OK)), new a(f12), new b(f11));
            if (g11.containsKey("canceledOnTouchOutside")) {
                b02.setCanceledOnTouchOutside(Boolean.parseBoolean(String.valueOf(g11.get("canceledOnTouchOutside"))));
            }
            if (aVar != null) {
                aVar.a(true, (Object) null);
                unit = Unit.f56620a;
            } else {
                unit = null;
            }
            if (unit != null) {
                return;
            }
        }
        if (aVar != null) {
            aVar.a(false, (Object) null);
            Unit unit2 = Unit.f56620a;
        }
    }

    public final String f(Map<?, ?> map, String str) {
        if (!map.containsKey(str)) {
            return "";
        }
        Object obj = map.get(str);
        Objects.requireNonNull(obj);
        return String.valueOf(obj);
    }

    public final Map<?, ?> g(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        try {
            return (Map) JSON.parseObject((String) obj, (Type) Map.class, new Feature[0]);
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }
}
