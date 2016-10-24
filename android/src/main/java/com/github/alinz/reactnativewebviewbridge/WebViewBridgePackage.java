package com.github.alinz.reactnativewebviewbridge;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WebViewBridgePackage implements ReactPackage {
    private RNWebViewModule module;
    private RNWebViewManager viewManager;

    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        module = new RNWebViewModule(reactApplicationContext);
        module.setPackage(this);
        
        List<NativeModule> modules = new ArrayList<>();
        modules.add(module);
        
        return modules;
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        viewManager = new RNWebViewManager();
        viewManager.setPackage(this);
        
        return Arrays.<ViewManager>asList(viewManager);
    }

    @Override
    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Arrays.asList();
    }
    
    public RNWebViewModule getModule() {
        return module;
    }
    
    public RNWebViewManager getViewManager() {
        return viewManager;
    }
}
