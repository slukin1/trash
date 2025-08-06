package com.huobi.app.startuptasks;

import al.p;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.widget.ImageView;
import com.bumptech.glide.request.e;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.module.account.edgeengine.widget.AccountAvatarWidget;
import com.hbg.module.content.custom.widget.TagCellWidget;
import com.huobi.copytrading.widget.CopyTradingLineChart;
import com.huobi.edgeengine.ability.AlertAbility;
import com.huobi.edgeengine.ability.ClipBoardAbility;
import com.huobi.edgeengine.ability.CloseKeyboardAbility;
import com.huobi.edgeengine.ability.DatePickerAbility;
import com.huobi.edgeengine.ability.EngineAnatylicsAbility;
import com.huobi.edgeengine.ability.EngineCurrencyAbility;
import com.huobi.edgeengine.ability.EngineGetStringAbility;
import com.huobi.edgeengine.ability.EngineHandleFavorite;
import com.huobi.edgeengine.ability.EngineNetworkAbility;
import com.huobi.edgeengine.ability.EngineStorageAbility;
import com.huobi.edgeengine.ability.EngineSymbolAbility;
import com.huobi.edgeengine.ability.HBToastAbility;
import com.huobi.edgeengine.ability.I18nAbility;
import com.huobi.edgeengine.ability.RouteAbility;
import com.huobi.edgeengine.ability.ShareAbility;
import com.huobi.edgeengine.ability.ShowLoadingAbility;
import com.huobi.edgeengine.ability.TemplateInfoListAbility;
import com.huobi.edgeengine.ability.UploadLogAbility;
import com.huobi.edgeengine.widget.LottieWidget;
import com.huobi.edgeengine.widget.MarginRateSectorWidget;
import com.huobi.edgeengine.widget.OrderBookWidget;
import com.huobi.edgeengine.widget.SeekBarWidget;
import com.huobi.engineutils.widget.BottomLineTextWidget;
import com.huobi.tradingbot.widget.DashLineWidget;
import com.huochat.community.util.ImageLoadedrManager;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import e6.c;
import e6.g;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import oupson.apng.decoder.ApngDecoder;
import rj.b;
import tx.a;

public class EdgeEngineInitTask extends BaseAppStartTask {

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<DisplayImageOptions> f42181a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    public boolean f42182b = false;

    public static /* synthetic */ InputStream g(b bVar, Context context, String str) {
        if (bVar == null) {
            return null;
        }
        String k11 = bVar.k();
        c r11 = c.r("RMS");
        String s11 = r11.s(k11);
        if (!TextUtils.isEmpty(s11)) {
            try {
                return new FileInputStream(s11 + File.separator + str);
            } catch (FileNotFoundException e11) {
                e11.printStackTrace();
            }
        }
        try {
            AssetManager assets = context.getAssets();
            return assets.open(r11.q(k11) + File.separator + str);
        } catch (IOException e12) {
            e12.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h(ImageView imageView, String str, int i11) {
        try {
            if (imageView.getContext() != null) {
                Drawable drawable = null;
                if (!TextUtils.isEmpty(str)) {
                    if (!"undefined".equals(str)) {
                        if (!str.startsWith("http")) {
                            Drawable s11 = g.v().s(imageView.getContext().getResources(), str);
                            if (s11 == null && i11 != 0) {
                                s11 = imageView.getResources().getDrawable(i11);
                            }
                            imageView.setImageDrawable(s11);
                            return;
                        } else if (str.endsWith("png") && "ApngDecoder".equals(imageView.getTag())) {
                            ApngDecoder.c(imageView.getContext(), new URL(str), imageView);
                            return;
                        } else if (str.endsWith("gif")) {
                            ImageLoadedrManager instance = ImageLoadedrManager.getInstance();
                            Context context = imageView.getContext();
                            if (i11 != 0) {
                                drawable = imageView.getResources().getDrawable(i11);
                            }
                            instance.displayGif(context, str, drawable, (e<Drawable>) null, imageView);
                            return;
                        } else {
                            if (i11 == 0) {
                                i11 = p.m();
                            }
                            int i12 = i11;
                            g6.b.c().j(imageView, str, i12, f(imageView.getContext(), i12), (a) null);
                            return;
                        }
                    }
                }
                if (i11 != 0) {
                    drawable = imageView.getResources().getDrawable(i11);
                }
                imageView.setImageDrawable(drawable);
            }
        } catch (Throwable th2) {
            Log.e("EdgeEngine", "image 加载异常 " + th2.getMessage());
            th2.printStackTrace();
        }
    }

    public void c() {
        Class<EngineNetworkAbility> cls = EngineNetworkAbility.class;
        b.w("request", cls);
        b.x("TagCell", TagCellWidget.class);
        b.x("SeekBar", SeekBarWidget.class);
        b.x("OrderBook", OrderBookWidget.class);
        b.x("LottieView", LottieWidget.class);
        b.x("AccountAvatar", AccountAvatarWidget.class);
        b.x("MarginRateSector", MarginRateSectorWidget.class);
        b.x("BottomLineTextView", BottomLineTextWidget.class);
        b.x("KlineChat", CopyTradingLineChart.class);
        b.x("DashLineView", DashLineWidget.class);
        b.w("request", cls);
        b.w("geti18nString", EngineGetStringAbility.class);
        b.w("storage", EngineStorageAbility.class);
        b.w("analytics", EngineAnatylicsAbility.class);
        b.w("uploadLog", UploadLogAbility.class);
        b.w("closeKeyboard", CloseKeyboardAbility.class);
        b.w("clipBoard", ClipBoardAbility.class);
        b.w("openRoute", RouteAbility.class);
        b.w("alert", AlertAbility.class);
        b.w("i18n", I18nAbility.class);
        b.w("hbToast", HBToastAbility.class);
        b.w("showLoading", ShowLoadingAbility.class);
        b.w("handleFavorite", EngineHandleFavorite.class);
        b.w("getSpotSymbolModel", EngineSymbolAbility.class);
        b.w("getCurrencyShowPrecision", EngineCurrencyAbility.class);
        b.w("shareAbility", ShareAbility.class);
        b.w("showDatePicker", DatePickerAbility.class);
        b.w("rmsInfo", TemplateInfoListAbility.class);
        b.y(ch.c.f13085a);
        b.K(new ch.b(this));
    }

    public final DisplayImageOptions f(Context context, int i11) {
        if (context == null) {
            return null;
        }
        int d11 = g6.b.c().d();
        if (NightHelper.e().g() != this.f42182b) {
            this.f42181a.clear();
            this.f42182b = NightHelper.e().g();
        }
        int i12 = (i11 * 10) + d11;
        DisplayImageOptions displayImageOptions = this.f42181a.get(i12);
        if (displayImageOptions != null) {
            return displayImageOptions;
        }
        DisplayImageOptions.Builder w11 = new DisplayImageOptions.Builder().A(true).w(true);
        if (i11 != -1) {
            Drawable drawable = context.getResources().getDrawable(i11);
            w11.G(drawable);
            w11.E(drawable);
            w11.C(drawable);
        }
        if (d11 == 1) {
            w11.z(ImageScaleType.EXACTLY).t(Bitmap.Config.RGB_565);
        } else if (d11 == 2) {
            w11.v(true).z(ImageScaleType.IN_SAMPLE_POWER_OF_2).t(Bitmap.Config.RGB_565);
        } else if (d11 == 3) {
            w11.v(true).z(ImageScaleType.IN_SAMPLE_INT).t(Bitmap.Config.ARGB_8888);
        }
        DisplayImageOptions u11 = w11.u();
        this.f42181a.put(i12, u11);
        return u11;
    }
}
