package com.capgemini.springboot.Dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.springboot.Entity.CustomerReward;
import com.capgemini.springboot.Entity.Transaction;
import com.capgemini.springboot.Entity.TransactionRewards;;

@Repository
public class CustomerRewardDao {
	@Autowired
	private static HashMap<Integer,CustomerReward> customerRewards;
	
	static {
		
		customerRewards = new HashMap<Integer,CustomerReward>(){
			
			{					
				
				put(1,new CustomerReward(getTransaction()));
				put(2,new CustomerReward(getTransaction()));
				put(3,new CustomerReward(getTransaction()));
				
				
			}
			
			
		};
		
	}
	
	public Collection<TransactionRewards> getAllRewards() {
		
		HashMap<Integer,CustomerReward> customerRewardList = customerRewards;
		List<TransactionRewards> transactionRewardsList = new ArrayList<TransactionRewards>();
		TransactionRewards transactionRewardsTotal = new TransactionRewards();
		int totalReward = 0;
		int totalAmount = 0;
		
		for(int i = 1; i <= 3;i++) {
			String monthReward = null;
			if(i==1) {
				monthReward = "MonthOneReward";
			}
			else if(i==2) {
				monthReward = "MonthTwoReward";
			}
			else {
				monthReward = "MonthThreeReward";
			}
			CustomerReward customerReward = customerRewardList.get(i);
			TransactionRewards transactionRewards = getRewardPoints(customerReward,monthReward);
			totalReward = totalReward + transactionRewards.getRewardPoints();
			totalAmount = totalAmount + transactionRewards.getTransactionAmount();
			transactionRewardsList.add(transactionRewards);			
		}
		
		transactionRewardsTotal.setRewardPoints(totalReward);
		transactionRewardsTotal.setRewardMonth("MonthTotalReward");
		transactionRewardsTotal.setTransactionAmount(totalAmount);
		transactionRewardsList.add(transactionRewardsTotal);
		
		return transactionRewardsList;
		
		
		
	}
	
	private static List<Transaction> getTransaction(){
		List<Transaction> transactionList = new ArrayList<Transaction>();
		Transaction transactionOneMonth = new Transaction();
		for(int i=0;i<=10;i++) {
		transactionOneMonth.setAmount((int)(Math.random()*100));		
		transactionList.add(transactionOneMonth);
		}
		
		return transactionList;
		
		
	}
	
	private TransactionRewards getRewardPoints(CustomerReward customerReward,String rewardMonthName) {
		
		int monthTransaction = 0;
		int rewardPoints = 0;
		int remainingAmount = 0;
		TransactionRewards transactionRewards = new TransactionRewards();
		
      for (Transaction transaction : customerReward.getTransactionsList()) {
			
			monthTransaction = monthTransaction + transaction.getAmount();
		}
      
      if(monthTransaction > 0) {
    	  
    	  if(monthTransaction > 50 && monthTransaction < 100) {
    		  rewardPoints = rewardPoints * 50;
    		  
    	  }
    	  else if(monthTransaction > 100) {
    		  rewardPoints = 1 * 50;
    		  remainingAmount = monthTransaction - 100;
    		  rewardPoints = rewardPoints + 2 * remainingAmount;    		  
    	  }
      }
      
      transactionRewards.setRewardMonth(rewardMonthName);
      transactionRewards.setRewardPoints(rewardPoints);
      transactionRewards.setTransactionAmount(monthTransaction);
      
      return transactionRewards;
		
	}

}
