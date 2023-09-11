class Solution
 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) 
    {
        List<List<Integer>>ans=new ArrayList<>();
        Arrays.sort(candidates);
        fun(0,target,candidates,ans,new ArrayList<>());
        return ans;
    }

    public void fun(int i,int tar,int[]can,List<List<Integer>>ans,List<Integer>curr)
    {
        if(tar<=0 || i==can.length)
        {
            if(tar==0)
            ans.add(new ArrayList<>(curr));
            return;
        }


           

            //for duplicates handling.. as you are selecting a element..
            int pre=-1;

            for(int j=i;j<can.length;j++)
            {
                if(can[j]>tar)break;
                if(pre==-1 || pre!=can[j]){
                    curr.add(can[j]);
                    fun(j+1,tar-can[j],can,ans,curr);
                    curr.remove(curr.size()-1);
                    //step..
                    pre=can[j];
                }
            }

            return;
    }
}