/*
 * Copyright © 2015 <code@io7m.com> http://io7m.com
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY
 * SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF OR
 * IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */

package com.io7m.jnfp.core;

import com.io7m.junreachable.UnreachableCodeException;
import com.io7m.junsigned.core.UnsignedFloat;

/**
 * <p>Conversion of unsigned normalized fixed-point values to and from floating
 * point values.</p>
 *
 * <p>The OpenGL 3.3 specification defines the conversion from floating point
 * values {@code x} (implied to be in the range {@code [0, 1]}) to unsigned
 * normalized fixed-point values {@code f}, with {@code b} bits of precision,
 * as:</p>
 *
 * <pre>
 * f = x * (pow(2, b) - 1)
 * </pre>
 *
 * <p>The specification defines the conversion from unsigned normalized
 * fixed-point values {@code f} with {@code b} bits of precision to floating
 * point values {@code x} as:</p>
 *
 * <pre>
 * x = f / (pow(2, b) - 1)
 * </pre>
 *
 * <p>This implementation provides general conversion functions that operate on
 * arbitrary values of {@code b}, and specialized functions that operate for
 * specific values of {@code b} using precomputed terms.</p>
 */

public final class NFPUnsignedFloatInt
{
  private static final float TWO_P2_M1F;
  private static final float TWO_P3_M1F;
  private static final float TWO_P4_M1F;
  private static final float TWO_P5_M1F;
  private static final float TWO_P6_M1F;
  private static final float TWO_P7_M1F;
  private static final float TWO_P8_M1F;
  private static final float TWO_P9_M1F;
  private static final float TWO_P10_M1F;
  private static final float TWO_P11_M1F;
  private static final float TWO_P12_M1F;
  private static final float TWO_P13_M1F;
  private static final float TWO_P14_M1F;
  private static final float TWO_P15_M1F;
  private static final float TWO_P16_M1F;
  private static final float TWO_P17_M1F;
  private static final float TWO_P18_M1F;
  private static final float TWO_P19_M1F;
  private static final float TWO_P20_M1F;
  private static final float TWO_P21_M1F;
  private static final float TWO_P22_M1F;
  private static final float TWO_P23_M1F;
  private static final float TWO_P24_M1F;
  private static final float TWO_P25_M1F;
  private static final float TWO_P26_M1F;
  private static final float TWO_P27_M1F;
  private static final float TWO_P28_M1F;
  private static final float TWO_P29_M1F;
  private static final float TWO_P30_M1F;
  private static final float TWO_P31_M1F;
  private static final float TWO_P32_M1F;

  static {
    TWO_P2_M1F = 3.0f; // (2 ^ 2) - 1
    TWO_P3_M1F = 7.0f; // (2 ^ 3) - 1
    TWO_P4_M1F = 15.0f; // (2 ^ 4) - 1
    TWO_P5_M1F = 31.0f; // (2 ^ 5) - 1
    TWO_P6_M1F = 63.0f; // (2 ^ 6) - 1
    TWO_P7_M1F = 127.0f; // (2 ^ 7) - 1
    TWO_P8_M1F = 255.0f; // (2 ^ 8) - 1
    TWO_P9_M1F = 511.0f; // (2 ^ 9) - 1
    TWO_P10_M1F = 1023.0f; // (2 ^ 10) - 1
    TWO_P11_M1F = 2047.0f; // (2 ^ 11) - 1
    TWO_P12_M1F = 4095.0f; // (2 ^ 12) - 1
    TWO_P13_M1F = 8191.0f; // (2 ^ 13) - 1
    TWO_P14_M1F = 16383.0f; // (2 ^ 14) - 1
    TWO_P15_M1F = 32767.0f; // (2 ^ 15) - 1
    TWO_P16_M1F = 65535.0f; // (2 ^ 16) - 1
    TWO_P17_M1F = 131071.0f; // (2 ^ 17) - 1
    TWO_P18_M1F = 262143.0f; // (2 ^ 18) - 1
    TWO_P19_M1F = 524287.0f; // (2 ^ 19) - 1
    TWO_P20_M1F = 1048575.0f; // (2 ^ 20) - 1
    TWO_P21_M1F = 2097151.0f; // (2 ^ 21) - 1
    TWO_P22_M1F = 4194303.0f; // (2 ^ 22) - 1
    TWO_P23_M1F = 8388607.0f; // (2 ^ 23) - 1
    TWO_P24_M1F = 16777215.0f; // (2 ^ 24) - 1
    TWO_P25_M1F = 33554431.0f; // (2 ^ 25) - 1
    TWO_P26_M1F = 67108863.0f; // (2 ^ 26) - 1
    TWO_P27_M1F = 134217727.0f; // (2 ^ 27) - 1
    TWO_P28_M1F = 268435455.0f; // (2 ^ 28) - 1
    TWO_P29_M1F = 536870911.0f; // (2 ^ 29) - 1
    TWO_P30_M1F = 1073741823.0f; // (2 ^ 30) - 1
    TWO_P31_M1F = 2147483647.0f; // (2 ^ 31) - 1
    TWO_P32_M1F = 4294967295.0f; // (2 ^ 32) - 1
  }

  private NFPUnsignedFloatInt()
  {
    throw new UnreachableCodeException();
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ b) - 1]}
   * @param b A value in the range {@code [2, 32]}
   *
   * @return A floating point value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized(
    final int f,
    final int b)
  {
    final double twobm1 = StrictMath.pow(2.0, (double) b) - 1.0;
    return UnsignedFloat.fromUnsignedInt(f) / (float) twobm1;
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   * @param b A value in the range {@code [2, 32]}
   *
   * @return An unsigned normalized fixed-point value with {@code b} bits of
   * precision
   */

  public static int toUnsignedNormalized(
    final float x,
    final int b)
  {
    final double twobm1 = StrictMath.pow(2.0, (double) b) - 1.0;
    return UnsignedFloat.toUnsignedInt(x * (float) twobm1);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 2 bits of precision
   */

  public static int toUnsignedNormalized2(final float x)
  {
    return UnsignedFloat.toUnsignedInt(x * NFPUnsignedFloatInt.TWO_P2_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 3 bits of precision
   */

  public static int toUnsignedNormalized3(final float x)
  {
    return UnsignedFloat.toUnsignedInt(x * NFPUnsignedFloatInt.TWO_P3_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 4 bits of precision
   */

  public static int toUnsignedNormalized4(final float x)
  {
    return UnsignedFloat.toUnsignedInt(x * NFPUnsignedFloatInt.TWO_P4_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 5 bits of precision
   */

  public static int toUnsignedNormalized5(final float x)
  {
    return UnsignedFloat.toUnsignedInt(x * NFPUnsignedFloatInt.TWO_P5_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 6 bits of precision
   */

  public static int toUnsignedNormalized6(final float x)
  {
    return UnsignedFloat.toUnsignedInt(x * NFPUnsignedFloatInt.TWO_P6_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 7 bits of precision
   */

  public static int toUnsignedNormalized7(final float x)
  {
    return UnsignedFloat.toUnsignedInt(x * NFPUnsignedFloatInt.TWO_P7_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 8 bits of precision
   */

  public static int toUnsignedNormalized8(final float x)
  {
    return UnsignedFloat.toUnsignedInt(x * NFPUnsignedFloatInt.TWO_P8_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 9 bits of precision
   */

  public static int toUnsignedNormalized9(final float x)
  {
    return UnsignedFloat.toUnsignedInt(x * NFPUnsignedFloatInt.TWO_P9_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 10 bits of precision
   */

  public static int toUnsignedNormalized10(final float x)
  {
    return UnsignedFloat.toUnsignedInt(x * NFPUnsignedFloatInt.TWO_P10_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 11 bits of precision
   */

  public static int toUnsignedNormalized11(final float x)
  {
    return UnsignedFloat.toUnsignedInt(x * NFPUnsignedFloatInt.TWO_P11_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 12 bits of precision
   */

  public static int toUnsignedNormalized12(final float x)
  {
    return UnsignedFloat.toUnsignedInt(x * NFPUnsignedFloatInt.TWO_P12_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 13 bits of precision
   */

  public static int toUnsignedNormalized13(final float x)
  {
    return UnsignedFloat.toUnsignedInt(x * NFPUnsignedFloatInt.TWO_P13_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 14 bits of precision
   */

  public static int toUnsignedNormalized14(final float x)
  {
    return UnsignedFloat.toUnsignedInt(x * NFPUnsignedFloatInt.TWO_P14_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 15 bits of precision
   */

  public static int toUnsignedNormalized15(final float x)
  {
    return UnsignedFloat.toUnsignedInt(x * NFPUnsignedFloatInt.TWO_P15_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 16 bits of precision
   */

  public static int toUnsignedNormalized16(final float x)
  {
    return UnsignedFloat.toUnsignedInt(x * NFPUnsignedFloatInt.TWO_P16_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 17 bits of precision
   */

  public static int toUnsignedNormalized17(final float x)
  {
    return UnsignedFloat.toUnsignedInt(x * NFPUnsignedFloatInt.TWO_P17_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 18 bits of precision
   */

  public static int toUnsignedNormalized18(final float x)
  {
    return UnsignedFloat.toUnsignedInt(x * NFPUnsignedFloatInt.TWO_P18_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 19 bits of precision
   */

  public static int toUnsignedNormalized19(final float x)
  {
    return UnsignedFloat.toUnsignedInt(x * NFPUnsignedFloatInt.TWO_P19_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 20 bits of precision
   */

  public static int toUnsignedNormalized20(final float x)
  {
    return UnsignedFloat.toUnsignedInt(x * NFPUnsignedFloatInt.TWO_P20_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 21 bits of precision
   */

  public static int toUnsignedNormalized21(final float x)
  {
    return UnsignedFloat.toUnsignedInt(x * NFPUnsignedFloatInt.TWO_P21_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 22 bits of precision
   */

  public static int toUnsignedNormalized22(final float x)
  {
    return UnsignedFloat.toUnsignedInt(x * NFPUnsignedFloatInt.TWO_P22_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 23 bits of precision
   */

  public static int toUnsignedNormalized23(final float x)
  {
    return UnsignedFloat.toUnsignedInt(x * NFPUnsignedFloatInt.TWO_P23_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 24 bits of precision
   */

  public static int toUnsignedNormalized24(final float x)
  {
    return UnsignedFloat.toUnsignedInt(x * NFPUnsignedFloatInt.TWO_P24_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 25 bits of precision
   */

  public static int toUnsignedNormalized25(final float x)
  {
    return UnsignedFloat.toUnsignedInt(x * NFPUnsignedFloatInt.TWO_P25_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 26 bits of precision
   */

  public static int toUnsignedNormalized26(final float x)
  {
    return UnsignedFloat.toUnsignedInt(x * NFPUnsignedFloatInt.TWO_P26_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 27 bits of precision
   */

  public static int toUnsignedNormalized27(final float x)
  {
    return UnsignedFloat.toUnsignedInt(x * NFPUnsignedFloatInt.TWO_P27_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 28 bits of precision
   */

  public static int toUnsignedNormalized28(final float x)
  {
    return UnsignedFloat.toUnsignedInt(x * NFPUnsignedFloatInt.TWO_P28_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 29 bits of precision
   */

  public static int toUnsignedNormalized29(final float x)
  {
    return UnsignedFloat.toUnsignedInt(x * NFPUnsignedFloatInt.TWO_P29_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 30 bits of precision
   */

  public static int toUnsignedNormalized30(final float x)
  {
    return UnsignedFloat.toUnsignedInt(x * NFPUnsignedFloatInt.TWO_P30_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 31 bits of precision
   */

  public static int toUnsignedNormalized31(final float x)
  {
    return UnsignedFloat.toUnsignedInt(x * NFPUnsignedFloatInt.TWO_P31_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 32 bits of precision
   */

  public static int toUnsignedNormalized32(final float x)
  {
    return UnsignedFloat.toUnsignedInt(x * NFPUnsignedFloatInt.TWO_P32_M1F);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 2) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized2(final int f)
  {
    final float fv = UnsignedFloat.fromUnsignedInt(f);
    return fv / NFPUnsignedFloatInt.TWO_P2_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 3) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized3(final int f)
  {
    final float fv = UnsignedFloat.fromUnsignedInt(f);
    return fv / NFPUnsignedFloatInt.TWO_P3_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 4) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized4(final int f)
  {
    final float fv = UnsignedFloat.fromUnsignedInt(f);
    return fv / NFPUnsignedFloatInt.TWO_P4_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 5) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized5(final int f)
  {
    final float fv = UnsignedFloat.fromUnsignedInt(f);
    return fv / NFPUnsignedFloatInt.TWO_P5_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 6) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized6(final int f)
  {
    final float fv = UnsignedFloat.fromUnsignedInt(f);
    return fv / NFPUnsignedFloatInt.TWO_P6_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 7) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized7(final int f)
  {
    final float fv = UnsignedFloat.fromUnsignedInt(f);
    return fv / NFPUnsignedFloatInt.TWO_P7_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 8) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized8(final int f)
  {
    final float fv = UnsignedFloat.fromUnsignedInt(f);
    return fv / NFPUnsignedFloatInt.TWO_P8_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 9) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized9(final int f)
  {
    final float fv = UnsignedFloat.fromUnsignedInt(f);
    return fv / NFPUnsignedFloatInt.TWO_P9_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 10) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized10(final int f)
  {
    final float fv = UnsignedFloat.fromUnsignedInt(f);
    return fv / NFPUnsignedFloatInt.TWO_P10_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 11) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized11(final int f)
  {
    final float fv = UnsignedFloat.fromUnsignedInt(f);
    return fv / NFPUnsignedFloatInt.TWO_P11_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 12) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized12(final int f)
  {
    final float fv = UnsignedFloat.fromUnsignedInt(f);
    return fv / NFPUnsignedFloatInt.TWO_P12_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 13) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized13(final int f)
  {
    final float fv = UnsignedFloat.fromUnsignedInt(f);
    return fv / NFPUnsignedFloatInt.TWO_P13_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 14) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized14(final int f)
  {
    final float fv = UnsignedFloat.fromUnsignedInt(f);
    return fv / NFPUnsignedFloatInt.TWO_P14_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 15) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized15(final int f)
  {
    final float fv = UnsignedFloat.fromUnsignedInt(f);
    return fv / NFPUnsignedFloatInt.TWO_P15_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 16) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized16(final int f)
  {
    final float fv = UnsignedFloat.fromUnsignedInt(f);
    return fv / NFPUnsignedFloatInt.TWO_P16_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 17) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized17(final int f)
  {
    final float fv = UnsignedFloat.fromUnsignedInt(f);
    return fv / NFPUnsignedFloatInt.TWO_P17_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 18) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized18(final int f)
  {
    final float fv = UnsignedFloat.fromUnsignedInt(f);
    return fv / NFPUnsignedFloatInt.TWO_P18_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 19) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized19(final int f)
  {
    final float fv = UnsignedFloat.fromUnsignedInt(f);
    return fv / NFPUnsignedFloatInt.TWO_P19_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 20) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized20(final int f)
  {
    final float fv = UnsignedFloat.fromUnsignedInt(f);
    return fv / NFPUnsignedFloatInt.TWO_P20_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 21) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized21(final int f)
  {
    final float fv = UnsignedFloat.fromUnsignedInt(f);
    return fv / NFPUnsignedFloatInt.TWO_P21_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 22) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized22(final int f)
  {
    final float fv = UnsignedFloat.fromUnsignedInt(f);
    return fv / NFPUnsignedFloatInt.TWO_P22_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 23) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized23(final int f)
  {
    final float fv = UnsignedFloat.fromUnsignedInt(f);
    return fv / NFPUnsignedFloatInt.TWO_P23_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 24) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized24(final int f)
  {
    final float fv = UnsignedFloat.fromUnsignedInt(f);
    return fv / NFPUnsignedFloatInt.TWO_P24_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 25) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized25(final int f)
  {
    final float fv = UnsignedFloat.fromUnsignedInt(f);
    return fv / NFPUnsignedFloatInt.TWO_P25_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 26) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized26(final int f)
  {
    final float fv = UnsignedFloat.fromUnsignedInt(f);
    return fv / NFPUnsignedFloatInt.TWO_P26_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 27) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized27(final int f)
  {
    final float fv = UnsignedFloat.fromUnsignedInt(f);
    return fv / NFPUnsignedFloatInt.TWO_P27_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 28) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized28(final int f)
  {
    final float fv = UnsignedFloat.fromUnsignedInt(f);
    return fv / NFPUnsignedFloatInt.TWO_P28_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 29) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized29(final int f)
  {
    final float fv = UnsignedFloat.fromUnsignedInt(f);
    return fv / NFPUnsignedFloatInt.TWO_P29_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 30) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized30(final int f)
  {
    final float fv = UnsignedFloat.fromUnsignedInt(f);
    return fv / NFPUnsignedFloatInt.TWO_P30_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 31) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized31(final int f)
  {
    final float fv = UnsignedFloat.fromUnsignedInt(f);
    return fv / NFPUnsignedFloatInt.TWO_P31_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 32) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized32(final int f)
  {
    final float fv = UnsignedFloat.fromUnsignedInt(f);
    return fv / NFPUnsignedFloatInt.TWO_P32_M1F;
  }
}
