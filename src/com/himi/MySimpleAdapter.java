/**
 * 
 */
package com.himi;

import java.util.List;
import java.util.Map;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.CompoundButton.OnCheckedChangeListener;

/**
 * @author Himi
 * 
 */
public class MySimpleAdapter extends BaseAdapter {
	private LayoutInflater mInflater;
	private List<Map<String, Object>> list;
	private int layoutID;
	private String flag[];
	private int ItemIDs[];
	public MySimpleAdapter(Context context, List<Map<String, Object>> list,
			int layoutID, String flag[], int ItemIDs[]) {
		this.mInflater = LayoutInflater.from(context);
		this.list = list;
		this.layoutID = layoutID;
		this.flag = flag;
		this.ItemIDs = ItemIDs;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		convertView = mInflater.inflate(layoutID, null);
		convertView = mInflater.inflate(layoutID, null);
		for (int i = 0; i < flag.length; i++) {//备注1
			if (convertView.findViewById(ItemIDs[i]) instanceof ImageView) {
				ImageView iv = (ImageView) convertView.findViewById(ItemIDs[i]);
				iv.setBackgroundResource((Integer) list.get(position).get(
						flag[i]));
			} else if (convertView.findViewById(ItemIDs[i]) instanceof TextView) {
				TextView tv = (TextView) convertView.findViewById(ItemIDs[i]);
				tv.setText((String) list.get(position).get(flag[i]));
			}else{
				//...备注2
			}
		}
		addListener(convertView);
		return convertView;
	}
/**
 * 
 * 备注3
 */
	public void addListener(View convertView) {
		((Button)convertView.findViewById(R.id.btn)).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						new AlertDialog.Builder(MainActivity.ma)
						.setTitle("自定义通用SimpleAdapter")
						.setMessage("按钮成功触发监听事件！")
						.show();
					}
				});
		((ImageView)convertView.findViewById(R.id.iv)).setOnClickListener(
					new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						new AlertDialog.Builder(MainActivity.ma)
								.setTitle("自定义通用SimpleAdapter")
								.setMessage("imageview成功触发监听事件！").show();
					}
					}
				);
		
		((CheckBox)convertView.findViewById(R.id.cb)).
		setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				new AlertDialog.Builder(MainActivity.ma)
				.setTitle("自定义通用SimpleAdapter")
				.setMessage("CheckBox成功触发状态改变监听事件！")
				.show();
			}
		});
	}
}