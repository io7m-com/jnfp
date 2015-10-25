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

package com.io7m.jnfp.tests.core;

import com.io7m.jnfp.core.NFPUnsignedDoubleLong;
import org.junit.Assert;
import org.junit.Test;

public final class NFPUnsignedDoubleLongTest
{
  @Test public void testBounds()
  {
    for (int e = 2; e <= 64; ++e) {
      final long k0 = NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, e);
      final double f0 = NFPUnsignedDoubleLong.fromUnsignedNormalized(k0, e);

      System.out.printf("[%d] k0: %s\n", e, Long.toUnsignedString(k0));
      System.out.printf("[%d] f0: %f\n", e, f0);
      Assert.assertEquals(0L, k0);
      Assert.assertEquals(0.0, f0, 0.0);

      final long k1 = NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, e);
      final double f1 = NFPUnsignedDoubleLong.fromUnsignedNormalized(k1, e);

      System.out.printf("[%d] k1: %s\n", e, Long.toUnsignedString(k1));
      System.out.printf("[%d] f1: %f\n", e, f1);
      Assert.assertNotEquals(0, k1);
      Assert.assertEquals(1.0, f1, 0.0);
    }
  }

  @Test public void testBounds2()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 2);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 2);
    final long k2_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized2(0.0);
    final long k2_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized2(1.0);

    final double f2_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized2(k2_0);
    final double f2_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized2(k2_1);
    final double f2_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k2_0, 2);
    final double f2_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k2_1, 2);

    System.out.printf("[2] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[2] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[2] k2_0: %s\n", Long.toUnsignedString(k2_0));
    System.out.printf("[2] k2_1: %s\n", Long.toUnsignedString(k2_1));
    System.out.printf("[2] f2_0a: %f\n", f2_0a);
    System.out.printf("[2] f2_1a: %f\n", f2_1a);
    System.out.printf("[2] f2_0b: %f\n", f2_0b);
    System.out.printf("[2] f2_1b: %f\n", f2_1b);

    Assert.assertEquals(k2_0, k0);
    Assert.assertEquals(k2_1, k1);
    Assert.assertEquals(f2_0a, 0.0, 0.0);
    Assert.assertEquals(f2_1a, 1.0, 0.0);
    Assert.assertEquals(f2_0b, 0.0, 0.0);
    Assert.assertEquals(f2_1b, 1.0, 0.0);
    Assert.assertEquals(f2_0a, f2_0b, 0.0);
    Assert.assertEquals(f2_1a, f2_1b, 0.0);
  }

  @Test public void testBounds3()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 3);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 3);
    final long k3_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized3(0.0);
    final long k3_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized3(1.0);

    final double f3_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized3(k3_0);
    final double f3_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized3(k3_1);
    final double f3_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k3_0, 3);
    final double f3_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k3_1, 3);

    System.out.printf("[3] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[3] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[3] k3_0: %s\n", Long.toUnsignedString(k3_0));
    System.out.printf("[3] k3_1: %s\n", Long.toUnsignedString(k3_1));
    System.out.printf("[3] f3_0a: %f\n", f3_0a);
    System.out.printf("[3] f3_1a: %f\n", f3_1a);
    System.out.printf("[3] f3_0b: %f\n", f3_0b);
    System.out.printf("[3] f3_1b: %f\n", f3_1b);

    Assert.assertEquals(k3_0, k0);
    Assert.assertEquals(k3_1, k1);
    Assert.assertEquals(f3_0a, 0.0, 0.0);
    Assert.assertEquals(f3_1a, 1.0, 0.0);
    Assert.assertEquals(f3_0b, 0.0, 0.0);
    Assert.assertEquals(f3_1b, 1.0, 0.0);
    Assert.assertEquals(f3_0a, f3_0b, 0.0);
    Assert.assertEquals(f3_1a, f3_1b, 0.0);
  }

  @Test public void testBounds4()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 4);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 4);
    final long k4_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized4(0.0);
    final long k4_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized4(1.0);

    final double f4_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized4(k4_0);
    final double f4_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized4(k4_1);
    final double f4_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k4_0, 4);
    final double f4_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k4_1, 4);

    System.out.printf("[4] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[4] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[4] k4_0: %s\n", Long.toUnsignedString(k4_0));
    System.out.printf("[4] k4_1: %s\n", Long.toUnsignedString(k4_1));
    System.out.printf("[4] f4_0a: %f\n", f4_0a);
    System.out.printf("[4] f4_1a: %f\n", f4_1a);
    System.out.printf("[4] f4_0b: %f\n", f4_0b);
    System.out.printf("[4] f4_1b: %f\n", f4_1b);

    Assert.assertEquals(k4_0, k0);
    Assert.assertEquals(k4_1, k1);
    Assert.assertEquals(f4_0a, 0.0, 0.0);
    Assert.assertEquals(f4_1a, 1.0, 0.0);
    Assert.assertEquals(f4_0b, 0.0, 0.0);
    Assert.assertEquals(f4_1b, 1.0, 0.0);
    Assert.assertEquals(f4_0a, f4_0b, 0.0);
    Assert.assertEquals(f4_1a, f4_1b, 0.0);
  }

  @Test public void testBounds5()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 5);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 5);
    final long k5_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized5(0.0);
    final long k5_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized5(1.0);

    final double f5_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized5(k5_0);
    final double f5_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized5(k5_1);
    final double f5_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k5_0, 5);
    final double f5_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k5_1, 5);

    System.out.printf("[5] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[5] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[5] k5_0: %s\n", Long.toUnsignedString(k5_0));
    System.out.printf("[5] k5_1: %s\n", Long.toUnsignedString(k5_1));
    System.out.printf("[5] f5_0a: %f\n", f5_0a);
    System.out.printf("[5] f5_1a: %f\n", f5_1a);
    System.out.printf("[5] f5_0b: %f\n", f5_0b);
    System.out.printf("[5] f5_1b: %f\n", f5_1b);

    Assert.assertEquals(k5_0, k0);
    Assert.assertEquals(k5_1, k1);
    Assert.assertEquals(f5_0a, 0.0, 0.0);
    Assert.assertEquals(f5_1a, 1.0, 0.0);
    Assert.assertEquals(f5_0b, 0.0, 0.0);
    Assert.assertEquals(f5_1b, 1.0, 0.0);
    Assert.assertEquals(f5_0a, f5_0b, 0.0);
    Assert.assertEquals(f5_1a, f5_1b, 0.0);
  }

  @Test public void testBounds6()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 6);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 6);
    final long k6_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized6(0.0);
    final long k6_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized6(1.0);

    final double f6_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized6(k6_0);
    final double f6_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized6(k6_1);
    final double f6_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k6_0, 6);
    final double f6_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k6_1, 6);

    System.out.printf("[6] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[6] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[6] k6_0: %s\n", Long.toUnsignedString(k6_0));
    System.out.printf("[6] k6_1: %s\n", Long.toUnsignedString(k6_1));
    System.out.printf("[6] f6_0a: %f\n", f6_0a);
    System.out.printf("[6] f6_1a: %f\n", f6_1a);
    System.out.printf("[6] f6_0b: %f\n", f6_0b);
    System.out.printf("[6] f6_1b: %f\n", f6_1b);

    Assert.assertEquals(k6_0, k0);
    Assert.assertEquals(k6_1, k1);
    Assert.assertEquals(f6_0a, 0.0, 0.0);
    Assert.assertEquals(f6_1a, 1.0, 0.0);
    Assert.assertEquals(f6_0b, 0.0, 0.0);
    Assert.assertEquals(f6_1b, 1.0, 0.0);
    Assert.assertEquals(f6_0a, f6_0b, 0.0);
    Assert.assertEquals(f6_1a, f6_1b, 0.0);
  }

  @Test public void testBounds7()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 7);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 7);
    final long k7_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized7(0.0);
    final long k7_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized7(1.0);

    final double f7_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized7(k7_0);
    final double f7_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized7(k7_1);
    final double f7_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k7_0, 7);
    final double f7_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k7_1, 7);

    System.out.printf("[7] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[7] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[7] k7_0: %s\n", Long.toUnsignedString(k7_0));
    System.out.printf("[7] k7_1: %s\n", Long.toUnsignedString(k7_1));
    System.out.printf("[7] f7_0a: %f\n", f7_0a);
    System.out.printf("[7] f7_1a: %f\n", f7_1a);
    System.out.printf("[7] f7_0b: %f\n", f7_0b);
    System.out.printf("[7] f7_1b: %f\n", f7_1b);

    Assert.assertEquals(k7_0, k0);
    Assert.assertEquals(k7_1, k1);
    Assert.assertEquals(f7_0a, 0.0, 0.0);
    Assert.assertEquals(f7_1a, 1.0, 0.0);
    Assert.assertEquals(f7_0b, 0.0, 0.0);
    Assert.assertEquals(f7_1b, 1.0, 0.0);
    Assert.assertEquals(f7_0a, f7_0b, 0.0);
    Assert.assertEquals(f7_1a, f7_1b, 0.0);
  }

  @Test public void testBounds8()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 8);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 8);
    final long k8_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized8(0.0);
    final long k8_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized8(1.0);

    final double f8_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized8(k8_0);
    final double f8_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized8(k8_1);
    final double f8_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k8_0, 8);
    final double f8_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k8_1, 8);

    System.out.printf("[8] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[8] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[8] k8_0: %s\n", Long.toUnsignedString(k8_0));
    System.out.printf("[8] k8_1: %s\n", Long.toUnsignedString(k8_1));
    System.out.printf("[8] f8_0a: %f\n", f8_0a);
    System.out.printf("[8] f8_1a: %f\n", f8_1a);
    System.out.printf("[8] f8_0b: %f\n", f8_0b);
    System.out.printf("[8] f8_1b: %f\n", f8_1b);

    Assert.assertEquals(k8_0, k0);
    Assert.assertEquals(k8_1, k1);
    Assert.assertEquals(f8_0a, 0.0, 0.0);
    Assert.assertEquals(f8_1a, 1.0, 0.0);
    Assert.assertEquals(f8_0b, 0.0, 0.0);
    Assert.assertEquals(f8_1b, 1.0, 0.0);
    Assert.assertEquals(f8_0a, f8_0b, 0.0);
    Assert.assertEquals(f8_1a, f8_1b, 0.0);
  }

  @Test public void testBounds9()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 9);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 9);
    final long k9_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized9(0.0);
    final long k9_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized9(1.0);

    final double f9_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized9(k9_0);
    final double f9_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized9(k9_1);
    final double f9_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k9_0, 9);
    final double f9_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k9_1, 9);

    System.out.printf("[9] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[9] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[9] k9_0: %s\n", Long.toUnsignedString(k9_0));
    System.out.printf("[9] k9_1: %s\n", Long.toUnsignedString(k9_1));
    System.out.printf("[9] f9_0a: %f\n", f9_0a);
    System.out.printf("[9] f9_1a: %f\n", f9_1a);
    System.out.printf("[9] f9_0b: %f\n", f9_0b);
    System.out.printf("[9] f9_1b: %f\n", f9_1b);

    Assert.assertEquals(k9_0, k0);
    Assert.assertEquals(k9_1, k1);
    Assert.assertEquals(f9_0a, 0.0, 0.0);
    Assert.assertEquals(f9_1a, 1.0, 0.0);
    Assert.assertEquals(f9_0b, 0.0, 0.0);
    Assert.assertEquals(f9_1b, 1.0, 0.0);
    Assert.assertEquals(f9_0a, f9_0b, 0.0);
    Assert.assertEquals(f9_1a, f9_1b, 0.0);
  }

  @Test public void testBounds10()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 10);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 10);
    final long k10_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized10(0.0);
    final long k10_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized10(1.0);

    final double f10_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized10(k10_0);
    final double f10_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized10(k10_1);
    final double f10_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k10_0, 10);
    final double f10_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k10_1, 10);

    System.out.printf("[10] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[10] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[10] k10_0: %s\n", Long.toUnsignedString(k10_0));
    System.out.printf("[10] k10_1: %s\n", Long.toUnsignedString(k10_1));
    System.out.printf("[10] f10_0a: %f\n", f10_0a);
    System.out.printf("[10] f10_1a: %f\n", f10_1a);
    System.out.printf("[10] f10_0b: %f\n", f10_0b);
    System.out.printf("[10] f10_1b: %f\n", f10_1b);

    Assert.assertEquals(k10_0, k0);
    Assert.assertEquals(k10_1, k1);
    Assert.assertEquals(f10_0a, 0.0, 0.0);
    Assert.assertEquals(f10_1a, 1.0, 0.0);
    Assert.assertEquals(f10_0b, 0.0, 0.0);
    Assert.assertEquals(f10_1b, 1.0, 0.0);
    Assert.assertEquals(f10_0a, f10_0b, 0.0);
    Assert.assertEquals(f10_1a, f10_1b, 0.0);
  }

  @Test public void testBounds11()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 11);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 11);
    final long k11_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized11(0.0);
    final long k11_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized11(1.0);

    final double f11_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized11(k11_0);
    final double f11_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized11(k11_1);
    final double f11_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k11_0, 11);
    final double f11_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k11_1, 11);

    System.out.printf("[11] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[11] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[11] k11_0: %s\n", Long.toUnsignedString(k11_0));
    System.out.printf("[11] k11_1: %s\n", Long.toUnsignedString(k11_1));
    System.out.printf("[11] f11_0a: %f\n", f11_0a);
    System.out.printf("[11] f11_1a: %f\n", f11_1a);
    System.out.printf("[11] f11_0b: %f\n", f11_0b);
    System.out.printf("[11] f11_1b: %f\n", f11_1b);

    Assert.assertEquals(k11_0, k0);
    Assert.assertEquals(k11_1, k1);
    Assert.assertEquals(f11_0a, 0.0, 0.0);
    Assert.assertEquals(f11_1a, 1.0, 0.0);
    Assert.assertEquals(f11_0b, 0.0, 0.0);
    Assert.assertEquals(f11_1b, 1.0, 0.0);
    Assert.assertEquals(f11_0a, f11_0b, 0.0);
    Assert.assertEquals(f11_1a, f11_1b, 0.0);
  }

  @Test public void testBounds12()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 12);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 12);
    final long k12_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized12(0.0);
    final long k12_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized12(1.0);

    final double f12_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized12(k12_0);
    final double f12_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized12(k12_1);
    final double f12_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k12_0, 12);
    final double f12_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k12_1, 12);

    System.out.printf("[12] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[12] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[12] k12_0: %s\n", Long.toUnsignedString(k12_0));
    System.out.printf("[12] k12_1: %s\n", Long.toUnsignedString(k12_1));
    System.out.printf("[12] f12_0a: %f\n", f12_0a);
    System.out.printf("[12] f12_1a: %f\n", f12_1a);
    System.out.printf("[12] f12_0b: %f\n", f12_0b);
    System.out.printf("[12] f12_1b: %f\n", f12_1b);

    Assert.assertEquals(k12_0, k0);
    Assert.assertEquals(k12_1, k1);
    Assert.assertEquals(f12_0a, 0.0, 0.0);
    Assert.assertEquals(f12_1a, 1.0, 0.0);
    Assert.assertEquals(f12_0b, 0.0, 0.0);
    Assert.assertEquals(f12_1b, 1.0, 0.0);
    Assert.assertEquals(f12_0a, f12_0b, 0.0);
    Assert.assertEquals(f12_1a, f12_1b, 0.0);
  }

  @Test public void testBounds13()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 13);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 13);
    final long k13_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized13(0.0);
    final long k13_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized13(1.0);

    final double f13_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized13(k13_0);
    final double f13_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized13(k13_1);
    final double f13_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k13_0, 13);
    final double f13_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k13_1, 13);

    System.out.printf("[13] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[13] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[13] k13_0: %s\n", Long.toUnsignedString(k13_0));
    System.out.printf("[13] k13_1: %s\n", Long.toUnsignedString(k13_1));
    System.out.printf("[13] f13_0a: %f\n", f13_0a);
    System.out.printf("[13] f13_1a: %f\n", f13_1a);
    System.out.printf("[13] f13_0b: %f\n", f13_0b);
    System.out.printf("[13] f13_1b: %f\n", f13_1b);

    Assert.assertEquals(k13_0, k0);
    Assert.assertEquals(k13_1, k1);
    Assert.assertEquals(f13_0a, 0.0, 0.0);
    Assert.assertEquals(f13_1a, 1.0, 0.0);
    Assert.assertEquals(f13_0b, 0.0, 0.0);
    Assert.assertEquals(f13_1b, 1.0, 0.0);
    Assert.assertEquals(f13_0a, f13_0b, 0.0);
    Assert.assertEquals(f13_1a, f13_1b, 0.0);
  }

  @Test public void testBounds14()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 14);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 14);
    final long k14_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized14(0.0);
    final long k14_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized14(1.0);

    final double f14_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized14(k14_0);
    final double f14_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized14(k14_1);
    final double f14_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k14_0, 14);
    final double f14_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k14_1, 14);

    System.out.printf("[14] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[14] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[14] k14_0: %s\n", Long.toUnsignedString(k14_0));
    System.out.printf("[14] k14_1: %s\n", Long.toUnsignedString(k14_1));
    System.out.printf("[14] f14_0a: %f\n", f14_0a);
    System.out.printf("[14] f14_1a: %f\n", f14_1a);
    System.out.printf("[14] f14_0b: %f\n", f14_0b);
    System.out.printf("[14] f14_1b: %f\n", f14_1b);

    Assert.assertEquals(k14_0, k0);
    Assert.assertEquals(k14_1, k1);
    Assert.assertEquals(f14_0a, 0.0, 0.0);
    Assert.assertEquals(f14_1a, 1.0, 0.0);
    Assert.assertEquals(f14_0b, 0.0, 0.0);
    Assert.assertEquals(f14_1b, 1.0, 0.0);
    Assert.assertEquals(f14_0a, f14_0b, 0.0);
    Assert.assertEquals(f14_1a, f14_1b, 0.0);
  }

  @Test public void testBounds15()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 15);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 15);
    final long k15_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized15(0.0);
    final long k15_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized15(1.0);

    final double f15_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized15(k15_0);
    final double f15_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized15(k15_1);
    final double f15_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k15_0, 15);
    final double f15_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k15_1, 15);

    System.out.printf("[15] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[15] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[15] k15_0: %s\n", Long.toUnsignedString(k15_0));
    System.out.printf("[15] k15_1: %s\n", Long.toUnsignedString(k15_1));
    System.out.printf("[15] f15_0a: %f\n", f15_0a);
    System.out.printf("[15] f15_1a: %f\n", f15_1a);
    System.out.printf("[15] f15_0b: %f\n", f15_0b);
    System.out.printf("[15] f15_1b: %f\n", f15_1b);

    Assert.assertEquals(k15_0, k0);
    Assert.assertEquals(k15_1, k1);
    Assert.assertEquals(f15_0a, 0.0, 0.0);
    Assert.assertEquals(f15_1a, 1.0, 0.0);
    Assert.assertEquals(f15_0b, 0.0, 0.0);
    Assert.assertEquals(f15_1b, 1.0, 0.0);
    Assert.assertEquals(f15_0a, f15_0b, 0.0);
    Assert.assertEquals(f15_1a, f15_1b, 0.0);
  }

  @Test public void testBounds16()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 16);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 16);
    final long k16_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized16(0.0);
    final long k16_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized16(1.0);

    final double f16_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized16(k16_0);
    final double f16_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized16(k16_1);
    final double f16_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k16_0, 16);
    final double f16_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k16_1, 16);

    System.out.printf("[16] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[16] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[16] k16_0: %s\n", Long.toUnsignedString(k16_0));
    System.out.printf("[16] k16_1: %s\n", Long.toUnsignedString(k16_1));
    System.out.printf("[16] f16_0a: %f\n", f16_0a);
    System.out.printf("[16] f16_1a: %f\n", f16_1a);
    System.out.printf("[16] f16_0b: %f\n", f16_0b);
    System.out.printf("[16] f16_1b: %f\n", f16_1b);

    Assert.assertEquals(k16_0, k0);
    Assert.assertEquals(k16_1, k1);
    Assert.assertEquals(f16_0a, 0.0, 0.0);
    Assert.assertEquals(f16_1a, 1.0, 0.0);
    Assert.assertEquals(f16_0b, 0.0, 0.0);
    Assert.assertEquals(f16_1b, 1.0, 0.0);
    Assert.assertEquals(f16_0a, f16_0b, 0.0);
    Assert.assertEquals(f16_1a, f16_1b, 0.0);
  }

  @Test public void testBounds17()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 17);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 17);
    final long k17_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized17(0.0);
    final long k17_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized17(1.0);

    final double f17_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized17(k17_0);
    final double f17_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized17(k17_1);
    final double f17_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k17_0, 17);
    final double f17_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k17_1, 17);

    System.out.printf("[17] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[17] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[17] k17_0: %s\n", Long.toUnsignedString(k17_0));
    System.out.printf("[17] k17_1: %s\n", Long.toUnsignedString(k17_1));
    System.out.printf("[17] f17_0a: %f\n", f17_0a);
    System.out.printf("[17] f17_1a: %f\n", f17_1a);
    System.out.printf("[17] f17_0b: %f\n", f17_0b);
    System.out.printf("[17] f17_1b: %f\n", f17_1b);

    Assert.assertEquals(k17_0, k0);
    Assert.assertEquals(k17_1, k1);
    Assert.assertEquals(f17_0a, 0.0, 0.0);
    Assert.assertEquals(f17_1a, 1.0, 0.0);
    Assert.assertEquals(f17_0b, 0.0, 0.0);
    Assert.assertEquals(f17_1b, 1.0, 0.0);
    Assert.assertEquals(f17_0a, f17_0b, 0.0);
    Assert.assertEquals(f17_1a, f17_1b, 0.0);
  }

  @Test public void testBounds18()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 18);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 18);
    final long k18_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized18(0.0);
    final long k18_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized18(1.0);

    final double f18_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized18(k18_0);
    final double f18_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized18(k18_1);
    final double f18_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k18_0, 18);
    final double f18_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k18_1, 18);

    System.out.printf("[18] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[18] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[18] k18_0: %s\n", Long.toUnsignedString(k18_0));
    System.out.printf("[18] k18_1: %s\n", Long.toUnsignedString(k18_1));
    System.out.printf("[18] f18_0a: %f\n", f18_0a);
    System.out.printf("[18] f18_1a: %f\n", f18_1a);
    System.out.printf("[18] f18_0b: %f\n", f18_0b);
    System.out.printf("[18] f18_1b: %f\n", f18_1b);

    Assert.assertEquals(k18_0, k0);
    Assert.assertEquals(k18_1, k1);
    Assert.assertEquals(f18_0a, 0.0, 0.0);
    Assert.assertEquals(f18_1a, 1.0, 0.0);
    Assert.assertEquals(f18_0b, 0.0, 0.0);
    Assert.assertEquals(f18_1b, 1.0, 0.0);
    Assert.assertEquals(f18_0a, f18_0b, 0.0);
    Assert.assertEquals(f18_1a, f18_1b, 0.0);
  }

  @Test public void testBounds19()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 19);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 19);
    final long k19_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized19(0.0);
    final long k19_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized19(1.0);

    final double f19_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized19(k19_0);
    final double f19_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized19(k19_1);
    final double f19_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k19_0, 19);
    final double f19_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k19_1, 19);

    System.out.printf("[19] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[19] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[19] k19_0: %s\n", Long.toUnsignedString(k19_0));
    System.out.printf("[19] k19_1: %s\n", Long.toUnsignedString(k19_1));
    System.out.printf("[19] f19_0a: %f\n", f19_0a);
    System.out.printf("[19] f19_1a: %f\n", f19_1a);
    System.out.printf("[19] f19_0b: %f\n", f19_0b);
    System.out.printf("[19] f19_1b: %f\n", f19_1b);

    Assert.assertEquals(k19_0, k0);
    Assert.assertEquals(k19_1, k1);
    Assert.assertEquals(f19_0a, 0.0, 0.0);
    Assert.assertEquals(f19_1a, 1.0, 0.0);
    Assert.assertEquals(f19_0b, 0.0, 0.0);
    Assert.assertEquals(f19_1b, 1.0, 0.0);
    Assert.assertEquals(f19_0a, f19_0b, 0.0);
    Assert.assertEquals(f19_1a, f19_1b, 0.0);
  }

  @Test public void testBounds20()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 20);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 20);
    final long k20_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized20(0.0);
    final long k20_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized20(1.0);

    final double f20_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized20(k20_0);
    final double f20_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized20(k20_1);
    final double f20_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k20_0, 20);
    final double f20_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k20_1, 20);

    System.out.printf("[20] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[20] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[20] k20_0: %s\n", Long.toUnsignedString(k20_0));
    System.out.printf("[20] k20_1: %s\n", Long.toUnsignedString(k20_1));
    System.out.printf("[20] f20_0a: %f\n", f20_0a);
    System.out.printf("[20] f20_1a: %f\n", f20_1a);
    System.out.printf("[20] f20_0b: %f\n", f20_0b);
    System.out.printf("[20] f20_1b: %f\n", f20_1b);

    Assert.assertEquals(k20_0, k0);
    Assert.assertEquals(k20_1, k1);
    Assert.assertEquals(f20_0a, 0.0, 0.0);
    Assert.assertEquals(f20_1a, 1.0, 0.0);
    Assert.assertEquals(f20_0b, 0.0, 0.0);
    Assert.assertEquals(f20_1b, 1.0, 0.0);
    Assert.assertEquals(f20_0a, f20_0b, 0.0);
    Assert.assertEquals(f20_1a, f20_1b, 0.0);
  }

  @Test public void testBounds21()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 21);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 21);
    final long k21_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized21(0.0);
    final long k21_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized21(1.0);

    final double f21_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized21(k21_0);
    final double f21_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized21(k21_1);
    final double f21_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k21_0, 21);
    final double f21_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k21_1, 21);

    System.out.printf("[21] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[21] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[21] k21_0: %s\n", Long.toUnsignedString(k21_0));
    System.out.printf("[21] k21_1: %s\n", Long.toUnsignedString(k21_1));
    System.out.printf("[21] f21_0a: %f\n", f21_0a);
    System.out.printf("[21] f21_1a: %f\n", f21_1a);
    System.out.printf("[21] f21_0b: %f\n", f21_0b);
    System.out.printf("[21] f21_1b: %f\n", f21_1b);

    Assert.assertEquals(k21_0, k0);
    Assert.assertEquals(k21_1, k1);
    Assert.assertEquals(f21_0a, 0.0, 0.0);
    Assert.assertEquals(f21_1a, 1.0, 0.0);
    Assert.assertEquals(f21_0b, 0.0, 0.0);
    Assert.assertEquals(f21_1b, 1.0, 0.0);
    Assert.assertEquals(f21_0a, f21_0b, 0.0);
    Assert.assertEquals(f21_1a, f21_1b, 0.0);
  }

  @Test public void testBounds22()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 22);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 22);
    final long k22_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized22(0.0);
    final long k22_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized22(1.0);

    final double f22_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized22(k22_0);
    final double f22_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized22(k22_1);
    final double f22_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k22_0, 22);
    final double f22_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k22_1, 22);

    System.out.printf("[22] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[22] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[22] k22_0: %s\n", Long.toUnsignedString(k22_0));
    System.out.printf("[22] k22_1: %s\n", Long.toUnsignedString(k22_1));
    System.out.printf("[22] f22_0a: %f\n", f22_0a);
    System.out.printf("[22] f22_1a: %f\n", f22_1a);
    System.out.printf("[22] f22_0b: %f\n", f22_0b);
    System.out.printf("[22] f22_1b: %f\n", f22_1b);

    Assert.assertEquals(k22_0, k0);
    Assert.assertEquals(k22_1, k1);
    Assert.assertEquals(f22_0a, 0.0, 0.0);
    Assert.assertEquals(f22_1a, 1.0, 0.0);
    Assert.assertEquals(f22_0b, 0.0, 0.0);
    Assert.assertEquals(f22_1b, 1.0, 0.0);
    Assert.assertEquals(f22_0a, f22_0b, 0.0);
    Assert.assertEquals(f22_1a, f22_1b, 0.0);
  }

  @Test public void testBounds23()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 23);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 23);
    final long k23_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized23(0.0);
    final long k23_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized23(1.0);

    final double f23_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized23(k23_0);
    final double f23_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized23(k23_1);
    final double f23_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k23_0, 23);
    final double f23_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k23_1, 23);

    System.out.printf("[23] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[23] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[23] k23_0: %s\n", Long.toUnsignedString(k23_0));
    System.out.printf("[23] k23_1: %s\n", Long.toUnsignedString(k23_1));
    System.out.printf("[23] f23_0a: %f\n", f23_0a);
    System.out.printf("[23] f23_1a: %f\n", f23_1a);
    System.out.printf("[23] f23_0b: %f\n", f23_0b);
    System.out.printf("[23] f23_1b: %f\n", f23_1b);

    Assert.assertEquals(k23_0, k0);
    Assert.assertEquals(k23_1, k1);
    Assert.assertEquals(f23_0a, 0.0, 0.0);
    Assert.assertEquals(f23_1a, 1.0, 0.0);
    Assert.assertEquals(f23_0b, 0.0, 0.0);
    Assert.assertEquals(f23_1b, 1.0, 0.0);
    Assert.assertEquals(f23_0a, f23_0b, 0.0);
    Assert.assertEquals(f23_1a, f23_1b, 0.0);
  }

  @Test public void testBounds24()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 24);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 24);
    final long k24_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized24(0.0);
    final long k24_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized24(1.0);

    final double f24_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized24(k24_0);
    final double f24_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized24(k24_1);
    final double f24_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k24_0, 24);
    final double f24_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k24_1, 24);

    System.out.printf("[24] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[24] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[24] k24_0: %s\n", Long.toUnsignedString(k24_0));
    System.out.printf("[24] k24_1: %s\n", Long.toUnsignedString(k24_1));
    System.out.printf("[24] f24_0a: %f\n", f24_0a);
    System.out.printf("[24] f24_1a: %f\n", f24_1a);
    System.out.printf("[24] f24_0b: %f\n", f24_0b);
    System.out.printf("[24] f24_1b: %f\n", f24_1b);

    Assert.assertEquals(k24_0, k0);
    Assert.assertEquals(k24_1, k1);
    Assert.assertEquals(f24_0a, 0.0, 0.0);
    Assert.assertEquals(f24_1a, 1.0, 0.0);
    Assert.assertEquals(f24_0b, 0.0, 0.0);
    Assert.assertEquals(f24_1b, 1.0, 0.0);
    Assert.assertEquals(f24_0a, f24_0b, 0.0);
    Assert.assertEquals(f24_1a, f24_1b, 0.0);
  }

  @Test public void testBounds25()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 25);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 25);
    final long k25_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized25(0.0);
    final long k25_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized25(1.0);

    final double f25_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized25(k25_0);
    final double f25_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized25(k25_1);
    final double f25_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k25_0, 25);
    final double f25_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k25_1, 25);

    System.out.printf("[25] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[25] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[25] k25_0: %s\n", Long.toUnsignedString(k25_0));
    System.out.printf("[25] k25_1: %s\n", Long.toUnsignedString(k25_1));
    System.out.printf("[25] f25_0a: %f\n", f25_0a);
    System.out.printf("[25] f25_1a: %f\n", f25_1a);
    System.out.printf("[25] f25_0b: %f\n", f25_0b);
    System.out.printf("[25] f25_1b: %f\n", f25_1b);

    Assert.assertEquals(k25_0, k0);
    Assert.assertEquals(k25_1, k1);
    Assert.assertEquals(f25_0a, 0.0, 0.0);
    Assert.assertEquals(f25_1a, 1.0, 0.0);
    Assert.assertEquals(f25_0b, 0.0, 0.0);
    Assert.assertEquals(f25_1b, 1.0, 0.0);
    Assert.assertEquals(f25_0a, f25_0b, 0.0);
    Assert.assertEquals(f25_1a, f25_1b, 0.0);
  }

  @Test public void testBounds26()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 26);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 26);
    final long k26_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized26(0.0);
    final long k26_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized26(1.0);

    final double f26_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized26(k26_0);
    final double f26_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized26(k26_1);
    final double f26_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k26_0, 26);
    final double f26_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k26_1, 26);

    System.out.printf("[26] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[26] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[26] k26_0: %s\n", Long.toUnsignedString(k26_0));
    System.out.printf("[26] k26_1: %s\n", Long.toUnsignedString(k26_1));
    System.out.printf("[26] f26_0a: %f\n", f26_0a);
    System.out.printf("[26] f26_1a: %f\n", f26_1a);
    System.out.printf("[26] f26_0b: %f\n", f26_0b);
    System.out.printf("[26] f26_1b: %f\n", f26_1b);

    Assert.assertEquals(k26_0, k0);
    Assert.assertEquals(k26_1, k1);
    Assert.assertEquals(f26_0a, 0.0, 0.0);
    Assert.assertEquals(f26_1a, 1.0, 0.0);
    Assert.assertEquals(f26_0b, 0.0, 0.0);
    Assert.assertEquals(f26_1b, 1.0, 0.0);
    Assert.assertEquals(f26_0a, f26_0b, 0.0);
    Assert.assertEquals(f26_1a, f26_1b, 0.0);
  }

  @Test public void testBounds27()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 27);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 27);
    final long k27_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized27(0.0);
    final long k27_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized27(1.0);

    final double f27_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized27(k27_0);
    final double f27_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized27(k27_1);
    final double f27_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k27_0, 27);
    final double f27_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k27_1, 27);

    System.out.printf("[27] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[27] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[27] k27_0: %s\n", Long.toUnsignedString(k27_0));
    System.out.printf("[27] k27_1: %s\n", Long.toUnsignedString(k27_1));
    System.out.printf("[27] f27_0a: %f\n", f27_0a);
    System.out.printf("[27] f27_1a: %f\n", f27_1a);
    System.out.printf("[27] f27_0b: %f\n", f27_0b);
    System.out.printf("[27] f27_1b: %f\n", f27_1b);

    Assert.assertEquals(k27_0, k0);
    Assert.assertEquals(k27_1, k1);
    Assert.assertEquals(f27_0a, 0.0, 0.0);
    Assert.assertEquals(f27_1a, 1.0, 0.0);
    Assert.assertEquals(f27_0b, 0.0, 0.0);
    Assert.assertEquals(f27_1b, 1.0, 0.0);
    Assert.assertEquals(f27_0a, f27_0b, 0.0);
    Assert.assertEquals(f27_1a, f27_1b, 0.0);
  }

  @Test public void testBounds28()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 28);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 28);
    final long k28_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized28(0.0);
    final long k28_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized28(1.0);

    final double f28_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized28(k28_0);
    final double f28_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized28(k28_1);
    final double f28_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k28_0, 28);
    final double f28_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k28_1, 28);

    System.out.printf("[28] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[28] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[28] k28_0: %s\n", Long.toUnsignedString(k28_0));
    System.out.printf("[28] k28_1: %s\n", Long.toUnsignedString(k28_1));
    System.out.printf("[28] f28_0a: %f\n", f28_0a);
    System.out.printf("[28] f28_1a: %f\n", f28_1a);
    System.out.printf("[28] f28_0b: %f\n", f28_0b);
    System.out.printf("[28] f28_1b: %f\n", f28_1b);

    Assert.assertEquals(k28_0, k0);
    Assert.assertEquals(k28_1, k1);
    Assert.assertEquals(f28_0a, 0.0, 0.0);
    Assert.assertEquals(f28_1a, 1.0, 0.0);
    Assert.assertEquals(f28_0b, 0.0, 0.0);
    Assert.assertEquals(f28_1b, 1.0, 0.0);
    Assert.assertEquals(f28_0a, f28_0b, 0.0);
    Assert.assertEquals(f28_1a, f28_1b, 0.0);
  }

  @Test public void testBounds29()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 29);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 29);
    final long k29_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized29(0.0);
    final long k29_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized29(1.0);

    final double f29_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized29(k29_0);
    final double f29_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized29(k29_1);
    final double f29_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k29_0, 29);
    final double f29_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k29_1, 29);

    System.out.printf("[29] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[29] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[29] k29_0: %s\n", Long.toUnsignedString(k29_0));
    System.out.printf("[29] k29_1: %s\n", Long.toUnsignedString(k29_1));
    System.out.printf("[29] f29_0a: %f\n", f29_0a);
    System.out.printf("[29] f29_1a: %f\n", f29_1a);
    System.out.printf("[29] f29_0b: %f\n", f29_0b);
    System.out.printf("[29] f29_1b: %f\n", f29_1b);

    Assert.assertEquals(k29_0, k0);
    Assert.assertEquals(k29_1, k1);
    Assert.assertEquals(f29_0a, 0.0, 0.0);
    Assert.assertEquals(f29_1a, 1.0, 0.0);
    Assert.assertEquals(f29_0b, 0.0, 0.0);
    Assert.assertEquals(f29_1b, 1.0, 0.0);
    Assert.assertEquals(f29_0a, f29_0b, 0.0);
    Assert.assertEquals(f29_1a, f29_1b, 0.0);
  }

  @Test public void testBounds30()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 30);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 30);
    final long k30_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized30(0.0);
    final long k30_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized30(1.0);

    final double f30_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized30(k30_0);
    final double f30_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized30(k30_1);
    final double f30_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k30_0, 30);
    final double f30_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k30_1, 30);

    System.out.printf("[30] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[30] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[30] k30_0: %s\n", Long.toUnsignedString(k30_0));
    System.out.printf("[30] k30_1: %s\n", Long.toUnsignedString(k30_1));
    System.out.printf("[30] f30_0a: %f\n", f30_0a);
    System.out.printf("[30] f30_1a: %f\n", f30_1a);
    System.out.printf("[30] f30_0b: %f\n", f30_0b);
    System.out.printf("[30] f30_1b: %f\n", f30_1b);

    Assert.assertEquals(k30_0, k0);
    Assert.assertEquals(k30_1, k1);
    Assert.assertEquals(f30_0a, 0.0, 0.0);
    Assert.assertEquals(f30_1a, 1.0, 0.0);
    Assert.assertEquals(f30_0b, 0.0, 0.0);
    Assert.assertEquals(f30_1b, 1.0, 0.0);
    Assert.assertEquals(f30_0a, f30_0b, 0.0);
    Assert.assertEquals(f30_1a, f30_1b, 0.0);
  }

  @Test public void testBounds31()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 31);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 31);
    final long k31_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized31(0.0);
    final long k31_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized31(1.0);

    final double f31_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized31(k31_0);
    final double f31_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized31(k31_1);
    final double f31_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k31_0, 31);
    final double f31_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k31_1, 31);

    System.out.printf("[31] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[31] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[31] k31_0: %s\n", Long.toUnsignedString(k31_0));
    System.out.printf("[31] k31_1: %s\n", Long.toUnsignedString(k31_1));
    System.out.printf("[31] f31_0a: %f\n", f31_0a);
    System.out.printf("[31] f31_1a: %f\n", f31_1a);
    System.out.printf("[31] f31_0b: %f\n", f31_0b);
    System.out.printf("[31] f31_1b: %f\n", f31_1b);

    Assert.assertEquals(k31_0, k0);
    Assert.assertEquals(k31_1, k1);
    Assert.assertEquals(f31_0a, 0.0, 0.0);
    Assert.assertEquals(f31_1a, 1.0, 0.0);
    Assert.assertEquals(f31_0b, 0.0, 0.0);
    Assert.assertEquals(f31_1b, 1.0, 0.0);
    Assert.assertEquals(f31_0a, f31_0b, 0.0);
    Assert.assertEquals(f31_1a, f31_1b, 0.0);
  }

  @Test public void testBounds32()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 32);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 32);
    final long k32_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized32(0.0);
    final long k32_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized32(1.0);

    final double f32_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized32(k32_0);
    final double f32_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized32(k32_1);
    final double f32_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k32_0, 32);
    final double f32_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k32_1, 32);

    System.out.printf("[32] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[32] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[32] k32_0: %s\n", Long.toUnsignedString(k32_0));
    System.out.printf("[32] k32_1: %s\n", Long.toUnsignedString(k32_1));
    System.out.printf("[32] f32_0a: %f\n", f32_0a);
    System.out.printf("[32] f32_1a: %f\n", f32_1a);
    System.out.printf("[32] f32_0b: %f\n", f32_0b);
    System.out.printf("[32] f32_1b: %f\n", f32_1b);

    Assert.assertEquals(k32_0, k0);
    Assert.assertEquals(k32_1, k1);
    Assert.assertEquals(f32_0a, 0.0, 0.0);
    Assert.assertEquals(f32_1a, 1.0, 0.0);
    Assert.assertEquals(f32_0b, 0.0, 0.0);
    Assert.assertEquals(f32_1b, 1.0, 0.0);
    Assert.assertEquals(f32_0a, f32_0b, 0.0);
    Assert.assertEquals(f32_1a, f32_1b, 0.0);
  }

  @Test public void testBounds33()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 33);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 33);
    final long k33_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized33(0.0);
    final long k33_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized33(1.0);

    final double f33_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized33(k33_0);
    final double f33_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized33(k33_1);
    final double f33_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k33_0, 33);
    final double f33_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k33_1, 33);

    System.out.printf("[33] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[33] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[33] k33_0: %s\n", Long.toUnsignedString(k33_0));
    System.out.printf("[33] k33_1: %s\n", Long.toUnsignedString(k33_1));
    System.out.printf("[33] f33_0a: %f\n", f33_0a);
    System.out.printf("[33] f33_1a: %f\n", f33_1a);
    System.out.printf("[33] f33_0b: %f\n", f33_0b);
    System.out.printf("[33] f33_1b: %f\n", f33_1b);

    Assert.assertEquals(k33_0, k0);
    Assert.assertEquals(k33_1, k1);
    Assert.assertEquals(f33_0a, 0.0, 0.0);
    Assert.assertEquals(f33_1a, 1.0, 0.0);
    Assert.assertEquals(f33_0b, 0.0, 0.0);
    Assert.assertEquals(f33_1b, 1.0, 0.0);
    Assert.assertEquals(f33_0a, f33_0b, 0.0);
    Assert.assertEquals(f33_1a, f33_1b, 0.0);
  }

  @Test public void testBounds34()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 34);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 34);
    final long k34_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized34(0.0);
    final long k34_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized34(1.0);

    final double f34_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized34(k34_0);
    final double f34_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized34(k34_1);
    final double f34_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k34_0, 34);
    final double f34_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k34_1, 34);

    System.out.printf("[34] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[34] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[34] k34_0: %s\n", Long.toUnsignedString(k34_0));
    System.out.printf("[34] k34_1: %s\n", Long.toUnsignedString(k34_1));
    System.out.printf("[34] f34_0a: %f\n", f34_0a);
    System.out.printf("[34] f34_1a: %f\n", f34_1a);
    System.out.printf("[34] f34_0b: %f\n", f34_0b);
    System.out.printf("[34] f34_1b: %f\n", f34_1b);

    Assert.assertEquals(k34_0, k0);
    Assert.assertEquals(k34_1, k1);
    Assert.assertEquals(f34_0a, 0.0, 0.0);
    Assert.assertEquals(f34_1a, 1.0, 0.0);
    Assert.assertEquals(f34_0b, 0.0, 0.0);
    Assert.assertEquals(f34_1b, 1.0, 0.0);
    Assert.assertEquals(f34_0a, f34_0b, 0.0);
    Assert.assertEquals(f34_1a, f34_1b, 0.0);
  }

  @Test public void testBounds35()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 35);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 35);
    final long k35_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized35(0.0);
    final long k35_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized35(1.0);

    final double f35_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized35(k35_0);
    final double f35_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized35(k35_1);
    final double f35_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k35_0, 35);
    final double f35_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k35_1, 35);

    System.out.printf("[35] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[35] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[35] k35_0: %s\n", Long.toUnsignedString(k35_0));
    System.out.printf("[35] k35_1: %s\n", Long.toUnsignedString(k35_1));
    System.out.printf("[35] f35_0a: %f\n", f35_0a);
    System.out.printf("[35] f35_1a: %f\n", f35_1a);
    System.out.printf("[35] f35_0b: %f\n", f35_0b);
    System.out.printf("[35] f35_1b: %f\n", f35_1b);

    Assert.assertEquals(k35_0, k0);
    Assert.assertEquals(k35_1, k1);
    Assert.assertEquals(f35_0a, 0.0, 0.0);
    Assert.assertEquals(f35_1a, 1.0, 0.0);
    Assert.assertEquals(f35_0b, 0.0, 0.0);
    Assert.assertEquals(f35_1b, 1.0, 0.0);
    Assert.assertEquals(f35_0a, f35_0b, 0.0);
    Assert.assertEquals(f35_1a, f35_1b, 0.0);
  }

  @Test public void testBounds36()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 36);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 36);
    final long k36_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized36(0.0);
    final long k36_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized36(1.0);

    final double f36_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized36(k36_0);
    final double f36_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized36(k36_1);
    final double f36_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k36_0, 36);
    final double f36_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k36_1, 36);

    System.out.printf("[36] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[36] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[36] k36_0: %s\n", Long.toUnsignedString(k36_0));
    System.out.printf("[36] k36_1: %s\n", Long.toUnsignedString(k36_1));
    System.out.printf("[36] f36_0a: %f\n", f36_0a);
    System.out.printf("[36] f36_1a: %f\n", f36_1a);
    System.out.printf("[36] f36_0b: %f\n", f36_0b);
    System.out.printf("[36] f36_1b: %f\n", f36_1b);

    Assert.assertEquals(k36_0, k0);
    Assert.assertEquals(k36_1, k1);
    Assert.assertEquals(f36_0a, 0.0, 0.0);
    Assert.assertEquals(f36_1a, 1.0, 0.0);
    Assert.assertEquals(f36_0b, 0.0, 0.0);
    Assert.assertEquals(f36_1b, 1.0, 0.0);
    Assert.assertEquals(f36_0a, f36_0b, 0.0);
    Assert.assertEquals(f36_1a, f36_1b, 0.0);
  }

  @Test public void testBounds37()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 37);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 37);
    final long k37_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized37(0.0);
    final long k37_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized37(1.0);

    final double f37_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized37(k37_0);
    final double f37_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized37(k37_1);
    final double f37_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k37_0, 37);
    final double f37_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k37_1, 37);

    System.out.printf("[37] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[37] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[37] k37_0: %s\n", Long.toUnsignedString(k37_0));
    System.out.printf("[37] k37_1: %s\n", Long.toUnsignedString(k37_1));
    System.out.printf("[37] f37_0a: %f\n", f37_0a);
    System.out.printf("[37] f37_1a: %f\n", f37_1a);
    System.out.printf("[37] f37_0b: %f\n", f37_0b);
    System.out.printf("[37] f37_1b: %f\n", f37_1b);

    Assert.assertEquals(k37_0, k0);
    Assert.assertEquals(k37_1, k1);
    Assert.assertEquals(f37_0a, 0.0, 0.0);
    Assert.assertEquals(f37_1a, 1.0, 0.0);
    Assert.assertEquals(f37_0b, 0.0, 0.0);
    Assert.assertEquals(f37_1b, 1.0, 0.0);
    Assert.assertEquals(f37_0a, f37_0b, 0.0);
    Assert.assertEquals(f37_1a, f37_1b, 0.0);
  }

  @Test public void testBounds38()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 38);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 38);
    final long k38_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized38(0.0);
    final long k38_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized38(1.0);

    final double f38_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized38(k38_0);
    final double f38_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized38(k38_1);
    final double f38_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k38_0, 38);
    final double f38_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k38_1, 38);

    System.out.printf("[38] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[38] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[38] k38_0: %s\n", Long.toUnsignedString(k38_0));
    System.out.printf("[38] k38_1: %s\n", Long.toUnsignedString(k38_1));
    System.out.printf("[38] f38_0a: %f\n", f38_0a);
    System.out.printf("[38] f38_1a: %f\n", f38_1a);
    System.out.printf("[38] f38_0b: %f\n", f38_0b);
    System.out.printf("[38] f38_1b: %f\n", f38_1b);

    Assert.assertEquals(k38_0, k0);
    Assert.assertEquals(k38_1, k1);
    Assert.assertEquals(f38_0a, 0.0, 0.0);
    Assert.assertEquals(f38_1a, 1.0, 0.0);
    Assert.assertEquals(f38_0b, 0.0, 0.0);
    Assert.assertEquals(f38_1b, 1.0, 0.0);
    Assert.assertEquals(f38_0a, f38_0b, 0.0);
    Assert.assertEquals(f38_1a, f38_1b, 0.0);
  }

  @Test public void testBounds39()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 39);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 39);
    final long k39_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized39(0.0);
    final long k39_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized39(1.0);

    final double f39_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized39(k39_0);
    final double f39_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized39(k39_1);
    final double f39_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k39_0, 39);
    final double f39_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k39_1, 39);

    System.out.printf("[39] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[39] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[39] k39_0: %s\n", Long.toUnsignedString(k39_0));
    System.out.printf("[39] k39_1: %s\n", Long.toUnsignedString(k39_1));
    System.out.printf("[39] f39_0a: %f\n", f39_0a);
    System.out.printf("[39] f39_1a: %f\n", f39_1a);
    System.out.printf("[39] f39_0b: %f\n", f39_0b);
    System.out.printf("[39] f39_1b: %f\n", f39_1b);

    Assert.assertEquals(k39_0, k0);
    Assert.assertEquals(k39_1, k1);
    Assert.assertEquals(f39_0a, 0.0, 0.0);
    Assert.assertEquals(f39_1a, 1.0, 0.0);
    Assert.assertEquals(f39_0b, 0.0, 0.0);
    Assert.assertEquals(f39_1b, 1.0, 0.0);
    Assert.assertEquals(f39_0a, f39_0b, 0.0);
    Assert.assertEquals(f39_1a, f39_1b, 0.0);
  }

  @Test public void testBounds40()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 40);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 40);
    final long k40_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized40(0.0);
    final long k40_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized40(1.0);

    final double f40_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized40(k40_0);
    final double f40_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized40(k40_1);
    final double f40_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k40_0, 40);
    final double f40_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k40_1, 40);

    System.out.printf("[40] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[40] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[40] k40_0: %s\n", Long.toUnsignedString(k40_0));
    System.out.printf("[40] k40_1: %s\n", Long.toUnsignedString(k40_1));
    System.out.printf("[40] f40_0a: %f\n", f40_0a);
    System.out.printf("[40] f40_1a: %f\n", f40_1a);
    System.out.printf("[40] f40_0b: %f\n", f40_0b);
    System.out.printf("[40] f40_1b: %f\n", f40_1b);

    Assert.assertEquals(k40_0, k0);
    Assert.assertEquals(k40_1, k1);
    Assert.assertEquals(f40_0a, 0.0, 0.0);
    Assert.assertEquals(f40_1a, 1.0, 0.0);
    Assert.assertEquals(f40_0b, 0.0, 0.0);
    Assert.assertEquals(f40_1b, 1.0, 0.0);
    Assert.assertEquals(f40_0a, f40_0b, 0.0);
    Assert.assertEquals(f40_1a, f40_1b, 0.0);
  }

  @Test public void testBounds41()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 41);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 41);
    final long k41_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized41(0.0);
    final long k41_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized41(1.0);

    final double f41_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized41(k41_0);
    final double f41_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized41(k41_1);
    final double f41_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k41_0, 41);
    final double f41_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k41_1, 41);

    System.out.printf("[41] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[41] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[41] k41_0: %s\n", Long.toUnsignedString(k41_0));
    System.out.printf("[41] k41_1: %s\n", Long.toUnsignedString(k41_1));
    System.out.printf("[41] f41_0a: %f\n", f41_0a);
    System.out.printf("[41] f41_1a: %f\n", f41_1a);
    System.out.printf("[41] f41_0b: %f\n", f41_0b);
    System.out.printf("[41] f41_1b: %f\n", f41_1b);

    Assert.assertEquals(k41_0, k0);
    Assert.assertEquals(k41_1, k1);
    Assert.assertEquals(f41_0a, 0.0, 0.0);
    Assert.assertEquals(f41_1a, 1.0, 0.0);
    Assert.assertEquals(f41_0b, 0.0, 0.0);
    Assert.assertEquals(f41_1b, 1.0, 0.0);
    Assert.assertEquals(f41_0a, f41_0b, 0.0);
    Assert.assertEquals(f41_1a, f41_1b, 0.0);
  }

  @Test public void testBounds42()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 42);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 42);
    final long k42_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized42(0.0);
    final long k42_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized42(1.0);

    final double f42_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized42(k42_0);
    final double f42_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized42(k42_1);
    final double f42_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k42_0, 42);
    final double f42_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k42_1, 42);

    System.out.printf("[42] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[42] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[42] k42_0: %s\n", Long.toUnsignedString(k42_0));
    System.out.printf("[42] k42_1: %s\n", Long.toUnsignedString(k42_1));
    System.out.printf("[42] f42_0a: %f\n", f42_0a);
    System.out.printf("[42] f42_1a: %f\n", f42_1a);
    System.out.printf("[42] f42_0b: %f\n", f42_0b);
    System.out.printf("[42] f42_1b: %f\n", f42_1b);

    Assert.assertEquals(k42_0, k0);
    Assert.assertEquals(k42_1, k1);
    Assert.assertEquals(f42_0a, 0.0, 0.0);
    Assert.assertEquals(f42_1a, 1.0, 0.0);
    Assert.assertEquals(f42_0b, 0.0, 0.0);
    Assert.assertEquals(f42_1b, 1.0, 0.0);
    Assert.assertEquals(f42_0a, f42_0b, 0.0);
    Assert.assertEquals(f42_1a, f42_1b, 0.0);
  }

  @Test public void testBounds43()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 43);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 43);
    final long k43_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized43(0.0);
    final long k43_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized43(1.0);

    final double f43_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized43(k43_0);
    final double f43_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized43(k43_1);
    final double f43_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k43_0, 43);
    final double f43_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k43_1, 43);

    System.out.printf("[43] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[43] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[43] k43_0: %s\n", Long.toUnsignedString(k43_0));
    System.out.printf("[43] k43_1: %s\n", Long.toUnsignedString(k43_1));
    System.out.printf("[43] f43_0a: %f\n", f43_0a);
    System.out.printf("[43] f43_1a: %f\n", f43_1a);
    System.out.printf("[43] f43_0b: %f\n", f43_0b);
    System.out.printf("[43] f43_1b: %f\n", f43_1b);

    Assert.assertEquals(k43_0, k0);
    Assert.assertEquals(k43_1, k1);
    Assert.assertEquals(f43_0a, 0.0, 0.0);
    Assert.assertEquals(f43_1a, 1.0, 0.0);
    Assert.assertEquals(f43_0b, 0.0, 0.0);
    Assert.assertEquals(f43_1b, 1.0, 0.0);
    Assert.assertEquals(f43_0a, f43_0b, 0.0);
    Assert.assertEquals(f43_1a, f43_1b, 0.0);
  }

  @Test public void testBounds44()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 44);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 44);
    final long k44_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized44(0.0);
    final long k44_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized44(1.0);

    final double f44_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized44(k44_0);
    final double f44_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized44(k44_1);
    final double f44_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k44_0, 44);
    final double f44_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k44_1, 44);

    System.out.printf("[44] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[44] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[44] k44_0: %s\n", Long.toUnsignedString(k44_0));
    System.out.printf("[44] k44_1: %s\n", Long.toUnsignedString(k44_1));
    System.out.printf("[44] f44_0a: %f\n", f44_0a);
    System.out.printf("[44] f44_1a: %f\n", f44_1a);
    System.out.printf("[44] f44_0b: %f\n", f44_0b);
    System.out.printf("[44] f44_1b: %f\n", f44_1b);

    Assert.assertEquals(k44_0, k0);
    Assert.assertEquals(k44_1, k1);
    Assert.assertEquals(f44_0a, 0.0, 0.0);
    Assert.assertEquals(f44_1a, 1.0, 0.0);
    Assert.assertEquals(f44_0b, 0.0, 0.0);
    Assert.assertEquals(f44_1b, 1.0, 0.0);
    Assert.assertEquals(f44_0a, f44_0b, 0.0);
    Assert.assertEquals(f44_1a, f44_1b, 0.0);
  }

  @Test public void testBounds45()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 45);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 45);
    final long k45_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized45(0.0);
    final long k45_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized45(1.0);

    final double f45_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized45(k45_0);
    final double f45_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized45(k45_1);
    final double f45_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k45_0, 45);
    final double f45_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k45_1, 45);

    System.out.printf("[45] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[45] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[45] k45_0: %s\n", Long.toUnsignedString(k45_0));
    System.out.printf("[45] k45_1: %s\n", Long.toUnsignedString(k45_1));
    System.out.printf("[45] f45_0a: %f\n", f45_0a);
    System.out.printf("[45] f45_1a: %f\n", f45_1a);
    System.out.printf("[45] f45_0b: %f\n", f45_0b);
    System.out.printf("[45] f45_1b: %f\n", f45_1b);

    Assert.assertEquals(k45_0, k0);
    Assert.assertEquals(k45_1, k1);
    Assert.assertEquals(f45_0a, 0.0, 0.0);
    Assert.assertEquals(f45_1a, 1.0, 0.0);
    Assert.assertEquals(f45_0b, 0.0, 0.0);
    Assert.assertEquals(f45_1b, 1.0, 0.0);
    Assert.assertEquals(f45_0a, f45_0b, 0.0);
    Assert.assertEquals(f45_1a, f45_1b, 0.0);
  }

  @Test public void testBounds46()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 46);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 46);
    final long k46_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized46(0.0);
    final long k46_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized46(1.0);

    final double f46_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized46(k46_0);
    final double f46_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized46(k46_1);
    final double f46_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k46_0, 46);
    final double f46_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k46_1, 46);

    System.out.printf("[46] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[46] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[46] k46_0: %s\n", Long.toUnsignedString(k46_0));
    System.out.printf("[46] k46_1: %s\n", Long.toUnsignedString(k46_1));
    System.out.printf("[46] f46_0a: %f\n", f46_0a);
    System.out.printf("[46] f46_1a: %f\n", f46_1a);
    System.out.printf("[46] f46_0b: %f\n", f46_0b);
    System.out.printf("[46] f46_1b: %f\n", f46_1b);

    Assert.assertEquals(k46_0, k0);
    Assert.assertEquals(k46_1, k1);
    Assert.assertEquals(f46_0a, 0.0, 0.0);
    Assert.assertEquals(f46_1a, 1.0, 0.0);
    Assert.assertEquals(f46_0b, 0.0, 0.0);
    Assert.assertEquals(f46_1b, 1.0, 0.0);
    Assert.assertEquals(f46_0a, f46_0b, 0.0);
    Assert.assertEquals(f46_1a, f46_1b, 0.0);
  }

  @Test public void testBounds47()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 47);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 47);
    final long k47_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized47(0.0);
    final long k47_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized47(1.0);

    final double f47_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized47(k47_0);
    final double f47_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized47(k47_1);
    final double f47_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k47_0, 47);
    final double f47_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k47_1, 47);

    System.out.printf("[47] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[47] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[47] k47_0: %s\n", Long.toUnsignedString(k47_0));
    System.out.printf("[47] k47_1: %s\n", Long.toUnsignedString(k47_1));
    System.out.printf("[47] f47_0a: %f\n", f47_0a);
    System.out.printf("[47] f47_1a: %f\n", f47_1a);
    System.out.printf("[47] f47_0b: %f\n", f47_0b);
    System.out.printf("[47] f47_1b: %f\n", f47_1b);

    Assert.assertEquals(k47_0, k0);
    Assert.assertEquals(k47_1, k1);
    Assert.assertEquals(f47_0a, 0.0, 0.0);
    Assert.assertEquals(f47_1a, 1.0, 0.0);
    Assert.assertEquals(f47_0b, 0.0, 0.0);
    Assert.assertEquals(f47_1b, 1.0, 0.0);
    Assert.assertEquals(f47_0a, f47_0b, 0.0);
    Assert.assertEquals(f47_1a, f47_1b, 0.0);
  }

  @Test public void testBounds48()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 48);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 48);
    final long k48_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized48(0.0);
    final long k48_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized48(1.0);

    final double f48_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized48(k48_0);
    final double f48_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized48(k48_1);
    final double f48_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k48_0, 48);
    final double f48_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k48_1, 48);

    System.out.printf("[48] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[48] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[48] k48_0: %s\n", Long.toUnsignedString(k48_0));
    System.out.printf("[48] k48_1: %s\n", Long.toUnsignedString(k48_1));
    System.out.printf("[48] f48_0a: %f\n", f48_0a);
    System.out.printf("[48] f48_1a: %f\n", f48_1a);
    System.out.printf("[48] f48_0b: %f\n", f48_0b);
    System.out.printf("[48] f48_1b: %f\n", f48_1b);

    Assert.assertEquals(k48_0, k0);
    Assert.assertEquals(k48_1, k1);
    Assert.assertEquals(f48_0a, 0.0, 0.0);
    Assert.assertEquals(f48_1a, 1.0, 0.0);
    Assert.assertEquals(f48_0b, 0.0, 0.0);
    Assert.assertEquals(f48_1b, 1.0, 0.0);
    Assert.assertEquals(f48_0a, f48_0b, 0.0);
    Assert.assertEquals(f48_1a, f48_1b, 0.0);
  }

  @Test public void testBounds49()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 49);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 49);
    final long k49_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized49(0.0);
    final long k49_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized49(1.0);

    final double f49_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized49(k49_0);
    final double f49_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized49(k49_1);
    final double f49_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k49_0, 49);
    final double f49_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k49_1, 49);

    System.out.printf("[49] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[49] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[49] k49_0: %s\n", Long.toUnsignedString(k49_0));
    System.out.printf("[49] k49_1: %s\n", Long.toUnsignedString(k49_1));
    System.out.printf("[49] f49_0a: %f\n", f49_0a);
    System.out.printf("[49] f49_1a: %f\n", f49_1a);
    System.out.printf("[49] f49_0b: %f\n", f49_0b);
    System.out.printf("[49] f49_1b: %f\n", f49_1b);

    Assert.assertEquals(k49_0, k0);
    Assert.assertEquals(k49_1, k1);
    Assert.assertEquals(f49_0a, 0.0, 0.0);
    Assert.assertEquals(f49_1a, 1.0, 0.0);
    Assert.assertEquals(f49_0b, 0.0, 0.0);
    Assert.assertEquals(f49_1b, 1.0, 0.0);
    Assert.assertEquals(f49_0a, f49_0b, 0.0);
    Assert.assertEquals(f49_1a, f49_1b, 0.0);
  }

  @Test public void testBounds50()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 50);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 50);
    final long k50_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized50(0.0);
    final long k50_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized50(1.0);

    final double f50_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized50(k50_0);
    final double f50_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized50(k50_1);
    final double f50_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k50_0, 50);
    final double f50_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k50_1, 50);

    System.out.printf("[50] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[50] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[50] k50_0: %s\n", Long.toUnsignedString(k50_0));
    System.out.printf("[50] k50_1: %s\n", Long.toUnsignedString(k50_1));
    System.out.printf("[50] f50_0a: %f\n", f50_0a);
    System.out.printf("[50] f50_1a: %f\n", f50_1a);
    System.out.printf("[50] f50_0b: %f\n", f50_0b);
    System.out.printf("[50] f50_1b: %f\n", f50_1b);

    Assert.assertEquals(k50_0, k0);
    Assert.assertEquals(k50_1, k1);
    Assert.assertEquals(f50_0a, 0.0, 0.0);
    Assert.assertEquals(f50_1a, 1.0, 0.0);
    Assert.assertEquals(f50_0b, 0.0, 0.0);
    Assert.assertEquals(f50_1b, 1.0, 0.0);
    Assert.assertEquals(f50_0a, f50_0b, 0.0);
    Assert.assertEquals(f50_1a, f50_1b, 0.0);
  }

  @Test public void testBounds51()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 51);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 51);
    final long k51_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized51(0.0);
    final long k51_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized51(1.0);

    final double f51_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized51(k51_0);
    final double f51_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized51(k51_1);
    final double f51_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k51_0, 51);
    final double f51_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k51_1, 51);

    System.out.printf("[51] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[51] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[51] k51_0: %s\n", Long.toUnsignedString(k51_0));
    System.out.printf("[51] k51_1: %s\n", Long.toUnsignedString(k51_1));
    System.out.printf("[51] f51_0a: %f\n", f51_0a);
    System.out.printf("[51] f51_1a: %f\n", f51_1a);
    System.out.printf("[51] f51_0b: %f\n", f51_0b);
    System.out.printf("[51] f51_1b: %f\n", f51_1b);

    Assert.assertEquals(k51_0, k0);
    Assert.assertEquals(k51_1, k1);
    Assert.assertEquals(f51_0a, 0.0, 0.0);
    Assert.assertEquals(f51_1a, 1.0, 0.0);
    Assert.assertEquals(f51_0b, 0.0, 0.0);
    Assert.assertEquals(f51_1b, 1.0, 0.0);
    Assert.assertEquals(f51_0a, f51_0b, 0.0);
    Assert.assertEquals(f51_1a, f51_1b, 0.0);
  }

  @Test public void testBounds52()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 52);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 52);
    final long k52_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized52(0.0);
    final long k52_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized52(1.0);

    final double f52_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized52(k52_0);
    final double f52_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized52(k52_1);
    final double f52_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k52_0, 52);
    final double f52_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k52_1, 52);

    System.out.printf("[52] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[52] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[52] k52_0: %s\n", Long.toUnsignedString(k52_0));
    System.out.printf("[52] k52_1: %s\n", Long.toUnsignedString(k52_1));
    System.out.printf("[52] f52_0a: %f\n", f52_0a);
    System.out.printf("[52] f52_1a: %f\n", f52_1a);
    System.out.printf("[52] f52_0b: %f\n", f52_0b);
    System.out.printf("[52] f52_1b: %f\n", f52_1b);

    Assert.assertEquals(k52_0, k0);
    Assert.assertEquals(k52_1, k1);
    Assert.assertEquals(f52_0a, 0.0, 0.0);
    Assert.assertEquals(f52_1a, 1.0, 0.0);
    Assert.assertEquals(f52_0b, 0.0, 0.0);
    Assert.assertEquals(f52_1b, 1.0, 0.0);
    Assert.assertEquals(f52_0a, f52_0b, 0.0);
    Assert.assertEquals(f52_1a, f52_1b, 0.0);
  }

  @Test public void testBounds53()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 53);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 53);
    final long k53_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized53(0.0);
    final long k53_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized53(1.0);

    final double f53_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized53(k53_0);
    final double f53_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized53(k53_1);
    final double f53_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k53_0, 53);
    final double f53_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k53_1, 53);

    System.out.printf("[53] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[53] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[53] k53_0: %s\n", Long.toUnsignedString(k53_0));
    System.out.printf("[53] k53_1: %s\n", Long.toUnsignedString(k53_1));
    System.out.printf("[53] f53_0a: %f\n", f53_0a);
    System.out.printf("[53] f53_1a: %f\n", f53_1a);
    System.out.printf("[53] f53_0b: %f\n", f53_0b);
    System.out.printf("[53] f53_1b: %f\n", f53_1b);

    Assert.assertEquals(k53_0, k0);
    Assert.assertEquals(k53_1, k1);
    Assert.assertEquals(f53_0a, 0.0, 0.0);
    Assert.assertEquals(f53_1a, 1.0, 0.0);
    Assert.assertEquals(f53_0b, 0.0, 0.0);
    Assert.assertEquals(f53_1b, 1.0, 0.0);
    Assert.assertEquals(f53_0a, f53_0b, 0.0);
    Assert.assertEquals(f53_1a, f53_1b, 0.0);
  }

  @Test public void testBounds54()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 54);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 54);
    final long k54_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized54(0.0);
    final long k54_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized54(1.0);

    final double f54_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized54(k54_0);
    final double f54_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized54(k54_1);
    final double f54_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k54_0, 54);
    final double f54_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k54_1, 54);

    System.out.printf("[54] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[54] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[54] k54_0: %s\n", Long.toUnsignedString(k54_0));
    System.out.printf("[54] k54_1: %s\n", Long.toUnsignedString(k54_1));
    System.out.printf("[54] f54_0a: %f\n", f54_0a);
    System.out.printf("[54] f54_1a: %f\n", f54_1a);
    System.out.printf("[54] f54_0b: %f\n", f54_0b);
    System.out.printf("[54] f54_1b: %f\n", f54_1b);

    Assert.assertEquals(k54_0, k0);
    Assert.assertEquals(k54_1, k1);
    Assert.assertEquals(f54_0a, 0.0, 0.0);
    Assert.assertEquals(f54_1a, 1.0, 0.0);
    Assert.assertEquals(f54_0b, 0.0, 0.0);
    Assert.assertEquals(f54_1b, 1.0, 0.0);
    Assert.assertEquals(f54_0a, f54_0b, 0.0);
    Assert.assertEquals(f54_1a, f54_1b, 0.0);
  }

  @Test public void testBounds55()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 55);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 55);
    final long k55_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized55(0.0);
    final long k55_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized55(1.0);

    final double f55_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized55(k55_0);
    final double f55_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized55(k55_1);
    final double f55_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k55_0, 55);
    final double f55_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k55_1, 55);

    System.out.printf("[55] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[55] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[55] k55_0: %s\n", Long.toUnsignedString(k55_0));
    System.out.printf("[55] k55_1: %s\n", Long.toUnsignedString(k55_1));
    System.out.printf("[55] f55_0a: %f\n", f55_0a);
    System.out.printf("[55] f55_1a: %f\n", f55_1a);
    System.out.printf("[55] f55_0b: %f\n", f55_0b);
    System.out.printf("[55] f55_1b: %f\n", f55_1b);

    Assert.assertEquals(k55_0, k0);
    Assert.assertEquals(k55_1, k1);
    Assert.assertEquals(f55_0a, 0.0, 0.0);
    Assert.assertEquals(f55_1a, 1.0, 0.0);
    Assert.assertEquals(f55_0b, 0.0, 0.0);
    Assert.assertEquals(f55_1b, 1.0, 0.0);
    Assert.assertEquals(f55_0a, f55_0b, 0.0);
    Assert.assertEquals(f55_1a, f55_1b, 0.0);
  }

  @Test public void testBounds56()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 56);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 56);
    final long k56_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized56(0.0);
    final long k56_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized56(1.0);

    final double f56_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized56(k56_0);
    final double f56_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized56(k56_1);
    final double f56_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k56_0, 56);
    final double f56_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k56_1, 56);

    System.out.printf("[56] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[56] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[56] k56_0: %s\n", Long.toUnsignedString(k56_0));
    System.out.printf("[56] k56_1: %s\n", Long.toUnsignedString(k56_1));
    System.out.printf("[56] f56_0a: %f\n", f56_0a);
    System.out.printf("[56] f56_1a: %f\n", f56_1a);
    System.out.printf("[56] f56_0b: %f\n", f56_0b);
    System.out.printf("[56] f56_1b: %f\n", f56_1b);

    Assert.assertEquals(k56_0, k0);
    Assert.assertEquals(k56_1, k1);
    Assert.assertEquals(f56_0a, 0.0, 0.0);
    Assert.assertEquals(f56_1a, 1.0, 0.0);
    Assert.assertEquals(f56_0b, 0.0, 0.0);
    Assert.assertEquals(f56_1b, 1.0, 0.0);
    Assert.assertEquals(f56_0a, f56_0b, 0.0);
    Assert.assertEquals(f56_1a, f56_1b, 0.0);
  }

  @Test public void testBounds57()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 57);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 57);
    final long k57_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized57(0.0);
    final long k57_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized57(1.0);

    final double f57_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized57(k57_0);
    final double f57_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized57(k57_1);
    final double f57_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k57_0, 57);
    final double f57_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k57_1, 57);

    System.out.printf("[57] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[57] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[57] k57_0: %s\n", Long.toUnsignedString(k57_0));
    System.out.printf("[57] k57_1: %s\n", Long.toUnsignedString(k57_1));
    System.out.printf("[57] f57_0a: %f\n", f57_0a);
    System.out.printf("[57] f57_1a: %f\n", f57_1a);
    System.out.printf("[57] f57_0b: %f\n", f57_0b);
    System.out.printf("[57] f57_1b: %f\n", f57_1b);

    Assert.assertEquals(k57_0, k0);
    Assert.assertEquals(k57_1, k1);
    Assert.assertEquals(f57_0a, 0.0, 0.0);
    Assert.assertEquals(f57_1a, 1.0, 0.0);
    Assert.assertEquals(f57_0b, 0.0, 0.0);
    Assert.assertEquals(f57_1b, 1.0, 0.0);
    Assert.assertEquals(f57_0a, f57_0b, 0.0);
    Assert.assertEquals(f57_1a, f57_1b, 0.0);
  }

  @Test public void testBounds58()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 58);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 58);
    final long k58_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized58(0.0);
    final long k58_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized58(1.0);

    final double f58_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized58(k58_0);
    final double f58_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized58(k58_1);
    final double f58_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k58_0, 58);
    final double f58_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k58_1, 58);

    System.out.printf("[58] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[58] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[58] k58_0: %s\n", Long.toUnsignedString(k58_0));
    System.out.printf("[58] k58_1: %s\n", Long.toUnsignedString(k58_1));
    System.out.printf("[58] f58_0a: %f\n", f58_0a);
    System.out.printf("[58] f58_1a: %f\n", f58_1a);
    System.out.printf("[58] f58_0b: %f\n", f58_0b);
    System.out.printf("[58] f58_1b: %f\n", f58_1b);

    Assert.assertEquals(k58_0, k0);
    Assert.assertEquals(k58_1, k1);
    Assert.assertEquals(f58_0a, 0.0, 0.0);
    Assert.assertEquals(f58_1a, 1.0, 0.0);
    Assert.assertEquals(f58_0b, 0.0, 0.0);
    Assert.assertEquals(f58_1b, 1.0, 0.0);
    Assert.assertEquals(f58_0a, f58_0b, 0.0);
    Assert.assertEquals(f58_1a, f58_1b, 0.0);
  }

  @Test public void testBounds59()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 59);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 59);
    final long k59_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized59(0.0);
    final long k59_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized59(1.0);

    final double f59_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized59(k59_0);
    final double f59_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized59(k59_1);
    final double f59_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k59_0, 59);
    final double f59_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k59_1, 59);

    System.out.printf("[59] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[59] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[59] k59_0: %s\n", Long.toUnsignedString(k59_0));
    System.out.printf("[59] k59_1: %s\n", Long.toUnsignedString(k59_1));
    System.out.printf("[59] f59_0a: %f\n", f59_0a);
    System.out.printf("[59] f59_1a: %f\n", f59_1a);
    System.out.printf("[59] f59_0b: %f\n", f59_0b);
    System.out.printf("[59] f59_1b: %f\n", f59_1b);

    Assert.assertEquals(k59_0, k0);
    Assert.assertEquals(k59_1, k1);
    Assert.assertEquals(f59_0a, 0.0, 0.0);
    Assert.assertEquals(f59_1a, 1.0, 0.0);
    Assert.assertEquals(f59_0b, 0.0, 0.0);
    Assert.assertEquals(f59_1b, 1.0, 0.0);
    Assert.assertEquals(f59_0a, f59_0b, 0.0);
    Assert.assertEquals(f59_1a, f59_1b, 0.0);
  }

  @Test public void testBounds60()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 60);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 60);
    final long k60_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized60(0.0);
    final long k60_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized60(1.0);

    final double f60_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized60(k60_0);
    final double f60_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized60(k60_1);
    final double f60_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k60_0, 60);
    final double f60_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k60_1, 60);

    System.out.printf("[60] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[60] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[60] k60_0: %s\n", Long.toUnsignedString(k60_0));
    System.out.printf("[60] k60_1: %s\n", Long.toUnsignedString(k60_1));
    System.out.printf("[60] f60_0a: %f\n", f60_0a);
    System.out.printf("[60] f60_1a: %f\n", f60_1a);
    System.out.printf("[60] f60_0b: %f\n", f60_0b);
    System.out.printf("[60] f60_1b: %f\n", f60_1b);

    Assert.assertEquals(k60_0, k0);
    Assert.assertEquals(k60_1, k1);
    Assert.assertEquals(f60_0a, 0.0, 0.0);
    Assert.assertEquals(f60_1a, 1.0, 0.0);
    Assert.assertEquals(f60_0b, 0.0, 0.0);
    Assert.assertEquals(f60_1b, 1.0, 0.0);
    Assert.assertEquals(f60_0a, f60_0b, 0.0);
    Assert.assertEquals(f60_1a, f60_1b, 0.0);
  }

  @Test public void testBounds61()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 61);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 61);
    final long k61_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized61(0.0);
    final long k61_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized61(1.0);

    final double f61_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized61(k61_0);
    final double f61_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized61(k61_1);
    final double f61_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k61_0, 61);
    final double f61_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k61_1, 61);

    System.out.printf("[61] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[61] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[61] k61_0: %s\n", Long.toUnsignedString(k61_0));
    System.out.printf("[61] k61_1: %s\n", Long.toUnsignedString(k61_1));
    System.out.printf("[61] f61_0a: %f\n", f61_0a);
    System.out.printf("[61] f61_1a: %f\n", f61_1a);
    System.out.printf("[61] f61_0b: %f\n", f61_0b);
    System.out.printf("[61] f61_1b: %f\n", f61_1b);

    Assert.assertEquals(k61_0, k0);
    Assert.assertEquals(k61_1, k1);
    Assert.assertEquals(f61_0a, 0.0, 0.0);
    Assert.assertEquals(f61_1a, 1.0, 0.0);
    Assert.assertEquals(f61_0b, 0.0, 0.0);
    Assert.assertEquals(f61_1b, 1.0, 0.0);
    Assert.assertEquals(f61_0a, f61_0b, 0.0);
    Assert.assertEquals(f61_1a, f61_1b, 0.0);
  }

  @Test public void testBounds62()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 62);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 62);
    final long k62_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized62(0.0);
    final long k62_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized62(1.0);

    final double f62_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized62(k62_0);
    final double f62_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized62(k62_1);
    final double f62_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k62_0, 62);
    final double f62_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k62_1, 62);

    System.out.printf("[62] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[62] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[62] k62_0: %s\n", Long.toUnsignedString(k62_0));
    System.out.printf("[62] k62_1: %s\n", Long.toUnsignedString(k62_1));
    System.out.printf("[62] f62_0a: %f\n", f62_0a);
    System.out.printf("[62] f62_1a: %f\n", f62_1a);
    System.out.printf("[62] f62_0b: %f\n", f62_0b);
    System.out.printf("[62] f62_1b: %f\n", f62_1b);

    Assert.assertEquals(k62_0, k0);
    Assert.assertEquals(k62_1, k1);
    Assert.assertEquals(f62_0a, 0.0, 0.0);
    Assert.assertEquals(f62_1a, 1.0, 0.0);
    Assert.assertEquals(f62_0b, 0.0, 0.0);
    Assert.assertEquals(f62_1b, 1.0, 0.0);
    Assert.assertEquals(f62_0a, f62_0b, 0.0);
    Assert.assertEquals(f62_1a, f62_1b, 0.0);
  }

  @Test public void testBounds63()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 63);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 63);
    final long k63_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized63(0.0);
    final long k63_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized63(1.0);

    final double f63_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized63(k63_0);
    final double f63_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized63(k63_1);
    final double f63_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k63_0, 63);
    final double f63_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k63_1, 63);

    System.out.printf("[63] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[63] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[63] k63_0: %s\n", Long.toUnsignedString(k63_0));
    System.out.printf("[63] k63_1: %s\n", Long.toUnsignedString(k63_1));
    System.out.printf("[63] f63_0a: %f\n", f63_0a);
    System.out.printf("[63] f63_1a: %f\n", f63_1a);
    System.out.printf("[63] f63_0b: %f\n", f63_0b);
    System.out.printf("[63] f63_1b: %f\n", f63_1b);

    Assert.assertEquals(k63_0, k0);
    Assert.assertEquals(k63_1, k1);
    Assert.assertEquals(f63_0a, 0.0, 0.0);
    Assert.assertEquals(f63_1a, 1.0, 0.0);
    Assert.assertEquals(f63_0b, 0.0, 0.0);
    Assert.assertEquals(f63_1b, 1.0, 0.0);
    Assert.assertEquals(f63_0a, f63_0b, 0.0);
    Assert.assertEquals(f63_1a, f63_1b, 0.0);
  }

  @Test public void testBounds64()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, 64);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, 64);
    final long k64_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized64(0.0);
    final long k64_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized64(1.0);

    final double f64_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized64(k64_0);
    final double f64_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized64(k64_1);
    final double f64_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k64_0, 64);
    final double f64_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k64_1, 64);

    System.out.printf("[64] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[64] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[64] k64_0: %s\n", Long.toUnsignedString(k64_0));
    System.out.printf("[64] k64_1: %s\n", Long.toUnsignedString(k64_1));
    System.out.printf("[64] f64_0a: %f\n", f64_0a);
    System.out.printf("[64] f64_1a: %f\n", f64_1a);
    System.out.printf("[64] f64_0b: %f\n", f64_0b);
    System.out.printf("[64] f64_1b: %f\n", f64_1b);

    Assert.assertEquals(k64_0, k0);
    Assert.assertEquals(k64_1, k1);
    Assert.assertEquals(f64_0a, 0.0, 0.0);
    Assert.assertEquals(f64_1a, 1.0, 0.0);
    Assert.assertEquals(f64_0b, 0.0, 0.0);
    Assert.assertEquals(f64_1b, 1.0, 0.0);
    Assert.assertEquals(f64_0a, f64_0b, 0.0);
    Assert.assertEquals(f64_1a, f64_1b, 0.0);
  }
}
