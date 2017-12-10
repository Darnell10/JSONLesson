package com.rusi.jsonlesson.controller;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rusi.jsonlesson.R;
import com.rusi.jsonlesson.ui.MessageViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageViewHolder> {
	private List<String> messageList = new ArrayList<>();

	public MessageAdapter(@Nullable List<String> list){
		this.messageList = list;
	}

	@Override
	public MessageViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_viewholder, null);
		return new MessageViewHolder(view);
	}

	@Override
	public void onBindViewHolder (MessageViewHolder holder, int position) {
		holder.bind(messageList.get(position), position);
	}

	@Override
	public int getItemCount () {
		return messageList.size();
	}
}
