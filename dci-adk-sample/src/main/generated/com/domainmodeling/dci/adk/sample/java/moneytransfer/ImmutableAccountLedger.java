package com.domainmodeling.dci.adk.sample.java.moneytransfer;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link AccountLedger}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableAccountLedger.builder()}.
 */
@Generated(from = "AccountLedger", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
final class ImmutableAccountLedger
    implements AccountLedger {
  private final Account account;
  private final BigDecimal originalBalance;
  private final BigDecimal income;
  private final BigDecimal outcome;
  private final Instant creationTime;

  private ImmutableAccountLedger(ImmutableAccountLedger.Builder builder) {
    this.account = builder.account;
    this.originalBalance = builder.originalBalance;
    if (builder.income != null) {
      initShim.income(builder.income);
    }
    if (builder.outcome != null) {
      initShim.outcome(builder.outcome);
    }
    if (builder.creationTime != null) {
      initShim.creationTime(builder.creationTime);
    }
    this.income = initShim.income();
    this.outcome = initShim.outcome();
    this.creationTime = initShim.creationTime();
    this.initShim = null;
  }

  private ImmutableAccountLedger(
      Account account,
      BigDecimal originalBalance,
      BigDecimal income,
      BigDecimal outcome,
      Instant creationTime) {
    this.account = account;
    this.originalBalance = originalBalance;
    this.income = income;
    this.outcome = outcome;
    this.creationTime = creationTime;
    this.initShim = null;
  }

  private static final byte STAGE_INITIALIZING = -1;
  private static final byte STAGE_UNINITIALIZED = 0;
  private static final byte STAGE_INITIALIZED = 1;
  private transient volatile InitShim initShim = new InitShim();

  @Generated(from = "AccountLedger", generator = "Immutables")
  private final class InitShim {
    private byte incomeBuildStage = STAGE_UNINITIALIZED;
    private BigDecimal income;

    BigDecimal income() {
      if (incomeBuildStage == STAGE_INITIALIZING) throw new IllegalStateException(formatInitCycleMessage());
      if (incomeBuildStage == STAGE_UNINITIALIZED) {
        incomeBuildStage = STAGE_INITIALIZING;
        this.income = Objects.requireNonNull(incomeInitialize(), "income");
        incomeBuildStage = STAGE_INITIALIZED;
      }
      return this.income;
    }

    void income(BigDecimal income) {
      this.income = income;
      incomeBuildStage = STAGE_INITIALIZED;
    }

    private byte outcomeBuildStage = STAGE_UNINITIALIZED;
    private BigDecimal outcome;

    BigDecimal outcome() {
      if (outcomeBuildStage == STAGE_INITIALIZING) throw new IllegalStateException(formatInitCycleMessage());
      if (outcomeBuildStage == STAGE_UNINITIALIZED) {
        outcomeBuildStage = STAGE_INITIALIZING;
        this.outcome = Objects.requireNonNull(outcomeInitialize(), "outcome");
        outcomeBuildStage = STAGE_INITIALIZED;
      }
      return this.outcome;
    }

    void outcome(BigDecimal outcome) {
      this.outcome = outcome;
      outcomeBuildStage = STAGE_INITIALIZED;
    }

    private byte creationTimeBuildStage = STAGE_UNINITIALIZED;
    private Instant creationTime;

    Instant creationTime() {
      if (creationTimeBuildStage == STAGE_INITIALIZING) throw new IllegalStateException(formatInitCycleMessage());
      if (creationTimeBuildStage == STAGE_UNINITIALIZED) {
        creationTimeBuildStage = STAGE_INITIALIZING;
        this.creationTime = Objects.requireNonNull(creationTimeInitialize(), "creationTime");
        creationTimeBuildStage = STAGE_INITIALIZED;
      }
      return this.creationTime;
    }

    void creationTime(Instant creationTime) {
      this.creationTime = creationTime;
      creationTimeBuildStage = STAGE_INITIALIZED;
    }

    private String formatInitCycleMessage() {
      List<String> attributes = new ArrayList<>();
      if (incomeBuildStage == STAGE_INITIALIZING) attributes.add("income");
      if (outcomeBuildStage == STAGE_INITIALIZING) attributes.add("outcome");
      if (creationTimeBuildStage == STAGE_INITIALIZING) attributes.add("creationTime");
      return "Cannot build AccountLedger, attribute initializers form cycle " + attributes;
    }
  }

  private BigDecimal incomeInitialize() {
    return AccountLedger.super.income();
  }

  private BigDecimal outcomeInitialize() {
    return AccountLedger.super.outcome();
  }

  private Instant creationTimeInitialize() {
    return AccountLedger.super.creationTime();
  }

  /**
   * @return The value of the {@code account} attribute
   */
  @Override
  public Account account() {
    return account;
  }

  /**
   * @return The value of the {@code originalBalance} attribute
   */
  @Override
  public BigDecimal originalBalance() {
    return originalBalance;
  }

  /**
   * @return The value of the {@code income} attribute
   */
  @Override
  public BigDecimal income() {
    InitShim shim = this.initShim;
    return shim != null
        ? shim.income()
        : this.income;
  }

  /**
   * @return The value of the {@code outcome} attribute
   */
  @Override
  public BigDecimal outcome() {
    InitShim shim = this.initShim;
    return shim != null
        ? shim.outcome()
        : this.outcome;
  }

  /**
   * @return The value of the {@code creationTime} attribute
   */
  @Override
  public Instant creationTime() {
    InitShim shim = this.initShim;
    return shim != null
        ? shim.creationTime()
        : this.creationTime;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AccountLedger#account() account} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for account
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableAccountLedger withAccount(Account value) {
    if (this.account == value) return this;
    Account newValue = Objects.requireNonNull(value, "account");
    return new ImmutableAccountLedger(newValue, this.originalBalance, this.income, this.outcome, this.creationTime);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AccountLedger#originalBalance() originalBalance} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for originalBalance
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableAccountLedger withOriginalBalance(BigDecimal value) {
    BigDecimal newValue = Objects.requireNonNull(value, "originalBalance");
    if (this.originalBalance.equals(newValue)) return this;
    return new ImmutableAccountLedger(this.account, newValue, this.income, this.outcome, this.creationTime);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AccountLedger#income() income} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for income
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableAccountLedger withIncome(BigDecimal value) {
    BigDecimal newValue = Objects.requireNonNull(value, "income");
    if (this.income.equals(newValue)) return this;
    return new ImmutableAccountLedger(this.account, this.originalBalance, newValue, this.outcome, this.creationTime);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AccountLedger#outcome() outcome} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for outcome
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableAccountLedger withOutcome(BigDecimal value) {
    BigDecimal newValue = Objects.requireNonNull(value, "outcome");
    if (this.outcome.equals(newValue)) return this;
    return new ImmutableAccountLedger(this.account, this.originalBalance, this.income, newValue, this.creationTime);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AccountLedger#creationTime() creationTime} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for creationTime
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableAccountLedger withCreationTime(Instant value) {
    if (this.creationTime == value) return this;
    Instant newValue = Objects.requireNonNull(value, "creationTime");
    return new ImmutableAccountLedger(this.account, this.originalBalance, this.income, this.outcome, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableAccountLedger} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableAccountLedger
        && equalTo((ImmutableAccountLedger) another);
  }

  private boolean equalTo(ImmutableAccountLedger another) {
    return account.equals(another.account)
        && originalBalance.equals(another.originalBalance)
        && income.equals(another.income)
        && outcome.equals(another.outcome)
        && creationTime.equals(another.creationTime);
  }

  /**
   * Computes a hash code from attributes: {@code account}, {@code originalBalance}, {@code income}, {@code outcome}, {@code creationTime}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + account.hashCode();
    h += (h << 5) + originalBalance.hashCode();
    h += (h << 5) + income.hashCode();
    h += (h << 5) + outcome.hashCode();
    h += (h << 5) + creationTime.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code AccountLedger} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "AccountLedger{"
        + "account=" + account
        + ", originalBalance=" + originalBalance
        + ", income=" + income
        + ", outcome=" + outcome
        + ", creationTime=" + creationTime
        + "}";
  }

  /**
   * Creates an immutable copy of a {@link AccountLedger} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable AccountLedger instance
   */
  public static ImmutableAccountLedger copyOf(AccountLedger instance) {
    if (instance instanceof ImmutableAccountLedger) {
      return (ImmutableAccountLedger) instance;
    }
    return ImmutableAccountLedger.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableAccountLedger ImmutableAccountLedger}.
   * <pre>
   * ImmutableAccountLedger.builder()
   *    .account(com.domainmodeling.dci.adk.sample.java.moneytransfer.Account) // required {@link AccountLedger#account() account}
   *    .originalBalance(java.math.BigDecimal) // required {@link AccountLedger#originalBalance() originalBalance}
   *    .income(java.math.BigDecimal) // optional {@link AccountLedger#income() income}
   *    .outcome(java.math.BigDecimal) // optional {@link AccountLedger#outcome() outcome}
   *    .creationTime(java.time.Instant) // optional {@link AccountLedger#creationTime() creationTime}
   *    .build();
   * </pre>
   * @return A new ImmutableAccountLedger builder
   */
  public static ImmutableAccountLedger.Builder builder() {
    return new ImmutableAccountLedger.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableAccountLedger ImmutableAccountLedger}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "AccountLedger", generator = "Immutables")
  public static final class Builder {
    private static final long INIT_BIT_ACCOUNT = 0x1L;
    private static final long INIT_BIT_ORIGINAL_BALANCE = 0x2L;
    private long initBits = 0x3L;

    private Account account;
    private BigDecimal originalBalance;
    private BigDecimal income;
    private BigDecimal outcome;
    private Instant creationTime;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code AccountLedger} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(AccountLedger instance) {
      Objects.requireNonNull(instance, "instance");
      account(instance.account());
      originalBalance(instance.originalBalance());
      income(instance.income());
      outcome(instance.outcome());
      creationTime(instance.creationTime());
      return this;
    }

    /**
     * Initializes the value for the {@link AccountLedger#account() account} attribute.
     * @param account The value for account 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder account(Account account) {
      this.account = Objects.requireNonNull(account, "account");
      initBits &= ~INIT_BIT_ACCOUNT;
      return this;
    }

    /**
     * Initializes the value for the {@link AccountLedger#originalBalance() originalBalance} attribute.
     * @param originalBalance The value for originalBalance 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder originalBalance(BigDecimal originalBalance) {
      this.originalBalance = Objects.requireNonNull(originalBalance, "originalBalance");
      initBits &= ~INIT_BIT_ORIGINAL_BALANCE;
      return this;
    }

    /**
     * Initializes the value for the {@link AccountLedger#income() income} attribute.
     * <p><em>If not set, this attribute will have a default value as returned by the initializer of {@link AccountLedger#income() income}.</em>
     * @param income The value for income 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder income(BigDecimal income) {
      this.income = Objects.requireNonNull(income, "income");
      return this;
    }

    /**
     * Initializes the value for the {@link AccountLedger#outcome() outcome} attribute.
     * <p><em>If not set, this attribute will have a default value as returned by the initializer of {@link AccountLedger#outcome() outcome}.</em>
     * @param outcome The value for outcome 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder outcome(BigDecimal outcome) {
      this.outcome = Objects.requireNonNull(outcome, "outcome");
      return this;
    }

    /**
     * Initializes the value for the {@link AccountLedger#creationTime() creationTime} attribute.
     * <p><em>If not set, this attribute will have a default value as returned by the initializer of {@link AccountLedger#creationTime() creationTime}.</em>
     * @param creationTime The value for creationTime 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder creationTime(Instant creationTime) {
      this.creationTime = Objects.requireNonNull(creationTime, "creationTime");
      return this;
    }

    /**
     * Builds a new {@link ImmutableAccountLedger ImmutableAccountLedger}.
     * @return An immutable instance of AccountLedger
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableAccountLedger build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableAccountLedger(this);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_ACCOUNT) != 0) attributes.add("account");
      if ((initBits & INIT_BIT_ORIGINAL_BALANCE) != 0) attributes.add("originalBalance");
      return "Cannot build AccountLedger, some of required attributes are not set " + attributes;
    }
  }
}
