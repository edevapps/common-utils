/*
 *     Copyright (c) 2019, The Eduard Burenkov (http://edevapps.com)
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

import static com.edevapps.util.ReflectionUtil.findField;
import static com.edevapps.util.ReflectionUtil.getFieldValue;
import static com.edevapps.util.ReflectionUtil.newInstance;
import static com.edevapps.util.objects.ReflectionTestBean.PRIVATE_STRING_FIELD_NAME;
import static com.edevapps.util.objects.ReflectionTestBean.STRING_VALUE;
import static java.util.Objects.requireNonNull;
import static org.junit.Assert.assertEquals;

import com.edevapps.util.objects.ReflectionTestBean;
import org.junit.Assert;
import org.junit.Test;

public class ReflectionUtilTest {

  public static final String UNKNOWN_VALUE = "unknown_value";

  @Test(expected = NoSuchFieldException.class)
  public void getFieldValueTest() throws NoSuchFieldException, IllegalAccessException {
    getFieldValue(UNKNOWN_VALUE, new ReflectionTestBean());
    assertEquals(
        getFieldValue(PRIVATE_STRING_FIELD_NAME, new ReflectionTestBean()), STRING_VALUE);
  }

  @Test
  public void findFieldTest() {
    requireNonNull(
        findField(ReflectionTestBean.class, PRIVATE_STRING_FIELD_NAME));
    Assert.assertNull(
        findField(ReflectionTestBean.class, UNKNOWN_VALUE));
  }

  @Test
  public void newInstanceTest() {
    requireNonNull(
        newInstance(ReflectionTestBean.class));
  }
}
