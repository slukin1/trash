package com.sumsub.sns.presentation.screen.preview.photo;

import android.view.View;
import com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel;

public final /* synthetic */ class m implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f f40023b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SNSPreviewPhotoDocumentViewModel.Content f40024c;

    public /* synthetic */ m(f fVar, SNSPreviewPhotoDocumentViewModel.Content content) {
        this.f40023b = fVar;
        this.f40024c = content;
    }

    public final void onClick(View view) {
        f.a(this.f40023b, this.f40024c, view);
    }
}
