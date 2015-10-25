  /**
   * Convert {@code f} to floating point format. {@code f} is assumed to be an
   * unsigned fixed-point value with {@code b} bits of precision.
   *
   * @param f A value in the range {@code [0, (2 ^ $bits$) - 1]}
   *
   * @return A value in the range {@code [0, 1]}
   */

  public static float fromUnsignedNormalized$bits$(final int f)
  {
    final float fv = UnsignedFloat.fromUnsignedInt(f);
    return fv / NFPUnsignedFloatInt.TWO_P$bits$_M1F;
  }
