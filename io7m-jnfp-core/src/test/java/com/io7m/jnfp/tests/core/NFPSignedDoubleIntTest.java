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

import com.io7m.jnfp.core.NFPSignedDoubleInt;
import org.junit.Assert;
import org.junit.Test;

public final class NFPSignedDoubleIntTest
{
  @Test public void testBoundsWithoutZero()
  {
    for (int e = 2; e <= 32; ++e) {
      final int km1 = NFPSignedDoubleInt.toSignedNormalizedWithoutZero(-1.0, e);
      final double fm1 =
        NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(km1, e);

      System.out.printf("[%d] km1: %s\n", e, Integer.toString(km1));
      System.out.printf("[%d] fm1: %f\n", e, fm1);
      Assert.assertNotEquals(0, km1);
      Assert.assertEquals(-1.0, fm1, 0.000000000000001);

      final int kp1 = NFPSignedDoubleInt.toSignedNormalizedWithoutZero(1.0, e);
      final double fp1 =
        NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(kp1, e);

      System.out.printf("[%d] kp1: %s\n", e, Integer.toString(kp1));
      System.out.printf("[%d] fp1: %f\n", e, fp1);
      Assert.assertNotEquals(0, kp1);
      Assert.assertEquals(1.0, fp1, 0.000000000000001);
    }
  }

  @Test public void testBoundsWithZero()
  {
    for (int e = 2; e <= 32; ++e) {
      final int km1 = NFPSignedDoubleInt.toSignedNormalizedWithZero(-1.0, e);
      final double fm1 =
        NFPSignedDoubleInt.fromSignedNormalizedWithZero(km1, e);

      System.out.printf("[%d] km1: %s\n", e, Integer.toString(km1));
      System.out.printf("[%d] fm1: %f\n", e, fm1);
      Assert.assertNotEquals(0, km1);
      Assert.assertEquals(-1.0, fm1, 0.000000000000001);

      final int kp1 = NFPSignedDoubleInt.toSignedNormalizedWithZero(1.0, e);
      final double fp1 =
        NFPSignedDoubleInt.fromSignedNormalizedWithZero(kp1, e);

      System.out.printf("[%d] kp1: %s\n", e, Integer.toString(kp1));
      System.out.printf("[%d] fp1: %f\n", e, fp1);
      Assert.assertNotEquals(0, kp1);
      Assert.assertEquals(1.0, fp1, 0.000000000000001);

      final int k0 = NFPSignedDoubleInt.toSignedNormalizedWithZero(0.0, e);
      final double f0 = NFPSignedDoubleInt.fromSignedNormalizedWithZero(k0, e);

      System.out.printf("[%d] k0: %s\n", e, Integer.toString(k0));
      System.out.printf("[%d] f0: %f\n", e, f0);
      Assert.assertEquals(0.0, f0, 0.0);
    }
  }

  @Test public void testBoundsWithoutZero2()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero2(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero2(1.0);
    final int k2_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(-1.0, 2);
    final int k2_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(1.0, 2);

    final double f2_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero2(k2_m1);
    final double f2_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero2(k2_p1);
    final double f2_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k2_m1, 2);
    final double f2_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k2_p1, 2);

    System.out.printf("[2] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[2] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[2] k2_m1: %s\n", Integer.toString(k2_m1));
    System.out.printf("[2] k2_p1: %s\n", Integer.toString(k2_p1));
    System.out.printf("[2] f2_m1a: %f\n", f2_m1a);
    System.out.printf("[2] f2_p1a: %f\n", f2_p1a);
    System.out.printf("[2] f2_m1b: %f\n", f2_m1b);
    System.out.printf("[2] f2_p1b: %f\n", f2_p1b);
  }

  @Test public void testBoundsWithZero2()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero2(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero2(1.0);
    final int k_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero2(0.0);
    final int k2_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(-1.0, 2);
    final int k2_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(1.0, 2);
    final int k2_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(0.0, 2);

    final double f2_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero2(k2_m1);
    final double f2_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero2(k2_p1);
    final double f2_0a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero2(k2_0);
    final double f2_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k2_m1, 2);
    final double f2_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k2_p1, 2);
    final double f2_0b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k2_0, 2);

    System.out.printf("[2] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[2] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[2] k_0: %s\n", Integer.toString(k_0));
    System.out.printf("[2] k2_m1: %s\n", Integer.toString(k2_m1));
    System.out.printf("[2] k2_p1: %s\n", Integer.toString(k2_p1));
    System.out.printf("[2] k2_0: %s\n", Integer.toString(k2_0));
    System.out.printf("[2] f2_m1a: %f\n", f2_m1a);
    System.out.printf("[2] f2_p1a: %f\n", f2_p1a);
    System.out.printf("[2] f2_0a: %f\n", f2_0a);
    System.out.printf("[2] f2_m1b: %f\n", f2_m1b);
    System.out.printf("[2] f2_p1b: %f\n", f2_p1b);
    System.out.printf("[2] f2_0b: %f\n", f2_0b);
  }

  @Test public void testBoundsWithoutZero3()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero3(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero3(1.0);
    final int k3_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(-1.0, 3);
    final int k3_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(1.0, 3);

    final double f3_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero3(k3_m1);
    final double f3_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero3(k3_p1);
    final double f3_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k3_m1, 3);
    final double f3_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k3_p1, 3);

    System.out.printf("[3] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[3] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[3] k3_m1: %s\n", Integer.toString(k3_m1));
    System.out.printf("[3] k3_p1: %s\n", Integer.toString(k3_p1));
    System.out.printf("[3] f3_m1a: %f\n", f3_m1a);
    System.out.printf("[3] f3_p1a: %f\n", f3_p1a);
    System.out.printf("[3] f3_m1b: %f\n", f3_m1b);
    System.out.printf("[3] f3_p1b: %f\n", f3_p1b);
  }

  @Test public void testBoundsWithZero3()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero3(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero3(1.0);
    final int k_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero3(0.0);
    final int k3_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(-1.0, 3);
    final int k3_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(1.0, 3);
    final int k3_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(0.0, 3);

    final double f3_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero3(k3_m1);
    final double f3_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero3(k3_p1);
    final double f3_0a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero3(k3_0);
    final double f3_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k3_m1, 3);
    final double f3_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k3_p1, 3);
    final double f3_0b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k3_0, 3);

    System.out.printf("[3] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[3] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[3] k_0: %s\n", Integer.toString(k_0));
    System.out.printf("[3] k3_m1: %s\n", Integer.toString(k3_m1));
    System.out.printf("[3] k3_p1: %s\n", Integer.toString(k3_p1));
    System.out.printf("[3] k3_0: %s\n", Integer.toString(k3_0));
    System.out.printf("[3] f3_m1a: %f\n", f3_m1a);
    System.out.printf("[3] f3_p1a: %f\n", f3_p1a);
    System.out.printf("[3] f3_0a: %f\n", f3_0a);
    System.out.printf("[3] f3_m1b: %f\n", f3_m1b);
    System.out.printf("[3] f3_p1b: %f\n", f3_p1b);
    System.out.printf("[3] f3_0b: %f\n", f3_0b);
  }

  @Test public void testBoundsWithoutZero4()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero4(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero4(1.0);
    final int k4_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(-1.0, 4);
    final int k4_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(1.0, 4);

    final double f4_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero4(k4_m1);
    final double f4_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero4(k4_p1);
    final double f4_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k4_m1, 4);
    final double f4_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k4_p1, 4);

    System.out.printf("[4] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[4] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[4] k4_m1: %s\n", Integer.toString(k4_m1));
    System.out.printf("[4] k4_p1: %s\n", Integer.toString(k4_p1));
    System.out.printf("[4] f4_m1a: %f\n", f4_m1a);
    System.out.printf("[4] f4_p1a: %f\n", f4_p1a);
    System.out.printf("[4] f4_m1b: %f\n", f4_m1b);
    System.out.printf("[4] f4_p1b: %f\n", f4_p1b);
  }

  @Test public void testBoundsWithZero4()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero4(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero4(1.0);
    final int k_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero4(0.0);
    final int k4_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(-1.0, 4);
    final int k4_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(1.0, 4);
    final int k4_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(0.0, 4);

    final double f4_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero4(k4_m1);
    final double f4_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero4(k4_p1);
    final double f4_0a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero4(k4_0);
    final double f4_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k4_m1, 4);
    final double f4_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k4_p1, 4);
    final double f4_0b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k4_0, 4);

    System.out.printf("[4] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[4] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[4] k_0: %s\n", Integer.toString(k_0));
    System.out.printf("[4] k4_m1: %s\n", Integer.toString(k4_m1));
    System.out.printf("[4] k4_p1: %s\n", Integer.toString(k4_p1));
    System.out.printf("[4] k4_0: %s\n", Integer.toString(k4_0));
    System.out.printf("[4] f4_m1a: %f\n", f4_m1a);
    System.out.printf("[4] f4_p1a: %f\n", f4_p1a);
    System.out.printf("[4] f4_0a: %f\n", f4_0a);
    System.out.printf("[4] f4_m1b: %f\n", f4_m1b);
    System.out.printf("[4] f4_p1b: %f\n", f4_p1b);
    System.out.printf("[4] f4_0b: %f\n", f4_0b);
  }

  @Test public void testBoundsWithoutZero5()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero5(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero5(1.0);
    final int k5_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(-1.0, 5);
    final int k5_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(1.0, 5);

    final double f5_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero5(k5_m1);
    final double f5_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero5(k5_p1);
    final double f5_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k5_m1, 5);
    final double f5_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k5_p1, 5);

    System.out.printf("[5] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[5] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[5] k5_m1: %s\n", Integer.toString(k5_m1));
    System.out.printf("[5] k5_p1: %s\n", Integer.toString(k5_p1));
    System.out.printf("[5] f5_m1a: %f\n", f5_m1a);
    System.out.printf("[5] f5_p1a: %f\n", f5_p1a);
    System.out.printf("[5] f5_m1b: %f\n", f5_m1b);
    System.out.printf("[5] f5_p1b: %f\n", f5_p1b);
  }

  @Test public void testBoundsWithZero5()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero5(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero5(1.0);
    final int k_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero5(0.0);
    final int k5_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(-1.0, 5);
    final int k5_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(1.0, 5);
    final int k5_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(0.0, 5);

    final double f5_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero5(k5_m1);
    final double f5_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero5(k5_p1);
    final double f5_0a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero5(k5_0);
    final double f5_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k5_m1, 5);
    final double f5_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k5_p1, 5);
    final double f5_0b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k5_0, 5);

    System.out.printf("[5] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[5] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[5] k_0: %s\n", Integer.toString(k_0));
    System.out.printf("[5] k5_m1: %s\n", Integer.toString(k5_m1));
    System.out.printf("[5] k5_p1: %s\n", Integer.toString(k5_p1));
    System.out.printf("[5] k5_0: %s\n", Integer.toString(k5_0));
    System.out.printf("[5] f5_m1a: %f\n", f5_m1a);
    System.out.printf("[5] f5_p1a: %f\n", f5_p1a);
    System.out.printf("[5] f5_0a: %f\n", f5_0a);
    System.out.printf("[5] f5_m1b: %f\n", f5_m1b);
    System.out.printf("[5] f5_p1b: %f\n", f5_p1b);
    System.out.printf("[5] f5_0b: %f\n", f5_0b);
  }

  @Test public void testBoundsWithoutZero6()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero6(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero6(1.0);
    final int k6_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(-1.0, 6);
    final int k6_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(1.0, 6);

    final double f6_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero6(k6_m1);
    final double f6_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero6(k6_p1);
    final double f6_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k6_m1, 6);
    final double f6_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k6_p1, 6);

    System.out.printf("[6] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[6] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[6] k6_m1: %s\n", Integer.toString(k6_m1));
    System.out.printf("[6] k6_p1: %s\n", Integer.toString(k6_p1));
    System.out.printf("[6] f6_m1a: %f\n", f6_m1a);
    System.out.printf("[6] f6_p1a: %f\n", f6_p1a);
    System.out.printf("[6] f6_m1b: %f\n", f6_m1b);
    System.out.printf("[6] f6_p1b: %f\n", f6_p1b);
  }

  @Test public void testBoundsWithZero6()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero6(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero6(1.0);
    final int k_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero6(0.0);
    final int k6_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(-1.0, 6);
    final int k6_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(1.0, 6);
    final int k6_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(0.0, 6);

    final double f6_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero6(k6_m1);
    final double f6_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero6(k6_p1);
    final double f6_0a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero6(k6_0);
    final double f6_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k6_m1, 6);
    final double f6_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k6_p1, 6);
    final double f6_0b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k6_0, 6);

    System.out.printf("[6] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[6] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[6] k_0: %s\n", Integer.toString(k_0));
    System.out.printf("[6] k6_m1: %s\n", Integer.toString(k6_m1));
    System.out.printf("[6] k6_p1: %s\n", Integer.toString(k6_p1));
    System.out.printf("[6] k6_0: %s\n", Integer.toString(k6_0));
    System.out.printf("[6] f6_m1a: %f\n", f6_m1a);
    System.out.printf("[6] f6_p1a: %f\n", f6_p1a);
    System.out.printf("[6] f6_0a: %f\n", f6_0a);
    System.out.printf("[6] f6_m1b: %f\n", f6_m1b);
    System.out.printf("[6] f6_p1b: %f\n", f6_p1b);
    System.out.printf("[6] f6_0b: %f\n", f6_0b);
  }

  @Test public void testBoundsWithoutZero7()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero7(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero7(1.0);
    final int k7_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(-1.0, 7);
    final int k7_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(1.0, 7);

    final double f7_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero7(k7_m1);
    final double f7_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero7(k7_p1);
    final double f7_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k7_m1, 7);
    final double f7_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k7_p1, 7);

    System.out.printf("[7] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[7] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[7] k7_m1: %s\n", Integer.toString(k7_m1));
    System.out.printf("[7] k7_p1: %s\n", Integer.toString(k7_p1));
    System.out.printf("[7] f7_m1a: %f\n", f7_m1a);
    System.out.printf("[7] f7_p1a: %f\n", f7_p1a);
    System.out.printf("[7] f7_m1b: %f\n", f7_m1b);
    System.out.printf("[7] f7_p1b: %f\n", f7_p1b);
  }

  @Test public void testBoundsWithZero7()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero7(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero7(1.0);
    final int k_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero7(0.0);
    final int k7_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(-1.0, 7);
    final int k7_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(1.0, 7);
    final int k7_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(0.0, 7);

    final double f7_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero7(k7_m1);
    final double f7_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero7(k7_p1);
    final double f7_0a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero7(k7_0);
    final double f7_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k7_m1, 7);
    final double f7_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k7_p1, 7);
    final double f7_0b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k7_0, 7);

    System.out.printf("[7] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[7] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[7] k_0: %s\n", Integer.toString(k_0));
    System.out.printf("[7] k7_m1: %s\n", Integer.toString(k7_m1));
    System.out.printf("[7] k7_p1: %s\n", Integer.toString(k7_p1));
    System.out.printf("[7] k7_0: %s\n", Integer.toString(k7_0));
    System.out.printf("[7] f7_m1a: %f\n", f7_m1a);
    System.out.printf("[7] f7_p1a: %f\n", f7_p1a);
    System.out.printf("[7] f7_0a: %f\n", f7_0a);
    System.out.printf("[7] f7_m1b: %f\n", f7_m1b);
    System.out.printf("[7] f7_p1b: %f\n", f7_p1b);
    System.out.printf("[7] f7_0b: %f\n", f7_0b);
  }

  @Test public void testBoundsWithoutZero8()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero8(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero8(1.0);
    final int k8_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(-1.0, 8);
    final int k8_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(1.0, 8);

    final double f8_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero8(k8_m1);
    final double f8_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero8(k8_p1);
    final double f8_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k8_m1, 8);
    final double f8_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k8_p1, 8);

    System.out.printf("[8] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[8] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[8] k8_m1: %s\n", Integer.toString(k8_m1));
    System.out.printf("[8] k8_p1: %s\n", Integer.toString(k8_p1));
    System.out.printf("[8] f8_m1a: %f\n", f8_m1a);
    System.out.printf("[8] f8_p1a: %f\n", f8_p1a);
    System.out.printf("[8] f8_m1b: %f\n", f8_m1b);
    System.out.printf("[8] f8_p1b: %f\n", f8_p1b);
  }

  @Test public void testBoundsWithZero8()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero8(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero8(1.0);
    final int k_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero8(0.0);
    final int k8_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(-1.0, 8);
    final int k8_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(1.0, 8);
    final int k8_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(0.0, 8);

    final double f8_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero8(k8_m1);
    final double f8_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero8(k8_p1);
    final double f8_0a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero8(k8_0);
    final double f8_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k8_m1, 8);
    final double f8_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k8_p1, 8);
    final double f8_0b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k8_0, 8);

    System.out.printf("[8] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[8] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[8] k_0: %s\n", Integer.toString(k_0));
    System.out.printf("[8] k8_m1: %s\n", Integer.toString(k8_m1));
    System.out.printf("[8] k8_p1: %s\n", Integer.toString(k8_p1));
    System.out.printf("[8] k8_0: %s\n", Integer.toString(k8_0));
    System.out.printf("[8] f8_m1a: %f\n", f8_m1a);
    System.out.printf("[8] f8_p1a: %f\n", f8_p1a);
    System.out.printf("[8] f8_0a: %f\n", f8_0a);
    System.out.printf("[8] f8_m1b: %f\n", f8_m1b);
    System.out.printf("[8] f8_p1b: %f\n", f8_p1b);
    System.out.printf("[8] f8_0b: %f\n", f8_0b);
  }

  @Test public void testBoundsWithoutZero9()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero9(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero9(1.0);
    final int k9_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(-1.0, 9);
    final int k9_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(1.0, 9);

    final double f9_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero9(k9_m1);
    final double f9_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero9(k9_p1);
    final double f9_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k9_m1, 9);
    final double f9_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k9_p1, 9);

    System.out.printf("[9] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[9] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[9] k9_m1: %s\n", Integer.toString(k9_m1));
    System.out.printf("[9] k9_p1: %s\n", Integer.toString(k9_p1));
    System.out.printf("[9] f9_m1a: %f\n", f9_m1a);
    System.out.printf("[9] f9_p1a: %f\n", f9_p1a);
    System.out.printf("[9] f9_m1b: %f\n", f9_m1b);
    System.out.printf("[9] f9_p1b: %f\n", f9_p1b);
  }

  @Test public void testBoundsWithZero9()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero9(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero9(1.0);
    final int k_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero9(0.0);
    final int k9_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(-1.0, 9);
    final int k9_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(1.0, 9);
    final int k9_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(0.0, 9);

    final double f9_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero9(k9_m1);
    final double f9_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero9(k9_p1);
    final double f9_0a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero9(k9_0);
    final double f9_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k9_m1, 9);
    final double f9_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k9_p1, 9);
    final double f9_0b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k9_0, 9);

    System.out.printf("[9] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[9] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[9] k_0: %s\n", Integer.toString(k_0));
    System.out.printf("[9] k9_m1: %s\n", Integer.toString(k9_m1));
    System.out.printf("[9] k9_p1: %s\n", Integer.toString(k9_p1));
    System.out.printf("[9] k9_0: %s\n", Integer.toString(k9_0));
    System.out.printf("[9] f9_m1a: %f\n", f9_m1a);
    System.out.printf("[9] f9_p1a: %f\n", f9_p1a);
    System.out.printf("[9] f9_0a: %f\n", f9_0a);
    System.out.printf("[9] f9_m1b: %f\n", f9_m1b);
    System.out.printf("[9] f9_p1b: %f\n", f9_p1b);
    System.out.printf("[9] f9_0b: %f\n", f9_0b);
  }

  @Test public void testBoundsWithoutZero10()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero10(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero10(1.0);
    final int k10_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(-1.0, 10);
    final int k10_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(1.0, 10);

    final double f10_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero10(k10_m1);
    final double f10_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero10(k10_p1);
    final double f10_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k10_m1, 10);
    final double f10_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k10_p1, 10);

    System.out.printf("[10] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[10] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[10] k10_m1: %s\n", Integer.toString(k10_m1));
    System.out.printf("[10] k10_p1: %s\n", Integer.toString(k10_p1));
    System.out.printf("[10] f10_m1a: %f\n", f10_m1a);
    System.out.printf("[10] f10_p1a: %f\n", f10_p1a);
    System.out.printf("[10] f10_m1b: %f\n", f10_m1b);
    System.out.printf("[10] f10_p1b: %f\n", f10_p1b);
  }

  @Test public void testBoundsWithZero10()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero10(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero10(1.0);
    final int k_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero10(0.0);
    final int k10_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(-1.0, 10);
    final int k10_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(1.0, 10);
    final int k10_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(0.0, 10);

    final double f10_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero10(k10_m1);
    final double f10_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero10(k10_p1);
    final double f10_0a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero10(k10_0);
    final double f10_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k10_m1, 10);
    final double f10_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k10_p1, 10);
    final double f10_0b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k10_0, 10);

    System.out.printf("[10] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[10] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[10] k_0: %s\n", Integer.toString(k_0));
    System.out.printf("[10] k10_m1: %s\n", Integer.toString(k10_m1));
    System.out.printf("[10] k10_p1: %s\n", Integer.toString(k10_p1));
    System.out.printf("[10] k10_0: %s\n", Integer.toString(k10_0));
    System.out.printf("[10] f10_m1a: %f\n", f10_m1a);
    System.out.printf("[10] f10_p1a: %f\n", f10_p1a);
    System.out.printf("[10] f10_0a: %f\n", f10_0a);
    System.out.printf("[10] f10_m1b: %f\n", f10_m1b);
    System.out.printf("[10] f10_p1b: %f\n", f10_p1b);
    System.out.printf("[10] f10_0b: %f\n", f10_0b);
  }

  @Test public void testBoundsWithoutZero11()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero11(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero11(1.0);
    final int k11_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(-1.0, 11);
    final int k11_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(1.0, 11);

    final double f11_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero11(k11_m1);
    final double f11_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero11(k11_p1);
    final double f11_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k11_m1, 11);
    final double f11_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k11_p1, 11);

    System.out.printf("[11] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[11] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[11] k11_m1: %s\n", Integer.toString(k11_m1));
    System.out.printf("[11] k11_p1: %s\n", Integer.toString(k11_p1));
    System.out.printf("[11] f11_m1a: %f\n", f11_m1a);
    System.out.printf("[11] f11_p1a: %f\n", f11_p1a);
    System.out.printf("[11] f11_m1b: %f\n", f11_m1b);
    System.out.printf("[11] f11_p1b: %f\n", f11_p1b);
  }

  @Test public void testBoundsWithZero11()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero11(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero11(1.0);
    final int k_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero11(0.0);
    final int k11_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(-1.0, 11);
    final int k11_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(1.0, 11);
    final int k11_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(0.0, 11);

    final double f11_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero11(k11_m1);
    final double f11_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero11(k11_p1);
    final double f11_0a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero11(k11_0);
    final double f11_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k11_m1, 11);
    final double f11_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k11_p1, 11);
    final double f11_0b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k11_0, 11);

    System.out.printf("[11] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[11] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[11] k_0: %s\n", Integer.toString(k_0));
    System.out.printf("[11] k11_m1: %s\n", Integer.toString(k11_m1));
    System.out.printf("[11] k11_p1: %s\n", Integer.toString(k11_p1));
    System.out.printf("[11] k11_0: %s\n", Integer.toString(k11_0));
    System.out.printf("[11] f11_m1a: %f\n", f11_m1a);
    System.out.printf("[11] f11_p1a: %f\n", f11_p1a);
    System.out.printf("[11] f11_0a: %f\n", f11_0a);
    System.out.printf("[11] f11_m1b: %f\n", f11_m1b);
    System.out.printf("[11] f11_p1b: %f\n", f11_p1b);
    System.out.printf("[11] f11_0b: %f\n", f11_0b);
  }

  @Test public void testBoundsWithoutZero12()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero12(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero12(1.0);
    final int k12_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(-1.0, 12);
    final int k12_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(1.0, 12);

    final double f12_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero12(k12_m1);
    final double f12_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero12(k12_p1);
    final double f12_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k12_m1, 12);
    final double f12_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k12_p1, 12);

    System.out.printf("[12] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[12] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[12] k12_m1: %s\n", Integer.toString(k12_m1));
    System.out.printf("[12] k12_p1: %s\n", Integer.toString(k12_p1));
    System.out.printf("[12] f12_m1a: %f\n", f12_m1a);
    System.out.printf("[12] f12_p1a: %f\n", f12_p1a);
    System.out.printf("[12] f12_m1b: %f\n", f12_m1b);
    System.out.printf("[12] f12_p1b: %f\n", f12_p1b);
  }

  @Test public void testBoundsWithZero12()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero12(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero12(1.0);
    final int k_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero12(0.0);
    final int k12_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(-1.0, 12);
    final int k12_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(1.0, 12);
    final int k12_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(0.0, 12);

    final double f12_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero12(k12_m1);
    final double f12_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero12(k12_p1);
    final double f12_0a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero12(k12_0);
    final double f12_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k12_m1, 12);
    final double f12_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k12_p1, 12);
    final double f12_0b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k12_0, 12);

    System.out.printf("[12] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[12] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[12] k_0: %s\n", Integer.toString(k_0));
    System.out.printf("[12] k12_m1: %s\n", Integer.toString(k12_m1));
    System.out.printf("[12] k12_p1: %s\n", Integer.toString(k12_p1));
    System.out.printf("[12] k12_0: %s\n", Integer.toString(k12_0));
    System.out.printf("[12] f12_m1a: %f\n", f12_m1a);
    System.out.printf("[12] f12_p1a: %f\n", f12_p1a);
    System.out.printf("[12] f12_0a: %f\n", f12_0a);
    System.out.printf("[12] f12_m1b: %f\n", f12_m1b);
    System.out.printf("[12] f12_p1b: %f\n", f12_p1b);
    System.out.printf("[12] f12_0b: %f\n", f12_0b);
  }

  @Test public void testBoundsWithoutZero13()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero13(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero13(1.0);
    final int k13_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(-1.0, 13);
    final int k13_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(1.0, 13);

    final double f13_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero13(k13_m1);
    final double f13_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero13(k13_p1);
    final double f13_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k13_m1, 13);
    final double f13_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k13_p1, 13);

    System.out.printf("[13] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[13] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[13] k13_m1: %s\n", Integer.toString(k13_m1));
    System.out.printf("[13] k13_p1: %s\n", Integer.toString(k13_p1));
    System.out.printf("[13] f13_m1a: %f\n", f13_m1a);
    System.out.printf("[13] f13_p1a: %f\n", f13_p1a);
    System.out.printf("[13] f13_m1b: %f\n", f13_m1b);
    System.out.printf("[13] f13_p1b: %f\n", f13_p1b);
  }

  @Test public void testBoundsWithZero13()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero13(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero13(1.0);
    final int k_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero13(0.0);
    final int k13_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(-1.0, 13);
    final int k13_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(1.0, 13);
    final int k13_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(0.0, 13);

    final double f13_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero13(k13_m1);
    final double f13_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero13(k13_p1);
    final double f13_0a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero13(k13_0);
    final double f13_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k13_m1, 13);
    final double f13_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k13_p1, 13);
    final double f13_0b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k13_0, 13);

    System.out.printf("[13] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[13] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[13] k_0: %s\n", Integer.toString(k_0));
    System.out.printf("[13] k13_m1: %s\n", Integer.toString(k13_m1));
    System.out.printf("[13] k13_p1: %s\n", Integer.toString(k13_p1));
    System.out.printf("[13] k13_0: %s\n", Integer.toString(k13_0));
    System.out.printf("[13] f13_m1a: %f\n", f13_m1a);
    System.out.printf("[13] f13_p1a: %f\n", f13_p1a);
    System.out.printf("[13] f13_0a: %f\n", f13_0a);
    System.out.printf("[13] f13_m1b: %f\n", f13_m1b);
    System.out.printf("[13] f13_p1b: %f\n", f13_p1b);
    System.out.printf("[13] f13_0b: %f\n", f13_0b);
  }

  @Test public void testBoundsWithoutZero14()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero14(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero14(1.0);
    final int k14_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(-1.0, 14);
    final int k14_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(1.0, 14);

    final double f14_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero14(k14_m1);
    final double f14_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero14(k14_p1);
    final double f14_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k14_m1, 14);
    final double f14_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k14_p1, 14);

    System.out.printf("[14] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[14] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[14] k14_m1: %s\n", Integer.toString(k14_m1));
    System.out.printf("[14] k14_p1: %s\n", Integer.toString(k14_p1));
    System.out.printf("[14] f14_m1a: %f\n", f14_m1a);
    System.out.printf("[14] f14_p1a: %f\n", f14_p1a);
    System.out.printf("[14] f14_m1b: %f\n", f14_m1b);
    System.out.printf("[14] f14_p1b: %f\n", f14_p1b);
  }

  @Test public void testBoundsWithZero14()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero14(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero14(1.0);
    final int k_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero14(0.0);
    final int k14_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(-1.0, 14);
    final int k14_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(1.0, 14);
    final int k14_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(0.0, 14);

    final double f14_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero14(k14_m1);
    final double f14_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero14(k14_p1);
    final double f14_0a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero14(k14_0);
    final double f14_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k14_m1, 14);
    final double f14_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k14_p1, 14);
    final double f14_0b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k14_0, 14);

    System.out.printf("[14] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[14] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[14] k_0: %s\n", Integer.toString(k_0));
    System.out.printf("[14] k14_m1: %s\n", Integer.toString(k14_m1));
    System.out.printf("[14] k14_p1: %s\n", Integer.toString(k14_p1));
    System.out.printf("[14] k14_0: %s\n", Integer.toString(k14_0));
    System.out.printf("[14] f14_m1a: %f\n", f14_m1a);
    System.out.printf("[14] f14_p1a: %f\n", f14_p1a);
    System.out.printf("[14] f14_0a: %f\n", f14_0a);
    System.out.printf("[14] f14_m1b: %f\n", f14_m1b);
    System.out.printf("[14] f14_p1b: %f\n", f14_p1b);
    System.out.printf("[14] f14_0b: %f\n", f14_0b);
  }

  @Test public void testBoundsWithoutZero15()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero15(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero15(1.0);
    final int k15_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(-1.0, 15);
    final int k15_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(1.0, 15);

    final double f15_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero15(k15_m1);
    final double f15_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero15(k15_p1);
    final double f15_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k15_m1, 15);
    final double f15_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k15_p1, 15);

    System.out.printf("[15] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[15] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[15] k15_m1: %s\n", Integer.toString(k15_m1));
    System.out.printf("[15] k15_p1: %s\n", Integer.toString(k15_p1));
    System.out.printf("[15] f15_m1a: %f\n", f15_m1a);
    System.out.printf("[15] f15_p1a: %f\n", f15_p1a);
    System.out.printf("[15] f15_m1b: %f\n", f15_m1b);
    System.out.printf("[15] f15_p1b: %f\n", f15_p1b);
  }

  @Test public void testBoundsWithZero15()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero15(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero15(1.0);
    final int k_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero15(0.0);
    final int k15_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(-1.0, 15);
    final int k15_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(1.0, 15);
    final int k15_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(0.0, 15);

    final double f15_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero15(k15_m1);
    final double f15_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero15(k15_p1);
    final double f15_0a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero15(k15_0);
    final double f15_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k15_m1, 15);
    final double f15_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k15_p1, 15);
    final double f15_0b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k15_0, 15);

    System.out.printf("[15] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[15] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[15] k_0: %s\n", Integer.toString(k_0));
    System.out.printf("[15] k15_m1: %s\n", Integer.toString(k15_m1));
    System.out.printf("[15] k15_p1: %s\n", Integer.toString(k15_p1));
    System.out.printf("[15] k15_0: %s\n", Integer.toString(k15_0));
    System.out.printf("[15] f15_m1a: %f\n", f15_m1a);
    System.out.printf("[15] f15_p1a: %f\n", f15_p1a);
    System.out.printf("[15] f15_0a: %f\n", f15_0a);
    System.out.printf("[15] f15_m1b: %f\n", f15_m1b);
    System.out.printf("[15] f15_p1b: %f\n", f15_p1b);
    System.out.printf("[15] f15_0b: %f\n", f15_0b);
  }

  @Test public void testBoundsWithoutZero16()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero16(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero16(1.0);
    final int k16_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(-1.0, 16);
    final int k16_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(1.0, 16);

    final double f16_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero16(k16_m1);
    final double f16_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero16(k16_p1);
    final double f16_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k16_m1, 16);
    final double f16_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k16_p1, 16);

    System.out.printf("[16] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[16] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[16] k16_m1: %s\n", Integer.toString(k16_m1));
    System.out.printf("[16] k16_p1: %s\n", Integer.toString(k16_p1));
    System.out.printf("[16] f16_m1a: %f\n", f16_m1a);
    System.out.printf("[16] f16_p1a: %f\n", f16_p1a);
    System.out.printf("[16] f16_m1b: %f\n", f16_m1b);
    System.out.printf("[16] f16_p1b: %f\n", f16_p1b);
  }

  @Test public void testBoundsWithZero16()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero16(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero16(1.0);
    final int k_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero16(0.0);
    final int k16_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(-1.0, 16);
    final int k16_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(1.0, 16);
    final int k16_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(0.0, 16);

    final double f16_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero16(k16_m1);
    final double f16_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero16(k16_p1);
    final double f16_0a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero16(k16_0);
    final double f16_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k16_m1, 16);
    final double f16_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k16_p1, 16);
    final double f16_0b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k16_0, 16);

    System.out.printf("[16] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[16] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[16] k_0: %s\n", Integer.toString(k_0));
    System.out.printf("[16] k16_m1: %s\n", Integer.toString(k16_m1));
    System.out.printf("[16] k16_p1: %s\n", Integer.toString(k16_p1));
    System.out.printf("[16] k16_0: %s\n", Integer.toString(k16_0));
    System.out.printf("[16] f16_m1a: %f\n", f16_m1a);
    System.out.printf("[16] f16_p1a: %f\n", f16_p1a);
    System.out.printf("[16] f16_0a: %f\n", f16_0a);
    System.out.printf("[16] f16_m1b: %f\n", f16_m1b);
    System.out.printf("[16] f16_p1b: %f\n", f16_p1b);
    System.out.printf("[16] f16_0b: %f\n", f16_0b);
  }

  @Test public void testBoundsWithoutZero17()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero17(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero17(1.0);
    final int k17_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(-1.0, 17);
    final int k17_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(1.0, 17);

    final double f17_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero17(k17_m1);
    final double f17_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero17(k17_p1);
    final double f17_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k17_m1, 17);
    final double f17_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k17_p1, 17);

    System.out.printf("[17] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[17] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[17] k17_m1: %s\n", Integer.toString(k17_m1));
    System.out.printf("[17] k17_p1: %s\n", Integer.toString(k17_p1));
    System.out.printf("[17] f17_m1a: %f\n", f17_m1a);
    System.out.printf("[17] f17_p1a: %f\n", f17_p1a);
    System.out.printf("[17] f17_m1b: %f\n", f17_m1b);
    System.out.printf("[17] f17_p1b: %f\n", f17_p1b);
  }

  @Test public void testBoundsWithZero17()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero17(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero17(1.0);
    final int k_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero17(0.0);
    final int k17_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(-1.0, 17);
    final int k17_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(1.0, 17);
    final int k17_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(0.0, 17);

    final double f17_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero17(k17_m1);
    final double f17_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero17(k17_p1);
    final double f17_0a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero17(k17_0);
    final double f17_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k17_m1, 17);
    final double f17_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k17_p1, 17);
    final double f17_0b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k17_0, 17);

    System.out.printf("[17] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[17] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[17] k_0: %s\n", Integer.toString(k_0));
    System.out.printf("[17] k17_m1: %s\n", Integer.toString(k17_m1));
    System.out.printf("[17] k17_p1: %s\n", Integer.toString(k17_p1));
    System.out.printf("[17] k17_0: %s\n", Integer.toString(k17_0));
    System.out.printf("[17] f17_m1a: %f\n", f17_m1a);
    System.out.printf("[17] f17_p1a: %f\n", f17_p1a);
    System.out.printf("[17] f17_0a: %f\n", f17_0a);
    System.out.printf("[17] f17_m1b: %f\n", f17_m1b);
    System.out.printf("[17] f17_p1b: %f\n", f17_p1b);
    System.out.printf("[17] f17_0b: %f\n", f17_0b);
  }

  @Test public void testBoundsWithoutZero18()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero18(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero18(1.0);
    final int k18_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(-1.0, 18);
    final int k18_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(1.0, 18);

    final double f18_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero18(k18_m1);
    final double f18_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero18(k18_p1);
    final double f18_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k18_m1, 18);
    final double f18_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k18_p1, 18);

    System.out.printf("[18] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[18] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[18] k18_m1: %s\n", Integer.toString(k18_m1));
    System.out.printf("[18] k18_p1: %s\n", Integer.toString(k18_p1));
    System.out.printf("[18] f18_m1a: %f\n", f18_m1a);
    System.out.printf("[18] f18_p1a: %f\n", f18_p1a);
    System.out.printf("[18] f18_m1b: %f\n", f18_m1b);
    System.out.printf("[18] f18_p1b: %f\n", f18_p1b);
  }

  @Test public void testBoundsWithZero18()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero18(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero18(1.0);
    final int k_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero18(0.0);
    final int k18_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(-1.0, 18);
    final int k18_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(1.0, 18);
    final int k18_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(0.0, 18);

    final double f18_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero18(k18_m1);
    final double f18_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero18(k18_p1);
    final double f18_0a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero18(k18_0);
    final double f18_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k18_m1, 18);
    final double f18_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k18_p1, 18);
    final double f18_0b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k18_0, 18);

    System.out.printf("[18] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[18] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[18] k_0: %s\n", Integer.toString(k_0));
    System.out.printf("[18] k18_m1: %s\n", Integer.toString(k18_m1));
    System.out.printf("[18] k18_p1: %s\n", Integer.toString(k18_p1));
    System.out.printf("[18] k18_0: %s\n", Integer.toString(k18_0));
    System.out.printf("[18] f18_m1a: %f\n", f18_m1a);
    System.out.printf("[18] f18_p1a: %f\n", f18_p1a);
    System.out.printf("[18] f18_0a: %f\n", f18_0a);
    System.out.printf("[18] f18_m1b: %f\n", f18_m1b);
    System.out.printf("[18] f18_p1b: %f\n", f18_p1b);
    System.out.printf("[18] f18_0b: %f\n", f18_0b);
  }

  @Test public void testBoundsWithoutZero19()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero19(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero19(1.0);
    final int k19_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(-1.0, 19);
    final int k19_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(1.0, 19);

    final double f19_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero19(k19_m1);
    final double f19_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero19(k19_p1);
    final double f19_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k19_m1, 19);
    final double f19_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k19_p1, 19);

    System.out.printf("[19] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[19] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[19] k19_m1: %s\n", Integer.toString(k19_m1));
    System.out.printf("[19] k19_p1: %s\n", Integer.toString(k19_p1));
    System.out.printf("[19] f19_m1a: %f\n", f19_m1a);
    System.out.printf("[19] f19_p1a: %f\n", f19_p1a);
    System.out.printf("[19] f19_m1b: %f\n", f19_m1b);
    System.out.printf("[19] f19_p1b: %f\n", f19_p1b);
  }

  @Test public void testBoundsWithZero19()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero19(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero19(1.0);
    final int k_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero19(0.0);
    final int k19_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(-1.0, 19);
    final int k19_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(1.0, 19);
    final int k19_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(0.0, 19);

    final double f19_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero19(k19_m1);
    final double f19_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero19(k19_p1);
    final double f19_0a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero19(k19_0);
    final double f19_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k19_m1, 19);
    final double f19_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k19_p1, 19);
    final double f19_0b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k19_0, 19);

    System.out.printf("[19] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[19] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[19] k_0: %s\n", Integer.toString(k_0));
    System.out.printf("[19] k19_m1: %s\n", Integer.toString(k19_m1));
    System.out.printf("[19] k19_p1: %s\n", Integer.toString(k19_p1));
    System.out.printf("[19] k19_0: %s\n", Integer.toString(k19_0));
    System.out.printf("[19] f19_m1a: %f\n", f19_m1a);
    System.out.printf("[19] f19_p1a: %f\n", f19_p1a);
    System.out.printf("[19] f19_0a: %f\n", f19_0a);
    System.out.printf("[19] f19_m1b: %f\n", f19_m1b);
    System.out.printf("[19] f19_p1b: %f\n", f19_p1b);
    System.out.printf("[19] f19_0b: %f\n", f19_0b);
  }

  @Test public void testBoundsWithoutZero20()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero20(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero20(1.0);
    final int k20_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(-1.0, 20);
    final int k20_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(1.0, 20);

    final double f20_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero20(k20_m1);
    final double f20_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero20(k20_p1);
    final double f20_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k20_m1, 20);
    final double f20_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k20_p1, 20);

    System.out.printf("[20] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[20] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[20] k20_m1: %s\n", Integer.toString(k20_m1));
    System.out.printf("[20] k20_p1: %s\n", Integer.toString(k20_p1));
    System.out.printf("[20] f20_m1a: %f\n", f20_m1a);
    System.out.printf("[20] f20_p1a: %f\n", f20_p1a);
    System.out.printf("[20] f20_m1b: %f\n", f20_m1b);
    System.out.printf("[20] f20_p1b: %f\n", f20_p1b);
  }

  @Test public void testBoundsWithZero20()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero20(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero20(1.0);
    final int k_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero20(0.0);
    final int k20_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(-1.0, 20);
    final int k20_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(1.0, 20);
    final int k20_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(0.0, 20);

    final double f20_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero20(k20_m1);
    final double f20_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero20(k20_p1);
    final double f20_0a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero20(k20_0);
    final double f20_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k20_m1, 20);
    final double f20_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k20_p1, 20);
    final double f20_0b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k20_0, 20);

    System.out.printf("[20] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[20] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[20] k_0: %s\n", Integer.toString(k_0));
    System.out.printf("[20] k20_m1: %s\n", Integer.toString(k20_m1));
    System.out.printf("[20] k20_p1: %s\n", Integer.toString(k20_p1));
    System.out.printf("[20] k20_0: %s\n", Integer.toString(k20_0));
    System.out.printf("[20] f20_m1a: %f\n", f20_m1a);
    System.out.printf("[20] f20_p1a: %f\n", f20_p1a);
    System.out.printf("[20] f20_0a: %f\n", f20_0a);
    System.out.printf("[20] f20_m1b: %f\n", f20_m1b);
    System.out.printf("[20] f20_p1b: %f\n", f20_p1b);
    System.out.printf("[20] f20_0b: %f\n", f20_0b);
  }

  @Test public void testBoundsWithoutZero21()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero21(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero21(1.0);
    final int k21_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(-1.0, 21);
    final int k21_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(1.0, 21);

    final double f21_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero21(k21_m1);
    final double f21_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero21(k21_p1);
    final double f21_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k21_m1, 21);
    final double f21_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k21_p1, 21);

    System.out.printf("[21] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[21] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[21] k21_m1: %s\n", Integer.toString(k21_m1));
    System.out.printf("[21] k21_p1: %s\n", Integer.toString(k21_p1));
    System.out.printf("[21] f21_m1a: %f\n", f21_m1a);
    System.out.printf("[21] f21_p1a: %f\n", f21_p1a);
    System.out.printf("[21] f21_m1b: %f\n", f21_m1b);
    System.out.printf("[21] f21_p1b: %f\n", f21_p1b);
  }

  @Test public void testBoundsWithZero21()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero21(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero21(1.0);
    final int k_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero21(0.0);
    final int k21_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(-1.0, 21);
    final int k21_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(1.0, 21);
    final int k21_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(0.0, 21);

    final double f21_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero21(k21_m1);
    final double f21_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero21(k21_p1);
    final double f21_0a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero21(k21_0);
    final double f21_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k21_m1, 21);
    final double f21_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k21_p1, 21);
    final double f21_0b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k21_0, 21);

    System.out.printf("[21] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[21] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[21] k_0: %s\n", Integer.toString(k_0));
    System.out.printf("[21] k21_m1: %s\n", Integer.toString(k21_m1));
    System.out.printf("[21] k21_p1: %s\n", Integer.toString(k21_p1));
    System.out.printf("[21] k21_0: %s\n", Integer.toString(k21_0));
    System.out.printf("[21] f21_m1a: %f\n", f21_m1a);
    System.out.printf("[21] f21_p1a: %f\n", f21_p1a);
    System.out.printf("[21] f21_0a: %f\n", f21_0a);
    System.out.printf("[21] f21_m1b: %f\n", f21_m1b);
    System.out.printf("[21] f21_p1b: %f\n", f21_p1b);
    System.out.printf("[21] f21_0b: %f\n", f21_0b);
  }

  @Test public void testBoundsWithoutZero22()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero22(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero22(1.0);
    final int k22_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(-1.0, 22);
    final int k22_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(1.0, 22);

    final double f22_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero22(k22_m1);
    final double f22_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero22(k22_p1);
    final double f22_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k22_m1, 22);
    final double f22_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k22_p1, 22);

    System.out.printf("[22] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[22] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[22] k22_m1: %s\n", Integer.toString(k22_m1));
    System.out.printf("[22] k22_p1: %s\n", Integer.toString(k22_p1));
    System.out.printf("[22] f22_m1a: %f\n", f22_m1a);
    System.out.printf("[22] f22_p1a: %f\n", f22_p1a);
    System.out.printf("[22] f22_m1b: %f\n", f22_m1b);
    System.out.printf("[22] f22_p1b: %f\n", f22_p1b);
  }

  @Test public void testBoundsWithZero22()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero22(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero22(1.0);
    final int k_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero22(0.0);
    final int k22_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(-1.0, 22);
    final int k22_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(1.0, 22);
    final int k22_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(0.0, 22);

    final double f22_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero22(k22_m1);
    final double f22_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero22(k22_p1);
    final double f22_0a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero22(k22_0);
    final double f22_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k22_m1, 22);
    final double f22_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k22_p1, 22);
    final double f22_0b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k22_0, 22);

    System.out.printf("[22] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[22] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[22] k_0: %s\n", Integer.toString(k_0));
    System.out.printf("[22] k22_m1: %s\n", Integer.toString(k22_m1));
    System.out.printf("[22] k22_p1: %s\n", Integer.toString(k22_p1));
    System.out.printf("[22] k22_0: %s\n", Integer.toString(k22_0));
    System.out.printf("[22] f22_m1a: %f\n", f22_m1a);
    System.out.printf("[22] f22_p1a: %f\n", f22_p1a);
    System.out.printf("[22] f22_0a: %f\n", f22_0a);
    System.out.printf("[22] f22_m1b: %f\n", f22_m1b);
    System.out.printf("[22] f22_p1b: %f\n", f22_p1b);
    System.out.printf("[22] f22_0b: %f\n", f22_0b);
  }

  @Test public void testBoundsWithoutZero23()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero23(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero23(1.0);
    final int k23_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(-1.0, 23);
    final int k23_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(1.0, 23);

    final double f23_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero23(k23_m1);
    final double f23_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero23(k23_p1);
    final double f23_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k23_m1, 23);
    final double f23_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k23_p1, 23);

    System.out.printf("[23] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[23] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[23] k23_m1: %s\n", Integer.toString(k23_m1));
    System.out.printf("[23] k23_p1: %s\n", Integer.toString(k23_p1));
    System.out.printf("[23] f23_m1a: %f\n", f23_m1a);
    System.out.printf("[23] f23_p1a: %f\n", f23_p1a);
    System.out.printf("[23] f23_m1b: %f\n", f23_m1b);
    System.out.printf("[23] f23_p1b: %f\n", f23_p1b);
  }

  @Test public void testBoundsWithZero23()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero23(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero23(1.0);
    final int k_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero23(0.0);
    final int k23_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(-1.0, 23);
    final int k23_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(1.0, 23);
    final int k23_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(0.0, 23);

    final double f23_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero23(k23_m1);
    final double f23_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero23(k23_p1);
    final double f23_0a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero23(k23_0);
    final double f23_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k23_m1, 23);
    final double f23_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k23_p1, 23);
    final double f23_0b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k23_0, 23);

    System.out.printf("[23] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[23] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[23] k_0: %s\n", Integer.toString(k_0));
    System.out.printf("[23] k23_m1: %s\n", Integer.toString(k23_m1));
    System.out.printf("[23] k23_p1: %s\n", Integer.toString(k23_p1));
    System.out.printf("[23] k23_0: %s\n", Integer.toString(k23_0));
    System.out.printf("[23] f23_m1a: %f\n", f23_m1a);
    System.out.printf("[23] f23_p1a: %f\n", f23_p1a);
    System.out.printf("[23] f23_0a: %f\n", f23_0a);
    System.out.printf("[23] f23_m1b: %f\n", f23_m1b);
    System.out.printf("[23] f23_p1b: %f\n", f23_p1b);
    System.out.printf("[23] f23_0b: %f\n", f23_0b);
  }

  @Test public void testBoundsWithoutZero24()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero24(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero24(1.0);
    final int k24_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(-1.0, 24);
    final int k24_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(1.0, 24);

    final double f24_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero24(k24_m1);
    final double f24_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero24(k24_p1);
    final double f24_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k24_m1, 24);
    final double f24_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k24_p1, 24);

    System.out.printf("[24] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[24] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[24] k24_m1: %s\n", Integer.toString(k24_m1));
    System.out.printf("[24] k24_p1: %s\n", Integer.toString(k24_p1));
    System.out.printf("[24] f24_m1a: %f\n", f24_m1a);
    System.out.printf("[24] f24_p1a: %f\n", f24_p1a);
    System.out.printf("[24] f24_m1b: %f\n", f24_m1b);
    System.out.printf("[24] f24_p1b: %f\n", f24_p1b);
  }

  @Test public void testBoundsWithZero24()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero24(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero24(1.0);
    final int k_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero24(0.0);
    final int k24_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(-1.0, 24);
    final int k24_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(1.0, 24);
    final int k24_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(0.0, 24);

    final double f24_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero24(k24_m1);
    final double f24_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero24(k24_p1);
    final double f24_0a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero24(k24_0);
    final double f24_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k24_m1, 24);
    final double f24_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k24_p1, 24);
    final double f24_0b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k24_0, 24);

    System.out.printf("[24] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[24] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[24] k_0: %s\n", Integer.toString(k_0));
    System.out.printf("[24] k24_m1: %s\n", Integer.toString(k24_m1));
    System.out.printf("[24] k24_p1: %s\n", Integer.toString(k24_p1));
    System.out.printf("[24] k24_0: %s\n", Integer.toString(k24_0));
    System.out.printf("[24] f24_m1a: %f\n", f24_m1a);
    System.out.printf("[24] f24_p1a: %f\n", f24_p1a);
    System.out.printf("[24] f24_0a: %f\n", f24_0a);
    System.out.printf("[24] f24_m1b: %f\n", f24_m1b);
    System.out.printf("[24] f24_p1b: %f\n", f24_p1b);
    System.out.printf("[24] f24_0b: %f\n", f24_0b);
  }

  @Test public void testBoundsWithoutZero25()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero25(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero25(1.0);
    final int k25_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(-1.0, 25);
    final int k25_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(1.0, 25);

    final double f25_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero25(k25_m1);
    final double f25_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero25(k25_p1);
    final double f25_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k25_m1, 25);
    final double f25_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k25_p1, 25);

    System.out.printf("[25] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[25] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[25] k25_m1: %s\n", Integer.toString(k25_m1));
    System.out.printf("[25] k25_p1: %s\n", Integer.toString(k25_p1));
    System.out.printf("[25] f25_m1a: %f\n", f25_m1a);
    System.out.printf("[25] f25_p1a: %f\n", f25_p1a);
    System.out.printf("[25] f25_m1b: %f\n", f25_m1b);
    System.out.printf("[25] f25_p1b: %f\n", f25_p1b);
  }

  @Test public void testBoundsWithZero25()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero25(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero25(1.0);
    final int k_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero25(0.0);
    final int k25_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(-1.0, 25);
    final int k25_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(1.0, 25);
    final int k25_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(0.0, 25);

    final double f25_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero25(k25_m1);
    final double f25_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero25(k25_p1);
    final double f25_0a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero25(k25_0);
    final double f25_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k25_m1, 25);
    final double f25_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k25_p1, 25);
    final double f25_0b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k25_0, 25);

    System.out.printf("[25] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[25] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[25] k_0: %s\n", Integer.toString(k_0));
    System.out.printf("[25] k25_m1: %s\n", Integer.toString(k25_m1));
    System.out.printf("[25] k25_p1: %s\n", Integer.toString(k25_p1));
    System.out.printf("[25] k25_0: %s\n", Integer.toString(k25_0));
    System.out.printf("[25] f25_m1a: %f\n", f25_m1a);
    System.out.printf("[25] f25_p1a: %f\n", f25_p1a);
    System.out.printf("[25] f25_0a: %f\n", f25_0a);
    System.out.printf("[25] f25_m1b: %f\n", f25_m1b);
    System.out.printf("[25] f25_p1b: %f\n", f25_p1b);
    System.out.printf("[25] f25_0b: %f\n", f25_0b);
  }

  @Test public void testBoundsWithoutZero26()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero26(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero26(1.0);
    final int k26_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(-1.0, 26);
    final int k26_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(1.0, 26);

    final double f26_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero26(k26_m1);
    final double f26_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero26(k26_p1);
    final double f26_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k26_m1, 26);
    final double f26_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k26_p1, 26);

    System.out.printf("[26] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[26] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[26] k26_m1: %s\n", Integer.toString(k26_m1));
    System.out.printf("[26] k26_p1: %s\n", Integer.toString(k26_p1));
    System.out.printf("[26] f26_m1a: %f\n", f26_m1a);
    System.out.printf("[26] f26_p1a: %f\n", f26_p1a);
    System.out.printf("[26] f26_m1b: %f\n", f26_m1b);
    System.out.printf("[26] f26_p1b: %f\n", f26_p1b);
  }

  @Test public void testBoundsWithZero26()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero26(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero26(1.0);
    final int k_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero26(0.0);
    final int k26_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(-1.0, 26);
    final int k26_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(1.0, 26);
    final int k26_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(0.0, 26);

    final double f26_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero26(k26_m1);
    final double f26_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero26(k26_p1);
    final double f26_0a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero26(k26_0);
    final double f26_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k26_m1, 26);
    final double f26_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k26_p1, 26);
    final double f26_0b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k26_0, 26);

    System.out.printf("[26] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[26] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[26] k_0: %s\n", Integer.toString(k_0));
    System.out.printf("[26] k26_m1: %s\n", Integer.toString(k26_m1));
    System.out.printf("[26] k26_p1: %s\n", Integer.toString(k26_p1));
    System.out.printf("[26] k26_0: %s\n", Integer.toString(k26_0));
    System.out.printf("[26] f26_m1a: %f\n", f26_m1a);
    System.out.printf("[26] f26_p1a: %f\n", f26_p1a);
    System.out.printf("[26] f26_0a: %f\n", f26_0a);
    System.out.printf("[26] f26_m1b: %f\n", f26_m1b);
    System.out.printf("[26] f26_p1b: %f\n", f26_p1b);
    System.out.printf("[26] f26_0b: %f\n", f26_0b);
  }

  @Test public void testBoundsWithoutZero27()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero27(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero27(1.0);
    final int k27_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(-1.0, 27);
    final int k27_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(1.0, 27);

    final double f27_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero27(k27_m1);
    final double f27_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero27(k27_p1);
    final double f27_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k27_m1, 27);
    final double f27_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k27_p1, 27);

    System.out.printf("[27] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[27] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[27] k27_m1: %s\n", Integer.toString(k27_m1));
    System.out.printf("[27] k27_p1: %s\n", Integer.toString(k27_p1));
    System.out.printf("[27] f27_m1a: %f\n", f27_m1a);
    System.out.printf("[27] f27_p1a: %f\n", f27_p1a);
    System.out.printf("[27] f27_m1b: %f\n", f27_m1b);
    System.out.printf("[27] f27_p1b: %f\n", f27_p1b);
  }

  @Test public void testBoundsWithZero27()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero27(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero27(1.0);
    final int k_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero27(0.0);
    final int k27_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(-1.0, 27);
    final int k27_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(1.0, 27);
    final int k27_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(0.0, 27);

    final double f27_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero27(k27_m1);
    final double f27_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero27(k27_p1);
    final double f27_0a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero27(k27_0);
    final double f27_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k27_m1, 27);
    final double f27_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k27_p1, 27);
    final double f27_0b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k27_0, 27);

    System.out.printf("[27] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[27] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[27] k_0: %s\n", Integer.toString(k_0));
    System.out.printf("[27] k27_m1: %s\n", Integer.toString(k27_m1));
    System.out.printf("[27] k27_p1: %s\n", Integer.toString(k27_p1));
    System.out.printf("[27] k27_0: %s\n", Integer.toString(k27_0));
    System.out.printf("[27] f27_m1a: %f\n", f27_m1a);
    System.out.printf("[27] f27_p1a: %f\n", f27_p1a);
    System.out.printf("[27] f27_0a: %f\n", f27_0a);
    System.out.printf("[27] f27_m1b: %f\n", f27_m1b);
    System.out.printf("[27] f27_p1b: %f\n", f27_p1b);
    System.out.printf("[27] f27_0b: %f\n", f27_0b);
  }

  @Test public void testBoundsWithoutZero28()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero28(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero28(1.0);
    final int k28_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(-1.0, 28);
    final int k28_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(1.0, 28);

    final double f28_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero28(k28_m1);
    final double f28_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero28(k28_p1);
    final double f28_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k28_m1, 28);
    final double f28_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k28_p1, 28);

    System.out.printf("[28] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[28] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[28] k28_m1: %s\n", Integer.toString(k28_m1));
    System.out.printf("[28] k28_p1: %s\n", Integer.toString(k28_p1));
    System.out.printf("[28] f28_m1a: %f\n", f28_m1a);
    System.out.printf("[28] f28_p1a: %f\n", f28_p1a);
    System.out.printf("[28] f28_m1b: %f\n", f28_m1b);
    System.out.printf("[28] f28_p1b: %f\n", f28_p1b);
  }

  @Test public void testBoundsWithZero28()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero28(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero28(1.0);
    final int k_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero28(0.0);
    final int k28_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(-1.0, 28);
    final int k28_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(1.0, 28);
    final int k28_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(0.0, 28);

    final double f28_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero28(k28_m1);
    final double f28_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero28(k28_p1);
    final double f28_0a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero28(k28_0);
    final double f28_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k28_m1, 28);
    final double f28_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k28_p1, 28);
    final double f28_0b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k28_0, 28);

    System.out.printf("[28] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[28] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[28] k_0: %s\n", Integer.toString(k_0));
    System.out.printf("[28] k28_m1: %s\n", Integer.toString(k28_m1));
    System.out.printf("[28] k28_p1: %s\n", Integer.toString(k28_p1));
    System.out.printf("[28] k28_0: %s\n", Integer.toString(k28_0));
    System.out.printf("[28] f28_m1a: %f\n", f28_m1a);
    System.out.printf("[28] f28_p1a: %f\n", f28_p1a);
    System.out.printf("[28] f28_0a: %f\n", f28_0a);
    System.out.printf("[28] f28_m1b: %f\n", f28_m1b);
    System.out.printf("[28] f28_p1b: %f\n", f28_p1b);
    System.out.printf("[28] f28_0b: %f\n", f28_0b);
  }

  @Test public void testBoundsWithoutZero29()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero29(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero29(1.0);
    final int k29_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(-1.0, 29);
    final int k29_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(1.0, 29);

    final double f29_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero29(k29_m1);
    final double f29_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero29(k29_p1);
    final double f29_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k29_m1, 29);
    final double f29_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k29_p1, 29);

    System.out.printf("[29] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[29] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[29] k29_m1: %s\n", Integer.toString(k29_m1));
    System.out.printf("[29] k29_p1: %s\n", Integer.toString(k29_p1));
    System.out.printf("[29] f29_m1a: %f\n", f29_m1a);
    System.out.printf("[29] f29_p1a: %f\n", f29_p1a);
    System.out.printf("[29] f29_m1b: %f\n", f29_m1b);
    System.out.printf("[29] f29_p1b: %f\n", f29_p1b);
  }

  @Test public void testBoundsWithZero29()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero29(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero29(1.0);
    final int k_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero29(0.0);
    final int k29_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(-1.0, 29);
    final int k29_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(1.0, 29);
    final int k29_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(0.0, 29);

    final double f29_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero29(k29_m1);
    final double f29_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero29(k29_p1);
    final double f29_0a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero29(k29_0);
    final double f29_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k29_m1, 29);
    final double f29_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k29_p1, 29);
    final double f29_0b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k29_0, 29);

    System.out.printf("[29] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[29] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[29] k_0: %s\n", Integer.toString(k_0));
    System.out.printf("[29] k29_m1: %s\n", Integer.toString(k29_m1));
    System.out.printf("[29] k29_p1: %s\n", Integer.toString(k29_p1));
    System.out.printf("[29] k29_0: %s\n", Integer.toString(k29_0));
    System.out.printf("[29] f29_m1a: %f\n", f29_m1a);
    System.out.printf("[29] f29_p1a: %f\n", f29_p1a);
    System.out.printf("[29] f29_0a: %f\n", f29_0a);
    System.out.printf("[29] f29_m1b: %f\n", f29_m1b);
    System.out.printf("[29] f29_p1b: %f\n", f29_p1b);
    System.out.printf("[29] f29_0b: %f\n", f29_0b);
  }

  @Test public void testBoundsWithoutZero30()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero30(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero30(1.0);
    final int k30_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(-1.0, 30);
    final int k30_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(1.0, 30);

    final double f30_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero30(k30_m1);
    final double f30_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero30(k30_p1);
    final double f30_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k30_m1, 30);
    final double f30_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k30_p1, 30);

    System.out.printf("[30] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[30] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[30] k30_m1: %s\n", Integer.toString(k30_m1));
    System.out.printf("[30] k30_p1: %s\n", Integer.toString(k30_p1));
    System.out.printf("[30] f30_m1a: %f\n", f30_m1a);
    System.out.printf("[30] f30_p1a: %f\n", f30_p1a);
    System.out.printf("[30] f30_m1b: %f\n", f30_m1b);
    System.out.printf("[30] f30_p1b: %f\n", f30_p1b);
  }

  @Test public void testBoundsWithZero30()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero30(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero30(1.0);
    final int k_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero30(0.0);
    final int k30_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(-1.0, 30);
    final int k30_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(1.0, 30);
    final int k30_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(0.0, 30);

    final double f30_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero30(k30_m1);
    final double f30_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero30(k30_p1);
    final double f30_0a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero30(k30_0);
    final double f30_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k30_m1, 30);
    final double f30_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k30_p1, 30);
    final double f30_0b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k30_0, 30);

    System.out.printf("[30] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[30] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[30] k_0: %s\n", Integer.toString(k_0));
    System.out.printf("[30] k30_m1: %s\n", Integer.toString(k30_m1));
    System.out.printf("[30] k30_p1: %s\n", Integer.toString(k30_p1));
    System.out.printf("[30] k30_0: %s\n", Integer.toString(k30_0));
    System.out.printf("[30] f30_m1a: %f\n", f30_m1a);
    System.out.printf("[30] f30_p1a: %f\n", f30_p1a);
    System.out.printf("[30] f30_0a: %f\n", f30_0a);
    System.out.printf("[30] f30_m1b: %f\n", f30_m1b);
    System.out.printf("[30] f30_p1b: %f\n", f30_p1b);
    System.out.printf("[30] f30_0b: %f\n", f30_0b);
  }

  @Test public void testBoundsWithoutZero31()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero31(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero31(1.0);
    final int k31_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(-1.0, 31);
    final int k31_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(1.0, 31);

    final double f31_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero31(k31_m1);
    final double f31_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero31(k31_p1);
    final double f31_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k31_m1, 31);
    final double f31_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k31_p1, 31);

    System.out.printf("[31] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[31] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[31] k31_m1: %s\n", Integer.toString(k31_m1));
    System.out.printf("[31] k31_p1: %s\n", Integer.toString(k31_p1));
    System.out.printf("[31] f31_m1a: %f\n", f31_m1a);
    System.out.printf("[31] f31_p1a: %f\n", f31_p1a);
    System.out.printf("[31] f31_m1b: %f\n", f31_m1b);
    System.out.printf("[31] f31_p1b: %f\n", f31_p1b);
  }

  @Test public void testBoundsWithZero31()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero31(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero31(1.0);
    final int k_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero31(0.0);
    final int k31_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(-1.0, 31);
    final int k31_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(1.0, 31);
    final int k31_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(0.0, 31);

    final double f31_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero31(k31_m1);
    final double f31_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero31(k31_p1);
    final double f31_0a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero31(k31_0);
    final double f31_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k31_m1, 31);
    final double f31_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k31_p1, 31);
    final double f31_0b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k31_0, 31);

    System.out.printf("[31] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[31] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[31] k_0: %s\n", Integer.toString(k_0));
    System.out.printf("[31] k31_m1: %s\n", Integer.toString(k31_m1));
    System.out.printf("[31] k31_p1: %s\n", Integer.toString(k31_p1));
    System.out.printf("[31] k31_0: %s\n", Integer.toString(k31_0));
    System.out.printf("[31] f31_m1a: %f\n", f31_m1a);
    System.out.printf("[31] f31_p1a: %f\n", f31_p1a);
    System.out.printf("[31] f31_0a: %f\n", f31_0a);
    System.out.printf("[31] f31_m1b: %f\n", f31_m1b);
    System.out.printf("[31] f31_p1b: %f\n", f31_p1b);
    System.out.printf("[31] f31_0b: %f\n", f31_0b);
  }

  @Test public void testBoundsWithoutZero32()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero32(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero32(1.0);
    final int k32_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(-1.0, 32);
    final int k32_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(1.0, 32);

    final double f32_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero32(k32_m1);
    final double f32_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero32(k32_p1);
    final double f32_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k32_m1, 32);
    final double f32_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k32_p1, 32);

    System.out.printf("[32] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[32] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[32] k32_m1: %s\n", Integer.toString(k32_m1));
    System.out.printf("[32] k32_p1: %s\n", Integer.toString(k32_p1));
    System.out.printf("[32] f32_m1a: %f\n", f32_m1a);
    System.out.printf("[32] f32_p1a: %f\n", f32_p1a);
    System.out.printf("[32] f32_m1b: %f\n", f32_m1b);
    System.out.printf("[32] f32_p1b: %f\n", f32_p1b);
  }

  @Test public void testBoundsWithZero32()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero32(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero32(1.0);
    final int k_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero32(0.0);
    final int k32_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(-1.0, 32);
    final int k32_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(1.0, 32);
    final int k32_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(0.0, 32);

    final double f32_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero32(k32_m1);
    final double f32_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero32(k32_p1);
    final double f32_0a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero32(k32_0);
    final double f32_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k32_m1, 32);
    final double f32_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k32_p1, 32);
    final double f32_0b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k32_0, 32);

    System.out.printf("[32] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[32] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[32] k_0: %s\n", Integer.toString(k_0));
    System.out.printf("[32] k32_m1: %s\n", Integer.toString(k32_m1));
    System.out.printf("[32] k32_p1: %s\n", Integer.toString(k32_p1));
    System.out.printf("[32] k32_0: %s\n", Integer.toString(k32_0));
    System.out.printf("[32] f32_m1a: %f\n", f32_m1a);
    System.out.printf("[32] f32_p1a: %f\n", f32_p1a);
    System.out.printf("[32] f32_0a: %f\n", f32_0a);
    System.out.printf("[32] f32_m1b: %f\n", f32_m1b);
    System.out.printf("[32] f32_p1b: %f\n", f32_p1b);
    System.out.printf("[32] f32_0b: %f\n", f32_0b);
  }
}
