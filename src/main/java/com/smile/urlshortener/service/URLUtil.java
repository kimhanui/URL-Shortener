package com.smile.urlshortener.service;

import org.springframework.stereotype.Component;

@Component
public class URLUtil {

    public static String getPath(String url){
        final int SIZE = url.length();
        int sliceIndex=-1;
        int cnt=0;
        for(int i=0;i<SIZE;i++){
            if(url.charAt(i) == '/'){
                cnt++;
                if(cnt == 3){
                    sliceIndex = i;
                }
            }
        }
        if(sliceIndex == -1 || sliceIndex == SIZE-1) //도메인만 있는 경우
            return "";
        return url.substring(sliceIndex, SIZE-1);
    }

    // TODO : url의 path를 단축할 수 있는 메서드 작성
    public static String getShortenPath(String path) {

        return "";
    }
}
