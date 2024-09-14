public class Desafio2 {
    public static double[][]M=new double[3][3];
    public static double[]d=new double[3];

    public static double maximo(double a, double b,double c){
        return Math.max(a, Math.max(b, c));
    }
    public static double abs(double a ,double b){
        return Math.abs(b-a);
    }
    public static void cambiar(double[][] x,double[] y){
        M[0][1]=-x[0][1]/x[0][0];M[0][2]=-x[0][2]/x[0][0];
        M[1][0]=-x[1][0]/x[1][1];M[1][2]=-x[1][2]/x[1][1];
        M[2][0]=-x[2][0]/x[2][2];M[2][1]=-x[2][1]/x[2][2];
        d[0]=y[0]/x[0][0];d[1]=y[1]/x[1][1];d[2]=y[2]/x[2][2];
    }
    public static void main(String[] args) {
        double [][]A={
            {0.52,0.2,0.25},
            {0.3,0.5,0.2},
            {0.18,0.3,0.55},
        };
        double []c={4800,5810,5690};
        cambiar(A,c);
        double alfa1,alfa2,alfa3;
        alfa1 =Math.abs(M[0][1])+Math.abs(M[0][2]);
        alfa2 =Math.abs(M[1][0])+Math.abs(M[1][2]);
        alfa3 =Math.abs(M[2][0])+Math.abs(M[2][1]);
        if (maximo(alfa1, alfa2, alfa3)<=1)
            System.out.println("el sistema converge");
        else
            System.out.println("el sistema no converge");

        double x1=0,x2=0,x3=0;
        double y1,y2,y3;
        double maxe=0;
        int iteracion=0;boolean val=true;
        while (val) {
            y1=M[0][1]*x2+M[0][2]*x3+d[0];
            y2=M[1][0]*x1+M[1][2]*x3+d[1];
            y3=M[2][0]*x1+M[2][1]*x2+d[2];
            
            maxe=maximo(abs(x1,y1),abs(x2, y2),abs(x3, y3));
            if (maxe>0.0005) {
                x1=y1;x2=y2;x3=y3;
                iteracion++;
            }
            else{
                val=false;
            }
        }
        System.out.println("x1: "+x1);
        System.out.println("x2: "+x2);
        System.out.println("x3: "+x3);
        System.out.println("error :"+maxe);
        System.out.println("iteracion: "+iteracion);
        }
}