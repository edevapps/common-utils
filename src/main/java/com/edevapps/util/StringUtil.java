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
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringUtil {

    public static final String EMPTY_STRING = "";

    public static boolean isEmpty(String value) {
        return value == null || value.equals(EMPTY_STRING);
    }

    public static String buildString(Collection<?> values, String delimiter) {
        StringJoiner stringJoiner = new StringJoiner(delimiter);
        for(Object value: values) {
            if(value == null) {
                continue;
            }
            stringJoiner.add(value.toString());
        }
        return stringJoiner.toString();
    }

    public static String buildString(Collection<?> values, String delimiter, String format) {
        StringJoiner stringJoiner = new StringJoiner(delimiter);
        values.forEach(value -> stringJoiner.add(String.format(format, value.toString())));
        return stringJoiner.toString();
    }

    public static <T> List<T> toObjects(String value, String delimiter, Parser<T> parser) {
        if (isEmpty(value)) {
            return Collections.emptyList();
        }
        return toStrings(value, delimiter)
            .stream()
            .map(parser::parse)
            .collect(Collectors.toList());
    }

    public static List<String> toStrings(String value, String delimiter) {
        if (isEmpty(value)) {
            return Collections.emptyList();
        }
        return Arrays.stream(value.split(delimiter))
            .collect(Collectors.toList());
    }

    public static String md5Hash(String input) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new IllegalStateException(e);
        }
        byte[] bytMD5 = digest.digest(input.getBytes());
        BigInteger intNum = new BigInteger(1, bytMD5);
        StringBuilder hc = new StringBuilder(intNum.toString(16));
        while (hc.length() < 32) {
            hc.insert(0, "0");
        }
        return hc.toString();
    }

    public static String cutString(String str, int length) {
        return str != null && str.length() > length ? str.substring(0, length) : str;
    }

    public static String format(String format, Map<String, Object> values) {
        StringBuilder formatter = new StringBuilder(format);
        List<Object> valueList = new ArrayList<>();

        Matcher matcher = Pattern.compile("\\$\\{(\\w+)}").matcher(format);

        while (matcher.find()) {
            String key = matcher.group(1);

            String formatKey = String.format("${%s}", key);
            int index = formatter.indexOf(formatKey);

            if (index != -1) {
                formatter.replace(index, index + formatKey.length(), "%s");
                valueList.add(values.get(key));
            }
        }

        return String.format(formatter.toString(), valueList.toArray());
    }
}
