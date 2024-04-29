public class GCD {
    int n1;
    int n2;
    int num;

    public GCD(int n1, int n2){
        this.n1 = n1;
        this.n2 = n2;
    }

   public int findGCDForLoop(int n1, int n2){
        int smallest = Math.min(n1, n2);

        for(int i = 1; i <= smallest; i++){
            if((n1 % i == 0) && (n2 % i == 0)){
                num = i;
            }
        }
        return num;
   }

   public int findGCDWhileLoop(int n1, int n2){
        while(n1 != n2){
            if(n1 > n2){
                n1 = n1 - n2;
            }else{
                n2 = n2 - n1;
            }
        }

        return n1;
   }

   public int findGCDRecursively(int n1, int n2){
        if(n2 == 0){
            return n1;
        }

        return findGCDRecursively(n2, n1 % n2);
   }


}
