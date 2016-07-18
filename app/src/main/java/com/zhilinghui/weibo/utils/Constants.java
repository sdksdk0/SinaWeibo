package com.zhilinghui.weibo.utils;

/**
 * 常量类
 *
 *
 */
public class Constants {
public static final String APP_KEY = "换成你的appkey";
	public static final String App_SECRET = "换成你的app_secret";


	/**
	 * 当前 DEMO 应用的回调页，第三方应用可以使用自己的回调页。
	 * 建议使用默认回调页：https://api.weibo.com/oauth2/default.html
	 */
	public static final String REDIRECT_URL = "http://www.tianfang1314.cn/";

	/**
	 * WeiboSDKDemo 应用对应的权限，第三方开发者一般不需要这么多，可直接设置成空即可。 详情请查看 Demo 中对应的注释。
	 */
	public static final String SCOPE = "email,direct_messages_read,direct_messages_write,"
			+ "friendships_groups_read,friendships_groups_write,statuses_to_me_read,"
			+ "follow_app_official_microblog," + "invitation_write";
	public static final String user_show = "https://api.weibo.com/2/users/show.json?uid={0}&access_token={1}";
	public static final String public_timeline = "https://api.weibo.com/2/statuses/public_timeline.json?access_token={0}";
	public static final String friends_timeline = "https://api.weibo.com/2/statuses/friends_timeline.json?access_token={0}";
	public static final String home_timeline = "https://api.weibo.com/2/statuses/home_timeline.json?count=20&access_token={0}";
	public static final String bilateral_timeline = "https://api.weibo.com/2/statuses/bilateral_timeline.json?count=20&access_token={0}";
	public static final String repost = "https://api.weibo.com/2/statuses/repost.json";
	public static final String updata = "https://api.weibo.com/2/statuses/update.json";
	public static final String comment_show = "https://api.weibo.com/2/comments/show.json?access_token={0}";
	public static final String comment_create = "https://api.weibo.com/2/comments/create.json";
	public static final String friendships_destroy = "https://api.weibo.com/2/friendships/destroy.json";
	public static final String friendships_create = "https://api.weibo.com/2/friendships/create.json";
	public static final String followers = "https://api.weibo.com/2/friendships/followers.json";
	public static final String user_timeline = "https://api.weibo.com/2/statuses/user_timeline.json";
	public static final String delete = "https://api.weibo.com/2/statuses/destroy.json";
	public static final String friendship_friends = "https://api.weibo.com/2/friendships/friends.json";
	public static final String replay = "https://api.weibo.com/2/comments/reply.json";
	public static final String bilateral_timeline2 = "https://api.weibo.com/2/statuses/bilateral_timeline.json";
	public static final String mentions = "https://api.weibo.com/2/statuses/mentions.json";
	public static final String weekly = "https://api.weibo.com/2/trends/weekly.json";
	public static final String daily = "https://api.weibo.com/2/trends/daily.json";
	public static final String hourly = "https://api.weibo.com/2/trends/hourly.json";
	public static final String users = "https://api.weibo.com/2/search/suggestions/users.json";
	public static final String upload = "https://upload.api.weibo.com/2/statuses/upload.json";
	public static final String comment_mentions = "https://api.weibo.com/2/comments/mentions.json";
}
