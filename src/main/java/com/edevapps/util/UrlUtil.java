/*
 *     Copyright (c) 2018, The Eduard Burenkov (http://edevapps.com)
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package com.edevapps.util;

import java.util.HashMap;
import java.util.Map;

public class UrlUtil {
    
    public static Map<String, String> getQueryProps(String url) {
        String source = AssertUtil.assertNotNull(url, "url");
        int idx = source.indexOf("?");
        if (idx < 0) {
            throw new IllegalStateException("Url value is not contain queries.");
        }
        int len = source.length();
        String temp = source.substring(idx + 1, len);
        String[] gueries = temp.split("&");
        Map<String, String> values = new HashMap<>();
        for (String query : gueries) {
            String[] value = query.split("=");
            if (value.length >= 2) {
                values.put(value[0], value[1]);
            }
        }
        return values;
    }
}
