package com.pallaw.tmassignment.Util;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;

/**
 * Created by Pallaw Pathak on 2019-06-18. - https://www.linkedin.com/in/pallaw-pathak-a6a324a1/
 */
public class Util {
    /**
     * Converting dp to pixel
     */
    public static int dpToPx(Context context, int dp) {
        Resources r =context.getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
