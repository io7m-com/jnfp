  @Test public void testBoundsWithoutZero$bits$()
  {
    final int k_m1 =
      NFPSignedFloatInt.toSignedNormalizedWithoutZero$bits$(-1.0f);
    final int k_p1 =
      NFPSignedFloatInt.toSignedNormalizedWithoutZero$bits$(1.0f);
    final int k$bits$_m1 =
      NFPSignedFloatInt.toSignedNormalizedWithoutZero(-1.0f, $bits$);
    final int k$bits$_p1 =
      NFPSignedFloatInt.toSignedNormalizedWithoutZero(1.0f, $bits$);

    final float f$bits$_m1a =
      NFPSignedFloatInt.fromSignedNormalizedWithoutZero$bits$(k$bits$_m1);
    final float f$bits$_p1a =
      NFPSignedFloatInt.fromSignedNormalizedWithoutZero$bits$(k$bits$_p1);
    final float f$bits$_m1b =
      NFPSignedFloatInt.fromSignedNormalizedWithoutZero(k$bits$_m1, $bits$);
    final float f$bits$_p1b =
      NFPSignedFloatInt.fromSignedNormalizedWithoutZero(k$bits$_p1, $bits$);

    System.out.printf("[$bits$] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[$bits$] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[$bits$] k$bits$_m1: %s\n", Integer.toString(k$bits$_m1));
    System.out.printf("[$bits$] k$bits$_p1: %s\n", Integer.toString(k$bits$_p1));
    System.out.printf("[$bits$] f$bits$_m1a: %f\n", f$bits$_m1a);
    System.out.printf("[$bits$] f$bits$_p1a: %f\n", f$bits$_p1a);
    System.out.printf("[$bits$] f$bits$_m1b: %f\n", f$bits$_m1b);
    System.out.printf("[$bits$] f$bits$_p1b: %f\n", f$bits$_p1b);
  }

  @Test public void testBoundsWithZero$bits$()
  {
    final int k_m1 =
      NFPSignedFloatInt.toSignedNormalizedWithZero$bits$(-1.0f);
    final int k_p1 =
      NFPSignedFloatInt.toSignedNormalizedWithZero$bits$(1.0f);
    final int k_0 =
      NFPSignedFloatInt.toSignedNormalizedWithZero$bits$(0.0f);
    final int k$bits$_m1 =
      NFPSignedFloatInt.toSignedNormalizedWithZero(-1.0f, $bits$);
    final int k$bits$_p1 =
      NFPSignedFloatInt.toSignedNormalizedWithZero(1.0f, $bits$);
    final int k$bits$_0 =
      NFPSignedFloatInt.toSignedNormalizedWithZero(0.0f, $bits$);

    final float f$bits$_m1a =
      NFPSignedFloatInt.fromSignedNormalizedWithZero$bits$(k$bits$_m1);
    final float f$bits$_p1a =
      NFPSignedFloatInt.fromSignedNormalizedWithZero$bits$(k$bits$_p1);
    final float f$bits$_0a =
      NFPSignedFloatInt.fromSignedNormalizedWithZero$bits$(k$bits$_0);
    final float f$bits$_m1b =
      NFPSignedFloatInt.fromSignedNormalizedWithZero(k$bits$_m1, $bits$);
    final float f$bits$_p1b =
      NFPSignedFloatInt.fromSignedNormalizedWithZero(k$bits$_p1, $bits$);
    final float f$bits$_0b =
      NFPSignedFloatInt.fromSignedNormalizedWithZero(k$bits$_0, $bits$);

    System.out.printf("[$bits$] k_m1: %s\n", Integer.toString(k_m1));
    System.out.printf("[$bits$] k_p1: %s\n", Integer.toString(k_p1));
    System.out.printf("[$bits$] k_0: %s\n", Integer.toString(k_0));
    System.out.printf("[$bits$] k$bits$_m1: %s\n", Integer.toString(k$bits$_m1));
    System.out.printf("[$bits$] k$bits$_p1: %s\n", Integer.toString(k$bits$_p1));
    System.out.printf("[$bits$] k$bits$_0: %s\n", Integer.toString(k$bits$_0));
    System.out.printf("[$bits$] f$bits$_m1a: %f\n", f$bits$_m1a);
    System.out.printf("[$bits$] f$bits$_p1a: %f\n", f$bits$_p1a);
    System.out.printf("[$bits$] f$bits$_0a: %f\n", f$bits$_0a);
    System.out.printf("[$bits$] f$bits$_m1b: %f\n", f$bits$_m1b);
    System.out.printf("[$bits$] f$bits$_p1b: %f\n", f$bits$_p1b);
    System.out.printf("[$bits$] f$bits$_0b: %f\n", f$bits$_0b);
  }
