package com.rams.backend.payload.request;

public class GheRequest {
    private String maGhe;
    private String maTrangThaiGhe;

    public GheRequest(String maGhe, String maTrangThaiGhe) {
        this.maGhe = maGhe;
        this.maTrangThaiGhe = maTrangThaiGhe;
    }

    public String getMaGhe() {
        return maGhe;
    }

    public void setMaGhe(String maGhe) {
        this.maGhe = maGhe;
    }

    public String getMaTrangThaiGhe() {
        return maTrangThaiGhe;
    }

    public void setMaTrangThaiGhe(String maTrangThaiGhe) {
        this.maTrangThaiGhe = maTrangThaiGhe;
    }
}
