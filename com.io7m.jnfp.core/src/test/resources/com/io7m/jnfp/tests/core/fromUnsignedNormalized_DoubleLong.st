  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ $bits$) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static double fromUnsignedNormalized$bits$(final long f)
  {
    final double fv = UnsignedDouble.fromUnsignedLong(f);
    return fv / NFPUnsignedDoubleLong.TWO_P$bits$_M1D;
  }
