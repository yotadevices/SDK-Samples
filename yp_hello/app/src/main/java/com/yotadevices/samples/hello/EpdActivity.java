/*
 * Copyright 2015 Yota Devices LLC, Russia
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.yotadevices.samples.hello;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.yotadevices.sdk.Epd;

/**
 * The {@code Activity} for launching on Epd display.
 * */
public class EpdActivity extends Activity implements View.OnClickListener {

    /**
     * {@inheritDoc}
     * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.epd_activity);

        // Set specific update mode for Epd display
        final View root = this.findViewById(R.id.root_view);
        Epd.setUpdateMode(root, Epd.UPDATE_MODE_HIGH_QUALITY);
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}