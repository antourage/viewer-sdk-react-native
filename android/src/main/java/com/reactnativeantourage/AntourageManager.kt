package com.reactnativeantourage

import android.os.Handler
import android.os.Looper
import com.antourage.weaverlib.ui.AntourageFab
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod


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
  fun configure(teamId: Int, localization: String?) {
    reactApplicationContext.currentActivity?.runOnUiThread {
      AntourageFab.configure(reactApplicationContext, teamId, localization)
    }
  }

  @ReactMethod
  fun onPause() {
    Handler(Looper.getMainLooper()).post{
      viewManager?.getInstance()?.onPause()
    }
  }
}
