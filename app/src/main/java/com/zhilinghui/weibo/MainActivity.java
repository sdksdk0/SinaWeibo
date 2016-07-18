package com.zhilinghui.weibo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.zhilinghui.weibo.ui.LoginActivity;
import com.zhilinghui.weibo.ui.SendWeibo;

public class MainActivity extends Activity {

    private static final String TAG = MainActivity.class.getSimpleName();


    private static final DemoInfo[] demos = {
            new DemoInfo("登录微博","first",LoginActivity.class),
            new DemoInfo("发送微博","second",SendWeibo.class),
//			new DemoInfo("获取微博","third",GetWeibo.class)


    };


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        TextView text = (TextView) findViewById(R.id.text_Info);
        text.setTextColor(Color.RED);
        text.setText("新浪微博实例");
        ListView mListView = (ListView) findViewById(R.id.listView);
        // 添加ListItem，设置事件响应
        mListView.setAdapter(new DemoListAdapter());
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View v, int index,
                                    long arg3) {
                onListItemClick(index);
            }
        });
    }


    public void onListItemClick(int index) {
        Intent intent = null;
        intent = new Intent(MainActivity.this, demos[index].demoClass);

        Log.d(TAG, "itemClick()");
        this.startActivity(intent);
    }


    /**
     * demo列表适配器
     *
     * @author Jason
     *
     */
    private class DemoListAdapter extends BaseAdapter {
        public DemoListAdapter() {
            super();
        }

        @Override
        public View getView(int index, View convertView, ViewGroup parent) {
            convertView = View.inflate(MainActivity.this,
                    R.layout.demo_info_item, null);

            TextView title = (TextView) convertView.findViewById(R.id.title);
            TextView desc = (TextView) convertView.findViewById(R.id.desc);
            title.setText(demos[index].title);
            desc.setText(demos[index].desc);
            if (index >= 16) {
                title.setTextColor(Color.YELLOW);
            }
            return convertView;
        }

        @Override
        public int getCount() {
            return demos.length;
        }

        @Override
        public Object getItem(int index) {
            return demos[index];
        }

        @Override
        public long getItemId(int id) {
            return id;
        }
    }


    /**
     * item的信息
     *
     * @author jason
     *
     */
    private static class DemoInfo {
        private final String title;
        private final String desc;
        private final Class<? extends android.app.Activity> demoClass;

        public DemoInfo(String title, String desc,
                        Class<? extends android.app.Activity> demoClass) {
            this.title = title;
            this.desc = desc;
            this.demoClass = demoClass;
        }
    }
}
