package com.huochat.community.listener;

import android.app.Activity;
import rx.subjects.BehaviorSubject;
import u6.g;

public interface ICommunityShareUI extends g {
    /* synthetic */ void dismissProgressDialog();

    Activity getActivity();

    /* synthetic */ BehaviorSubject<Integer> getUIChangeSubject();

    /* synthetic */ boolean isAlive();

    /* synthetic */ boolean isCanBeSeen();

    void shareCommunity();

    /* synthetic */ void showOldProgressDialog(String str);

    /* synthetic */ void showProgressDialog();

    /* synthetic */ void showProgressDialog(String str);

    /* synthetic */ void showProgressDialog(String str, boolean z11);

    /* synthetic */ void showProgressDialog(boolean z11);
}
