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

public final class NFPSignedDoubleInt
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
  }

  private NFPSignedDoubleInt()
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
    final int f,
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

  public static int toSignedNormalizedWithoutZero(
    final double x,
    final int b)
  {
    final double twobm1 = StrictMath.pow(2.0, (double) b) - 1.0;
    final double r = (x * twobm1) - 1.0;
    final double rx = r / 2.0;
    return (int) rx;
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
    final int f,
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

  public static int toSignedNormalizedWithZero(
    final double x,
    final int b)
  {
    final double twobm1m1 = StrictMath.pow(2.0, (double) b - 1.0) - 1.0;
    final double mult = x * twobm1m1;
    return (int) mult;
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

  public static int toSignedNormalizedWithoutZero2(
    final double x)
  {
    final double r = (x * NFPSignedDoubleInt.TWO_P2_M1D) - 1.0;
    return (int) (r / 2.0);
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

  public static int toSignedNormalizedWithZero2(
    final double x)
  {
    return (int) (x * NFPSignedDoubleInt.TWO_P1_M1D);
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

  public static int toSignedNormalizedWithoutZero3(
    final double x)
  {
    final double r = (x * NFPSignedDoubleInt.TWO_P3_M1D) - 1.0;
    return (int) (r / 2.0);
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

  public static int toSignedNormalizedWithZero3(
    final double x)
  {
    return (int) (x * NFPSignedDoubleInt.TWO_P2_M1D);
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

  public static int toSignedNormalizedWithoutZero4(
    final double x)
  {
    final double r = (x * NFPSignedDoubleInt.TWO_P4_M1D) - 1.0;
    return (int) (r / 2.0);
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

  public static int toSignedNormalizedWithZero4(
    final double x)
  {
    return (int) (x * NFPSignedDoubleInt.TWO_P3_M1D);
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

  public static int toSignedNormalizedWithoutZero5(
    final double x)
  {
    final double r = (x * NFPSignedDoubleInt.TWO_P5_M1D) - 1.0;
    return (int) (r / 2.0);
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

  public static int toSignedNormalizedWithZero5(
    final double x)
  {
    return (int) (x * NFPSignedDoubleInt.TWO_P4_M1D);
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

  public static int toSignedNormalizedWithoutZero6(
    final double x)
  {
    final double r = (x * NFPSignedDoubleInt.TWO_P6_M1D) - 1.0;
    return (int) (r / 2.0);
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

  public static int toSignedNormalizedWithZero6(
    final double x)
  {
    return (int) (x * NFPSignedDoubleInt.TWO_P5_M1D);
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

  public static int toSignedNormalizedWithoutZero7(
    final double x)
  {
    final double r = (x * NFPSignedDoubleInt.TWO_P7_M1D) - 1.0;
    return (int) (r / 2.0);
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

  public static int toSignedNormalizedWithZero7(
    final double x)
  {
    return (int) (x * NFPSignedDoubleInt.TWO_P6_M1D);
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

  public static int toSignedNormalizedWithoutZero8(
    final double x)
  {
    final double r = (x * NFPSignedDoubleInt.TWO_P8_M1D) - 1.0;
    return (int) (r / 2.0);
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

  public static int toSignedNormalizedWithZero8(
    final double x)
  {
    return (int) (x * NFPSignedDoubleInt.TWO_P7_M1D);
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

  public static int toSignedNormalizedWithoutZero9(
    final double x)
  {
    final double r = (x * NFPSignedDoubleInt.TWO_P9_M1D) - 1.0;
    return (int) (r / 2.0);
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

  public static int toSignedNormalizedWithZero9(
    final double x)
  {
    return (int) (x * NFPSignedDoubleInt.TWO_P8_M1D);
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

  public static int toSignedNormalizedWithoutZero10(
    final double x)
  {
    final double r = (x * NFPSignedDoubleInt.TWO_P10_M1D) - 1.0;
    return (int) (r / 2.0);
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

  public static int toSignedNormalizedWithZero10(
    final double x)
  {
    return (int) (x * NFPSignedDoubleInt.TWO_P9_M1D);
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

  public static int toSignedNormalizedWithoutZero11(
    final double x)
  {
    final double r = (x * NFPSignedDoubleInt.TWO_P11_M1D) - 1.0;
    return (int) (r / 2.0);
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

  public static int toSignedNormalizedWithZero11(
    final double x)
  {
    return (int) (x * NFPSignedDoubleInt.TWO_P10_M1D);
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

  public static int toSignedNormalizedWithoutZero12(
    final double x)
  {
    final double r = (x * NFPSignedDoubleInt.TWO_P12_M1D) - 1.0;
    return (int) (r / 2.0);
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

  public static int toSignedNormalizedWithZero12(
    final double x)
  {
    return (int) (x * NFPSignedDoubleInt.TWO_P11_M1D);
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

  public static int toSignedNormalizedWithoutZero13(
    final double x)
  {
    final double r = (x * NFPSignedDoubleInt.TWO_P13_M1D) - 1.0;
    return (int) (r / 2.0);
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

  public static int toSignedNormalizedWithZero13(
    final double x)
  {
    return (int) (x * NFPSignedDoubleInt.TWO_P12_M1D);
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

  public static int toSignedNormalizedWithoutZero14(
    final double x)
  {
    final double r = (x * NFPSignedDoubleInt.TWO_P14_M1D) - 1.0;
    return (int) (r / 2.0);
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

  public static int toSignedNormalizedWithZero14(
    final double x)
  {
    return (int) (x * NFPSignedDoubleInt.TWO_P13_M1D);
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

  public static int toSignedNormalizedWithoutZero15(
    final double x)
  {
    final double r = (x * NFPSignedDoubleInt.TWO_P15_M1D) - 1.0;
    return (int) (r / 2.0);
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

  public static int toSignedNormalizedWithZero15(
    final double x)
  {
    return (int) (x * NFPSignedDoubleInt.TWO_P14_M1D);
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

  public static int toSignedNormalizedWithoutZero16(
    final double x)
  {
    final double r = (x * NFPSignedDoubleInt.TWO_P16_M1D) - 1.0;
    return (int) (r / 2.0);
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

  public static int toSignedNormalizedWithZero16(
    final double x)
  {
    return (int) (x * NFPSignedDoubleInt.TWO_P15_M1D);
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

  public static int toSignedNormalizedWithoutZero17(
    final double x)
  {
    final double r = (x * NFPSignedDoubleInt.TWO_P17_M1D) - 1.0;
    return (int) (r / 2.0);
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

  public static int toSignedNormalizedWithZero17(
    final double x)
  {
    return (int) (x * NFPSignedDoubleInt.TWO_P16_M1D);
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

  public static int toSignedNormalizedWithoutZero18(
    final double x)
  {
    final double r = (x * NFPSignedDoubleInt.TWO_P18_M1D) - 1.0;
    return (int) (r / 2.0);
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

  public static int toSignedNormalizedWithZero18(
    final double x)
  {
    return (int) (x * NFPSignedDoubleInt.TWO_P17_M1D);
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

  public static int toSignedNormalizedWithoutZero19(
    final double x)
  {
    final double r = (x * NFPSignedDoubleInt.TWO_P19_M1D) - 1.0;
    return (int) (r / 2.0);
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

  public static int toSignedNormalizedWithZero19(
    final double x)
  {
    return (int) (x * NFPSignedDoubleInt.TWO_P18_M1D);
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

  public static int toSignedNormalizedWithoutZero20(
    final double x)
  {
    final double r = (x * NFPSignedDoubleInt.TWO_P20_M1D) - 1.0;
    return (int) (r / 2.0);
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

  public static int toSignedNormalizedWithZero20(
    final double x)
  {
    return (int) (x * NFPSignedDoubleInt.TWO_P19_M1D);
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

  public static int toSignedNormalizedWithoutZero21(
    final double x)
  {
    final double r = (x * NFPSignedDoubleInt.TWO_P21_M1D) - 1.0;
    return (int) (r / 2.0);
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

  public static int toSignedNormalizedWithZero21(
    final double x)
  {
    return (int) (x * NFPSignedDoubleInt.TWO_P20_M1D);
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

  public static int toSignedNormalizedWithoutZero22(
    final double x)
  {
    final double r = (x * NFPSignedDoubleInt.TWO_P22_M1D) - 1.0;
    return (int) (r / 2.0);
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

  public static int toSignedNormalizedWithZero22(
    final double x)
  {
    return (int) (x * NFPSignedDoubleInt.TWO_P21_M1D);
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

  public static int toSignedNormalizedWithoutZero23(
    final double x)
  {
    final double r = (x * NFPSignedDoubleInt.TWO_P23_M1D) - 1.0;
    return (int) (r / 2.0);
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

  public static int toSignedNormalizedWithZero23(
    final double x)
  {
    return (int) (x * NFPSignedDoubleInt.TWO_P22_M1D);
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

  public static int toSignedNormalizedWithoutZero24(
    final double x)
  {
    final double r = (x * NFPSignedDoubleInt.TWO_P24_M1D) - 1.0;
    return (int) (r / 2.0);
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

  public static int toSignedNormalizedWithZero24(
    final double x)
  {
    return (int) (x * NFPSignedDoubleInt.TWO_P23_M1D);
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

  public static int toSignedNormalizedWithoutZero25(
    final double x)
  {
    final double r = (x * NFPSignedDoubleInt.TWO_P25_M1D) - 1.0;
    return (int) (r / 2.0);
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

  public static int toSignedNormalizedWithZero25(
    final double x)
  {
    return (int) (x * NFPSignedDoubleInt.TWO_P24_M1D);
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

  public static int toSignedNormalizedWithoutZero26(
    final double x)
  {
    final double r = (x * NFPSignedDoubleInt.TWO_P26_M1D) - 1.0;
    return (int) (r / 2.0);
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

  public static int toSignedNormalizedWithZero26(
    final double x)
  {
    return (int) (x * NFPSignedDoubleInt.TWO_P25_M1D);
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

  public static int toSignedNormalizedWithoutZero27(
    final double x)
  {
    final double r = (x * NFPSignedDoubleInt.TWO_P27_M1D) - 1.0;
    return (int) (r / 2.0);
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

  public static int toSignedNormalizedWithZero27(
    final double x)
  {
    return (int) (x * NFPSignedDoubleInt.TWO_P26_M1D);
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

  public static int toSignedNormalizedWithoutZero28(
    final double x)
  {
    final double r = (x * NFPSignedDoubleInt.TWO_P28_M1D) - 1.0;
    return (int) (r / 2.0);
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

  public static int toSignedNormalizedWithZero28(
    final double x)
  {
    return (int) (x * NFPSignedDoubleInt.TWO_P27_M1D);
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

  public static int toSignedNormalizedWithoutZero29(
    final double x)
  {
    final double r = (x * NFPSignedDoubleInt.TWO_P29_M1D) - 1.0;
    return (int) (r / 2.0);
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

  public static int toSignedNormalizedWithZero29(
    final double x)
  {
    return (int) (x * NFPSignedDoubleInt.TWO_P28_M1D);
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

  public static int toSignedNormalizedWithoutZero30(
    final double x)
  {
    final double r = (x * NFPSignedDoubleInt.TWO_P30_M1D) - 1.0;
    return (int) (r / 2.0);
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

  public static int toSignedNormalizedWithZero30(
    final double x)
  {
    return (int) (x * NFPSignedDoubleInt.TWO_P29_M1D);
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

  public static int toSignedNormalizedWithoutZero31(
    final double x)
  {
    final double r = (x * NFPSignedDoubleInt.TWO_P31_M1D) - 1.0;
    return (int) (r / 2.0);
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

  public static int toSignedNormalizedWithZero31(
    final double x)
  {
    return (int) (x * NFPSignedDoubleInt.TWO_P30_M1D);
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

  public static int toSignedNormalizedWithoutZero32(
    final double x)
  {
    final double r = (x * NFPSignedDoubleInt.TWO_P32_M1D) - 1.0;
    return (int) (r / 2.0);
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

  public static int toSignedNormalizedWithZero32(
    final double x)
  {
    return (int) (x * NFPSignedDoubleInt.TWO_P31_M1D);
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

  public static double fromSignedNormalizedWithoutZero2(final int f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleInt.TWO_P2_M1D;
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
    final int f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleInt.TWO_P1_M1D;
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

  public static double fromSignedNormalizedWithoutZero3(final int f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleInt.TWO_P3_M1D;
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
    final int f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleInt.TWO_P2_M1D;
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

  public static double fromSignedNormalizedWithoutZero4(final int f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleInt.TWO_P4_M1D;
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
    final int f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleInt.TWO_P3_M1D;
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

  public static double fromSignedNormalizedWithoutZero5(final int f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleInt.TWO_P5_M1D;
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
    final int f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleInt.TWO_P4_M1D;
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

  public static double fromSignedNormalizedWithoutZero6(final int f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleInt.TWO_P6_M1D;
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
    final int f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleInt.TWO_P5_M1D;
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

  public static double fromSignedNormalizedWithoutZero7(final int f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleInt.TWO_P7_M1D;
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
    final int f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleInt.TWO_P6_M1D;
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

  public static double fromSignedNormalizedWithoutZero8(final int f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleInt.TWO_P8_M1D;
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
    final int f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleInt.TWO_P7_M1D;
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

  public static double fromSignedNormalizedWithoutZero9(final int f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleInt.TWO_P9_M1D;
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
    final int f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleInt.TWO_P8_M1D;
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

  public static double fromSignedNormalizedWithoutZero10(final int f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleInt.TWO_P10_M1D;
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
    final int f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleInt.TWO_P9_M1D;
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

  public static double fromSignedNormalizedWithoutZero11(final int f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleInt.TWO_P11_M1D;
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
    final int f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleInt.TWO_P10_M1D;
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

  public static double fromSignedNormalizedWithoutZero12(final int f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleInt.TWO_P12_M1D;
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
    final int f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleInt.TWO_P11_M1D;
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

  public static double fromSignedNormalizedWithoutZero13(final int f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleInt.TWO_P13_M1D;
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
    final int f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleInt.TWO_P12_M1D;
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

  public static double fromSignedNormalizedWithoutZero14(final int f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleInt.TWO_P14_M1D;
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
    final int f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleInt.TWO_P13_M1D;
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

  public static double fromSignedNormalizedWithoutZero15(final int f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleInt.TWO_P15_M1D;
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
    final int f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleInt.TWO_P14_M1D;
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

  public static double fromSignedNormalizedWithoutZero16(final int f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleInt.TWO_P16_M1D;
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
    final int f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleInt.TWO_P15_M1D;
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

  public static double fromSignedNormalizedWithoutZero17(final int f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleInt.TWO_P17_M1D;
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
    final int f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleInt.TWO_P16_M1D;
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

  public static double fromSignedNormalizedWithoutZero18(final int f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleInt.TWO_P18_M1D;
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
    final int f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleInt.TWO_P17_M1D;
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

  public static double fromSignedNormalizedWithoutZero19(final int f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleInt.TWO_P19_M1D;
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
    final int f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleInt.TWO_P18_M1D;
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

  public static double fromSignedNormalizedWithoutZero20(final int f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleInt.TWO_P20_M1D;
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
    final int f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleInt.TWO_P19_M1D;
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

  public static double fromSignedNormalizedWithoutZero21(final int f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleInt.TWO_P21_M1D;
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
    final int f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleInt.TWO_P20_M1D;
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

  public static double fromSignedNormalizedWithoutZero22(final int f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleInt.TWO_P22_M1D;
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
    final int f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleInt.TWO_P21_M1D;
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

  public static double fromSignedNormalizedWithoutZero23(final int f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleInt.TWO_P23_M1D;
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
    final int f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleInt.TWO_P22_M1D;
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

  public static double fromSignedNormalizedWithoutZero24(final int f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleInt.TWO_P24_M1D;
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
    final int f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleInt.TWO_P23_M1D;
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

  public static double fromSignedNormalizedWithoutZero25(final int f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleInt.TWO_P25_M1D;
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
    final int f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleInt.TWO_P24_M1D;
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

  public static double fromSignedNormalizedWithoutZero26(final int f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleInt.TWO_P26_M1D;
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
    final int f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleInt.TWO_P25_M1D;
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

  public static double fromSignedNormalizedWithoutZero27(final int f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleInt.TWO_P27_M1D;
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
    final int f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleInt.TWO_P26_M1D;
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

  public static double fromSignedNormalizedWithoutZero28(final int f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleInt.TWO_P28_M1D;
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
    final int f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleInt.TWO_P27_M1D;
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

  public static double fromSignedNormalizedWithoutZero29(final int f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleInt.TWO_P29_M1D;
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
    final int f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleInt.TWO_P28_M1D;
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

  public static double fromSignedNormalizedWithoutZero30(final int f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleInt.TWO_P30_M1D;
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
    final int f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleInt.TWO_P29_M1D;
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

  public static double fromSignedNormalizedWithoutZero31(final int f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleInt.TWO_P31_M1D;
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
    final int f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleInt.TWO_P30_M1D;
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

  public static double fromSignedNormalizedWithoutZero32(final int f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleInt.TWO_P32_M1D;
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
    final int f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleInt.TWO_P31_M1D;
    return Math.max(-1.0, div);
  }
}
