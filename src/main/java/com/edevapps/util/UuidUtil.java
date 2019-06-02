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

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.UUID;

public class UuidUtil {

  public static UUID asUuid(byte[] bytes) {
    ByteBuffer bb = ByteBuffer.wrap(bytes);
    long firstLong = bb.getLong();
    long secondLong = bb.getLong();
    return new UUID(firstLong, secondLong);
  }

  public static byte[] asBytes(UUID uuid) {
    ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
    bb.putLong(uuid.getMostSignificantBits());
    bb.putLong(uuid.getLeastSignificantBits());
    return bb.array();
  }

  public static String asString(UUID uuid, Charset charset) {
    return new String(asBytes(uuid), charset);
  }

  public static String asString(UUID uuid, String charsetName) {
    try {
      return new String(asBytes(uuid), charsetName);
    } catch (UnsupportedEncodingException e) {
      throw new IllegalArgumentException("Unsupported encoding '" + charsetName + "'.", e);
    }
  }

  public static UUID asUuid(String string, Charset charset) {
    return asUuid(string.getBytes(charset));
  }

  public static UUID asUuid(String string, String charsetName) {
    try {
      return asUuid(string.getBytes(charsetName));
    } catch (UnsupportedEncodingException e) {
      throw new IllegalArgumentException("Unsupported encoding '" + charsetName + "'.", e);
    }
  }
}
