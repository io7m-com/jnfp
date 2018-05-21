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
 */

public final class NFPUnsignedDoubleLong
{
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

}
