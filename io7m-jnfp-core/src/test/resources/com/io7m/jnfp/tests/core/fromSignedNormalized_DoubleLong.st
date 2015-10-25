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

  public static double fromSignedNormalizedWithoutZero$bits$(final long f)
  {
    final double dx = (double) f;
    return ((2.0 * dx) + 1.0) / NFPSignedDoubleLong.TWO_P$bits$_M1D;
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

  public static double fromSignedNormalizedWithZero$bits$(
    final long f)
  {
    final double dx = (double) f;
    final double div = dx / NFPSignedDoubleLong.TWO_P$bits_m1$_M1D;
    return Math.max(-1.0, div);
  }
