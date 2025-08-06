package com.tencent.ugc.videobase.frame;

import com.tencent.ugc.videobase.frame.RefCounted;

public interface IRecycler<T extends RefCounted> {
    void recycle(T t11);
}
