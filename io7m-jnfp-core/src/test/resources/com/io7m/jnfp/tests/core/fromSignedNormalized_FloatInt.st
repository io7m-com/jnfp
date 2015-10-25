  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with $bits$ bits of precision, using the {@code
   * without-zero} representation described in the documentation at the
   * beginning of this class.
   *
   * @param f A value in the range {@code [-(2 ^ ($bits$ - 1)), (2 ^ ($bits$ - 1)) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithoutZero$bits$(final int f)
  {
    final float dx = (float) f;
    return ((2.0f * dx) + 1.0f) / NFPSignedFloatInt.TWO_P$bits$_M1F;
  }

  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * signed fixed-point value with $bits$ bits of precision, using the {@code
   * with-zero} representation described in the documentation at the beginning
   * of this class.
   *
   * @param f A value in the range {@code [-(2 ^ $bits_m1$) + 1, (2 ^ $bits_m1$) - 1]}
   *
   * @return A floating point value in the range {@code[-1, 1]}
   */

  public static float fromSignedNormalizedWithZero$bits$(
    final int f)
  {
    final float dx = (float) f;
    final float div = dx / NFPSignedFloatInt.TWO_P$bits_m1$_M1F;
    return Math.max(-1.0f, div);
  }
