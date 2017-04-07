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

public final class NFPUnsignedDoubleInt
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
  }

  private NFPUnsignedDoubleInt()
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
    final int f,
    final int b)
  {
    final double twobm1 = StrictMath.pow(2.0, (double) b) - 1.0;
    return UnsignedDouble.fromUnsignedInt(f) / twobm1;
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

  public static int toUnsignedNormalized(
    final double x,
    final int b)
  {
    final double twobm1 = StrictMath.pow(2.0, (double) b) - 1.0;
    return UnsignedDouble.toUnsignedInt(x * twobm1);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 2 bits of precision
   */

  public static int toUnsignedNormalized2(final double x)
  {
    return UnsignedDouble.toUnsignedInt(x * NFPUnsignedDoubleInt.TWO_P2_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 3 bits of precision
   */

  public static int toUnsignedNormalized3(final double x)
  {
    return UnsignedDouble.toUnsignedInt(x * NFPUnsignedDoubleInt.TWO_P3_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 4 bits of precision
   */

  public static int toUnsignedNormalized4(final double x)
  {
    return UnsignedDouble.toUnsignedInt(x * NFPUnsignedDoubleInt.TWO_P4_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 5 bits of precision
   */

  public static int toUnsignedNormalized5(final double x)
  {
    return UnsignedDouble.toUnsignedInt(x * NFPUnsignedDoubleInt.TWO_P5_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 6 bits of precision
   */

  public static int toUnsignedNormalized6(final double x)
  {
    return UnsignedDouble.toUnsignedInt(x * NFPUnsignedDoubleInt.TWO_P6_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 7 bits of precision
   */

  public static int toUnsignedNormalized7(final double x)
  {
    return UnsignedDouble.toUnsignedInt(x * NFPUnsignedDoubleInt.TWO_P7_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 8 bits of precision
   */

  public static int toUnsignedNormalized8(final double x)
  {
    return UnsignedDouble.toUnsignedInt(x * NFPUnsignedDoubleInt.TWO_P8_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 9 bits of precision
   */

  public static int toUnsignedNormalized9(final double x)
  {
    return UnsignedDouble.toUnsignedInt(x * NFPUnsignedDoubleInt.TWO_P9_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 10 bits of precision
   */

  public static int toUnsignedNormalized10(final double x)
  {
    return UnsignedDouble.toUnsignedInt(x * NFPUnsignedDoubleInt.TWO_P10_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 11 bits of precision
   */

  public static int toUnsignedNormalized11(final double x)
  {
    return UnsignedDouble.toUnsignedInt(x * NFPUnsignedDoubleInt.TWO_P11_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 12 bits of precision
   */

  public static int toUnsignedNormalized12(final double x)
  {
    return UnsignedDouble.toUnsignedInt(x * NFPUnsignedDoubleInt.TWO_P12_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 13 bits of precision
   */

  public static int toUnsignedNormalized13(final double x)
  {
    return UnsignedDouble.toUnsignedInt(x * NFPUnsignedDoubleInt.TWO_P13_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 14 bits of precision
   */

  public static int toUnsignedNormalized14(final double x)
  {
    return UnsignedDouble.toUnsignedInt(x * NFPUnsignedDoubleInt.TWO_P14_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 15 bits of precision
   */

  public static int toUnsignedNormalized15(final double x)
  {
    return UnsignedDouble.toUnsignedInt(x * NFPUnsignedDoubleInt.TWO_P15_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 16 bits of precision
   */

  public static int toUnsignedNormalized16(final double x)
  {
    return UnsignedDouble.toUnsignedInt(x * NFPUnsignedDoubleInt.TWO_P16_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 17 bits of precision
   */

  public static int toUnsignedNormalized17(final double x)
  {
    return UnsignedDouble.toUnsignedInt(x * NFPUnsignedDoubleInt.TWO_P17_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 18 bits of precision
   */

  public static int toUnsignedNormalized18(final double x)
  {
    return UnsignedDouble.toUnsignedInt(x * NFPUnsignedDoubleInt.TWO_P18_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 19 bits of precision
   */

  public static int toUnsignedNormalized19(final double x)
  {
    return UnsignedDouble.toUnsignedInt(x * NFPUnsignedDoubleInt.TWO_P19_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 20 bits of precision
   */

  public static int toUnsignedNormalized20(final double x)
  {
    return UnsignedDouble.toUnsignedInt(x * NFPUnsignedDoubleInt.TWO_P20_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 21 bits of precision
   */

  public static int toUnsignedNormalized21(final double x)
  {
    return UnsignedDouble.toUnsignedInt(x * NFPUnsignedDoubleInt.TWO_P21_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 22 bits of precision
   */

  public static int toUnsignedNormalized22(final double x)
  {
    return UnsignedDouble.toUnsignedInt(x * NFPUnsignedDoubleInt.TWO_P22_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 23 bits of precision
   */

  public static int toUnsignedNormalized23(final double x)
  {
    return UnsignedDouble.toUnsignedInt(x * NFPUnsignedDoubleInt.TWO_P23_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 24 bits of precision
   */

  public static int toUnsignedNormalized24(final double x)
  {
    return UnsignedDouble.toUnsignedInt(x * NFPUnsignedDoubleInt.TWO_P24_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 25 bits of precision
   */

  public static int toUnsignedNormalized25(final double x)
  {
    return UnsignedDouble.toUnsignedInt(x * NFPUnsignedDoubleInt.TWO_P25_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 26 bits of precision
   */

  public static int toUnsignedNormalized26(final double x)
  {
    return UnsignedDouble.toUnsignedInt(x * NFPUnsignedDoubleInt.TWO_P26_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 27 bits of precision
   */

  public static int toUnsignedNormalized27(final double x)
  {
    return UnsignedDouble.toUnsignedInt(x * NFPUnsignedDoubleInt.TWO_P27_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 28 bits of precision
   */

  public static int toUnsignedNormalized28(final double x)
  {
    return UnsignedDouble.toUnsignedInt(x * NFPUnsignedDoubleInt.TWO_P28_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 29 bits of precision
   */

  public static int toUnsignedNormalized29(final double x)
  {
    return UnsignedDouble.toUnsignedInt(x * NFPUnsignedDoubleInt.TWO_P29_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 30 bits of precision
   */

  public static int toUnsignedNormalized30(final double x)
  {
    return UnsignedDouble.toUnsignedInt(x * NFPUnsignedDoubleInt.TWO_P30_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 31 bits of precision
   */

  public static int toUnsignedNormalized31(final double x)
  {
    return UnsignedDouble.toUnsignedInt(x * NFPUnsignedDoubleInt.TWO_P31_M1D);
  }

  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with 32 bits of precision
   */

  public static int toUnsignedNormalized32(final double x)
  {
    return UnsignedDouble.toUnsignedInt(x * NFPUnsignedDoubleInt.TWO_P32_M1D);
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 2) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized2(final int f)
  {
    final double fv = UnsignedDouble.fromUnsignedInt(f);
    return fv / NFPUnsignedDoubleInt.TWO_P2_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 3) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized3(final int f)
  {
    final double fv = UnsignedDouble.fromUnsignedInt(f);
    return fv / NFPUnsignedDoubleInt.TWO_P3_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 4) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized4(final int f)
  {
    final double fv = UnsignedDouble.fromUnsignedInt(f);
    return fv / NFPUnsignedDoubleInt.TWO_P4_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 5) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized5(final int f)
  {
    final double fv = UnsignedDouble.fromUnsignedInt(f);
    return fv / NFPUnsignedDoubleInt.TWO_P5_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 6) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized6(final int f)
  {
    final double fv = UnsignedDouble.fromUnsignedInt(f);
    return fv / NFPUnsignedDoubleInt.TWO_P6_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 7) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized7(final int f)
  {
    final double fv = UnsignedDouble.fromUnsignedInt(f);
    return fv / NFPUnsignedDoubleInt.TWO_P7_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 8) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized8(final int f)
  {
    final double fv = UnsignedDouble.fromUnsignedInt(f);
    return fv / NFPUnsignedDoubleInt.TWO_P8_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 9) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized9(final int f)
  {
    final double fv = UnsignedDouble.fromUnsignedInt(f);
    return fv / NFPUnsignedDoubleInt.TWO_P9_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 10) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized10(final int f)
  {
    final double fv = UnsignedDouble.fromUnsignedInt(f);
    return fv / NFPUnsignedDoubleInt.TWO_P10_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 11) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized11(final int f)
  {
    final double fv = UnsignedDouble.fromUnsignedInt(f);
    return fv / NFPUnsignedDoubleInt.TWO_P11_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 12) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized12(final int f)
  {
    final double fv = UnsignedDouble.fromUnsignedInt(f);
    return fv / NFPUnsignedDoubleInt.TWO_P12_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 13) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized13(final int f)
  {
    final double fv = UnsignedDouble.fromUnsignedInt(f);
    return fv / NFPUnsignedDoubleInt.TWO_P13_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 14) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized14(final int f)
  {
    final double fv = UnsignedDouble.fromUnsignedInt(f);
    return fv / NFPUnsignedDoubleInt.TWO_P14_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 15) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized15(final int f)
  {
    final double fv = UnsignedDouble.fromUnsignedInt(f);
    return fv / NFPUnsignedDoubleInt.TWO_P15_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 16) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized16(final int f)
  {
    final double fv = UnsignedDouble.fromUnsignedInt(f);
    return fv / NFPUnsignedDoubleInt.TWO_P16_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 17) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized17(final int f)
  {
    final double fv = UnsignedDouble.fromUnsignedInt(f);
    return fv / NFPUnsignedDoubleInt.TWO_P17_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 18) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized18(final int f)
  {
    final double fv = UnsignedDouble.fromUnsignedInt(f);
    return fv / NFPUnsignedDoubleInt.TWO_P18_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 19) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized19(final int f)
  {
    final double fv = UnsignedDouble.fromUnsignedInt(f);
    return fv / NFPUnsignedDoubleInt.TWO_P19_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 20) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized20(final int f)
  {
    final double fv = UnsignedDouble.fromUnsignedInt(f);
    return fv / NFPUnsignedDoubleInt.TWO_P20_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 21) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized21(final int f)
  {
    final double fv = UnsignedDouble.fromUnsignedInt(f);
    return fv / NFPUnsignedDoubleInt.TWO_P21_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 22) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized22(final int f)
  {
    final double fv = UnsignedDouble.fromUnsignedInt(f);
    return fv / NFPUnsignedDoubleInt.TWO_P22_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 23) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized23(final int f)
  {
    final double fv = UnsignedDouble.fromUnsignedInt(f);
    return fv / NFPUnsignedDoubleInt.TWO_P23_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 24) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized24(final int f)
  {
    final double fv = UnsignedDouble.fromUnsignedInt(f);
    return fv / NFPUnsignedDoubleInt.TWO_P24_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 25) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized25(final int f)
  {
    final double fv = UnsignedDouble.fromUnsignedInt(f);
    return fv / NFPUnsignedDoubleInt.TWO_P25_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 26) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized26(final int f)
  {
    final double fv = UnsignedDouble.fromUnsignedInt(f);
    return fv / NFPUnsignedDoubleInt.TWO_P26_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 27) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized27(final int f)
  {
    final double fv = UnsignedDouble.fromUnsignedInt(f);
    return fv / NFPUnsignedDoubleInt.TWO_P27_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 28) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized28(final int f)
  {
    final double fv = UnsignedDouble.fromUnsignedInt(f);
    return fv / NFPUnsignedDoubleInt.TWO_P28_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 29) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized29(final int f)
  {
    final double fv = UnsignedDouble.fromUnsignedInt(f);
    return fv / NFPUnsignedDoubleInt.TWO_P29_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 30) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized30(final int f)
  {
    final double fv = UnsignedDouble.fromUnsignedInt(f);
    return fv / NFPUnsignedDoubleInt.TWO_P30_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 31) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized31(final int f)
  {
    final double fv = UnsignedDouble.fromUnsignedInt(f);
    return fv / NFPUnsignedDoubleInt.TWO_P31_M1D;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ 32) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized32(final int f)
  {
    final double fv = UnsignedDouble.fromUnsignedInt(f);
    return fv / NFPUnsignedDoubleInt.TWO_P32_M1D;
  }
}
