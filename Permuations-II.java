class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) 
    {
        Arrays.sort(nums);
        boolean[]visit=new boolean[nums.length];
        List<List<Integer>>ans=new ArrayList<>();
        fun(nums,visit,ans,new ArrayList<>());

        return ans;
    }

    public void fun(int[]nums,boolean[]visit,List<List<Integer>>ans,List<Integer>curr)
    {   
       if(curr.size()==nums.length) 
       {
        ans.add(new ArrayList<>(curr));
       return;
       }

        for(int i=0;i<nums.length;i++)
        {
            if(visit[i]==true)continue;
            if(i!=0 && visit[i-1] && nums[i]==nums[i-1])continue;
            visit[i]=true;
            curr.add(nums[i]);
            fun(nums,visit,ans,curr);
            visit[i]=false;
            curr.remove(curr.size()-1);
        }

    }
}