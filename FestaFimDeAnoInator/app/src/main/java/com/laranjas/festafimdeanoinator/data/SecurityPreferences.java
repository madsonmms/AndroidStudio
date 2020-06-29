package com.laranjas.festafimdeanoinator.data;

import android.content.Context;
import android.content.SharedPreferences;

public class SecurityPreferences {

    private SharedPreferences mSharedPreferences;

    public SecurityPreferences(Context mContext) {
        this.mSharedPreferences = mContext.getSharedPreferences("FimDeAno", Context.MODE_PRIVATE);
    }

    public void storageString(String key, String value) {
        this.mSharedPreferences.edit().putString(key, value).apply();
    }

    public String getStorageString(String key) {
        return this.mSharedPreferences.getString(key, "");
    }

    public void resetString() {
        this.mSharedPreferences.edit().putString("", "").apply();
    }
}
