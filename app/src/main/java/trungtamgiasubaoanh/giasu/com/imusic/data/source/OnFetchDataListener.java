package trungtamgiasubaoanh.giasu.com.imusic.data.source;

import java.util.List;

/**
 * Created by Admin on 22-May-18.
 */

public interface OnFetchDataListener<T> {
    void onSuccess(int requestCode, List<T> data);

    void onSuccess(List<T> data);

    void onFailure(Exception e);
}
