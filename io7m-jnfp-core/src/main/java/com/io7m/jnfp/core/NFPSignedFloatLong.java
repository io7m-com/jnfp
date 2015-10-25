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

/**
 * <p>Conversion of signed normalized fixed-point values to and from floating
 * point values.</p>
 *
 * <p>The OpenGL 3.3 specification defines two representations of signed
 * normalized fixed-point values with {@code b} bits of precision. The first
 * representation maps {@code -1.0} to {@code -(2 ^ (b - 1))} and {@code 1.0} to
 * {@code (2 ^ (b -1)) - 1}. This representation does not allow for {@code 0} to
 * be expressed directly. The second representation maps {@code -1.0} to {@code
 * -(2 ^ (b - 1)) + 1} and {@code 1.0} to {@code (2 ^ (b -1)) - 1}, which allows
 * for {@code 0} to be represented exactly but means that {@code -(2 ^ (b - 1))}
 * is outside of the representable range.</p>
 *
 * <p>For lack of better names, this implementation refers to the first
 * representation as {@code without-zero}, and the second as {@code
 * with-zero}.</p>
 *
 * <p>For the {@code without-zero} representation, conversion from signed
 * normalized fixed-point values {@code f} to floating point values {@code x} is
 * defined as:</p>
 *
 * <pre>
 * x = ((2 * f) + 1) / (pow(2, b) - 1)
 * </pre>
 *
 * <p>For the {@code with-zero} representation, conversion from signed
 * normalized fixed-point values {@code f} to floating point values {@code x} is
 * defined as:</p>
 *
 * <pre>
 * x = max (-1.0, f / (pow(2, b - 1) - 1))
 * </pre>
 *
 * <p>For the {@code without-zero} representation, conversion from floating
 * point values {@code x} (assumed to be in the range {@code [-1.0, 1.0]}) to
 * signed normalized fixed-point values {@code f} is defined as:</p>
 *
 * <pre>
 * f = ((x * (pow(2, b) - 1)) - 1) / 2
 * </pre>
 *
 * <p>For the {@code with-zero} representation, conversion from floating point
 * values {@code x} (assumed to be in the range {@code [-1.0, 1.0]}) to signed
 * normalized fixed-point values {@code f} is defined as:</p>
 *
 * <pre>
 * f = x * (pow(2, b - 1) - 1)
 * </pre>
 *
 * <p>This implementation provides general conversion functions that operate on
 * arbitrary values of {@code b}, and specialized functions that operate for
 * specific values of {@code b} using precomputed terms.</p>
 */

public final class NFPSignedFloatLong
{
  private static final float TWO_P1_M1F;
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
    TWO_P1_M1F = 1.0f; // (2 ^ 1) - 1
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

  private NFPSignedFloatLong()
  {
    throw new UnreachableCodeException();
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with {@code b} bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (b - 1)), (2 ^ (b -1)) - 1]}
   * @param b A value in the range {@code [2, 32]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero(
    final long f,
    final int b)
  {
    final float twobm1 = (float) StrictMath.pow(2.0, (double) b) - 1.0f;
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / twobm1;
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   * @param b A value in the range {@code [2, 32]}
   *
   * @return A signed normalized fixed-point value with {@code b} bits of
   * precision
   */

  public static long toSignedNormalizedWithoutZero(
    final float x,
    final int b)
  {
    final float twobm1 = (float) StrictMath.pow(2.0, (double) b) - 1.0f;
    final float r = (x * twobm1) - 1.0f;
    final float rx = r / 2.0f;
    return (long) rx;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with {@code b} bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (b - 1)) + 1, (2 ^ (b -1)) -
   *          1]}
   * @param b A value in the range {@code [2, 32]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero(
    final long f,
    final int b)
  {
    final float twobm1m1 = (float) StrictMath.pow(
      2.0, (double) b - 1.0) - 1.0f;
    final float dx = (float) f;
    final float div = dx / (twobm1m1);
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   * @param b A value in the range {@code [2, 32]}
   *
   * @return A signed normalized fixed-point value with {@code b} bits of
   * precision
   */

  public static long toSignedNormalizedWithZero(
    final float x,
    final int b)
  {
    final float twobm1m1 = (float) StrictMath.pow(
      2.0, (double) b - 1.0) - 1.0f;
    final float mult = x * twobm1m1;
    return (long) mult;
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 2 bits of precision
   */

  public static long toSignedNormalizedWithoutZero2(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P2_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 2 bits of precision
   */

  public static long toSignedNormalizedWithZero2(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P1_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 3 bits of precision
   */

  public static long toSignedNormalizedWithoutZero3(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P3_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 3 bits of precision
   */

  public static long toSignedNormalizedWithZero3(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P2_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 4 bits of precision
   */

  public static long toSignedNormalizedWithoutZero4(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P4_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 4 bits of precision
   */

  public static long toSignedNormalizedWithZero4(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P3_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 5 bits of precision
   */

  public static long toSignedNormalizedWithoutZero5(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P5_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 5 bits of precision
   */

  public static long toSignedNormalizedWithZero5(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P4_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 6 bits of precision
   */

  public static long toSignedNormalizedWithoutZero6(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P6_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 6 bits of precision
   */

  public static long toSignedNormalizedWithZero6(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P5_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 7 bits of precision
   */

  public static long toSignedNormalizedWithoutZero7(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P7_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 7 bits of precision
   */

  public static long toSignedNormalizedWithZero7(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P6_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 8 bits of precision
   */

  public static long toSignedNormalizedWithoutZero8(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P8_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 8 bits of precision
   */

  public static long toSignedNormalizedWithZero8(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P7_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 9 bits of precision
   */

  public static long toSignedNormalizedWithoutZero9(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P9_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 9 bits of precision
   */

  public static long toSignedNormalizedWithZero9(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P8_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 10 bits of precision
   */

  public static long toSignedNormalizedWithoutZero10(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P10_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 10 bits of precision
   */

  public static long toSignedNormalizedWithZero10(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P9_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 11 bits of precision
   */

  public static long toSignedNormalizedWithoutZero11(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P11_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 11 bits of precision
   */

  public static long toSignedNormalizedWithZero11(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P10_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 12 bits of precision
   */

  public static long toSignedNormalizedWithoutZero12(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P12_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 12 bits of precision
   */

  public static long toSignedNormalizedWithZero12(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P11_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 13 bits of precision
   */

  public static long toSignedNormalizedWithoutZero13(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P13_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 13 bits of precision
   */

  public static long toSignedNormalizedWithZero13(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P12_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 14 bits of precision
   */

  public static long toSignedNormalizedWithoutZero14(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P14_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 14 bits of precision
   */

  public static long toSignedNormalizedWithZero14(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P13_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 15 bits of precision
   */

  public static long toSignedNormalizedWithoutZero15(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P15_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 15 bits of precision
   */

  public static long toSignedNormalizedWithZero15(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P14_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 16 bits of precision
   */

  public static long toSignedNormalizedWithoutZero16(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P16_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 16 bits of precision
   */

  public static long toSignedNormalizedWithZero16(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P15_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 17 bits of precision
   */

  public static long toSignedNormalizedWithoutZero17(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P17_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 17 bits of precision
   */

  public static long toSignedNormalizedWithZero17(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P16_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 18 bits of precision
   */

  public static long toSignedNormalizedWithoutZero18(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P18_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 18 bits of precision
   */

  public static long toSignedNormalizedWithZero18(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P17_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 19 bits of precision
   */

  public static long toSignedNormalizedWithoutZero19(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P19_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 19 bits of precision
   */

  public static long toSignedNormalizedWithZero19(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P18_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 20 bits of precision
   */

  public static long toSignedNormalizedWithoutZero20(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P20_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 20 bits of precision
   */

  public static long toSignedNormalizedWithZero20(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P19_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 21 bits of precision
   */

  public static long toSignedNormalizedWithoutZero21(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P21_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 21 bits of precision
   */

  public static long toSignedNormalizedWithZero21(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P20_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 22 bits of precision
   */

  public static long toSignedNormalizedWithoutZero22(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P22_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 22 bits of precision
   */

  public static long toSignedNormalizedWithZero22(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P21_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 23 bits of precision
   */

  public static long toSignedNormalizedWithoutZero23(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P23_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 23 bits of precision
   */

  public static long toSignedNormalizedWithZero23(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P22_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 24 bits of precision
   */

  public static long toSignedNormalizedWithoutZero24(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P24_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 24 bits of precision
   */

  public static long toSignedNormalizedWithZero24(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P23_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 25 bits of precision
   */

  public static long toSignedNormalizedWithoutZero25(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P25_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 25 bits of precision
   */

  public static long toSignedNormalizedWithZero25(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P24_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 26 bits of precision
   */

  public static long toSignedNormalizedWithoutZero26(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P26_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 26 bits of precision
   */

  public static long toSignedNormalizedWithZero26(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P25_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 27 bits of precision
   */

  public static long toSignedNormalizedWithoutZero27(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P27_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 27 bits of precision
   */

  public static long toSignedNormalizedWithZero27(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P26_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 28 bits of precision
   */

  public static long toSignedNormalizedWithoutZero28(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P28_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 28 bits of precision
   */

  public static long toSignedNormalizedWithZero28(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P27_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 29 bits of precision
   */

  public static long toSignedNormalizedWithoutZero29(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P29_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 29 bits of precision
   */

  public static long toSignedNormalizedWithZero29(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P28_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 30 bits of precision
   */

  public static long toSignedNormalizedWithoutZero30(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P30_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 30 bits of precision
   */

  public static long toSignedNormalizedWithZero30(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P29_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 31 bits of precision
   */

  public static long toSignedNormalizedWithoutZero31(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P31_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 31 bits of precision
   */

  public static long toSignedNormalizedWithZero31(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P30_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 32 bits of precision
   */

  public static long toSignedNormalizedWithoutZero32(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P32_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 32 bits of precision
   */

  public static long toSignedNormalizedWithZero32(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P31_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 33 bits of precision
   */

  public static long toSignedNormalizedWithoutZero33(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P33_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 33 bits of precision
   */

  public static long toSignedNormalizedWithZero33(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P32_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 34 bits of precision
   */

  public static long toSignedNormalizedWithoutZero34(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P34_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 34 bits of precision
   */

  public static long toSignedNormalizedWithZero34(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P33_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 35 bits of precision
   */

  public static long toSignedNormalizedWithoutZero35(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P35_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 35 bits of precision
   */

  public static long toSignedNormalizedWithZero35(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P34_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 36 bits of precision
   */

  public static long toSignedNormalizedWithoutZero36(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P36_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 36 bits of precision
   */

  public static long toSignedNormalizedWithZero36(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P35_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 37 bits of precision
   */

  public static long toSignedNormalizedWithoutZero37(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P37_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 37 bits of precision
   */

  public static long toSignedNormalizedWithZero37(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P36_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 38 bits of precision
   */

  public static long toSignedNormalizedWithoutZero38(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P38_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 38 bits of precision
   */

  public static long toSignedNormalizedWithZero38(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P37_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 39 bits of precision
   */

  public static long toSignedNormalizedWithoutZero39(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P39_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 39 bits of precision
   */

  public static long toSignedNormalizedWithZero39(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P38_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 40 bits of precision
   */

  public static long toSignedNormalizedWithoutZero40(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P40_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 40 bits of precision
   */

  public static long toSignedNormalizedWithZero40(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P39_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 41 bits of precision
   */

  public static long toSignedNormalizedWithoutZero41(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P41_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 41 bits of precision
   */

  public static long toSignedNormalizedWithZero41(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P40_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 42 bits of precision
   */

  public static long toSignedNormalizedWithoutZero42(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P42_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 42 bits of precision
   */

  public static long toSignedNormalizedWithZero42(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P41_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 43 bits of precision
   */

  public static long toSignedNormalizedWithoutZero43(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P43_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 43 bits of precision
   */

  public static long toSignedNormalizedWithZero43(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P42_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 44 bits of precision
   */

  public static long toSignedNormalizedWithoutZero44(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P44_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 44 bits of precision
   */

  public static long toSignedNormalizedWithZero44(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P43_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 45 bits of precision
   */

  public static long toSignedNormalizedWithoutZero45(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P45_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 45 bits of precision
   */

  public static long toSignedNormalizedWithZero45(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P44_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 46 bits of precision
   */

  public static long toSignedNormalizedWithoutZero46(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P46_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 46 bits of precision
   */

  public static long toSignedNormalizedWithZero46(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P45_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 47 bits of precision
   */

  public static long toSignedNormalizedWithoutZero47(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P47_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 47 bits of precision
   */

  public static long toSignedNormalizedWithZero47(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P46_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 48 bits of precision
   */

  public static long toSignedNormalizedWithoutZero48(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P48_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 48 bits of precision
   */

  public static long toSignedNormalizedWithZero48(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P47_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 49 bits of precision
   */

  public static long toSignedNormalizedWithoutZero49(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P49_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 49 bits of precision
   */

  public static long toSignedNormalizedWithZero49(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P48_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 50 bits of precision
   */

  public static long toSignedNormalizedWithoutZero50(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P50_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 50 bits of precision
   */

  public static long toSignedNormalizedWithZero50(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P49_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 51 bits of precision
   */

  public static long toSignedNormalizedWithoutZero51(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P51_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 51 bits of precision
   */

  public static long toSignedNormalizedWithZero51(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P50_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 52 bits of precision
   */

  public static long toSignedNormalizedWithoutZero52(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P52_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 52 bits of precision
   */

  public static long toSignedNormalizedWithZero52(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P51_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 53 bits of precision
   */

  public static long toSignedNormalizedWithoutZero53(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P53_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 53 bits of precision
   */

  public static long toSignedNormalizedWithZero53(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P52_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 54 bits of precision
   */

  public static long toSignedNormalizedWithoutZero54(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P54_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 54 bits of precision
   */

  public static long toSignedNormalizedWithZero54(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P53_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 55 bits of precision
   */

  public static long toSignedNormalizedWithoutZero55(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P55_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 55 bits of precision
   */

  public static long toSignedNormalizedWithZero55(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P54_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 56 bits of precision
   */

  public static long toSignedNormalizedWithoutZero56(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P56_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 56 bits of precision
   */

  public static long toSignedNormalizedWithZero56(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P55_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 57 bits of precision
   */

  public static long toSignedNormalizedWithoutZero57(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P57_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 57 bits of precision
   */

  public static long toSignedNormalizedWithZero57(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P56_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 58 bits of precision
   */

  public static long toSignedNormalizedWithoutZero58(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P58_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 58 bits of precision
   */

  public static long toSignedNormalizedWithZero58(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P57_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 59 bits of precision
   */

  public static long toSignedNormalizedWithoutZero59(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P59_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 59 bits of precision
   */

  public static long toSignedNormalizedWithZero59(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P58_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 60 bits of precision
   */

  public static long toSignedNormalizedWithoutZero60(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P60_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 60 bits of precision
   */

  public static long toSignedNormalizedWithZero60(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P59_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 61 bits of precision
   */

  public static long toSignedNormalizedWithoutZero61(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P61_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 61 bits of precision
   */

  public static long toSignedNormalizedWithZero61(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P60_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 62 bits of precision
   */

  public static long toSignedNormalizedWithoutZero62(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P62_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 62 bits of precision
   */

  public static long toSignedNormalizedWithZero62(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P61_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 63 bits of precision
   */

  public static long toSignedNormalizedWithoutZero63(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P63_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 63 bits of precision
   */

  public static long toSignedNormalizedWithZero63(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P62_M1F);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 64 bits of precision
   */

  public static long toSignedNormalizedWithoutZero64(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P64_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with 64 bits of precision
   */

  public static long toSignedNormalizedWithZero64(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P63_M1F);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 2 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (2 - 1)), (2 ^ (2 - 1)) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero2(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P2_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 2 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 1) + 1, (2 ^ 1) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero2(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P1_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 3 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (3 - 1)), (2 ^ (3 - 1)) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero3(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P3_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 3 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 2) + 1, (2 ^ 2) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero3(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P2_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 4 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (4 - 1)), (2 ^ (4 - 1)) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero4(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P4_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 4 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 3) + 1, (2 ^ 3) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero4(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P3_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 5 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (5 - 1)), (2 ^ (5 - 1)) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero5(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P5_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 5 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 4) + 1, (2 ^ 4) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero5(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P4_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 6 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (6 - 1)), (2 ^ (6 - 1)) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero6(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P6_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 6 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 5) + 1, (2 ^ 5) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero6(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P5_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 7 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (7 - 1)), (2 ^ (7 - 1)) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero7(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P7_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 7 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 6) + 1, (2 ^ 6) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero7(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P6_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 8 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (8 - 1)), (2 ^ (8 - 1)) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero8(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P8_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 8 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 7) + 1, (2 ^ 7) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero8(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P7_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 9 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (9 - 1)), (2 ^ (9 - 1)) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero9(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P9_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 9 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 8) + 1, (2 ^ 8) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero9(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P8_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 10 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (10 - 1)), (2 ^ (10 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero10(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P10_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 10 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 9) + 1, (2 ^ 9) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero10(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P9_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 11 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (11 - 1)), (2 ^ (11 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero11(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P11_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 11 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 10) + 1, (2 ^ 10) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero11(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P10_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 12 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (12 - 1)), (2 ^ (12 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero12(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P12_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 12 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 11) + 1, (2 ^ 11) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero12(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P11_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 13 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (13 - 1)), (2 ^ (13 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero13(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P13_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 13 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 12) + 1, (2 ^ 12) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero13(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P12_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 14 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (14 - 1)), (2 ^ (14 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero14(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P14_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 14 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 13) + 1, (2 ^ 13) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero14(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P13_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 15 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (15 - 1)), (2 ^ (15 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero15(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P15_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 15 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 14) + 1, (2 ^ 14) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero15(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P14_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 16 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (16 - 1)), (2 ^ (16 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero16(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P16_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 16 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 15) + 1, (2 ^ 15) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero16(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P15_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 17 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (17 - 1)), (2 ^ (17 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero17(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P17_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 17 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 16) + 1, (2 ^ 16) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero17(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P16_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 18 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (18 - 1)), (2 ^ (18 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero18(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P18_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 18 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 17) + 1, (2 ^ 17) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero18(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P17_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 19 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (19 - 1)), (2 ^ (19 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero19(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P19_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 19 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 18) + 1, (2 ^ 18) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero19(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P18_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 20 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (20 - 1)), (2 ^ (20 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero20(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P20_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 20 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 19) + 1, (2 ^ 19) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero20(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P19_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 21 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (21 - 1)), (2 ^ (21 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero21(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P21_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 21 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 20) + 1, (2 ^ 20) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero21(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P20_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 22 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (22 - 1)), (2 ^ (22 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero22(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P22_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 22 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 21) + 1, (2 ^ 21) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero22(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P21_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 23 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (23 - 1)), (2 ^ (23 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero23(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P23_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 23 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 22) + 1, (2 ^ 22) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero23(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P22_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 24 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (24 - 1)), (2 ^ (24 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero24(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P24_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 24 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 23) + 1, (2 ^ 23) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero24(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P23_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 25 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (25 - 1)), (2 ^ (25 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero25(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P25_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 25 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 24) + 1, (2 ^ 24) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero25(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P24_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 26 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (26 - 1)), (2 ^ (26 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero26(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P26_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 26 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 25) + 1, (2 ^ 25) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero26(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P25_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 27 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (27 - 1)), (2 ^ (27 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero27(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P27_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 27 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 26) + 1, (2 ^ 26) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero27(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P26_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 28 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (28 - 1)), (2 ^ (28 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero28(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P28_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 28 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 27) + 1, (2 ^ 27) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero28(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P27_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 29 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (29 - 1)), (2 ^ (29 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero29(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P29_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 29 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 28) + 1, (2 ^ 28) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero29(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P28_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 30 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (30 - 1)), (2 ^ (30 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero30(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P30_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 30 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 29) + 1, (2 ^ 29) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero30(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P29_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 31 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (31 - 1)), (2 ^ (31 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero31(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P31_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 31 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 30) + 1, (2 ^ 30) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero31(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P30_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 32 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (32 - 1)), (2 ^ (32 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero32(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P32_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 32 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 31) + 1, (2 ^ 31) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero32(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P31_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 33 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (33 - 1)), (2 ^ (33 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero33(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P33_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 33 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 32) + 1, (2 ^ 32) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero33(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P32_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 34 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (34 - 1)), (2 ^ (34 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero34(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P34_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 34 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 33) + 1, (2 ^ 33) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero34(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P33_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 35 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (35 - 1)), (2 ^ (35 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero35(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P35_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 35 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 34) + 1, (2 ^ 34) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero35(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P34_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 36 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (36 - 1)), (2 ^ (36 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero36(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P36_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 36 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 35) + 1, (2 ^ 35) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero36(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P35_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 37 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (37 - 1)), (2 ^ (37 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero37(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P37_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 37 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 36) + 1, (2 ^ 36) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero37(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P36_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 38 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (38 - 1)), (2 ^ (38 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero38(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P38_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 38 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 37) + 1, (2 ^ 37) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero38(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P37_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 39 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (39 - 1)), (2 ^ (39 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero39(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P39_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 39 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 38) + 1, (2 ^ 38) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero39(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P38_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 40 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (40 - 1)), (2 ^ (40 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero40(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P40_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 40 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 39) + 1, (2 ^ 39) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero40(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P39_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 41 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (41 - 1)), (2 ^ (41 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero41(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P41_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 41 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 40) + 1, (2 ^ 40) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero41(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P40_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 42 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (42 - 1)), (2 ^ (42 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero42(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P42_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 42 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 41) + 1, (2 ^ 41) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero42(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P41_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 43 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (43 - 1)), (2 ^ (43 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero43(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P43_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 43 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 42) + 1, (2 ^ 42) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero43(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P42_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 44 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (44 - 1)), (2 ^ (44 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero44(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P44_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 44 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 43) + 1, (2 ^ 43) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero44(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P43_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 45 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (45 - 1)), (2 ^ (45 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero45(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P45_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 45 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 44) + 1, (2 ^ 44) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero45(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P44_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 46 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (46 - 1)), (2 ^ (46 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero46(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P46_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 46 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 45) + 1, (2 ^ 45) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero46(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P45_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 47 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (47 - 1)), (2 ^ (47 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero47(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P47_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 47 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 46) + 1, (2 ^ 46) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero47(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P46_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 48 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (48 - 1)), (2 ^ (48 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero48(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P48_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 48 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 47) + 1, (2 ^ 47) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero48(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P47_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 49 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (49 - 1)), (2 ^ (49 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero49(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P49_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 49 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 48) + 1, (2 ^ 48) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero49(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P48_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 50 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (50 - 1)), (2 ^ (50 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero50(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P50_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 50 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 49) + 1, (2 ^ 49) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero50(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P49_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 51 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (51 - 1)), (2 ^ (51 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero51(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P51_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 51 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 50) + 1, (2 ^ 50) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero51(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P50_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 52 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (52 - 1)), (2 ^ (52 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero52(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P52_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 52 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 51) + 1, (2 ^ 51) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero52(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P51_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 53 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (53 - 1)), (2 ^ (53 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero53(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P53_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 53 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 52) + 1, (2 ^ 52) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero53(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P52_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 54 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (54 - 1)), (2 ^ (54 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero54(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P54_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 54 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 53) + 1, (2 ^ 53) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero54(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P53_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 55 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (55 - 1)), (2 ^ (55 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero55(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P55_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 55 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 54) + 1, (2 ^ 54) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero55(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P54_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 56 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (56 - 1)), (2 ^ (56 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero56(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P56_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 56 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 55) + 1, (2 ^ 55) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero56(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P55_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 57 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (57 - 1)), (2 ^ (57 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero57(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P57_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 57 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 56) + 1, (2 ^ 56) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero57(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P56_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 58 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (58 - 1)), (2 ^ (58 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero58(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P58_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 58 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 57) + 1, (2 ^ 57) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero58(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P57_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 59 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (59 - 1)), (2 ^ (59 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero59(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P59_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 59 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 58) + 1, (2 ^ 58) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero59(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P58_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 60 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (60 - 1)), (2 ^ (60 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero60(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P60_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 60 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 59) + 1, (2 ^ 59) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero60(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P59_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 61 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (61 - 1)), (2 ^ (61 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero61(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P61_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 61 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 60) + 1, (2 ^ 60) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero61(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P60_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 62 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (62 - 1)), (2 ^ (62 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero62(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P62_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 62 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 61) + 1, (2 ^ 61) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero62(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P61_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 63 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (63 - 1)), (2 ^ (63 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero63(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P63_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 63 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 62) + 1, (2 ^ 62) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero63(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P62_M1F;
    return Math.max(-1.0f, div);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 64 bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ (64 - 1)), (2 ^ (64 - 1)) -
   *          1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero64(final long f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatLong.TWO_P64_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with 64 bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ 63) + 1, (2 ^ 63) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero64(
    final long f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatLong.TWO_P63_M1F;
    return Math.max(-1.0f, div);
  }
}
