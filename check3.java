class check3 {
    String ans;
    check3(int kmap[][]){
        //int kmap[][]={{1,1,1,1},{0,1,0,1}};
        int isused[][]={{0,0,0,0},{0,0,0,0}};
        String[] result=new String[4];
        result[0]="0";
        int counter=0;

        //CHECK 8
        check8:for(int i=0;i<2;i++){
            for (int j=0;j<4;j++){
                if(kmap[i][j]==0)break check8;
            }
            if(i==1){
                ans="1";
                return;
            }
        }

        //CHECK 4 ki ROWS
        for(int i=0;i<2;i++){
            int broken=0;
            for(int j=0;j<4;j++){
                if(kmap[i][j]==0)broken=1;
            }
            if(broken==0){
                for(int j=0;j<4;j++){
                    isused[i][j]=1;
                }
                if(i==0)result[counter++]="A'";
                else result[counter++]="A";
            }
        }

        //CHECK BOXES
        for(int j=0;j<4;j++){
            if(kmap[0][j]==1&&kmap[0][(j+1)%4]==1&&kmap[1][j]==1&&kmap[1][(j+1)%4]==1){
                isused[0][j]=isused[0][(j+1)%4]=isused[1][j]=isused[1][(j+1)%4]=1;
                if(j==0)result[counter++]="B'";
                else if(j==1)result[counter++]="C";
                else if(j==2)result[counter++]="B";
                else result[counter++]="C'";
            }
        }

        //CHECK 2 ROWWISE

        for(int i=0;i<2;i++){    
            for(int j=0;j<4;j++){
                if(kmap[i][j]==1&&kmap[i][(j+1)%4]==1&&(isused[i][j]!=1||isused[i][(j+1)%4]!=1)){
                    if(i==0)result[counter]="A'";
                    else result[counter]="A";

                    if(j==0)result[counter]=result[counter].concat("B'");
                    else if(j==1)result[counter]=result[counter].concat("C");
                    else if(j==2)result[counter]=result[counter].concat("B");
                    else if(j==3)result[counter]=result[counter].concat("C'");

                    counter++;
                    isused[i][j]=1;
                    isused[i][(j+1)%4]=1;
                }
            }
        }

        //CHECK 2 COLUMNWISE
        for(int j=0;j<4;j++){
                if(kmap[0][j]==1&&kmap[1][j]==1&&(isused[0][j]!=1||isused[1][j]!=1)){
                    if(j==0)result[counter]="B'C'";
                    else if(j==1)result[counter]="B'C";
                    else if(j==2)result[counter]="BC";
                    else if(j==3)result[counter]="BC'";
                    counter++;
                    isused[0][j]=1;
                    isused[1][j]=1;
                }
        }

        //CHECK SINGULAR REMAINS
        for(int i=0;i<2;i++){
            for(int j=0;j<4;j++){                
                if(isused[i][j]==0&&kmap[i][j]==1){
                    if(i==0)result[counter]="A'";
                    else result[counter]="A";
                    if(j==0)result[counter]=result[counter].concat("B'C'");
                    else if(j==1)result[counter]=result[counter].concat("B'C");
                    else if(j==2)result[counter]=result[counter].concat("BC");
                    else if(j==3)result[counter]=result[counter].concat("BC'");
                    counter++;
                }
            }
        }
        
        //PRINT
        ans=result[0];
        for(int i=1;i<counter;i++){
            ans=ans.concat(" + "+result[i]);
        }
    }
    String anscheck3(){
        return ans;
    }
}
