class check4{
    String ans;
    check4(int kmap[][]){
        //int kmap[][]={{0,1,0,1},{1,0,1,0},{0,1,0,1},{1,0,1,0}};
        int isused[][]={{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
        String[] result=new String[8];
        result[0]="0";
        int counter=0;

        //CHECK 16
        check16:for(int i=0;i<4;i++){
            for (int j=0;j<4;j++){
                if(kmap[i][j]==0)break check16;
            }
            if(i==3){
                ans="1";
                return;
            }
        }
        
        //CHECK 8 ROWS
        for(int i=0;i<4;i++){
            int broken=0;
            for(int j =0;j<4;j++){
                if(kmap[i][j]==0||kmap[((i+1)%4)][j]==0){
                    broken=1;
                }
            }
            if(broken==0){
                for(int j =0;j<4;j++){
                    isused[i][j]=isused[(i+1)%4][j]=1;
                }
                result[counter++]=i==0?"A'":i==1?"B":i==2?"A":"B'";
            }
        }

        //CHECK 8 COLS
        for(int j=0;j<4;j++){
            int broken=0;
            for(int i =0;i<4;i++){
                if(kmap[i][j]==0||kmap[i][(j+1)%4]==0){
                    broken=1;
                }
            }
            if(broken==0){
                for(int i =0;i<4;i++){
                    isused[i][j]=isused[i][(j+1)%4]=1;
                }
                result[counter++]=j==0?"C'":j==1?"D":j==2?"C":"D'";
            }
        }

        //CHECK 4 BOXES
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(kmap[i][j]==1&&kmap[i][(j+1)%4]==1&&kmap[(i+1)%4][j]==1&&kmap[(i+1)%4][(j+1)%4]==1){
                    if(isused[i][j]==0||isused[i][(j+1)%4]==0||isused[(i+1)%4][j]==0||isused[(i+1)%4][(j+1)%4]==0){
                        result[counter]=i==0?"A'":i==1?"B":i==2?"A":"B'";
                        result[counter]=result[counter++].concat(j==0?"C'":j==1?"D":j==2?"C":"D'");
                        isused[i][j]=1;isused[i][(j+1)%4]=1;isused[(i+1)%4][j]=1;isused[(i+1)%4][(j+1)%4]=1;
                    }
                }
            }
        }

        //CHECK 4 ROWS
        for(int i=0;i<4;i++){
            int broken=0;
            for(int j=0;j<4;j++){
                if(kmap[i][j]==0){
                    broken=1;
                }
            }
            if(broken==0){
                int use=0;
                for(int j=0;j<4;j++){
                    if(isused[i][j]==0){
                        isused[i][j]=1;
                        use=1;
                    }
                }
                if(use==1){
                    result[counter++]=i==0?"A'B'":i==1?"A'B":i==2?"AB":"AB'";
                }
            }
        }

        //CHECK 4 COLS
        for(int i=0;i<4;i++){
            int broken=0;
            for(int j=0;j<4;j++){
                if(kmap[j][i]==0){
                    broken=1;
                }
            }
            if(broken==0){
                int use=0;
                for(int j=0;j<4;j++){
                    if(isused[j][i]==0){
                        isused[j][i]=1;
                        use=1;
                    }
                }
                if(use==1){
                    result[counter++]=i==0?"C'D'":i==1?"C'D":i==2?"CD":"CD'";
                }
            }
        }

        //CHECK 2 ROWS
        for(int i=0;i<4;i++){    
            for(int j=0;j<4;j++){
                if(kmap[i][j]==1&&kmap[i][(j+1)%4]==1&&(isused[i][j]!=1||isused[i][(j+1)%4]!=1)){
                    result[counter]=i==0?"A'B'":i==1?"A'B":i==2?"AB":"AB'";
                    result[counter]=result[counter].concat(j==0?"C'":j==1?"D":j==2?"C":"D'");
                    counter++;
                    isused[i][j]=1;
                    isused[i][(j+1)%4]=1;
                }
            }
        }

        //CHECK 2 COLS
        for(int j=0;j<4;j++){    
            for(int i=0;i<4;i++){
                if(kmap[i][j]==1&&kmap[(i+1)%4][j]==1&&(isused[i][j]!=1||isused[(i+1)%4][j]!=1)){
                    result[counter]=i==0?"A'":i==1?"B":i==2?"A":"B'";
                    result[counter]=result[counter].concat(j==0?"C'D'":j==1?"C'D":j==2?"CD":"CD'");
                    counter++;
                    isused[i][j]=1;
                    isused[(i+1)%4][j]=1;
                }
            }
        }

        //CHECK SINGULAR REMAINS
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){                
                if(isused[i][j]==0&&kmap[i][j]==1){
                    result[counter]=i==0?"A'B'":i==1?"A'B":i==2?"AB":"AB'";
                    result[counter]=result[counter].concat(j==0?"C'D'":j==1?"C'D":j==2?"CD":"CD'");
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
    String anscheck4(){
        return ans;
    }
}