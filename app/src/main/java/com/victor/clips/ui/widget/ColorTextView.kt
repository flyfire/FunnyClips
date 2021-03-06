package com.victor.clips.ui.widget

import android.content.Context
import android.content.res.Resources
import android.util.AttributeSet
import android.widget.TextView
import com.victor.clips.interfaces.ColorUiInterface
import com.victor.clips.util.ViewAttributeUtil
import android.util.Log
import android.view.View


/*
 * -----------------------------------------------------------------
 * Copyright (C) 2018-2028, by Victor, All rights reserved.
 * -----------------------------------------------------------------
 * File: ColorTextView.java
 * Author: Victor
 * Date: 2019/10/15 17:41
 * Description:
 * -----------------------------------------------------------------
 */
class ColorTextView: TextView,ColorUiInterface {
    private var attr_drawable = -1
    private var attr_textAppearance = -1
    private var attr_textColor = -1
    private var attr_textLinkColor = -1

    constructor(context: Context) : this(context,null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs,0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        this.attr_drawable = ViewAttributeUtil.getBackgroundAttibute(attrs);
        this.attr_textColor = ViewAttributeUtil.getTextColorAttribute(attrs);
        this.attr_textLinkColor = ViewAttributeUtil.getTextLinkColorAttribute(attrs);
    }

    override fun getView(): View {
        return this
    }

    override fun setTheme(themeId: Resources.Theme) {
        Log.d("COLOR", "id = $id")
        if (attr_drawable !== -1) {
            ViewAttributeUtil.applyBackgroundDrawable(this, themeId, attr_drawable)
        }
        if (attr_textColor !== -1) {
            ViewAttributeUtil.applyTextColor(this, themeId, attr_textColor)
        }
        if (attr_textLinkColor !== -1) {
            ViewAttributeUtil.applyTextLinkColor(this, themeId, attr_textLinkColor)
        }
    }
}