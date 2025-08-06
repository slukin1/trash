package com.sumsub.sns.presentation.utils;

import androidx.fragment.app.Fragment;
import com.sumsub.sns.core.widget.autocompletePhone.bottomsheet.SNSCountryPickerDialog;
import com.sumsub.sns.core.widget.autocompletePhone.bottomsheet.SNSPickerDialog;
import com.sumsub.sns.internal.core.analytics.Screen;
import com.sumsub.sns.presentation.screen.questionnary.SNSQuestionnaireFragment;
import com.sumsub.sns.prooface.presentation.SNSLiveness3dFaceFragment;

public final class a {
    public static final Screen a(Fragment fragment) {
        if (fragment instanceof com.sumsub.sns.presentation.screen.intro.a) {
            return Screen.InstructionsScreen;
        }
        if (fragment instanceof com.sumsub.sns.presentation.screen.verification.a) {
            return Screen.StatusScreen;
        }
        if (fragment instanceof com.sumsub.sns.presentation.dialogs.bottomsheet.a) {
            return Screen.AgreementScreen;
        }
        if (fragment instanceof SNSCountryPickerDialog) {
            return Screen.CountriesScreen;
        }
        if (fragment instanceof com.sumsub.sns.presentation.screen.preview.photo.identity.a) {
            return Screen.PreviewScreen;
        }
        if (fragment instanceof com.sumsub.sns.presentation.screen.preview.photo.mrtd.a) {
            return Screen.MrtdScreen;
        }
        if (fragment instanceof com.sumsub.sns.presentation.screen.preview.selfie.a) {
            return Screen.PreviewScreen;
        }
        if (fragment instanceof com.sumsub.sns.presentation.screen.preview.applicantdata.a) {
            return Screen.ApplicantDataScreen;
        }
        if (fragment instanceof com.sumsub.sns.presentation.screen.preview.photo.common.a) {
            return Screen.PreviewScreen;
        }
        if (fragment instanceof SNSLiveness3dFaceFragment) {
            return Screen.LivenessScreen;
        }
        if (fragment instanceof com.sumsub.sns.core.presentation.screen.verification.a) {
            return Screen.ConfirmationContactScreen;
        }
        if (fragment instanceof SNSQuestionnaireFragment) {
            return Screen.QuestionnaireScreen;
        }
        if (fragment instanceof com.sumsub.sns.core.presentation.support.a) {
            return Screen.SupportScreen;
        }
        if (fragment instanceof SNSPickerDialog) {
            return Screen.SystemImagePicker;
        }
        if (fragment instanceof com.sumsub.sns.camera.photo.presentation.a) {
            return Screen.DocTypeSelectorScreen;
        }
        if (fragment instanceof com.sumsub.sns.camera.photo.presentation.selfie.a) {
            return Screen.CameraScreen;
        }
        if (fragment instanceof com.sumsub.sns.camera.photo.presentation.document.a) {
            return Screen.CameraScreen;
        }
        if (fragment instanceof com.sumsub.sns.camera.video.presentation.a) {
            return Screen.VideoScreen;
        }
        if (fragment instanceof com.sumsub.sns.presentation.consent.a) {
            return Screen.AgreementSelectorScreen;
        }
        return Screen.Other;
    }
}
