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

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainFragment extends ListFragment {
    private List<Command> commandList;

public MainFragment() {
    commandList = new ArrayList<Command>();
    commandList.add(new Command("Reboot", new String[]{"su", "-c", "reboot"}, R.drawable.ic_restart));
    commandList.add(new Command("Shutdown", new String[]{"su", "-c", "reboot -p"}, R.drawable.ic_shutdown));
    commandList.add(new Command("Recovery", new String[]{"su", "-c", "reboot recovery"}, R.drawable.ic_recovery));
}

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_main, container, false);
    setListAdapter(new CommandAdapter(getActivity(), commandList));
    return rootView;
}

@Override
public void onListItemClick(ListView l, View v, int position, long id) {
    super.onListItemClick(l, v, position, id);
    try {
        Process process = Runtime.getRuntime().exec(commandList.get(position).getCommand());
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
