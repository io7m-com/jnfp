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

public final class NFPUnsignedFloatLong
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
  private static final float TWO_P33_M1F;
  private static final float TWO_P34_M1F;
  private static final float TWO_P35_M1F;
  private static final float TWO_P36_M1F;
  private static final float TWO_P37_M1F;
  private static final float TWO_P38_M1F;
  private static final float TWO_P39_M1F;
  private static final float TWO_P40_M1F;
  private static final float TWO_P41_M1F;
  private static final float TWO_P42_M1F;
  private static final float TWO_P43_M1F;
  private static final float TWO_P44_M1F;
  private static final float TWO_P45_M1F;
  private static final float TWO_P46_M1F;
  private static final float TWO_P47_M1F;
  private static final float TWO_P48_M1F;
  private static final float TWO_P49_M1F;
  private static final float TWO_P50_M1F;
  private static final float TWO_P51_M1F;
  private static final float TWO_P52_M1F;
  private static final float TWO_P53_M1F;
  private static final float TWO_P54_M1F;
  private static final float TWO_P55_M1F;
  private static final float TWO_P56_M1F;
  private static final float TWO_P57_M1F;
  private static final float TWO_P58_M1F;
  private static final float TWO_P59_M1F;
  private static final float TWO_P60_M1F;
  private static final float TWO_P61_M1F;
  private static final float TWO_P62_M1F;
  private static final float TWO_P63_M1F;
  private static final float TWO_P64_M1F;

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
    TWO_P33_M1F = 8589934591.0f; // (2 ^ 33) - 1
    TWO_P34_M1F = 17179869183.0f; // (2 ^ 34) - 1
    TWO_P35_M1F = 34359738367.0f; // (2 ^ 35) - 1
    TWO_P36_M1F = 68719476735.0f; // (2 ^ 36) - 1
    TWO_P37_M1F = 137438953471.0f; // (2 ^ 37) - 1
    TWO_P38_M1F = 274877906943.0f; // (2 ^ 38) - 1
    TWO_P39_M1F = 549755813887.0f; // (2 ^ 39) - 1
    TWO_P40_M1F = 1099511627775.0f; // (2 ^ 40) - 1
    TWO_P41_M1F = 2199023255551.0f; // (2 ^ 41) - 1
    TWO_P42_M1F = 4398046511103.0f; // (2 ^ 42) - 1
    TWO_P43_M1F = 8796093022207.0f; // (2 ^ 43) - 1
    TWO_P44_M1F = 17592186044415.0f; // (2 ^ 44) - 1
    TWO_P45_M1F = 35184372088831.0f; // (2 ^ 45) - 1
    TWO_P46_M1F = 70368744177663.0f; // (2 ^ 46) - 1
    TWO_P47_M1F = 140737488355327.0f; // (2 ^ 47) - 1
    TWO_P48_M1F = 281474976710655.0f; // (2 ^ 48) - 1
    TWO_P49_M1F = 562949953421311.0f; // (2 ^ 49) - 1
    TWO_P50_M1F = 1125899906842623.0f; // (2 ^ 50) - 1
    TWO_P51_M1F = 2251799813685247.0f; // (2 ^ 51) - 1
    TWO_P52_M1F = 4503599627370495.0f; // (2 ^ 52) - 1
    TWO_P53_M1F = 9007199254740991.0f; // (2 ^ 53) - 1
    TWO_P54_M1F = 18014398509481983.0f; // (2 ^ 54) - 1
    TWO_P55_M1F = 36028797018963967.0f; // (2 ^ 55) - 1
    TWO_P56_M1F = 72057594037927935.0f; // (2 ^ 56) - 1
    TWO_P57_M1F = 144115188075855871.0f; // (2 ^ 57) - 1
    TWO_P58_M1F = 288230376151711743.0f; // (2 ^ 58) - 1
    TWO_P59_M1F = 576460752303423487.0f; // (2 ^ 59) - 1
    TWO_P60_M1F = 1152921504606846975.0f; // (2 ^ 60) - 1
    TWO_P61_M1F = 2305843009213693951.0f; // (2 ^ 61) - 1
    TWO_P62_M1F = 4611686018427387903.0f; // (2 ^ 62) - 1
    TWO_P63_M1F = 9223372036854775807.0f; // (2 ^ 63) - 1
    TWO_P64_M1F = 18446744073709551615.0f; // (2 ^ 64) - 1
  }

  private NFPUnsignedFloatLong()
  {
    throw new UnreachableCodeException();
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code[0, (2 ^ b) - 1]}
   * @param b A value in the range {@code[2, 32]}
   *
   * @return A floating point value in the range {@code[0, 1]}
   */

  public static float fromUnsignedNormalized(
    final long f,
    final int b)
  {
    final double twobm1 = StrictMath.pow(2.0, (double) b) - 1.0;
    return UnsignedFloat.fromUnsignedLong(f) / (float) twobm1;
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   * @param b A value in the range {@code[2, 32]}
   *
   * @return An unsigned normalized fixed-point value with {@code b} bits of
   * precision
   */

  public static long toUnsignedNormalized(
    final float x,
    final int b)
  {
    final double twobm1 = StrictMath.pow(2.0, (double) b) - 1.0;
    return UnsignedFloat.toUnsignedLong(x * (float) twobm1);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 2 bits of precision
   */

  public static long toUnsignedNormalized2(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P2_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 3 bits of precision
   */

  public static long toUnsignedNormalized3(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P3_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 4 bits of precision
   */

  public static long toUnsignedNormalized4(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P4_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 5 bits of precision
   */

  public static long toUnsignedNormalized5(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P5_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 6 bits of precision
   */

  public static long toUnsignedNormalized6(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P6_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 7 bits of precision
   */

  public static long toUnsignedNormalized7(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P7_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 8 bits of precision
   */

  public static long toUnsignedNormalized8(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P8_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 9 bits of precision
   */

  public static long toUnsignedNormalized9(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P9_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 10 bits of precision
   */

  public static long toUnsignedNormalized10(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P10_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 11 bits of precision
   */

  public static long toUnsignedNormalized11(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P11_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 12 bits of precision
   */

  public static long toUnsignedNormalized12(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P12_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 13 bits of precision
   */

  public static long toUnsignedNormalized13(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P13_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 14 bits of precision
   */

  public static long toUnsignedNormalized14(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P14_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 15 bits of precision
   */

  public static long toUnsignedNormalized15(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P15_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 16 bits of precision
   */

  public static long toUnsignedNormalized16(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P16_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 17 bits of precision
   */

  public static long toUnsignedNormalized17(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P17_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 18 bits of precision
   */

  public static long toUnsignedNormalized18(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P18_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 19 bits of precision
   */

  public static long toUnsignedNormalized19(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P19_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 20 bits of precision
   */

  public static long toUnsignedNormalized20(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P20_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 21 bits of precision
   */

  public static long toUnsignedNormalized21(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P21_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 22 bits of precision
   */

  public static long toUnsignedNormalized22(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P22_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 23 bits of precision
   */

  public static long toUnsignedNormalized23(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P23_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 24 bits of precision
   */

  public static long toUnsignedNormalized24(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P24_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 25 bits of precision
   */

  public static long toUnsignedNormalized25(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P25_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 26 bits of precision
   */

  public static long toUnsignedNormalized26(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P26_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 27 bits of precision
   */

  public static long toUnsignedNormalized27(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P27_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 28 bits of precision
   */

  public static long toUnsignedNormalized28(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P28_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 29 bits of precision
   */

  public static long toUnsignedNormalized29(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P29_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 30 bits of precision
   */

  public static long toUnsignedNormalized30(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P30_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 31 bits of precision
   */

  public static long toUnsignedNormalized31(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P31_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 32 bits of precision
   */

  public static long toUnsignedNormalized32(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P32_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 33 bits of precision
   */

  public static long toUnsignedNormalized33(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P33_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 34 bits of precision
   */

  public static long toUnsignedNormalized34(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P34_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 35 bits of precision
   */

  public static long toUnsignedNormalized35(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P35_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 36 bits of precision
   */

  public static long toUnsignedNormalized36(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P36_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 37 bits of precision
   */

  public static long toUnsignedNormalized37(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P37_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 38 bits of precision
   */

  public static long toUnsignedNormalized38(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P38_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 39 bits of precision
   */

  public static long toUnsignedNormalized39(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P39_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 40 bits of precision
   */

  public static long toUnsignedNormalized40(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P40_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 41 bits of precision
   */

  public static long toUnsignedNormalized41(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P41_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 42 bits of precision
   */

  public static long toUnsignedNormalized42(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P42_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 43 bits of precision
   */

  public static long toUnsignedNormalized43(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P43_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 44 bits of precision
   */

  public static long toUnsignedNormalized44(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P44_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 45 bits of precision
   */

  public static long toUnsignedNormalized45(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P45_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 46 bits of precision
   */

  public static long toUnsignedNormalized46(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P46_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 47 bits of precision
   */

  public static long toUnsignedNormalized47(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P47_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 48 bits of precision
   */

  public static long toUnsignedNormalized48(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P48_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 49 bits of precision
   */

  public static long toUnsignedNormalized49(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P49_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 50 bits of precision
   */

  public static long toUnsignedNormalized50(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P50_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 51 bits of precision
   */

  public static long toUnsignedNormalized51(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P51_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 52 bits of precision
   */

  public static long toUnsignedNormalized52(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P52_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 53 bits of precision
   */

  public static long toUnsignedNormalized53(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P53_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 54 bits of precision
   */

  public static long toUnsignedNormalized54(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P54_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 55 bits of precision
   */

  public static long toUnsignedNormalized55(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P55_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 56 bits of precision
   */

  public static long toUnsignedNormalized56(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P56_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 57 bits of precision
   */

  public static long toUnsignedNormalized57(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P57_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 58 bits of precision
   */

  public static long toUnsignedNormalized58(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P58_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 59 bits of precision
   */

  public static long toUnsignedNormalized59(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P59_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 60 bits of precision
   */

  public static long toUnsignedNormalized60(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P60_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 61 bits of precision
   */

  public static long toUnsignedNormalized61(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P61_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 62 bits of precision
   */

  public static long toUnsignedNormalized62(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P62_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 63 bits of precision
   */

  public static long toUnsignedNormalized63(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P63_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 64 bits of precision
   */

  public static long toUnsignedNormalized64(final float x)
  {
    return UnsignedFloat.toUnsignedLong(x * NFPUnsignedFloatLong.TWO_P64_M1F);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 2) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized2(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P2_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 3) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized3(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P3_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 4) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized4(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P4_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 5) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized5(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P5_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 6) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized6(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P6_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 7) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized7(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P7_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 8) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized8(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P8_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 9) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized9(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P9_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 10) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized10(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P10_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 11) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized11(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P11_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 12) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized12(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P12_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 13) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized13(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P13_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 14) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized14(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P14_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 15) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized15(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P15_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 16) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized16(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P16_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 17) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized17(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P17_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 18) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized18(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P18_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 19) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized19(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P19_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 20) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized20(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P20_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 21) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized21(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P21_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 22) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized22(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P22_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 23) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized23(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P23_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 24) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized24(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P24_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 25) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized25(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P25_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 26) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized26(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P26_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 27) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized27(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P27_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 28) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized28(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P28_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 29) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized29(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P29_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 30) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized30(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P30_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 31) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized31(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P31_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 32) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized32(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P32_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 33) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized33(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P33_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 34) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized34(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P34_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 35) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized35(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P35_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 36) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized36(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P36_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 37) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized37(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P37_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 38) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized38(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P38_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 39) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized39(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P39_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 40) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized40(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P40_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 41) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized41(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P41_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 42) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized42(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P42_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 43) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized43(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P43_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 44) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized44(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P44_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 45) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized45(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P45_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 46) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized46(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P46_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 47) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized47(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P47_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 48) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized48(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P48_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 49) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized49(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P49_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 50) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized50(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P50_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 51) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized51(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P51_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 52) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized52(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P52_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 53) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized53(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P53_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 54) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized54(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P54_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 55) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized55(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P55_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 56) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized56(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P56_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 57) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized57(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P57_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 58) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized58(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P58_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 59) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized59(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P59_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 60) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized60(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P60_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 61) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized61(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P61_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 62) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized62(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P62_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 63) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized63(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P63_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 64) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized64(final long f)
  {
    final float fv = UnsignedFloat.fromUnsignedLong(f);
    return fv / NFPUnsignedFloatLong.TWO_P64_M1F;
  }
}
