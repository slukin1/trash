package zendesk.support;

import com.zendesk.service.ZendeskCallback;
import java.io.File;

class ZendeskUploadProvider implements UploadProvider {
    private final ZendeskUploadService uploadService;

    public ZendeskUploadProvider(ZendeskUploadService zendeskUploadService) {
        this.uploadService = zendeskUploadService;
    }

    public void deleteAttachment(String str, ZendeskCallback<Void> zendeskCallback) {
        this.uploadService.deleteAttachment(str, zendeskCallback);
    }

    public void uploadAttachment(String str, File file, String str2, final ZendeskCallback<UploadResponse> zendeskCallback) {
        this.uploadService.uploadAttachment(str, file, str2, new ZendeskCallbackSuccess<UploadResponseWrapper>(zendeskCallback) {
            public void onSuccess(UploadResponseWrapper uploadResponseWrapper) {
                ZendeskCallback zendeskCallback = zendeskCallback;
                if (zendeskCallback != null) {
                    zendeskCallback.onSuccess(uploadResponseWrapper.getUpload());
                }
            }
        });
    }
}
