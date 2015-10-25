  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with $bits$ bits of precision
   */

  public static int toUnsignedNormalized$bits$(final float x)
  {
    return UnsignedFloat.toUnsignedInt(x * NFPUnsignedFloatInt.TWO_P$bits$_M1F);
  }
