package trungtamgiasubaoanh.giasu.com.imusic;

/**
 * Created by Admin on 18-May-18.
 */

public interface BasePresenter<T> {
    void setView(T view);

    void onStart();

    void onStop();
}
