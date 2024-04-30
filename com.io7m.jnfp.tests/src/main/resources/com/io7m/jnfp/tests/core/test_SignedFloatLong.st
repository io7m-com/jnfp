  @Test public void testBoundsWithoutZero$bits$()
  {
    final long k_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero$bits$(-1.0f);
    final long k_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero$bits$(1.0f);
    final long k$bits$_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(-1.0f, $bits$);
    final long k$bits$_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithoutZero(1.0f, $bits$);

    final float f$bits$_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero$bits$(k$bits$_m1);
    final float f$bits$_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero$bits$(k$bits$_p1);
    final float f$bits$_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k$bits$_m1, $bits$);
    final float f$bits$_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithoutZero(k$bits$_p1, $bits$);

    System.out.printf("[$bits$] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[$bits$] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[$bits$] k$bits$_m1: %s\n", Long.toString(k$bits$_m1));
    System.out.printf("[$bits$] k$bits$_p1: %s\n", Long.toString(k$bits$_p1));
    System.out.printf("[$bits$] f$bits$_m1a: %f\n", f$bits$_m1a);
    System.out.printf("[$bits$] f$bits$_p1a: %f\n", f$bits$_p1a);
    System.out.printf("[$bits$] f$bits$_m1b: %f\n", f$bits$_m1b);
    System.out.printf("[$bits$] f$bits$_p1b: %f\n", f$bits$_p1b);
  }

  @Test public void testBoundsWithZero$bits$()
  {
    final long k_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero$bits$(-1.0f);
    final long k_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero$bits$(1.0f);
    final long k_0 =
      NFPSignedFloatLong.toSignedNormalizedWithZero$bits$(0.0f);
    final long k$bits$_m1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(-1.0f, $bits$);
    final long k$bits$_p1 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(1.0f, $bits$);
    final long k$bits$_0 =
      NFPSignedFloatLong.toSignedNormalizedWithZero(0.0f, $bits$);

    final float f$bits$_m1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero$bits$(k$bits$_m1);
    final float f$bits$_p1a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero$bits$(k$bits$_p1);
    final float f$bits$_0a =
      NFPSignedFloatLong.fromSignedNormalizedWithZero$bits$(k$bits$_0);
    final float f$bits$_m1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k$bits$_m1, $bits$);
    final float f$bits$_p1b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k$bits$_p1, $bits$);
    final float f$bits$_0b =
      NFPSignedFloatLong.fromSignedNormalizedWithZero(k$bits$_0, $bits$);

    System.out.printf("[$bits$] k_m1: %s\n", Long.toString(k_m1));
    System.out.printf("[$bits$] k_p1: %s\n", Long.toString(k_p1));
    System.out.printf("[$bits$] k_0: %s\n", Long.toString(k_0));
    System.out.printf("[$bits$] k$bits$_m1: %s\n", Long.toString(k$bits$_m1));
    System.out.printf("[$bits$] k$bits$_p1: %s\n", Long.toString(k$bits$_p1));
    System.out.printf("[$bits$] k$bits$_0: %s\n", Long.toString(k$bits$_0));
    System.out.printf("[$bits$] f$bits$_m1a: %f\n", f$bits$_m1a);
    System.out.printf("[$bits$] f$bits$_p1a: %f\n", f$bits$_p1a);
    System.out.printf("[$bits$] f$bits$_0a: %f\n", f$bits$_0a);
    System.out.printf("[$bits$] f$bits$_m1b: %f\n", f$bits$_m1b);
    System.out.printf("[$bits$] f$bits$_p1b: %f\n", f$bits$_p1b);
    System.out.printf("[$bits$] f$bits$_0b: %f\n", f$bits$_0b);
  }
