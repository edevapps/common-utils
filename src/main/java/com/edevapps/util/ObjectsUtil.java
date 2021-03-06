/*
 *     Copyright (c) 2018, The Eduard Burenkov. All rights reserved. http://edevapps.com
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

import static com.edevapps.util.StringUtil.EMPTY_STRING;

public class ObjectsUtil {

  public static String requireNonNullOrEmpty(String argument, String name)
      throws IllegalArgumentException {
    if (argument == null || argument.equals(EMPTY_STRING)) {
      throw new IllegalArgumentException(String.format("The %s is not be null or empty.", name));
    }
    return argument;
  }

  public static <T> T requireNonNull(T argument, String name) throws NullPointerException {
    return java.util.Objects
        .requireNonNull(argument, String.format("The %s is not be null.", name));
  }

  public static int requireNonNegative(int number, String name) throws IllegalArgumentException {
    if (number < 0) {
      throw new IllegalArgumentException(
          String.format("The %s should not be a negative number.", name));
    }
    return number;
  }
}
