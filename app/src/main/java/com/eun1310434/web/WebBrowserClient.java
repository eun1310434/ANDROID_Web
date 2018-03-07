/*=====================================================================
□ Infomation
  ○ Data : 07.03.2018
  ○ Mail : eun1310434@naver.com
  ○ Blog : https://blog.naver.com/eun1310434
  ○ Reference : Do it android app Programming

□ Function
  ○ WebChrome이 연동되게 설정

□ Study
  ○
=====================================================================*/

package com.eun1310434.web;

import android.util.Log;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;


final class WebBrowserClient extends WebChromeClient {
    public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
        Log.d("MainActivity", message);
        result.confirm();
        return true;
    }
}