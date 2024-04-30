  @Test public void testBounds$bits$()
  {
    final long k0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(0.0, $bits$);
    final long k1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized(1.0, $bits$);
    final long k$bits$_0 =
      NFPUnsignedDoubleLong.toUnsignedNormalized$bits$(0.0);
    final long k$bits$_1 =
      NFPUnsignedDoubleLong.toUnsignedNormalized$bits$(1.0);

    final double f$bits$_0a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized$bits$(k$bits$_0);
    final double f$bits$_1a =
      NFPUnsignedDoubleLong.fromUnsignedNormalized$bits$(k$bits$_1);
    final double f$bits$_0b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k$bits$_0, $bits$);
    final double f$bits$_1b =
      NFPUnsignedDoubleLong.fromUnsignedNormalized(k$bits$_1, $bits$);

    System.out.printf("[$bits$] k0: %s\n", Long.toUnsignedString(k0));
    System.out.printf("[$bits$] k1: %s\n", Long.toUnsignedString(k1));
    System.out.printf("[$bits$] k$bits$_0: %s\n", Long.toUnsignedString(k$bits$_0));
    System.out.printf("[$bits$] k$bits$_1: %s\n", Long.toUnsignedString(k$bits$_1));
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
