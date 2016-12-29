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
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

/**
 * The main {@code Activity} in this app.
 *
 * <p>If you want to use all features, provided by <tt>YotaDevices SDK API</tt>, you must either
 * add following code in your <b>AndroidManifest.xml</b>:
 * <pre>
 *     &lt;uses-library
 *     android:name="com.yotadevices.sdk"
 *     android:required="false|true" /&gt;
 * </pre>
 * where the <tt>android:required</tt> parameter allows to run an application on non-yotaphone
 * devices if set to <tt>false</tt>. </p>
 *
 * <p>Also you have to connect an SDK in your <b>build.gradle</b> file as shown below:
 * <pre>
 *     allprojects {
 *         repositories {
 *             jcenter()
 *             // Add YotaDevices maven repository
 *             maven { url "http://fw.ydevices.com/maven" }
 *         }
 *     }
 * </pre><pre>
 *     dependencies {
 *         provided 'com.yotadevices.libs.public:sdk:3.7.+'
 *     }
 * </pre></p>
 * */
public class MainActivity extends Activity {

    /** Contains a name of the yotaphone device. */
    private static final String YOTAPHONE = "yotaphone";

    /** Contains the main {@code TextView}.*/
    private TextView mMainText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMainText = (TextView) findViewById(R.id.main_text);

        // If you plan to run this application on different devices (not on YotaPhone only), you
        // may want to check if this device is YotaPhone before starting Epd activity. You could
        // use Build.DEVICE for this.
        if (!Build.DEVICE.contains(YOTAPHONE)) {
            // This device is not a YotaPhone, say "Hello! This is not a YotaPhone!"
            mMainText.setText(getString(R.string.hello_strange_phone));
        } else {
            // This device is a YotaPhone, say "Hello, YotaPhone!" and start activity on Epd screen
            mMainText.setText(getString(R.string.hello_yota_phone));
            this.startActivity(new Intent(this, EpdActivity.class));
        }
    }
}