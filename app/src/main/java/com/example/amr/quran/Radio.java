
package com.example.amr.quran;

import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Radio {

    @SerializedName("Name")
    private String mName;
    @SerializedName("URL")
    private String mURL;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getURL() {
        return mURL;
    }

    public void setURL(String uRL) {
        mURL = uRL;
    }

}
