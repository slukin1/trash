package com.facebook.appevents.ml;

import android.os.AsyncTask;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsConstants;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class Model {
    private static final String DIR_NAME = "facebook_ml/";
    private static final int EMBEDDING_SIZE = 64;
    private static final int SEQ_LEN = 128;
    public static final String SHOULD_FILTER = "SHOULD_FILTER";
    private static final List<String> SUGGESTED_EVENTS_PREDICTION = Arrays.asList(new String[]{AppEventsConstants.EVENT_NAME_ADDED_TO_CART, AppEventsConstants.EVENT_NAME_COMPLETED_REGISTRATION, "other", AppEventsConstants.EVENT_NAME_PURCHASED});
    private static final Map<String, String> WEIGHTS_KEY_MAPPING = new HashMap<String, String>() {
        {
            put("embedding.weight", "embed.weight");
            put("dense1.weight", "fc1.weight");
            put("dense2.weight", "fc2.weight");
            put("dense3.weight", "fc3.weight");
            put("dense1.bias", "fc1.bias");
            put("dense2.bias", "fc2.bias");
            put("dense3.bias", "fc3.bias");
        }
    };
    private Weight convs_1_bias;
    private Weight convs_1_weight;
    private Weight convs_2_bias;
    private Weight convs_2_weight;
    private Weight convs_3_bias;
    private Weight convs_3_weight;
    private File dir;
    private Weight embedding;
    private Weight fc1_bias;
    private Weight fc1_weight;
    private Weight fc2_bias;
    private Weight fc2_weight;
    private Weight fc3_bias;
    private Weight fc3_weight;
    private File modelFile;
    private String modelUri;
    private File ruleFile;
    private String ruleUri;
    private float[] thresholds;
    private String useCase;
    private int versionID;

    public static class FileDownloadTask extends AsyncTask<String, Void, Boolean> {
        public File destFile;
        public Runnable onSuccess;
        public String uriStr;

        public FileDownloadTask(String str, File file, Runnable runnable) {
            this.uriStr = str;
            this.destFile = file;
            this.onSuccess = runnable;
        }

        public Boolean doInBackground(String... strArr) {
            try {
                URL url = new URL(this.uriStr);
                int contentLength = url.openConnection().getContentLength();
                DataInputStream dataInputStream = new DataInputStream(url.openStream());
                byte[] bArr = new byte[contentLength];
                dataInputStream.readFully(bArr);
                dataInputStream.close();
                DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(this.destFile));
                dataOutputStream.write(bArr);
                dataOutputStream.flush();
                dataOutputStream.close();
                return Boolean.TRUE;
            } catch (Exception unused) {
                return Boolean.FALSE;
            }
        }

        public void onPostExecute(Boolean bool) {
            if (bool.booleanValue()) {
                this.onSuccess.run();
            }
        }
    }

    public static class Weight {
        public float[] data;
        public int[] shape;

        public Weight(int[] iArr, float[] fArr) {
            this.shape = iArr;
            this.data = fArr;
        }
    }

    public Model(String str, int i11, String str2, String str3, float[] fArr) {
        this.useCase = str;
        this.versionID = i11;
        this.thresholds = fArr;
        this.modelUri = str2;
        this.ruleUri = str3;
        File file = new File(FacebookSdk.getApplicationContext().getFilesDir(), DIR_NAME);
        this.dir = file;
        if (!file.exists()) {
            this.dir.mkdirs();
        }
        File file2 = this.dir;
        this.modelFile = new File(file2, str + "_" + i11);
        File file3 = this.dir;
        this.ruleFile = new File(file3, str + "_" + i11 + "_rule");
    }

    private void deleteOldFiles() {
        File[] listFiles = this.dir.listFiles();
        if (listFiles != null && listFiles.length != 0) {
            String str = this.useCase + "_" + this.versionID;
            for (File file : listFiles) {
                String name = file.getName();
                if (name.startsWith(this.useCase) && !name.startsWith(str)) {
                    file.delete();
                }
            }
        }
    }

    private void downloadModel(Runnable runnable) {
        if (this.modelFile.exists()) {
            runnable.run();
        } else if (this.modelUri != null) {
            new FileDownloadTask(this.modelUri, this.modelFile, runnable).execute(new String[0]);
        }
    }

    /* access modifiers changed from: private */
    public void downloadRule(Runnable runnable) {
        if (this.ruleFile.exists() || this.ruleUri == null) {
            runnable.run();
        } else {
            new FileDownloadTask(this.ruleUri, this.ruleFile, runnable).execute(new String[0]);
        }
    }

    /* access modifiers changed from: private */
    public boolean initializeWeights() {
        try {
            FileInputStream fileInputStream = new FileInputStream(this.modelFile);
            int available = fileInputStream.available();
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            byte[] bArr = new byte[available];
            dataInputStream.readFully(bArr);
            dataInputStream.close();
            if (available < 4) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, 4);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            int i11 = wrap.getInt();
            int i12 = i11 + 4;
            if (available < i12) {
                return false;
            }
            JSONObject jSONObject = new JSONObject(new String(bArr, 4, i11));
            JSONArray names = jSONObject.names();
            int length = names.length();
            String[] strArr = new String[length];
            for (int i13 = 0; i13 < length; i13++) {
                strArr[i13] = names.getString(i13);
            }
            Arrays.sort(strArr);
            HashMap hashMap = new HashMap();
            int i14 = 0;
            while (true) {
                int i15 = 1;
                if (i14 < length) {
                    String str = strArr[i14];
                    JSONArray jSONArray = jSONObject.getJSONArray(str);
                    int length2 = jSONArray.length();
                    int[] iArr = new int[length2];
                    for (int i16 = 0; i16 < length2; i16++) {
                        iArr[i16] = jSONArray.getInt(i16);
                        i15 *= iArr[i16];
                    }
                    int i17 = i15 * 4;
                    int i18 = i12 + i17;
                    if (i18 > available) {
                        return false;
                    }
                    ByteBuffer wrap2 = ByteBuffer.wrap(bArr, i12, i17);
                    wrap2.order(ByteOrder.LITTLE_ENDIAN);
                    float[] fArr = new float[i15];
                    wrap2.asFloatBuffer().get(fArr, 0, i15);
                    Map<String, String> map = WEIGHTS_KEY_MAPPING;
                    if (map.containsKey(str)) {
                        str = map.get(str);
                    }
                    hashMap.put(str, new Weight(iArr, fArr));
                    i14++;
                    i12 = i18;
                } else {
                    this.embedding = (Weight) hashMap.get("embed.weight");
                    this.convs_1_weight = (Weight) hashMap.get("convs.0.weight");
                    this.convs_2_weight = (Weight) hashMap.get("convs.1.weight");
                    this.convs_3_weight = (Weight) hashMap.get("convs.2.weight");
                    Weight weight = this.convs_1_weight;
                    float[] fArr2 = weight.data;
                    int[] iArr2 = weight.shape;
                    weight.data = Operator.transpose3D(fArr2, iArr2[0], iArr2[1], iArr2[2]);
                    Weight weight2 = this.convs_2_weight;
                    float[] fArr3 = weight2.data;
                    int[] iArr3 = weight2.shape;
                    weight2.data = Operator.transpose3D(fArr3, iArr3[0], iArr3[1], iArr3[2]);
                    Weight weight3 = this.convs_3_weight;
                    float[] fArr4 = weight3.data;
                    int[] iArr4 = weight3.shape;
                    weight3.data = Operator.transpose3D(fArr4, iArr4[0], iArr4[1], iArr4[2]);
                    this.convs_1_bias = (Weight) hashMap.get("convs.0.bias");
                    this.convs_2_bias = (Weight) hashMap.get("convs.1.bias");
                    this.convs_3_bias = (Weight) hashMap.get("convs.2.bias");
                    this.fc1_weight = (Weight) hashMap.get("fc1.weight");
                    this.fc2_weight = (Weight) hashMap.get("fc2.weight");
                    this.fc3_weight = (Weight) hashMap.get("fc3.weight");
                    Weight weight4 = this.fc1_weight;
                    float[] fArr5 = weight4.data;
                    int[] iArr5 = weight4.shape;
                    weight4.data = Operator.transpose2D(fArr5, iArr5[0], iArr5[1]);
                    Weight weight5 = this.fc2_weight;
                    float[] fArr6 = weight5.data;
                    int[] iArr6 = weight5.shape;
                    weight5.data = Operator.transpose2D(fArr6, iArr6[0], iArr6[1]);
                    Weight weight6 = this.fc3_weight;
                    float[] fArr7 = weight6.data;
                    int[] iArr7 = weight6.shape;
                    weight6.data = Operator.transpose2D(fArr7, iArr7[0], iArr7[1]);
                    this.fc1_bias = (Weight) hashMap.get("fc1.bias");
                    this.fc2_bias = (Weight) hashMap.get("fc2.bias");
                    this.fc3_bias = (Weight) hashMap.get("fc3.bias");
                    return true;
                }
            }
        } catch (Exception unused) {
            return false;
        }
    }

    public File getRuleFile() {
        return this.ruleFile;
    }

    public void initialize(final Runnable runnable) {
        downloadModel(new Runnable() {
            public void run() {
                if (Model.this.initializeWeights()) {
                    Model.this.downloadRule(runnable);
                }
            }
        });
        deleteOldFiles();
    }

    public String predict(float[] fArr, String str) {
        float[] embedding2 = Operator.embedding(Utils.vectorize(str, 128), this.embedding.data, 1, 128, 64);
        Weight weight = this.convs_1_weight;
        float[] fArr2 = weight.data;
        int[] iArr = weight.shape;
        float[] conv1D = Operator.conv1D(embedding2, fArr2, 1, 128, 64, iArr[2], iArr[0]);
        Weight weight2 = this.convs_2_weight;
        float[] fArr3 = weight2.data;
        int[] iArr2 = weight2.shape;
        float[] conv1D2 = Operator.conv1D(embedding2, fArr3, 1, 128, 64, iArr2[2], iArr2[0]);
        Weight weight3 = this.convs_3_weight;
        float[] fArr4 = weight3.data;
        int[] iArr3 = weight3.shape;
        float[] conv1D3 = Operator.conv1D(embedding2, fArr4, 1, 128, 64, iArr3[2], iArr3[0]);
        float[] fArr5 = this.convs_1_bias.data;
        int[] iArr4 = this.convs_1_weight.shape;
        Operator.add(conv1D, fArr5, 1, (128 - iArr4[2]) + 1, iArr4[0]);
        float[] fArr6 = this.convs_2_bias.data;
        int[] iArr5 = this.convs_2_weight.shape;
        Operator.add(conv1D2, fArr6, 1, (128 - iArr5[2]) + 1, iArr5[0]);
        float[] fArr7 = this.convs_3_bias.data;
        int[] iArr6 = this.convs_3_weight.shape;
        Operator.add(conv1D3, fArr7, 1, (128 - iArr6[2]) + 1, iArr6[0]);
        int[] iArr7 = this.convs_1_weight.shape;
        Operator.relu(conv1D, ((128 - iArr7[2]) + 1) * iArr7[0]);
        int[] iArr8 = this.convs_2_weight.shape;
        Operator.relu(conv1D2, ((128 - iArr8[2]) + 1) * iArr8[0]);
        int[] iArr9 = this.convs_3_weight.shape;
        Operator.relu(conv1D3, ((128 - iArr9[2]) + 1) * iArr9[0]);
        int[] iArr10 = this.convs_1_weight.shape;
        float[] maxPool1D = Operator.maxPool1D(conv1D, (128 - iArr10[2]) + 1, iArr10[0], (128 - iArr10[2]) + 1);
        int[] iArr11 = this.convs_2_weight.shape;
        float[] maxPool1D2 = Operator.maxPool1D(conv1D2, (128 - iArr11[2]) + 1, iArr11[0], (128 - iArr11[2]) + 1);
        int[] iArr12 = this.convs_3_weight.shape;
        float[] concatenate = Operator.concatenate(Operator.concatenate(Operator.concatenate(maxPool1D, maxPool1D2), Operator.maxPool1D(conv1D3, (128 - iArr12[2]) + 1, iArr12[0], (128 - iArr12[2]) + 1)), fArr);
        Weight weight4 = this.fc1_weight;
        float[] fArr8 = weight4.data;
        float[] fArr9 = this.fc1_bias.data;
        int[] iArr13 = weight4.shape;
        float[] dense = Operator.dense(concatenate, fArr8, fArr9, 1, iArr13[1], iArr13[0]);
        Operator.relu(dense, this.fc1_bias.shape[0]);
        Weight weight5 = this.fc2_weight;
        float[] fArr10 = weight5.data;
        float[] fArr11 = this.fc2_bias.data;
        int[] iArr14 = weight5.shape;
        float[] dense2 = Operator.dense(dense, fArr10, fArr11, 1, iArr14[1], iArr14[0]);
        Operator.relu(dense2, this.fc2_bias.shape[0]);
        Weight weight6 = this.fc3_weight;
        float[] fArr12 = weight6.data;
        float[] fArr13 = this.fc3_bias.data;
        int[] iArr15 = weight6.shape;
        float[] dense3 = Operator.dense(dense2, fArr12, fArr13, 1, iArr15[1], iArr15[0]);
        Operator.softmax(dense3, this.fc3_bias.shape[0]);
        return processPredictionResult(dense3);
    }

    public String processAddressDetectionResult(float[] fArr) {
        if (fArr[1] >= this.thresholds[0]) {
            return SHOULD_FILTER;
        }
        return null;
    }

    public String processPredictionResult(float[] fArr) {
        if (!(fArr.length == 0 || this.thresholds.length == 0)) {
            if (this.useCase.equals(ModelManager.MODEL_SUGGESTED_EVENTS)) {
                return processSuggestedEventResult(fArr);
            }
            if (this.useCase.equals(ModelManager.MODEL_ADDRESS_DETECTION)) {
                return processAddressDetectionResult(fArr);
            }
        }
        return null;
    }

    public String processSuggestedEventResult(float[] fArr) {
        if (this.thresholds.length != fArr.length) {
            return null;
        }
        int i11 = 0;
        while (true) {
            float[] fArr2 = this.thresholds;
            if (i11 >= fArr2.length) {
                return "other";
            }
            if (fArr[i11] >= fArr2[i11]) {
                return SUGGESTED_EVENTS_PREDICTION.get(i11);
            }
            i11++;
        }
    }
}
