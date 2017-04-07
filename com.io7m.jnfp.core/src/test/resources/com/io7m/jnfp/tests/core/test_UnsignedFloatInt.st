  @Test public void testBounds$bits$()
  {
    final int k0 =
      NFPUnsignedFloatInt.toUnsignedNormalized(0.0f, $bits$);
    final int k1 =
      NFPUnsignedFloatInt.toUnsignedNormalized(1.0f, $bits$);
    final int k$bits$_0 =
      NFPUnsignedFloatInt.toUnsignedNormalized$bits$(0.0f);
    final int k$bits$_1 =
      NFPUnsignedFloatInt.toUnsignedNormalized$bits$(1.0f);

    final float f$bits$_0a =
      NFPUnsignedFloatInt.fromUnsignedNormalized$bits$(k$bits$_0);
    final float f$bits$_1a =
      NFPUnsignedFloatInt.fromUnsignedNormalized$bits$(k$bits$_1);
    final float f$bits$_0b =
      NFPUnsignedFloatInt.fromUnsignedNormalized(k$bits$_0, $bits$);
    final float f$bits$_1b =
      NFPUnsignedFloatInt.fromUnsignedNormalized(k$bits$_1, $bits$);

    System.out.printf("[$bits$] k0: %s\n", Integer.toUnsignedString(k0));
    System.out.printf("[$bits$] k1: %s\n", Integer.toUnsignedString(k1));
    System.out.printf("[$bits$] k$bits$_0: %s\n", Integer.toUnsignedString(k$bits$_0));
    System.out.printf("[$bits$] k$bits$_1: %s\n", Integer.toUnsignedString(k$bits$_1));
    System.out.printf("[$bits$] f$bits$_0a: %f\n", f$bits$_0a);
    System.out.printf("[$bits$] f$bits$_1a: %f\n", f$bits$_1a);
    System.out.printf("[$bits$] f$bits$_0b: %f\n", f$bits$_0b);
    System.out.printf("[$bits$] f$bits$_1b: %f\n", f$bits$_1b);

    Assert.assertEquals(k$bits$_0, k0);
    Assert.assertEquals(k$bits$_1, k1);
    Assert.assertEquals(f$bits$_0a, 0.0, 0.0);
    Assert.assertEquals(f$bits$_1a, 1.0, 0.0);
    Assert.assertEquals(f$bits$_0b, 0.0, 0.0);
    Assert.assertEquals(f$bits$_1b, 1.0, 0.0);
    Assert.assertEquals(f$bits$_0a, f$bits$_0b, 0.0);
    Assert.assertEquals(f$bits$_1a, f$bits$_1b, 0.0);
  }
