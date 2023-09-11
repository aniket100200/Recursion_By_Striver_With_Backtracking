class Solution {
    public void solveSudoku(char[][] board) 
    {
        //let's solve this suduko.. here we go..'
        solve(board);
           
    }


    public boolean solve(char[][]board)
    {
         for(int i=0;i<9;i++)
            {
                for(int j=0;j<9;j++)
                {
                        if(board[i][j]=='.')
                        {
                            //you can answer the question...> >  > 
                            for(char k='1'; k<='9';k++)
                            {
                                if(isValid(k,board,i,j))
                                {
                                    
                                    board[i][j]=k;

                                    if(solve(board))return true;

                                    board[i][j]='.';

                                }
                            }

                            return false;
                        }
                }
            }


            return true;
    }

    public boolean isValid(char ch,char[][]board,int row, int col){

        for(int i=0;i<9;i++)
        {
            //check in the row..
            if(board[row][i]==ch)return false;

            //check in the col..

            if(board[i][col]==ch)return false;


            //in the 3 X 3 Matrix,..

            if(board[3*(row/3)+i/3][3*(col/3)+i%3]==ch)return false;
        }

        return true;
    }
}