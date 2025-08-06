package com.hbg.module.content.helper.live;

import android.os.Bundle;
import com.tencent.live2.V2TXLivePlayer;

public interface g {

    public static final class a {
        public static /* synthetic */ void a(g gVar, int i11, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 1) != 0) {
                    i11 = 0;
                }
                gVar.J3(i11);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onPraiseNumChange");
        }
    }

    void B7(V2TXLivePlayer v2TXLivePlayer, Bundle bundle);

    void Bb(V2TXLivePlayer v2TXLivePlayer, boolean z11, Bundle bundle);

    void J3(int i11);

    void O9();

    void S7();

    void Ta(V2TXLivePlayer v2TXLivePlayer, boolean z11, Bundle bundle);

    void V6(int i11, int i12);

    void X8(V2TXLivePlayer v2TXLivePlayer, int i11, String str, Bundle bundle);

    void bb();

    void da();

    void f4();

    void ic(V2TXLivePlayer v2TXLivePlayer, int i11, String str, Bundle bundle);

    void onPlayEnd();
}
