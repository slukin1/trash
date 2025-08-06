package com.fluttercandies.photo_manager.core.utils;

import android.database.Cursor;
import com.fluttercandies.photo_manager.core.entity.b;
import d10.l;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class AndroidQDBUtils$getAssetFromGalleryIdRange$1$1 extends Lambda implements l<Cursor, Unit> {
    public final /* synthetic */ Cursor $cursor;
    public final /* synthetic */ ArrayList<b> $list;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidQDBUtils$getAssetFromGalleryIdRange$1$1(ArrayList<b> arrayList, Cursor cursor) {
        super(1);
        this.$list = arrayList;
        this.$cursor = cursor;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Cursor) obj);
        return Unit.f56620a;
    }

    public final void invoke(Cursor cursor) {
        this.$list.add(AndroidQDBUtils.f65102b.C(this.$cursor));
    }
}
