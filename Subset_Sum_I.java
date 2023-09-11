class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>list=new ArrayList<>();
        f(0,list,nums,new ArrayList<>());

        return list;
    }

    public void f(int i,List<List<Integer>>ans,int[]arr,List<Integer>curr){
        if(i==arr.length)
        {
            ans.add(new ArrayList<>(curr));
            return;
        }

        //first don't include.'

        f(i+1,ans,arr,curr);

        curr.add(arr[i]);

        f(i+1,ans,arr,curr);
        curr.remove(curr.size()-1);
    }
}