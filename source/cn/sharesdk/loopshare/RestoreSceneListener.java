package cn.sharesdk.loopshare;

import android.app.Activity;
import com.mob.tools.proguard.EverythingKeeper;

public interface RestoreSceneListener extends EverythingKeeper {
    void completeRestore(Scene scene);

    void notFoundScene(Scene scene);

    Class<? extends Activity> willRestoreScene(Scene scene);
}
