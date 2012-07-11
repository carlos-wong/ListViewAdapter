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
	private SimpleAdapter adapter;// ��������������
	private ListView listView; // �����б���ͼ����
	private List<Map<String, Object>> list;// �����б�����
	public static MainActivity ma;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ma = this;
		// ʵ�����б�����
		list = new ArrayList<Map<String, Object>>();
		listView = new ListView(this);// ʵ�����б���ͼ
		// ʵ��һ���б���������
		Map<String, Object> map = new HashMap<String, Object>();
		// ���б��������������
		map.put("item1_imageivew", R.drawable.icon);
		map.put("item1_bigtv", "BIGTV");
		map.put("item1_smalltv", "SMALLTV");
		// ���б�������ӵ��б�������
		list.add(map);
		// --ʹ��ϵͳ���������޷�ʵ�����������
		//ʵ�������� 
		//ʹ��Android �ṩ��SimpleAdapter������
		adapter = new SimpleAdapter(this, list, R.layout.main, 
				new String[] {"item1_imageivew", "item1_bigtv", "item1_smalltv" },
				new int[] {R.id.iv, R.id.bigtv, R.id.smalltv });
		
		// --ʹ���Զ��������������������ListView��ÿһ����¼�����
		 MySimpleAdapter adapter = new MySimpleAdapter(this, list,
		 R.layout.main, new String[] {
		 "item1_imageivew", "item1_bigtv", "item1_smalltv" }, new int[] {
		 R.id.iv, R.id.bigtv, R.id.smalltv });
		 
		// Ϊ�б���ͼ������������������ӳ�䵽�б���ͼ�У�
		listView.setAdapter(adapter);
		// //��ʾ�б���ͼ
		this.setContentView(listView);
	}
}