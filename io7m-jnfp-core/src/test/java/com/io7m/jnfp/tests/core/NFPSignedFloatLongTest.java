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

import com.io7m.jnfp.core.NFPSignedFloatLong;
import org.junit.Assert;
import org.junit.Test;

public final class NFPSignedFloatLongTest
{
  @Test public void testBoundsWithoutZero()
  {
    for (int e = 2; e <= 64; ++e) {
      final long km1 =
        NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, e);
      final double fm1 =
        NFPSignedFloatLong.fromSignedNormalizedWithoutZero(km1, e);

      System.out.printf("[%d] km1: %s\n", e, Long.toString(km1));
      System.out.printf("[%d] fm1: %f\n", e, fm1);
      Assert.assertNotEquals(0, km1);
      Assert.assertEquals(-1.0, fm1, 0.000000000000001);

      final long kp1 =
        NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, e);
      final double fp1 =
        NFPSignedFloatLong.fromSignedNormalizedWithoutZero(kp1, e);

      System.out.printf("[%d] kp1: %s\n", e, Long.toString(kp1));
      System.out.printf("[%d] fp1: %f\n", e, fp1);
      Assert.assertNotEquals(0, kp1);
      Assert.assertEquals(1.0, fp1, 0.000000000000001);
    }
  }

  @Test public void testBoundsWithZero()
  {
    for (int e = 2; e <= 64; ++e) {
      final long km1 = NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, e);
      final double fm1 =
        NFPSignedFloatLong.fromSignedNormalizedWithZero(km1, e);

      System.out.printf("[%d] km1: %s\n", e, Long.toString(km1));
      System.out.printf("[%d] fm1: %f\n", e, fm1);
      Assert.assertNotEquals(0, km1);
      Assert.assertEquals(-1.0, fm1, 0.000000000000001);

      final long kp1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, e);
      final double fp1 =
        NFPSignedFloatLong.fromSignedNormalizedWithZero(kp1, e);

      System.out.printf("[%d] kp1: %s\n", e, Long.toString(kp1));
      System.out.printf("[%d] fp1: %f\n", e, fp1);
      Assert.assertNotEquals(0, kp1);
      Assert.assertEquals(1.0, fp1, 0.000000000000001);

      final long k0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, e);
      final double f0 = NFPSignedFloatLong.fromSignedNormalizedWithZero(k0, e);

      System.out.printf("[%d] k0: %s\n", e, Long.toString(k0));
      System.out.printf("[%d] f0: %f\n", e, f0);
      Assert.assertEquals(0.0, f0, 0.0);
    }
  }

  @Test public void testBoundsWithoutZero2()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero2(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero2(1.0f);
    final long k2_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 2);
    final long k2_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 2);

    final float f2_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero2(k2_m1);
    final float f2_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero2(k2_p1);
    final float f2_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k2_m1, 2);
    final float f2_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k2_p1, 2);

    System.out.printf("[2] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[2] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[2] k2_m1: %s\n", Long.toString(k2_m1));
    System.out.printf("[2] k2_p1: %s\n", Long.toString(k2_p1));
    System.out.printf("[2] f2_m1a: %f\n", f2_m1a);
    System.out.printf("[2] f2_p1a: %f\n", f2_p1a);
    System.out.printf("[2] f2_m1b: %f\n", f2_m1b);
    System.out.printf("[2] f2_p1b: %f\n", f2_p1b);
  }

  @Test public void testBoundsWithZero2()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero2(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero2(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero2(0.0f);
    final long k2_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 2);
    final long k2_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 2);
    final long k2_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 2);

    final float f2_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero2(k2_m1);
    final float f2_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero2(k2_p1);
    final float f2_0a = NFPSignedFloatLong.fromSignedNormalizedWithZero2(k2_0);
    final float f2_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k2_m1, 2);
    final float f2_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k2_p1, 2);
    final float f2_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k2_0, 2);

    System.out.printf("[2] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[2] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[2] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[2] k2_m1: %s\n", Long.toString(k2_m1));
    System.out.printf("[2] k2_p1: %s\n", Long.toString(k2_p1));
    System.out.printf("[2] k2_0: %s\n", Long.toString(k2_0));
    System.out.printf("[2] f2_m1a: %f\n", f2_m1a);
    System.out.printf("[2] f2_p1a: %f\n", f2_p1a);
    System.out.printf("[2] f2_0a: %f\n", f2_0a);
    System.out.printf("[2] f2_m1b: %f\n", f2_m1b);
    System.out.printf("[2] f2_p1b: %f\n", f2_p1b);
    System.out.printf("[2] f2_0b: %f\n", f2_0b);
  }

  @Test public void testBoundsWithoutZero3()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero3(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero3(1.0f);
    final long k3_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 3);
    final long k3_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 3);

    final float f3_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero3(k3_m1);
    final float f3_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero3(k3_p1);
    final float f3_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k3_m1, 3);
    final float f3_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k3_p1, 3);

    System.out.printf("[3] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[3] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[3] k3_m1: %s\n", Long.toString(k3_m1));
    System.out.printf("[3] k3_p1: %s\n", Long.toString(k3_p1));
    System.out.printf("[3] f3_m1a: %f\n", f3_m1a);
    System.out.printf("[3] f3_p1a: %f\n", f3_p1a);
    System.out.printf("[3] f3_m1b: %f\n", f3_m1b);
    System.out.printf("[3] f3_p1b: %f\n", f3_p1b);
  }

  @Test public void testBoundsWithZero3()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero3(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero3(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero3(0.0f);
    final long k3_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 3);
    final long k3_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 3);
    final long k3_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 3);

    final float f3_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero3(k3_m1);
    final float f3_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero3(k3_p1);
    final float f3_0a = NFPSignedFloatLong.fromSignedNormalizedWithZero3(k3_0);
    final float f3_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k3_m1, 3);
    final float f3_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k3_p1, 3);
    final float f3_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k3_0, 3);

    System.out.printf("[3] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[3] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[3] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[3] k3_m1: %s\n", Long.toString(k3_m1));
    System.out.printf("[3] k3_p1: %s\n", Long.toString(k3_p1));
    System.out.printf("[3] k3_0: %s\n", Long.toString(k3_0));
    System.out.printf("[3] f3_m1a: %f\n", f3_m1a);
    System.out.printf("[3] f3_p1a: %f\n", f3_p1a);
    System.out.printf("[3] f3_0a: %f\n", f3_0a);
    System.out.printf("[3] f3_m1b: %f\n", f3_m1b);
    System.out.printf("[3] f3_p1b: %f\n", f3_p1b);
    System.out.printf("[3] f3_0b: %f\n", f3_0b);
  }

  @Test public void testBoundsWithoutZero4()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero4(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero4(1.0f);
    final long k4_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 4);
    final long k4_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 4);

    final float f4_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero4(k4_m1);
    final float f4_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero4(k4_p1);
    final float f4_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k4_m1, 4);
    final float f4_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k4_p1, 4);

    System.out.printf("[4] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[4] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[4] k4_m1: %s\n", Long.toString(k4_m1));
    System.out.printf("[4] k4_p1: %s\n", Long.toString(k4_p1));
    System.out.printf("[4] f4_m1a: %f\n", f4_m1a);
    System.out.printf("[4] f4_p1a: %f\n", f4_p1a);
    System.out.printf("[4] f4_m1b: %f\n", f4_m1b);
    System.out.printf("[4] f4_p1b: %f\n", f4_p1b);
  }

  @Test public void testBoundsWithZero4()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero4(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero4(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero4(0.0f);
    final long k4_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 4);
    final long k4_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 4);
    final long k4_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 4);

    final float f4_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero4(k4_m1);
    final float f4_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero4(k4_p1);
    final float f4_0a = NFPSignedFloatLong.fromSignedNormalizedWithZero4(k4_0);
    final float f4_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k4_m1, 4);
    final float f4_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k4_p1, 4);
    final float f4_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k4_0, 4);

    System.out.printf("[4] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[4] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[4] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[4] k4_m1: %s\n", Long.toString(k4_m1));
    System.out.printf("[4] k4_p1: %s\n", Long.toString(k4_p1));
    System.out.printf("[4] k4_0: %s\n", Long.toString(k4_0));
    System.out.printf("[4] f4_m1a: %f\n", f4_m1a);
    System.out.printf("[4] f4_p1a: %f\n", f4_p1a);
    System.out.printf("[4] f4_0a: %f\n", f4_0a);
    System.out.printf("[4] f4_m1b: %f\n", f4_m1b);
    System.out.printf("[4] f4_p1b: %f\n", f4_p1b);
    System.out.printf("[4] f4_0b: %f\n", f4_0b);
  }

  @Test public void testBoundsWithoutZero5()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero5(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero5(1.0f);
    final long k5_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 5);
    final long k5_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 5);

    final float f5_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero5(k5_m1);
    final float f5_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero5(k5_p1);
    final float f5_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k5_m1, 5);
    final float f5_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k5_p1, 5);

    System.out.printf("[5] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[5] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[5] k5_m1: %s\n", Long.toString(k5_m1));
    System.out.printf("[5] k5_p1: %s\n", Long.toString(k5_p1));
    System.out.printf("[5] f5_m1a: %f\n", f5_m1a);
    System.out.printf("[5] f5_p1a: %f\n", f5_p1a);
    System.out.printf("[5] f5_m1b: %f\n", f5_m1b);
    System.out.printf("[5] f5_p1b: %f\n", f5_p1b);
  }

  @Test public void testBoundsWithZero5()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero5(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero5(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero5(0.0f);
    final long k5_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 5);
    final long k5_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 5);
    final long k5_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 5);

    final float f5_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero5(k5_m1);
    final float f5_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero5(k5_p1);
    final float f5_0a = NFPSignedFloatLong.fromSignedNormalizedWithZero5(k5_0);
    final float f5_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k5_m1, 5);
    final float f5_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k5_p1, 5);
    final float f5_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k5_0, 5);

    System.out.printf("[5] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[5] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[5] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[5] k5_m1: %s\n", Long.toString(k5_m1));
    System.out.printf("[5] k5_p1: %s\n", Long.toString(k5_p1));
    System.out.printf("[5] k5_0: %s\n", Long.toString(k5_0));
    System.out.printf("[5] f5_m1a: %f\n", f5_m1a);
    System.out.printf("[5] f5_p1a: %f\n", f5_p1a);
    System.out.printf("[5] f5_0a: %f\n", f5_0a);
    System.out.printf("[5] f5_m1b: %f\n", f5_m1b);
    System.out.printf("[5] f5_p1b: %f\n", f5_p1b);
    System.out.printf("[5] f5_0b: %f\n", f5_0b);
  }

  @Test public void testBoundsWithoutZero6()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero6(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero6(1.0f);
    final long k6_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 6);
    final long k6_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 6);

    final float f6_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero6(k6_m1);
    final float f6_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero6(k6_p1);
    final float f6_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k6_m1, 6);
    final float f6_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k6_p1, 6);

    System.out.printf("[6] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[6] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[6] k6_m1: %s\n", Long.toString(k6_m1));
    System.out.printf("[6] k6_p1: %s\n", Long.toString(k6_p1));
    System.out.printf("[6] f6_m1a: %f\n", f6_m1a);
    System.out.printf("[6] f6_p1a: %f\n", f6_p1a);
    System.out.printf("[6] f6_m1b: %f\n", f6_m1b);
    System.out.printf("[6] f6_p1b: %f\n", f6_p1b);
  }

  @Test public void testBoundsWithZero6()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero6(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero6(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero6(0.0f);
    final long k6_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 6);
    final long k6_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 6);
    final long k6_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 6);

    final float f6_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero6(k6_m1);
    final float f6_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero6(k6_p1);
    final float f6_0a = NFPSignedFloatLong.fromSignedNormalizedWithZero6(k6_0);
    final float f6_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k6_m1, 6);
    final float f6_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k6_p1, 6);
    final float f6_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k6_0, 6);

    System.out.printf("[6] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[6] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[6] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[6] k6_m1: %s\n", Long.toString(k6_m1));
    System.out.printf("[6] k6_p1: %s\n", Long.toString(k6_p1));
    System.out.printf("[6] k6_0: %s\n", Long.toString(k6_0));
    System.out.printf("[6] f6_m1a: %f\n", f6_m1a);
    System.out.printf("[6] f6_p1a: %f\n", f6_p1a);
    System.out.printf("[6] f6_0a: %f\n", f6_0a);
    System.out.printf("[6] f6_m1b: %f\n", f6_m1b);
    System.out.printf("[6] f6_p1b: %f\n", f6_p1b);
    System.out.printf("[6] f6_0b: %f\n", f6_0b);
  }

  @Test public void testBoundsWithoutZero7()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero7(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero7(1.0f);
    final long k7_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 7);
    final long k7_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 7);

    final float f7_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero7(k7_m1);
    final float f7_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero7(k7_p1);
    final float f7_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k7_m1, 7);
    final float f7_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k7_p1, 7);

    System.out.printf("[7] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[7] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[7] k7_m1: %s\n", Long.toString(k7_m1));
    System.out.printf("[7] k7_p1: %s\n", Long.toString(k7_p1));
    System.out.printf("[7] f7_m1a: %f\n", f7_m1a);
    System.out.printf("[7] f7_p1a: %f\n", f7_p1a);
    System.out.printf("[7] f7_m1b: %f\n", f7_m1b);
    System.out.printf("[7] f7_p1b: %f\n", f7_p1b);
  }

  @Test public void testBoundsWithZero7()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero7(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero7(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero7(0.0f);
    final long k7_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 7);
    final long k7_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 7);
    final long k7_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 7);

    final float f7_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero7(k7_m1);
    final float f7_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero7(k7_p1);
    final float f7_0a = NFPSignedFloatLong.fromSignedNormalizedWithZero7(k7_0);
    final float f7_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k7_m1, 7);
    final float f7_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k7_p1, 7);
    final float f7_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k7_0, 7);

    System.out.printf("[7] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[7] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[7] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[7] k7_m1: %s\n", Long.toString(k7_m1));
    System.out.printf("[7] k7_p1: %s\n", Long.toString(k7_p1));
    System.out.printf("[7] k7_0: %s\n", Long.toString(k7_0));
    System.out.printf("[7] f7_m1a: %f\n", f7_m1a);
    System.out.printf("[7] f7_p1a: %f\n", f7_p1a);
    System.out.printf("[7] f7_0a: %f\n", f7_0a);
    System.out.printf("[7] f7_m1b: %f\n", f7_m1b);
    System.out.printf("[7] f7_p1b: %f\n", f7_p1b);
    System.out.printf("[7] f7_0b: %f\n", f7_0b);
  }

  @Test public void testBoundsWithoutZero8()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero8(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero8(1.0f);
    final long k8_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 8);
    final long k8_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 8);

    final float f8_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero8(k8_m1);
    final float f8_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero8(k8_p1);
    final float f8_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k8_m1, 8);
    final float f8_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k8_p1, 8);

    System.out.printf("[8] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[8] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[8] k8_m1: %s\n", Long.toString(k8_m1));
    System.out.printf("[8] k8_p1: %s\n", Long.toString(k8_p1));
    System.out.printf("[8] f8_m1a: %f\n", f8_m1a);
    System.out.printf("[8] f8_p1a: %f\n", f8_p1a);
    System.out.printf("[8] f8_m1b: %f\n", f8_m1b);
    System.out.printf("[8] f8_p1b: %f\n", f8_p1b);
  }

  @Test public void testBoundsWithZero8()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero8(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero8(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero8(0.0f);
    final long k8_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 8);
    final long k8_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 8);
    final long k8_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 8);

    final float f8_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero8(k8_m1);
    final float f8_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero8(k8_p1);
    final float f8_0a = NFPSignedFloatLong.fromSignedNormalizedWithZero8(k8_0);
    final float f8_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k8_m1, 8);
    final float f8_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k8_p1, 8);
    final float f8_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k8_0, 8);

    System.out.printf("[8] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[8] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[8] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[8] k8_m1: %s\n", Long.toString(k8_m1));
    System.out.printf("[8] k8_p1: %s\n", Long.toString(k8_p1));
    System.out.printf("[8] k8_0: %s\n", Long.toString(k8_0));
    System.out.printf("[8] f8_m1a: %f\n", f8_m1a);
    System.out.printf("[8] f8_p1a: %f\n", f8_p1a);
    System.out.printf("[8] f8_0a: %f\n", f8_0a);
    System.out.printf("[8] f8_m1b: %f\n", f8_m1b);
    System.out.printf("[8] f8_p1b: %f\n", f8_p1b);
    System.out.printf("[8] f8_0b: %f\n", f8_0b);
  }

  @Test public void testBoundsWithoutZero9()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero9(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero9(1.0f);
    final long k9_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 9);
    final long k9_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 9);

    final float f9_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero9(k9_m1);
    final float f9_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero9(k9_p1);
    final float f9_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k9_m1, 9);
    final float f9_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k9_p1, 9);

    System.out.printf("[9] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[9] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[9] k9_m1: %s\n", Long.toString(k9_m1));
    System.out.printf("[9] k9_p1: %s\n", Long.toString(k9_p1));
    System.out.printf("[9] f9_m1a: %f\n", f9_m1a);
    System.out.printf("[9] f9_p1a: %f\n", f9_p1a);
    System.out.printf("[9] f9_m1b: %f\n", f9_m1b);
    System.out.printf("[9] f9_p1b: %f\n", f9_p1b);
  }

  @Test public void testBoundsWithZero9()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero9(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero9(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero9(0.0f);
    final long k9_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 9);
    final long k9_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 9);
    final long k9_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 9);

    final float f9_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero9(k9_m1);
    final float f9_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero9(k9_p1);
    final float f9_0a = NFPSignedFloatLong.fromSignedNormalizedWithZero9(k9_0);
    final float f9_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k9_m1, 9);
    final float f9_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k9_p1, 9);
    final float f9_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k9_0, 9);

    System.out.printf("[9] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[9] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[9] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[9] k9_m1: %s\n", Long.toString(k9_m1));
    System.out.printf("[9] k9_p1: %s\n", Long.toString(k9_p1));
    System.out.printf("[9] k9_0: %s\n", Long.toString(k9_0));
    System.out.printf("[9] f9_m1a: %f\n", f9_m1a);
    System.out.printf("[9] f9_p1a: %f\n", f9_p1a);
    System.out.printf("[9] f9_0a: %f\n", f9_0a);
    System.out.printf("[9] f9_m1b: %f\n", f9_m1b);
    System.out.printf("[9] f9_p1b: %f\n", f9_p1b);
    System.out.printf("[9] f9_0b: %f\n", f9_0b);
  }

  @Test public void testBoundsWithoutZero10()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero10(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero10(1.0f);
    final long k10_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 10);
    final long k10_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 10);

    final float f10_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero10(k10_m1);
    final float f10_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero10(k10_p1);
    final float f10_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k10_m1, 10);
    final float f10_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k10_p1, 10);

    System.out.printf("[10] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[10] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[10] k10_m1: %s\n", Long.toString(k10_m1));
    System.out.printf("[10] k10_p1: %s\n", Long.toString(k10_p1));
    System.out.printf("[10] f10_m1a: %f\n", f10_m1a);
    System.out.printf("[10] f10_p1a: %f\n", f10_p1a);
    System.out.printf("[10] f10_m1b: %f\n", f10_m1b);
    System.out.printf("[10] f10_p1b: %f\n", f10_p1b);
  }

  @Test public void testBoundsWithZero10()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero10(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero10(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero10(0.0f);
    final long k10_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 10);
    final long k10_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 10);
    final long k10_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 10);

    final float f10_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero10(k10_m1);
    final float f10_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero10(k10_p1);
    final float f10_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero10(k10_0);
    final float f10_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k10_m1, 10);
    final float f10_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k10_p1, 10);
    final float f10_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k10_0, 10);

    System.out.printf("[10] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[10] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[10] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[10] k10_m1: %s\n", Long.toString(k10_m1));
    System.out.printf("[10] k10_p1: %s\n", Long.toString(k10_p1));
    System.out.printf("[10] k10_0: %s\n", Long.toString(k10_0));
    System.out.printf("[10] f10_m1a: %f\n", f10_m1a);
    System.out.printf("[10] f10_p1a: %f\n", f10_p1a);
    System.out.printf("[10] f10_0a: %f\n", f10_0a);
    System.out.printf("[10] f10_m1b: %f\n", f10_m1b);
    System.out.printf("[10] f10_p1b: %f\n", f10_p1b);
    System.out.printf("[10] f10_0b: %f\n", f10_0b);
  }

  @Test public void testBoundsWithoutZero11()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero11(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero11(1.0f);
    final long k11_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 11);
    final long k11_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 11);

    final float f11_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero11(k11_m1);
    final float f11_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero11(k11_p1);
    final float f11_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k11_m1, 11);
    final float f11_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k11_p1, 11);

    System.out.printf("[11] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[11] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[11] k11_m1: %s\n", Long.toString(k11_m1));
    System.out.printf("[11] k11_p1: %s\n", Long.toString(k11_p1));
    System.out.printf("[11] f11_m1a: %f\n", f11_m1a);
    System.out.printf("[11] f11_p1a: %f\n", f11_p1a);
    System.out.printf("[11] f11_m1b: %f\n", f11_m1b);
    System.out.printf("[11] f11_p1b: %f\n", f11_p1b);
  }

  @Test public void testBoundsWithZero11()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero11(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero11(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero11(0.0f);
    final long k11_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 11);
    final long k11_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 11);
    final long k11_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 11);

    final float f11_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero11(k11_m1);
    final float f11_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero11(k11_p1);
    final float f11_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero11(k11_0);
    final float f11_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k11_m1, 11);
    final float f11_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k11_p1, 11);
    final float f11_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k11_0, 11);

    System.out.printf("[11] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[11] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[11] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[11] k11_m1: %s\n", Long.toString(k11_m1));
    System.out.printf("[11] k11_p1: %s\n", Long.toString(k11_p1));
    System.out.printf("[11] k11_0: %s\n", Long.toString(k11_0));
    System.out.printf("[11] f11_m1a: %f\n", f11_m1a);
    System.out.printf("[11] f11_p1a: %f\n", f11_p1a);
    System.out.printf("[11] f11_0a: %f\n", f11_0a);
    System.out.printf("[11] f11_m1b: %f\n", f11_m1b);
    System.out.printf("[11] f11_p1b: %f\n", f11_p1b);
    System.out.printf("[11] f11_0b: %f\n", f11_0b);
  }

  @Test public void testBoundsWithoutZero12()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero12(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero12(1.0f);
    final long k12_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 12);
    final long k12_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 12);

    final float f12_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero12(k12_m1);
    final float f12_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero12(k12_p1);
    final float f12_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k12_m1, 12);
    final float f12_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k12_p1, 12);

    System.out.printf("[12] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[12] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[12] k12_m1: %s\n", Long.toString(k12_m1));
    System.out.printf("[12] k12_p1: %s\n", Long.toString(k12_p1));
    System.out.printf("[12] f12_m1a: %f\n", f12_m1a);
    System.out.printf("[12] f12_p1a: %f\n", f12_p1a);
    System.out.printf("[12] f12_m1b: %f\n", f12_m1b);
    System.out.printf("[12] f12_p1b: %f\n", f12_p1b);
  }

  @Test public void testBoundsWithZero12()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero12(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero12(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero12(0.0f);
    final long k12_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 12);
    final long k12_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 12);
    final long k12_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 12);

    final float f12_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero12(k12_m1);
    final float f12_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero12(k12_p1);
    final float f12_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero12(k12_0);
    final float f12_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k12_m1, 12);
    final float f12_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k12_p1, 12);
    final float f12_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k12_0, 12);

    System.out.printf("[12] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[12] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[12] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[12] k12_m1: %s\n", Long.toString(k12_m1));
    System.out.printf("[12] k12_p1: %s\n", Long.toString(k12_p1));
    System.out.printf("[12] k12_0: %s\n", Long.toString(k12_0));
    System.out.printf("[12] f12_m1a: %f\n", f12_m1a);
    System.out.printf("[12] f12_p1a: %f\n", f12_p1a);
    System.out.printf("[12] f12_0a: %f\n", f12_0a);
    System.out.printf("[12] f12_m1b: %f\n", f12_m1b);
    System.out.printf("[12] f12_p1b: %f\n", f12_p1b);
    System.out.printf("[12] f12_0b: %f\n", f12_0b);
  }

  @Test public void testBoundsWithoutZero13()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero13(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero13(1.0f);
    final long k13_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 13);
    final long k13_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 13);

    final float f13_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero13(k13_m1);
    final float f13_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero13(k13_p1);
    final float f13_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k13_m1, 13);
    final float f13_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k13_p1, 13);

    System.out.printf("[13] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[13] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[13] k13_m1: %s\n", Long.toString(k13_m1));
    System.out.printf("[13] k13_p1: %s\n", Long.toString(k13_p1));
    System.out.printf("[13] f13_m1a: %f\n", f13_m1a);
    System.out.printf("[13] f13_p1a: %f\n", f13_p1a);
    System.out.printf("[13] f13_m1b: %f\n", f13_m1b);
    System.out.printf("[13] f13_p1b: %f\n", f13_p1b);
  }

  @Test public void testBoundsWithZero13()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero13(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero13(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero13(0.0f);
    final long k13_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 13);
    final long k13_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 13);
    final long k13_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 13);

    final float f13_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero13(k13_m1);
    final float f13_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero13(k13_p1);
    final float f13_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero13(k13_0);
    final float f13_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k13_m1, 13);
    final float f13_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k13_p1, 13);
    final float f13_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k13_0, 13);

    System.out.printf("[13] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[13] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[13] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[13] k13_m1: %s\n", Long.toString(k13_m1));
    System.out.printf("[13] k13_p1: %s\n", Long.toString(k13_p1));
    System.out.printf("[13] k13_0: %s\n", Long.toString(k13_0));
    System.out.printf("[13] f13_m1a: %f\n", f13_m1a);
    System.out.printf("[13] f13_p1a: %f\n", f13_p1a);
    System.out.printf("[13] f13_0a: %f\n", f13_0a);
    System.out.printf("[13] f13_m1b: %f\n", f13_m1b);
    System.out.printf("[13] f13_p1b: %f\n", f13_p1b);
    System.out.printf("[13] f13_0b: %f\n", f13_0b);
  }

  @Test public void testBoundsWithoutZero14()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero14(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero14(1.0f);
    final long k14_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 14);
    final long k14_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 14);

    final float f14_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero14(k14_m1);
    final float f14_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero14(k14_p1);
    final float f14_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k14_m1, 14);
    final float f14_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k14_p1, 14);

    System.out.printf("[14] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[14] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[14] k14_m1: %s\n", Long.toString(k14_m1));
    System.out.printf("[14] k14_p1: %s\n", Long.toString(k14_p1));
    System.out.printf("[14] f14_m1a: %f\n", f14_m1a);
    System.out.printf("[14] f14_p1a: %f\n", f14_p1a);
    System.out.printf("[14] f14_m1b: %f\n", f14_m1b);
    System.out.printf("[14] f14_p1b: %f\n", f14_p1b);
  }

  @Test public void testBoundsWithZero14()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero14(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero14(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero14(0.0f);
    final long k14_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 14);
    final long k14_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 14);
    final long k14_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 14);

    final float f14_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero14(k14_m1);
    final float f14_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero14(k14_p1);
    final float f14_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero14(k14_0);
    final float f14_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k14_m1, 14);
    final float f14_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k14_p1, 14);
    final float f14_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k14_0, 14);

    System.out.printf("[14] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[14] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[14] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[14] k14_m1: %s\n", Long.toString(k14_m1));
    System.out.printf("[14] k14_p1: %s\n", Long.toString(k14_p1));
    System.out.printf("[14] k14_0: %s\n", Long.toString(k14_0));
    System.out.printf("[14] f14_m1a: %f\n", f14_m1a);
    System.out.printf("[14] f14_p1a: %f\n", f14_p1a);
    System.out.printf("[14] f14_0a: %f\n", f14_0a);
    System.out.printf("[14] f14_m1b: %f\n", f14_m1b);
    System.out.printf("[14] f14_p1b: %f\n", f14_p1b);
    System.out.printf("[14] f14_0b: %f\n", f14_0b);
  }

  @Test public void testBoundsWithoutZero15()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero15(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero15(1.0f);
    final long k15_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 15);
    final long k15_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 15);

    final float f15_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero15(k15_m1);
    final float f15_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero15(k15_p1);
    final float f15_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k15_m1, 15);
    final float f15_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k15_p1, 15);

    System.out.printf("[15] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[15] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[15] k15_m1: %s\n", Long.toString(k15_m1));
    System.out.printf("[15] k15_p1: %s\n", Long.toString(k15_p1));
    System.out.printf("[15] f15_m1a: %f\n", f15_m1a);
    System.out.printf("[15] f15_p1a: %f\n", f15_p1a);
    System.out.printf("[15] f15_m1b: %f\n", f15_m1b);
    System.out.printf("[15] f15_p1b: %f\n", f15_p1b);
  }

  @Test public void testBoundsWithZero15()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero15(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero15(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero15(0.0f);
    final long k15_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 15);
    final long k15_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 15);
    final long k15_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 15);

    final float f15_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero15(k15_m1);
    final float f15_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero15(k15_p1);
    final float f15_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero15(k15_0);
    final float f15_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k15_m1, 15);
    final float f15_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k15_p1, 15);
    final float f15_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k15_0, 15);

    System.out.printf("[15] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[15] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[15] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[15] k15_m1: %s\n", Long.toString(k15_m1));
    System.out.printf("[15] k15_p1: %s\n", Long.toString(k15_p1));
    System.out.printf("[15] k15_0: %s\n", Long.toString(k15_0));
    System.out.printf("[15] f15_m1a: %f\n", f15_m1a);
    System.out.printf("[15] f15_p1a: %f\n", f15_p1a);
    System.out.printf("[15] f15_0a: %f\n", f15_0a);
    System.out.printf("[15] f15_m1b: %f\n", f15_m1b);
    System.out.printf("[15] f15_p1b: %f\n", f15_p1b);
    System.out.printf("[15] f15_0b: %f\n", f15_0b);
  }

  @Test public void testBoundsWithoutZero16()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero16(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero16(1.0f);
    final long k16_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 16);
    final long k16_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 16);

    final float f16_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero16(k16_m1);
    final float f16_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero16(k16_p1);
    final float f16_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k16_m1, 16);
    final float f16_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k16_p1, 16);

    System.out.printf("[16] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[16] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[16] k16_m1: %s\n", Long.toString(k16_m1));
    System.out.printf("[16] k16_p1: %s\n", Long.toString(k16_p1));
    System.out.printf("[16] f16_m1a: %f\n", f16_m1a);
    System.out.printf("[16] f16_p1a: %f\n", f16_p1a);
    System.out.printf("[16] f16_m1b: %f\n", f16_m1b);
    System.out.printf("[16] f16_p1b: %f\n", f16_p1b);
  }

  @Test public void testBoundsWithZero16()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero16(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero16(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero16(0.0f);
    final long k16_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 16);
    final long k16_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 16);
    final long k16_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 16);

    final float f16_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero16(k16_m1);
    final float f16_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero16(k16_p1);
    final float f16_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero16(k16_0);
    final float f16_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k16_m1, 16);
    final float f16_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k16_p1, 16);
    final float f16_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k16_0, 16);

    System.out.printf("[16] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[16] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[16] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[16] k16_m1: %s\n", Long.toString(k16_m1));
    System.out.printf("[16] k16_p1: %s\n", Long.toString(k16_p1));
    System.out.printf("[16] k16_0: %s\n", Long.toString(k16_0));
    System.out.printf("[16] f16_m1a: %f\n", f16_m1a);
    System.out.printf("[16] f16_p1a: %f\n", f16_p1a);
    System.out.printf("[16] f16_0a: %f\n", f16_0a);
    System.out.printf("[16] f16_m1b: %f\n", f16_m1b);
    System.out.printf("[16] f16_p1b: %f\n", f16_p1b);
    System.out.printf("[16] f16_0b: %f\n", f16_0b);
  }

  @Test public void testBoundsWithoutZero17()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero17(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero17(1.0f);
    final long k17_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 17);
    final long k17_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 17);

    final float f17_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero17(k17_m1);
    final float f17_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero17(k17_p1);
    final float f17_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k17_m1, 17);
    final float f17_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k17_p1, 17);

    System.out.printf("[17] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[17] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[17] k17_m1: %s\n", Long.toString(k17_m1));
    System.out.printf("[17] k17_p1: %s\n", Long.toString(k17_p1));
    System.out.printf("[17] f17_m1a: %f\n", f17_m1a);
    System.out.printf("[17] f17_p1a: %f\n", f17_p1a);
    System.out.printf("[17] f17_m1b: %f\n", f17_m1b);
    System.out.printf("[17] f17_p1b: %f\n", f17_p1b);
  }

  @Test public void testBoundsWithZero17()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero17(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero17(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero17(0.0f);
    final long k17_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 17);
    final long k17_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 17);
    final long k17_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 17);

    final float f17_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero17(k17_m1);
    final float f17_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero17(k17_p1);
    final float f17_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero17(k17_0);
    final float f17_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k17_m1, 17);
    final float f17_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k17_p1, 17);
    final float f17_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k17_0, 17);

    System.out.printf("[17] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[17] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[17] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[17] k17_m1: %s\n", Long.toString(k17_m1));
    System.out.printf("[17] k17_p1: %s\n", Long.toString(k17_p1));
    System.out.printf("[17] k17_0: %s\n", Long.toString(k17_0));
    System.out.printf("[17] f17_m1a: %f\n", f17_m1a);
    System.out.printf("[17] f17_p1a: %f\n", f17_p1a);
    System.out.printf("[17] f17_0a: %f\n", f17_0a);
    System.out.printf("[17] f17_m1b: %f\n", f17_m1b);
    System.out.printf("[17] f17_p1b: %f\n", f17_p1b);
    System.out.printf("[17] f17_0b: %f\n", f17_0b);
  }

  @Test public void testBoundsWithoutZero18()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero18(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero18(1.0f);
    final long k18_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 18);
    final long k18_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 18);

    final float f18_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero18(k18_m1);
    final float f18_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero18(k18_p1);
    final float f18_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k18_m1, 18);
    final float f18_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k18_p1, 18);

    System.out.printf("[18] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[18] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[18] k18_m1: %s\n", Long.toString(k18_m1));
    System.out.printf("[18] k18_p1: %s\n", Long.toString(k18_p1));
    System.out.printf("[18] f18_m1a: %f\n", f18_m1a);
    System.out.printf("[18] f18_p1a: %f\n", f18_p1a);
    System.out.printf("[18] f18_m1b: %f\n", f18_m1b);
    System.out.printf("[18] f18_p1b: %f\n", f18_p1b);
  }

  @Test public void testBoundsWithZero18()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero18(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero18(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero18(0.0f);
    final long k18_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 18);
    final long k18_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 18);
    final long k18_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 18);

    final float f18_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero18(k18_m1);
    final float f18_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero18(k18_p1);
    final float f18_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero18(k18_0);
    final float f18_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k18_m1, 18);
    final float f18_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k18_p1, 18);
    final float f18_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k18_0, 18);

    System.out.printf("[18] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[18] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[18] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[18] k18_m1: %s\n", Long.toString(k18_m1));
    System.out.printf("[18] k18_p1: %s\n", Long.toString(k18_p1));
    System.out.printf("[18] k18_0: %s\n", Long.toString(k18_0));
    System.out.printf("[18] f18_m1a: %f\n", f18_m1a);
    System.out.printf("[18] f18_p1a: %f\n", f18_p1a);
    System.out.printf("[18] f18_0a: %f\n", f18_0a);
    System.out.printf("[18] f18_m1b: %f\n", f18_m1b);
    System.out.printf("[18] f18_p1b: %f\n", f18_p1b);
    System.out.printf("[18] f18_0b: %f\n", f18_0b);
  }

  @Test public void testBoundsWithoutZero19()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero19(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero19(1.0f);
    final long k19_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 19);
    final long k19_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 19);

    final float f19_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero19(k19_m1);
    final float f19_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero19(k19_p1);
    final float f19_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k19_m1, 19);
    final float f19_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k19_p1, 19);

    System.out.printf("[19] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[19] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[19] k19_m1: %s\n", Long.toString(k19_m1));
    System.out.printf("[19] k19_p1: %s\n", Long.toString(k19_p1));
    System.out.printf("[19] f19_m1a: %f\n", f19_m1a);
    System.out.printf("[19] f19_p1a: %f\n", f19_p1a);
    System.out.printf("[19] f19_m1b: %f\n", f19_m1b);
    System.out.printf("[19] f19_p1b: %f\n", f19_p1b);
  }

  @Test public void testBoundsWithZero19()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero19(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero19(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero19(0.0f);
    final long k19_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 19);
    final long k19_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 19);
    final long k19_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 19);

    final float f19_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero19(k19_m1);
    final float f19_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero19(k19_p1);
    final float f19_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero19(k19_0);
    final float f19_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k19_m1, 19);
    final float f19_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k19_p1, 19);
    final float f19_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k19_0, 19);

    System.out.printf("[19] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[19] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[19] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[19] k19_m1: %s\n", Long.toString(k19_m1));
    System.out.printf("[19] k19_p1: %s\n", Long.toString(k19_p1));
    System.out.printf("[19] k19_0: %s\n", Long.toString(k19_0));
    System.out.printf("[19] f19_m1a: %f\n", f19_m1a);
    System.out.printf("[19] f19_p1a: %f\n", f19_p1a);
    System.out.printf("[19] f19_0a: %f\n", f19_0a);
    System.out.printf("[19] f19_m1b: %f\n", f19_m1b);
    System.out.printf("[19] f19_p1b: %f\n", f19_p1b);
    System.out.printf("[19] f19_0b: %f\n", f19_0b);
  }

  @Test public void testBoundsWithoutZero20()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero20(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero20(1.0f);
    final long k20_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 20);
    final long k20_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 20);

    final float f20_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero20(k20_m1);
    final float f20_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero20(k20_p1);
    final float f20_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k20_m1, 20);
    final float f20_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k20_p1, 20);

    System.out.printf("[20] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[20] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[20] k20_m1: %s\n", Long.toString(k20_m1));
    System.out.printf("[20] k20_p1: %s\n", Long.toString(k20_p1));
    System.out.printf("[20] f20_m1a: %f\n", f20_m1a);
    System.out.printf("[20] f20_p1a: %f\n", f20_p1a);
    System.out.printf("[20] f20_m1b: %f\n", f20_m1b);
    System.out.printf("[20] f20_p1b: %f\n", f20_p1b);
  }

  @Test public void testBoundsWithZero20()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero20(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero20(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero20(0.0f);
    final long k20_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 20);
    final long k20_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 20);
    final long k20_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 20);

    final float f20_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero20(k20_m1);
    final float f20_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero20(k20_p1);
    final float f20_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero20(k20_0);
    final float f20_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k20_m1, 20);
    final float f20_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k20_p1, 20);
    final float f20_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k20_0, 20);

    System.out.printf("[20] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[20] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[20] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[20] k20_m1: %s\n", Long.toString(k20_m1));
    System.out.printf("[20] k20_p1: %s\n", Long.toString(k20_p1));
    System.out.printf("[20] k20_0: %s\n", Long.toString(k20_0));
    System.out.printf("[20] f20_m1a: %f\n", f20_m1a);
    System.out.printf("[20] f20_p1a: %f\n", f20_p1a);
    System.out.printf("[20] f20_0a: %f\n", f20_0a);
    System.out.printf("[20] f20_m1b: %f\n", f20_m1b);
    System.out.printf("[20] f20_p1b: %f\n", f20_p1b);
    System.out.printf("[20] f20_0b: %f\n", f20_0b);
  }

  @Test public void testBoundsWithoutZero21()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero21(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero21(1.0f);
    final long k21_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 21);
    final long k21_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 21);

    final float f21_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero21(k21_m1);
    final float f21_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero21(k21_p1);
    final float f21_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k21_m1, 21);
    final float f21_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k21_p1, 21);

    System.out.printf("[21] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[21] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[21] k21_m1: %s\n", Long.toString(k21_m1));
    System.out.printf("[21] k21_p1: %s\n", Long.toString(k21_p1));
    System.out.printf("[21] f21_m1a: %f\n", f21_m1a);
    System.out.printf("[21] f21_p1a: %f\n", f21_p1a);
    System.out.printf("[21] f21_m1b: %f\n", f21_m1b);
    System.out.printf("[21] f21_p1b: %f\n", f21_p1b);
  }

  @Test public void testBoundsWithZero21()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero21(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero21(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero21(0.0f);
    final long k21_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 21);
    final long k21_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 21);
    final long k21_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 21);

    final float f21_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero21(k21_m1);
    final float f21_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero21(k21_p1);
    final float f21_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero21(k21_0);
    final float f21_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k21_m1, 21);
    final float f21_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k21_p1, 21);
    final float f21_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k21_0, 21);

    System.out.printf("[21] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[21] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[21] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[21] k21_m1: %s\n", Long.toString(k21_m1));
    System.out.printf("[21] k21_p1: %s\n", Long.toString(k21_p1));
    System.out.printf("[21] k21_0: %s\n", Long.toString(k21_0));
    System.out.printf("[21] f21_m1a: %f\n", f21_m1a);
    System.out.printf("[21] f21_p1a: %f\n", f21_p1a);
    System.out.printf("[21] f21_0a: %f\n", f21_0a);
    System.out.printf("[21] f21_m1b: %f\n", f21_m1b);
    System.out.printf("[21] f21_p1b: %f\n", f21_p1b);
    System.out.printf("[21] f21_0b: %f\n", f21_0b);
  }

  @Test public void testBoundsWithoutZero22()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero22(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero22(1.0f);
    final long k22_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 22);
    final long k22_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 22);

    final float f22_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero22(k22_m1);
    final float f22_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero22(k22_p1);
    final float f22_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k22_m1, 22);
    final float f22_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k22_p1, 22);

    System.out.printf("[22] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[22] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[22] k22_m1: %s\n", Long.toString(k22_m1));
    System.out.printf("[22] k22_p1: %s\n", Long.toString(k22_p1));
    System.out.printf("[22] f22_m1a: %f\n", f22_m1a);
    System.out.printf("[22] f22_p1a: %f\n", f22_p1a);
    System.out.printf("[22] f22_m1b: %f\n", f22_m1b);
    System.out.printf("[22] f22_p1b: %f\n", f22_p1b);
  }

  @Test public void testBoundsWithZero22()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero22(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero22(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero22(0.0f);
    final long k22_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 22);
    final long k22_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 22);
    final long k22_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 22);

    final float f22_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero22(k22_m1);
    final float f22_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero22(k22_p1);
    final float f22_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero22(k22_0);
    final float f22_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k22_m1, 22);
    final float f22_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k22_p1, 22);
    final float f22_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k22_0, 22);

    System.out.printf("[22] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[22] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[22] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[22] k22_m1: %s\n", Long.toString(k22_m1));
    System.out.printf("[22] k22_p1: %s\n", Long.toString(k22_p1));
    System.out.printf("[22] k22_0: %s\n", Long.toString(k22_0));
    System.out.printf("[22] f22_m1a: %f\n", f22_m1a);
    System.out.printf("[22] f22_p1a: %f\n", f22_p1a);
    System.out.printf("[22] f22_0a: %f\n", f22_0a);
    System.out.printf("[22] f22_m1b: %f\n", f22_m1b);
    System.out.printf("[22] f22_p1b: %f\n", f22_p1b);
    System.out.printf("[22] f22_0b: %f\n", f22_0b);
  }

  @Test public void testBoundsWithoutZero23()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero23(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero23(1.0f);
    final long k23_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 23);
    final long k23_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 23);

    final float f23_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero23(k23_m1);
    final float f23_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero23(k23_p1);
    final float f23_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k23_m1, 23);
    final float f23_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k23_p1, 23);

    System.out.printf("[23] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[23] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[23] k23_m1: %s\n", Long.toString(k23_m1));
    System.out.printf("[23] k23_p1: %s\n", Long.toString(k23_p1));
    System.out.printf("[23] f23_m1a: %f\n", f23_m1a);
    System.out.printf("[23] f23_p1a: %f\n", f23_p1a);
    System.out.printf("[23] f23_m1b: %f\n", f23_m1b);
    System.out.printf("[23] f23_p1b: %f\n", f23_p1b);
  }

  @Test public void testBoundsWithZero23()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero23(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero23(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero23(0.0f);
    final long k23_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 23);
    final long k23_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 23);
    final long k23_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 23);

    final float f23_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero23(k23_m1);
    final float f23_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero23(k23_p1);
    final float f23_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero23(k23_0);
    final float f23_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k23_m1, 23);
    final float f23_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k23_p1, 23);
    final float f23_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k23_0, 23);

    System.out.printf("[23] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[23] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[23] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[23] k23_m1: %s\n", Long.toString(k23_m1));
    System.out.printf("[23] k23_p1: %s\n", Long.toString(k23_p1));
    System.out.printf("[23] k23_0: %s\n", Long.toString(k23_0));
    System.out.printf("[23] f23_m1a: %f\n", f23_m1a);
    System.out.printf("[23] f23_p1a: %f\n", f23_p1a);
    System.out.printf("[23] f23_0a: %f\n", f23_0a);
    System.out.printf("[23] f23_m1b: %f\n", f23_m1b);
    System.out.printf("[23] f23_p1b: %f\n", f23_p1b);
    System.out.printf("[23] f23_0b: %f\n", f23_0b);
  }

  @Test public void testBoundsWithoutZero24()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero24(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero24(1.0f);
    final long k24_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 24);
    final long k24_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 24);

    final float f24_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero24(k24_m1);
    final float f24_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero24(k24_p1);
    final float f24_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k24_m1, 24);
    final float f24_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k24_p1, 24);

    System.out.printf("[24] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[24] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[24] k24_m1: %s\n", Long.toString(k24_m1));
    System.out.printf("[24] k24_p1: %s\n", Long.toString(k24_p1));
    System.out.printf("[24] f24_m1a: %f\n", f24_m1a);
    System.out.printf("[24] f24_p1a: %f\n", f24_p1a);
    System.out.printf("[24] f24_m1b: %f\n", f24_m1b);
    System.out.printf("[24] f24_p1b: %f\n", f24_p1b);
  }

  @Test public void testBoundsWithZero24()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero24(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero24(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero24(0.0f);
    final long k24_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 24);
    final long k24_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 24);
    final long k24_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 24);

    final float f24_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero24(k24_m1);
    final float f24_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero24(k24_p1);
    final float f24_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero24(k24_0);
    final float f24_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k24_m1, 24);
    final float f24_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k24_p1, 24);
    final float f24_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k24_0, 24);

    System.out.printf("[24] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[24] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[24] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[24] k24_m1: %s\n", Long.toString(k24_m1));
    System.out.printf("[24] k24_p1: %s\n", Long.toString(k24_p1));
    System.out.printf("[24] k24_0: %s\n", Long.toString(k24_0));
    System.out.printf("[24] f24_m1a: %f\n", f24_m1a);
    System.out.printf("[24] f24_p1a: %f\n", f24_p1a);
    System.out.printf("[24] f24_0a: %f\n", f24_0a);
    System.out.printf("[24] f24_m1b: %f\n", f24_m1b);
    System.out.printf("[24] f24_p1b: %f\n", f24_p1b);
    System.out.printf("[24] f24_0b: %f\n", f24_0b);
  }

  @Test public void testBoundsWithoutZero25()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero25(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero25(1.0f);
    final long k25_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 25);
    final long k25_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 25);

    final float f25_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero25(k25_m1);
    final float f25_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero25(k25_p1);
    final float f25_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k25_m1, 25);
    final float f25_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k25_p1, 25);

    System.out.printf("[25] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[25] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[25] k25_m1: %s\n", Long.toString(k25_m1));
    System.out.printf("[25] k25_p1: %s\n", Long.toString(k25_p1));
    System.out.printf("[25] f25_m1a: %f\n", f25_m1a);
    System.out.printf("[25] f25_p1a: %f\n", f25_p1a);
    System.out.printf("[25] f25_m1b: %f\n", f25_m1b);
    System.out.printf("[25] f25_p1b: %f\n", f25_p1b);
  }

  @Test public void testBoundsWithZero25()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero25(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero25(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero25(0.0f);
    final long k25_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 25);
    final long k25_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 25);
    final long k25_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 25);

    final float f25_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero25(k25_m1);
    final float f25_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero25(k25_p1);
    final float f25_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero25(k25_0);
    final float f25_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k25_m1, 25);
    final float f25_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k25_p1, 25);
    final float f25_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k25_0, 25);

    System.out.printf("[25] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[25] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[25] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[25] k25_m1: %s\n", Long.toString(k25_m1));
    System.out.printf("[25] k25_p1: %s\n", Long.toString(k25_p1));
    System.out.printf("[25] k25_0: %s\n", Long.toString(k25_0));
    System.out.printf("[25] f25_m1a: %f\n", f25_m1a);
    System.out.printf("[25] f25_p1a: %f\n", f25_p1a);
    System.out.printf("[25] f25_0a: %f\n", f25_0a);
    System.out.printf("[25] f25_m1b: %f\n", f25_m1b);
    System.out.printf("[25] f25_p1b: %f\n", f25_p1b);
    System.out.printf("[25] f25_0b: %f\n", f25_0b);
  }

  @Test public void testBoundsWithoutZero26()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero26(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero26(1.0f);
    final long k26_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 26);
    final long k26_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 26);

    final float f26_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero26(k26_m1);
    final float f26_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero26(k26_p1);
    final float f26_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k26_m1, 26);
    final float f26_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k26_p1, 26);

    System.out.printf("[26] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[26] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[26] k26_m1: %s\n", Long.toString(k26_m1));
    System.out.printf("[26] k26_p1: %s\n", Long.toString(k26_p1));
    System.out.printf("[26] f26_m1a: %f\n", f26_m1a);
    System.out.printf("[26] f26_p1a: %f\n", f26_p1a);
    System.out.printf("[26] f26_m1b: %f\n", f26_m1b);
    System.out.printf("[26] f26_p1b: %f\n", f26_p1b);
  }

  @Test public void testBoundsWithZero26()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero26(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero26(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero26(0.0f);
    final long k26_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 26);
    final long k26_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 26);
    final long k26_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 26);

    final float f26_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero26(k26_m1);
    final float f26_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero26(k26_p1);
    final float f26_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero26(k26_0);
    final float f26_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k26_m1, 26);
    final float f26_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k26_p1, 26);
    final float f26_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k26_0, 26);

    System.out.printf("[26] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[26] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[26] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[26] k26_m1: %s\n", Long.toString(k26_m1));
    System.out.printf("[26] k26_p1: %s\n", Long.toString(k26_p1));
    System.out.printf("[26] k26_0: %s\n", Long.toString(k26_0));
    System.out.printf("[26] f26_m1a: %f\n", f26_m1a);
    System.out.printf("[26] f26_p1a: %f\n", f26_p1a);
    System.out.printf("[26] f26_0a: %f\n", f26_0a);
    System.out.printf("[26] f26_m1b: %f\n", f26_m1b);
    System.out.printf("[26] f26_p1b: %f\n", f26_p1b);
    System.out.printf("[26] f26_0b: %f\n", f26_0b);
  }

  @Test public void testBoundsWithoutZero27()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero27(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero27(1.0f);
    final long k27_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 27);
    final long k27_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 27);

    final float f27_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero27(k27_m1);
    final float f27_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero27(k27_p1);
    final float f27_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k27_m1, 27);
    final float f27_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k27_p1, 27);

    System.out.printf("[27] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[27] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[27] k27_m1: %s\n", Long.toString(k27_m1));
    System.out.printf("[27] k27_p1: %s\n", Long.toString(k27_p1));
    System.out.printf("[27] f27_m1a: %f\n", f27_m1a);
    System.out.printf("[27] f27_p1a: %f\n", f27_p1a);
    System.out.printf("[27] f27_m1b: %f\n", f27_m1b);
    System.out.printf("[27] f27_p1b: %f\n", f27_p1b);
  }

  @Test public void testBoundsWithZero27()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero27(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero27(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero27(0.0f);
    final long k27_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 27);
    final long k27_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 27);
    final long k27_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 27);

    final float f27_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero27(k27_m1);
    final float f27_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero27(k27_p1);
    final float f27_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero27(k27_0);
    final float f27_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k27_m1, 27);
    final float f27_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k27_p1, 27);
    final float f27_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k27_0, 27);

    System.out.printf("[27] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[27] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[27] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[27] k27_m1: %s\n", Long.toString(k27_m1));
    System.out.printf("[27] k27_p1: %s\n", Long.toString(k27_p1));
    System.out.printf("[27] k27_0: %s\n", Long.toString(k27_0));
    System.out.printf("[27] f27_m1a: %f\n", f27_m1a);
    System.out.printf("[27] f27_p1a: %f\n", f27_p1a);
    System.out.printf("[27] f27_0a: %f\n", f27_0a);
    System.out.printf("[27] f27_m1b: %f\n", f27_m1b);
    System.out.printf("[27] f27_p1b: %f\n", f27_p1b);
    System.out.printf("[27] f27_0b: %f\n", f27_0b);
  }

  @Test public void testBoundsWithoutZero28()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero28(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero28(1.0f);
    final long k28_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 28);
    final long k28_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 28);

    final float f28_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero28(k28_m1);
    final float f28_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero28(k28_p1);
    final float f28_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k28_m1, 28);
    final float f28_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k28_p1, 28);

    System.out.printf("[28] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[28] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[28] k28_m1: %s\n", Long.toString(k28_m1));
    System.out.printf("[28] k28_p1: %s\n", Long.toString(k28_p1));
    System.out.printf("[28] f28_m1a: %f\n", f28_m1a);
    System.out.printf("[28] f28_p1a: %f\n", f28_p1a);
    System.out.printf("[28] f28_m1b: %f\n", f28_m1b);
    System.out.printf("[28] f28_p1b: %f\n", f28_p1b);
  }

  @Test public void testBoundsWithZero28()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero28(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero28(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero28(0.0f);
    final long k28_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 28);
    final long k28_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 28);
    final long k28_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 28);

    final float f28_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero28(k28_m1);
    final float f28_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero28(k28_p1);
    final float f28_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero28(k28_0);
    final float f28_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k28_m1, 28);
    final float f28_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k28_p1, 28);
    final float f28_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k28_0, 28);

    System.out.printf("[28] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[28] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[28] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[28] k28_m1: %s\n", Long.toString(k28_m1));
    System.out.printf("[28] k28_p1: %s\n", Long.toString(k28_p1));
    System.out.printf("[28] k28_0: %s\n", Long.toString(k28_0));
    System.out.printf("[28] f28_m1a: %f\n", f28_m1a);
    System.out.printf("[28] f28_p1a: %f\n", f28_p1a);
    System.out.printf("[28] f28_0a: %f\n", f28_0a);
    System.out.printf("[28] f28_m1b: %f\n", f28_m1b);
    System.out.printf("[28] f28_p1b: %f\n", f28_p1b);
    System.out.printf("[28] f28_0b: %f\n", f28_0b);
  }

  @Test public void testBoundsWithoutZero29()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero29(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero29(1.0f);
    final long k29_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 29);
    final long k29_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 29);

    final float f29_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero29(k29_m1);
    final float f29_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero29(k29_p1);
    final float f29_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k29_m1, 29);
    final float f29_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k29_p1, 29);

    System.out.printf("[29] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[29] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[29] k29_m1: %s\n", Long.toString(k29_m1));
    System.out.printf("[29] k29_p1: %s\n", Long.toString(k29_p1));
    System.out.printf("[29] f29_m1a: %f\n", f29_m1a);
    System.out.printf("[29] f29_p1a: %f\n", f29_p1a);
    System.out.printf("[29] f29_m1b: %f\n", f29_m1b);
    System.out.printf("[29] f29_p1b: %f\n", f29_p1b);
  }

  @Test public void testBoundsWithZero29()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero29(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero29(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero29(0.0f);
    final long k29_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 29);
    final long k29_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 29);
    final long k29_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 29);

    final float f29_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero29(k29_m1);
    final float f29_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero29(k29_p1);
    final float f29_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero29(k29_0);
    final float f29_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k29_m1, 29);
    final float f29_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k29_p1, 29);
    final float f29_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k29_0, 29);

    System.out.printf("[29] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[29] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[29] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[29] k29_m1: %s\n", Long.toString(k29_m1));
    System.out.printf("[29] k29_p1: %s\n", Long.toString(k29_p1));
    System.out.printf("[29] k29_0: %s\n", Long.toString(k29_0));
    System.out.printf("[29] f29_m1a: %f\n", f29_m1a);
    System.out.printf("[29] f29_p1a: %f\n", f29_p1a);
    System.out.printf("[29] f29_0a: %f\n", f29_0a);
    System.out.printf("[29] f29_m1b: %f\n", f29_m1b);
    System.out.printf("[29] f29_p1b: %f\n", f29_p1b);
    System.out.printf("[29] f29_0b: %f\n", f29_0b);
  }

  @Test public void testBoundsWithoutZero30()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero30(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero30(1.0f);
    final long k30_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 30);
    final long k30_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 30);

    final float f30_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero30(k30_m1);
    final float f30_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero30(k30_p1);
    final float f30_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k30_m1, 30);
    final float f30_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k30_p1, 30);

    System.out.printf("[30] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[30] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[30] k30_m1: %s\n", Long.toString(k30_m1));
    System.out.printf("[30] k30_p1: %s\n", Long.toString(k30_p1));
    System.out.printf("[30] f30_m1a: %f\n", f30_m1a);
    System.out.printf("[30] f30_p1a: %f\n", f30_p1a);
    System.out.printf("[30] f30_m1b: %f\n", f30_m1b);
    System.out.printf("[30] f30_p1b: %f\n", f30_p1b);
  }

  @Test public void testBoundsWithZero30()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero30(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero30(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero30(0.0f);
    final long k30_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 30);
    final long k30_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 30);
    final long k30_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 30);

    final float f30_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero30(k30_m1);
    final float f30_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero30(k30_p1);
    final float f30_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero30(k30_0);
    final float f30_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k30_m1, 30);
    final float f30_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k30_p1, 30);
    final float f30_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k30_0, 30);

    System.out.printf("[30] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[30] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[30] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[30] k30_m1: %s\n", Long.toString(k30_m1));
    System.out.printf("[30] k30_p1: %s\n", Long.toString(k30_p1));
    System.out.printf("[30] k30_0: %s\n", Long.toString(k30_0));
    System.out.printf("[30] f30_m1a: %f\n", f30_m1a);
    System.out.printf("[30] f30_p1a: %f\n", f30_p1a);
    System.out.printf("[30] f30_0a: %f\n", f30_0a);
    System.out.printf("[30] f30_m1b: %f\n", f30_m1b);
    System.out.printf("[30] f30_p1b: %f\n", f30_p1b);
    System.out.printf("[30] f30_0b: %f\n", f30_0b);
  }

  @Test public void testBoundsWithoutZero31()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero31(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero31(1.0f);
    final long k31_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 31);
    final long k31_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 31);

    final float f31_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero31(k31_m1);
    final float f31_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero31(k31_p1);
    final float f31_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k31_m1, 31);
    final float f31_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k31_p1, 31);

    System.out.printf("[31] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[31] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[31] k31_m1: %s\n", Long.toString(k31_m1));
    System.out.printf("[31] k31_p1: %s\n", Long.toString(k31_p1));
    System.out.printf("[31] f31_m1a: %f\n", f31_m1a);
    System.out.printf("[31] f31_p1a: %f\n", f31_p1a);
    System.out.printf("[31] f31_m1b: %f\n", f31_m1b);
    System.out.printf("[31] f31_p1b: %f\n", f31_p1b);
  }

  @Test public void testBoundsWithZero31()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero31(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero31(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero31(0.0f);
    final long k31_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 31);
    final long k31_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 31);
    final long k31_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 31);

    final float f31_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero31(k31_m1);
    final float f31_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero31(k31_p1);
    final float f31_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero31(k31_0);
    final float f31_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k31_m1, 31);
    final float f31_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k31_p1, 31);
    final float f31_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k31_0, 31);

    System.out.printf("[31] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[31] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[31] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[31] k31_m1: %s\n", Long.toString(k31_m1));
    System.out.printf("[31] k31_p1: %s\n", Long.toString(k31_p1));
    System.out.printf("[31] k31_0: %s\n", Long.toString(k31_0));
    System.out.printf("[31] f31_m1a: %f\n", f31_m1a);
    System.out.printf("[31] f31_p1a: %f\n", f31_p1a);
    System.out.printf("[31] f31_0a: %f\n", f31_0a);
    System.out.printf("[31] f31_m1b: %f\n", f31_m1b);
    System.out.printf("[31] f31_p1b: %f\n", f31_p1b);
    System.out.printf("[31] f31_0b: %f\n", f31_0b);
  }

  @Test public void testBoundsWithoutZero32()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero32(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero32(1.0f);
    final long k32_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 32);
    final long k32_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 32);

    final float f32_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero32(k32_m1);
    final float f32_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero32(k32_p1);
    final float f32_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k32_m1, 32);
    final float f32_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k32_p1, 32);

    System.out.printf("[32] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[32] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[32] k32_m1: %s\n", Long.toString(k32_m1));
    System.out.printf("[32] k32_p1: %s\n", Long.toString(k32_p1));
    System.out.printf("[32] f32_m1a: %f\n", f32_m1a);
    System.out.printf("[32] f32_p1a: %f\n", f32_p1a);
    System.out.printf("[32] f32_m1b: %f\n", f32_m1b);
    System.out.printf("[32] f32_p1b: %f\n", f32_p1b);
  }

  @Test public void testBoundsWithZero32()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero32(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero32(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero32(0.0f);
    final long k32_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 32);
    final long k32_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 32);
    final long k32_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 32);

    final float f32_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero32(k32_m1);
    final float f32_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero32(k32_p1);
    final float f32_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero32(k32_0);
    final float f32_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k32_m1, 32);
    final float f32_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k32_p1, 32);
    final float f32_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k32_0, 32);

    System.out.printf("[32] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[32] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[32] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[32] k32_m1: %s\n", Long.toString(k32_m1));
    System.out.printf("[32] k32_p1: %s\n", Long.toString(k32_p1));
    System.out.printf("[32] k32_0: %s\n", Long.toString(k32_0));
    System.out.printf("[32] f32_m1a: %f\n", f32_m1a);
    System.out.printf("[32] f32_p1a: %f\n", f32_p1a);
    System.out.printf("[32] f32_0a: %f\n", f32_0a);
    System.out.printf("[32] f32_m1b: %f\n", f32_m1b);
    System.out.printf("[32] f32_p1b: %f\n", f32_p1b);
    System.out.printf("[32] f32_0b: %f\n", f32_0b);
  }

  @Test public void testBoundsWithoutZero33()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero33(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero33(1.0f);
    final long k33_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 33);
    final long k33_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 33);

    final float f33_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero33(k33_m1);
    final float f33_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero33(k33_p1);
    final float f33_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k33_m1, 33);
    final float f33_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k33_p1, 33);

    System.out.printf("[33] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[33] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[33] k33_m1: %s\n", Long.toString(k33_m1));
    System.out.printf("[33] k33_p1: %s\n", Long.toString(k33_p1));
    System.out.printf("[33] f33_m1a: %f\n", f33_m1a);
    System.out.printf("[33] f33_p1a: %f\n", f33_p1a);
    System.out.printf("[33] f33_m1b: %f\n", f33_m1b);
    System.out.printf("[33] f33_p1b: %f\n", f33_p1b);
  }

  @Test public void testBoundsWithZero33()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero33(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero33(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero33(0.0f);
    final long k33_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 33);
    final long k33_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 33);
    final long k33_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 33);

    final float f33_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero33(k33_m1);
    final float f33_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero33(k33_p1);
    final float f33_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero33(k33_0);
    final float f33_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k33_m1, 33);
    final float f33_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k33_p1, 33);
    final float f33_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k33_0, 33);

    System.out.printf("[33] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[33] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[33] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[33] k33_m1: %s\n", Long.toString(k33_m1));
    System.out.printf("[33] k33_p1: %s\n", Long.toString(k33_p1));
    System.out.printf("[33] k33_0: %s\n", Long.toString(k33_0));
    System.out.printf("[33] f33_m1a: %f\n", f33_m1a);
    System.out.printf("[33] f33_p1a: %f\n", f33_p1a);
    System.out.printf("[33] f33_0a: %f\n", f33_0a);
    System.out.printf("[33] f33_m1b: %f\n", f33_m1b);
    System.out.printf("[33] f33_p1b: %f\n", f33_p1b);
    System.out.printf("[33] f33_0b: %f\n", f33_0b);
  }

  @Test public void testBoundsWithoutZero34()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero34(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero34(1.0f);
    final long k34_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 34);
    final long k34_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 34);

    final float f34_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero34(k34_m1);
    final float f34_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero34(k34_p1);
    final float f34_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k34_m1, 34);
    final float f34_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k34_p1, 34);

    System.out.printf("[34] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[34] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[34] k34_m1: %s\n", Long.toString(k34_m1));
    System.out.printf("[34] k34_p1: %s\n", Long.toString(k34_p1));
    System.out.printf("[34] f34_m1a: %f\n", f34_m1a);
    System.out.printf("[34] f34_p1a: %f\n", f34_p1a);
    System.out.printf("[34] f34_m1b: %f\n", f34_m1b);
    System.out.printf("[34] f34_p1b: %f\n", f34_p1b);
  }

  @Test public void testBoundsWithZero34()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero34(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero34(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero34(0.0f);
    final long k34_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 34);
    final long k34_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 34);
    final long k34_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 34);

    final float f34_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero34(k34_m1);
    final float f34_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero34(k34_p1);
    final float f34_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero34(k34_0);
    final float f34_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k34_m1, 34);
    final float f34_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k34_p1, 34);
    final float f34_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k34_0, 34);

    System.out.printf("[34] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[34] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[34] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[34] k34_m1: %s\n", Long.toString(k34_m1));
    System.out.printf("[34] k34_p1: %s\n", Long.toString(k34_p1));
    System.out.printf("[34] k34_0: %s\n", Long.toString(k34_0));
    System.out.printf("[34] f34_m1a: %f\n", f34_m1a);
    System.out.printf("[34] f34_p1a: %f\n", f34_p1a);
    System.out.printf("[34] f34_0a: %f\n", f34_0a);
    System.out.printf("[34] f34_m1b: %f\n", f34_m1b);
    System.out.printf("[34] f34_p1b: %f\n", f34_p1b);
    System.out.printf("[34] f34_0b: %f\n", f34_0b);
  }

  @Test public void testBoundsWithoutZero35()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero35(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero35(1.0f);
    final long k35_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 35);
    final long k35_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 35);

    final float f35_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero35(k35_m1);
    final float f35_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero35(k35_p1);
    final float f35_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k35_m1, 35);
    final float f35_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k35_p1, 35);

    System.out.printf("[35] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[35] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[35] k35_m1: %s\n", Long.toString(k35_m1));
    System.out.printf("[35] k35_p1: %s\n", Long.toString(k35_p1));
    System.out.printf("[35] f35_m1a: %f\n", f35_m1a);
    System.out.printf("[35] f35_p1a: %f\n", f35_p1a);
    System.out.printf("[35] f35_m1b: %f\n", f35_m1b);
    System.out.printf("[35] f35_p1b: %f\n", f35_p1b);
  }

  @Test public void testBoundsWithZero35()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero35(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero35(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero35(0.0f);
    final long k35_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 35);
    final long k35_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 35);
    final long k35_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 35);

    final float f35_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero35(k35_m1);
    final float f35_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero35(k35_p1);
    final float f35_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero35(k35_0);
    final float f35_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k35_m1, 35);
    final float f35_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k35_p1, 35);
    final float f35_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k35_0, 35);

    System.out.printf("[35] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[35] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[35] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[35] k35_m1: %s\n", Long.toString(k35_m1));
    System.out.printf("[35] k35_p1: %s\n", Long.toString(k35_p1));
    System.out.printf("[35] k35_0: %s\n", Long.toString(k35_0));
    System.out.printf("[35] f35_m1a: %f\n", f35_m1a);
    System.out.printf("[35] f35_p1a: %f\n", f35_p1a);
    System.out.printf("[35] f35_0a: %f\n", f35_0a);
    System.out.printf("[35] f35_m1b: %f\n", f35_m1b);
    System.out.printf("[35] f35_p1b: %f\n", f35_p1b);
    System.out.printf("[35] f35_0b: %f\n", f35_0b);
  }

  @Test public void testBoundsWithoutZero36()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero36(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero36(1.0f);
    final long k36_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 36);
    final long k36_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 36);

    final float f36_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero36(k36_m1);
    final float f36_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero36(k36_p1);
    final float f36_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k36_m1, 36);
    final float f36_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k36_p1, 36);

    System.out.printf("[36] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[36] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[36] k36_m1: %s\n", Long.toString(k36_m1));
    System.out.printf("[36] k36_p1: %s\n", Long.toString(k36_p1));
    System.out.printf("[36] f36_m1a: %f\n", f36_m1a);
    System.out.printf("[36] f36_p1a: %f\n", f36_p1a);
    System.out.printf("[36] f36_m1b: %f\n", f36_m1b);
    System.out.printf("[36] f36_p1b: %f\n", f36_p1b);
  }

  @Test public void testBoundsWithZero36()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero36(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero36(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero36(0.0f);
    final long k36_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 36);
    final long k36_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 36);
    final long k36_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 36);

    final float f36_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero36(k36_m1);
    final float f36_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero36(k36_p1);
    final float f36_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero36(k36_0);
    final float f36_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k36_m1, 36);
    final float f36_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k36_p1, 36);
    final float f36_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k36_0, 36);

    System.out.printf("[36] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[36] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[36] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[36] k36_m1: %s\n", Long.toString(k36_m1));
    System.out.printf("[36] k36_p1: %s\n", Long.toString(k36_p1));
    System.out.printf("[36] k36_0: %s\n", Long.toString(k36_0));
    System.out.printf("[36] f36_m1a: %f\n", f36_m1a);
    System.out.printf("[36] f36_p1a: %f\n", f36_p1a);
    System.out.printf("[36] f36_0a: %f\n", f36_0a);
    System.out.printf("[36] f36_m1b: %f\n", f36_m1b);
    System.out.printf("[36] f36_p1b: %f\n", f36_p1b);
    System.out.printf("[36] f36_0b: %f\n", f36_0b);
  }

  @Test public void testBoundsWithoutZero37()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero37(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero37(1.0f);
    final long k37_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 37);
    final long k37_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 37);

    final float f37_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero37(k37_m1);
    final float f37_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero37(k37_p1);
    final float f37_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k37_m1, 37);
    final float f37_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k37_p1, 37);

    System.out.printf("[37] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[37] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[37] k37_m1: %s\n", Long.toString(k37_m1));
    System.out.printf("[37] k37_p1: %s\n", Long.toString(k37_p1));
    System.out.printf("[37] f37_m1a: %f\n", f37_m1a);
    System.out.printf("[37] f37_p1a: %f\n", f37_p1a);
    System.out.printf("[37] f37_m1b: %f\n", f37_m1b);
    System.out.printf("[37] f37_p1b: %f\n", f37_p1b);
  }

  @Test public void testBoundsWithZero37()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero37(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero37(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero37(0.0f);
    final long k37_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 37);
    final long k37_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 37);
    final long k37_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 37);

    final float f37_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero37(k37_m1);
    final float f37_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero37(k37_p1);
    final float f37_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero37(k37_0);
    final float f37_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k37_m1, 37);
    final float f37_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k37_p1, 37);
    final float f37_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k37_0, 37);

    System.out.printf("[37] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[37] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[37] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[37] k37_m1: %s\n", Long.toString(k37_m1));
    System.out.printf("[37] k37_p1: %s\n", Long.toString(k37_p1));
    System.out.printf("[37] k37_0: %s\n", Long.toString(k37_0));
    System.out.printf("[37] f37_m1a: %f\n", f37_m1a);
    System.out.printf("[37] f37_p1a: %f\n", f37_p1a);
    System.out.printf("[37] f37_0a: %f\n", f37_0a);
    System.out.printf("[37] f37_m1b: %f\n", f37_m1b);
    System.out.printf("[37] f37_p1b: %f\n", f37_p1b);
    System.out.printf("[37] f37_0b: %f\n", f37_0b);
  }

  @Test public void testBoundsWithoutZero38()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero38(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero38(1.0f);
    final long k38_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 38);
    final long k38_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 38);

    final float f38_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero38(k38_m1);
    final float f38_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero38(k38_p1);
    final float f38_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k38_m1, 38);
    final float f38_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k38_p1, 38);

    System.out.printf("[38] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[38] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[38] k38_m1: %s\n", Long.toString(k38_m1));
    System.out.printf("[38] k38_p1: %s\n", Long.toString(k38_p1));
    System.out.printf("[38] f38_m1a: %f\n", f38_m1a);
    System.out.printf("[38] f38_p1a: %f\n", f38_p1a);
    System.out.printf("[38] f38_m1b: %f\n", f38_m1b);
    System.out.printf("[38] f38_p1b: %f\n", f38_p1b);
  }

  @Test public void testBoundsWithZero38()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero38(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero38(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero38(0.0f);
    final long k38_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 38);
    final long k38_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 38);
    final long k38_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 38);

    final float f38_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero38(k38_m1);
    final float f38_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero38(k38_p1);
    final float f38_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero38(k38_0);
    final float f38_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k38_m1, 38);
    final float f38_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k38_p1, 38);
    final float f38_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k38_0, 38);

    System.out.printf("[38] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[38] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[38] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[38] k38_m1: %s\n", Long.toString(k38_m1));
    System.out.printf("[38] k38_p1: %s\n", Long.toString(k38_p1));
    System.out.printf("[38] k38_0: %s\n", Long.toString(k38_0));
    System.out.printf("[38] f38_m1a: %f\n", f38_m1a);
    System.out.printf("[38] f38_p1a: %f\n", f38_p1a);
    System.out.printf("[38] f38_0a: %f\n", f38_0a);
    System.out.printf("[38] f38_m1b: %f\n", f38_m1b);
    System.out.printf("[38] f38_p1b: %f\n", f38_p1b);
    System.out.printf("[38] f38_0b: %f\n", f38_0b);
  }

  @Test public void testBoundsWithoutZero39()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero39(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero39(1.0f);
    final long k39_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 39);
    final long k39_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 39);

    final float f39_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero39(k39_m1);
    final float f39_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero39(k39_p1);
    final float f39_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k39_m1, 39);
    final float f39_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k39_p1, 39);

    System.out.printf("[39] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[39] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[39] k39_m1: %s\n", Long.toString(k39_m1));
    System.out.printf("[39] k39_p1: %s\n", Long.toString(k39_p1));
    System.out.printf("[39] f39_m1a: %f\n", f39_m1a);
    System.out.printf("[39] f39_p1a: %f\n", f39_p1a);
    System.out.printf("[39] f39_m1b: %f\n", f39_m1b);
    System.out.printf("[39] f39_p1b: %f\n", f39_p1b);
  }

  @Test public void testBoundsWithZero39()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero39(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero39(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero39(0.0f);
    final long k39_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 39);
    final long k39_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 39);
    final long k39_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 39);

    final float f39_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero39(k39_m1);
    final float f39_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero39(k39_p1);
    final float f39_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero39(k39_0);
    final float f39_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k39_m1, 39);
    final float f39_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k39_p1, 39);
    final float f39_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k39_0, 39);

    System.out.printf("[39] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[39] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[39] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[39] k39_m1: %s\n", Long.toString(k39_m1));
    System.out.printf("[39] k39_p1: %s\n", Long.toString(k39_p1));
    System.out.printf("[39] k39_0: %s\n", Long.toString(k39_0));
    System.out.printf("[39] f39_m1a: %f\n", f39_m1a);
    System.out.printf("[39] f39_p1a: %f\n", f39_p1a);
    System.out.printf("[39] f39_0a: %f\n", f39_0a);
    System.out.printf("[39] f39_m1b: %f\n", f39_m1b);
    System.out.printf("[39] f39_p1b: %f\n", f39_p1b);
    System.out.printf("[39] f39_0b: %f\n", f39_0b);
  }

  @Test public void testBoundsWithoutZero40()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero40(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero40(1.0f);
    final long k40_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 40);
    final long k40_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 40);

    final float f40_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero40(k40_m1);
    final float f40_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero40(k40_p1);
    final float f40_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k40_m1, 40);
    final float f40_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k40_p1, 40);

    System.out.printf("[40] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[40] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[40] k40_m1: %s\n", Long.toString(k40_m1));
    System.out.printf("[40] k40_p1: %s\n", Long.toString(k40_p1));
    System.out.printf("[40] f40_m1a: %f\n", f40_m1a);
    System.out.printf("[40] f40_p1a: %f\n", f40_p1a);
    System.out.printf("[40] f40_m1b: %f\n", f40_m1b);
    System.out.printf("[40] f40_p1b: %f\n", f40_p1b);
  }

  @Test public void testBoundsWithZero40()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero40(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero40(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero40(0.0f);
    final long k40_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 40);
    final long k40_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 40);
    final long k40_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 40);

    final float f40_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero40(k40_m1);
    final float f40_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero40(k40_p1);
    final float f40_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero40(k40_0);
    final float f40_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k40_m1, 40);
    final float f40_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k40_p1, 40);
    final float f40_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k40_0, 40);

    System.out.printf("[40] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[40] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[40] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[40] k40_m1: %s\n", Long.toString(k40_m1));
    System.out.printf("[40] k40_p1: %s\n", Long.toString(k40_p1));
    System.out.printf("[40] k40_0: %s\n", Long.toString(k40_0));
    System.out.printf("[40] f40_m1a: %f\n", f40_m1a);
    System.out.printf("[40] f40_p1a: %f\n", f40_p1a);
    System.out.printf("[40] f40_0a: %f\n", f40_0a);
    System.out.printf("[40] f40_m1b: %f\n", f40_m1b);
    System.out.printf("[40] f40_p1b: %f\n", f40_p1b);
    System.out.printf("[40] f40_0b: %f\n", f40_0b);
  }

  @Test public void testBoundsWithoutZero41()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero41(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero41(1.0f);
    final long k41_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 41);
    final long k41_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 41);

    final float f41_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero41(k41_m1);
    final float f41_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero41(k41_p1);
    final float f41_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k41_m1, 41);
    final float f41_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k41_p1, 41);

    System.out.printf("[41] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[41] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[41] k41_m1: %s\n", Long.toString(k41_m1));
    System.out.printf("[41] k41_p1: %s\n", Long.toString(k41_p1));
    System.out.printf("[41] f41_m1a: %f\n", f41_m1a);
    System.out.printf("[41] f41_p1a: %f\n", f41_p1a);
    System.out.printf("[41] f41_m1b: %f\n", f41_m1b);
    System.out.printf("[41] f41_p1b: %f\n", f41_p1b);
  }

  @Test public void testBoundsWithZero41()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero41(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero41(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero41(0.0f);
    final long k41_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 41);
    final long k41_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 41);
    final long k41_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 41);

    final float f41_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero41(k41_m1);
    final float f41_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero41(k41_p1);
    final float f41_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero41(k41_0);
    final float f41_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k41_m1, 41);
    final float f41_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k41_p1, 41);
    final float f41_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k41_0, 41);

    System.out.printf("[41] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[41] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[41] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[41] k41_m1: %s\n", Long.toString(k41_m1));
    System.out.printf("[41] k41_p1: %s\n", Long.toString(k41_p1));
    System.out.printf("[41] k41_0: %s\n", Long.toString(k41_0));
    System.out.printf("[41] f41_m1a: %f\n", f41_m1a);
    System.out.printf("[41] f41_p1a: %f\n", f41_p1a);
    System.out.printf("[41] f41_0a: %f\n", f41_0a);
    System.out.printf("[41] f41_m1b: %f\n", f41_m1b);
    System.out.printf("[41] f41_p1b: %f\n", f41_p1b);
    System.out.printf("[41] f41_0b: %f\n", f41_0b);
  }

  @Test public void testBoundsWithoutZero42()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero42(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero42(1.0f);
    final long k42_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 42);
    final long k42_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 42);

    final float f42_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero42(k42_m1);
    final float f42_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero42(k42_p1);
    final float f42_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k42_m1, 42);
    final float f42_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k42_p1, 42);

    System.out.printf("[42] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[42] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[42] k42_m1: %s\n", Long.toString(k42_m1));
    System.out.printf("[42] k42_p1: %s\n", Long.toString(k42_p1));
    System.out.printf("[42] f42_m1a: %f\n", f42_m1a);
    System.out.printf("[42] f42_p1a: %f\n", f42_p1a);
    System.out.printf("[42] f42_m1b: %f\n", f42_m1b);
    System.out.printf("[42] f42_p1b: %f\n", f42_p1b);
  }

  @Test public void testBoundsWithZero42()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero42(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero42(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero42(0.0f);
    final long k42_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 42);
    final long k42_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 42);
    final long k42_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 42);

    final float f42_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero42(k42_m1);
    final float f42_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero42(k42_p1);
    final float f42_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero42(k42_0);
    final float f42_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k42_m1, 42);
    final float f42_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k42_p1, 42);
    final float f42_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k42_0, 42);

    System.out.printf("[42] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[42] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[42] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[42] k42_m1: %s\n", Long.toString(k42_m1));
    System.out.printf("[42] k42_p1: %s\n", Long.toString(k42_p1));
    System.out.printf("[42] k42_0: %s\n", Long.toString(k42_0));
    System.out.printf("[42] f42_m1a: %f\n", f42_m1a);
    System.out.printf("[42] f42_p1a: %f\n", f42_p1a);
    System.out.printf("[42] f42_0a: %f\n", f42_0a);
    System.out.printf("[42] f42_m1b: %f\n", f42_m1b);
    System.out.printf("[42] f42_p1b: %f\n", f42_p1b);
    System.out.printf("[42] f42_0b: %f\n", f42_0b);
  }

  @Test public void testBoundsWithoutZero43()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero43(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero43(1.0f);
    final long k43_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 43);
    final long k43_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 43);

    final float f43_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero43(k43_m1);
    final float f43_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero43(k43_p1);
    final float f43_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k43_m1, 43);
    final float f43_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k43_p1, 43);

    System.out.printf("[43] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[43] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[43] k43_m1: %s\n", Long.toString(k43_m1));
    System.out.printf("[43] k43_p1: %s\n", Long.toString(k43_p1));
    System.out.printf("[43] f43_m1a: %f\n", f43_m1a);
    System.out.printf("[43] f43_p1a: %f\n", f43_p1a);
    System.out.printf("[43] f43_m1b: %f\n", f43_m1b);
    System.out.printf("[43] f43_p1b: %f\n", f43_p1b);
  }

  @Test public void testBoundsWithZero43()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero43(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero43(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero43(0.0f);
    final long k43_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 43);
    final long k43_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 43);
    final long k43_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 43);

    final float f43_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero43(k43_m1);
    final float f43_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero43(k43_p1);
    final float f43_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero43(k43_0);
    final float f43_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k43_m1, 43);
    final float f43_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k43_p1, 43);
    final float f43_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k43_0, 43);

    System.out.printf("[43] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[43] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[43] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[43] k43_m1: %s\n", Long.toString(k43_m1));
    System.out.printf("[43] k43_p1: %s\n", Long.toString(k43_p1));
    System.out.printf("[43] k43_0: %s\n", Long.toString(k43_0));
    System.out.printf("[43] f43_m1a: %f\n", f43_m1a);
    System.out.printf("[43] f43_p1a: %f\n", f43_p1a);
    System.out.printf("[43] f43_0a: %f\n", f43_0a);
    System.out.printf("[43] f43_m1b: %f\n", f43_m1b);
    System.out.printf("[43] f43_p1b: %f\n", f43_p1b);
    System.out.printf("[43] f43_0b: %f\n", f43_0b);
  }

  @Test public void testBoundsWithoutZero44()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero44(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero44(1.0f);
    final long k44_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 44);
    final long k44_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 44);

    final float f44_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero44(k44_m1);
    final float f44_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero44(k44_p1);
    final float f44_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k44_m1, 44);
    final float f44_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k44_p1, 44);

    System.out.printf("[44] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[44] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[44] k44_m1: %s\n", Long.toString(k44_m1));
    System.out.printf("[44] k44_p1: %s\n", Long.toString(k44_p1));
    System.out.printf("[44] f44_m1a: %f\n", f44_m1a);
    System.out.printf("[44] f44_p1a: %f\n", f44_p1a);
    System.out.printf("[44] f44_m1b: %f\n", f44_m1b);
    System.out.printf("[44] f44_p1b: %f\n", f44_p1b);
  }

  @Test public void testBoundsWithZero44()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero44(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero44(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero44(0.0f);
    final long k44_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 44);
    final long k44_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 44);
    final long k44_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 44);

    final float f44_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero44(k44_m1);
    final float f44_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero44(k44_p1);
    final float f44_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero44(k44_0);
    final float f44_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k44_m1, 44);
    final float f44_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k44_p1, 44);
    final float f44_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k44_0, 44);

    System.out.printf("[44] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[44] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[44] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[44] k44_m1: %s\n", Long.toString(k44_m1));
    System.out.printf("[44] k44_p1: %s\n", Long.toString(k44_p1));
    System.out.printf("[44] k44_0: %s\n", Long.toString(k44_0));
    System.out.printf("[44] f44_m1a: %f\n", f44_m1a);
    System.out.printf("[44] f44_p1a: %f\n", f44_p1a);
    System.out.printf("[44] f44_0a: %f\n", f44_0a);
    System.out.printf("[44] f44_m1b: %f\n", f44_m1b);
    System.out.printf("[44] f44_p1b: %f\n", f44_p1b);
    System.out.printf("[44] f44_0b: %f\n", f44_0b);
  }

  @Test public void testBoundsWithoutZero45()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero45(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero45(1.0f);
    final long k45_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 45);
    final long k45_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 45);

    final float f45_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero45(k45_m1);
    final float f45_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero45(k45_p1);
    final float f45_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k45_m1, 45);
    final float f45_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k45_p1, 45);

    System.out.printf("[45] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[45] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[45] k45_m1: %s\n", Long.toString(k45_m1));
    System.out.printf("[45] k45_p1: %s\n", Long.toString(k45_p1));
    System.out.printf("[45] f45_m1a: %f\n", f45_m1a);
    System.out.printf("[45] f45_p1a: %f\n", f45_p1a);
    System.out.printf("[45] f45_m1b: %f\n", f45_m1b);
    System.out.printf("[45] f45_p1b: %f\n", f45_p1b);
  }

  @Test public void testBoundsWithZero45()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero45(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero45(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero45(0.0f);
    final long k45_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 45);
    final long k45_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 45);
    final long k45_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 45);

    final float f45_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero45(k45_m1);
    final float f45_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero45(k45_p1);
    final float f45_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero45(k45_0);
    final float f45_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k45_m1, 45);
    final float f45_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k45_p1, 45);
    final float f45_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k45_0, 45);

    System.out.printf("[45] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[45] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[45] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[45] k45_m1: %s\n", Long.toString(k45_m1));
    System.out.printf("[45] k45_p1: %s\n", Long.toString(k45_p1));
    System.out.printf("[45] k45_0: %s\n", Long.toString(k45_0));
    System.out.printf("[45] f45_m1a: %f\n", f45_m1a);
    System.out.printf("[45] f45_p1a: %f\n", f45_p1a);
    System.out.printf("[45] f45_0a: %f\n", f45_0a);
    System.out.printf("[45] f45_m1b: %f\n", f45_m1b);
    System.out.printf("[45] f45_p1b: %f\n", f45_p1b);
    System.out.printf("[45] f45_0b: %f\n", f45_0b);
  }

  @Test public void testBoundsWithoutZero46()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero46(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero46(1.0f);
    final long k46_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 46);
    final long k46_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 46);

    final float f46_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero46(k46_m1);
    final float f46_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero46(k46_p1);
    final float f46_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k46_m1, 46);
    final float f46_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k46_p1, 46);

    System.out.printf("[46] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[46] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[46] k46_m1: %s\n", Long.toString(k46_m1));
    System.out.printf("[46] k46_p1: %s\n", Long.toString(k46_p1));
    System.out.printf("[46] f46_m1a: %f\n", f46_m1a);
    System.out.printf("[46] f46_p1a: %f\n", f46_p1a);
    System.out.printf("[46] f46_m1b: %f\n", f46_m1b);
    System.out.printf("[46] f46_p1b: %f\n", f46_p1b);
  }

  @Test public void testBoundsWithZero46()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero46(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero46(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero46(0.0f);
    final long k46_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 46);
    final long k46_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 46);
    final long k46_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 46);

    final float f46_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero46(k46_m1);
    final float f46_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero46(k46_p1);
    final float f46_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero46(k46_0);
    final float f46_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k46_m1, 46);
    final float f46_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k46_p1, 46);
    final float f46_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k46_0, 46);

    System.out.printf("[46] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[46] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[46] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[46] k46_m1: %s\n", Long.toString(k46_m1));
    System.out.printf("[46] k46_p1: %s\n", Long.toString(k46_p1));
    System.out.printf("[46] k46_0: %s\n", Long.toString(k46_0));
    System.out.printf("[46] f46_m1a: %f\n", f46_m1a);
    System.out.printf("[46] f46_p1a: %f\n", f46_p1a);
    System.out.printf("[46] f46_0a: %f\n", f46_0a);
    System.out.printf("[46] f46_m1b: %f\n", f46_m1b);
    System.out.printf("[46] f46_p1b: %f\n", f46_p1b);
    System.out.printf("[46] f46_0b: %f\n", f46_0b);
  }

  @Test public void testBoundsWithoutZero47()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero47(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero47(1.0f);
    final long k47_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 47);
    final long k47_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 47);

    final float f47_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero47(k47_m1);
    final float f47_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero47(k47_p1);
    final float f47_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k47_m1, 47);
    final float f47_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k47_p1, 47);

    System.out.printf("[47] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[47] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[47] k47_m1: %s\n", Long.toString(k47_m1));
    System.out.printf("[47] k47_p1: %s\n", Long.toString(k47_p1));
    System.out.printf("[47] f47_m1a: %f\n", f47_m1a);
    System.out.printf("[47] f47_p1a: %f\n", f47_p1a);
    System.out.printf("[47] f47_m1b: %f\n", f47_m1b);
    System.out.printf("[47] f47_p1b: %f\n", f47_p1b);
  }

  @Test public void testBoundsWithZero47()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero47(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero47(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero47(0.0f);
    final long k47_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 47);
    final long k47_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 47);
    final long k47_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 47);

    final float f47_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero47(k47_m1);
    final float f47_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero47(k47_p1);
    final float f47_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero47(k47_0);
    final float f47_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k47_m1, 47);
    final float f47_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k47_p1, 47);
    final float f47_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k47_0, 47);

    System.out.printf("[47] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[47] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[47] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[47] k47_m1: %s\n", Long.toString(k47_m1));
    System.out.printf("[47] k47_p1: %s\n", Long.toString(k47_p1));
    System.out.printf("[47] k47_0: %s\n", Long.toString(k47_0));
    System.out.printf("[47] f47_m1a: %f\n", f47_m1a);
    System.out.printf("[47] f47_p1a: %f\n", f47_p1a);
    System.out.printf("[47] f47_0a: %f\n", f47_0a);
    System.out.printf("[47] f47_m1b: %f\n", f47_m1b);
    System.out.printf("[47] f47_p1b: %f\n", f47_p1b);
    System.out.printf("[47] f47_0b: %f\n", f47_0b);
  }

  @Test public void testBoundsWithoutZero48()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero48(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero48(1.0f);
    final long k48_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 48);
    final long k48_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 48);

    final float f48_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero48(k48_m1);
    final float f48_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero48(k48_p1);
    final float f48_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k48_m1, 48);
    final float f48_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k48_p1, 48);

    System.out.printf("[48] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[48] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[48] k48_m1: %s\n", Long.toString(k48_m1));
    System.out.printf("[48] k48_p1: %s\n", Long.toString(k48_p1));
    System.out.printf("[48] f48_m1a: %f\n", f48_m1a);
    System.out.printf("[48] f48_p1a: %f\n", f48_p1a);
    System.out.printf("[48] f48_m1b: %f\n", f48_m1b);
    System.out.printf("[48] f48_p1b: %f\n", f48_p1b);
  }

  @Test public void testBoundsWithZero48()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero48(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero48(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero48(0.0f);
    final long k48_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 48);
    final long k48_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 48);
    final long k48_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 48);

    final float f48_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero48(k48_m1);
    final float f48_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero48(k48_p1);
    final float f48_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero48(k48_0);
    final float f48_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k48_m1, 48);
    final float f48_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k48_p1, 48);
    final float f48_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k48_0, 48);

    System.out.printf("[48] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[48] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[48] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[48] k48_m1: %s\n", Long.toString(k48_m1));
    System.out.printf("[48] k48_p1: %s\n", Long.toString(k48_p1));
    System.out.printf("[48] k48_0: %s\n", Long.toString(k48_0));
    System.out.printf("[48] f48_m1a: %f\n", f48_m1a);
    System.out.printf("[48] f48_p1a: %f\n", f48_p1a);
    System.out.printf("[48] f48_0a: %f\n", f48_0a);
    System.out.printf("[48] f48_m1b: %f\n", f48_m1b);
    System.out.printf("[48] f48_p1b: %f\n", f48_p1b);
    System.out.printf("[48] f48_0b: %f\n", f48_0b);
  }

  @Test public void testBoundsWithoutZero49()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero49(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero49(1.0f);
    final long k49_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 49);
    final long k49_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 49);

    final float f49_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero49(k49_m1);
    final float f49_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero49(k49_p1);
    final float f49_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k49_m1, 49);
    final float f49_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k49_p1, 49);

    System.out.printf("[49] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[49] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[49] k49_m1: %s\n", Long.toString(k49_m1));
    System.out.printf("[49] k49_p1: %s\n", Long.toString(k49_p1));
    System.out.printf("[49] f49_m1a: %f\n", f49_m1a);
    System.out.printf("[49] f49_p1a: %f\n", f49_p1a);
    System.out.printf("[49] f49_m1b: %f\n", f49_m1b);
    System.out.printf("[49] f49_p1b: %f\n", f49_p1b);
  }

  @Test public void testBoundsWithZero49()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero49(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero49(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero49(0.0f);
    final long k49_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 49);
    final long k49_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 49);
    final long k49_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 49);

    final float f49_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero49(k49_m1);
    final float f49_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero49(k49_p1);
    final float f49_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero49(k49_0);
    final float f49_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k49_m1, 49);
    final float f49_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k49_p1, 49);
    final float f49_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k49_0, 49);

    System.out.printf("[49] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[49] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[49] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[49] k49_m1: %s\n", Long.toString(k49_m1));
    System.out.printf("[49] k49_p1: %s\n", Long.toString(k49_p1));
    System.out.printf("[49] k49_0: %s\n", Long.toString(k49_0));
    System.out.printf("[49] f49_m1a: %f\n", f49_m1a);
    System.out.printf("[49] f49_p1a: %f\n", f49_p1a);
    System.out.printf("[49] f49_0a: %f\n", f49_0a);
    System.out.printf("[49] f49_m1b: %f\n", f49_m1b);
    System.out.printf("[49] f49_p1b: %f\n", f49_p1b);
    System.out.printf("[49] f49_0b: %f\n", f49_0b);
  }

  @Test public void testBoundsWithoutZero50()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero50(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero50(1.0f);
    final long k50_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 50);
    final long k50_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 50);

    final float f50_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero50(k50_m1);
    final float f50_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero50(k50_p1);
    final float f50_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k50_m1, 50);
    final float f50_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k50_p1, 50);

    System.out.printf("[50] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[50] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[50] k50_m1: %s\n", Long.toString(k50_m1));
    System.out.printf("[50] k50_p1: %s\n", Long.toString(k50_p1));
    System.out.printf("[50] f50_m1a: %f\n", f50_m1a);
    System.out.printf("[50] f50_p1a: %f\n", f50_p1a);
    System.out.printf("[50] f50_m1b: %f\n", f50_m1b);
    System.out.printf("[50] f50_p1b: %f\n", f50_p1b);
  }

  @Test public void testBoundsWithZero50()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero50(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero50(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero50(0.0f);
    final long k50_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 50);
    final long k50_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 50);
    final long k50_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 50);

    final float f50_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero50(k50_m1);
    final float f50_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero50(k50_p1);
    final float f50_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero50(k50_0);
    final float f50_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k50_m1, 50);
    final float f50_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k50_p1, 50);
    final float f50_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k50_0, 50);

    System.out.printf("[50] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[50] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[50] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[50] k50_m1: %s\n", Long.toString(k50_m1));
    System.out.printf("[50] k50_p1: %s\n", Long.toString(k50_p1));
    System.out.printf("[50] k50_0: %s\n", Long.toString(k50_0));
    System.out.printf("[50] f50_m1a: %f\n", f50_m1a);
    System.out.printf("[50] f50_p1a: %f\n", f50_p1a);
    System.out.printf("[50] f50_0a: %f\n", f50_0a);
    System.out.printf("[50] f50_m1b: %f\n", f50_m1b);
    System.out.printf("[50] f50_p1b: %f\n", f50_p1b);
    System.out.printf("[50] f50_0b: %f\n", f50_0b);
  }

  @Test public void testBoundsWithoutZero51()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero51(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero51(1.0f);
    final long k51_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 51);
    final long k51_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 51);

    final float f51_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero51(k51_m1);
    final float f51_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero51(k51_p1);
    final float f51_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k51_m1, 51);
    final float f51_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k51_p1, 51);

    System.out.printf("[51] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[51] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[51] k51_m1: %s\n", Long.toString(k51_m1));
    System.out.printf("[51] k51_p1: %s\n", Long.toString(k51_p1));
    System.out.printf("[51] f51_m1a: %f\n", f51_m1a);
    System.out.printf("[51] f51_p1a: %f\n", f51_p1a);
    System.out.printf("[51] f51_m1b: %f\n", f51_m1b);
    System.out.printf("[51] f51_p1b: %f\n", f51_p1b);
  }

  @Test public void testBoundsWithZero51()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero51(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero51(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero51(0.0f);
    final long k51_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 51);
    final long k51_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 51);
    final long k51_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 51);

    final float f51_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero51(k51_m1);
    final float f51_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero51(k51_p1);
    final float f51_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero51(k51_0);
    final float f51_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k51_m1, 51);
    final float f51_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k51_p1, 51);
    final float f51_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k51_0, 51);

    System.out.printf("[51] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[51] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[51] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[51] k51_m1: %s\n", Long.toString(k51_m1));
    System.out.printf("[51] k51_p1: %s\n", Long.toString(k51_p1));
    System.out.printf("[51] k51_0: %s\n", Long.toString(k51_0));
    System.out.printf("[51] f51_m1a: %f\n", f51_m1a);
    System.out.printf("[51] f51_p1a: %f\n", f51_p1a);
    System.out.printf("[51] f51_0a: %f\n", f51_0a);
    System.out.printf("[51] f51_m1b: %f\n", f51_m1b);
    System.out.printf("[51] f51_p1b: %f\n", f51_p1b);
    System.out.printf("[51] f51_0b: %f\n", f51_0b);
  }

  @Test public void testBoundsWithoutZero52()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero52(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero52(1.0f);
    final long k52_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 52);
    final long k52_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 52);

    final float f52_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero52(k52_m1);
    final float f52_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero52(k52_p1);
    final float f52_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k52_m1, 52);
    final float f52_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k52_p1, 52);

    System.out.printf("[52] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[52] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[52] k52_m1: %s\n", Long.toString(k52_m1));
    System.out.printf("[52] k52_p1: %s\n", Long.toString(k52_p1));
    System.out.printf("[52] f52_m1a: %f\n", f52_m1a);
    System.out.printf("[52] f52_p1a: %f\n", f52_p1a);
    System.out.printf("[52] f52_m1b: %f\n", f52_m1b);
    System.out.printf("[52] f52_p1b: %f\n", f52_p1b);
  }

  @Test public void testBoundsWithZero52()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero52(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero52(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero52(0.0f);
    final long k52_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 52);
    final long k52_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 52);
    final long k52_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 52);

    final float f52_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero52(k52_m1);
    final float f52_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero52(k52_p1);
    final float f52_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero52(k52_0);
    final float f52_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k52_m1, 52);
    final float f52_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k52_p1, 52);
    final float f52_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k52_0, 52);

    System.out.printf("[52] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[52] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[52] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[52] k52_m1: %s\n", Long.toString(k52_m1));
    System.out.printf("[52] k52_p1: %s\n", Long.toString(k52_p1));
    System.out.printf("[52] k52_0: %s\n", Long.toString(k52_0));
    System.out.printf("[52] f52_m1a: %f\n", f52_m1a);
    System.out.printf("[52] f52_p1a: %f\n", f52_p1a);
    System.out.printf("[52] f52_0a: %f\n", f52_0a);
    System.out.printf("[52] f52_m1b: %f\n", f52_m1b);
    System.out.printf("[52] f52_p1b: %f\n", f52_p1b);
    System.out.printf("[52] f52_0b: %f\n", f52_0b);
  }

  @Test public void testBoundsWithoutZero53()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero53(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero53(1.0f);
    final long k53_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 53);
    final long k53_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 53);

    final float f53_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero53(k53_m1);
    final float f53_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero53(k53_p1);
    final float f53_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k53_m1, 53);
    final float f53_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k53_p1, 53);

    System.out.printf("[53] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[53] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[53] k53_m1: %s\n", Long.toString(k53_m1));
    System.out.printf("[53] k53_p1: %s\n", Long.toString(k53_p1));
    System.out.printf("[53] f53_m1a: %f\n", f53_m1a);
    System.out.printf("[53] f53_p1a: %f\n", f53_p1a);
    System.out.printf("[53] f53_m1b: %f\n", f53_m1b);
    System.out.printf("[53] f53_p1b: %f\n", f53_p1b);
  }

  @Test public void testBoundsWithZero53()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero53(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero53(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero53(0.0f);
    final long k53_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 53);
    final long k53_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 53);
    final long k53_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 53);

    final float f53_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero53(k53_m1);
    final float f53_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero53(k53_p1);
    final float f53_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero53(k53_0);
    final float f53_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k53_m1, 53);
    final float f53_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k53_p1, 53);
    final float f53_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k53_0, 53);

    System.out.printf("[53] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[53] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[53] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[53] k53_m1: %s\n", Long.toString(k53_m1));
    System.out.printf("[53] k53_p1: %s\n", Long.toString(k53_p1));
    System.out.printf("[53] k53_0: %s\n", Long.toString(k53_0));
    System.out.printf("[53] f53_m1a: %f\n", f53_m1a);
    System.out.printf("[53] f53_p1a: %f\n", f53_p1a);
    System.out.printf("[53] f53_0a: %f\n", f53_0a);
    System.out.printf("[53] f53_m1b: %f\n", f53_m1b);
    System.out.printf("[53] f53_p1b: %f\n", f53_p1b);
    System.out.printf("[53] f53_0b: %f\n", f53_0b);
  }

  @Test public void testBoundsWithoutZero54()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero54(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero54(1.0f);
    final long k54_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 54);
    final long k54_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 54);

    final float f54_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero54(k54_m1);
    final float f54_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero54(k54_p1);
    final float f54_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k54_m1, 54);
    final float f54_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k54_p1, 54);

    System.out.printf("[54] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[54] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[54] k54_m1: %s\n", Long.toString(k54_m1));
    System.out.printf("[54] k54_p1: %s\n", Long.toString(k54_p1));
    System.out.printf("[54] f54_m1a: %f\n", f54_m1a);
    System.out.printf("[54] f54_p1a: %f\n", f54_p1a);
    System.out.printf("[54] f54_m1b: %f\n", f54_m1b);
    System.out.printf("[54] f54_p1b: %f\n", f54_p1b);
  }

  @Test public void testBoundsWithZero54()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero54(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero54(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero54(0.0f);
    final long k54_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 54);
    final long k54_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 54);
    final long k54_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 54);

    final float f54_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero54(k54_m1);
    final float f54_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero54(k54_p1);
    final float f54_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero54(k54_0);
    final float f54_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k54_m1, 54);
    final float f54_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k54_p1, 54);
    final float f54_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k54_0, 54);

    System.out.printf("[54] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[54] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[54] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[54] k54_m1: %s\n", Long.toString(k54_m1));
    System.out.printf("[54] k54_p1: %s\n", Long.toString(k54_p1));
    System.out.printf("[54] k54_0: %s\n", Long.toString(k54_0));
    System.out.printf("[54] f54_m1a: %f\n", f54_m1a);
    System.out.printf("[54] f54_p1a: %f\n", f54_p1a);
    System.out.printf("[54] f54_0a: %f\n", f54_0a);
    System.out.printf("[54] f54_m1b: %f\n", f54_m1b);
    System.out.printf("[54] f54_p1b: %f\n", f54_p1b);
    System.out.printf("[54] f54_0b: %f\n", f54_0b);
  }

  @Test public void testBoundsWithoutZero55()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero55(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero55(1.0f);
    final long k55_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 55);
    final long k55_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 55);

    final float f55_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero55(k55_m1);
    final float f55_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero55(k55_p1);
    final float f55_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k55_m1, 55);
    final float f55_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k55_p1, 55);

    System.out.printf("[55] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[55] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[55] k55_m1: %s\n", Long.toString(k55_m1));
    System.out.printf("[55] k55_p1: %s\n", Long.toString(k55_p1));
    System.out.printf("[55] f55_m1a: %f\n", f55_m1a);
    System.out.printf("[55] f55_p1a: %f\n", f55_p1a);
    System.out.printf("[55] f55_m1b: %f\n", f55_m1b);
    System.out.printf("[55] f55_p1b: %f\n", f55_p1b);
  }

  @Test public void testBoundsWithZero55()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero55(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero55(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero55(0.0f);
    final long k55_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 55);
    final long k55_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 55);
    final long k55_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 55);

    final float f55_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero55(k55_m1);
    final float f55_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero55(k55_p1);
    final float f55_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero55(k55_0);
    final float f55_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k55_m1, 55);
    final float f55_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k55_p1, 55);
    final float f55_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k55_0, 55);

    System.out.printf("[55] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[55] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[55] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[55] k55_m1: %s\n", Long.toString(k55_m1));
    System.out.printf("[55] k55_p1: %s\n", Long.toString(k55_p1));
    System.out.printf("[55] k55_0: %s\n", Long.toString(k55_0));
    System.out.printf("[55] f55_m1a: %f\n", f55_m1a);
    System.out.printf("[55] f55_p1a: %f\n", f55_p1a);
    System.out.printf("[55] f55_0a: %f\n", f55_0a);
    System.out.printf("[55] f55_m1b: %f\n", f55_m1b);
    System.out.printf("[55] f55_p1b: %f\n", f55_p1b);
    System.out.printf("[55] f55_0b: %f\n", f55_0b);
  }

  @Test public void testBoundsWithoutZero56()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero56(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero56(1.0f);
    final long k56_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 56);
    final long k56_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 56);

    final float f56_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero56(k56_m1);
    final float f56_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero56(k56_p1);
    final float f56_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k56_m1, 56);
    final float f56_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k56_p1, 56);

    System.out.printf("[56] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[56] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[56] k56_m1: %s\n", Long.toString(k56_m1));
    System.out.printf("[56] k56_p1: %s\n", Long.toString(k56_p1));
    System.out.printf("[56] f56_m1a: %f\n", f56_m1a);
    System.out.printf("[56] f56_p1a: %f\n", f56_p1a);
    System.out.printf("[56] f56_m1b: %f\n", f56_m1b);
    System.out.printf("[56] f56_p1b: %f\n", f56_p1b);
  }

  @Test public void testBoundsWithZero56()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero56(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero56(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero56(0.0f);
    final long k56_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 56);
    final long k56_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 56);
    final long k56_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 56);

    final float f56_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero56(k56_m1);
    final float f56_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero56(k56_p1);
    final float f56_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero56(k56_0);
    final float f56_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k56_m1, 56);
    final float f56_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k56_p1, 56);
    final float f56_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k56_0, 56);

    System.out.printf("[56] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[56] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[56] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[56] k56_m1: %s\n", Long.toString(k56_m1));
    System.out.printf("[56] k56_p1: %s\n", Long.toString(k56_p1));
    System.out.printf("[56] k56_0: %s\n", Long.toString(k56_0));
    System.out.printf("[56] f56_m1a: %f\n", f56_m1a);
    System.out.printf("[56] f56_p1a: %f\n", f56_p1a);
    System.out.printf("[56] f56_0a: %f\n", f56_0a);
    System.out.printf("[56] f56_m1b: %f\n", f56_m1b);
    System.out.printf("[56] f56_p1b: %f\n", f56_p1b);
    System.out.printf("[56] f56_0b: %f\n", f56_0b);
  }

  @Test public void testBoundsWithoutZero57()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero57(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero57(1.0f);
    final long k57_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 57);
    final long k57_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 57);

    final float f57_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero57(k57_m1);
    final float f57_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero57(k57_p1);
    final float f57_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k57_m1, 57);
    final float f57_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k57_p1, 57);

    System.out.printf("[57] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[57] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[57] k57_m1: %s\n", Long.toString(k57_m1));
    System.out.printf("[57] k57_p1: %s\n", Long.toString(k57_p1));
    System.out.printf("[57] f57_m1a: %f\n", f57_m1a);
    System.out.printf("[57] f57_p1a: %f\n", f57_p1a);
    System.out.printf("[57] f57_m1b: %f\n", f57_m1b);
    System.out.printf("[57] f57_p1b: %f\n", f57_p1b);
  }

  @Test public void testBoundsWithZero57()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero57(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero57(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero57(0.0f);
    final long k57_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 57);
    final long k57_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 57);
    final long k57_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 57);

    final float f57_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero57(k57_m1);
    final float f57_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero57(k57_p1);
    final float f57_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero57(k57_0);
    final float f57_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k57_m1, 57);
    final float f57_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k57_p1, 57);
    final float f57_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k57_0, 57);

    System.out.printf("[57] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[57] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[57] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[57] k57_m1: %s\n", Long.toString(k57_m1));
    System.out.printf("[57] k57_p1: %s\n", Long.toString(k57_p1));
    System.out.printf("[57] k57_0: %s\n", Long.toString(k57_0));
    System.out.printf("[57] f57_m1a: %f\n", f57_m1a);
    System.out.printf("[57] f57_p1a: %f\n", f57_p1a);
    System.out.printf("[57] f57_0a: %f\n", f57_0a);
    System.out.printf("[57] f57_m1b: %f\n", f57_m1b);
    System.out.printf("[57] f57_p1b: %f\n", f57_p1b);
    System.out.printf("[57] f57_0b: %f\n", f57_0b);
  }

  @Test public void testBoundsWithoutZero58()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero58(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero58(1.0f);
    final long k58_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 58);
    final long k58_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 58);

    final float f58_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero58(k58_m1);
    final float f58_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero58(k58_p1);
    final float f58_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k58_m1, 58);
    final float f58_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k58_p1, 58);

    System.out.printf("[58] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[58] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[58] k58_m1: %s\n", Long.toString(k58_m1));
    System.out.printf("[58] k58_p1: %s\n", Long.toString(k58_p1));
    System.out.printf("[58] f58_m1a: %f\n", f58_m1a);
    System.out.printf("[58] f58_p1a: %f\n", f58_p1a);
    System.out.printf("[58] f58_m1b: %f\n", f58_m1b);
    System.out.printf("[58] f58_p1b: %f\n", f58_p1b);
  }

  @Test public void testBoundsWithZero58()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero58(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero58(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero58(0.0f);
    final long k58_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 58);
    final long k58_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 58);
    final long k58_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 58);

    final float f58_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero58(k58_m1);
    final float f58_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero58(k58_p1);
    final float f58_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero58(k58_0);
    final float f58_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k58_m1, 58);
    final float f58_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k58_p1, 58);
    final float f58_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k58_0, 58);

    System.out.printf("[58] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[58] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[58] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[58] k58_m1: %s\n", Long.toString(k58_m1));
    System.out.printf("[58] k58_p1: %s\n", Long.toString(k58_p1));
    System.out.printf("[58] k58_0: %s\n", Long.toString(k58_0));
    System.out.printf("[58] f58_m1a: %f\n", f58_m1a);
    System.out.printf("[58] f58_p1a: %f\n", f58_p1a);
    System.out.printf("[58] f58_0a: %f\n", f58_0a);
    System.out.printf("[58] f58_m1b: %f\n", f58_m1b);
    System.out.printf("[58] f58_p1b: %f\n", f58_p1b);
    System.out.printf("[58] f58_0b: %f\n", f58_0b);
  }

  @Test public void testBoundsWithoutZero59()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero59(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero59(1.0f);
    final long k59_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 59);
    final long k59_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 59);

    final float f59_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero59(k59_m1);
    final float f59_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero59(k59_p1);
    final float f59_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k59_m1, 59);
    final float f59_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k59_p1, 59);

    System.out.printf("[59] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[59] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[59] k59_m1: %s\n", Long.toString(k59_m1));
    System.out.printf("[59] k59_p1: %s\n", Long.toString(k59_p1));
    System.out.printf("[59] f59_m1a: %f\n", f59_m1a);
    System.out.printf("[59] f59_p1a: %f\n", f59_p1a);
    System.out.printf("[59] f59_m1b: %f\n", f59_m1b);
    System.out.printf("[59] f59_p1b: %f\n", f59_p1b);
  }

  @Test public void testBoundsWithZero59()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero59(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero59(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero59(0.0f);
    final long k59_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 59);
    final long k59_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 59);
    final long k59_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 59);

    final float f59_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero59(k59_m1);
    final float f59_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero59(k59_p1);
    final float f59_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero59(k59_0);
    final float f59_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k59_m1, 59);
    final float f59_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k59_p1, 59);
    final float f59_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k59_0, 59);

    System.out.printf("[59] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[59] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[59] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[59] k59_m1: %s\n", Long.toString(k59_m1));
    System.out.printf("[59] k59_p1: %s\n", Long.toString(k59_p1));
    System.out.printf("[59] k59_0: %s\n", Long.toString(k59_0));
    System.out.printf("[59] f59_m1a: %f\n", f59_m1a);
    System.out.printf("[59] f59_p1a: %f\n", f59_p1a);
    System.out.printf("[59] f59_0a: %f\n", f59_0a);
    System.out.printf("[59] f59_m1b: %f\n", f59_m1b);
    System.out.printf("[59] f59_p1b: %f\n", f59_p1b);
    System.out.printf("[59] f59_0b: %f\n", f59_0b);
  }

  @Test public void testBoundsWithoutZero60()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero60(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero60(1.0f);
    final long k60_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 60);
    final long k60_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 60);

    final float f60_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero60(k60_m1);
    final float f60_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero60(k60_p1);
    final float f60_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k60_m1, 60);
    final float f60_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k60_p1, 60);

    System.out.printf("[60] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[60] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[60] k60_m1: %s\n", Long.toString(k60_m1));
    System.out.printf("[60] k60_p1: %s\n", Long.toString(k60_p1));
    System.out.printf("[60] f60_m1a: %f\n", f60_m1a);
    System.out.printf("[60] f60_p1a: %f\n", f60_p1a);
    System.out.printf("[60] f60_m1b: %f\n", f60_m1b);
    System.out.printf("[60] f60_p1b: %f\n", f60_p1b);
  }

  @Test public void testBoundsWithZero60()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero60(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero60(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero60(0.0f);
    final long k60_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 60);
    final long k60_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 60);
    final long k60_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 60);

    final float f60_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero60(k60_m1);
    final float f60_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero60(k60_p1);
    final float f60_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero60(k60_0);
    final float f60_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k60_m1, 60);
    final float f60_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k60_p1, 60);
    final float f60_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k60_0, 60);

    System.out.printf("[60] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[60] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[60] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[60] k60_m1: %s\n", Long.toString(k60_m1));
    System.out.printf("[60] k60_p1: %s\n", Long.toString(k60_p1));
    System.out.printf("[60] k60_0: %s\n", Long.toString(k60_0));
    System.out.printf("[60] f60_m1a: %f\n", f60_m1a);
    System.out.printf("[60] f60_p1a: %f\n", f60_p1a);
    System.out.printf("[60] f60_0a: %f\n", f60_0a);
    System.out.printf("[60] f60_m1b: %f\n", f60_m1b);
    System.out.printf("[60] f60_p1b: %f\n", f60_p1b);
    System.out.printf("[60] f60_0b: %f\n", f60_0b);
  }

  @Test public void testBoundsWithoutZero61()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero61(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero61(1.0f);
    final long k61_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 61);
    final long k61_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 61);

    final float f61_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero61(k61_m1);
    final float f61_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero61(k61_p1);
    final float f61_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k61_m1, 61);
    final float f61_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k61_p1, 61);

    System.out.printf("[61] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[61] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[61] k61_m1: %s\n", Long.toString(k61_m1));
    System.out.printf("[61] k61_p1: %s\n", Long.toString(k61_p1));
    System.out.printf("[61] f61_m1a: %f\n", f61_m1a);
    System.out.printf("[61] f61_p1a: %f\n", f61_p1a);
    System.out.printf("[61] f61_m1b: %f\n", f61_m1b);
    System.out.printf("[61] f61_p1b: %f\n", f61_p1b);
  }

  @Test public void testBoundsWithZero61()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero61(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero61(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero61(0.0f);
    final long k61_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 61);
    final long k61_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 61);
    final long k61_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 61);

    final float f61_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero61(k61_m1);
    final float f61_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero61(k61_p1);
    final float f61_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero61(k61_0);
    final float f61_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k61_m1, 61);
    final float f61_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k61_p1, 61);
    final float f61_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k61_0, 61);

    System.out.printf("[61] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[61] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[61] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[61] k61_m1: %s\n", Long.toString(k61_m1));
    System.out.printf("[61] k61_p1: %s\n", Long.toString(k61_p1));
    System.out.printf("[61] k61_0: %s\n", Long.toString(k61_0));
    System.out.printf("[61] f61_m1a: %f\n", f61_m1a);
    System.out.printf("[61] f61_p1a: %f\n", f61_p1a);
    System.out.printf("[61] f61_0a: %f\n", f61_0a);
    System.out.printf("[61] f61_m1b: %f\n", f61_m1b);
    System.out.printf("[61] f61_p1b: %f\n", f61_p1b);
    System.out.printf("[61] f61_0b: %f\n", f61_0b);
  }

  @Test public void testBoundsWithoutZero62()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero62(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero62(1.0f);
    final long k62_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 62);
    final long k62_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 62);

    final float f62_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero62(k62_m1);
    final float f62_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero62(k62_p1);
    final float f62_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k62_m1, 62);
    final float f62_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k62_p1, 62);

    System.out.printf("[62] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[62] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[62] k62_m1: %s\n", Long.toString(k62_m1));
    System.out.printf("[62] k62_p1: %s\n", Long.toString(k62_p1));
    System.out.printf("[62] f62_m1a: %f\n", f62_m1a);
    System.out.printf("[62] f62_p1a: %f\n", f62_p1a);
    System.out.printf("[62] f62_m1b: %f\n", f62_m1b);
    System.out.printf("[62] f62_p1b: %f\n", f62_p1b);
  }

  @Test public void testBoundsWithZero62()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero62(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero62(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero62(0.0f);
    final long k62_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 62);
    final long k62_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 62);
    final long k62_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 62);

    final float f62_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero62(k62_m1);
    final float f62_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero62(k62_p1);
    final float f62_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero62(k62_0);
    final float f62_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k62_m1, 62);
    final float f62_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k62_p1, 62);
    final float f62_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k62_0, 62);

    System.out.printf("[62] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[62] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[62] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[62] k62_m1: %s\n", Long.toString(k62_m1));
    System.out.printf("[62] k62_p1: %s\n", Long.toString(k62_p1));
    System.out.printf("[62] k62_0: %s\n", Long.toString(k62_0));
    System.out.printf("[62] f62_m1a: %f\n", f62_m1a);
    System.out.printf("[62] f62_p1a: %f\n", f62_p1a);
    System.out.printf("[62] f62_0a: %f\n", f62_0a);
    System.out.printf("[62] f62_m1b: %f\n", f62_m1b);
    System.out.printf("[62] f62_p1b: %f\n", f62_p1b);
    System.out.printf("[62] f62_0b: %f\n", f62_0b);
  }

  @Test public void testBoundsWithoutZero63()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero63(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero63(1.0f);
    final long k63_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 63);
    final long k63_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 63);

    final float f63_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero63(k63_m1);
    final float f63_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero63(k63_p1);
    final float f63_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k63_m1, 63);
    final float f63_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k63_p1, 63);

    System.out.printf("[63] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[63] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[63] k63_m1: %s\n", Long.toString(k63_m1));
    System.out.printf("[63] k63_p1: %s\n", Long.toString(k63_p1));
    System.out.printf("[63] f63_m1a: %f\n", f63_m1a);
    System.out.printf("[63] f63_p1a: %f\n", f63_p1a);
    System.out.printf("[63] f63_m1b: %f\n", f63_m1b);
    System.out.printf("[63] f63_p1b: %f\n", f63_p1b);
  }

  @Test public void testBoundsWithZero63()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero63(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero63(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero63(0.0f);
    final long k63_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 63);
    final long k63_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 63);
    final long k63_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 63);

    final float f63_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero63(k63_m1);
    final float f63_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero63(k63_p1);
    final float f63_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero63(k63_0);
    final float f63_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k63_m1, 63);
    final float f63_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k63_p1, 63);
    final float f63_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k63_0, 63);

    System.out.printf("[63] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[63] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[63] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[63] k63_m1: %s\n", Long.toString(k63_m1));
    System.out.printf("[63] k63_p1: %s\n", Long.toString(k63_p1));
    System.out.printf("[63] k63_0: %s\n", Long.toString(k63_0));
    System.out.printf("[63] f63_m1a: %f\n", f63_m1a);
    System.out.printf("[63] f63_p1a: %f\n", f63_p1a);
    System.out.printf("[63] f63_0a: %f\n", f63_0a);
    System.out.printf("[63] f63_m1b: %f\n", f63_m1b);
    System.out.printf("[63] f63_p1b: %f\n", f63_p1b);
    System.out.printf("[63] f63_0b: %f\n", f63_0b);
  }

  @Test public void testBoundsWithoutZero64()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero64(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithoutZero64(1.0f);
    final long k64_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, 64);
    final long k64_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, 64);

    final float f64_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero64(k64_m1);
    final float f64_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero64(k64_p1);
    final float f64_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k64_m1, 64);
    final float f64_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k64_p1, 64);

    System.out.printf("[64] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[64] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[64] k64_m1: %s\n", Long.toString(k64_m1));
    System.out.printf("[64] k64_p1: %s\n", Long.toString(k64_p1));
    System.out.printf("[64] f64_m1a: %f\n", f64_m1a);
    System.out.printf("[64] f64_p1a: %f\n", f64_p1a);
    System.out.printf("[64] f64_m1b: %f\n", f64_m1b);
    System.out.printf("[64] f64_p1b: %f\n", f64_p1b);
  }

  @Test public void testBoundsWithZero64()
  {
    final long k_m1 = NFPSignedFloatLong.toSignedNormalizedWithZero64(-1.0f);
    final long k_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero64(1.0f);
    final long k_0 = NFPSignedFloatLong.toSignedNormalizedWithZero64(0.0f);
    final long k64_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, 64);
    final long k64_p1 = NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, 64);
    final long k64_0 = NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, 64);

    final float f64_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero64(k64_m1);
    final float f64_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero64(k64_p1);
    final float f64_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero64(k64_0);
    final float f64_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k64_m1, 64);
    final float f64_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k64_p1, 64);
    final float f64_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k64_0, 64);

    System.out.printf("[64] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[64] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[64] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[64] k64_m1: %s\n", Long.toString(k64_m1));
    System.out.printf("[64] k64_p1: %s\n", Long.toString(k64_p1));
    System.out.printf("[64] k64_0: %s\n", Long.toString(k64_0));
    System.out.printf("[64] f64_m1a: %f\n", f64_m1a);
    System.out.printf("[64] f64_p1a: %f\n", f64_p1a);
    System.out.printf("[64] f64_0a: %f\n", f64_0a);
    System.out.printf("[64] f64_m1b: %f\n", f64_m1b);
    System.out.printf("[64] f64_p1b: %f\n", f64_p1b);
    System.out.printf("[64] f64_0b: %f\n", f64_0b);
  }
}
