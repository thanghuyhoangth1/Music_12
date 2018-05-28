package trungtamgiasubaoanh.giasu.com.imusic.Utils;

import trungtamgiasubaoanh.giasu.com.imusic.BuildConfig;

/**
 * Created by Admin on 23-May-18.
 */

public class Utils {
    public static String createURL(String genre, int limit, int offset) {
        StringBuffer url = new StringBuffer();
        url.append(Constants.BASE_URL)
                .append(genre)
                .append("&")
                .append(Constants.CLIENT_ID)
                .append("=")
                .append(BuildConfig.API_KEY)
                .append("&")
                .append(Constants.LIMMIT)
                .append("=")
                .append(limit)
                .append("&")
                .append(Constants.OFFSET)
                .append("=")
                .append(offset);
        return url.toString();
    }
}
