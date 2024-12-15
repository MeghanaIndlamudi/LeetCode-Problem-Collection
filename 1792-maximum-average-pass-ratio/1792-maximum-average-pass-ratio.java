class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n=classes.length;
        PriorityQueue<pair> pq=new PriorityQueue<>((b,a)->{
            int c=a.ar[0]+1;
            int d=a.ar[1]+1;
            double cd=((double)c/(double)d-(double)a.ar[0]/(double)a.ar[1]);
            int e=b.ar[0]+1;
            int f=b.ar[1]+1;
            double ef=((double)e/(double)f-(double)b.ar[0]/(double)b.ar[1]);
            return Double.compare(cd,ef);
        });
        for(int i=0;i<n;i++){
            pq.offer(new pair((double)classes[i][0]/(double)classes[i][1],classes[i]));
        }
        while(extraStudents>0){
            pair p=pq.poll();
            int a=p.ar[0]+1;
            int b=p.ar[1]+1;
            pq.offer(new pair((double)a/(double)b,new int[]{a,b}));
            extraStudents--;
        }
        double sum=0;
        while(pq.isEmpty()==false){
            pair p=pq.poll();
            sum+=p.d;
        }
        return sum/n;
    }
}
class pair{
    double d;
    int ar[]=new int[2];
    pair(double d,int a[]){
        this.d=d;
        for(int i=0;i<a.length;i++){
            ar[i]=a[i];
        }
    }
}