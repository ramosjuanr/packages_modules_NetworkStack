/*
 * Copyright (C) 2020 The Android Open Source Project
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

package android.net.shared;

import android.net.Layer2InformationParcelable;
import android.net.MacAddress;

import java.util.Objects;

/** @hide */
public class Layer2Information {
    public final String mL2Key;
    public final String mGroupHint;
    public final MacAddress mBssid;

    /**
     * Create a Layer2Information with the specified configuration.
     */
    public Layer2Information(String l2Key, String groupHint, MacAddress bssid) {
        mL2Key = l2Key;
        mGroupHint = groupHint;
        mBssid = bssid;
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append("L2Key: ").append(mL2Key);
        str.append(", GroupHint: ").append(mGroupHint);
        str.append(", bssid: ").append(mBssid.toString());
        return str.toString();
    }

    /**
     * Convert Layer2 Information to a {@link Layer2InformationParcelable}.
     */
    public Layer2InformationParcelable toStableParcelable() {
        final Layer2InformationParcelable p = new Layer2InformationParcelable();
        p.l2Key = mL2Key;
        p.groupHint = mGroupHint;
        p.bssid = mBssid;
        return p;
    }

    /**
     * Create an instance of {@link Layer2Information} based on the contents of the specified
     * {@link Layer2InformationParcelable}.
     */
    public static Layer2Information fromStableParcelable(Layer2InformationParcelable p) {
        if (p == null) return null;
        return new Layer2Information(p.l2Key, p.groupHint, p.bssid);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Layer2Information)) return false;
        final Layer2Information other = (Layer2Information) obj;
        return Objects.equals(mL2Key, other.mL2Key)
                && Objects.equals(mGroupHint, other.mGroupHint)
                && Objects.equals(mBssid, other.mBssid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mL2Key, mGroupHint, mBssid);
    }
}
