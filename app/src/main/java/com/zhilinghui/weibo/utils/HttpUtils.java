package com.zhilinghui.weibo.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtils {

	/**
	 * 通过url地址返回一个输入流
	 *
	 * @param url
	 *            地址
	 * @return 输入流
	 */
	public static InputStream getInputStream(String url) {
		URL home_url = null;

		InputStream input = null;

		HttpURLConnection conn = null;

		try {
			home_url = new URL(url);

			conn = (HttpURLConnection) home_url.openConnection();

			conn.setRequestMethod("GET");

			conn.setConnectTimeout(5000);

			conn.connect();

			input = conn.getInputStream();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return input;

	}


	/**
	 * 返回字符串
	 *
	 * @param url
	 * @return
	 */
	public static String getStringByStream(String url) {

		StringBuilder sb = null;
		BufferedReader br = null;

		InputStream input = getInputStream(url);


		if (input != null) {
			br = new BufferedReader(new InputStreamReader(input));

			String line = null;
			sb = new StringBuilder();
			try {
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}else{
			sb = new StringBuilder("");
		}

		return sb.toString();

	}

}
