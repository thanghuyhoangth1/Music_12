package trungtamgiasubaoanh.giasu.com.imusic.screen.online;

import java.util.List;

import trungtamgiasubaoanh.giasu.com.imusic.BasePresenter;
import trungtamgiasubaoanh.giasu.com.imusic.data.model.Song;

/**
 * Created by Admin on 22-May-18.
 */

public interface OnlineConstract {
    interface View {
        void initRecyclerAllMusic(List<Song> listSong);

        void initRecyclerAllAudio(List<Song> listSong);

        void initRecyclerAlternativerock(List<Song> listSong);

        void initRecyclerAmbiant(List<Song> listSong);

        void initRecyclerClassical(List<Song> listSong);

        void initRecyclerCountry(List<Song> listSong);
    }

    interface Presenter extends BasePresenter<OnlineConstract.View> {
        void getListAllMusic();

        void getListAllAudio();

        void getListAlternativerock();

        void getListAmbiant();

        void getListClassical();

        void getListCoutry();
    }
}
