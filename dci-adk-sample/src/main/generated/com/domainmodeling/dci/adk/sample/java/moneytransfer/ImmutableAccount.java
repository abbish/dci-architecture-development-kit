package com.domainmodeling.dci.adk.sample.java.moneytransfer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link Account}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableAccount.builder()}.
 */
@Generated(from = "Account", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
final class ImmutableAccount implements Account {
  private final String name;
  private final BigDecimal balance;

  private ImmutableAccount(String name, BigDecimal balance) {
    this.name = name;
    this.balance = balance;
  }

  /**
   * @return The value of the {@code name} attribute
   */
  @Override
  public String name() {
    return name;
  }

  /**
   * @return The value of the {@code balance} attribute
   */
  @Override
  public BigDecimal balance() {
    return balance;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Account#name() name} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for name
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableAccount withName(String value) {
    String newValue = Objects.requireNonNull(value, "name");
    if (this.name.equals(newValue)) return this;
    return new ImmutableAccount(newValue, this.balance);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Account#balance() balance} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for balance
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableAccount withBalance(BigDecimal value) {
    BigDecimal newValue = Objects.requireNonNull(value, "balance");
    if (this.balance.equals(newValue)) return this;
    return new ImmutableAccount(this.name, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableAccount} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableAccount
        && equalTo((ImmutableAccount) another);
  }

  private boolean equalTo(ImmutableAccount another) {
    return name.equals(another.name)
        && balance.equals(another.balance);
  }

  /**
   * Computes a hash code from attributes: {@code name}, {@code balance}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + name.hashCode();
    h += (h << 5) + balance.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Account} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "Account{"
        + "name=" + name
        + ", balance=" + balance
        + "}";
  }

  /**
   * Creates an immutable copy of a {@link Account} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Account instance
   */
  public static ImmutableAccount copyOf(Account instance) {
    if (instance instanceof ImmutableAccount) {
      return (ImmutableAccount) instance;
    }
    return ImmutableAccount.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableAccount ImmutableAccount}.
   * <pre>
   * ImmutableAccount.builder()
   *    .name(String) // required {@link Account#name() name}
   *    .balance(java.math.BigDecimal) // required {@link Account#balance() balance}
   *    .build();
   * </pre>
   * @return A new ImmutableAccount builder
   */
  public static ImmutableAccount.Builder builder() {
    return new ImmutableAccount.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableAccount ImmutableAccount}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "Account", generator = "Immutables")
  public static final class Builder {
    private static final long INIT_BIT_NAME = 0x1L;
    private static final long INIT_BIT_BALANCE = 0x2L;
    private long initBits = 0x3L;

    private String name;
    private BigDecimal balance;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code Account} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(Account instance) {
      Objects.requireNonNull(instance, "instance");
      name(instance.name());
      balance(instance.balance());
      return this;
    }

    /**
     * Initializes the value for the {@link Account#name() name} attribute.
     * @param name The value for name 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder name(String name) {
      this.name = Objects.requireNonNull(name, "name");
      initBits &= ~INIT_BIT_NAME;
      return this;
    }

    /**
     * Initializes the value for the {@link Account#balance() balance} attribute.
     * @param balance The value for balance 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder balance(BigDecimal balance) {
      this.balance = Objects.requireNonNull(balance, "balance");
      initBits &= ~INIT_BIT_BALANCE;
      return this;
    }

    /**
     * Builds a new {@link ImmutableAccount ImmutableAccount}.
     * @return An immutable instance of Account
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableAccount build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableAccount(name, balance);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_NAME) != 0) attributes.add("name");
      if ((initBits & INIT_BIT_BALANCE) != 0) attributes.add("balance");
      return "Cannot build Account, some of required attributes are not set " + attributes;
    }
  }
}