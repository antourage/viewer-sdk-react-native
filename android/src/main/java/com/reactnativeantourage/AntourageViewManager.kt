package com.reactnativeantourage

import android.graphics.Color
import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.antourage.weaverlib.ui.AntourageFab
import com.facebook.react.bridge.Arguments
import com.facebook.react.bridge.LifecycleEventListener
import com.facebook.react.bridge.ReactContext
import com.facebook.react.common.MapBuilder
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.uimanager.events.RCTEventEmitter
import javax.annotation.Nonnull

class AntourageViewManager : SimpleViewManager<AntourageFab?>(), View.OnClickListener,
  LifecycleEventListener {
  companion object {
    private const val REACT_CLASS = "AntourageView"
    private const val TAG = "AntourageFabLogs"
  }

  private var fab: AntourageFab? = null

  fun getInstance(): AntourageFab? {
    return fab
  }

  override fun onClick(v: View) {
    val map = Arguments.createMap()
    val context = v.context as ReactContext
    context.getJSModule(RCTEventEmitter::class.java).receiveEvent(v.id, "topChange", map)
  }

  override fun getName(): String {
    return REACT_CLASS
  }

  override fun createViewInstance(@Nonnull reactContext: ThemedReactContext): AntourageFab {
    reactContext.addLifecycleEventListener(this)
    if (fab != null && fab?.parent != null) {
      (fab?.parent as ViewGroup).removeView(fab)
    } else {
      fab = AntourageFab(reactContext)
    }
    return fab as AntourageFab
  }

  @ReactProp(name = "portalColor")
  fun setPortalColor(button: AntourageFab, color: String?) {
    color?.let { fab?.portalColor = Color.parseColor(it) }
  }

  @ReactProp(name = "nameTextColor")
  fun setNameTextColor(button: AntourageFab, color: String?) {
    color?.let { fab?.nameTextColor = Color.parseColor(it) }
  }

  @ReactProp(name = "nameBackgroundColor")
  fun setNameBackgroundColor(button: AntourageFab, color: String?) {
    color?.let { fab?.nameBackgroundColor = Color.parseColor(it) }
  }

  @ReactProp(name = "titleTextColor")
  fun setTitleTextColor(button: AntourageFab, color: String?) {
    color?.let { fab?.titleTextColor = Color.parseColor(it) }
  }

  @ReactProp(name = "titleBackgroundColor")
  fun setTitleBackgroundColor(button: AntourageFab, color: String?) {
    color?.let { fab?.titleBackgroundColor = Color.parseColor(it) }
  }

  @ReactProp(name = "ctaTextColor")
  fun setCtaTextColor(button: AntourageFab, color: String?) {
    color?.let { fab?.ctaTextColor = Color.parseColor(it) }
  }

  @ReactProp(name = "ctaBackgroundColor")
  fun setCtaBackgroundColor(button: AntourageFab, color: String?) {
    color?.let { fab?.ctaBackgroundColor = Color.parseColor(it) }
  }

  @ReactProp(name = "liveDotColor")
  fun setLiveDotColor(button: AntourageFab, color: String?) {
    color?.let { fab?.liveDotColor = Color.parseColor(it) }
  }

  override fun getExportedCustomDirectEventTypeConstants(): MutableMap<String, Any>? {
    return MapBuilder.of(
      "onViewerAppear",
      MapBuilder.of("registrationName", "onViewerAppear"),
      "onViewerDisappear",
      MapBuilder.of("registrationName", "onViewerDisappear")
    )
  }

  override fun onHostResume() {
    Log.d(TAG, "onResume")
    fab?.onResume()
  }

  override fun onHostPause() {
    Log.d(TAG, "onPause")
    fab?.onPause()
  }

  override fun onHostDestroy() {
  }
}
