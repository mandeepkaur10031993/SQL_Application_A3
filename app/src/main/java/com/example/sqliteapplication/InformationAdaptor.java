package com.example.sqliteapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

class InformationAdaptor extends ArrayAdapter {
    List<Information> Information;
    private final LayoutInflater layoutInflater;
    private final int layoutResource;

    public InformationAdaptor(@NonNull Context context, int resource, List<Information> Information){
        super(context, resource);
        this.Information = Information;
        this.layoutInflater = LayoutInflater.from(context);
        this.layoutResource = resource;
    }

    @Override
    public int getCount(){
        return Information.size();
    }

    @Nullable
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View v = convertView;
        v = layoutInflater.inflate(layoutResource, parent,false);
        TextView nameText = v.findViewById(R.id.nameText);
        TextView contactText = v.findViewById(R.id.contactText);
        TextView DobText = v.findViewById(R.id.DoBtext);
        nameText.setText(nameText.getText() + " " + Information.get(position).getName());
        contactText.setText(contactText.getText() + " " + Information.get(position).getContact());
        DobText.setText(DobText.getText() + " " + Information.get(position).getDate_of_birth());
        return v;
    }
}
