package com.compass.uavmanager.view;

import tv.danmaku.ijk.media.player.IMediaPlayer;

public interface VideoListener {

    void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i);

    void onCompletion(IMediaPlayer iMediaPlayer);

    boolean onError(IMediaPlayer iMediaPlayer, int i, int i1);

    boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i1);

    void onPrepared(IMediaPlayer iMediaPlayer);

    void onSeekComplete(IMediaPlayer iMediaPlayer);

    void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i1, int i2, int i3);
}
