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

import com.edevapps.Parser;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtil {
    
    public static final String EMPTY_STRING = "";
    
    public static boolean isEmpty(String value) {
        return value == null || value.equals(EMPTY_STRING);
    }
    
    public static String buildString(Collection<?> values, String delimeter) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object value: values) {
            if(stringBuilder.length() > 0) {
                stringBuilder.append(delimeter);
            }
            stringBuilder.append(value);
        }
        return stringBuilder.toString();
    }

    public static String buildString(Collection<?> values, String delimeter, String format) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object value: values) {
            if(stringBuilder.length() > 0) {
                stringBuilder.append(delimeter);
            }
            stringBuilder.append(String.format(format, value));
        }
        return stringBuilder.toString();
    }
    
    public static <T> List<T> toObjects(String value, String delimeter, Parser<T> parser) {
        if (isEmpty(value)) {
            return Collections.emptyList();
        }
        return toStrings(value, delimeter)
          .stream()
          .map(parser::parse)
          .collect(Collectors.toList());
    }
    
    public static List<String> toStrings(String value, String delimeter) {
        if (isEmpty(value)) {
            return Collections.emptyList();
        }
        return Arrays.stream(value.split(delimeter))
          .collect(Collectors.toList());
    }
}
