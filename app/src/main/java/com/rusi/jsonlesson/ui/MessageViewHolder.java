package com.rusi.jsonlesson.ui;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.rusi.jsonlesson.R;

public class MessageViewHolder extends RecyclerView.ViewHolder {
	private TextView messageTextView;

	public MessageViewHolder (@NonNull View itemView) {
		super(itemView);
		messageTextView = itemView.findViewById(R.id.messageTextView);
	}

	public void bind (@Nullable String message, int position) {
		messageTextView.setText(new StringBuilder().append(String.valueOf(position))
			  .append(": ")
			  .append(message).toString());
	}
}
