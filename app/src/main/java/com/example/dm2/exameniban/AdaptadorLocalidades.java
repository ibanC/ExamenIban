package com.example.dm2.exameniban;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class AdaptadorLocalidades extends ArrayAdapter<Localidad> {

  private Localidad[] datos;
    private int[] imagenes;
  public AdaptadorLocalidades(Context context, Localidad[] datos, int[] imagenes) {
      super(context, R.layout.listitem_localidad, datos);
      this.datos=datos;
      this.imagenes=imagenes;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listitem_localidad, null);

        TextView lblpueblo = (TextView)item.findViewById(R.id.Lblpueblo);
        lblpueblo.setText(datos[position].getPueblo());

        TextView lblSuperficie = (TextView)item.findViewById(R.id.lblsuperficie);
        lblSuperficie.setText(datos[position].getSuperficie());

        TextView lblhabitantes=(TextView)item.findViewById(R.id.lblhabitantes);
        lblhabitantes.setText(datos[position].getHabitantes());

        TextView lblweb=(TextView)item.findViewById(R.id.lblweb);
        lblweb.setText(datos[position].getWeb());

        ImageView imgImg = (ImageView) item.findViewById(R.id.list_row_image);
        imgImg.setImageResource(imagenes[position]);
        return(item);
    }
}
