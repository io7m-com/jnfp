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

import com.io7m.jnfp.core.NFPUnsignedFloatInt;
import org.junit.Assert;
import org.junit.Test;

public final class NFPUnsignedFloatIntTest
{
  @Test public void testBounds()
  {
    for (int e = 2; e <= 32; ++e) {
      final int k0 = NFPUnsignedFloatInt.toUnsignedNormalized(0.0f, e);
      final float f0 = NFPUnsignedFloatInt.fromUnsignedNormalized(k0, e);

      System.out.printf("[%d] k0: %s\n", e, Integer.toUnsignedString(k0));
      System.out.printf("[%d] f0: %f\n", e, f0);
      Assert.assertEquals(0L, (long) k0);
      Assert.assertEquals(0.0, f0, 0.0);

      final int k1 = NFPUnsignedFloatInt.toUnsignedNormalized(1.0f, e);
      final float f1 = NFPUnsignedFloatInt.fromUnsignedNormalized(k1, e);

      System.out.printf("[%d] k1: %s\n", e, Integer.toUnsignedString(k1));
      System.out.printf("[%d] f1: %f\n", e, f1);
      Assert.assertNotEquals(0, k1);
      Assert.assertEquals(1.0, f1, 0.0);
    }
  }

  @Test public void testBounds2()
  {
    final int k0 = NFPUnsignedFloatInt.toUnsignedNormalized(0.0f, 2);
    final int k1 = NFPUnsignedFloatInt.toUnsignedNormalized(1.0f, 2);
    final int k2_0 = NFPUnsignedFloatInt.toUnsignedNormalized2(0.0f);
    final int k2_1 = NFPUnsignedFloatInt.toUnsignedNormalized2(1.0f);

    final float f2_0a = NFPUnsignedFloatInt.fromUnsignedNormalized2(k2_0);
    final float f2_1a = NFPUnsignedFloatInt.fromUnsignedNormalized2(k2_1);
    final float f2_0b = NFPUnsignedFloatInt.fromUnsignedNormalized(k2_0, 2);
    final float f2_1b = NFPUnsignedFloatInt.fromUnsignedNormalized(k2_1, 2);

    System.out.printf("[2] k0: %s\n", Integer.toUnsignedString(k0));
    System.out.printf("[2] k1: %s\n", Integer.toUnsignedString(k1));
    System.out.printf("[2] k2_0: %s\n", Integer.toUnsignedString(k2_0));
    System.out.printf("[2] k2_1: %s\n", Integer.toUnsignedString(k2_1));
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
    final int k0 = NFPUnsignedFloatInt.toUnsignedNormalized(0.0f, 3);
    final int k1 = NFPUnsignedFloatInt.toUnsignedNormalized(1.0f, 3);
    final int k3_0 = NFPUnsignedFloatInt.toUnsignedNormalized3(0.0f);
    final int k3_1 = NFPUnsignedFloatInt.toUnsignedNormalized3(1.0f);

    final float f3_0a = NFPUnsignedFloatInt.fromUnsignedNormalized3(k3_0);
    final float f3_1a = NFPUnsignedFloatInt.fromUnsignedNormalized3(k3_1);
    final float f3_0b = NFPUnsignedFloatInt.fromUnsignedNormalized(k3_0, 3);
    final float f3_1b = NFPUnsignedFloatInt.fromUnsignedNormalized(k3_1, 3);

    System.out.printf("[3] k0: %s\n", Integer.toUnsignedString(k0));
    System.out.printf("[3] k1: %s\n", Integer.toUnsignedString(k1));
    System.out.printf("[3] k3_0: %s\n", Integer.toUnsignedString(k3_0));
    System.out.printf("[3] k3_1: %s\n", Integer.toUnsignedString(k3_1));
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
    final int k0 = NFPUnsignedFloatInt.toUnsignedNormalized(0.0f, 4);
    final int k1 = NFPUnsignedFloatInt.toUnsignedNormalized(1.0f, 4);
    final int k4_0 = NFPUnsignedFloatInt.toUnsignedNormalized4(0.0f);
    final int k4_1 = NFPUnsignedFloatInt.toUnsignedNormalized4(1.0f);

    final float f4_0a = NFPUnsignedFloatInt.fromUnsignedNormalized4(k4_0);
    final float f4_1a = NFPUnsignedFloatInt.fromUnsignedNormalized4(k4_1);
    final float f4_0b = NFPUnsignedFloatInt.fromUnsignedNormalized(k4_0, 4);
    final float f4_1b = NFPUnsignedFloatInt.fromUnsignedNormalized(k4_1, 4);

    System.out.printf("[4] k0: %s\n", Integer.toUnsignedString(k0));
    System.out.printf("[4] k1: %s\n", Integer.toUnsignedString(k1));
    System.out.printf("[4] k4_0: %s\n", Integer.toUnsignedString(k4_0));
    System.out.printf("[4] k4_1: %s\n", Integer.toUnsignedString(k4_1));
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
    final int k0 = NFPUnsignedFloatInt.toUnsignedNormalized(0.0f, 5);
    final int k1 = NFPUnsignedFloatInt.toUnsignedNormalized(1.0f, 5);
    final int k5_0 = NFPUnsignedFloatInt.toUnsignedNormalized5(0.0f);
    final int k5_1 = NFPUnsignedFloatInt.toUnsignedNormalized5(1.0f);

    final float f5_0a = NFPUnsignedFloatInt.fromUnsignedNormalized5(k5_0);
    final float f5_1a = NFPUnsignedFloatInt.fromUnsignedNormalized5(k5_1);
    final float f5_0b = NFPUnsignedFloatInt.fromUnsignedNormalized(k5_0, 5);
    final float f5_1b = NFPUnsignedFloatInt.fromUnsignedNormalized(k5_1, 5);

    System.out.printf("[5] k0: %s\n", Integer.toUnsignedString(k0));
    System.out.printf("[5] k1: %s\n", Integer.toUnsignedString(k1));
    System.out.printf("[5] k5_0: %s\n", Integer.toUnsignedString(k5_0));
    System.out.printf("[5] k5_1: %s\n", Integer.toUnsignedString(k5_1));
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
    final int k0 = NFPUnsignedFloatInt.toUnsignedNormalized(0.0f, 6);
    final int k1 = NFPUnsignedFloatInt.toUnsignedNormalized(1.0f, 6);
    final int k6_0 = NFPUnsignedFloatInt.toUnsignedNormalized6(0.0f);
    final int k6_1 = NFPUnsignedFloatInt.toUnsignedNormalized6(1.0f);

    final float f6_0a = NFPUnsignedFloatInt.fromUnsignedNormalized6(k6_0);
    final float f6_1a = NFPUnsignedFloatInt.fromUnsignedNormalized6(k6_1);
    final float f6_0b = NFPUnsignedFloatInt.fromUnsignedNormalized(k6_0, 6);
    final float f6_1b = NFPUnsignedFloatInt.fromUnsignedNormalized(k6_1, 6);

    System.out.printf("[6] k0: %s\n", Integer.toUnsignedString(k0));
    System.out.printf("[6] k1: %s\n", Integer.toUnsignedString(k1));
    System.out.printf("[6] k6_0: %s\n", Integer.toUnsignedString(k6_0));
    System.out.printf("[6] k6_1: %s\n", Integer.toUnsignedString(k6_1));
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
    final int k0 = NFPUnsignedFloatInt.toUnsignedNormalized(0.0f, 7);
    final int k1 = NFPUnsignedFloatInt.toUnsignedNormalized(1.0f, 7);
    final int k7_0 = NFPUnsignedFloatInt.toUnsignedNormalized7(0.0f);
    final int k7_1 = NFPUnsignedFloatInt.toUnsignedNormalized7(1.0f);

    final float f7_0a = NFPUnsignedFloatInt.fromUnsignedNormalized7(k7_0);
    final float f7_1a = NFPUnsignedFloatInt.fromUnsignedNormalized7(k7_1);
    final float f7_0b = NFPUnsignedFloatInt.fromUnsignedNormalized(k7_0, 7);
    final float f7_1b = NFPUnsignedFloatInt.fromUnsignedNormalized(k7_1, 7);

    System.out.printf("[7] k0: %s\n", Integer.toUnsignedString(k0));
    System.out.printf("[7] k1: %s\n", Integer.toUnsignedString(k1));
    System.out.printf("[7] k7_0: %s\n", Integer.toUnsignedString(k7_0));
    System.out.printf("[7] k7_1: %s\n", Integer.toUnsignedString(k7_1));
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
    final int k0 = NFPUnsignedFloatInt.toUnsignedNormalized(0.0f, 8);
    final int k1 = NFPUnsignedFloatInt.toUnsignedNormalized(1.0f, 8);
    final int k8_0 = NFPUnsignedFloatInt.toUnsignedNormalized8(0.0f);
    final int k8_1 = NFPUnsignedFloatInt.toUnsignedNormalized8(1.0f);

    final float f8_0a = NFPUnsignedFloatInt.fromUnsignedNormalized8(k8_0);
    final float f8_1a = NFPUnsignedFloatInt.fromUnsignedNormalized8(k8_1);
    final float f8_0b = NFPUnsignedFloatInt.fromUnsignedNormalized(k8_0, 8);
    final float f8_1b = NFPUnsignedFloatInt.fromUnsignedNormalized(k8_1, 8);

    System.out.printf("[8] k0: %s\n", Integer.toUnsignedString(k0));
    System.out.printf("[8] k1: %s\n", Integer.toUnsignedString(k1));
    System.out.printf("[8] k8_0: %s\n", Integer.toUnsignedString(k8_0));
    System.out.printf("[8] k8_1: %s\n", Integer.toUnsignedString(k8_1));
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
    final int k0 = NFPUnsignedFloatInt.toUnsignedNormalized(0.0f, 9);
    final int k1 = NFPUnsignedFloatInt.toUnsignedNormalized(1.0f, 9);
    final int k9_0 = NFPUnsignedFloatInt.toUnsignedNormalized9(0.0f);
    final int k9_1 = NFPUnsignedFloatInt.toUnsignedNormalized9(1.0f);

    final float f9_0a = NFPUnsignedFloatInt.fromUnsignedNormalized9(k9_0);
    final float f9_1a = NFPUnsignedFloatInt.fromUnsignedNormalized9(k9_1);
    final float f9_0b = NFPUnsignedFloatInt.fromUnsignedNormalized(k9_0, 9);
    final float f9_1b = NFPUnsignedFloatInt.fromUnsignedNormalized(k9_1, 9);

    System.out.printf("[9] k0: %s\n", Integer.toUnsignedString(k0));
    System.out.printf("[9] k1: %s\n", Integer.toUnsignedString(k1));
    System.out.printf("[9] k9_0: %s\n", Integer.toUnsignedString(k9_0));
    System.out.printf("[9] k9_1: %s\n", Integer.toUnsignedString(k9_1));
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
    final int k0 = NFPUnsignedFloatInt.toUnsignedNormalized(0.0f, 10);
    final int k1 = NFPUnsignedFloatInt.toUnsignedNormalized(1.0f, 10);
    final int k10_0 = NFPUnsignedFloatInt.toUnsignedNormalized10(0.0f);
    final int k10_1 = NFPUnsignedFloatInt.toUnsignedNormalized10(1.0f);

    final float f10_0a = NFPUnsignedFloatInt.fromUnsignedNormalized10(k10_0);
    final float f10_1a = NFPUnsignedFloatInt.fromUnsignedNormalized10(k10_1);
    final float f10_0b = NFPUnsignedFloatInt.fromUnsignedNormalized(k10_0, 10);
    final float f10_1b = NFPUnsignedFloatInt.fromUnsignedNormalized(k10_1, 10);

    System.out.printf("[10] k0: %s\n", Integer.toUnsignedString(k0));
    System.out.printf("[10] k1: %s\n", Integer.toUnsignedString(k1));
    System.out.printf("[10] k10_0: %s\n", Integer.toUnsignedString(k10_0));
    System.out.printf("[10] k10_1: %s\n", Integer.toUnsignedString(k10_1));
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
    final int k0 = NFPUnsignedFloatInt.toUnsignedNormalized(0.0f, 11);
    final int k1 = NFPUnsignedFloatInt.toUnsignedNormalized(1.0f, 11);
    final int k11_0 = NFPUnsignedFloatInt.toUnsignedNormalized11(0.0f);
    final int k11_1 = NFPUnsignedFloatInt.toUnsignedNormalized11(1.0f);

    final float f11_0a = NFPUnsignedFloatInt.fromUnsignedNormalized11(k11_0);
    final float f11_1a = NFPUnsignedFloatInt.fromUnsignedNormalized11(k11_1);
    final float f11_0b = NFPUnsignedFloatInt.fromUnsignedNormalized(k11_0, 11);
    final float f11_1b = NFPUnsignedFloatInt.fromUnsignedNormalized(k11_1, 11);

    System.out.printf("[11] k0: %s\n", Integer.toUnsignedString(k0));
    System.out.printf("[11] k1: %s\n", Integer.toUnsignedString(k1));
    System.out.printf("[11] k11_0: %s\n", Integer.toUnsignedString(k11_0));
    System.out.printf("[11] k11_1: %s\n", Integer.toUnsignedString(k11_1));
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
    final int k0 = NFPUnsignedFloatInt.toUnsignedNormalized(0.0f, 12);
    final int k1 = NFPUnsignedFloatInt.toUnsignedNormalized(1.0f, 12);
    final int k12_0 = NFPUnsignedFloatInt.toUnsignedNormalized12(0.0f);
    final int k12_1 = NFPUnsignedFloatInt.toUnsignedNormalized12(1.0f);

    final float f12_0a = NFPUnsignedFloatInt.fromUnsignedNormalized12(k12_0);
    final float f12_1a = NFPUnsignedFloatInt.fromUnsignedNormalized12(k12_1);
    final float f12_0b = NFPUnsignedFloatInt.fromUnsignedNormalized(k12_0, 12);
    final float f12_1b = NFPUnsignedFloatInt.fromUnsignedNormalized(k12_1, 12);

    System.out.printf("[12] k0: %s\n", Integer.toUnsignedString(k0));
    System.out.printf("[12] k1: %s\n", Integer.toUnsignedString(k1));
    System.out.printf("[12] k12_0: %s\n", Integer.toUnsignedString(k12_0));
    System.out.printf("[12] k12_1: %s\n", Integer.toUnsignedString(k12_1));
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
    final int k0 = NFPUnsignedFloatInt.toUnsignedNormalized(0.0f, 13);
    final int k1 = NFPUnsignedFloatInt.toUnsignedNormalized(1.0f, 13);
    final int k13_0 = NFPUnsignedFloatInt.toUnsignedNormalized13(0.0f);
    final int k13_1 = NFPUnsignedFloatInt.toUnsignedNormalized13(1.0f);

    final float f13_0a = NFPUnsignedFloatInt.fromUnsignedNormalized13(k13_0);
    final float f13_1a = NFPUnsignedFloatInt.fromUnsignedNormalized13(k13_1);
    final float f13_0b = NFPUnsignedFloatInt.fromUnsignedNormalized(k13_0, 13);
    final float f13_1b = NFPUnsignedFloatInt.fromUnsignedNormalized(k13_1, 13);

    System.out.printf("[13] k0: %s\n", Integer.toUnsignedString(k0));
    System.out.printf("[13] k1: %s\n", Integer.toUnsignedString(k1));
    System.out.printf("[13] k13_0: %s\n", Integer.toUnsignedString(k13_0));
    System.out.printf("[13] k13_1: %s\n", Integer.toUnsignedString(k13_1));
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
    final int k0 = NFPUnsignedFloatInt.toUnsignedNormalized(0.0f, 14);
    final int k1 = NFPUnsignedFloatInt.toUnsignedNormalized(1.0f, 14);
    final int k14_0 = NFPUnsignedFloatInt.toUnsignedNormalized14(0.0f);
    final int k14_1 = NFPUnsignedFloatInt.toUnsignedNormalized14(1.0f);

    final float f14_0a = NFPUnsignedFloatInt.fromUnsignedNormalized14(k14_0);
    final float f14_1a = NFPUnsignedFloatInt.fromUnsignedNormalized14(k14_1);
    final float f14_0b = NFPUnsignedFloatInt.fromUnsignedNormalized(k14_0, 14);
    final float f14_1b = NFPUnsignedFloatInt.fromUnsignedNormalized(k14_1, 14);

    System.out.printf("[14] k0: %s\n", Integer.toUnsignedString(k0));
    System.out.printf("[14] k1: %s\n", Integer.toUnsignedString(k1));
    System.out.printf("[14] k14_0: %s\n", Integer.toUnsignedString(k14_0));
    System.out.printf("[14] k14_1: %s\n", Integer.toUnsignedString(k14_1));
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
    final int k0 = NFPUnsignedFloatInt.toUnsignedNormalized(0.0f, 15);
    final int k1 = NFPUnsignedFloatInt.toUnsignedNormalized(1.0f, 15);
    final int k15_0 = NFPUnsignedFloatInt.toUnsignedNormalized15(0.0f);
    final int k15_1 = NFPUnsignedFloatInt.toUnsignedNormalized15(1.0f);

    final float f15_0a = NFPUnsignedFloatInt.fromUnsignedNormalized15(k15_0);
    final float f15_1a = NFPUnsignedFloatInt.fromUnsignedNormalized15(k15_1);
    final float f15_0b = NFPUnsignedFloatInt.fromUnsignedNormalized(k15_0, 15);
    final float f15_1b = NFPUnsignedFloatInt.fromUnsignedNormalized(k15_1, 15);

    System.out.printf("[15] k0: %s\n", Integer.toUnsignedString(k0));
    System.out.printf("[15] k1: %s\n", Integer.toUnsignedString(k1));
    System.out.printf("[15] k15_0: %s\n", Integer.toUnsignedString(k15_0));
    System.out.printf("[15] k15_1: %s\n", Integer.toUnsignedString(k15_1));
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
    final int k0 = NFPUnsignedFloatInt.toUnsignedNormalized(0.0f, 16);
    final int k1 = NFPUnsignedFloatInt.toUnsignedNormalized(1.0f, 16);
    final int k16_0 = NFPUnsignedFloatInt.toUnsignedNormalized16(0.0f);
    final int k16_1 = NFPUnsignedFloatInt.toUnsignedNormalized16(1.0f);

    final float f16_0a = NFPUnsignedFloatInt.fromUnsignedNormalized16(k16_0);
    final float f16_1a = NFPUnsignedFloatInt.fromUnsignedNormalized16(k16_1);
    final float f16_0b = NFPUnsignedFloatInt.fromUnsignedNormalized(k16_0, 16);
    final float f16_1b = NFPUnsignedFloatInt.fromUnsignedNormalized(k16_1, 16);

    System.out.printf("[16] k0: %s\n", Integer.toUnsignedString(k0));
    System.out.printf("[16] k1: %s\n", Integer.toUnsignedString(k1));
    System.out.printf("[16] k16_0: %s\n", Integer.toUnsignedString(k16_0));
    System.out.printf("[16] k16_1: %s\n", Integer.toUnsignedString(k16_1));
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
    final int k0 = NFPUnsignedFloatInt.toUnsignedNormalized(0.0f, 17);
    final int k1 = NFPUnsignedFloatInt.toUnsignedNormalized(1.0f, 17);
    final int k17_0 = NFPUnsignedFloatInt.toUnsignedNormalized17(0.0f);
    final int k17_1 = NFPUnsignedFloatInt.toUnsignedNormalized17(1.0f);

    final float f17_0a = NFPUnsignedFloatInt.fromUnsignedNormalized17(k17_0);
    final float f17_1a = NFPUnsignedFloatInt.fromUnsignedNormalized17(k17_1);
    final float f17_0b = NFPUnsignedFloatInt.fromUnsignedNormalized(k17_0, 17);
    final float f17_1b = NFPUnsignedFloatInt.fromUnsignedNormalized(k17_1, 17);

    System.out.printf("[17] k0: %s\n", Integer.toUnsignedString(k0));
    System.out.printf("[17] k1: %s\n", Integer.toUnsignedString(k1));
    System.out.printf("[17] k17_0: %s\n", Integer.toUnsignedString(k17_0));
    System.out.printf("[17] k17_1: %s\n", Integer.toUnsignedString(k17_1));
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
    final int k0 = NFPUnsignedFloatInt.toUnsignedNormalized(0.0f, 18);
    final int k1 = NFPUnsignedFloatInt.toUnsignedNormalized(1.0f, 18);
    final int k18_0 = NFPUnsignedFloatInt.toUnsignedNormalized18(0.0f);
    final int k18_1 = NFPUnsignedFloatInt.toUnsignedNormalized18(1.0f);

    final float f18_0a = NFPUnsignedFloatInt.fromUnsignedNormalized18(k18_0);
    final float f18_1a = NFPUnsignedFloatInt.fromUnsignedNormalized18(k18_1);
    final float f18_0b = NFPUnsignedFloatInt.fromUnsignedNormalized(k18_0, 18);
    final float f18_1b = NFPUnsignedFloatInt.fromUnsignedNormalized(k18_1, 18);

    System.out.printf("[18] k0: %s\n", Integer.toUnsignedString(k0));
    System.out.printf("[18] k1: %s\n", Integer.toUnsignedString(k1));
    System.out.printf("[18] k18_0: %s\n", Integer.toUnsignedString(k18_0));
    System.out.printf("[18] k18_1: %s\n", Integer.toUnsignedString(k18_1));
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
    final int k0 = NFPUnsignedFloatInt.toUnsignedNormalized(0.0f, 19);
    final int k1 = NFPUnsignedFloatInt.toUnsignedNormalized(1.0f, 19);
    final int k19_0 = NFPUnsignedFloatInt.toUnsignedNormalized19(0.0f);
    final int k19_1 = NFPUnsignedFloatInt.toUnsignedNormalized19(1.0f);

    final float f19_0a = NFPUnsignedFloatInt.fromUnsignedNormalized19(k19_0);
    final float f19_1a = NFPUnsignedFloatInt.fromUnsignedNormalized19(k19_1);
    final float f19_0b = NFPUnsignedFloatInt.fromUnsignedNormalized(k19_0, 19);
    final float f19_1b = NFPUnsignedFloatInt.fromUnsignedNormalized(k19_1, 19);

    System.out.printf("[19] k0: %s\n", Integer.toUnsignedString(k0));
    System.out.printf("[19] k1: %s\n", Integer.toUnsignedString(k1));
    System.out.printf("[19] k19_0: %s\n", Integer.toUnsignedString(k19_0));
    System.out.printf("[19] k19_1: %s\n", Integer.toUnsignedString(k19_1));
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
    final int k0 = NFPUnsignedFloatInt.toUnsignedNormalized(0.0f, 20);
    final int k1 = NFPUnsignedFloatInt.toUnsignedNormalized(1.0f, 20);
    final int k20_0 = NFPUnsignedFloatInt.toUnsignedNormalized20(0.0f);
    final int k20_1 = NFPUnsignedFloatInt.toUnsignedNormalized20(1.0f);

    final float f20_0a = NFPUnsignedFloatInt.fromUnsignedNormalized20(k20_0);
    final float f20_1a = NFPUnsignedFloatInt.fromUnsignedNormalized20(k20_1);
    final float f20_0b = NFPUnsignedFloatInt.fromUnsignedNormalized(k20_0, 20);
    final float f20_1b = NFPUnsignedFloatInt.fromUnsignedNormalized(k20_1, 20);

    System.out.printf("[20] k0: %s\n", Integer.toUnsignedString(k0));
    System.out.printf("[20] k1: %s\n", Integer.toUnsignedString(k1));
    System.out.printf("[20] k20_0: %s\n", Integer.toUnsignedString(k20_0));
    System.out.printf("[20] k20_1: %s\n", Integer.toUnsignedString(k20_1));
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
    final int k0 = NFPUnsignedFloatInt.toUnsignedNormalized(0.0f, 21);
    final int k1 = NFPUnsignedFloatInt.toUnsignedNormalized(1.0f, 21);
    final int k21_0 = NFPUnsignedFloatInt.toUnsignedNormalized21(0.0f);
    final int k21_1 = NFPUnsignedFloatInt.toUnsignedNormalized21(1.0f);

    final float f21_0a = NFPUnsignedFloatInt.fromUnsignedNormalized21(k21_0);
    final float f21_1a = NFPUnsignedFloatInt.fromUnsignedNormalized21(k21_1);
    final float f21_0b = NFPUnsignedFloatInt.fromUnsignedNormalized(k21_0, 21);
    final float f21_1b = NFPUnsignedFloatInt.fromUnsignedNormalized(k21_1, 21);

    System.out.printf("[21] k0: %s\n", Integer.toUnsignedString(k0));
    System.out.printf("[21] k1: %s\n", Integer.toUnsignedString(k1));
    System.out.printf("[21] k21_0: %s\n", Integer.toUnsignedString(k21_0));
    System.out.printf("[21] k21_1: %s\n", Integer.toUnsignedString(k21_1));
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
    final int k0 = NFPUnsignedFloatInt.toUnsignedNormalized(0.0f, 22);
    final int k1 = NFPUnsignedFloatInt.toUnsignedNormalized(1.0f, 22);
    final int k22_0 = NFPUnsignedFloatInt.toUnsignedNormalized22(0.0f);
    final int k22_1 = NFPUnsignedFloatInt.toUnsignedNormalized22(1.0f);

    final float f22_0a = NFPUnsignedFloatInt.fromUnsignedNormalized22(k22_0);
    final float f22_1a = NFPUnsignedFloatInt.fromUnsignedNormalized22(k22_1);
    final float f22_0b = NFPUnsignedFloatInt.fromUnsignedNormalized(k22_0, 22);
    final float f22_1b = NFPUnsignedFloatInt.fromUnsignedNormalized(k22_1, 22);

    System.out.printf("[22] k0: %s\n", Integer.toUnsignedString(k0));
    System.out.printf("[22] k1: %s\n", Integer.toUnsignedString(k1));
    System.out.printf("[22] k22_0: %s\n", Integer.toUnsignedString(k22_0));
    System.out.printf("[22] k22_1: %s\n", Integer.toUnsignedString(k22_1));
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
    final int k0 = NFPUnsignedFloatInt.toUnsignedNormalized(0.0f, 23);
    final int k1 = NFPUnsignedFloatInt.toUnsignedNormalized(1.0f, 23);
    final int k23_0 = NFPUnsignedFloatInt.toUnsignedNormalized23(0.0f);
    final int k23_1 = NFPUnsignedFloatInt.toUnsignedNormalized23(1.0f);

    final float f23_0a = NFPUnsignedFloatInt.fromUnsignedNormalized23(k23_0);
    final float f23_1a = NFPUnsignedFloatInt.fromUnsignedNormalized23(k23_1);
    final float f23_0b = NFPUnsignedFloatInt.fromUnsignedNormalized(k23_0, 23);
    final float f23_1b = NFPUnsignedFloatInt.fromUnsignedNormalized(k23_1, 23);

    System.out.printf("[23] k0: %s\n", Integer.toUnsignedString(k0));
    System.out.printf("[23] k1: %s\n", Integer.toUnsignedString(k1));
    System.out.printf("[23] k23_0: %s\n", Integer.toUnsignedString(k23_0));
    System.out.printf("[23] k23_1: %s\n", Integer.toUnsignedString(k23_1));
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
    final int k0 = NFPUnsignedFloatInt.toUnsignedNormalized(0.0f, 24);
    final int k1 = NFPUnsignedFloatInt.toUnsignedNormalized(1.0f, 24);
    final int k24_0 = NFPUnsignedFloatInt.toUnsignedNormalized24(0.0f);
    final int k24_1 = NFPUnsignedFloatInt.toUnsignedNormalized24(1.0f);

    final float f24_0a = NFPUnsignedFloatInt.fromUnsignedNormalized24(k24_0);
    final float f24_1a = NFPUnsignedFloatInt.fromUnsignedNormalized24(k24_1);
    final float f24_0b = NFPUnsignedFloatInt.fromUnsignedNormalized(k24_0, 24);
    final float f24_1b = NFPUnsignedFloatInt.fromUnsignedNormalized(k24_1, 24);

    System.out.printf("[24] k0: %s\n", Integer.toUnsignedString(k0));
    System.out.printf("[24] k1: %s\n", Integer.toUnsignedString(k1));
    System.out.printf("[24] k24_0: %s\n", Integer.toUnsignedString(k24_0));
    System.out.printf("[24] k24_1: %s\n", Integer.toUnsignedString(k24_1));
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
    final int k0 = NFPUnsignedFloatInt.toUnsignedNormalized(0.0f, 25);
    final int k1 = NFPUnsignedFloatInt.toUnsignedNormalized(1.0f, 25);
    final int k25_0 = NFPUnsignedFloatInt.toUnsignedNormalized25(0.0f);
    final int k25_1 = NFPUnsignedFloatInt.toUnsignedNormalized25(1.0f);

    final float f25_0a = NFPUnsignedFloatInt.fromUnsignedNormalized25(k25_0);
    final float f25_1a = NFPUnsignedFloatInt.fromUnsignedNormalized25(k25_1);
    final float f25_0b = NFPUnsignedFloatInt.fromUnsignedNormalized(k25_0, 25);
    final float f25_1b = NFPUnsignedFloatInt.fromUnsignedNormalized(k25_1, 25);

    System.out.printf("[25] k0: %s\n", Integer.toUnsignedString(k0));
    System.out.printf("[25] k1: %s\n", Integer.toUnsignedString(k1));
    System.out.printf("[25] k25_0: %s\n", Integer.toUnsignedString(k25_0));
    System.out.printf("[25] k25_1: %s\n", Integer.toUnsignedString(k25_1));
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
    final int k0 = NFPUnsignedFloatInt.toUnsignedNormalized(0.0f, 26);
    final int k1 = NFPUnsignedFloatInt.toUnsignedNormalized(1.0f, 26);
    final int k26_0 = NFPUnsignedFloatInt.toUnsignedNormalized26(0.0f);
    final int k26_1 = NFPUnsignedFloatInt.toUnsignedNormalized26(1.0f);

    final float f26_0a = NFPUnsignedFloatInt.fromUnsignedNormalized26(k26_0);
    final float f26_1a = NFPUnsignedFloatInt.fromUnsignedNormalized26(k26_1);
    final float f26_0b = NFPUnsignedFloatInt.fromUnsignedNormalized(k26_0, 26);
    final float f26_1b = NFPUnsignedFloatInt.fromUnsignedNormalized(k26_1, 26);

    System.out.printf("[26] k0: %s\n", Integer.toUnsignedString(k0));
    System.out.printf("[26] k1: %s\n", Integer.toUnsignedString(k1));
    System.out.printf("[26] k26_0: %s\n", Integer.toUnsignedString(k26_0));
    System.out.printf("[26] k26_1: %s\n", Integer.toUnsignedString(k26_1));
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
    final int k0 = NFPUnsignedFloatInt.toUnsignedNormalized(0.0f, 27);
    final int k1 = NFPUnsignedFloatInt.toUnsignedNormalized(1.0f, 27);
    final int k27_0 = NFPUnsignedFloatInt.toUnsignedNormalized27(0.0f);
    final int k27_1 = NFPUnsignedFloatInt.toUnsignedNormalized27(1.0f);

    final float f27_0a = NFPUnsignedFloatInt.fromUnsignedNormalized27(k27_0);
    final float f27_1a = NFPUnsignedFloatInt.fromUnsignedNormalized27(k27_1);
    final float f27_0b = NFPUnsignedFloatInt.fromUnsignedNormalized(k27_0, 27);
    final float f27_1b = NFPUnsignedFloatInt.fromUnsignedNormalized(k27_1, 27);

    System.out.printf("[27] k0: %s\n", Integer.toUnsignedString(k0));
    System.out.printf("[27] k1: %s\n", Integer.toUnsignedString(k1));
    System.out.printf("[27] k27_0: %s\n", Integer.toUnsignedString(k27_0));
    System.out.printf("[27] k27_1: %s\n", Integer.toUnsignedString(k27_1));
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
    final int k0 = NFPUnsignedFloatInt.toUnsignedNormalized(0.0f, 28);
    final int k1 = NFPUnsignedFloatInt.toUnsignedNormalized(1.0f, 28);
    final int k28_0 = NFPUnsignedFloatInt.toUnsignedNormalized28(0.0f);
    final int k28_1 = NFPUnsignedFloatInt.toUnsignedNormalized28(1.0f);

    final float f28_0a = NFPUnsignedFloatInt.fromUnsignedNormalized28(k28_0);
    final float f28_1a = NFPUnsignedFloatInt.fromUnsignedNormalized28(k28_1);
    final float f28_0b = NFPUnsignedFloatInt.fromUnsignedNormalized(k28_0, 28);
    final float f28_1b = NFPUnsignedFloatInt.fromUnsignedNormalized(k28_1, 28);

    System.out.printf("[28] k0: %s\n", Integer.toUnsignedString(k0));
    System.out.printf("[28] k1: %s\n", Integer.toUnsignedString(k1));
    System.out.printf("[28] k28_0: %s\n", Integer.toUnsignedString(k28_0));
    System.out.printf("[28] k28_1: %s\n", Integer.toUnsignedString(k28_1));
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
    final int k0 = NFPUnsignedFloatInt.toUnsignedNormalized(0.0f, 29);
    final int k1 = NFPUnsignedFloatInt.toUnsignedNormalized(1.0f, 29);
    final int k29_0 = NFPUnsignedFloatInt.toUnsignedNormalized29(0.0f);
    final int k29_1 = NFPUnsignedFloatInt.toUnsignedNormalized29(1.0f);

    final float f29_0a = NFPUnsignedFloatInt.fromUnsignedNormalized29(k29_0);
    final float f29_1a = NFPUnsignedFloatInt.fromUnsignedNormalized29(k29_1);
    final float f29_0b = NFPUnsignedFloatInt.fromUnsignedNormalized(k29_0, 29);
    final float f29_1b = NFPUnsignedFloatInt.fromUnsignedNormalized(k29_1, 29);

    System.out.printf("[29] k0: %s\n", Integer.toUnsignedString(k0));
    System.out.printf("[29] k1: %s\n", Integer.toUnsignedString(k1));
    System.out.printf("[29] k29_0: %s\n", Integer.toUnsignedString(k29_0));
    System.out.printf("[29] k29_1: %s\n", Integer.toUnsignedString(k29_1));
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
    final int k0 = NFPUnsignedFloatInt.toUnsignedNormalized(0.0f, 30);
    final int k1 = NFPUnsignedFloatInt.toUnsignedNormalized(1.0f, 30);
    final int k30_0 = NFPUnsignedFloatInt.toUnsignedNormalized30(0.0f);
    final int k30_1 = NFPUnsignedFloatInt.toUnsignedNormalized30(1.0f);

    final float f30_0a = NFPUnsignedFloatInt.fromUnsignedNormalized30(k30_0);
    final float f30_1a = NFPUnsignedFloatInt.fromUnsignedNormalized30(k30_1);
    final float f30_0b = NFPUnsignedFloatInt.fromUnsignedNormalized(k30_0, 30);
    final float f30_1b = NFPUnsignedFloatInt.fromUnsignedNormalized(k30_1, 30);

    System.out.printf("[30] k0: %s\n", Integer.toUnsignedString(k0));
    System.out.printf("[30] k1: %s\n", Integer.toUnsignedString(k1));
    System.out.printf("[30] k30_0: %s\n", Integer.toUnsignedString(k30_0));
    System.out.printf("[30] k30_1: %s\n", Integer.toUnsignedString(k30_1));
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
    final int k0 = NFPUnsignedFloatInt.toUnsignedNormalized(0.0f, 31);
    final int k1 = NFPUnsignedFloatInt.toUnsignedNormalized(1.0f, 31);
    final int k31_0 = NFPUnsignedFloatInt.toUnsignedNormalized31(0.0f);
    final int k31_1 = NFPUnsignedFloatInt.toUnsignedNormalized31(1.0f);

    final float f31_0a = NFPUnsignedFloatInt.fromUnsignedNormalized31(k31_0);
    final float f31_1a = NFPUnsignedFloatInt.fromUnsignedNormalized31(k31_1);
    final float f31_0b = NFPUnsignedFloatInt.fromUnsignedNormalized(k31_0, 31);
    final float f31_1b = NFPUnsignedFloatInt.fromUnsignedNormalized(k31_1, 31);

    System.out.printf("[31] k0: %s\n", Integer.toUnsignedString(k0));
    System.out.printf("[31] k1: %s\n", Integer.toUnsignedString(k1));
    System.out.printf("[31] k31_0: %s\n", Integer.toUnsignedString(k31_0));
    System.out.printf("[31] k31_1: %s\n", Integer.toUnsignedString(k31_1));
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
    final int k0 = NFPUnsignedFloatInt.toUnsignedNormalized(0.0f, 32);
    final int k1 = NFPUnsignedFloatInt.toUnsignedNormalized(1.0f, 32);
    final int k32_0 = NFPUnsignedFloatInt.toUnsignedNormalized32(0.0f);
    final int k32_1 = NFPUnsignedFloatInt.toUnsignedNormalized32(1.0f);

    final float f32_0a = NFPUnsignedFloatInt.fromUnsignedNormalized32(k32_0);
    final float f32_1a = NFPUnsignedFloatInt.fromUnsignedNormalized32(k32_1);
    final float f32_0b = NFPUnsignedFloatInt.fromUnsignedNormalized(k32_0, 32);
    final float f32_1b = NFPUnsignedFloatInt.fromUnsignedNormalized(k32_1, 32);

    System.out.printf("[32] k0: %s\n", Integer.toUnsignedString(k0));
    System.out.printf("[32] k1: %s\n", Integer.toUnsignedString(k1));
    System.out.printf("[32] k32_0: %s\n", Integer.toUnsignedString(k32_0));
    System.out.printf("[32] k32_1: %s\n", Integer.toUnsignedString(k32_1));
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
}
