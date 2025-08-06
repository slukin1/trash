package cn.sharesdk.loopshare;

import com.mob.tools.proguard.EverythingKeeper;

public interface SceneRestorable extends EverythingKeeper {
    void onReturnSceneData(Scene scene);
}
