/*
 * Copyright 2014 thuytieni <contact@duocnguyen.me>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.senviet.android.powercontroler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CommandAdapter extends ArrayAdapter<Command> {
    private Context context;
    List<Command> commandList;
    public CommandAdapter(Context context, List items)
    {
        super(context, R.layout.list_item_command, items);
        this.commandList = items;
        this.context = context;
    }
    @Override
    public Command getItem(int position)
    {
        if(position < commandList.size()) {
            return commandList.get(position);
        }
        return null;
    }
@Override
public View getView(int position, View convertView, ViewGroup parent) {
    View rowView = convertView;
    if (rowView == null) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        rowView = inflater.inflate(R.layout.list_item_command, parent, false);
    }
    TextView textView = (TextView) rowView.findViewById(R.id.tv_name);
    ImageView ivIcon = (ImageView) rowView.findViewById(R.id.iv_icon);
    textView.setText(commandList.get(position).getName());
    ivIcon.setImageResource(commandList.get(position).getIconResource());
    return rowView;
}
}
