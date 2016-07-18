package com.zhilinghui.weibo.ui;


import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.auth.sso.SsoHandler;
import com.sina.weibo.sdk.exception.WeiboException;
import com.zhilinghui.weibo.R;
import com.zhilinghui.weibo.utils.AccessTokenKeeper;
import com.zhilinghui.weibo.utils.Constants;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class LoginActivity extends Activity {

	AuthInfo mauthInfo;

	SsoHandler ssoHandler;

	Oauth2AccessToken accessToken;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_login);

		initDatas();
	}

	/**
	 * 数据初始化
	 */
	private void initDatas() {
		// 上下文
		mauthInfo = new AuthInfo(LoginActivity.this, Constants.APP_KEY, Constants.REDIRECT_URL,
				Constants.SCOPE);
		ssoHandler = new SsoHandler(LoginActivity.this, mauthInfo);

		ssoHandler.authorize(new WeiboAuthListener() {

			//认证失败
			@Override
			public void onWeiboException(WeiboException arg0) {

				Toast.makeText(LoginActivity.this, "认证失败"+arg0, Toast.LENGTH_SHORT).show();
			}

			//认证成功的
			@Override
			public void onComplete(Bundle arg0) {

				accessToken = Oauth2AccessToken.parseAccessToken(arg0);

				//验证我们的令牌是否有效
				if(accessToken.isSessionValid()){
					AccessTokenKeeper.writeAccessToken(LoginActivity.this, accessToken);
					Toast.makeText(LoginActivity.this, "认证成功", Toast.LENGTH_SHORT).show();
				}


			}

			//取消认证的
			@Override
			public void onCancel() {
				// TODO Auto-generated method stub
				Toast.makeText(LoginActivity.this, "取消认证", Toast.LENGTH_SHORT).show();

			}
		});

	}

}
