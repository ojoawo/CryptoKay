package com.example.solomonojoawo.cryptokay;

/**
 * Created by Solomon Ojoawo on 11/12/2017.
 */

package com.example.currencyconverter;
        import java.text.DecimalFormat;
        import android.content.Context;
        import android.graphics.Color;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.ImageView;
        import android.widget.TextView;

public class ListAdapterModel extends ArrayAdapter<String>{
    int groupid;
    String[] clist;
    Context context;
    String to;
    Double[] alist;

    public ListAdapterModel(Context context, int vg,String[] clist, Double[] alist, String to){
        super(context,vg, clist);
        this.context=context;
        groupid=vg;
        this.clist=clist;
        this.to=to;
        this.alist=alist;
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(groupid, parent, false);
        ImageView imageView = (ImageView) itemView.findViewById(R.id.icon);
        imageView.setImageDrawable(context.getResources().getDrawable(getImage(position)));
        TextView textCurrency = (TextView) itemView.findViewById(R.id.currency);
        TextView textAmount= (TextView) itemView.findViewById(R.id.label_amount);
        textCurrency.setText(clist[position]);
        DecimalFormat df=new DecimalFormat("#,###.0000");
        String value=df.format(Double.valueOf(alist[position]));
        textAmount.setText(value);
        if(clist[position].equals(to)) //highlight the target conversion row
            itemView.setBackgroundColor(Color.MAGENTA);
        return itemView;

    }

    public Integer getImage(int pos){
        Integer[] imageIds=new Integer[12];
        imageIds[0]=R.drawable.aud;
        imageIds[1]=R.drawable.cad;
        imageIds[2]=R.drawable.chf;
        imageIds[3]=R.drawable.eur;
        imageIds[4]=R.drawable.gbp;
        imageIds[5]=R.drawable.jpy;
        imageIds[6]=R.drawable.nzd;
        imageIds[7]=R.drawable.khr;
        imageIds[8]=R.drawable.usd;
        imageIds[9]=R.drawable.cny;
        imageIds[10]=R.drawable.thb;
        imageIds[11]=R.drawable.inr;

        return(imageIds[pos]);

    }

}

