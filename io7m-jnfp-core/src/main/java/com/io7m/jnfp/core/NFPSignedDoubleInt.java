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
}
