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

public class AssertUtil {
    
    public static final String EMPTY_STRING = "";
    
    public static <T> T assertNotNull(T argument, String name) {
        if (argument == null) {
            throw new IllegalArgumentException(String.format("The %s is not be null.", name));
        }
        return argument;
    }
    
    public static String assertNotNullOrEmpty(String argument, String name) {
        if (argument == null || argument.equals(EMPTY_STRING)) {
            throw new IllegalArgumentException(String.format("The %s is not be null or empty.", name));
        }
        return argument;
    }
    
    public static int assertNegative(int number, String name) {
        if (number < 0) {
            throw new IllegalArgumentException(
              String.format("The %s should not be a negative number.", name));
        }
        return number;
    }
}
