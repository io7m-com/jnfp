  /**
   * Convert {@code x} to fixed-point format.
   *
   * @param x A value in the range {@code [0, 1]}
   *
   * @return An unsigned normalized fixed-point value with $bits$ bits of precision
   */

  public static int toUnsignedNormalized$bits$(final double x)
  {
    return UnsignedDouble.toUnsignedInt(x * NFPUnsignedDoubleInt.TWO_P$bits$_M1D);
  }
