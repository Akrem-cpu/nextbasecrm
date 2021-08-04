package com.nextbasecrm.utilities;

import com.nextbasecrm.pages.ActivityStream;
import com.nextbasecrm.pages.Authorization;

public class Pages {
    private Pages(){}

   private static ActivityStream stream;
   private static Authorization authorization;



    public synchronized static ActivityStream getStream() {
        if(stream==null){
            stream = new ActivityStream();
        }

        return stream;
    }

    public synchronized static Authorization getAuthorization() {
        if(authorization == null){
            authorization = new Authorization();
        }
        return   authorization;
    }

    public static void closeAuthorization(){
        authorization = null;
    }
    public static void closeStream(){
        stream = null;
    }

}
