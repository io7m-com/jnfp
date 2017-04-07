  /**
   * Convert {@code x} to fixed-point format using the {@code without-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with $bits$ bits of
   * precision
   */

  public static long toSignedNormalizedWithoutZero$bits$(
    final float x)
  {
    final float r = (x * NFPSignedFloatLong.TWO_P$bits$_M1F) - 1.0f;
    return (long) (r / 2.0f);
  }

  /**
   * Convert {@code x} to fixed-point format using the {@code with-zero}
   * representation described in the documentation at the beginning of this
   * class.
   *
   * @param x A value in the range {@code [-1, 1]}
   *
   * @return A signed normalized fixed-point value with $bits$ bits of
   * precision
   */

  public static long toSignedNormalizedWithZero$bits$(
    final float x)
  {
    return (long) (x * NFPSignedFloatLong.TWO_P$bits_m1$_M1F);
  }
