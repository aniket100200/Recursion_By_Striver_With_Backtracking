class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        fun(0,nums,ans,new ArrayList<Integer>());

        return ans;
    }

    public void fun(int i,int[]nums,List<List<Integer>> ans,List<Integer>curr){
       
            ans.add(new ArrayList<>(curr));
           


        //done. declare previous..
        int prev=-11;
        for(int j=i;j<nums.length;j++){
            if(prev==-1 || prev!=nums[j]){
                curr.add(nums[j]);
                fun(j+1,nums,ans,curr);
                curr.remove(curr.size()-1);
                prev=nums[j];
            }
          
        }

     }
}