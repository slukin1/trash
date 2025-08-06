package com.huobi.edgeengine.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.Keep;
import androidx.lifecycle.n0;
import cn.sharesdk.framework.InnerShareParams;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.SystemUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.p;
import com.hbg.lib.core.util.w;
import com.hbg.lib.imsdk.HbgDialogPageBean;
import com.hbg.lib.network.pro.core.bean.ProTokenUpdate;
import com.hbg.lib.network.retrofit.util.SPUtil;
import com.hbg.lib.network.uc.core.utils.UcHelper;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.libkt.base.ext.b;
import com.hbg.module.libkt.base.ui.BaseActivity;
import com.hbg.module.libkt.utils.b;
import com.hbg.module.libkt.utils.o;
import com.huawei.hms.push.AttributionReporter;
import com.huobi.account.event.LogOutEvent;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.edgeengine.model.Action;
import com.huobi.edgeengine.model.NavModel;
import com.huobi.edgeengine.template.widget.Widget;
import com.huobi.edgeengine.util.EdgeEngineScene;
import com.huobi.edgeengine.util.HBResType;
import com.huobi.edgeengine.util.ViewUtils;
import com.huobi.edgeengine.viewmodel.EdgeEngineContainerViewModel;
import com.huochat.community.network.domain.DomainTool;
import d10.a;
import dk.e;
import dk.g;
import e7.f;
import e7.s;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import k20.h;
import kotlin.i;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.x;
import lj.m;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;
import tg.r;

@Route(path = "/edgeengine/container")
public final class EdgeEngineContainerActivity extends BaseActivity<m> {

    /* renamed from: i  reason: collision with root package name */
    public final i f44354i = new n0(Reflection.b(EdgeEngineContainerViewModel.class), new EdgeEngineContainerActivity$special$$inlined$viewModels$default$2(this), new EdgeEngineContainerActivity$special$$inlined$viewModels$default$1(this), new EdgeEngineContainerActivity$special$$inlined$viewModels$default$3((a) null, this));

    /* renamed from: j  reason: collision with root package name */
    public String f44355j;

    /* renamed from: k  reason: collision with root package name */
    public String f44356k;

    /* renamed from: l  reason: collision with root package name */
    public Widget f44357l;

    /* renamed from: m  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f44358m;

    public static final void Lh(EdgeEngineContainerActivity edgeEngineContainerActivity, Object obj) {
        if (obj != null && (obj instanceof String) && !s.f70074d.containsKey(obj)) {
            Map<String, HbgDialogPageBean> map = s.f70074d;
            map.put(obj, new HbgDialogPageBean(f.a().f70056a + edgeEngineContainerActivity.Hh() + '_' + edgeEngineContainerActivity.Gh(), true));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0134, code lost:
        if ((r3.length() > 0) == true) goto L_0x0138;
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Nh(com.huobi.edgeengine.ui.EdgeEngineContainerActivity r6, java.lang.Object r7) {
        /*
            if (r7 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "loadNavByConfig ："
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            r6.Uh(r0)
            boolean r0 = r7 instanceof java.lang.String
            if (r0 == 0) goto L_0x0033
            java.lang.String r7 = (java.lang.String) r7
            com.huobi.edgeengine.ui.EdgeEngineContainerActivity$loadNavByConfig$lambda$14$$inlined$gsonToBean$1 r0 = new com.huobi.edgeengine.ui.EdgeEngineContainerActivity$loadNavByConfig$lambda$14$$inlined$gsonToBean$1
            r0.<init>()
            java.lang.reflect.Type r0 = r0.getType()
            com.google.gson.Gson r1 = com.hbg.module.libkt.base.ext.f.e()
            java.lang.Object r7 = r1.fromJson((java.lang.String) r7, (java.lang.reflect.Type) r0)
            com.huobi.edgeengine.model.EdgeEngineNavModel r7 = (com.huobi.edgeengine.model.EdgeEngineNavModel) r7
            if (r7 != 0) goto L_0x004d
            return
        L_0x0033:
            java.lang.String r7 = com.hbg.module.libkt.base.ext.f.f(r7)
            com.huobi.edgeengine.ui.EdgeEngineContainerActivity$loadNavByConfig$lambda$14$$inlined$gsonToBean$2 r0 = new com.huobi.edgeengine.ui.EdgeEngineContainerActivity$loadNavByConfig$lambda$14$$inlined$gsonToBean$2
            r0.<init>()
            java.lang.reflect.Type r0 = r0.getType()
            com.google.gson.Gson r1 = com.hbg.module.libkt.base.ext.f.e()
            java.lang.Object r7 = r1.fromJson((java.lang.String) r7, (java.lang.reflect.Type) r0)
            com.huobi.edgeengine.model.EdgeEngineNavModel r7 = (com.huobi.edgeengine.model.EdgeEngineNavModel) r7
            if (r7 != 0) goto L_0x004d
            return
        L_0x004d:
            com.huobi.edgeengine.model.NavModel r0 = r7.getLeft()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0068
            java.lang.String r3 = r0.getText()
            if (r3 == 0) goto L_0x0068
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x0063
            r3 = r1
            goto L_0x0064
        L_0x0063:
            r3 = r2
        L_0x0064:
            if (r3 != r1) goto L_0x0068
            r3 = r1
            goto L_0x0069
        L_0x0068:
            r3 = r2
        L_0x0069:
            if (r3 == 0) goto L_0x0076
            ek.a r3 = ek.a.f47514a
            com.huobi.edgeengine.util.HBResType r4 = com.huobi.edgeengine.util.HBResType.String
            java.lang.String r5 = r0.getText()
            r3.a(r6, r4, r5)
        L_0x0076:
            if (r0 == 0) goto L_0x008b
            java.lang.String r3 = r0.getIcon()
            if (r3 == 0) goto L_0x008b
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x0086
            r3 = r1
            goto L_0x0087
        L_0x0086:
            r3 = r2
        L_0x0087:
            if (r3 != r1) goto L_0x008b
            r3 = r1
            goto L_0x008c
        L_0x008b:
            r3 = r2
        L_0x008c:
            if (r3 == 0) goto L_0x00b5
            ek.a r3 = ek.a.f47514a
            com.huobi.edgeengine.util.HBResType r4 = com.huobi.edgeengine.util.HBResType.Drawable
            java.lang.String r5 = r0.getIcon()
            int r3 = r3.a(r6, r4, r5)
            x1.a r4 = r6.Yf()
            lj.m r4 = (lj.m) r4
            android.widget.ImageView r4 = r4.C
            r4.setImageResource(r3)
            x1.a r3 = r6.Yf()
            lj.m r3 = (lj.m) r3
            android.widget.ImageView r3 = r3.C
            dk.c r4 = new dk.c
            r4.<init>(r0, r6)
            r3.setOnClickListener(r4)
        L_0x00b5:
            com.huobi.edgeengine.model.NavModel r0 = r7.getRight()
            if (r0 != 0) goto L_0x00d5
            x1.a r0 = r6.Yf()
            lj.m r0 = (lj.m) r0
            android.widget.ImageView r0 = r0.D
            r0.setImageResource(r2)
            x1.a r0 = r6.Yf()
            lj.m r0 = (lj.m) r0
            android.widget.ImageView r0 = r0.D
            dk.d r1 = dk.d.f53799b
            r0.setOnClickListener(r1)
            goto L_0x0161
        L_0x00d5:
            java.lang.String r3 = r0.getText()
            if (r3 == 0) goto L_0x00e8
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x00e3
            r3 = r1
            goto L_0x00e4
        L_0x00e3:
            r3 = r2
        L_0x00e4:
            if (r3 != r1) goto L_0x00e8
            r3 = r1
            goto L_0x00e9
        L_0x00e8:
            r3 = r2
        L_0x00e9:
            if (r3 == 0) goto L_0x0125
            ek.a r3 = ek.a.f47514a
            com.huobi.edgeengine.util.HBResType r4 = com.huobi.edgeengine.util.HBResType.String
            java.lang.String r5 = r0.getText()
            int r3 = r3.a(r6, r4, r5)
            x1.a r4 = r6.Yf()
            lj.m r4 = (lj.m) r4
            android.widget.TextView r4 = r4.H
            android.content.res.Resources r5 = r6.getResources()
            java.lang.String r3 = r5.getString(r3)
            r4.setText(r3)
            x1.a r3 = r6.Yf()
            lj.m r3 = (lj.m) r3
            android.widget.TextView r3 = r3.H
            r3.setVisibility(r2)
            x1.a r3 = r6.Yf()
            lj.m r3 = (lj.m) r3
            android.widget.TextView r3 = r3.H
            dk.a r4 = new dk.a
            r4.<init>(r0, r6)
            r3.setOnClickListener(r4)
        L_0x0125:
            java.lang.String r3 = r0.getIcon()
            if (r3 == 0) goto L_0x0137
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x0133
            r3 = r1
            goto L_0x0134
        L_0x0133:
            r3 = r2
        L_0x0134:
            if (r3 != r1) goto L_0x0137
            goto L_0x0138
        L_0x0137:
            r1 = r2
        L_0x0138:
            if (r1 == 0) goto L_0x0161
            ek.a r1 = ek.a.f47514a
            com.huobi.edgeengine.util.HBResType r2 = com.huobi.edgeengine.util.HBResType.Drawable
            java.lang.String r3 = r0.getIcon()
            int r1 = r1.a(r6, r2, r3)
            x1.a r2 = r6.Yf()
            lj.m r2 = (lj.m) r2
            android.widget.ImageView r2 = r2.D
            r2.setImageResource(r1)
            x1.a r1 = r6.Yf()
            lj.m r1 = (lj.m) r1
            android.widget.ImageView r1 = r1.D
            dk.b r2 = new dk.b
            r2.<init>(r0, r6)
            r1.setOnClickListener(r2)
        L_0x0161:
            ek.a r0 = ek.a.f47514a
            com.huobi.edgeengine.util.HBResType r1 = com.huobi.edgeengine.util.HBResType.String
            java.lang.String r2 = r7.getTitleKey()
            int r1 = r0.a(r6, r1, r2)
            if (r1 != 0) goto L_0x0174
            java.lang.String r1 = r7.getTitle()
            goto L_0x0178
        L_0x0174:
            java.lang.String r1 = r6.getString(r1)
        L_0x0178:
            x1.a r2 = r6.Yf()
            lj.m r2 = (lj.m) r2
            android.widget.TextView r2 = r2.I
            r2.setText(r1)
            com.huobi.edgeengine.util.HBResType r1 = com.huobi.edgeengine.util.HBResType.Color
            java.lang.String r7 = r7.getBackgroundColor()
            int r7 = r0.a(r6, r1, r7)
            if (r7 == 0) goto L_0x01a5
            x1.a r0 = r6.Yf()
            lj.m r0 = (lj.m) r0
            android.widget.LinearLayout r0 = r0.G
            r0.setBackgroundResource(r7)
            x1.a r6 = r6.Yf()
            lj.m r6 = (lj.m) r6
            android.widget.RelativeLayout r6 = r6.F
            r6.setBackgroundResource(r7)
        L_0x01a5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.edgeengine.ui.EdgeEngineContainerActivity.Nh(com.huobi.edgeengine.ui.EdgeEngineContainerActivity, java.lang.Object):void");
    }

    public static final void Oh(NavModel navModel, EdgeEngineContainerActivity edgeEngineContainerActivity, View view) {
        Action action = navModel.getAction();
        String type = action != null ? action.getType() : null;
        if (type != null) {
            int hashCode = type.hashCode();
            if (hashCode != -1396674110) {
                if (hashCode != -1291451675) {
                    if (hashCode == 3015911 && type.equals("back")) {
                        edgeEngineContainerActivity.finish();
                        return;
                    }
                } else if (type.equals("evalJS")) {
                    String parameter = navModel.getAction().getParameter();
                    if (parameter != null) {
                        edgeEngineContainerActivity.Fh().h(parameter);
                        return;
                    }
                    return;
                }
            } else if (type.equals("backTo")) {
                return;
            }
        }
        edgeEngineContainerActivity.Uh("action参数不合法");
    }

    public static final void Ph(View view) {
    }

    public static final void Qh(NavModel navModel, EdgeEngineContainerActivity edgeEngineContainerActivity, View view) {
        Action action = navModel.getAction();
        String type = action != null ? action.getType() : null;
        if (type != null) {
            int hashCode = type.hashCode();
            if (hashCode != -1396674110) {
                if (hashCode != -1291451675) {
                    if (hashCode == 3015911 && type.equals("back")) {
                        edgeEngineContainerActivity.finish();
                        return;
                    }
                } else if (type.equals("evalJS")) {
                    String parameter = navModel.getAction().getParameter();
                    if (parameter != null) {
                        edgeEngineContainerActivity.Fh().h(parameter);
                        return;
                    }
                    return;
                }
            } else if (type.equals("backTo")) {
                return;
            }
        }
        edgeEngineContainerActivity.Uh("action参数不合法");
    }

    public static final void Rh(NavModel navModel, EdgeEngineContainerActivity edgeEngineContainerActivity, View view) {
        Action action = navModel.getAction();
        String type = action != null ? action.getType() : null;
        if (type != null) {
            int hashCode = type.hashCode();
            if (hashCode != -1396674110) {
                if (hashCode != -1291451675) {
                    if (hashCode == 3015911 && type.equals("back")) {
                        edgeEngineContainerActivity.finish();
                        return;
                    }
                } else if (type.equals("evalJS")) {
                    String parameter = navModel.getAction().getParameter();
                    if (parameter != null) {
                        edgeEngineContainerActivity.Fh().h(parameter);
                        return;
                    }
                    return;
                }
            } else if (type.equals("backTo")) {
                return;
            }
        }
        edgeEngineContainerActivity.Uh("action参数不合法");
    }

    public static final void Th(EdgeEngineContainerActivity edgeEngineContainerActivity, Object obj) {
        JSONObject jSONObject;
        if (obj != null) {
            if (obj instanceof String) {
                jSONObject = new JSONObject((String) obj);
            } else {
                jSONObject = new JSONObject(com.blankj.utilcode.util.m.g(obj));
            }
            if (!b.x(jSONObject.optString("isNight"))) {
                try {
                    edgeEngineContainerActivity.Qg(Boolean.parseBoolean(jSONObject.optString("isNight")));
                } catch (Throwable unused) {
                }
            }
            edgeEngineContainerActivity.Pg(!Boolean.parseBoolean(jSONObject.optString("statusBarMode")));
            int a11 = ek.a.f47514a.a(edgeEngineContainerActivity, HBResType.Color, jSONObject.optString("adStatusBarColor"));
            if (a11 != 0) {
                edgeEngineContainerActivity.setStatusBarColor(a11);
            }
            if (x.b(jSONObject.optString("keyBoardMode"), "adjustPan")) {
                Log.d("keyBoardMode", "adjustPan");
                edgeEngineContainerActivity.findViewById(16908290).getViewTreeObserver().removeOnGlobalLayoutListener(edgeEngineContainerActivity.f44358m);
                edgeEngineContainerActivity.findViewById(16908290).requestLayout();
                edgeEngineContainerActivity.getWindow().setSoftInputMode(32);
            }
        }
    }

    public final EdgeEngineContainerViewModel Fh() {
        return (EdgeEngineContainerViewModel) this.f44354i.getValue();
    }

    public final String Gh() {
        String str = this.f44356k;
        if (str != null) {
            return str;
        }
        return null;
    }

    public final String Hh() {
        String str = this.f44355j;
        if (str != null) {
            return str;
        }
        return null;
    }

    /* renamed from: Ih */
    public m Og() {
        return m.K(getLayoutInflater());
    }

    public final int Jh(Context context, int i11) {
        return (int) ((((float) i11) * 375.0f) / ((float) ViewUtils.a(context)));
    }

    public final void Kh() {
        rj.b h02 = Fh().h0();
        h02.u(Fh().i0() + ".edgeEnginePageId", new dk.f(this));
    }

    public final void Mh() {
        rj.b h02 = Fh().h0();
        h02.u(Fh().i0() + ".navConfig", new g(this));
    }

    public final void Sh() {
        rj.b h02 = Fh().h0();
        h02.u(Fh().i0() + ".statusBarConfig", new e(this));
    }

    public final void Uh(String str) {
        ek.b.f47515a.c(str);
    }

    public final void Vh(rj.b bVar) {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("h5Url", BaseModuleConfig.a().j());
        if (!SystemUtils.c()) {
            jSONObject.put("contractH5Url", wi.b.f48056t);
        }
        String y11 = LegalCurrencyConfigUtil.y();
        Locale locale = Locale.ROOT;
        jSONObject.put("currencyCharacter", y11.toUpperCase(locale));
        jSONObject.put("currencyRate", LegalCurrencyConfigUtil.v());
        jSONObject.put("priceColorType", Integer.valueOf(w.l() ^ true ? 1 : 0));
        jSONObject.put("colorMode", Integer.valueOf(NightHelper.e().g() ? 1 : 0));
        jSONObject.put("unionMode", Boolean.valueOf(SPUtil.j()));
        String j11 = AssetModuleConfig.a().j();
        Context context = null;
        jSONObject.put("iconURLHost", j11 != null ? StringsKt__StringsJVMKt.G(j11, DomainTool.DOMAIN_PREFIX, "", false, 4, (Object) null) : null);
        jSONObject.put("iconPlaceholder", "");
        jSONObject.put("OS", 1);
        jSONObject.put("bottomSafeAreaHeight", 0);
        jSONObject.put(AttributionReporter.APP_VERSION, 105400);
        if (bVar != null) {
            context = bVar.d();
        }
        jSONObject.put("language", p.a(context).toLowerCase(locale));
        jSONObject.put("webUrl", BaseModuleConfig.a().j());
        o oVar = o.f24912a;
        jSONObject.put("statusHeight", Integer.valueOf(PixelUtils.h((float) oVar.b(this))));
        jSONObject.put("countryId", sn.a.c().a());
        jSONObject.put("navbarHeight", Integer.valueOf(Jh(this, b.s(this))));
        jSONObject.put("statusBarHeight", Integer.valueOf(Jh(this, oVar.b(this))));
        jSONObject.put("isChild", r.x().X() ? "1" : "0");
        jSONObject.put("vToken", ku.b.e().h(this));
        jSONObject.put("oldVToken", UcHelper.b(true));
        if (bVar != null) {
            bVar.I("sendCommonConfig(" + jSONObject + ')');
        }
    }

    public final void Wh(String str) {
        this.f44356k = str;
    }

    public final void Xh(String str) {
        this.f44355j = str;
    }

    public void initView() {
    }

    public void oh() {
        Bundle extras;
        super.oh();
        Pg(false);
        Uh("容器初始化");
        Qg(NightHelper.e().g());
        getLifecycle().a(Fh());
        String stringExtra = getIntent().getStringExtra(InnerShareParams.SCENCE);
        String str = "";
        if (stringExtra == null) {
            stringExtra = str;
        }
        if (!x.b(stringExtra, EdgeEngineScene.TRADE_BOT.getScene())) {
            stringExtra = stringExtra.toLowerCase(Locale.ROOT);
        }
        Xh(stringExtra);
        rj.b b11 = ek.b.f47515a.b(this, Hh());
        Vh(b11);
        yt.a.f85088a.c(b11);
        Fh().t0(Hh());
        Fh().q0(b11);
        Uh("scene : " + Hh());
        String stringExtra2 = getIntent().getStringExtra("rootName");
        if (stringExtra2 == null) {
            stringExtra2 = str;
        }
        Wh(stringExtra2);
        Fh().r0(Gh());
        String stringExtra3 = getIntent().getStringExtra("xml");
        if (stringExtra3 == null) {
            stringExtra3 = Gh();
        }
        f a11 = f.a();
        a11.c(Hh() + '_' + Gh());
        Uh("moduleName : " + Gh() + " xml : " + stringExtra3);
        Log.d("keyBoardMode", "adjustReSize");
        Set<String> set = null;
        this.f44358m = b.a.b(com.hbg.module.libkt.utils.b.f24864f, findViewById(16908290), 0, 2, (Object) null);
        Sh();
        Kh();
        String stringExtra4 = getIntent().getStringExtra("navConfig");
        if ((stringExtra4 == null || stringExtra4.length() == 0) || StringsKt__StringsJVMKt.w(stringExtra4, MessengerShareContentUtility.WEBVIEW_RATIO_FULL, true)) {
            ((m) Yf()).B.setVisibility(8);
            ((m) Yf()).F.setVisibility(8);
        } else if (x.b(stringExtra4, AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE)) {
            ((m) Yf()).B.setVisibility(0);
            ((m) Yf()).F.setVisibility(0);
            try {
                Mh();
            } catch (Exception unused) {
                Uh("导航栏解析失败");
            }
        } else {
            ((m) Yf()).B.setVisibility(0);
            ((m) Yf()).F.setVisibility(8);
            rj.b h02 = Fh().h0();
            ((m) Yf()).B.addView(h02.D(stringExtra4 + ".xml", this));
        }
        rj.b h03 = Fh().h0();
        Widget F = h03.F(stringExtra3 + ".xml", this, false, (com.alibaba.fastjson.JSONObject) null);
        this.f44357l = F;
        ((m) Yf()).E.addView(F != null ? F.P(this) : null);
        Intent intent = getIntent();
        if (!(intent == null || (extras = intent.getExtras()) == null)) {
            set = extras.keySet();
        }
        if (set != null) {
            HashMap hashMap = new HashMap();
            for (String str2 : set) {
                String stringExtra5 = getIntent().getStringExtra(str2);
                if (!(stringExtra5 == null || stringExtra5.length() == 0) && !x.b(str2, InnerShareParams.SCENCE) && !x.b(str2, "rootName") && !x.b(str2, "xml") && !x.b(str2, "navConfig")) {
                    hashMap.put(str2, stringExtra5);
                }
            }
            if (!hashMap.isEmpty()) {
                EdgeEngineContainerViewModel Fh = Fh();
                String f11 = com.hbg.module.libkt.base.ext.f.f(hashMap);
                if (f11 != null) {
                    str = f11;
                }
                Fh.s0(str);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!EventBus.d().i(this)) {
            EventBus.d().p(this);
        }
    }

    public void onDestroy() {
        Widget widget = this.f44357l;
        if (widget != null) {
            widget.O();
        }
        EventBus.d().r(this);
        super.onDestroy();
        Uh("Activity onDestroy");
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public final void onEvent(LogOutEvent logOutEvent) {
        yt.a.f85088a.c(Fh().h0());
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public final void onProTokenUpdate(ProTokenUpdate proTokenUpdate) {
        yt.a.f85088a.c(Fh().h0());
    }
}
