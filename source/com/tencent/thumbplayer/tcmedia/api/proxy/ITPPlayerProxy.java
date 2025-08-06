package com.tencent.thumbplayer.tcmedia.api.proxy;

public interface ITPPlayerProxy {
    void pushEvent(int i11);

    void setIsActive(boolean z11);

    void setProxyServiceType(int i11);

    void setTPPlayerProxyListener(ITPPlayerProxyListener iTPPlayerProxyListener);
}
