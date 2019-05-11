/*
 *     Copyright (c) 2019, The Eduard Burenkov. All rights reserved. http://edevapps.com
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

import static com.edevapps.util.StringUtil.buildString;
import static com.edevapps.util.StringUtil.cutString;
import static com.edevapps.util.StringUtil.isEmpty;
import static com.edevapps.util.StringUtil.toStrings;
import static java.util.Objects.requireNonNull;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

import com.edevapps.Parser;
import com.edevapps.util.objects.ReflectionTestBean;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class StringUtilTest {

  private static final String EMPTY_STRING = "";
  private static final String NULL_STRING = null;
  private static final String STRING_1 = "sv1";
  private static final String STRING_2 = "sv2";
  private static final String DELIMITER = ",";
  private static final String KEY_1 = "sk1";
  private static final String KEY_2 = "sk2";

  @Test
  public void isEmptyTest() {
    assertTrue(
        isEmpty(EMPTY_STRING));
    assertTrue(
        isEmpty(NULL_STRING));
  }

  @Test
  public void buildStringTest() {
    Collection<String> values = new ArrayList<>();
    values.add(STRING_1);
    values.add(STRING_2);
    assertEquals(
        buildString(values, DELIMITER), STRING_1 + DELIMITER + STRING_2);
  }

  @Test
  public void buildString2Test() {
    Collection<String> values = new ArrayList<>();
    values.add(STRING_1);
    values.add(STRING_2);
    String format = "{%s}";
    assertEquals(
        buildString(values, DELIMITER, format),
        String.format(format, STRING_1) +
            DELIMITER +
            String.format(format, STRING_2));
  }

  @Test
  public void toObjectsTest() {
    Parser<ReflectionTestBean> parser = ReflectionTestBean::new;
    List<ReflectionTestBean> list = StringUtil
        .toObjects(STRING_1 + DELIMITER + STRING_2, DELIMITER, parser);
    assertEquals(list.size(), 2);
    requireNonNull(list.get(0));
    requireNonNull(list.get(1));
    assertEquals(list.get(0).getStringField(), STRING_1);
    assertEquals(list.get(1).getStringField(), STRING_2);
  }

  @Test
  public void toStringsTest() {
    List<String> list = toStrings(STRING_1 + DELIMITER + STRING_2, DELIMITER);
    assertEquals(list.size(), 2);
    assertEquals(list.get(0), STRING_1);
    assertEquals(list.get(1), STRING_2);
  }

  @Test
  public void cutStringTest() {
    assertEquals(
        cutString(STRING_1 + STRING_2, STRING_2.length()), STRING_1);
  }

  @Test
  public void formatTest() {
    Map<String, Object> values = new HashMap<>();
    values.put(KEY_1, 0);
    values.put(KEY_2, 1);
    String format = STRING_1 + "${" + KEY_1 + "}" + STRING_2 + "${" + KEY_2 + "}";
    assertEquals(
        StringUtil.format(format, values), STRING_1 + "0" + STRING_2 + "1");
  }
}
