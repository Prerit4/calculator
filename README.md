public class AudioListActivity extends Activity {
ListView musiclist;
Cursor musiccursor;
int music_column_index;
int count;
MediaPlayer mMediaPlayer;

@Override
protected void onCreate(Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    super.onCreate(savedInstanceState);
    setContentView(R.layout.audiolist_activity);
    init_phone_music_grid();
}
private void init_phone_music_grid() {
    System.gc();
    String[] proj = { MediaStore.Audio.Media._ID,MediaStore.Audio.Media.DATA,
                        MediaStore.Audio.Media.DISPLAY_NAME,MediaStore.Video.Media.SIZE };

    musiccursor = managedQuery(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,proj, null, null, null);

    count = musiccursor.getCount();
    musiclist = (ListView) findViewById(R.id.PhoneMusicList);
    musiclist.setAdapter(new MusicAdapter(getApplicationContext()));

    musiclist.setOnItemClickListener(musicgridlistener);
    mMediaPlayer = new MediaPlayer();
}

private OnItemClickListener musicgridlistener = new OnItemClickListener() {
    public void onItemClick(AdapterView parent, View v, int position,long id) {
        System.gc();
        music_column_index = musiccursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA);
        musiccursor.moveToPosition(position);
        String filename = musiccursor.getString(music_column_index);

        try {
            if (mMediaPlayer.isPlaying()) {
                mMediaPlayer.reset();
            }
            mMediaPlayer.setDataSource(filename);
            mMediaPlayer.prepare();
            mMediaPlayer.start();
        } catch (Exception e) {

        }
    }
};

public class MusicAdapter extends BaseAdapter {
    private Context mContext;

    public MusicAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return count;
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        System.gc();
        TextView tv = new TextView(mContext.getApplicationContext());
        String id = null;
        if (convertView == null) {
            music_column_index = musiccursor
                    .getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME);
            musiccursor.moveToPosition(position);
            id = musiccursor.getString(music_column_index);
            music_column_index = musiccursor
                    .getColumnIndexOrThrow(MediaStore.Audio.Media.SIZE);
            musiccursor.moveToPosition(position);
            id += " Size(KB):" + musiccursor.getString(music_column_index);
            tv.setText(id);
        } else
            tv = (TextView) convertView;
        return tv;
    }
}
@Override
public void onBackPressed() {
    // TODO Auto-generated method stub
    super.onBackPressed();
    mMediaPlayer.stop();
}
}
