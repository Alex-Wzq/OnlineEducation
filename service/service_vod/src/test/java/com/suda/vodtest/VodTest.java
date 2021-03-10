package com.suda.vodtest;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.vod.model.v20170321.GetPlayInfoRequest;
import com.aliyuncs.vod.model.v20170321.GetPlayInfoResponse;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthRequest;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthResponse;

import java.util.List;

import static com.suda.vodtest.InitObject.initVodClient;

public class VodTest {

    public static void main(String[] args) {
        // 输出url
        getUrl();
    }

    /*获取播放地址函数*/
    public static GetPlayInfoResponse getPlayInfo(DefaultAcsClient client) throws Exception {
        GetPlayInfoRequest request = new GetPlayInfoRequest();
        request.setVideoId("b9d93d5521f94b53a2dc77397fde3393");
        return client.getAcsResponse(request);
    }

    /*以下为调用示例*/
    public static void getUrl() {
        DefaultAcsClient client = null;
        GetPlayInfoResponse response = null;
        GetVideoPlayAuthResponse getVideoPlayAuthResponse = null;

        try {
            client = initVodClient("LTAI4G9pgSoCetf6HN7BYi8L", "pQbceF5ohYXWsSojcmCKVcjeVyK9du");
            response = getPlayInfo(client);

            List<GetPlayInfoResponse.PlayInfo> playInfoList = response.getPlayInfoList();
            //播放地址
            for (GetPlayInfoResponse.PlayInfo playInfo : playInfoList) {
                System.out.print("PlayInfo.PlayURL = " + playInfo.getPlayURL() + "\n");
            }

            //播放凭证
            getVideoPlayAuthResponse = getVideoPlayAuth(client);
            System.out.print("PlayAuth = " + getVideoPlayAuthResponse.getPlayAuth() + "\n");

            //Base信息
            System.out.print("VideoBase.Title = " + response.getVideoBase().getTitle() + "\n");
            //VideoMeta信息
            System.out.print("VideoMeta.Title = " + getVideoPlayAuthResponse.getVideoMeta().getTitle() + "\n");

        } catch (Exception e) {
            System.out.print("ErrorMessage = " + e.getLocalizedMessage());
        }
        System.out.print("RequestId = " + response.getRequestId() + "\n");
        System.out.print("GetVideoPlayAuthResponse = " + getVideoPlayAuthResponse.getRequestId() + "\n");
    }

    /*获取播放凭证函数*/
    public static GetVideoPlayAuthResponse getVideoPlayAuth(DefaultAcsClient client) throws Exception {
        GetVideoPlayAuthRequest request = new GetVideoPlayAuthRequest();
        request.setVideoId("b9d93d5521f94b53a2dc77397fde3393");
        return client.getAcsResponse(request);
    }

    /*以下为调用示例*/
    public static void getPlayAuth() {
        DefaultAcsClient client = null;
        GetVideoPlayAuthResponse response = new GetVideoPlayAuthResponse();

        try {
            client = initVodClient("LTAI4G9pgSoCetf6HN7BYi8L", "pQbceF5ohYXWsSojcmCKVcjeVyK9du");

            response = getVideoPlayAuth(client);
            //播放凭证
            System.out.print("PlayAuth = " + response.getPlayAuth() + "\n");
            //VideoMeta信息
            System.out.print("VideoMeta.Title = " + response.getVideoMeta().getTitle() + "\n");
        } catch (Exception e) {
            System.out.print("ErrorMessage = " + e.getLocalizedMessage());
        }
        System.out.print("RequestId = " + response.getRequestId() + "\n");
    }

}
