package com.example.mpd_coursework;

import android.app.ProgressDialog;
import android.os.Handler;

public class UsefulThread extends Thread
{
    private Handler mHandler;
    private ProgressDialog mProgressBar;

    public UsefulThread(ProgressDialog pBar)
    {
        mProgressBar = pBar;
        mHandler = new Handler();
    }

    public void run()
    {
        for (int i = 0; i <= 100; i++)
        {
            final int currentProgressCount = i;
            try
            {
                Thread.sleep(50);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            //Update the value background thread to UI thread
            mHandler.post(new Runnable()
            {
                @Override
                public void run()
                {
                    mProgressBar.setProgress(currentProgressCount);
                }
            });
        }
    }

}
