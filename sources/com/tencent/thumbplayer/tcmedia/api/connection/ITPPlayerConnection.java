package com.tencent.thumbplayer.tcmedia.api.connection;

public interface ITPPlayerConnection {
    int activeAllConnections();

    int activeConnection(int i11);

    int addConnection(long j11, TPPlayerConnectionNode tPPlayerConnectionNode, long j12, TPPlayerConnectionNode tPPlayerConnectionNode2);

    void deactiveAllConnections();

    void deactiveConnection(int i11);

    void init();

    void removeConnection(int i11);

    void uninit();
}
