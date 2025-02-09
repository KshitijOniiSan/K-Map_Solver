public class check2{
    String ans;
    check2(int kmap[][]){
        //int kmap[][]={{0,1},{1,0}};
        int isused[][]={{0,0},{0,0}};
        String[] result=new String[2];
        result[0]="0";
        int counter=0;

        //CHECK 4
        check4:for(int i=0;i<2;i++){
            for (int j=0;j<2;j++){
                if(kmap[i][j]==0)break check4;
            }
            if(i==1){
                ans="1";
                return;
            }
        }

        //CHECK 2 ROWWISE
        for(int i=0;i<2;i++){
            if(kmap[i][0]==1&&kmap[i][1]==1){
                if(i==0)result[counter++]="A'";
                else result[counter++]="A";
                isused[i][0]=1;
                isused[i][1]=1;
            }
        }

        //CHECK 2 COLUMNWISE
        for(int i=0;i<2;i++){
            if(kmap[0][i]==1&&kmap[1][i]==1){
                if(i==0)result[counter++]="B'";
                else result[counter++]="B";
                isused[0][i]=1;
                isused[1][i]=1;
            }
        }

        //CHECK SINGULAR REMAINS
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                if(isused[i][j]==0&&kmap[i][j]==1){
                    if(i==0)result[counter]="A'";
                    else result[counter]="A";
                    if(j==0)result[counter]=result[counter].concat("B'");
                    else result[counter]=result[counter].concat("B");
                    counter++;
                }
            }
        }
        /*System.out.print(result[0]);
        for(int i=1;i<counter;i++){
            System.out.print(" + "+result[i]);
        }*/
        ans = result[0];
        for(int i=1;i<counter;i++){
            ans=ans.concat(" + "+result[i]);
        }
    }
    String anscheck2(){
        return ans;
    }
}