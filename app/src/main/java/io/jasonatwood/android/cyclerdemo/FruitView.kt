package io.jasonatwood.android.cyclerdemo

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout

/**
 * Most of the time, RecyclerViews just inflate XML layouts. However, with Cycler, it is best to create
 * Kotlin objects (also?)
 */
open class FruitView : LinearLayout {
  constructor(context: Context?) : super(context)
  constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
}

class AppleView : FruitView {
  constructor(context: Context?) : super(context)
  constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
}

class BananaView : FruitView {
  constructor(context: Context?) : super(context)
  constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
}

class PearView : FruitView {
  constructor(context: Context?) : super(context)
  constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
}