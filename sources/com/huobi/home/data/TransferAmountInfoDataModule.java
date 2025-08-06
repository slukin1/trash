package com.huobi.home.data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.huobi.index.helper.data.HomePageModule;
import kotlin.jvm.internal.r;

public final class TransferAmountInfoDataModule extends HomePageModule<TransferAmountInfo> {

    /* renamed from: c  reason: collision with root package name */
    public static final a f72471c = new a((r) null);

    /* renamed from: d  reason: collision with root package name */
    public static String f72472d = "{\"isTransfer\":1,\"title\":null,\"desc\":null}";

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public static final class b extends TypeToken<TransferAmountInfo> {
    }

    public static final class c extends TypeToken<TransferAmountInfo> {
    }

    public static final class d extends TypeToken<TransferAmountInfo> {
    }

    public String e() {
        return "SP_TAG_HOME_PAGE_USER_DATA_230417";
    }

    /* renamed from: k */
    public String b(TransferAmountInfo transferAmountInfo) {
        return new Gson().toJson((Object) transferAmountInfo, new b().getType());
    }

    /* renamed from: l */
    public TransferAmountInfo c(String str) {
        return (TransferAmountInfo) new Gson().fromJson(str, new c().getType());
    }

    public final void m() {
        j(new Gson().fromJson(f72472d, new d().getType()));
    }

    /* renamed from: n */
    public TransferAmountInfo i(TransferAmountInfo transferAmountInfo) {
        return transferAmountInfo;
    }
}
