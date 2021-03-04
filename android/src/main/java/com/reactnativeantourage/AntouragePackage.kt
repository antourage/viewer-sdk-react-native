package com.reactnativeantourage

import com.facebook.react.ReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.ViewManager

class AntouragePackage : ReactPackage {
  private var antourageViewManager: AntourageViewManager? = null

  override fun createNativeModules(reactContext: ReactApplicationContext): List<NativeModule> {
    if(antourageViewManager == null){
      antourageViewManager = AntourageViewManager()
    }
    return listOf<NativeModule>(AntourageManager(reactContext, antourageViewManager))
  }

  override fun createViewManagers(reactContext: ReactApplicationContext): List<ViewManager<*, *>> {
    if(antourageViewManager == null){
      antourageViewManager = AntourageViewManager()
    }
    return listOf(antourageViewManager!!)
  }
}
