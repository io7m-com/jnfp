  @Test public void testBoundsWithoutZero$bits$()
  {
    final int k_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero$bits$(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero$bits$(1.0);
    final int k$bits$_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(-1.0, $bits$);
    final int k$bits$_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithoutZero(1.0, $bits$);

    final double f$bits$_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero$bits$(k$bits$_m1);
    final double f$bits$_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero$bits$(k$bits$_p1);
    final double f$bits$_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k$bits$_m1, $bits$);
    final double f$bits$_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithoutZero(k$bits$_p1, $bits$);

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
      NFPSignedDoubleInt.toSignedNormalizedWithZero$bits$(-1.0);
    final int k_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero$bits$(1.0);
    final int k_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero$bits$(0.0);
    final int k$bits$_m1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(-1.0, $bits$);
    final int k$bits$_p1 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(1.0, $bits$);
    final int k$bits$_0 =
      NFPSignedDoubleInt.toSignedNormalizedWithZero(0.0, $bits$);

    final double f$bits$_m1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero$bits$(k$bits$_m1);
    final double f$bits$_p1a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero$bits$(k$bits$_p1);
    final double f$bits$_0a =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero$bits$(k$bits$_0);
    final double f$bits$_m1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k$bits$_m1, $bits$);
    final double f$bits$_p1b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k$bits$_p1, $bits$);
    final double f$bits$_0b =
      NFPSignedDoubleInt.fromSignedNormalizedWithZero(k$bits$_0, $bits$);

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
