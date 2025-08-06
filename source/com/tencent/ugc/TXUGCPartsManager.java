package com.tencent.ugc;

import java.util.List;

public interface TXUGCPartsManager {
    void addClipInfo(PartInfo partInfo);

    void deleteAllParts();

    void deleteLastPart();

    void deletePart(int i11);

    int getDuration();

    List<String> getPartsPathList();

    void insertPart(String str, int i11);
}
