package com.leetcode.problem;

public class SubArraySumK {
	
	public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count=0;
        for (int i=0; i<n; i++) {
        	int sum = 0;
        		for(int j=i; j<n; j++) {
        			sum = sum + nums[j];
        			if(sum==k) {
        				count++;
        			}
        		}
        }
        
        return count;
    }
	
public static int findMaxLength(int[] nums) {
        
        int maxLength = 0;
        int n = nums.length;
        for(int i=0; i<n; i++) {
            int zeroCount = 0;
            int oneCount = 0;
            for (int j=i; j<n; j++) {
                if (nums[j]==0) {
                    zeroCount++;
                } else {
                    oneCount++;
                }
                if (zeroCount == oneCount) {
                    maxLength = Math.max(maxLength, j-i+1);
                }
            }
            
        }
        return maxLength;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {0,1};
		findMaxLength(a);

	}

}
