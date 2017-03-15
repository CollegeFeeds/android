package Adapters;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
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
    String [] titles={"Datesheet","Results","Notifications","Miscelleneous"};

    public  CategoryGridLayoutAdapter(Context c)
    {
        mContext=c;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       /************************* Inflate custom view and then assign images and set on clicklistener **********/
       if(convertView==null)
       {
           convertView= LayoutInflater.from(mContext).inflate(R.layout.utilities_gridviewcard, parent, false);
       }
        AppCompatImageView imageView = (AppCompatImageView)convertView.findViewById(R.id.utilityicon);
        imageView.setBackgroundResource(icons[position]);
        AppCompatTextView textview=(AppCompatTextView)convertView.findViewById(R.id.utilityname);
        textview.setText(titles[position]);
        return convertView;

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
