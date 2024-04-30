/*
 * Copyright © 2015 Mark Raynsford <code@io7m.com> https://www.io7m.com
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

package com.io7m.jnfp.tests.core;

import com.io7m.jnfp.core.NFPSignedFloatInt;
import org.junit.Assert;
import org.junit.Test;

public final class NFPSignedFloatIntTest
{
  @Test public void testBoundsWithoutZero()
  {
    for (int e = 2; e <= 32; ++e) {
      final int km1 = NFPSignedFloatInt.toSignedNormalizedWithoutZero(-1.0f, e);
      final double fm1 =
        NFPSignedFloatInt.fromSignedNormalizedWithoutZero(km1, e);

      System.out.printf("[%d] km1: %s\n", e, Integer.toString(km1));
      System.out.printf("[%d] fm1: %f\n", e, fm1);
      Assert.assertNotEquals(0, km1);
      Assert.assertEquals(-1.0, fm1, 0.000000000000001);

      final int kp1 = NFPSignedFloatInt.toSignedNormalizedWithoutZero(1.0f, e);
      final double fp1 =
        NFPSignedFloatInt.fromSignedNormalizedWithoutZero(kp1, e);

      System.out.printf("[%d] kp1: %s\n", e, Integer.toString(kp1));
      System.out.printf("[%d] fp1: %f\n", e, fp1);
      Assert.assertNotEquals(0, kp1);
      Assert.assertEquals(1.0, fp1, 0.000000000000001);
    }
  }

  @Test public void testBoundsWithZero()
  {
    for (int e = 2; e <= 32; ++e) {
      final int km1 = NFPSignedFloatInt.toSignedNormalizedWithZero(-1.0f, e);
      final double fm1 = NFPSignedFloatInt.fromSignedNormalizedWithZero(km1, e);

      System.out.printf("[%d] km1: %s\n", e, Integer.toString(km1));
      System.out.printf("[%d] fm1: %f\n", e, fm1);
      Assert.assertNotEquals(0, km1);
      Assert.assertEquals(-1.0, fm1, 0.000000000000001);

      final int kp1 = NFPSignedFloatInt.toSignedNormalizedWithZero(1.0f, e);
      final double fp1 = NFPSignedFloatInt.fromSignedNormalizedWithZero(kp1, e);

      System.out.printf("[%d] kp1: %s\n", e, Integer.toString(kp1));
      System.out.printf("[%d] fp1: %f\n", e, fp1);
      Assert.assertNotEquals(0, kp1);
      Assert.assertEquals(1.0, fp1, 0.000000000000001);

      final int k0 = NFPSignedFloatInt.toSignedNormalizedWithZero(0.0f, e);
      final double f0 = NFPSignedFloatInt.fromSignedNormalizedWithZero(k0, e);

      System.out.printf("[%d] k0: %s\n", e, Integer.toString(k0));
      System.out.printf("[%d] f0: %f\n", e, f0);
      Assert.assertEquals(0.0, f0, 0.0);
    }
  }
}
