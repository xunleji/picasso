package com.example.picassodemo;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static android.widget.ImageView.ScaleType.CENTER_CROP;

final class SampleGridViewAdapter extends BaseAdapter {
	private final Context context;
	private final List<String> urls = new ArrayList<String>();

	public SampleGridViewAdapter(Context context) {
		this.context = context;

		// Ensure we get a different ordering of images on each run.
		Collections.addAll(urls, Data.URLS);
		Collections.shuffle(urls);

		// Triple up the list.
		ArrayList<String> copy = new ArrayList<String>(urls);
		urls.addAll(copy);
		urls.addAll(copy);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		SquaredImageView view = (SquaredImageView) convertView;
		if (view == null) {
			view = new SquaredImageView(context);
			view.setScaleType(CENTER_CROP);
		}

		// Get the image URL for the current position.
		String url = getItem(position);
		Log.e("getView", "url=="+url+"position="+position);

		// Trigger the download of the URL asynchronously into the image view.
		Picasso.with(context) //
				.load(url) //
				.placeholder(R.drawable.placeholder) //
				.error(R.drawable.error) //
				.fit() //
				.into(view);
		//支持本地图片下载
//		Picasso.with(context).load(R.drawable.ic_launcher).into(view);
//		Picasso.with(context).load(new File("/images/oprah_bees.gif")).into(view);

		return view;
	}

	@Override
	public int getCount() {
		return urls.size();
	}

	@Override
	public String getItem(int position) {
		return urls.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}
}
