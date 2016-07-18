package com.zhilinghui.weibo.utils;

import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;


public class AccessTokenKeeper {
	private static final String PREFERENCES = "sina";
	private static final String KEY_UID = "uid";
	private static final String KEY_ACCESS_TOKEN = "access_token";
	private static final String KEY_EXPIRES_IN = "expires_in";

	public static void writeAccessToken(Context context, Oauth2AccessToken token) {
		if (context == null || token == null) {
			return;
		}
		SharedPreferences preferences = context.getSharedPreferences(
				PREFERENCES, context.MODE_APPEND);
		Editor editor = preferences.edit();
		editor.putString(KEY_UID, token.getUid());
		editor.putString(KEY_ACCESS_TOKEN, token.getToken());
		editor.putLong(KEY_EXPIRES_IN, token.getExpiresTime());
		editor.commit();
	}

	public static Oauth2AccessToken readAccessToken(Context context) {
		if (null == context) {
			return null;
		}

		Oauth2AccessToken token = new Oauth2AccessToken();
		SharedPreferences pref = context.getSharedPreferences(PREFERENCES,
				Context.MODE_APPEND);
		token.setUid(pref.getString(KEY_UID, ""));
		token.setToken(pref.getString(KEY_ACCESS_TOKEN, ""));
		token.setExpiresTime(pref.getLong(KEY_EXPIRES_IN, 0));
		return token;
	}

	public static void clear(Context context) {
		if (null == context) {
			return;
		}

		SharedPreferences pref = context.getSharedPreferences(PREFERENCES,
				Context.MODE_APPEND);
		Editor editor = pref.edit();
		editor.clear();
		editor.commit();
	}

}
