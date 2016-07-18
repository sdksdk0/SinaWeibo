package com.zhilinghui.weibo.ui;


import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.openapi.StatusesAPI;
import com.sina.weibo.sdk.openapi.models.Status;
import com.zhilinghui.weibo.R;
import com.zhilinghui.weibo.utils.AccessTokenKeeper;
import com.zhilinghui.weibo.utils.Constants;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SendWeibo extends Activity {

	//令牌
	Oauth2AccessToken accessToken;

	StatusesAPI statusesApi;

	private EditText et_weibo;

	private Button btn_sendweibo;



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_sendweibo);

		initDatas();

		initViews();


	}

	private void initViews() {

		et_weibo = (EditText)findViewById(R.id.et_weibo);

		btn_sendweibo =(Button)findViewById(R.id.btn_sendweibo);


		btn_sendweibo.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
				String weibo = et_weibo.getText().toString();

				if(!TextUtils.isEmpty(weibo)){

					statusesApi.update(weibo, null, null, new RequestListener() {

						@Override
						public void onWeiboException(WeiboException arg0) {
							Toast.makeText(SendWeibo.this, "发送失败", Toast.LENGTH_SHORT).show();
						}

						@Override
						public void onComplete(String arg0) {

							Toast.makeText(SendWeibo.this, "发送成功", Toast.LENGTH_SHORT).show();
						}
					});

				}

			}
		});

	}

	private void initDatas(){
		accessToken = AccessTokenKeeper.readAccessToken(SendWeibo.this);

		statusesApi = new StatusesAPI(SendWeibo.this, Constants.APP_KEY, accessToken);

	}


}
