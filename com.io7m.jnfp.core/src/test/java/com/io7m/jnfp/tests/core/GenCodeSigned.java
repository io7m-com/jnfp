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

import com.io7m.junreachable.UnreachableCodeException;
import org.junit.Test;
import org.stringtemplate.v4.ST;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;

public final class GenCodeSigned
{
  private static ST getStringTemplate(final String name)
  {
    try {
      final ByteArrayOutputStream bao = new ByteArrayOutputStream(8192);
      final byte[] data = new byte[8192];
      try (final InputStream s = GenCodeSigned.class.getResourceAsStream(name)) {
        for (; ; ) {
          final int r = s.read(data);
          if (r == -1) {
            break;
          }
          bao.write(data, 0, r);
        }

        return new ST(bao.toString("UTF-8"), '$', '$');
      }
    } catch (final IOException e) {
      throw new UnreachableCodeException(e);
    }
  }

  private static void makeConstantInt(final int e)
  {
    final StringBuilder sb = new StringBuilder(64);
    sb.setLength(0);
    sb.append("0b");
    for (int index = 0; index < e; ++index) {
      sb.append("1");
    }

    System.out.printf(
      "TWO_P%d_M1 = %s%s; // (2 ^ %d) - 1\n",
      Integer.valueOf(e),
      sb.toString(),
      (e > 32) ? "L" : "",
      Integer.valueOf(e));
  }

  private static void makeConstantFloat(final int e)
  {
    final BigDecimal bd =
      BigDecimal.valueOf(2L).pow(e).subtract(BigDecimal.ONE);

    System.out.printf(
      "TWO_P%d_M1F = %s.0f; // (2 ^ %d) - 1\n",
      Integer.valueOf(e),
      bd.toString(),
      Integer.valueOf(e));
  }

  private static void makeConstantDouble(final int e)
  {
    final BigDecimal bd =
      BigDecimal.valueOf(2L).pow(e).subtract(BigDecimal.ONE);

    System.out.printf(
      "TWO_P%d_M1D = %s.0; // (2 ^ %d) - 1\n",
      Integer.valueOf(e),
      bd.toString(),
      Integer.valueOf(e));
  }

  @Test public void makeConstants()
  {
    for (int e = 2; e <= 64; ++e) {
      if (e <= 32) {
        System.out.printf(
          "private static final int TWO_P%d_M1;\n", Integer.valueOf(e));
      } else {
        System.out.printf(
          "private static final long TWO_P%d_M1;\n", Integer.valueOf(e));
      }
    }

    System.out.println();
    System.out.printf("static {\n");

    for (int e = 2; e <= 64; ++e) {
      GenCodeSigned.makeConstantInt(e);
    }

    System.out.printf("}\n");
  }

  @Test public void makeDoubleLongConstants()
  {
    for (int e = 1; e <= 64; ++e) {
      System.out.printf(
        "private static final double TWO_P%d_M1D;\n", Integer.valueOf(e));
    }

    System.out.println();
    System.out.printf("static {\n");

    for (int e = 1; e <= 64; ++e) {
      GenCodeSigned.makeConstantDouble(e);
    }

    System.out.printf("}\n");
  }

  @Test public void makeDoubleLongCode()
  {
    {
      final ST st = GenCodeSigned.getStringTemplate(
        "toSignedNormalized_DoubleLong.st");

      for (int e = 2; e <= 64; ++e) {
        st.remove("bits");
        st.remove("bits_m1");
        st.add("bits", e);
        st.add("bits_m1", e - 1);
        System.out.println(st.render());
      }
    }

    {
      final ST st = GenCodeSigned.getStringTemplate(
        "fromSignedNormalized_DoubleLong.st");

      for (int e = 2; e <= 64; ++e) {
        st.remove("bits");
        st.remove("bits_m1");
        st.add("bits", e);
        st.add("bits_m1", e - 1);
        System.out.println(st.render());
      }
    }
  }

  @Test public void makeDoubleLongTest()
  {
    final ST st = GenCodeSigned.getStringTemplate(
      "test_SignedDoubleLong.st");

    for (int e = 2; e <= 64; ++e) {
      st.remove("bits");
      st.remove("bits_m1");
      st.add("bits", e);
      st.add("bits_m1", e - 1);
      System.out.println(st.render());
    }
  }




















  @Test public void makeFloatLongConstants()
  {
    for (int e = 1; e <= 64; ++e) {
      System.out.printf(
        "private static final float TWO_P%d_M1F;\n", Integer.valueOf(e));
    }

    System.out.println();
    System.out.printf("static {\n");

    for (int e = 1; e <= 64; ++e) {
      GenCodeSigned.makeConstantFloat(e);
    }

    System.out.printf("}\n");
  }

  @Test public void makeFloatLongCode()
  {
    {
      final ST st = GenCodeSigned.getStringTemplate(
        "toSignedNormalized_FloatLong.st");

      for (int e = 2; e <= 64; ++e) {
        st.remove("bits");
        st.remove("bits_m1");
        st.add("bits", e);
        st.add("bits_m1", e - 1);
        System.out.println(st.render());
      }
    }

    {
      final ST st = GenCodeSigned.getStringTemplate(
        "fromSignedNormalized_FloatLong.st");

      for (int e = 2; e <= 64; ++e) {
        st.remove("bits");
        st.remove("bits_m1");
        st.add("bits", e);
        st.add("bits_m1", e - 1);
        System.out.println(st.render());
      }
    }
  }

  @Test public void makeFloatLongTest()
  {
    final ST st = GenCodeSigned.getStringTemplate(
      "test_SignedFloatLong.st");

    for (int e = 2; e <= 64; ++e) {
      st.remove("bits");
      st.remove("bits_m1");
      st.add("bits", e);
      st.add("bits_m1", e - 1);
      System.out.println(st.render());
    }
  }












  @Test public void makeDoubleIntConstants()
  {
    for (int e = 1; e <= 32; ++e) {
      System.out.printf(
        "private static final double TWO_P%d_M1D;\n", Integer.valueOf(e));
    }

    System.out.println();
    System.out.printf("static {\n");

    for (int e = 1; e <= 32; ++e) {
      GenCodeSigned.makeConstantDouble(e);
    }

    System.out.printf("}\n");
  }

  @Test public void makeDoubleIntCode()
  {
    {
      final ST st = GenCodeSigned.getStringTemplate(
        "toSignedNormalized_DoubleInt.st");

      for (int e = 2; e <= 32; ++e) {
        st.remove("bits");
        st.remove("bits_m1");
        st.add("bits", e);
        st.add("bits_m1", e - 1);
        System.out.println(st.render());
      }
    }

    {
      final ST st = GenCodeSigned.getStringTemplate(
        "fromSignedNormalized_DoubleInt.st");

      for (int e = 2; e <= 32; ++e) {
        st.remove("bits");
        st.remove("bits_m1");
        st.add("bits", e);
        st.add("bits_m1", e - 1);
        System.out.println(st.render());
      }
    }
  }

  @Test public void makeDoubleIntTest()
  {
    final ST st = GenCodeSigned.getStringTemplate(
      "test_SignedDoubleInt.st");

    for (int e = 2; e <= 32; ++e) {
      st.remove("bits");
      st.remove("bits_m1");
      st.add("bits", e);
      st.add("bits_m1", e - 1);
      System.out.println(st.render());
    }
  }








  @Test public void makeFloatIntConstants()
  {
    for (int e = 1; e <= 32; ++e) {
      System.out.printf(
        "private static final float TWO_P%d_M1F;\n", Integer.valueOf(e));
    }

    System.out.println();
    System.out.printf("static {\n");

    for (int e = 1; e <= 32; ++e) {
      GenCodeSigned.makeConstantFloat(e);
    }

    System.out.printf("}\n");
  }

  @Test public void makeFloatIntCode()
  {
    {
      final ST st = GenCodeSigned.getStringTemplate(
        "toSignedNormalized_FloatInt.st");

      for (int e = 2; e <= 32; ++e) {
        st.remove("bits");
        st.remove("bits_m1");
        st.add("bits", e);
        st.add("bits_m1", e - 1);
        System.out.println(st.render());
      }
    }

    {
      final ST st = GenCodeSigned.getStringTemplate(
        "fromSignedNormalized_FloatInt.st");

      for (int e = 2; e <= 32; ++e) {
        st.remove("bits");
        st.remove("bits_m1");
        st.add("bits", e);
        st.add("bits_m1", e - 1);
        System.out.println(st.render());
      }
    }
  }

  @Test public void makeFloatIntTest()
  {
    final ST st = GenCodeSigned.getStringTemplate(
      "test_SignedFloatInt.st");

    for (int e = 2; e <= 32; ++e) {
      st.remove("bits");
      st.remove("bits_m1");
      st.add("bits", e);
      st.add("bits_m1", e - 1);
      System.out.println(st.render());
    }
  }
}
