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

import static com.edevapps.util.UuidUtil.asBytes;
import static com.edevapps.util.UuidUtil.asUuid;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.nio.ByteBuffer;
import java.util.UUID;
import org.junit.Test;

public class UuidUtilTest {

  private static final String UUID_STR = "123e4567-e89b-42d3-a456-556642447896";
  private static final byte[] UUID_BYTES;
  private static final UUID TEST_UUID;

  static {
    TEST_UUID = UUID.fromString(UUID_STR);
    ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
    bb.putLong(TEST_UUID.getMostSignificantBits());
    bb.putLong(TEST_UUID.getLeastSignificantBits());
    UUID_BYTES = bb.array();
  }

  @Test
  public void asUuidTest() {
    assertEquals(TEST_UUID,
        asUuid(UUID_BYTES));
  }

  @Test
  public void asBytesTest() {
    assertArrayEquals(UUID_BYTES,
        asBytes(TEST_UUID));
  }
}
