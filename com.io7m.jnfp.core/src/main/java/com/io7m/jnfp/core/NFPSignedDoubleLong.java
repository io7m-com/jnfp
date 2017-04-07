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

public final class NFPSignedDoubleLong
{
  private static final double TWO_P1_M1D;
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
    TWO_P1_M1D = 1.0; // (2 ^ 1) - 1
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

  private NFPSignedDoubleLong()
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

  public static double fromSignedNormalizedWithoutZero(
    final long f,
    final int b)
  {
    final double twobm1 = StrictMath.pow(2.0, (double) b) - 1.0;
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / twobm1;
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
    final double x,
    final int b)
  {
    final double twobm1 = StrictMath.pow(2.0, (double) b) - 1.0;
    final double r = (x * twobm1) - 1.0;
    final double rx = r / 2.0;
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

  public static double fromSignedNormalizedWithZero(
    final long f,
    final int b)
  {
    final double twobm1m1 = StrictMath.pow(2.0, (double) b - 1.0) - 1.0;
    final double dx = (double) f;
    final double div = dx / (twobm1m1);
    return Math.max(-1.0, div);
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
    final double x,
    final int b)
  {
    final double twobm1m1 = StrictMath.pow(2.0, (double) b - 1.0) - 1.0;
    final double mult = x * twobm1m1;
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P2_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P1_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P3_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P2_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P4_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P3_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P5_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P4_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P6_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P5_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P7_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P6_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P8_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P7_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P9_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P8_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P10_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P9_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P11_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P10_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P12_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P11_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P13_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P12_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P14_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P13_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P15_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P14_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P16_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P15_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P17_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P16_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P18_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P17_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P19_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P18_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P20_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P19_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P21_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P20_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P22_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P21_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P23_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P22_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P24_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P23_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P25_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P24_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P26_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P25_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P27_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P26_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P28_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P27_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P29_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P28_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P30_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P29_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P31_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P30_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P32_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P31_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P33_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P32_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P34_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P33_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P35_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P34_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P36_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P35_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P37_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P36_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P38_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P37_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P39_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P38_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P40_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P39_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P41_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P40_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P42_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P41_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P43_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P42_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P44_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P43_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P45_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P44_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P46_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P45_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P47_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P46_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P48_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P47_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P49_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P48_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P50_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P49_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P51_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P50_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P52_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P51_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P53_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P52_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P54_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P53_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P55_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P54_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P56_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P55_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P57_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P56_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P58_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P57_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P59_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P58_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P60_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P59_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P61_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P60_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P62_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P61_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P63_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P62_M1D);
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
    final double x)
  {
    final double r = (x * NFPSignedDoubleLong.TWO_P64_M1D) - 1.0;
    return (long) (r / 2.0);
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
    final double x)
  {
    return (long) (x * NFPSignedDoubleLong.TWO_P63_M1D);
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

  public static double fromSignedNormalizedWithoutZero2(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P2_M1D;
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

  public static double fromSignedNormalizedWithZero2(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P1_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero3(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P3_M1D;
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

  public static double fromSignedNormalizedWithZero3(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P2_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero4(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P4_M1D;
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

  public static double fromSignedNormalizedWithZero4(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P3_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero5(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P5_M1D;
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

  public static double fromSignedNormalizedWithZero5(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P4_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero6(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P6_M1D;
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

  public static double fromSignedNormalizedWithZero6(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P5_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero7(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P7_M1D;
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

  public static double fromSignedNormalizedWithZero7(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P6_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero8(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P8_M1D;
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

  public static double fromSignedNormalizedWithZero8(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P7_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero9(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P9_M1D;
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

  public static double fromSignedNormalizedWithZero9(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P8_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero10(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P10_M1D;
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

  public static double fromSignedNormalizedWithZero10(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P9_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero11(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P11_M1D;
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

  public static double fromSignedNormalizedWithZero11(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P10_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero12(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P12_M1D;
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

  public static double fromSignedNormalizedWithZero12(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P11_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero13(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P13_M1D;
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

  public static double fromSignedNormalizedWithZero13(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P12_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero14(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P14_M1D;
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

  public static double fromSignedNormalizedWithZero14(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P13_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero15(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P15_M1D;
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

  public static double fromSignedNormalizedWithZero15(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P14_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero16(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P16_M1D;
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

  public static double fromSignedNormalizedWithZero16(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P15_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero17(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P17_M1D;
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

  public static double fromSignedNormalizedWithZero17(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P16_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero18(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P18_M1D;
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

  public static double fromSignedNormalizedWithZero18(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P17_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero19(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P19_M1D;
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

  public static double fromSignedNormalizedWithZero19(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P18_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero20(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P20_M1D;
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

  public static double fromSignedNormalizedWithZero20(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P19_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero21(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P21_M1D;
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

  public static double fromSignedNormalizedWithZero21(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P20_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero22(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P22_M1D;
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

  public static double fromSignedNormalizedWithZero22(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P21_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero23(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P23_M1D;
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

  public static double fromSignedNormalizedWithZero23(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P22_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero24(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P24_M1D;
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

  public static double fromSignedNormalizedWithZero24(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P23_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero25(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P25_M1D;
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

  public static double fromSignedNormalizedWithZero25(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P24_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero26(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P26_M1D;
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

  public static double fromSignedNormalizedWithZero26(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P25_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero27(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P27_M1D;
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

  public static double fromSignedNormalizedWithZero27(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P26_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero28(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P28_M1D;
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

  public static double fromSignedNormalizedWithZero28(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P27_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero29(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P29_M1D;
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

  public static double fromSignedNormalizedWithZero29(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P28_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero30(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P30_M1D;
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

  public static double fromSignedNormalizedWithZero30(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P29_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero31(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P31_M1D;
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

  public static double fromSignedNormalizedWithZero31(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P30_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero32(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P32_M1D;
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

  public static double fromSignedNormalizedWithZero32(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P31_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero33(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P33_M1D;
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

  public static double fromSignedNormalizedWithZero33(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P32_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero34(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P34_M1D;
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

  public static double fromSignedNormalizedWithZero34(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P33_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero35(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P35_M1D;
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

  public static double fromSignedNormalizedWithZero35(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P34_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero36(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P36_M1D;
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

  public static double fromSignedNormalizedWithZero36(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P35_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero37(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P37_M1D;
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

  public static double fromSignedNormalizedWithZero37(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P36_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero38(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P38_M1D;
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

  public static double fromSignedNormalizedWithZero38(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P37_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero39(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P39_M1D;
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

  public static double fromSignedNormalizedWithZero39(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P38_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero40(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P40_M1D;
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

  public static double fromSignedNormalizedWithZero40(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P39_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero41(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P41_M1D;
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

  public static double fromSignedNormalizedWithZero41(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P40_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero42(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P42_M1D;
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

  public static double fromSignedNormalizedWithZero42(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P41_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero43(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P43_M1D;
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

  public static double fromSignedNormalizedWithZero43(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P42_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero44(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P44_M1D;
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

  public static double fromSignedNormalizedWithZero44(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P43_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero45(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P45_M1D;
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

  public static double fromSignedNormalizedWithZero45(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P44_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero46(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P46_M1D;
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

  public static double fromSignedNormalizedWithZero46(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P45_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero47(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P47_M1D;
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

  public static double fromSignedNormalizedWithZero47(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P46_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero48(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P48_M1D;
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

  public static double fromSignedNormalizedWithZero48(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P47_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero49(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P49_M1D;
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

  public static double fromSignedNormalizedWithZero49(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P48_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero50(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P50_M1D;
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

  public static double fromSignedNormalizedWithZero50(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P49_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero51(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P51_M1D;
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

  public static double fromSignedNormalizedWithZero51(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P50_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero52(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P52_M1D;
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

  public static double fromSignedNormalizedWithZero52(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P51_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero53(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P53_M1D;
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

  public static double fromSignedNormalizedWithZero53(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P52_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero54(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P54_M1D;
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

  public static double fromSignedNormalizedWithZero54(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P53_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero55(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P55_M1D;
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

  public static double fromSignedNormalizedWithZero55(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P54_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero56(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P56_M1D;
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

  public static double fromSignedNormalizedWithZero56(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P55_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero57(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P57_M1D;
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

  public static double fromSignedNormalizedWithZero57(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P56_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero58(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P58_M1D;
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

  public static double fromSignedNormalizedWithZero58(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P57_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero59(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P59_M1D;
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

  public static double fromSignedNormalizedWithZero59(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P58_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero60(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P60_M1D;
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

  public static double fromSignedNormalizedWithZero60(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P59_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero61(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P61_M1D;
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

  public static double fromSignedNormalizedWithZero61(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P60_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero62(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P62_M1D;
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

  public static double fromSignedNormalizedWithZero62(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P61_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero63(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P63_M1D;
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

  public static double fromSignedNormalizedWithZero63(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P62_M1D;
    return Math.max(-1.0, div);
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

  public static double fromSignedNormalizedWithoutZero64(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P64_M1D;
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

  public static double fromSignedNormalizedWithZero64(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P63_M1D;
    return Math.max(-1.0, div);
  }

}
