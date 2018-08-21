package com.example.lyn.audiovideo

import android.media.MediaCodec
import android.R.attr.configure
import android.media.MediaFormat



class MediaCodecUtil {
    private var mMediaCodec = null;
    private var mMimeType = "ss";
    public fun init() {
        mMediaCodec = MediaCodec.createDecoderByType(mMimeType) as Nothing?;
        //初始化解码器格式 预设宽高
        val mediaformat = MediaFormat.createVideoFormat(mMimeType, VIDEO_WIDTH, VIDEO_HEIGHT)
        //设置帧率
        mediaformat.setInteger(MediaFormat.KEY_FRAME_RATE, FRAME_RATE)
        //crypto:数据加密 flags:编码器/编码器
        mMediaCodec.configure(mediaformat, mSurface, null, 0)
        mMediaCodec.start()
    }
}