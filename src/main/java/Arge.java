/**
 * 1. 需要考虑到初始值的情况，p0>p时返回0年,
 * 2. 另外/100得到整数才符合题意。
 * Created by wutaotao
 * 2018/1/22 19:15
 */
class Arge {

    public static int nb_year(int p0, double percent, int aug, int p) {
        // your code
        int count = 0;
        while(p0 < p){
            p0 += p0 * percent / 100 + aug;
            count++;
        }
        return count;
//        double pTemp = p0;
//        int count = 1;
//        while(true){
//            pTemp = pTemp + pTemp * percent * 0.01 + aug;
//            if (pTemp > p) {
//                return count;
//            }else{
//                count++;
//            }
//        }
    }

    public static void main(String[] args) {
        //15
        System.out.println(nb_year(1500, 5, 100, 5000));
        //10
        System.out.println(nb_year(1500000, 2.5, 10000, 2000000));;
    }
}
