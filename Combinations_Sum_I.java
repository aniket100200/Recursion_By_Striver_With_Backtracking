class Solution
{

    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        List<List<Integer>>ans=new ArrayList<>();
        fun(0,target,candidates,new ArrayList<>(),ans);
        return ans;
    }

    private void fun(int i, int target, int[] candidates, List<Integer> curr, List<List<Integer>> ans)
    {
        //don't use loop brother
        if(i==candidates.length)
        {
            if(target==0)
            {
                ans.add(new ArrayList<>(curr));
            }

            return;
        }

        //let's pick..
        if( candidates[i]<=target)
        {
            curr.add(candidates[i]);
            fun(i,target-candidates[i],candidates,curr,ans);
            curr.remove(curr.size()-1);
        }
        fun(i+1,target,candidates,curr,ans);
    }


}
