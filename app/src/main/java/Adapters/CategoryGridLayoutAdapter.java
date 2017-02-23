package Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.nipunarora.dufeed.R;

/**
 * Created by nipunarora on 19/02/17.
 */
public class CategoryGridLayoutAdapter extends BaseAdapter {
    Context mContext;
    Integer [] icons={
            R.drawable.datesheet,R.drawable.resultgrid,R.drawable.notificationgridview,R.drawable.miscellaneous};

    public  CategoryGridLayoutAdapter(Context c)
    {
        mContext=c;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       /************************* Inflate custom view and then assign images and set on clicklistener **********/
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(icons[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(250,250));
        return imageView;

    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return icons[position];
    }

    @Override
    public int getCount() {
        return icons.length;
    }
}
