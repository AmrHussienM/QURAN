package com.example.amr.quran;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {
    @GET("radio/radio_ar.json")

    Call<RadioResponse> getRadioChannels();
}
