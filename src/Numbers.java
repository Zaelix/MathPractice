import java.util.ArrayList;

public class Numbers {

	static int[] nums = {1,2,3,4,5,6,7,8,9};
	static int[][] answers;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		iterate();
	}
	
	public static void iterate() {
		int[] combined;
		ArrayList<String> ops = new ArrayList<String>();
		ops.add("+");
		ops.add("+");
		ops.add("+");
		ops.add("+");
		ops.add("+");
		ops.add("+");
		ops.add("+");
		ops.add("+");
		int arg = 0;
		
		for (int i = 0; i < ops.size(); i++) {
			combined = makeCombined(nums, ops);
			calculate(combined, ops);
		}
	}
	
	public static int addPair(int a, int b) {
		return a+b;
	}
	
	public static int subtractPair(int a, int b) {
		return a-b;
	}
	
	public static int combinePair(int a, int b) {
		return (a*10)+b;
	}
	
	public static int[] makeCombined(int[] nums, ArrayList<String> ops) {
		int[] combined = new int[9];
		combined[0] = nums[0];
		ArrayList<String> opsL = new ArrayList<String>();
		for (int i = 0; i < nums.length; i++) {
			if(ops.get(i).equals("c")) {
				combined[i] = combinePair(combined[i], nums[i+1]);
				
			}
			else {
				combined[i] = nums[i];
			}
		}
		return combined;
	}
	
	public static boolean calculate(int[] combined, ArrayList<String> ops) {
		int val = combined[0];
		
		for(int i = 1; i < combined.length; i++) {
			if(ops.get(i).equals("+")) {
				val += combined[i];
			}
			else if(ops.get(i).equals("-")) {
				val -= combined[i];
			}
		}
		
		return false;
	}
	
	public static String makeAnswerString(int[] nums, ArrayList<String> ops) {
		String ans = "";
		for(int i = 0; i < nums.length-1; i++) {
			ans = ans + nums[i] + ops.get(i);
		}
		ans = ans + nums[nums.length-1];
		return ans;
	}
}
