package zendesk.support;

import com.zendesk.service.ZendeskCallback;
import java.io.File;
import lz.c;
import okhttp3.MediaType;
import okhttp3.RequestBody;

class ZendeskUploadService {
    private static final String LOG_TAG = "ZendeskUploadService";
    private final UploadService uploadService;

    public ZendeskUploadService(UploadService uploadService2) {
        this.uploadService = uploadService2;
    }

    public void deleteAttachment(String str, ZendeskCallback<Void> zendeskCallback) {
        this.uploadService.deleteAttachment(str).enqueue(new c(zendeskCallback));
    }

    public void uploadAttachment(String str, File file, String str2, ZendeskCallback<UploadResponseWrapper> zendeskCallback) {
        this.uploadService.uploadAttachment(str, RequestBody.create(MediaType.parse(str2), file)).enqueue(new c(zendeskCallback));
    }
}
