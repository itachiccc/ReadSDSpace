package com.style.readsdspace;

import java.io.File;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.text.format.Formatter;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView et_memoryspace = (TextView) findViewById(R.id.et_memoryspace);
        File sdPath = Environment.getExternalStorageDirectory();
        File storagePath = Environment.getDataDirectory();
        StatFs sdStat = new StatFs(sdPath.getPath());
        StatFs storageStat = new StatFs(storagePath.getPath());
        long blockSize = sdStat.getBlockSizeLong();
        long blockCount = sdStat.getBlockCountLong();
        long availableBlock = sdStat.getAvailableBlocksLong();
        long blockstorageSize = storageStat.getBlockSizeLong();
        long blockstorageCount = storageStat.getBlockCountLong();
        long availablestorageBlock = storageStat.getAvailableBlocksLong();
        
        long totalsize = blockCount*blockSize;
        long availablesize = availableBlock*blockSize;
        long totalstoragesize = blockstorageCount*blockstorageSize;
        long availablestoragesize = availablestorageBlock*blockstorageSize;
        
        String totalStr = Formatter.formatFileSize(this, totalsize);
        String availableStr = Formatter.formatFileSize(this, availablesize);
        String totalstorageStr = Formatter.formatFileSize(this, totalstoragesize);
        String availablestorageStr = Formatter.formatFileSize(this, availablestoragesize);
        et_memoryspace.setText("总储存空间为:"+totalStr+"\n"+"可用储存空间为:"+availableStr+"\n\n"+""
        		+"内置总储存空间为:"+totalstorageStr+"\n"+"可用内置储存空间为:"+availablestorageStr);
    }

}
