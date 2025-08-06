package com.jumio.defaultui.view;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import com.jumio.commons.utils.DeviceRotationManager;
import com.jumio.defaultui.view.LoadingView;
import jumio.dui.f;

public interface JumioFragmentCallback {
    void announceAccessibilityFragmentTitle();

    void countrySelected();

    f<ActivityResult> getLastActivityResult();

    ActivityResultLauncher<Intent> getLauncher();

    DeviceRotationManager getRotationManager();

    void hideLoading();

    void retakeImage();

    void setActionBarQuitIcon(int i11);

    void setBackgroundColor(int i11);

    void setOrientation(Integer num);

    void setUiAutomationString(String str);

    void skipAddonPart();

    void startCountrySelection();

    void startUserJourney();

    void updateLoadingState(LoadingView.State state);

    boolean validatePermissions();
}
