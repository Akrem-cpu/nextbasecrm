package com.nextbasecrm.utilities;

import com.nextbasecrm.pages.ActivityStream;

public class Pages {
    private Pages(){}

   private static ActivityStream stream;


    public static ActivityStream getStream() {
        stream = new ActivityStream();
        return stream;
    }
}
