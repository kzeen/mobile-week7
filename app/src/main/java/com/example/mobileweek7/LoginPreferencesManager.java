package com.example.mobileweek7;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;

public class LoginPreferencesManager {
    private static final String PREF_NAME = "LoginSharedPrefs";
    private static final String KEY_IS_LOGGED_IN = "isLoggedIn";
    private static final String KEY_Email = "email";
    private static SharedPreferences sharedPreferences = null;

    // Singleton design pattern
    public static SharedPreferences getInstance(Context context) {
        // Check if first time creating object
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        }
        // If not, return old existing one
        return sharedPreferences;
    }

    public static boolean isLoggedIn(Context context) {
        return getInstance(context).getBoolean(KEY_IS_LOGGED_IN, false);
    }

    public static void registerLogin(Context context, String email) {
        SharedPreferences.Editor editor = getInstance(context).edit();
        editor.putBoolean(KEY_IS_LOGGED_IN, true);
        editor.putString(KEY_Email, email);
        editor.commit();
    }

    public static void registerLogout(Context context) {
        SharedPreferences.Editor editor = getInstance(context).edit();
        editor.putBoolean(KEY_IS_LOGGED_IN, false);
        editor.commit();
    }

    public static String getEmail(Context context) {
        return getInstance(context).getString(KEY_Email, "def");
    }
}
