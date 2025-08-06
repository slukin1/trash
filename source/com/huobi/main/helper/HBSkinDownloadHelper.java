package com.huobi.main.helper;

import okhttp3.OkHttpClient;

public class HBSkinDownloadHelper {

    /* renamed from: c  reason: collision with root package name */
    public static final String f77703c = ("https://$domain/hbapp-directory/dynamic/skin/release/skinConfig.json?t=" + System.currentTimeMillis());

    /* renamed from: d  reason: collision with root package name */
    public static final String f77704d = ("https://$domain/hbapp-directory/dynamic/skin/debug/skinConfig.json?t=" + System.currentTimeMillis());

    /* renamed from: e  reason: collision with root package name */
    public static final String f77705e = ("https://$domain/hbapp-directory/dynamic/skin/release/$name?t=" + System.currentTimeMillis());

    /* renamed from: f  reason: collision with root package name */
    public static final String f77706f = ("https://$domain/hbapp-directory/dynamic/skin/debug/$name?t=" + System.currentTimeMillis());

    /* renamed from: a  reason: collision with root package name */
    public final OkHttpClient f77707a;

    /* renamed from: b  reason: collision with root package name */
    public final String f77708b;

    public static class Holder {

        /* renamed from: a  reason: collision with root package name */
        public static final HBSkinDownloadHelper f77709a = new HBSkinDownloadHelper((b) null);
    }

    public /* synthetic */ HBSkinDownloadHelper(b bVar) {
        this();
    }

    public HBSkinDownloadHelper() {
        this.f77708b = "HBSkinDownloadHelper";
        this.f77707a = new OkHttpClient();
    }
}
