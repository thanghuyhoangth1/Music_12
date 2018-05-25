package trungtamgiasubaoanh.giasu.com.imusic.screen.online;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import trungtamgiasubaoanh.giasu.com.imusic.R;
import trungtamgiasubaoanh.giasu.com.imusic.data.model.Song;

/**
 * Created by Admin on 23-May-18.
 */

public class OnlineFragmentAdapter extends RecyclerView.Adapter<OnlineFragmentAdapter.ViewHolder> {
    private Context mContext;
    private List<Song> mListSong;
    private LayoutInflater mInflater;

    public OnlineFragmentAdapter(Context context, List<Song> listSong) {
        mContext = context;
        mListSong = listSong;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = mInflater.inflate(R.layout.item_song, parent, false);
        ViewHolder holder = new ViewHolder(rootView);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Song values = mListSong.get(position);
        holder.textArtist.setText(values.getUserName());
        holder.textTitle.setText(values.getTitle());
        if (values.getArtWorkUrl().equals("") | values.getArtWorkUrl() == null | values.getArtWorkUrl().equals("null")) {
            holder.imageAvatar.setImageResource(R.drawable.ic_launcher);
        } else {
            Glide.with(mContext).load(values.getArtWorkUrl()).into(holder.imageAvatar);
        }
    }

    @Override
    public int getItemCount() {
        return mListSong == null ? 0 : mListSong.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageAvatar;
        TextView textTitle;
        TextView textArtist;

        public ViewHolder(View itemView) {
            super(itemView);
            imageAvatar = itemView.findViewById(R.id.image_avatar);
            textTitle = itemView.findViewById(R.id.text_title);
            textArtist = itemView.findViewById(R.id.text_artist);
        }
    }
}
