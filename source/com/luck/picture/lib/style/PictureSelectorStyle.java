package com.luck.picture.lib.style;

public class PictureSelectorStyle {
    private AlbumWindowStyle albumWindowStyle;
    private BottomNavBarStyle bottomBarStyle;
    private SelectMainStyle selectMainStyle;
    private TitleBarStyle titleBarStyle;
    private PictureWindowAnimationStyle windowAnimationStyle;

    public AlbumWindowStyle getAlbumWindowStyle() {
        AlbumWindowStyle albumWindowStyle2 = this.albumWindowStyle;
        return albumWindowStyle2 == null ? new AlbumWindowStyle() : albumWindowStyle2;
    }

    public BottomNavBarStyle getBottomBarStyle() {
        BottomNavBarStyle bottomNavBarStyle = this.bottomBarStyle;
        return bottomNavBarStyle == null ? new BottomNavBarStyle() : bottomNavBarStyle;
    }

    public SelectMainStyle getSelectMainStyle() {
        SelectMainStyle selectMainStyle2 = this.selectMainStyle;
        return selectMainStyle2 == null ? new SelectMainStyle() : selectMainStyle2;
    }

    public TitleBarStyle getTitleBarStyle() {
        TitleBarStyle titleBarStyle2 = this.titleBarStyle;
        return titleBarStyle2 == null ? new TitleBarStyle() : titleBarStyle2;
    }

    public PictureWindowAnimationStyle getWindowAnimationStyle() {
        if (this.windowAnimationStyle == null) {
            this.windowAnimationStyle = PictureWindowAnimationStyle.ofDefaultWindowAnimationStyle();
        }
        return this.windowAnimationStyle;
    }

    public void setAlbumWindowStyle(AlbumWindowStyle albumWindowStyle2) {
        this.albumWindowStyle = albumWindowStyle2;
    }

    public void setBottomBarStyle(BottomNavBarStyle bottomNavBarStyle) {
        this.bottomBarStyle = bottomNavBarStyle;
    }

    public void setSelectMainStyle(SelectMainStyle selectMainStyle2) {
        this.selectMainStyle = selectMainStyle2;
    }

    public void setTitleBarStyle(TitleBarStyle titleBarStyle2) {
        this.titleBarStyle = titleBarStyle2;
    }

    public void setWindowAnimationStyle(PictureWindowAnimationStyle pictureWindowAnimationStyle) {
        this.windowAnimationStyle = pictureWindowAnimationStyle;
    }
}
