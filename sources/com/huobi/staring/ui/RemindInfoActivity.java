package com.huobi.staring.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.gson.Gson;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import com.huobi.search.ui.SearchFlutterActivity;
import com.huobi.share.bean.PreviewItem;
import i6.d;
import i6.k;
import i6.m;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.List;
import sl.f0;

@Route(path = "/home/remindInfo")
public class RemindInfoActivity extends AbsGlobalFlutterActivity {

    /* renamed from: k  reason: collision with root package name */
    public Gson f81243k;

    /* renamed from: l  reason: collision with root package name */
    public MethodChannel f81244l;

    public class a implements f0.b {
        public a() {
        }

        public void e(List<SymbolPrice> list) {
        }

        public void onSuccess(List<SymbolPrice> list) {
            if (list != null) {
                try {
                    HashMap hashMap = new HashMap();
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        SymbolPrice symbolPrice = list.get(i11);
                        String str = "--";
                        if (!(symbolPrice.getClose() == null || Double.compare(symbolPrice.getClose().doubleValue(), 0.0d) == 0)) {
                            String i12 = m.i(((symbolPrice.getClose().doubleValue() - symbolPrice.getOpen().doubleValue()) / symbolPrice.getOpen().doubleValue()) * 100.0d, PrecisionUtil.v(symbolPrice.getSymbol()));
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(Double.compare(Double.parseDouble(i12), 0.0d) > 0 ? "+" : "");
                            sb2.append(i12);
                            sb2.append("%");
                            str = sb2.toString();
                        }
                        hashMap.put(symbolPrice.getSymbol(), str);
                    }
                    RemindInfoActivity.this.f81244l.invokeMethod("tradeInfoRealTime", RemindInfoActivity.this.f81243k.toJson((Object) hashMap));
                } catch (Exception unused) {
                    d.d("methodChannel tradeInfoRealTime");
                }
            }
        }
    }

    public String Nh() {
        return "remind_info_page";
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "remind_info_channel");
        this.f81244l = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        f0.g().i();
        this.f81243k = new Gson();
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            k.o("onMethodCall", str);
            char c11 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1679270936) {
                if (hashCode != -710649382) {
                    if (hashCode == 1321996464) {
                        if (str.equals("goSearch")) {
                            c11 = 1;
                        }
                    }
                } else if (str.equals("remindShare")) {
                    c11 = 0;
                }
            } else if (str.equals("getCurIndex")) {
                c11 = 2;
            }
            if (c11 == 0) {
                String str2 = (String) methodCall.argument("title");
                String str3 = (String) methodCall.argument("content");
                long longValue = ((Long) methodCall.argument("timeStamp")).longValue();
                int intValue = ((Integer) methodCall.argument("id")).intValue();
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    PreviewItem previewItem = new PreviewItem();
                    previewItem.setTitle(str2);
                    previewItem.setContent(str3);
                    previewItem.setIssueTime(longValue);
                    previewItem.setId((long) intValue);
                    yl.a.i(this, previewItem);
                }
                result.success((Object) null);
            } else if (c11 == 1) {
                SearchFlutterActivity.Fi(this);
                result.success((Object) null);
            } else if (c11 != 2) {
                result.notImplemented();
            } else {
                Intent intent = getIntent();
                if (intent != null) {
                    result.success(Integer.valueOf(intent.getIntExtra("getCurIndex", 0)));
                } else {
                    result.success(0);
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            result.notImplemented();
        }
    }

    public void onPause() {
        super.onPause();
        f0.g().j("REMIND_INFO_OVERVIEW");
    }

    public void onResume() {
        super.onResume();
        f0.g().e("REMIND_INFO_OVERVIEW", new a());
        f0.g().k("REMIND_INFO_OVERVIEW");
    }
}
