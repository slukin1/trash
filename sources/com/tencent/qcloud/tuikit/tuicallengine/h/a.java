package com.tencent.qcloud.tuikit.tuicallengine.h;

import android.content.ContentValues;

public class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ContentValues f48453a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f48454b;

    public a(d dVar, ContentValues contentValues) {
        this.f48454b = dVar;
        this.f48453a = contentValues;
    }

    public void run() {
        try {
            this.f48454b.getReadableDatabase().replace("callrecord", (String) null, this.f48453a);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }
}
