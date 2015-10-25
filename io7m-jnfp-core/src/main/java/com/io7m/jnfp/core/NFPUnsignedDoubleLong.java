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
import com.io7m.junsigned.core.UnsignedDouble;

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

public final class NFPUnsignedDoubleLong
{
  private static final double TWO_P2_M1D;
  private static final double TWO_P3_M1D;
  private static final double TWO_P4_M1D;
  private static final double TWO_P5_M1D;
  private static final double TWO_P6_M1D;
  private static final double TWO_P7_M1D;
  private static final double TWO_P8_M1D;
  private static final double TWO_P9_M1D;
  private static final double TWO_P10_M1D;
  private static final double TWO_P11_M1D;
  private static final double TWO_P12_M1D;
  private static final double TWO_P13_M1D;
  private static final double TWO_P14_M1D;
  private static final double TWO_P15_M1D;
  private static final double TWO_P16_M1D;
  private static final double TWO_P17_M1D;
  private static final double TWO_P18_M1D;
  private static final double TWO_P19_M1D;
  private static final double TWO_P20_M1D;
  private static final double TWO_P21_M1D;
  private static final double TWO_P22_M1D;
  private static final double TWO_P23_M1D;
  private static final double TWO_P24_M1D;
  private static final double TWO_P25_M1D;
  private static final double TWO_P26_M1D;
  private static final double TWO_P27_M1D;
  private static final double TWO_P28_M1D;
  private static final double TWO_P29_M1D;
  private static final double TWO_P30_M1D;
  private static final double TWO_P31_M1D;
  private static final double TWO_P32_M1D;
  private static final double TWO_P33_M1D;
  private static final double TWO_P34_M1D;
  private static final double TWO_P35_M1D;
  private static final double TWO_P36_M1D;
  private static final double TWO_P37_M1D;
  private static final double TWO_P38_M1D;
  private static final double TWO_P39_M1D;
  private static final double TWO_P40_M1D;
  private static final double TWO_P41_M1D;
  private static final double TWO_P42_M1D;
  private static final double TWO_P43_M1D;
  private static final double TWO_P44_M1D;
  private static final double TWO_P45_M1D;
  private static final double TWO_P46_M1D;
  private static final double TWO_P47_M1D;
  private static final double TWO_P48_M1D;
  private static final double TWO_P49_M1D;
  private static final double TWO_P50_M1D;
  private static final double TWO_P51_M1D;
  private static final double TWO_P52_M1D;
  private static final double TWO_P53_M1D;
  private static final double TWO_P54_M1D;
  private static final double TWO_P55_M1D;
  private static final double TWO_P56_M1D;
  private static final double TWO_P57_M1D;
  private static final double TWO_P58_M1D;
  private static final double TWO_P59_M1D;
  private static final double TWO_P60_M1D;
  private static final double TWO_P61_M1D;
  private static final double TWO_P62_M1D;
  private static final double TWO_P63_M1D;
  private static final double TWO_P64_M1D;

  static {
    TWO_P2_M1D = 3.0; // (2 ^ 2) - 1
    TWO_P3_M1D = 7.0; // (2 ^ 3) - 1
    TWO_P4_M1D = 15.0; // (2 ^ 4) - 1
    TWO_P5_M1D = 31.0; // (2 ^ 5) - 1
    TWO_P6_M1D = 63.0; // (2 ^ 6) - 1
    TWO_P7_M1D = 127.0; // (2 ^ 7) - 1
    TWO_P8_M1D = 255.0; // (2 ^ 8) - 1
    TWO_P9_M1D = 511.0; // (2 ^ 9) - 1
    TWO_P10_M1D = 1023.0; // (2 ^ 10) - 1
    TWO_P11_M1D = 2047.0; // (2 ^ 11) - 1
    TWO_P12_M1D = 4095.0; // (2 ^ 12) - 1
    TWO_P13_M1D = 8191.0; // (2 ^ 13) - 1
    TWO_P14_M1D = 16383.0; // (2 ^ 14) - 1
    TWO_P15_M1D = 32767.0; // (2 ^ 15) - 1
    TWO_P16_M1D = 65535.0; // (2 ^ 16) - 1
    TWO_P17_M1D = 131071.0; // (2 ^ 17) - 1
    TWO_P18_M1D = 262143.0; // (2 ^ 18) - 1
    TWO_P19_M1D = 524287.0; // (2 ^ 19) - 1
    TWO_P20_M1D = 1048575.0; // (2 ^ 20) - 1
    TWO_P21_M1D = 2097151.0; // (2 ^ 21) - 1
    TWO_P22_M1D = 4194303.0; // (2 ^ 22) - 1
    TWO_P23_M1D = 8388607.0; // (2 ^ 23) - 1
    TWO_P24_M1D = 16777215.0; // (2 ^ 24) - 1
    TWO_P25_M1D = 33554431.0; // (2 ^ 25) - 1
    TWO_P26_M1D = 67108863.0; // (2 ^ 26) - 1
    TWO_P27_M1D = 134217727.0; // (2 ^ 27) - 1
    TWO_P28_M1D = 268435455.0; // (2 ^ 28) - 1
    TWO_P29_M1D = 536870911.0; // (2 ^ 29) - 1
    TWO_P30_M1D = 1073741823.0; // (2 ^ 30) - 1
    TWO_P31_M1D = 2147483647.0; // (2 ^ 31) - 1
    TWO_P32_M1D = 4294967295.0; // (2 ^ 32) - 1
    TWO_P33_M1D = 8589934591.0; // (2 ^ 33) - 1
    TWO_P34_M1D = 17179869183.0; // (2 ^ 34) - 1
    TWO_P35_M1D = 34359738367.0; // (2 ^ 35) - 1
    TWO_P36_M1D = 68719476735.0; // (2 ^ 36) - 1
    TWO_P37_M1D = 137438953471.0; // (2 ^ 37) - 1
    TWO_P38_M1D = 274877906943.0; // (2 ^ 38) - 1
    TWO_P39_M1D = 549755813887.0; // (2 ^ 39) - 1
    TWO_P40_M1D = 1099511627775.0; // (2 ^ 40) - 1
    TWO_P41_M1D = 2199023255551.0; // (2 ^ 41) - 1
    TWO_P42_M1D = 4398046511103.0; // (2 ^ 42) - 1
    TWO_P43_M1D = 8796093022207.0; // (2 ^ 43) - 1
    TWO_P44_M1D = 17592186044415.0; // (2 ^ 44) - 1
    TWO_P45_M1D = 35184372088831.0; // (2 ^ 45) - 1
    TWO_P46_M1D = 70368744177663.0; // (2 ^ 46) - 1
    TWO_P47_M1D = 140737488355327.0; // (2 ^ 47) - 1
    TWO_P48_M1D = 281474976710655.0; // (2 ^ 48) - 1
    TWO_P49_M1D = 562949953421311.0; // (2 ^ 49) - 1
    TWO_P50_M1D = 1125899906842623.0; // (2 ^ 50) - 1
    TWO_P51_M1D = 2251799813685247.0; // (2 ^ 51) - 1
    TWO_P52_M1D = 4503599627370495.0; // (2 ^ 52) - 1
    TWO_P53_M1D = 9007199254740991.0; // (2 ^ 53) - 1
    TWO_P54_M1D = 18014398509481983.0; // (2 ^ 54) - 1
    TWO_P55_M1D = 36028797018963967.0; // (2 ^ 55) - 1
    TWO_P56_M1D = 72057594037927935.0; // (2 ^ 56) - 1
    TWO_P57_M1D = 144115188075855871.0; // (2 ^ 57) - 1
    TWO_P58_M1D = 288230376151711743.0; // (2 ^ 58) - 1
    TWO_P59_M1D = 576460752303423487.0; // (2 ^ 59) - 1
    TWO_P60_M1D = 1152921504606846975.0; // (2 ^ 60) - 1
    TWO_P61_M1D = 2305843009213693951.0; // (2 ^ 61) - 1
    TWO_P62_M1D = 4611686018427387903.0; // (2 ^ 62) - 1
    TWO_P63_M1D = 9223372036854775807.0; // (2 ^ 63) - 1
    TWO_P64_M1D = 18446744073709551615.0; // (2 ^ 64) - 1
  }

  private NFPUnsignedDoubleLong()
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

  public static double fromUnsignedNormalized(
    final long f,
    final int b)
  {
    final double twobm1 = StrictMath.pow(2.0, (double) b) - 1.0;
    return UnsignedDouble.fromUnsignedLong(f) / twobm1;
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
    final double x,
    final int b)
  {
    final double twobm1 = StrictMath.pow(2.0, (double) b) - 1.0;
    return UnsignedDouble.toUnsignedLong(x * twobm1);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 2 bits of precision
   */

  public static long toUnsignedNormalized2(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P2_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 3 bits of precision
   */

  public static long toUnsignedNormalized3(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P3_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 4 bits of precision
   */

  public static long toUnsignedNormalized4(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P4_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 5 bits of precision
   */

  public static long toUnsignedNormalized5(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P5_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 6 bits of precision
   */

  public static long toUnsignedNormalized6(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P6_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 7 bits of precision
   */

  public static long toUnsignedNormalized7(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P7_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 8 bits of precision
   */

  public static long toUnsignedNormalized8(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P8_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 9 bits of precision
   */

  public static long toUnsignedNormalized9(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P9_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 10 bits of precision
   */

  public static long toUnsignedNormalized10(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P10_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 11 bits of precision
   */

  public static long toUnsignedNormalized11(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P11_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 12 bits of precision
   */

  public static long toUnsignedNormalized12(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P12_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 13 bits of precision
   */

  public static long toUnsignedNormalized13(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P13_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 14 bits of precision
   */

  public static long toUnsignedNormalized14(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P14_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 15 bits of precision
   */

  public static long toUnsignedNormalized15(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P15_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 16 bits of precision
   */

  public static long toUnsignedNormalized16(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P16_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 17 bits of precision
   */

  public static long toUnsignedNormalized17(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P17_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 18 bits of precision
   */

  public static long toUnsignedNormalized18(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P18_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 19 bits of precision
   */

  public static long toUnsignedNormalized19(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P19_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 20 bits of precision
   */

  public static long toUnsignedNormalized20(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P20_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 21 bits of precision
   */

  public static long toUnsignedNormalized21(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P21_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 22 bits of precision
   */

  public static long toUnsignedNormalized22(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P22_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 23 bits of precision
   */

  public static long toUnsignedNormalized23(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P23_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 24 bits of precision
   */

  public static long toUnsignedNormalized24(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P24_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 25 bits of precision
   */

  public static long toUnsignedNormalized25(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P25_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 26 bits of precision
   */

  public static long toUnsignedNormalized26(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P26_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 27 bits of precision
   */

  public static long toUnsignedNormalized27(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P27_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 28 bits of precision
   */

  public static long toUnsignedNormalized28(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P28_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 29 bits of precision
   */

  public static long toUnsignedNormalized29(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P29_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 30 bits of precision
   */

  public static long toUnsignedNormalized30(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P30_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 31 bits of precision
   */

  public static long toUnsignedNormalized31(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P31_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 32 bits of precision
   */

  public static long toUnsignedNormalized32(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P32_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 33 bits of precision
   */

  public static long toUnsignedNormalized33(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P33_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 34 bits of precision
   */

  public static long toUnsignedNormalized34(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P34_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 35 bits of precision
   */

  public static long toUnsignedNormalized35(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P35_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 36 bits of precision
   */

  public static long toUnsignedNormalized36(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P36_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 37 bits of precision
   */

  public static long toUnsignedNormalized37(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P37_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 38 bits of precision
   */

  public static long toUnsignedNormalized38(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P38_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 39 bits of precision
   */

  public static long toUnsignedNormalized39(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P39_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 40 bits of precision
   */

  public static long toUnsignedNormalized40(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P40_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 41 bits of precision
   */

  public static long toUnsignedNormalized41(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P41_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 42 bits of precision
   */

  public static long toUnsignedNormalized42(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P42_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 43 bits of precision
   */

  public static long toUnsignedNormalized43(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P43_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 44 bits of precision
   */

  public static long toUnsignedNormalized44(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P44_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 45 bits of precision
   */

  public static long toUnsignedNormalized45(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P45_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 46 bits of precision
   */

  public static long toUnsignedNormalized46(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P46_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 47 bits of precision
   */

  public static long toUnsignedNormalized47(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P47_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 48 bits of precision
   */

  public static long toUnsignedNormalized48(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P48_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 49 bits of precision
   */

  public static long toUnsignedNormalized49(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P49_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 50 bits of precision
   */

  public static long toUnsignedNormalized50(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P50_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 51 bits of precision
   */

  public static long toUnsignedNormalized51(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P51_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 52 bits of precision
   */

  public static long toUnsignedNormalized52(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P52_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 53 bits of precision
   */

  public static long toUnsignedNormalized53(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P53_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 54 bits of precision
   */

  public static long toUnsignedNormalized54(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P54_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 55 bits of precision
   */

  public static long toUnsignedNormalized55(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P55_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 56 bits of precision
   */

  public static long toUnsignedNormalized56(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P56_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 57 bits of precision
   */

  public static long toUnsignedNormalized57(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P57_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 58 bits of precision
   */

  public static long toUnsignedNormalized58(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P58_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 59 bits of precision
   */

  public static long toUnsignedNormalized59(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P59_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 60 bits of precision
   */

  public static long toUnsignedNormalized60(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P60_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 61 bits of precision
   */

  public static long toUnsignedNormalized61(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P61_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 62 bits of precision
   */

  public static long toUnsignedNormalized62(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P62_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 63 bits of precision
   */

  public static long toUnsignedNormalized63(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P63_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 64 bits of precision
   */

  public static long toUnsignedNormalized64(final double x)
  {
    return UnsignedDouble.toUnsignedLong(x * NFPUnsignedDoubleLong.TWO_P64_M1D);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 2) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized2(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P2_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 3) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized3(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P3_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 4) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized4(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P4_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 5) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized5(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P5_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 6) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized6(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P6_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 7) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized7(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P7_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 8) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized8(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P8_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 9) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized9(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P9_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 10) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized10(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P10_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 11) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized11(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P11_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 12) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized12(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P12_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 13) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized13(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P13_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 14) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized14(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P14_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 15) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized15(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P15_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 16) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized16(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P16_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 17) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized17(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P17_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 18) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized18(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P18_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 19) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized19(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P19_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 20) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized20(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P20_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 21) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized21(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P21_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 22) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized22(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P22_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 23) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized23(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P23_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 24) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized24(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P24_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 25) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized25(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P25_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 26) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized26(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P26_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 27) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized27(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P27_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 28) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized28(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P28_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 29) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized29(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P29_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 30) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized30(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P30_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 31) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized31(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P31_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 32) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized32(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P32_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 33) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized33(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P33_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 34) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized34(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P34_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 35) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized35(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P35_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 36) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized36(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P36_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 37) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized37(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P37_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 38) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized38(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P38_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 39) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized39(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P39_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 40) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized40(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P40_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 41) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized41(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P41_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 42) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized42(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P42_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 43) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized43(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P43_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 44) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized44(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P44_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 45) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized45(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P45_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 46) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized46(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P46_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 47) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized47(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P47_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 48) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized48(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P48_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 49) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized49(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P49_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 50) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized50(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P50_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 51) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized51(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P51_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 52) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized52(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P52_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 53) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized53(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P53_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 54) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized54(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P54_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 55) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized55(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P55_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 56) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized56(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P56_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 57) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized57(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P57_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 58) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized58(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P58_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 59) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized59(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P59_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 60) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized60(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P60_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 61) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized61(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P61_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 62) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized62(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P62_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 63) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized63(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P63_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 64) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized64(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P64_M1D;
  }
}
