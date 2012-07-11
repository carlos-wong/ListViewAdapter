package com.himi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {
	private SimpleAdapter adapter;// 声明适配器对象
	private ListView listView; // 声明列表视图对象
	private List<Map<String, Object>> list;// 声明列表容器
	public static MainActivity ma;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ma = this;
		// 实例化列表容器
		list = new ArrayList<Map<String, Object>>();
		listView = new ListView(this);// 实例化列表视图
		// 实例一个列表数据容器
		Map<String, Object> map = new HashMap<String, Object>();
		// 往列表容器中添加数据
		map.put("item1_imageivew", R.drawable.icon);
		map.put("item1_bigtv", "BIGTV");
		map.put("item1_smalltv", "SMALLTV");
		// 将列表数据添加到列表容器中
		list.add(map);
		// --使用系统适配器，无法实现组件监听；
		//实例适配器 
		//使用Android 提供的SimpleAdapter适配器
		adapter = new SimpleAdapter(this, list, R.layout.main, 
				new String[] {"item1_imageivew", "item1_bigtv", "item1_smalltv" },
				new int[] {R.id.iv, R.id.bigtv, R.id.smalltv });
		
		// --使用自定义适配器，方便监听其ListView中每一项的事件监听
		 MySimpleAdapter adapter = new MySimpleAdapter(this, list,
		 R.layout.main, new String[] {
		 "item1_imageivew", "item1_bigtv", "item1_smalltv" }, new int[] {
		 R.id.iv, R.id.bigtv, R.id.smalltv });
		 
		// 为列表视图设置适配器（将数据映射到列表视图中）
		listView.setAdapter(adapter);
		// //显示列表视图
		this.setContentView(listView);
	}
}