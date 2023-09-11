class Solution 
{
    public List<List<String>> solveNQueens(int n) 
    {
        List<List<String>>ans=new ArrayList<>();

        char[][]board=new char[n][n];


        //optimisation for isPossible function..
        boolean[]left=new boolean[n];
        boolean[]lowerDig=new boolean[2*n];
        boolean[]upperDig=new boolean[2*n];


        for(char[]ch:board)
        {
            for(int i=0;i<n;i++)ch[i]='.';
        }

        //you have this board..
        solve(0,board,ans,n,left,lowerDig,upperDig);

        return ans;

    }

    public void solve(int col,char[][]board, List<List<String>>ans,int n,boolean[]left,boolean[]lowerDig,boolean[]upperDig)
    {
            if(col==n)
            {
                //this is your base case..
                //back Tracking learning...
                //I've to copy whole board'..

                List<String>list=new ArrayList<>();
                for(char[]ch:board)
                {   
                    StringBuilder sb=new StringBuilder();
                    for(char c:ch)sb.append(c);
                    list.add(sb.toString());
                }
                ans.add(list);
                return;
            }

            //you'll try to place the queen in each row..'

            for(int i=0;i<n;i++)
            {
                //for left.. directly chek for the corresponding row..
                if(left[i] || lowerDig[i+col] || upperDig[n-1+col-i])continue;

                board[i][col]='Q';
                
                //mark all the  seats..
                left[i]=true;
                lowerDig[i+col]=true;
                upperDig[n-1+col-i]=true;
                solve(col+1,board,ans,n,left,lowerDig,upperDig);
                board[i][col]='.';
                left[i]=false;
                lowerDig[i+col]=false;
                upperDig[n-1+col-i]=false;
            }
    }


    
}