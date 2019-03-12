
package com.example.amr.quran;

import java.util.List;
import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class RadioResponse {

    @SerializedName("Radios")
    private List<Radio> mRadios;

    public List<Radio> getRadios() {
        return mRadios;
    }

    public void setRadios(List<Radio> radios) {
        mRadios = radios;
    }

}
