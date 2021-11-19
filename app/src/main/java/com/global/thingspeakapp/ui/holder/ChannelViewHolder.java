package com.global.thingspeakapp.ui.holder;

import android.content.Intent;
import android.text.util.Linkify;
import android.view.View;
import android.widget.TextView;

import com.global.thingspeakapp.R;
import com.global.thingspeakapp.activities.ChannelActivity;
import com.global.thingspeakapp.activities.UserActivity;
import com.global.thingspeakapp.model.Channel;
import com.global.thingspeakapp.model.ListViewable;

/**
 * Updated by Kim-ilguk on 25.3.2021.
 */
public class ChannelViewHolder extends ViewHolder implements View.OnClickListener {

	private Channel mChannel;

	private TextView mTitle;
	private TextView mDescription;
	private TextView mUsername;
	private TextView mTags;

	public ChannelViewHolder(View itemView) {
		super(itemView);
		findViews();
	}

	private void findViews(){
		if(mTitle == null) mTitle = (TextView) root.findViewById(R.id.title);
		if(mDescription == null) mDescription= (TextView) root.findViewById(R.id.description);
		if(mUsername  == null) mUsername = (TextView) root.findViewById(R.id.username);
		if(mTags == null) mTags = (TextView) root.findViewById(R.id.tags);
	}

	@Override
	public void bind(ListViewable data) {
		this.mChannel = (Channel) data;

		mTitle.setText(mChannel.getName());
		mDescription.setText(mChannel.getDescription());
		Linkify.addLinks(mDescription, Linkify.ALL);
		mUsername.setText("By " + mChannel.getUsername());

		String tags = "";
		for(int i = 0; i < mChannel.getTags().size(); i++){
			tags += mChannel.getTags().get(i).getName() + (mChannel.getTags().size() - 1 == i ? "" : ", ");
		}

		mTags.setText(tags);

		// Set click handlers
		root.setOnClickListener(this);
		mUsername.setOnClickListener(this);

	}


	@Override
	public void onClick(View v) {
		if(v.getId() == mUsername.getId()){
			Intent intent = new Intent(root.getContext(), UserActivity.class);
			intent.putExtra("username", mChannel.getUsername());
			root.getContext().startActivity(intent);
		}else{
			Intent intent = new Intent(root.getContext(), ChannelActivity.class);
			intent.putExtra("id", mChannel.getId());
			root.getContext().startActivity(intent);
		}
	}
}
