package com.nara.narayana;

import java.io.File;
import java.io.FileFilter;

public class ImagesFilter implements FileFilter
{
    @Override
    public boolean accept(File dir)
    {
        if (dir.isDirectory() || dir.toString().endsWith(".jpg") || dir.toString().endsWith(".jpeg") ||
                dir.toString().endsWith(".png") || dir.toString().endsWith(".gif") || dir.toString().endsWith(".bmp"))
        {
            return true;
        }
        return false;
    }
}
