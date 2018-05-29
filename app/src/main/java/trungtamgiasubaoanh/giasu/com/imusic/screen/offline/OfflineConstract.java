package trungtamgiasubaoanh.giasu.com.imusic.screen.offline;

import java.util.List;

import trungtamgiasubaoanh.giasu.com.imusic.BasePresenter;

/**
 * Created by Admin on 25-May-18.
 */

public class OfflineConstract {
    interface View {
        void initRecyclerViewAllSong(List data);

        void initRecyclerViewAllAlbym(List datait);

        void initRecyclerViewArtist(List data);
    }

    interface Presenter extends BasePresenter<OfflineConstract.View> {
        void getListAllSong();

        void getListALlAlbum();

        void getListArtist();
    }
}
