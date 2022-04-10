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

import com.io7m.jnfp.core.NFPSignedDoubleLong;
import org.junit.Assert;
import org.junit.Test;

public final class NFPSignedDoubleLongTest
{
  @Test public void testBoundsWithoutZero()
  {
    for (int e = 2; e <= 64; ++e) {
      final long km1 =
        NFPSignedDoubleLong.toSignedNormalizedWithoutZero(-1.0, e);
      final double fm1 =
        NFPSignedDoubleLong.fromSignedNormalizedWithoutZero(km1, e);

      System.out.printf("[%d] km1: %s\n", e, Long.toString(km1));
      System.out.printf("[%d] fm1: %f\n", e, fm1);
      Assert.assertNotEquals(0, km1);
      Assert.assertEquals(-1.0, fm1, 0.000000000000001);

      final long kp1 =
        NFPSignedDoubleLong.toSignedNormalizedWithoutZero(1.0, e);
      final double fp1 =
        NFPSignedDoubleLong.fromSignedNormalizedWithoutZero(kp1, e);

      System.out.printf("[%d] kp1: %s\n", e, Long.toString(kp1));
      System.out.printf("[%d] fp1: %f\n", e, fp1);
      Assert.assertNotEquals(0, kp1);
      Assert.assertEquals(1.0, fp1, 0.000000000000001);
    }
  }

  @Test public void testBoundsWithZero()
  {
    for (int e = 2; e <= 64; ++e) {
      final long km1 = NFPSignedDoubleLong.toSignedNormalizedWithZero(-1.0, e);
      final double fm1 =
        NFPSignedDoubleLong.fromSignedNormalizedWithZero(km1, e);

      System.out.printf("[%d] km1: %s\n", e, Long.toString(km1));
      System.out.printf("[%d] fm1: %f\n", e, fm1);
      Assert.assertNotEquals(0, km1);
      Assert.assertEquals(-1.0, fm1, 0.000000000000001);

      final long kp1 = NFPSignedDoubleLong.toSignedNormalizedWithZero(1.0, e);
      final double fp1 =
        NFPSignedDoubleLong.fromSignedNormalizedWithZero(kp1, e);

      System.out.printf("[%d] kp1: %s\n", e, Long.toString(kp1));
      System.out.printf("[%d] fp1: %f\n", e, fp1);
      Assert.assertNotEquals(0, kp1);
      Assert.assertEquals(1.0, fp1, 0.000000000000001);

      final long k0 = NFPSignedDoubleLong.toSignedNormalizedWithZero(0.0, e);
      final double f0 = NFPSignedDoubleLong.fromSignedNormalizedWithZero(k0, e);

      System.out.printf("[%d] k0: %s\n", e, Long.toString(k0));
      System.out.printf("[%d] f0: %f\n", e, f0);
      Assert.assertEquals(0.0, f0, 0.0);
    }
  }
}
