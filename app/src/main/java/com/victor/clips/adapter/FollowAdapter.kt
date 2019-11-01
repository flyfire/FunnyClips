package com.victor.clips.adapter

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.LinearSnapHelper
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.AdapterView
import com.victor.clips.R
import com.victor.clips.app.App
import com.victor.clips.data.FollowInfo
import com.victor.clips.data.FollowItem
import com.victor.clips.data.VideoCategoryInfo
import com.victor.clips.holder.ContentViewHolder
import com.victor.clips.holder.LiveContentViewHolder
import com.victor.clips.util.ImageUtils
import com.victor.clips.util.Loger
import com.victor.clips.widget.GravitySnapHelper
import kotlinx.android.synthetic.main.activity_video_detail.*
import kotlinx.android.synthetic.main.adapter_media_type_item.view.*
import kotlinx.android.synthetic.main.adapter_media_type_item.view.recyclerView
import kotlinx.android.synthetic.main.rv_follow_cell.view.*
import kotlinx.android.synthetic.main.rv_video_category_cell.view.*

/*
 * -----------------------------------------------------------------
 * Copyright (C) 2018-2028, by Victor, All rights reserved.
 * -----------------------------------------------------------------
 * File: FollowAdapter.java
 * Author: Victor
 * Date: 2018/8/30 17:57
 * Description: 
 * -----------------------------------------------------------------
 */
class FollowAdapter(context: Context, listener: AdapterView.OnItemClickListener?) :
        BaseRecycleAdapter<FollowItem, RecyclerView.ViewHolder>(context, listener),
        GravitySnapHelper.SnapListener{

    override fun onSnap(position: Int) {
        Loger.d("onSnap()-position = ", position.toString())
    }

    override fun onCreateHeadVHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder? {
        return null
    }

    override fun onBindHeadVHolder(viewHolder: RecyclerView.ViewHolder, data: FollowItem, position: Int) {
    }

    override fun onCreateContentVHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ContentViewHolder(mLayoutInflater!!.inflate(R.layout.rv_follow_cell, parent, false))
    }

    override fun onBindContentVHolder(viewHolder: RecyclerView.ViewHolder, data: FollowItem, position: Int) {
        val contentViewHolder = viewHolder as ContentViewHolder
        contentViewHolder.itemView.mTvFollowTitle.setText(data.data?.header?.title)
        contentViewHolder.itemView.mTvFollowDes.setText(data.data?.header?.description)
        ImageUtils.instance.loadAvatar(mContext!!,contentViewHolder.itemView.mIvFollowAvatar, data.data?.header?.icon)

        contentViewHolder.itemView.recyclerView.layoutManager = LinearLayoutManager(
                contentViewHolder.itemView.context,
                LinearLayoutManager.HORIZONTAL,false)
        contentViewHolder.itemView.recyclerView.setOnFlingListener(null)
        LinearSnapHelper().attachToRecyclerView(contentViewHolder.itemView.recyclerView)

        var cellAdapter = FollowCellAdapter(mContext!!,mOnItemClickListener!!,position)
        cellAdapter.add(data.data?.itemList)

        contentViewHolder.itemView.recyclerView.adapter = cellAdapter
    }
}