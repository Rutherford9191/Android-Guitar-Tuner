package com.chrynan.guitartuner.util;

import android.media.AudioFormat;
import android.media.AudioRecord;

/**
 * Created by chRyNaN on 1/13/2016.
 */
public class AudioUtils {
    public static final int DEFAULT_SAMPLE_RATE = 44100;
    public static final int[] POSSIBLE_SAMPLE_RATES = new int[] {8000, 11025, 16000, 22050,
            32000, 37800, 44056, 44100, 47250, 48000};

    public static final int getSampleRate(boolean lowest){
        int sampleRate = -1;
        for(int rate : POSSIBLE_SAMPLE_RATES){
            int bufferSize = AudioRecord.getMinBufferSize(rate, AudioFormat.CHANNEL_IN_DEFAULT, AudioFormat.ENCODING_PCM_16BIT);
            if (bufferSize > 0) {
                // buffer size is valid, Sample rate supported
                sampleRate = rate;
                if(lowest){
                    return sampleRate;
                }
            }
        }
        return sampleRate;
    }

    public static final int getSampleRate(){
        return getSampleRate(false);
    }

}
