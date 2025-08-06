package com.luck.picture.lib.basic;

public interface IPictureSelectorEvent {
    void loadAllAlbumData();

    void loadFirstPageMediaData(long j11);

    void loadMoreMediaData();

    void loadOnlyInAppDirectoryAllMediaData();
}
