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

import com.io7m.jnfp.core.NFPUnsignedFloatLong;
import org.junit.Assert;
import org.junit.Test;

public final class NFPUnsignedFloatLongTest
{
  @Test public void testBounds()
  {
    for (int e = 2; e <= 64; ++e) {
      final long k0 = NFPUnsignedFloatLong.toUnsignedNormalized(0.0f, e);
      final float f0 = NFPUnsignedFloatLong.fromUnsignedNormalized(k0, e);

      System.out.printf("[%d] k0: %s\n", e, Long.toUnsignedString(k0));
      System.out.printf("[%d] f0: %f\n", e, f0);
      Assert.assertEquals(0L, k0);
      Assert.assertEquals(0.0, f0, 0.0);

      final long k1 = NFPUnsignedFloatLong.toUnsignedNormalized(1.0f, e);
      final float f1 = NFPUnsignedFloatLong.fromUnsignedNormalized(k1, e);

      System.out.printf("[%d] k1: %s\n", e, Long.toUnsignedString(k1));
      System.out.printf("[%d] f1: %f\n", e, f1);
      Assert.assertNotEquals(0, k1);
      Assert.assertEquals(1.0, f1, 0.0);
    }
  }
}
