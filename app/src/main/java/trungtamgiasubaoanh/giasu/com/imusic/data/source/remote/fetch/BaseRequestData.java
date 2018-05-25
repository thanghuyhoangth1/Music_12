package trungtamgiasubaoanh.giasu.com.imusic.data.source.remote.fetch;

import android.os.AsyncTask;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import trungtamgiasubaoanh.giasu.com.imusic.data.model.GenreSongEntry;
import trungtamgiasubaoanh.giasu.com.imusic.data.source.OnFetchDataListener;

/**
 * Created by Admin on 24-May-18.
 */

public abstract class BaseRequestData<T> extends AsyncTask<String, Void, BaseRequestData.WrapperData<T>> {

    private OnFetchDataListener<T> mOnFetchDataListener;
    private WrapperData<T> mWrapperData;
    private int mRequestCode;

    public BaseRequestData(OnFetchDataListener<T> onFetchDataListener) {
        mOnFetchDataListener = onFetchDataListener;
        mWrapperData = new WrapperData<>();
    }

    public void setRequestCode(@GenreSongEntry.RequestGenreAnotation int requestCode) {
        mRequestCode = requestCode;
    }

    public abstract List<T> parserJSON(String jsonString) throws JSONException;

    @Override
    protected WrapperData<T> doInBackground(String... strings) {

        String jsonString = "";
        try {
            URL url = new URL(strings[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream songInputStream = connection.getInputStream();
            InputStreamReader songReader = new InputStreamReader(songInputStream);
            BufferedReader reader = new BufferedReader(songReader);
            String line = "";
            while ((line = reader.readLine()) != null) {
                jsonString = jsonString + line;
            }
            songInputStream.close();
            reader.close();
            songReader.close();
            connection.disconnect();
            mWrapperData.setData(parserJSON(jsonString));
        } catch (MalformedURLException e) {
            mWrapperData.setException(e);
            e.printStackTrace();
        } catch (IOException e) {
            mWrapperData.setException(e);
            e.printStackTrace();
        } catch (JSONException e) {
            mWrapperData.setException(e);
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(WrapperData<T> tWrapperData) {
        super.onPostExecute(tWrapperData);
        if (mWrapperData.getException() == null & mOnFetchDataListener != null) {
            mOnFetchDataListener.onSuccess(mRequestCode, mWrapperData.getData());
        } else if (mWrapperData.getException() != null) {
            mOnFetchDataListener.onFailure(mWrapperData.getException());
        }
    }

    public static class WrapperData<T> {
        private List<T> mData;
        private Exception mException;

        public List<T> getData() {
            return mData;
        }

        public void setData(List<T> data) {
            mData = data;
        }

        public Exception getException() {
            return mException;
        }

        public void setException(Exception exception) {
            mException = exception;
        }
    }
}
