package com.hashcash.sdk;

import com.google.common.base.Objects;
import com.hashcash.sdk.xdr.*;

import static com.google.common.base.Preconditions.checkNotNull;

public class RevokeSignerSponsorshipOperation extends Operation {
  private final String accountId;
  private final SignerKey signer;

  private RevokeSignerSponsorshipOperation(String accountId, SignerKey signer) {
    this.accountId = accountId;
    this.signer = signer;
  }

  public String getAccountId() {
    return accountId;
  }

  public SignerKey getSigner() {
    return signer;
  }

  @Override
  com.hashcash.sdk.xdr.Operation.OperationBody toOperationBody(AccountConverter accountConverter) {
    RevokeSponsorshipOp op = new RevokeSponsorshipOp();

    RevokeSponsorshipOp.RevokeSponsorshipOpSigner xdrSigner = new RevokeSponsorshipOp.RevokeSponsorshipOpSigner();
    xdrSigner.setAccountID(StrKey.encodeToXDRAccountId(accountId));
    xdrSigner.setSignerKey(signer);
    op.setSigner(xdrSigner);
    op.setDiscriminant(RevokeSponsorshipType.REVOKE_SPONSORSHIP_SIGNER);

    com.hashcash.sdk.xdr.Operation.OperationBody body = new com.hashcash.sdk.xdr.Operation.OperationBody();
    body.setDiscriminant(OperationType.REVOKE_SPONSORSHIP);
    body.setRevokeSponsorshipOp(op);

    return body;
  }

  public static class Builder {
    private final String accountId;
    private final SignerKey signer;

    private String mSourceAccount;

    /**
     * Construct a new RevokeSignerSponsorshipOperation builder from a RevokeSponsorship XDR.
     * @param op {@link RevokeSponsorshipOp}
     */
    Builder(RevokeSponsorshipOp op) {
      accountId = StrKey.encodeStellarAccountId(op.getSigner().getAccountID());
      signer = op.getSigner().getSignerKey();
    }

    /**
     * Creates a new RevokeSignerSponsorshipOperation builder.
     * @param accountId The id of the account whose signer will be revoked.
     * @param signer The signer whose sponsorship which will be revoked.
     */
    public Builder(String accountId, SignerKey signer) {
      this.accountId = accountId;
      this.signer = signer;
    }

    /**
     * Sets the source account for this operation.
     * @param sourceAccount The operation's source account.
     * @return Builder object so you can chain methods.
     */
    public RevokeSignerSponsorshipOperation.Builder setSourceAccount(String sourceAccount) {
      mSourceAccount = checkNotNull(sourceAccount, "sourceAccount cannot be null");
      return this;
    }

    /**
     * Builds an operation
     */
    public RevokeSignerSponsorshipOperation build() {
      RevokeSignerSponsorshipOperation operation = new RevokeSignerSponsorshipOperation(accountId, signer);
      if (mSourceAccount != null) {
        operation.setSourceAccount(mSourceAccount);
      }
      return operation;
    }
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.accountId, this.signer, this.getSourceAccount());
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof RevokeSignerSponsorshipOperation)) {
      return false;
    }

    RevokeSignerSponsorshipOperation other = (RevokeSignerSponsorshipOperation) object;
    return Objects.equal(this.accountId, other.accountId) &&
        Objects.equal(this.signer, other.signer) &&
        Objects.equal(this.getSourceAccount(), other.getSourceAccount());
  }
}
