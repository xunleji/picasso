package com.example.picassodemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class SampleGridViewActivity extends PicassoSampleActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sample_gridview_activity);

		GridView gv = (GridView) findViewById(R.id.grid_view);
		gv.setAdapter(new SampleGridViewAdapter(this));
		gv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Log.e("SampleGridViewActivity", "onItemClick="+arg2);
			}
		});
	}
}
