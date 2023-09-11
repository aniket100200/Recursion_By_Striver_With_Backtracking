class Solution {
    public List<List<Integer>> permute(int[] nums) 
    {
        List<List<Integer>>ans=new ArrayList<>();
        nPr(0,nums,ans);
        return ans;
    }

    public void nPr(int index,int[]nums,List<List<Integer>>ans)
    {
        if(index==nums.length){
            List<Integer>list=new ArrayList<>();
            for(int i:nums)list.add(i);
            ans.add(list);
            return;
        }

        for(int i=index;i<nums.length;i++)
        {
            swap(index,i,nums);
            nPr(index+1,nums,ans);
            swap(index,i,nums);
        }
    }

    public void swap(int i,int j,int[]nums)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    
}