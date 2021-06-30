package com.reactnativeantourage

import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.antourage.weaverlib.screens.base.AntourageActivity
import com.antourage.weaverlib.ui.fab.AntourageFab
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.uimanager.UIBlock
import com.facebook.react.uimanager.UIManagerModule


class AntourageManager(reactContext: ReactApplicationContext, antourageViewManager: AntourageViewManager?) : ReactContextBaseJavaModule(reactContext){

  private var viewManager: AntourageViewManager? = null

  init {
    if (antourageViewManager != null) {
      viewManager = antourageViewManager
    }
  }

  companion object {
    private const val REACT_CLASS = "RNAntourage"
    private const val TAG = "AntourageFabLogs"
  }

  override fun getName(): String {
    return REACT_CLASS
  }


  @ReactMethod
  fun configure() {
    Log.d(TAG, "configure called")
    reactApplicationContext.currentActivity?.runOnUiThread {
      AntourageFab.configure(reactApplicationContext, true)
    }
  }

  @ReactMethod
  fun showFeed() {
    val intent = Intent(reactApplicationContext, AntourageActivity::class.java)
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
    reactApplicationContext.currentActivity?.startActivity(intent)
  }

  @ReactMethod
  fun onPause() {
    Handler(Looper.getMainLooper()).post{
      Log.d(TAG, "onPause called from AntourageManager")
      viewManager?.getInstance()?.onPause()
    }
  }
}
