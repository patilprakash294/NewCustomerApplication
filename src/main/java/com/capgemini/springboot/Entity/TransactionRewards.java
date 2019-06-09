package com.capgemini.springboot.Entity;

public class TransactionRewards {
	
	private String rewardMonth;
	private int rewardPoints;
	private int transactionAmount;
	
	public String getRewardMonth() {
		return rewardMonth;
	}
	public void setRewardMonth(String rewardMonth) {
		this.rewardMonth = rewardMonth;
	}
	public int getRewardPoints() {
		return rewardPoints;
	}
	public void setRewardPoints(int rewardPoints) {
		this.rewardPoints = rewardPoints;
	}
	public int getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(int transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	

}
