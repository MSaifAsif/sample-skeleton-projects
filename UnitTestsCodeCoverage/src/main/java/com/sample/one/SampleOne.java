package com.sample.one;

public class SampleOne {
	
	public int getSum(int i, int j){
		if (i == 0) {
			return j;
		}
		else if (j == 0) {
			return i;
		}
		else {
			return i + j;
		}
	}
	
	static class InnerSample{
		private int i;

		public InnerSample(int i){
			this.i = i;
		}
		
		public int getSquare(){
			if (this.i < 0){
				return -1;
			} else {
				return i*i;
			}
		}
	}
}
